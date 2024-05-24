package com.google.android.gms.common.util;

import android.os.SystemClock;

public class g implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final g f2263a = new g();

    private g() {
    }

    public static d d() {
        return f2263a;
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    public final long c() {
        return System.nanoTime();
    }
}
