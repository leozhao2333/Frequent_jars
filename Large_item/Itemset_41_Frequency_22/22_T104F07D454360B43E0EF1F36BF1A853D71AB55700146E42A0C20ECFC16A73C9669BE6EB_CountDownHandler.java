package com.ziggeo.androidsdk.recorder;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class CountDownHandler {

    private static final int COUNTDOWN_STEP = 1;
    private Handler handler = new Handler();
    private List<CountDownListener> listeners = new ArrayList<>();

    public void addListener(CountDownListener listener) {
        this.listeners.add(listener);
    }

    public void start(final int delay) {
        if (delay < 0) {
            return;
        }

        for (CountDownListener listener : listeners) {
            listener.countdown(delay);
        }

        final int updateAfter = delay >= COUNTDOWN_STEP ? COUNTDOWN_STEP : delay;
        if (updateAfter != 0) {
            handler.postDelayed(() -> start(delay - updateAfter), updateAfter * 1000);
        }
    }

    public void stop() {
        handler.removeCallbacksAndMessages(null);
    }

    public interface CountDownListener {
        void countdown(int secondsLeft);
    }
}
