package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import c.d.a.a.i.p;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ u j;
    public final /* synthetic */ p k;
    public final /* synthetic */ int l;
    public final /* synthetic */ Runnable m;

    public /* synthetic */ d(u uVar, p pVar, int i, Runnable runnable) {
        this.j = uVar;
        this.k = pVar;
        this.l = i;
        this.m = runnable;
    }

    public final void run() {
        this.j.t(this.k, this.l, this.m);
    }
}
