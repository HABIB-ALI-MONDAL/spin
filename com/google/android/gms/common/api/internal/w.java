package com.google.android.gms.common.api.internal;

final class w implements Runnable {
    final /* synthetic */ int j;
    final /* synthetic */ z k;

    w(z zVar, int i) {
        this.k = zVar;
        this.j = i;
    }

    public final void run() {
        this.k.j(this.j);
    }
}
