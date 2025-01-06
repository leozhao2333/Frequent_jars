package com.ziggeo.androidsdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;

import com.ziggeo.androidsdk.callbacks.IAnalyticsManager;
import com.ziggeo.androidsdk.camera.Camera;
import com.ziggeo.androidsdk.fileselector.FileSelectorConfig;
import com.ziggeo.androidsdk.net.ConnectionListener;
import com.ziggeo.androidsdk.net.services.audios.IAudiosService;
import com.ziggeo.androidsdk.net.services.auth.IAuthService;
import com.ziggeo.androidsdk.net.services.images.IImagesService;
import com.ziggeo.androidsdk.net.services.streams.IStreamsService;
import com.ziggeo.androidsdk.net.services.videos.IVideosService;
import com.ziggeo.androidsdk.net.uploading.UploadingConfig;
import com.ziggeo.androidsdk.player.PlayerConfig;
import com.ziggeo.androidsdk.qr.QrScannerConfig;
import com.ziggeo.androidsdk.recorder.RecorderConfig;
import com.ziggeo.androidsdk.widgets.videoview.ZVideoView;

import java.util.List;

interface IZiggeoBase {
    // ===============================================
    // Global config
    // ===============================================

    /**
     * Sets the application token.
     *
     * @param token - token which will be used in requests
     */
    void setAppToken(@NonNull String token);

    @NonNull
    String getAppToken();

    /**
     * Sets the client auth token.
     *
     * @param token - token which will be used for authentication in requests
     */
    void setClientAuthToken(@Nullable String token);

    @Nullable
    String getClientAuthToken();

    /**
     * Sets the server auth token.
     *
     * @param token - token which will be used for authentication in requests
     */
    void setServerAuthToken(@Nullable String token);

    @Nullable
    String getServerAuthToken();

    /**
     * The session key is generated as follows: i07af2jp98rvoctt26y5egy3APPLICATION_TOKEN -
     * in other words the string i07af2jp98rvoctt26y5egy3 concatenated with the application token.
     */
    @NonNull
    String getSessionKey();

    void setUploadingConfig(@NonNull UploadingConfig config);

    @NonNull
    UploadingConfig getUploadingConfig();

    void startFileSelector();

    void startFileSelectorWithConfig(int mediaType);

    /**
     * Cancel current active upload if any
     *
     * @param deleteFile - true if the local file should be deleted
     */
    void cancelCurrentUpload(boolean deleteFile);

    /**
     * Cancel specific upload (current or in queue)
     *
     * @param path       - filepath to local file
     * @param deleteFile - true if the local file should be deleted
     */
    void cancelUploadByPath(@NonNull String path, boolean deleteFile);

    /**
     * @return <code>true</code> if and only if the cache is
     * successfully cleared; <code>false</code> otherwise
     */
    boolean clearRecorded();

    /**
     * To use Crashlytics or similar service we have to turn off
     * internal crash logger because they can't work together.
     */
    void enableCrashTracker(@NonNull final Context context);

    // ===============================================
    // Camera
    // ===============================================
    @NonNull
    List<String> getCameraIdList();

    @Nullable
    Camera getCamera(@NonNull String id);

    // ===============================================
    // QR Scanner
    // ===============================================
    void setQrScannerConfig(@NonNull QrScannerConfig config);

    @NonNull
    QrScannerConfig getQrScannerConfig();

    void startQrScanner();

    void attachQrScanner(@NonNull FragmentManager fragmentManager, int contentId);

    // ===============================================
    // Camera recorder
    // ===============================================
    void setRecorderConfig(@NonNull RecorderConfig recorderConfig);

    @NonNull
    RecorderConfig getRecorderConfig();

    void startCameraRecorder();

    public void startImageRecorder();

    void attachCameraRecorder(@NonNull FragmentManager fragmentManager, int contentId);

    // ===============================================
    // Audio recorder
    // ===============================================
    void attachAudioPlayer(@NonNull FragmentManager fragmentManager, int contentId, @NonNull Uri... path);

    void attachAudioPlayer(@NonNull FragmentManager fragmentManager, int contentId, @NonNull String... token);

    void startAudioPlayer(@NonNull Uri... path);

    void startAudioPlayer(@NonNull String... videoToken);

    void startAudioRecorder();

    void showImage(@NonNull Uri path);

    void showImage(@Nullable String token);

    void attachAudioRecorder(@NonNull FragmentManager fragmentManager, int contentId);

    // ===============================================
    // Manual upload
    // ===============================================
    void setFileSelectorConfig(@NonNull FileSelectorConfig config);

    @NonNull
    FileSelectorConfig getFileSelectorConfig();

    // ===============================================
    // Player config
    // ===============================================
    void setPlayerConfig(@NonNull PlayerConfig config);

    @NonNull
    PlayerConfig getPlayerConfig();

    /**
     * Launch standalone activity with player to play the file from uri.
     *
     * @param path - {@link Uri} One or more path to file.
     */
    @Deprecated
    void startPlayer(@NonNull Uri... path);

    void startVideoPlayer(@NonNull Uri... path);

    /**
     * Launch standalone activity with the player to play the file from stream.
     *
     * @param videoToken - One or more video token.
     */
    @Deprecated
    void startPlayer(@NonNull String... videoToken);

    void startVideoPlayer(@NonNull String... videoToken);

    /**
     * Embed the player to play the file from uri.
     *
     * @param fragmentManager - {@link FragmentManager}
     * @param contentId       - Identifier of the container this fragment is to be placed in.
     * @param path            - {@link Uri} One or more path to file.
     */
    void attachPlayer(@NonNull FragmentManager fragmentManager, int contentId, Uri... path);

    /**
     * Embed the player to play the file from stream.
     *
     * @param fragmentManager - {@link FragmentManager}
     * @param contentId       - Identifier of the container this fragment is to be placed in.
     * @param videoToken      - One or more video token.
     */
    void attachPlayer(@NonNull FragmentManager fragmentManager, int contentId, String... videoToken);

    /**
     * Start foreground service for screen recording and screen recording
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void startScreenRecorder(@Nullable ScreenRecordServiceNotificationConfig config);

    /**
     * @return instance of an auth service
     */
    @NonNull
    IAuthService auth();

    /**
     * @return instance of a video service
     */
    @NonNull
    IVideosService videos();

    /**
     * @return instance of a stream service
     */
    @NonNull
    IStreamsService streams();

    /**
     * @return instance of a audio service
     */
    @NonNull
    IAudiosService audios();

    /**
     * @return instance of a image service
     */
    @NonNull
    IImagesService images();

    /**
     * @return instance of an AnalyticsManager to track analytic events
     */
    @NonNull
    IAnalyticsManager analyticsManager();

    /**
     * @return instance of ZVideoView
     */
    @NonNull
    ZVideoView getZVideoView();

    void createConnectionCallback(LifecycleOwner owner, ConnectionListener listener);


    // ===============================================
    // Sensors
    // ===============================================
    void setSensorCallback(@Nullable SensorManager.Callback callback);

    // ===============================================
    // Contact us
    // ===============================================
    void sendReport(@Nullable List<String> logs);

    void sendEmailToSupport();

    // ===============================================
    // Deprecated methods
    // ===============================================

}
