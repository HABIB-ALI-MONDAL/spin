package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import c.d.a.b.h.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.d;

public final class x0 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    private final n f2139b;

    /* renamed from: c  reason: collision with root package name */
    private final j f2140c;

    /* renamed from: d  reason: collision with root package name */
    private final m f2141d;

    public x0(int i, n nVar, j jVar, m mVar) {
        super(i);
        this.f2140c = jVar;
        this.f2139b = nVar;
        this.f2141d = mVar;
        if (i == 2 && nVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(Status status) {
        this.f2140c.d(this.f2141d.a(status));
    }

    public final void b(Exception exc) {
        this.f2140c.d(exc);
    }

    public final void c(z zVar) {
        try {
            this.f2139b.b(zVar.v(), this.f2140c);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a(z0.e(e3));
        } catch (RuntimeException e4) {
            this.f2140c.d(e4);
        }
    }

    public final void d(q qVar, boolean z) {
        qVar.b(this.f2140c, z);
    }

    public final boolean f(z zVar) {
        return this.f2139b.c();
    }

    public final d[] g(z zVar) {
        return this.f2139b.e();
    }
}
