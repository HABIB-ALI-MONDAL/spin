package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class b5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2319a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2320b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f2321c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ q5 f2322d;

    b5(q5 q5Var, String str, String str2, String str3) {
        this.f2322d = q5Var;
        this.f2319a = str;
        this.f2320b = str2;
        this.f2321c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f2322d.f2514a.b();
        return this.f2322d.f2514a.V().d0(this.f2319a, this.f2320b, this.f2321c);
    }
}
