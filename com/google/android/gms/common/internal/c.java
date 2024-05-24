package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class c<T extends IInterface> {
    private static final com.google.android.gms.common.d[] x = new com.google.android.gms.common.d[0];

    /* renamed from: a  reason: collision with root package name */
    private volatile String f2170a;

    /* renamed from: b  reason: collision with root package name */
    n1 f2171b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f2172c;

    /* renamed from: d  reason: collision with root package name */
    private final h f2173d;

    /* renamed from: e  reason: collision with root package name */
    private final f f2174e;

    /* renamed from: f  reason: collision with root package name */
    final Handler f2175f;
    private final Object g;
    /* access modifiers changed from: private */
    public final Object h;
    /* access modifiers changed from: private */
    @GuardedBy("mServiceBrokerLock")
    public k i;
    protected C0071c j;
    @GuardedBy("mLock")
    private IInterface k;
    /* access modifiers changed from: private */
    public final ArrayList l;
    @GuardedBy("mLock")
    private z0 m;
    @GuardedBy("mLock")
    private int n;
    /* access modifiers changed from: private */
    public final a o;
    /* access modifiers changed from: private */
    public final b p;
    private final int q;
    private final String r;
    private volatile String s;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.b t;
    /* access modifiers changed from: private */
    public boolean u;
    private volatile c1 v;
    protected AtomicInteger w;

    public interface a {
        void i(int i);

        void k(Bundle bundle);
    }

    public interface b {
        void h(com.google.android.gms.common.b bVar);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    public interface C0071c {
        void a(com.google.android.gms.common.b bVar);
    }

    protected class d implements C0071c {
        public d() {
        }

        public final void a(com.google.android.gms.common.b bVar) {
            if (bVar.l()) {
                c cVar = c.this;
                cVar.h((i) null, cVar.C());
            } else if (c.this.p != null) {
                c.this.p.h(bVar);
            }
        }
    }

    public interface e {
        void a();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected c(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.c.a r13, com.google.android.gms.common.internal.c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.h r3 = com.google.android.gms.common.internal.h.b(r10)
            com.google.android.gms.common.f r4 = com.google.android.gms.common.f.f()
            com.google.android.gms.common.internal.n.i(r13)
            com.google.android.gms.common.internal.n.i(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.c$a, com.google.android.gms.common.internal.c$b, java.lang.String):void");
    }

    protected c(Context context, Looper looper, h hVar, f fVar, int i2, a aVar, b bVar, String str) {
        this.f2170a = null;
        this.g = new Object();
        this.h = new Object();
        this.l = new ArrayList();
        this.n = 1;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = new AtomicInteger(0);
        n.j(context, "Context must not be null");
        this.f2172c = context;
        n.j(looper, "Looper must not be null");
        n.j(hVar, "Supervisor must not be null");
        this.f2173d = hVar;
        n.j(fVar, "API availability must not be null");
        this.f2174e = fVar;
        this.f2175f = new w0(this, looper);
        this.q = i2;
        this.o = aVar;
        this.p = bVar;
        this.r = str;
    }

    static /* bridge */ /* synthetic */ void c0(c cVar, c1 c1Var) {
        cVar.v = c1Var;
        if (cVar.S()) {
            e eVar = c1Var.m;
            o.b().c(eVar == null ? null : eVar.p());
        }
    }

    static /* bridge */ /* synthetic */ void d0(c cVar, int i2) {
        int i3;
        int i4;
        synchronized (cVar.g) {
            i3 = cVar.n;
        }
        if (i3 == 3) {
            cVar.u = true;
            i4 = 5;
        } else {
            i4 = 4;
        }
        Handler handler = cVar.f2175f;
        handler.sendMessage(handler.obtainMessage(i4, cVar.w.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean g0(c cVar, int i2, int i3, IInterface iInterface) {
        synchronized (cVar.g) {
            if (cVar.n != i2) {
                return false;
            }
            cVar.i0(i3, iInterface);
            return true;
        }
    }

    static /* bridge */ /* synthetic */ boolean h0(c cVar) {
        if (cVar.u || TextUtils.isEmpty(cVar.E()) || TextUtils.isEmpty(cVar.B())) {
            return false;
        }
        try {
            Class.forName(cVar.E());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void i0(int i2, IInterface iInterface) {
        n1 n1Var;
        boolean z = false;
        if ((i2 == 4) == (iInterface != null)) {
            z = true;
        }
        n.a(z);
        synchronized (this.g) {
            this.n = i2;
            this.k = iInterface;
            if (i2 == 1) {
                z0 z0Var = this.m;
                if (z0Var != null) {
                    h hVar = this.f2173d;
                    String c2 = this.f2171b.c();
                    n.i(c2);
                    hVar.e(c2, this.f2171b.b(), this.f2171b.a(), z0Var, X(), this.f2171b.d());
                    this.m = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                z0 z0Var2 = this.m;
                if (!(z0Var2 == null || (n1Var = this.f2171b) == null)) {
                    String c3 = n1Var.c();
                    String b2 = n1Var.b();
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + c3 + " on " + b2);
                    h hVar2 = this.f2173d;
                    String c4 = this.f2171b.c();
                    n.i(c4);
                    hVar2.e(c4, this.f2171b.b(), this.f2171b.a(), z0Var2, X(), this.f2171b.d());
                    this.w.incrementAndGet();
                }
                z0 z0Var3 = new z0(this, this.w.get());
                this.m = z0Var3;
                n1 n1Var2 = (this.n != 3 || B() == null) ? new n1(G(), F(), false, h.a(), I()) : new n1(y().getPackageName(), B(), true, h.a(), false);
                this.f2171b = n1Var2;
                if (n1Var2.d()) {
                    if (p() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f2171b.c())));
                    }
                }
                h hVar3 = this.f2173d;
                String c5 = this.f2171b.c();
                n.i(c5);
                if (!hVar3.f(new g1(c5, this.f2171b.b(), this.f2171b.a(), this.f2171b.d()), z0Var3, X(), w())) {
                    String c6 = this.f2171b.c();
                    String b3 = this.f2171b.b();
                    Log.w("GmsClient", "unable to connect to service: " + c6 + " on " + b3);
                    e0(16, (Bundle) null, this.w.get());
                }
            } else if (i2 == 4) {
                n.i(iInterface);
                K(iInterface);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Bundle A() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public String B() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> C() {
        return Collections.emptySet();
    }

    public final T D() {
        T t2;
        synchronized (this.g) {
            if (this.n != 5) {
                r();
                t2 = this.k;
                n.j(t2, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public abstract String E();

    /* access modifiers changed from: protected */
    public abstract String F();

    /* access modifiers changed from: protected */
    public String G() {
        return "com.google.android.gms";
    }

    public e H() {
        c1 c1Var = this.v;
        if (c1Var == null) {
            return null;
        }
        return c1Var.m;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        return p() >= 211700000;
    }

    public boolean J() {
        return this.v != null;
    }

    /* access modifiers changed from: protected */
    public void K(T t2) {
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void L(com.google.android.gms.common.b bVar) {
        bVar.g();
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void M(int i2) {
        System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void N(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f2175f;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new a1(this, i2, iBinder, bundle)));
    }

    public boolean O() {
        return false;
    }

    public void P(String str) {
        this.s = str;
    }

    public void Q(int i2) {
        Handler handler = this.f2175f;
        handler.sendMessage(handler.obtainMessage(6, this.w.get(), i2));
    }

    /* access modifiers changed from: protected */
    public void R(C0071c cVar, int i2, PendingIntent pendingIntent) {
        n.j(cVar, "Connection progress callbacks cannot be null.");
        this.j = cVar;
        Handler handler = this.f2175f;
        handler.sendMessage(handler.obtainMessage(3, this.w.get(), i2, pendingIntent));
    }

    public boolean S() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final String X() {
        String str = this.r;
        return str == null ? this.f2172c.getClass().getName() : str;
    }

    public void a(e eVar) {
        eVar.a();
    }

    public boolean b() {
        boolean z;
        synchronized (this.g) {
            int i2 = this.n;
            z = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    z = false;
                }
            }
        }
        return z;
    }

    public final com.google.android.gms.common.d[] c() {
        c1 c1Var = this.v;
        if (c1Var == null) {
            return null;
        }
        return c1Var.k;
    }

    public boolean d() {
        boolean z;
        synchronized (this.g) {
            z = this.n == 4;
        }
        return z;
    }

    public String e() {
        n1 n1Var;
        if (d() && (n1Var = this.f2171b) != null) {
            return n1Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    /* access modifiers changed from: protected */
    public final void e0(int i2, Bundle bundle, int i3) {
        Handler handler = this.f2175f;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new b1(this, i2, (Bundle) null)));
    }

    public String f() {
        return this.f2170a;
    }

    public void h(i iVar, Set<Scope> set) {
        Set<Scope> set2 = set;
        Bundle A = A();
        int i2 = this.q;
        String str = this.s;
        int i3 = f.f2160a;
        Scope[] scopeArr = f.x;
        Bundle bundle = new Bundle();
        com.google.android.gms.common.d[] dVarArr = f.y;
        f fVar = r3;
        f fVar2 = new f(6, i2, i3, (String) null, (IBinder) null, scopeArr, bundle, (Account) null, dVarArr, dVarArr, true, 0, false, str);
        f fVar3 = fVar;
        fVar3.m = this.f2172c.getPackageName();
        fVar3.p = A;
        if (set2 != null) {
            fVar3.o = (Scope[]) set2.toArray(new Scope[0]);
        }
        if (l()) {
            Account u2 = u();
            if (u2 == null) {
                u2 = new Account("<<default account>>", "com.google");
            }
            fVar3.q = u2;
            if (iVar != null) {
                fVar3.n = iVar.asBinder();
            }
        } else if (O()) {
            fVar3.q = u();
        }
        fVar3.r = x;
        fVar3.s = v();
        if (S()) {
            fVar3.v = true;
        }
        try {
            synchronized (this.h) {
                k kVar = this.i;
                if (kVar != null) {
                    kVar.P(new y0(this, this.w.get()), fVar3);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Q(3);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            N(8, (IBinder) null, (Bundle) null, this.w.get());
        }
    }

    public void i(C0071c cVar) {
        n.j(cVar, "Connection progress callbacks cannot be null.");
        this.j = cVar;
        i0(2, (IInterface) null);
    }

    public void j() {
        this.w.incrementAndGet();
        synchronized (this.l) {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((x0) this.l.get(i2)).d();
            }
            this.l.clear();
        }
        synchronized (this.h) {
            this.i = null;
        }
        i0(1, (IInterface) null);
    }

    public void k(String str) {
        this.f2170a = str;
        j();
    }

    public boolean l() {
        return false;
    }

    public boolean n() {
        return true;
    }

    public int p() {
        return f.f2160a;
    }

    public void q() {
        int h2 = this.f2174e.h(this.f2172c, p());
        if (h2 != 0) {
            i0(1, (IInterface) null);
            R(new d(), h2, (PendingIntent) null);
            return;
        }
        i(new d());
    }

    /* access modifiers changed from: protected */
    public final void r() {
        if (!d()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract T s(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean t() {
        return false;
    }

    public Account u() {
        return null;
    }

    public com.google.android.gms.common.d[] v() {
        return x;
    }

    /* access modifiers changed from: protected */
    public Executor w() {
        return null;
    }

    public Bundle x() {
        return null;
    }

    public final Context y() {
        return this.f2172c;
    }

    public int z() {
        return this.q;
    }
}
