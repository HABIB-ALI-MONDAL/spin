package com.google.firebase.messaging;

import android.content.Intent;
import c.d.a.b.h.j;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ i0 j;
    public final /* synthetic */ Intent k;
    public final /* synthetic */ j l;

    public /* synthetic */ c(i0 i0Var, Intent intent, j jVar) {
        this.j = i0Var;
        this.k = intent;
        this.l = jVar;
    }

    public final void run() {
        this.j.d(this.k, this.l);
    }
}
