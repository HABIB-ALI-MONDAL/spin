package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import c.d.a.b.h.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class z implements f, g {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f2144a = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: b  reason: collision with root package name */
    public final a.f f2145b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final b f2146c;

    /* renamed from: d  reason: collision with root package name */
    private final q f2147d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f2148e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final Map f2149f = new HashMap();
    private final int g;
    private final r0 h;
    private boolean i;
    private final List j = new ArrayList();
    private b k = null;
    private int l = 0;
    final /* synthetic */ e m;

    public z(e eVar, e eVar2) {
        this.m = eVar;
        a.f g2 = eVar2.g(eVar.p.getLooper(), this);
        this.f2145b = g2;
        this.f2146c = eVar2.d();
        this.f2147d = new q();
        this.g = eVar2.f();
        if (g2.l()) {
            this.h = eVar2.h(eVar.g, eVar.p);
        } else {
            this.h = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(z zVar, b0 b0Var) {
        if (!zVar.j.contains(b0Var) || zVar.i) {
            return;
        }
        if (!zVar.f2145b.d()) {
            zVar.E();
        } else {
            zVar.f();
        }
    }

    static /* bridge */ /* synthetic */ void C(z zVar, b0 b0Var) {
        d[] g2;
        if (zVar.j.remove(b0Var)) {
            zVar.m.p.removeMessages(15, b0Var);
            zVar.m.p.removeMessages(16, b0Var);
            d a2 = b0Var.f2070b;
            ArrayList arrayList = new ArrayList(zVar.f2144a.size());
            for (z0 z0Var : zVar.f2144a) {
                if ((z0Var instanceof g0) && (g2 = ((g0) z0Var).g(zVar)) != null && com.google.android.gms.common.util.b.c(g2, a2)) {
                    arrayList.add(z0Var);
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                z0 z0Var2 = (z0) arrayList.get(i2);
                zVar.f2144a.remove(z0Var2);
                z0Var2.b(new m(a2));
            }
        }
    }

    private final d b(d[] dVarArr) {
        if (!(dVarArr == null || dVarArr.length == 0)) {
            d[] c2 = this.f2145b.c();
            if (c2 == null) {
                c2 = new d[0];
            }
            b.c.a aVar = new b.c.a(r3);
            for (d dVar : c2) {
                aVar.put(dVar.g(), Long.valueOf(dVar.i()));
            }
            for (d dVar2 : dVarArr) {
                Long l2 = (Long) aVar.get(dVar2.g());
                if (l2 == null || l2.longValue() < dVar2.i()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private final void c(b bVar) {
        for (a1 b2 : this.f2148e) {
            b2.b(this.f2146c, bVar, com.google.android.gms.common.internal.m.a(bVar, b.n) ? this.f2145b.e() : null);
        }
        this.f2148e.clear();
    }

    /* access modifiers changed from: private */
    public final void d(Status status) {
        n.c(this.m.p);
        e(status, (Exception) null, false);
    }

    private final void e(Status status, Exception exc, boolean z) {
        n.c(this.m.p);
        boolean z2 = false;
        boolean z3 = status == null;
        if (exc == null) {
            z2 = true;
        }
        if (z3 != z2) {
            Iterator it = this.f2144a.iterator();
            while (it.hasNext()) {
                z0 z0Var = (z0) it.next();
                if (!z || z0Var.f2150a == 2) {
                    if (status != null) {
                        z0Var.a(status);
                    } else {
                        z0Var.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void f() {
        ArrayList arrayList = new ArrayList(this.f2144a);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            z0 z0Var = (z0) arrayList.get(i2);
            if (this.f2145b.d()) {
                if (o(z0Var)) {
                    this.f2144a.remove(z0Var);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        D();
        c(b.n);
        n();
        Iterator it = this.f2149f.values().iterator();
        while (it.hasNext()) {
            n0 n0Var = (n0) it.next();
            if (b(n0Var.f2118a.b()) == null) {
                try {
                    n0Var.f2118a.c(this.f2145b, new j());
                } catch (DeadObjectException unused) {
                    i(3);
                    this.f2145b.k("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it.remove();
        }
        f();
        l();
    }

    /* access modifiers changed from: private */
    public final void j(int i2) {
        D();
        this.i = true;
        this.f2147d.c(i2, this.f2145b.f());
        e eVar = this.m;
        eVar.p.sendMessageDelayed(Message.obtain(eVar.p, 9, this.f2146c), this.m.f2081a);
        e eVar2 = this.m;
        eVar2.p.sendMessageDelayed(Message.obtain(eVar2.p, 11, this.f2146c), this.m.f2082b);
        this.m.i.c();
        for (n0 n0Var : this.f2149f.values()) {
            n0Var.f2120c.run();
        }
    }

    private final void l() {
        this.m.p.removeMessages(12, this.f2146c);
        e eVar = this.m;
        eVar.p.sendMessageDelayed(eVar.p.obtainMessage(12, this.f2146c), this.m.f2083c);
    }

    private final void m(z0 z0Var) {
        z0Var.d(this.f2147d, P());
        try {
            z0Var.c(this);
        } catch (DeadObjectException unused) {
            i(1);
            this.f2145b.k("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void n() {
        if (this.i) {
            this.m.p.removeMessages(11, this.f2146c);
            this.m.p.removeMessages(9, this.f2146c);
            this.i = false;
        }
    }

    private final boolean o(z0 z0Var) {
        if (!(z0Var instanceof g0)) {
            m(z0Var);
            return true;
        }
        g0 g0Var = (g0) z0Var;
        d b2 = b(g0Var.g(this));
        if (b2 == null) {
            m(z0Var);
            return true;
        }
        String name = this.f2145b.getClass().getName();
        String g2 = b2.g();
        long i2 = b2.i();
        Log.w("GoogleApiManager", name + " could not execute call because it requires feature (" + g2 + ", " + i2 + ").");
        if (!this.m.q || !g0Var.f(this)) {
            g0Var.b(new m(b2));
            return true;
        }
        b0 b0Var = new b0(this.f2146c, b2, (a0) null);
        int indexOf = this.j.indexOf(b0Var);
        if (indexOf >= 0) {
            b0 b0Var2 = (b0) this.j.get(indexOf);
            this.m.p.removeMessages(15, b0Var2);
            e eVar = this.m;
            eVar.p.sendMessageDelayed(Message.obtain(eVar.p, 15, b0Var2), this.m.f2081a);
            return false;
        }
        this.j.add(b0Var);
        e eVar2 = this.m;
        eVar2.p.sendMessageDelayed(Message.obtain(eVar2.p, 15, b0Var), this.m.f2081a);
        e eVar3 = this.m;
        eVar3.p.sendMessageDelayed(Message.obtain(eVar3.p, 16, b0Var), this.m.f2082b);
        b bVar = new b(2, (PendingIntent) null);
        if (p(bVar)) {
            return false;
        }
        this.m.g(bVar, this.g);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean p(com.google.android.gms.common.b r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.e.t
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.e r1 = r3.m     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.r r2 = r1.m     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0027
            java.util.Set r1 = r1.n     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.b r2 = r3.f2146c     // Catch:{ all -> 0x002a }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0027
            com.google.android.gms.common.api.internal.e r1 = r3.m     // Catch:{ all -> 0x002a }
            com.google.android.gms.common.api.internal.r r1 = r1.m     // Catch:{ all -> 0x002a }
            int r2 = r3.g     // Catch:{ all -> 0x002a }
            r1.s(r4, r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 1
            return r4
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            r4 = 0
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.z.p(com.google.android.gms.common.b):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean q(boolean z) {
        n.c(this.m.p);
        if (!this.f2145b.d() || this.f2149f.size() != 0) {
            return false;
        }
        if (this.f2147d.e()) {
            if (z) {
                l();
            }
            return false;
        }
        this.f2145b.k("Timing out service connection.");
        return true;
    }

    public final void D() {
        n.c(this.m.p);
        this.k = null;
    }

    public final void E() {
        b bVar;
        n.c(this.m.p);
        if (!this.f2145b.d() && !this.f2145b.b()) {
            try {
                e eVar = this.m;
                int b2 = eVar.i.b(eVar.g, this.f2145b);
                if (b2 != 0) {
                    b bVar2 = new b(b2, (PendingIntent) null);
                    String name = this.f2145b.getClass().getName();
                    String obj = bVar2.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + obj);
                    H(bVar2, (Exception) null);
                    return;
                }
                e eVar2 = this.m;
                a.f fVar = this.f2145b;
                d0 d0Var = new d0(eVar2, fVar, this.f2146c);
                if (fVar.l()) {
                    r0 r0Var = this.h;
                    n.i(r0Var);
                    r0Var.e0(d0Var);
                }
                try {
                    this.f2145b.i(d0Var);
                } catch (SecurityException e2) {
                    e = e2;
                    bVar = new b(10);
                    H(bVar, e);
                }
            } catch (IllegalStateException e3) {
                e = e3;
                bVar = new b(10);
                H(bVar, e);
            }
        }
    }

    public final void F(z0 z0Var) {
        n.c(this.m.p);
        if (!this.f2145b.d()) {
            this.f2144a.add(z0Var);
            b bVar = this.k;
            if (bVar == null || !bVar.k()) {
                E();
            } else {
                H(this.k, (Exception) null);
            }
        } else if (o(z0Var)) {
            l();
        } else {
            this.f2144a.add(z0Var);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        this.l++;
    }

    public final void H(b bVar, Exception exc) {
        n.c(this.m.p);
        r0 r0Var = this.h;
        if (r0Var != null) {
            r0Var.f0();
        }
        D();
        this.m.i.c();
        c(bVar);
        if ((this.f2145b instanceof com.google.android.gms.common.internal.w.e) && bVar.g() != 24) {
            this.m.f2084d = true;
            e eVar = this.m;
            eVar.p.sendMessageDelayed(eVar.p.obtainMessage(19), 300000);
        }
        if (bVar.g() == 4) {
            d(e.s);
        } else if (this.f2144a.isEmpty()) {
            this.k = bVar;
        } else if (exc != null) {
            n.c(this.m.p);
            e((Status) null, exc, false);
        } else if (this.m.q) {
            e(e.h(this.f2146c, bVar), (Exception) null, true);
            if (!this.f2144a.isEmpty() && !p(bVar) && !this.m.g(bVar, this.g)) {
                if (bVar.g() == 18) {
                    this.i = true;
                }
                if (this.i) {
                    e eVar2 = this.m;
                    eVar2.p.sendMessageDelayed(Message.obtain(eVar2.p, 9, this.f2146c), this.m.f2081a);
                    return;
                }
                d(e.h(this.f2146c, bVar));
            }
        } else {
            d(e.h(this.f2146c, bVar));
        }
    }

    public final void I(b bVar) {
        n.c(this.m.p);
        a.f fVar = this.f2145b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(bVar);
        fVar.k("onSignInFailed for " + name + " with " + valueOf);
        H(bVar, (Exception) null);
    }

    public final void J(a1 a1Var) {
        n.c(this.m.p);
        this.f2148e.add(a1Var);
    }

    public final void K() {
        n.c(this.m.p);
        if (this.i) {
            E();
        }
    }

    public final void L() {
        n.c(this.m.p);
        d(e.r);
        this.f2147d.d();
        for (h y0Var : (h[]) this.f2149f.keySet().toArray(new h[0])) {
            F(new y0(y0Var, new j()));
        }
        c(new b(4));
        if (this.f2145b.d()) {
            this.f2145b.a(new y(this));
        }
    }

    public final void M() {
        n.c(this.m.p);
        if (this.i) {
            n();
            e eVar = this.m;
            d(eVar.h.g(eVar.g) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f2145b.k("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O() {
        return this.f2145b.d();
    }

    public final boolean P() {
        return this.f2145b.l();
    }

    public final boolean a() {
        return q(true);
    }

    public final void h(b bVar) {
        H(bVar, (Exception) null);
    }

    public final void i(int i2) {
        if (Looper.myLooper() == this.m.p.getLooper()) {
            j(i2);
        } else {
            this.m.p.post(new w(this, i2));
        }
    }

    public final void k(Bundle bundle) {
        if (Looper.myLooper() == this.m.p.getLooper()) {
            g();
        } else {
            this.m.p.post(new v(this));
        }
    }

    public final int r() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final int s() {
        return this.l;
    }

    public final b t() {
        n.c(this.m.p);
        return this.k;
    }

    public final a.f v() {
        return this.f2145b;
    }

    public final Map x() {
        return this.f2149f;
    }
}
