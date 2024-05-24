package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class p7 implements Runnable {
    final /* synthetic */ m7 j;
    final /* synthetic */ m7 k;
    final /* synthetic */ long l;
    final /* synthetic */ boolean m;
    final /* synthetic */ u7 n;

    p7(u7 u7Var, m7 m7Var, m7 m7Var2, long j2, boolean z) {
        this.n = u7Var;
        this.j = m7Var;
        this.k = m7Var2;
        this.l = j2;
        this.m = z;
    }

    public final void run() {
        this.n.o(this.j, this.k, this.l, this.m, (Bundle) null);
    }
}
