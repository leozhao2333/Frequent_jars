package com.tencent.timpush.xiaomi;

import com.tencent.imsdk.common.IMLog;

public class TIMPushLog extends IMLog {
    private static final String PRE = "TIMPush-";

    private static String mixTag(String tag) {
        return PRE + tag;
    }

    public static void v(String strTag, String strInfo) {
        IMLog.v(mixTag(strTag), strInfo);
    }

    public static void d(String strTag, String strInfo) {
        IMLog.d(mixTag(strTag), strInfo);
    }

    public static void i(String strTag, String strInfo) {
        IMLog.i(mixTag(strTag), strInfo);
    }

    public static void w(String strTag, String strInfo) {
        IMLog.w(mixTag(strTag), strInfo);
    }

    public static void e(String strTag, String strInfo) {
        IMLog.e(mixTag(strTag), strInfo);
    }
}
