package com.google.android.gms.common.util;

import android.os.Looper;

public final class r {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
