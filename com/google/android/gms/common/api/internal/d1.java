package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.n;

final class d1 implements Runnable {
    private final b1 j;
    final /* synthetic */ e1 k;

    d1(e1 e1Var, b1 b1Var) {
        this.k = e1Var;
        this.j = b1Var;
    }

    public final void run() {
        if (this.k.k) {
            b b2 = this.j.b();
            if (b2.k()) {
                e1 e1Var = this.k;
                g gVar = e1Var.j;
                Activity b3 = e1Var.b();
                PendingIntent j2 = b2.j();
                n.i(j2);
                gVar.startActivityForResult(GoogleApiActivity.a(b3, j2, this.j.a(), false), 1);
                return;
            }
            e1 e1Var2 = this.k;
            if (e1Var2.n.b(e1Var2.b(), b2.g(), (String) null) != null) {
                e1 e1Var3 = this.k;
                e1Var3.n.x(e1Var3.b(), this.k.j, b2.g(), 2, this.k);
            } else if (b2.g() == 18) {
                e1 e1Var4 = this.k;
                Dialog s = e1Var4.n.s(e1Var4.b(), this.k);
                e1 e1Var5 = this.k;
                e1Var5.n.t(e1Var5.b().getApplicationContext(), new c1(this, s));
            } else {
                this.k.l(b2, this.j.a());
            }
        }
    }
}
