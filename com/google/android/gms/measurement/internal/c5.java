package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class c5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2338a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f2339b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f2340c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ q5 f2341d;

    c5(q5 q5Var, String str, String str2, String str3) {
        this.f2341d = q5Var;
        this.f2338a = str;
        this.f2339b = str2;
        this.f2340c = str3;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        this.f2341d.f2514a.b();
        return this.f2341d.f2514a.V().d0(this.f2338a, this.f2339b, this.f2340c);
    }
}
