package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class j0 extends l0 {

    /* renamed from: e  reason: collision with root package name */
    private final Callable f2245e;

    /* synthetic */ j0(Callable callable, i0 i0Var) {
        super(false, 1, 5, (String) null, (Throwable) null, (k0) null);
        this.f2245e = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f2245e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
