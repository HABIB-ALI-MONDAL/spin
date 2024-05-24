package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class l8 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ qa m;
    final /* synthetic */ u8 n;

    l8(u8 u8Var, AtomicReference atomicReference, String str, String str2, String str3, qa qaVar) {
        this.n = u8Var;
        this.j = atomicReference;
        this.k = str2;
        this.l = str3;
        this.m = qaVar;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List a0;
        synchronized (this.j) {
            try {
                u8 u8Var = this.n;
                b3 H = u8Var.f2568d;
                if (H == null) {
                    u8Var.f2527a.f().r().d("(legacy) Failed to get conditional properties; not connected to service", (Object) null, this.k, this.l);
                    this.j.set(Collections.emptyList());
                    this.j.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    n.i(this.m);
                    atomicReference2 = this.j;
                    a0 = H.W(this.k, this.l, this.m);
                } else {
                    atomicReference2 = this.j;
                    a0 = H.a0((String) null, this.k, this.l);
                }
                atomicReference2.set(a0);
                this.n.E();
                atomicReference = this.j;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.n.f2527a.f().r().d("(legacy) Failed to get conditional properties; remote exception", (Object) null, this.k, e2);
                    this.j.set(Collections.emptyList());
                    atomicReference = this.j;
                } catch (Throwable th) {
                    this.j.notify();
                    throw th;
                }
            }
        }
    }
}
