package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.lang.Thread;

final class r4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f2525a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u4 f2526b;

    public r4(u4 u4Var, String str) {
        this.f2526b = u4Var;
        n.i(str);
        this.f2525a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f2526b.f2527a.f().r().b(this.f2525a, th);
    }
}
