package com.ziggeo.androidsdk.ui.theming;

import androidx.annotation.NonNull;

public class CameraRecorderStyle extends BaseStyle {

    private CameraRecorderStyle() {
    }

    public static class Builder {
        private CameraRecorderStyle style;

        public Builder(@NonNull CameraRecorderStyle style) {
            this.style = style;
        }

        public Builder() {
            style = new CameraRecorderStyle();
        }

        public Builder hideControls(boolean hide) {
            style.hideControls = hide;
            return this;
        }

        public CameraRecorderStyle build() {
            return style;
        }
    }

}
