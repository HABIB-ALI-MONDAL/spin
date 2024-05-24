package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import c.d.a.b.e.e.n1;
import com.google.android.gms.common.internal.n;

public final class b6 {

    /* renamed from: a  reason: collision with root package name */
    final Context f2323a;

    /* renamed from: b  reason: collision with root package name */
    String f2324b;

    /* renamed from: c  reason: collision with root package name */
    String f2325c;

    /* renamed from: d  reason: collision with root package name */
    String f2326d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f2327e;

    /* renamed from: f  reason: collision with root package name */
    long f2328f;
    n1 g;
    boolean h = true;
    final Long i;
    String j;

    public b6(Context context, n1 n1Var, Long l) {
        n.i(context);
        Context applicationContext = context.getApplicationContext();
        n.i(applicationContext);
        this.f2323a = applicationContext;
        this.i = l;
        if (n1Var != null) {
            this.g = n1Var;
            this.f2324b = n1Var.o;
            this.f2325c = n1Var.n;
            this.f2326d = n1Var.m;
            this.h = n1Var.l;
            this.f2328f = n1Var.k;
            this.j = n1Var.q;
            Bundle bundle = n1Var.p;
            if (bundle != null) {
                this.f2327e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
