package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class n3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2480a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2481b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2482c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f2483d;

    public n3(String str, String str2, Bundle bundle, long j) {
        this.f2480a = str;
        this.f2481b = str2;
        this.f2483d = bundle;
        this.f2482c = j;
    }

    public static n3 b(x xVar) {
        return new n3(xVar.j, xVar.l, xVar.k.j(), xVar.m);
    }

    public final x a() {
        return new x(this.f2480a, new v(new Bundle(this.f2483d)), this.f2481b, this.f2482c);
    }

    public final String toString() {
        String str = this.f2481b;
        String str2 = this.f2480a;
        String obj = this.f2483d.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }
}
