package com.ziggeo.androidsdk.ui.theming;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PlayerStyle extends BaseStyle {

    public static final int DEFAULT = 0;
    public static final int MODERN = 1;
    public static final int CUBE = 2;
    public static final int SPACE = 3;
    public static final int MINIMALIST = 4;
    public static final int ELEVATE = 5;
    public static final int THEATRE = 6;
    @ControllerStyle
    private int controllerStyle = DEFAULT;
    @ColorInt
    private int textColor;
    @ColorInt
    private int unplayedColor;
    @ColorInt
    private int playedColor;
    @ColorInt
    private int bufferedColor;
    @ColorInt
    private int tintColor;
    @DrawableRes
    private int muteOffImageDrawable;
    @DrawableRes
    private int muteOnImageDrawable;

    private PlayerStyle() {
    }

    public int getControllerStyle() {
        return controllerStyle;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getUnplayedColor() {
        return unplayedColor;
    }

    public int getPlayedColor() {
        return playedColor;
    }

    public int getBufferedColor() {
        return bufferedColor;
    }

    public int getTintColor() {
        return tintColor;
    }

    public int getMuteOffImageDrawable() {
        return muteOffImageDrawable;
    }

    public int getMuteOnImageDrawable() {
        return muteOnImageDrawable;
    }

    public void setControllerStyle(int controllerStyle) {
        this.controllerStyle = controllerStyle;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setUnplayedColor(int unplayedColor) {
        this.unplayedColor = unplayedColor;
    }

    public void setPlayedColor(int playedColor) {
        this.playedColor = playedColor;
    }

    public void setBufferedColor(int bufferedColor) {
        this.bufferedColor = bufferedColor;
    }

    public void setTintColor(int tintColor) {
        this.tintColor = tintColor;
    }

    public void setMuteOffImageDrawable(int muteOffImageDrawable) {
        this.muteOffImageDrawable = muteOffImageDrawable;
    }

    public void setMuteOnImageDrawable(int muteOnImageDrawable) {
        this.muteOnImageDrawable = muteOnImageDrawable;
    }

    public String stringValueConfig() {
        return "{\"controllerStyle\": " + controllerStyle +
                ",\"textColor\": " +
                textColor +
                ",\"unplayedColor\": " +
                unplayedColor +
                ",\"playedColor\": " +
                playedColor +
                ",\"bufferedColor\": " +
                bufferedColor +
                ",\"tintColor\": " +
                tintColor +
                ",\"muteOffImageDrawable\": " +
                muteOffImageDrawable +
                ",\"muteOnImageDrawable\": " +
                muteOnImageDrawable + "}";
    }

    @IntDef({DEFAULT, MODERN, CUBE, SPACE, MINIMALIST, ELEVATE, THEATRE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControllerStyle {
    }

    public static class Builder {
        private PlayerStyle style;

        public Builder(@NonNull PlayerStyle style) {
            this.style = style;
        }

        public Builder() {
            style = new PlayerStyle();
        }

        public Builder hideControls(boolean hide) {
            style.hideControls = hide;
            return this;
        }

        public Builder controllerStyle(@ControllerStyle int controllerStyle) {
            style.controllerStyle = controllerStyle;
            return this;
        }

        public Builder textColor(@ColorInt int textColor) {
            style.textColor = textColor;
            return this;
        }

        public Builder unplayedColor(@ColorInt int unplayedColor) {
            style.unplayedColor = unplayedColor;
            return this;
        }

        public Builder playedColor(@ColorInt int playedColor) {
            style.playedColor = playedColor;
            return this;
        }

        public Builder bufferedColor(@ColorInt int bufferedColor) {
            style.bufferedColor = bufferedColor;
            return this;
        }

        public Builder tintColor(@ColorInt int tint) {
            style.tintColor = tint;
            return this;
        }

        public Builder muteOffImageDrawable(@DrawableRes int muteOffImageRecourse) {
            style.muteOffImageDrawable = muteOffImageRecourse;
            return this;
        }

        public Builder muteOnImageDrawable(@DrawableRes int muteOnImageRecourse) {
            style.muteOnImageDrawable = muteOnImageRecourse;
            return this;
        }

        public PlayerStyle build() {
            return style;
        }
    }
}
