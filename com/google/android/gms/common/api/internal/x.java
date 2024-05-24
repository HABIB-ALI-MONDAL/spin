package com.google.android.gms.common.api.internal;

final class x implements Runnable {
    final /* synthetic */ y j;

    x(y yVar) {
        this.j = yVar;
    }

    public final void run() {
        z zVar = this.j.f2142a;
        zVar.f2145b.k(String.valueOf(zVar.f2145b.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
