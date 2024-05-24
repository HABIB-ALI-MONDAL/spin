package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class d5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2355a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2356b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f2357c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ q5 f2358d;

    d5(q5 q5Var, String str, String str2, String str3) {
        this.f2358d = q5Var;
        this.f2355a = str;
        this.f2356b = str2;
        this.f2357c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f2358d.f2514a.b();
        return this.f2358d.f2514a.V().a0(this.f2355a, this.f2356b, this.f2357c);
    }
}
