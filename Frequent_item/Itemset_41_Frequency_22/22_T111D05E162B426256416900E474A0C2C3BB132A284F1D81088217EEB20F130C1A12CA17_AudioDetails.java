package com.ziggeo.androidsdk.net.models.audios;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ziggeo.androidsdk.net.models.BaseApiModel;

public class AudioDetails extends BaseApiModel {

    @SerializedName("audio")
    private Audio audio;

    public Audio getAudio() {
        return audio;
    }

    public static AudioDetails fromJson(@NonNull String json) {
        return (new Gson()).fromJson(json, AudioDetails.class);
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }
}
