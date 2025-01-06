package com.tencent.timpush.xiaomi;

public class TIMPushErrorBean {
    public long errorCode;
    public String errorDescription;

    public long getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
