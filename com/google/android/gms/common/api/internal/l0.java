package com.google.android.gms.common.api.internal;

import android.os.IBinder;

public final /* synthetic */ class l0 implements Runnable {
    public final /* synthetic */ i j;
    public final /* synthetic */ IBinder k;

    public /* synthetic */ l0(i iVar, IBinder iBinder) {
        this.j = iVar;
        this.k = iBinder;
    }

    public final void run() {
        this.j.q(this.k);
    }
}
