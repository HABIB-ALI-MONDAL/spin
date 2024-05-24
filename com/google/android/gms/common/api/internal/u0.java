package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.d.a.b.h.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;

abstract class u0 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    protected final j f2136b;

    public u0(int i, j jVar) {
        super(i);
        this.f2136b = jVar;
    }

    public final void a(Status status) {
        this.f2136b.d(new b(status));
    }

    public final void b(Exception exc) {
        this.f2136b.d(exc);
    }

    public final void c(z zVar) {
        try {
            h(zVar);
        } catch (DeadObjectException e2) {
            a(z0.e(e2));
            throw e2;
        } catch (RemoteException e3) {
            a(z0.e(e3));
        } catch (RuntimeException e4) {
            this.f2136b.d(e4);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void h(z zVar);
}
