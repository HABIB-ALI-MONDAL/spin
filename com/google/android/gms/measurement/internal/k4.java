package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.le;
import java.util.concurrent.Callable;

public final /* synthetic */ class k4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p4 f2435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2436b;

    public /* synthetic */ k4(p4 p4Var, String str) {
        this.f2435a = p4Var;
        this.f2436b = str;
    }

    public final Object call() {
        return new le("internal.appMetadata", new i4(this.f2435a, this.f2436b));
    }
}
