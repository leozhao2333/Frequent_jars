package com.ziggeo.androidsdk.camera;

import androidx.annotation.NonNull;

public class CameraCharacteristics {
    private String id;
    private boolean zoomEnabled;
    private float maxZoom; // available only when camera opened
    private float currentZoom;

    public CameraCharacteristics(@NonNull String id) {
        this.id = id;
        this.zoomEnabled = true; // enabled by default
    }

    public String getId() {
        return id;
    }

    public boolean isZoomEnabled() {
        return zoomEnabled;
    }

    public void setZoomEnabled(boolean zoomEnabled) {
        this.zoomEnabled = zoomEnabled;
    }

    public float getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(float maxZoom) {
        this.maxZoom = maxZoom;
    }

    public float getCurrentZoom() {
        return currentZoom;
    }

    public void setCurrentZoom(float currentZoom) {
        this.currentZoom = currentZoom;
    }
}
