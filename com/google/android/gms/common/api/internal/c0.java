package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.i;

final class c0 implements Runnable {
    final /* synthetic */ b j;
    final /* synthetic */ d0 k;

    c0(d0 d0Var, b bVar) {
        this.k = d0Var;
        this.j = bVar;
    }

    public final void run() {
        d0 d0Var = this.k;
        z zVar = (z) d0Var.f2080f.l.get(d0Var.f2076b);
        if (zVar != null) {
            if (this.j.l()) {
                this.k.f2079e = true;
                if (this.k.f2075a.l()) {
                    this.k.h();
                    return;
                }
                try {
                    d0 d0Var2 = this.k;
                    d0Var2.f2075a.h((i) null, d0Var2.f2075a.g());
                } catch (SecurityException e2) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                    this.k.f2075a.k("Failed to get service from broker.");
                    zVar.H(new b(10), (Exception) null);
                }
            } else {
                zVar.H(this.j, (Exception) null);
            }
        }
    }
}
