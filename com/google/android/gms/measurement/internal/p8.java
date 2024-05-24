package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class p8 implements Runnable {
    final /* synthetic */ ComponentName j;
    final /* synthetic */ t8 k;

    p8(t8 t8Var, ComponentName componentName) {
        this.k = t8Var;
        this.j = componentName;
    }

    public final void run() {
        u8.M(this.k.f2551c, this.j);
    }
}
