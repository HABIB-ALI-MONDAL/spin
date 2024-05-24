package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class n8 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ qa m;
    final /* synthetic */ boolean n;
    final /* synthetic */ u8 o;

    n8(u8 u8Var, AtomicReference atomicReference, String str, String str2, String str3, qa qaVar, boolean z) {
        this.o = u8Var;
        this.j = atomicReference;
        this.k = str2;
        this.l = str3;
        this.m = qaVar;
        this.n = z;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List A;
        synchronized (this.j) {
            try {
                u8 u8Var = this.o;
                b3 H = u8Var.f2568d;
                if (H == null) {
                    u8Var.f2527a.f().r().d("(legacy) Failed to get user properties; not connected to service", (Object) null, this.k, this.l);
                    this.j.set(Collections.emptyList());
                    this.j.notify();
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) null)) {
                    n.i(this.m);
                    atomicReference2 = this.j;
                    A = H.M(this.k, this.l, this.n, this.m);
                } else {
                    atomicReference2 = this.j;
                    A = H.A((String) null, this.k, this.l, this.n);
                }
                atomicReference2.set(A);
                this.o.E();
                atomicReference = this.j;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.o.f2527a.f().r().d("(legacy) Failed to get user properties; remote exception", (Object) null, this.k, e2);
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
