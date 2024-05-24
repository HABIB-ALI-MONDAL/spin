package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

public final /* synthetic */ class c6 implements Runnable {
    public final /* synthetic */ e7 j;
    public final /* synthetic */ Bundle k;
    public final /* synthetic */ long l;

    public /* synthetic */ c6(e7 e7Var, Bundle bundle, long j2) {
        this.j = e7Var;
        this.k = bundle;
        this.l = j2;
    }

    public final void run() {
        e7 e7Var = this.j;
        Bundle bundle = this.k;
        long j2 = this.l;
        if (TextUtils.isEmpty(e7Var.f2527a.B().t())) {
            e7Var.F(bundle, 0, j2);
        } else {
            e7Var.f2527a.f().x().a("Using developer consent only; google app id found");
        }
    }
}
