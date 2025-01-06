package com.ziggeo.androidsdk.net;

import static com.ziggeo.androidsdk.net.exceptions.ResponseException.NO_INTERNET_CONNECTION;

import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.ziggeo.androidsdk.Ziggeo;
import com.ziggeo.androidsdk.log.ZLog;
import com.ziggeo.androidsdk.net.exceptions.ResponseException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


class RequestInterceptor implements Interceptor {

    private static final int UNAUTHORIZED = 403;

    private Ziggeo ziggeo;
    private String packageName;

    public RequestInterceptor(@NonNull Context context) {
        this.packageName = context.getPackageName();
        this.ziggeo = Ziggeo.getInstance(context);
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Response response;
        try {
            if (requireAuth() && !originalRequest.url().toString().contains("amazon")) {
                response = chain.proceed(addAuthentication(originalRequest));
                // retrying in case of session has expired for several reasons
                if (response.code() == UNAUTHORIZED) {
                    ZLog.d("Got 403. Retrying with a new session.");
                    clearSession();
                    response = chain.proceed(addAuthentication(originalRequest));
                }
            } else {
                //todo add UNAUTHORIZED?
                response = chain.proceed(originalRequest);
            }
        } catch (Exception e) {
            if (e instanceof ConnectException || e instanceof SocketException ||
                    e instanceof UnknownHostException) {
                ZLog.e(e, "Error occupied, no internet connection.");
                throw new ResponseException(NO_INTERNET_CONNECTION, e.getMessage());
            } else {
                ZLog.e(e, "Error occupied, trying to resend request.");
                try {
                    response = chain.proceed(addAuthentication(originalRequest));
                } catch (Exception ex) {
                    ZLog.e(ex.toString());
                    throw new IOException(ex.toString());
                }
            }
        }

        return response;
    }

    private Request addAuthentication(@NonNull Request request) {
        HttpUrl.Builder urlBuilder = request.url().newBuilder();

        // do not append tokens to session request
        if (shouldAppendAuthTokens(urlBuilder.toString())) {
            ZUrlHelper.appendAuthTokens(urlBuilder, ziggeo);
        }

        // package is not related to auth, it's just for analytics
        if (!TextUtils.isEmpty(packageName)) {
            ZUrlHelper.appendPackageName(urlBuilder, packageName);
        }
        return request.newBuilder().url(urlBuilder.build()).build();
    }

    private boolean shouldAppendAuthTokens(@NonNull String url) {
        return !url.contains(ZUrlHelper.SERVICE_SESSION) && !url.contains(ZUrlHelper.URL_PATH_ANALYTICS);
    }

    private boolean requireAuth() {
        return ziggeo.getServerAuthToken() != null || ziggeo.getClientAuthToken() != null;
    }

    /**
     * Session can expire due to several cases
     * - app token changed
     * - lifetime (1 week long)
     * - IP changed
     * To avoid checking if IP address changed in every request
     * we're just doing retry with a new session
     */
    private void clearSession() {
        ziggeo.prefs().putSession(null);
    }
}
