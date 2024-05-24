package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import c.d.a.b.e.e.i1;
import com.google.android.gms.common.internal.n;
import java.util.List;

final class v7 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k;
    final /* synthetic */ qa l;
    final /* synthetic */ boolean m;
    final /* synthetic */ i1 n;
    final /* synthetic */ u8 o;

    v7(u8 u8Var, String str, String str2, qa qaVar, boolean z, i1 i1Var) {
        this.o = u8Var;
        this.j = str;
        this.k = str2;
        this.l = qaVar;
        this.m = z;
        this.n = i1Var;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e2;
        Bundle bundle2 = new Bundle();
        try {
            u8 u8Var = this.o;
            b3 H = u8Var.f2568d;
            if (H == null) {
                u8Var.f2527a.f().r().c("Failed to get user properties; not connected to service", this.j, this.k);
                this.o.f2527a.N().F(this.n, bundle2);
                return;
            }
            n.i(this.l);
            List<fa> M = H.M(this.j, this.k, this.m, this.l);
            bundle = new Bundle();
            if (M != null) {
                for (fa faVar : M) {
                    String str = faVar.n;
                    if (str != null) {
                        bundle.putString(faVar.k, str);
                    } else {
                        Long l2 = faVar.m;
                        if (l2 != null) {
                            bundle.putLong(faVar.k, l2.longValue());
                        } else {
                            Double d2 = faVar.p;
                            if (d2 != null) {
                                bundle.putDouble(faVar.k, d2.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.o.E();
                this.o.f2527a.N().F(this.n, bundle);
            } catch (RemoteException e3) {
                e2 = e3;
                try {
                    this.o.f2527a.f().r().c("Failed to get user properties; remote exception", this.j, e2);
                    this.o.f2527a.N().F(this.n, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.o.f2527a.N().F(this.n, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e4) {
            bundle = bundle2;
            e2 = e4;
            this.o.f2527a.f().r().c("Failed to get user properties; remote exception", this.j, e2);
            this.o.f2527a.N().F(this.n, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.o.f2527a.N().F(this.n, bundle2);
            throw th;
        }
    }
}
