package com.ziggeo.androidsdk.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.graphics.Matrix;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.ziggeo.androidsdk.R;
import com.ziggeo.androidsdk.callbacks.ICommonCallback;
import com.ziggeo.androidsdk.log.ZLog;
import com.ziggeo.androidsdk.utils.Constants;

import java.io.IOException;
import java.net.URL;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ImageViewFragment extends BaseFragment {

    ImageView imageView;

    @Nullable
    @Override
    protected ICommonCallback getCallback() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_view;
    }

    @Override
    protected void initViews() {
        super.initViews();
        imageView = root.findViewById(R.id.iv_image);
        if (getArguments() != null && getArguments().containsKey(Constants.ARG_TOKEN)) {
            String imageToken = getArguments().getString(Constants.ARG_TOKEN);
            getImageUrl(imageToken);
        }
        if (getArguments() != null && getArguments().containsKey(Constants.ARG_PATH)) {
            Uri imagePath = getArguments().getParcelable(Constants.ARG_PATH);
            getImageUrl(imagePath);
        }
    }

    private void getImageUrl(String imageToken) {
        if (imageToken != null) {
            showProgress();
            ziggeo.getAuthRepository()
                    .getSession().toObservable()
                    .flatMap(session -> ziggeo.apiRx().images().getImageUrl(imageToken)
                            .toObservable())
                    .map(it -> {
                        URL url = new URL(it);
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90);
                        Bitmap rotatedBitmap = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), matrix, true);
                        return rotatedBitmap;
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(playingQueue ->
                    {
                        imageView.setImageBitmap(playingQueue);
                        hideProgress();
                    }, throwable -> {
                        ZLog.e(throwable);
                        if (getCallback() != null) {
                            getCallback().error(throwable);
                        }
                        new AlertDialog.Builder(getContext())
                                .setMessage(R.string.image_error)
                                .setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss())
                                .show();
                        hideProgress();
                    });
        }
    }

    private void getImageUrl(Uri imagePath) {
        if (imagePath != null) {
            showProgress();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), imagePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                hideProgress();
            }
        }
    }
}
