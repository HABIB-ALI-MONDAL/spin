package com.google.firebase.messaging;

import android.content.Context;
import c.d.a.b.h.j;

public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ Context j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ j l;

    public /* synthetic */ v(Context context, boolean z, j jVar) {
        this.j = context;
        this.k = z;
        this.l = jVar;
    }

    public final void run() {
        s0.c(this.j, this.k, this.l);
    }
}
