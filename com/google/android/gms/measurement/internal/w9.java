package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class w9 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k = "_err";
    final /* synthetic */ Bundle l;
    final /* synthetic */ x9 m;

    w9(x9 x9Var, String str, String str2, Bundle bundle) {
        this.m = x9Var;
        this.j = str;
        this.l = bundle;
    }

    public final void run() {
        x w0 = this.m.f2634a.g0().w0(this.j, this.k, this.l, "auto", this.m.f2634a.a().a(), false, true);
        ca caVar = this.m.f2634a;
        n.i(w0);
        caVar.k(w0, this.j);
    }
}
