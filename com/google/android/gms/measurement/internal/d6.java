package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class d6 implements Runnable {
    public final /* synthetic */ e7 j;
    public final /* synthetic */ Bundle k;

    public /* synthetic */ d6(e7 e7Var, Bundle bundle) {
        this.j = e7Var;
        this.k = bundle;
    }

    public final void run() {
        this.j.q(this.k);
    }
}
