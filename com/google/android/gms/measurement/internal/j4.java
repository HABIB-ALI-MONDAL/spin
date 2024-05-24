package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.mb;
import java.util.concurrent.Callable;

public final /* synthetic */ class j4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p4 f2419a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2420b;

    public /* synthetic */ j4(p4 p4Var, String str) {
        this.f2419a = p4Var;
        this.f2420b = str;
    }

    public final Object call() {
        return new mb("internal.remoteConfig", new o4(this.f2419a, this.f2420b));
    }
}
