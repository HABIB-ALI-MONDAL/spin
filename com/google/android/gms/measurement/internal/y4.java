package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class y4 implements Runnable {
    public final /* synthetic */ q5 j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Bundle l;

    public /* synthetic */ y4(q5 q5Var, String str, Bundle bundle) {
        this.j = q5Var;
        this.k = str;
        this.l = bundle;
    }

    public final void run() {
        this.j.d0(this.k, this.l);
    }
}
