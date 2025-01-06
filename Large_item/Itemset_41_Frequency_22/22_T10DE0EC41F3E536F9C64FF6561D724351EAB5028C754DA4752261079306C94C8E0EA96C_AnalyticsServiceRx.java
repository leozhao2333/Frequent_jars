package com.ziggeo.androidsdk.net.services.analitics;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.ziggeo.androidsdk.net.callbacks.CompletableRequestCallback;
import com.ziggeo.androidsdk.net.models.analitics.AnalyticsEventsListModel;

import io.reactivex.Completable;

/**
 * Created by alex on 10/15/2017.
 */

public class AnalyticsServiceRx implements IAnalyticsServiceRx {

    private IAnalyticsService analyticsService;
    private Gson gson;

    public AnalyticsServiceRx(@NonNull IAnalyticsService analyticsService, @NonNull Gson gson) {
        this.analyticsService = analyticsService;
        this.gson = gson;
    }

    @Override
    public Completable postEvents(@NonNull final AnalyticsEventsListModel queue) {
        return Completable.create(emitter -> analyticsService.postEvents(queue, new CompletableRequestCallback(emitter, gson)));
    }

}
