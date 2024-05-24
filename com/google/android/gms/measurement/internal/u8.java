package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import c.d.a.b.e.e.i1;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.m.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class u8 extends f4 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final t8 f2567c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b3 f2568d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f2569e;

    /* renamed from: f  reason: collision with root package name */
    private final q f2570f;
    private final m9 g;
    private final List h = new ArrayList();
    private final q i;

    protected u8(x4 x4Var) {
        super(x4Var);
        this.g = new m9(x4Var.a());
        this.f2567c = new t8(this);
        this.f2570f = new d8(this, x4Var);
        this.i = new f8(this, x4Var);
    }

    private final qa C(boolean z) {
        Pair a2;
        this.f2527a.e();
        c3 B = this.f2527a.B();
        String str = null;
        if (z) {
            m3 f2 = this.f2527a.f();
            if (!(f2.f2527a.F().f2316d == null || (a2 = f2.f2527a.F().f2316d.a()) == null || a2 == b4.y)) {
                str = String.valueOf(a2.second) + ":" + ((String) a2.first);
            }
        }
        return B.q(str);
    }

    /* access modifiers changed from: private */
    public final void D() {
        h();
        this.f2527a.f().v().b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        for (Runnable run : this.h) {
            try {
                run.run();
            } catch (RuntimeException e2) {
                this.f2527a.f().r().b("Task exception while flushing queue", e2);
            }
        }
        this.h.clear();
        this.i.b();
    }

    /* access modifiers changed from: private */
    public final void E() {
        h();
        this.g.b();
        q qVar = this.f2570f;
        this.f2527a.z();
        qVar.d(((Long) y2.J.a((Object) null)).longValue());
    }

    private final void F(Runnable runnable) {
        h();
        if (z()) {
            runnable.run();
            return;
        }
        int size = this.h.size();
        this.f2527a.z();
        if (((long) size) >= 1000) {
            this.f2527a.f().r().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.h.add(runnable);
        this.i.d(60000);
        P();
    }

    private final boolean G() {
        this.f2527a.e();
        return true;
    }

    static /* bridge */ /* synthetic */ void M(u8 u8Var, ComponentName componentName) {
        u8Var.h();
        if (u8Var.f2568d != null) {
            u8Var.f2568d = null;
            u8Var.f2527a.f().v().b("Disconnected from device MeasurementService", componentName);
            u8Var.h();
            u8Var.P();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean A() {
        h();
        i();
        return !B() || this.f2527a.N().o0() >= ((Integer) y2.f0.a((Object) null)).intValue();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean B() {
        /*
            r6 = this;
            r6.h()
            r6.i()
            java.lang.Boolean r0 = r6.f2569e
            if (r0 != 0) goto L_0x0143
            r6.h()
            r6.i()
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.b4 r0 = r0.F()
            r0.h()
            android.content.SharedPreferences r1 = r0.o()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r0 = r0.o()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0034:
            r1 = 1
            if (r0 == 0) goto L_0x003f
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x003f
            goto L_0x013d
        L_0x003f:
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            r4.e()
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            com.google.android.gms.measurement.internal.c3 r4 = r4.B()
            int r4 = r4.o()
            if (r4 != r1) goto L_0x0053
        L_0x0050:
            r3 = 1
            goto L_0x0105
        L_0x0053:
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.v()
            java.lang.String r5 = "Checking service availability"
            r4.a(r5)
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            com.google.android.gms.measurement.internal.la r4 = r4.N()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.p0(r5)
            if (r4 == 0) goto L_0x00f4
            if (r4 == r1) goto L_0x00e4
            r5 = 2
            if (r4 == r5) goto L_0x00c0
            r0 = 3
            if (r4 == r0) goto L_0x00af
            r0 = 9
            if (r4 == r0) goto L_0x00a2
            r0 = 18
            if (r4 == r0) goto L_0x0095
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.b(r4, r1)
            goto L_0x00be
        L_0x0095:
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.String r3 = "Service updating"
            goto L_0x0100
        L_0x00a2:
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.String r1 = "Service invalid"
            goto L_0x00bb
        L_0x00af:
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.String r1 = "Service disabled"
        L_0x00bb:
            r0.a(r1)
        L_0x00be:
            r1 = 0
            goto L_0x0105
        L_0x00c0:
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.q()
            java.lang.String r5 = "Service container out of date"
            r4.a(r5)
            com.google.android.gms.measurement.internal.x4 r4 = r6.f2527a
            com.google.android.gms.measurement.internal.la r4 = r4.N()
            int r4 = r4.o0()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00de
            goto L_0x0105
        L_0x00de:
            if (r0 != 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r1 = 0
        L_0x00e2:
            r3 = r1
            goto L_0x00be
        L_0x00e4:
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            java.lang.String r4 = "Service missing"
            r0.a(r4)
            goto L_0x0105
        L_0x00f4:
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            java.lang.String r3 = "Service available"
        L_0x0100:
            r0.a(r3)
            goto L_0x0050
        L_0x0105:
            if (r3 != 0) goto L_0x0123
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            boolean r0 = r0.G()
            if (r0 == 0) goto L_0x0123
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r1)
            goto L_0x013c
        L_0x0123:
            if (r1 == 0) goto L_0x013c
            com.google.android.gms.measurement.internal.x4 r0 = r6.f2527a
            com.google.android.gms.measurement.internal.b4 r0 = r0.F()
            r0.h()
            android.content.SharedPreferences r0 = r0.o()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x013c:
            r1 = r3
        L_0x013d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6.f2569e = r0
        L_0x0143:
            java.lang.Boolean r0 = r6.f2569e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u8.B():boolean");
    }

    /* access modifiers changed from: package-private */
    public final Boolean J() {
        return this.f2569e;
    }

    /* access modifiers changed from: protected */
    public final void O() {
        h();
        i();
        qa C = C(true);
        this.f2527a.C().r();
        F(new a8(this, C));
    }

    /* access modifiers changed from: package-private */
    public final void P() {
        h();
        i();
        if (!z()) {
            if (B()) {
                this.f2567c.c();
            } else if (!this.f2527a.z().G()) {
                this.f2527a.e();
                List<ResolveInfo> queryIntentServices = this.f2527a.d().getPackageManager().queryIntentServices(new Intent().setClassName(this.f2527a.d(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    this.f2527a.f().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context d2 = this.f2527a.d();
                this.f2527a.e();
                intent.setComponent(new ComponentName(d2, "com.google.android.gms.measurement.AppMeasurementService"));
                this.f2567c.b(intent);
            }
        }
    }

    public final void Q() {
        h();
        i();
        this.f2567c.d();
        try {
            a.b().c(this.f2527a.d(), this.f2567c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f2568d = null;
    }

    public final void R(i1 i1Var) {
        h();
        i();
        F(new z7(this, C(false), i1Var));
    }

    public final void S(AtomicReference atomicReference) {
        h();
        i();
        F(new y7(this, atomicReference, C(false)));
    }

    /* access modifiers changed from: protected */
    public final void T(i1 i1Var, String str, String str2) {
        h();
        i();
        F(new m8(this, str, str2, C(false), i1Var));
    }

    /* access modifiers changed from: protected */
    public final void U(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        i();
        F(new l8(this, atomicReference, (String) null, str2, str3, C(false)));
    }

    /* access modifiers changed from: protected */
    public final void V(i1 i1Var, String str, String str2, boolean z) {
        h();
        i();
        F(new v7(this, str, str2, C(false), z, i1Var));
    }

    /* access modifiers changed from: protected */
    public final void W(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        h();
        i();
        F(new n8(this, atomicReference, (String) null, str2, str3, C(false), z));
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void o(x xVar, String str) {
        n.i(xVar);
        h();
        i();
        G();
        F(new j8(this, true, C(true), this.f2527a.C().v(xVar), xVar, str));
    }

    public final void p(i1 i1Var, x xVar, String str) {
        h();
        i();
        if (this.f2527a.N().p0(i.f2162a) != 0) {
            this.f2527a.f().w().a("Not bundling data. Service unavailable or out of date");
            this.f2527a.N().G(i1Var, new byte[0]);
            return;
        }
        F(new e8(this, xVar, str, i1Var));
    }

    /* access modifiers changed from: protected */
    public final void q() {
        h();
        i();
        qa C = C(false);
        G();
        this.f2527a.C().q();
        F(new x7(this, C));
    }

    /* access modifiers changed from: package-private */
    public final void r(b3 b3Var, com.google.android.gms.common.internal.v.a aVar, qa qaVar) {
        int i2;
        int i3;
        k3 r;
        String str;
        h();
        i();
        G();
        this.f2527a.z();
        int i4 = 0;
        int i5 = 100;
        while (i4 < 1001 && i5 == 100) {
            ArrayList arrayList = new ArrayList();
            List p = this.f2527a.C().p(100);
            if (p != null) {
                arrayList.addAll(p);
                i2 = p.size();
            } else {
                i2 = 0;
            }
            if (aVar != null && i2 < 100) {
                arrayList.add(aVar);
            }
            int size = arrayList.size();
            for (i3 = 0; i3 < size; i3++) {
                com.google.android.gms.common.internal.v.a aVar2 = (com.google.android.gms.common.internal.v.a) arrayList.get(i3);
                if (aVar2 instanceof x) {
                    try {
                        b3Var.O((x) aVar2, qaVar);
                    } catch (RemoteException e2) {
                        e = e2;
                        r = this.f2527a.f().r();
                        str = "Failed to send event to the service";
                    }
                } else if (aVar2 instanceof fa) {
                    try {
                        b3Var.v((fa) aVar2, qaVar);
                    } catch (RemoteException e3) {
                        e = e3;
                        r = this.f2527a.f().r();
                        str = "Failed to send user property to the service";
                    }
                } else if (aVar2 instanceof d) {
                    try {
                        b3Var.y((d) aVar2, qaVar);
                    } catch (RemoteException e4) {
                        e = e4;
                        r = this.f2527a.f().r();
                        str = "Failed to send conditional user property to the service";
                    }
                } else {
                    this.f2527a.f().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i4++;
            i5 = i2;
        }
        return;
        r.b(str, e);
    }

    /* access modifiers changed from: protected */
    public final void s(d dVar) {
        n.i(dVar);
        h();
        i();
        this.f2527a.e();
        F(new k8(this, true, C(true), this.f2527a.C().u(dVar), new d(dVar), dVar));
    }

    /* access modifiers changed from: protected */
    public final void t(boolean z) {
        h();
        i();
        if (z) {
            G();
            this.f2527a.C().q();
        }
        if (A()) {
            F(new i8(this, C(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final void u(m7 m7Var) {
        h();
        i();
        F(new b8(this, m7Var));
    }

    public final void v(Bundle bundle) {
        h();
        i();
        F(new c8(this, C(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void w() {
        h();
        i();
        F(new g8(this, C(true)));
    }

    /* access modifiers changed from: protected */
    public final void x(b3 b3Var) {
        h();
        n.i(b3Var);
        this.f2568d = b3Var;
        E();
        D();
    }

    /* access modifiers changed from: protected */
    public final void y(fa faVar) {
        h();
        i();
        G();
        F(new w7(this, C(true), this.f2527a.C().w(faVar), faVar));
    }

    public final boolean z() {
        h();
        i();
        return this.f2568d != null;
    }
}
