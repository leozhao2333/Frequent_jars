package com.ziggeo.androidsdk.ui.dialogs;

import android.os.Bundle;

public abstract class BaseNoFrameDialog extends BaseDialog {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, getTheme());
        setCancelable(false);
    }
}