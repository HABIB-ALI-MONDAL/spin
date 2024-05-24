package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ l0 j;
    public final /* synthetic */ Intent k;

    public /* synthetic */ g(l0 l0Var, Intent intent) {
        this.j = l0Var;
        this.k = intent;
    }

    public final void run() {
        this.j.b(this.k);
    }
}
