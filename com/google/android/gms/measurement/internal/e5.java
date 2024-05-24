package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class e5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2365a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2366b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f2367c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ q5 f2368d;

    e5(q5 q5Var, String str, String str2, String str3) {
        this.f2368d = q5Var;
        this.f2365a = str;
        this.f2366b = str2;
        this.f2367c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f2368d.f2514a.b();
        return this.f2368d.f2514a.V().a0(this.f2365a, this.f2366b, this.f2367c);
    }
}
