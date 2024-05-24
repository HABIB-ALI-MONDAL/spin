package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b.c.b;
import c.d.a.b.e.b.j;
import c.d.a.b.h.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.h0;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class e implements Handler.Callback {
    public static final Status r = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status s = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */
    public static final Object t = new Object();
    @GuardedBy("lock")
    private static e u;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f2081a = 5000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f2082b = 120000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f2083c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f2084d = false;

    /* renamed from: e  reason: collision with root package name */
    private r f2085e;

    /* renamed from: f  reason: collision with root package name */
    private t f2086f;
    /* access modifiers changed from: private */
    public final Context g;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.e h;
    /* access modifiers changed from: private */
    public final h0 i;
    private final AtomicInteger j = new AtomicInteger(1);
    private final AtomicInteger k = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map l = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public r m = null;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final Set n = new b();
    private final Set o = new b();
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public final Handler p;
    /* access modifiers changed from: private */
    public volatile boolean q = true;

    private e(Context context, Looper looper, com.google.android.gms.common.e eVar) {
        this.g = context;
        j jVar = new j(looper, this);
        this.p = jVar;
        this.h = eVar;
        this.i = new h0(eVar);
        if (h.a(context)) {
            this.q = false;
        }
        jVar.sendMessage(jVar.obtainMessage(6));
    }

    /* access modifiers changed from: private */
    public static Status h(b bVar, com.google.android.gms.common.b bVar2) {
        String b2 = bVar.b();
        String valueOf = String.valueOf(bVar2);
        return new Status(bVar2, "API: " + b2 + " is not available on this device. Connection failed with: " + valueOf);
    }

    private final z i(com.google.android.gms.common.api.e eVar) {
        b d2 = eVar.d();
        z zVar = (z) this.l.get(d2);
        if (zVar == null) {
            zVar = new z(this, eVar);
            this.l.put(d2, zVar);
        }
        if (zVar.P()) {
            this.o.add(d2);
        }
        zVar.E();
        return zVar;
    }

    private final t j() {
        if (this.f2086f == null) {
            this.f2086f = s.a(this.g);
        }
        return this.f2086f;
    }

    private final void k() {
        r rVar = this.f2085e;
        if (rVar != null) {
            if (rVar.g() > 0 || f()) {
                j().a(rVar);
            }
            this.f2085e = null;
        }
    }

    private final void l(c.d.a.b.h.j jVar, int i2, com.google.android.gms.common.api.e eVar) {
        i0 b2;
        if (i2 != 0 && (b2 = i0.b(this, i2, eVar.d())) != null) {
            i a2 = jVar.a();
            Handler handler = this.p;
            handler.getClass();
            a2.c(new t(handler), b2);
        }
    }

    public static e x(Context context) {
        e eVar;
        synchronized (t) {
            if (u == null) {
                u = new e(context.getApplicationContext(), com.google.android.gms.common.internal.h.c().getLooper(), com.google.android.gms.common.e.n());
            }
            eVar = u;
        }
        return eVar;
    }

    public final void D(com.google.android.gms.common.api.e eVar, int i2, n nVar, c.d.a.b.h.j jVar, m mVar) {
        l(jVar, nVar.d(), eVar);
        x0 x0Var = new x0(i2, nVar, jVar, mVar);
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(4, new m0(x0Var, this.k.get(), eVar)));
    }

    /* access modifiers changed from: package-private */
    public final void E(l lVar, int i2, long j2, int i3) {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(18, new j0(lVar, i2, j2, i3)));
    }

    public final void F(com.google.android.gms.common.b bVar, int i2) {
        if (!g(bVar, i2)) {
            Handler handler = this.p;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, bVar));
        }
    }

    public final void a() {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void b(com.google.android.gms.common.api.e eVar) {
        Handler handler = this.p;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void c(r rVar) {
        synchronized (t) {
            if (this.m != rVar) {
                this.m = rVar;
                this.n.clear();
            }
            this.n.addAll(rVar.t());
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(r rVar) {
        synchronized (t) {
            if (this.m == rVar) {
                this.m = null;
                this.n.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        if (this.f2084d) {
            return false;
        }
        p a2 = o.b().a();
        if (a2 != null && !a2.j()) {
            return false;
        }
        int a3 = this.i.a(this.g, 203400000);
        return a3 == -1 || a3 == 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean g(com.google.android.gms.common.b bVar, int i2) {
        return this.h.y(this.g, bVar, i2);
    }

    public final boolean handleMessage(Message message) {
        c.d.a.b.h.j jVar;
        Boolean bool;
        int i2 = message.what;
        long j2 = 300000;
        z zVar = null;
        switch (i2) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f2083c = j2;
                this.p.removeMessages(12);
                for (b obtainMessage : this.l.keySet()) {
                    Handler handler = this.p;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f2083c);
                }
                break;
            case 2:
                a1 a1Var = (a1) message.obj;
                Iterator it = a1Var.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        b bVar = (b) it.next();
                        z zVar2 = (z) this.l.get(bVar);
                        if (zVar2 == null) {
                            a1Var.b(bVar, new com.google.android.gms.common.b(13), (String) null);
                            break;
                        } else if (zVar2.O()) {
                            a1Var.b(bVar, com.google.android.gms.common.b.n, zVar2.v().e());
                        } else {
                            com.google.android.gms.common.b t2 = zVar2.t();
                            if (t2 != null) {
                                a1Var.b(bVar, t2, (String) null);
                            } else {
                                zVar2.J(a1Var);
                                zVar2.E();
                            }
                        }
                    }
                }
            case 3:
                for (z zVar3 : this.l.values()) {
                    zVar3.D();
                    zVar3.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                m0 m0Var = (m0) message.obj;
                z zVar4 = (z) this.l.get(m0Var.f2110c.d());
                if (zVar4 == null) {
                    zVar4 = i(m0Var.f2110c);
                }
                if (zVar4.P() && this.k.get() != m0Var.f2109b) {
                    m0Var.f2108a.a(r);
                    zVar4.L();
                    break;
                } else {
                    zVar4.F(m0Var.f2108a);
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                com.google.android.gms.common.b bVar2 = (com.google.android.gms.common.b) message.obj;
                Iterator it2 = this.l.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        z zVar5 = (z) it2.next();
                        if (zVar5.r() == i3) {
                            zVar = zVar5;
                        }
                    }
                }
                if (zVar != null) {
                    if (bVar2.g() != 13) {
                        zVar.d(h(zVar.f2146c, bVar2));
                        break;
                    } else {
                        String e2 = this.h.e(bVar2.g());
                        String i4 = bVar2.i();
                        zVar.d(new Status(17, "Error resolution was canceled by the user, original error message: " + e2 + ": " + i4));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i3 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.g.getApplicationContext() instanceof Application) {
                    c.c((Application) this.g.getApplicationContext());
                    c.b().a(new u(this));
                    if (!c.b().e(true)) {
                        this.f2083c = 300000;
                        break;
                    }
                }
                break;
            case 7:
                i((com.google.android.gms.common.api.e) message.obj);
                break;
            case 9:
                if (this.l.containsKey(message.obj)) {
                    ((z) this.l.get(message.obj)).K();
                    break;
                }
                break;
            case 10:
                for (b remove : this.o) {
                    z zVar6 = (z) this.l.remove(remove);
                    if (zVar6 != null) {
                        zVar6.L();
                    }
                }
                this.o.clear();
                break;
            case 11:
                if (this.l.containsKey(message.obj)) {
                    ((z) this.l.get(message.obj)).M();
                    break;
                }
                break;
            case 12:
                if (this.l.containsKey(message.obj)) {
                    ((z) this.l.get(message.obj)).a();
                    break;
                }
                break;
            case 14:
                s sVar = (s) message.obj;
                b a2 = sVar.a();
                if (!this.l.containsKey(a2)) {
                    jVar = sVar.b();
                    bool = Boolean.FALSE;
                } else {
                    boolean N = ((z) this.l.get(a2)).q(false);
                    jVar = sVar.b();
                    bool = Boolean.valueOf(N);
                }
                jVar.c(bool);
                break;
            case 15:
                b0 b0Var = (b0) message.obj;
                if (this.l.containsKey(b0Var.f2069a)) {
                    z.B((z) this.l.get(b0Var.f2069a), b0Var);
                    break;
                }
                break;
            case 16:
                b0 b0Var2 = (b0) message.obj;
                if (this.l.containsKey(b0Var2.f2069a)) {
                    z.C((z) this.l.get(b0Var2.f2069a), b0Var2);
                    break;
                }
                break;
            case 17:
                k();
                break;
            case 18:
                j0 j0Var = (j0) message.obj;
                if (j0Var.f2106c != 0) {
                    r rVar = this.f2085e;
                    if (rVar != null) {
                        List i5 = rVar.i();
                        if (rVar.g() != j0Var.f2105b || (i5 != null && i5.size() >= j0Var.f2107d)) {
                            this.p.removeMessages(17);
                            k();
                        } else {
                            this.f2085e.j(j0Var.f2104a);
                        }
                    }
                    if (this.f2085e == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(j0Var.f2104a);
                        this.f2085e = new r(j0Var.f2105b, arrayList);
                        Handler handler2 = this.p;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), j0Var.f2106c);
                        break;
                    }
                } else {
                    j().a(new r(j0Var.f2105b, Arrays.asList(new l[]{j0Var.f2104a})));
                    break;
                }
                break;
            case 19:
                this.f2084d = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i2);
                return false;
        }
        return true;
    }

    public final int m() {
        return this.j.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final z w(b bVar) {
        return (z) this.l.get(bVar);
    }
}
