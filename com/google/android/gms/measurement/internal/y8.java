package com.google.android.gms.measurement.internal;

import android.content.Intent;

public final /* synthetic */ class y8 implements Runnable {
    public final /* synthetic */ b9 j;
    public final /* synthetic */ int k;
    public final /* synthetic */ m3 l;
    public final /* synthetic */ Intent m;

    public /* synthetic */ y8(b9 b9Var, int i, m3 m3Var, Intent intent) {
        this.j = b9Var;
        this.k = i;
        this.l = m3Var;
        this.m = intent;
    }

    public final void run() {
        this.j.c(this.k, this.l, this.m);
    }
}
