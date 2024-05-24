package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class u7 extends f4 {

    /* renamed from: c  reason: collision with root package name */
    private volatile m7 f2563c;

    /* renamed from: d  reason: collision with root package name */
    private volatile m7 f2564d;

    /* renamed from: e  reason: collision with root package name */
    protected m7 f2565e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f2566f = new ConcurrentHashMap();
    private Activity g;
    private volatile boolean h;
    private volatile m7 i;
    /* access modifiers changed from: private */
    public m7 j;
    private boolean k;
    private final Object l = new Object();

    public u7(x4 x4Var) {
        super(x4Var);
    }

    private final m7 F(Activity activity) {
        n.i(activity);
        m7 m7Var = (m7) this.f2566f.get(activity);
        if (m7Var == null) {
            m7 m7Var2 = new m7((String) null, t(activity.getClass(), "Activity"), this.f2527a.N().r0());
            this.f2566f.put(activity, m7Var2);
            m7Var = m7Var2;
        }
        return this.i != null ? this.i : m7Var;
    }

    private final void G(Activity activity, m7 m7Var, boolean z) {
        m7 m7Var2;
        m7 m7Var3 = m7Var;
        m7 m7Var4 = this.f2563c == null ? this.f2564d : this.f2563c;
        if (m7Var3.f2467b == null) {
            m7Var2 = new m7(m7Var3.f2466a, activity != null ? t(activity.getClass(), "Activity") : null, m7Var3.f2468c, m7Var3.f2470e, m7Var3.f2471f);
        } else {
            m7Var2 = m7Var3;
        }
        this.f2564d = this.f2563c;
        this.f2563c = m7Var2;
        this.f2527a.c().z(new p7(this, m7Var2, m7Var4, this.f2527a.a().b(), z));
    }

    /* access modifiers changed from: private */
    public final void o(m7 m7Var, m7 m7Var2, long j2, boolean z, Bundle bundle) {
        Bundle bundle2;
        long j3;
        m7 m7Var3 = m7Var;
        m7 m7Var4 = m7Var2;
        long j4 = j2;
        Bundle bundle3 = bundle;
        h();
        boolean z2 = false;
        boolean z3 = m7Var4 == null || m7Var4.f2468c != m7Var3.f2468c || !n7.a(m7Var4.f2467b, m7Var3.f2467b) || !n7.a(m7Var4.f2466a, m7Var3.f2466a);
        if (z && this.f2565e != null) {
            z2 = true;
        }
        if (z3) {
            if (bundle3 == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            la.y(m7Var3, bundle4, true);
            if (m7Var4 != null) {
                String str = m7Var4.f2466a;
                if (str != null) {
                    bundle4.putString("_pn", str);
                }
                String str2 = m7Var4.f2467b;
                if (str2 != null) {
                    bundle4.putString("_pc", str2);
                }
                bundle4.putLong("_pi", m7Var4.f2468c);
            }
            if (z2) {
                j9 j9Var = this.f2527a.M().f2453e;
                long j5 = j4 - j9Var.f2422b;
                j9Var.f2422b = j4;
                if (j5 > 0) {
                    this.f2527a.N().w(bundle4, j5);
                }
            }
            if (!this.f2527a.z().D()) {
                bundle4.putLong("_mst", 1);
            }
            String str3 = true != m7Var3.f2470e ? "auto" : "app";
            long a2 = this.f2527a.a().a();
            if (m7Var3.f2470e) {
                long j6 = m7Var3.f2471f;
                if (j6 != 0) {
                    j3 = j6;
                    this.f2527a.I().v(str3, "_vs", j3, bundle4);
                }
            }
            j3 = a2;
            this.f2527a.I().v(str3, "_vs", j3, bundle4);
        }
        if (z2) {
            p(this.f2565e, true, j4);
        }
        this.f2565e = m7Var3;
        if (m7Var3.f2470e) {
            this.j = m7Var3;
        }
        this.f2527a.L().u(m7Var3);
    }

    /* access modifiers changed from: private */
    public final void p(m7 m7Var, boolean z, long j2) {
        this.f2527a.y().n(this.f2527a.a().b());
        if (this.f2527a.M().f2453e.d(m7Var != null && m7Var.f2469d, z, j2) && m7Var != null) {
            m7Var.f2469d = false;
        }
    }

    static /* bridge */ /* synthetic */ void w(u7 u7Var, Bundle bundle, m7 m7Var, m7 m7Var2, long j2) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        u7Var.o(m7Var, m7Var2, j2, true, u7Var.f2527a.N().v0((String) null, "screen_view", bundle, (List) null, false));
    }

    public final void A(Activity activity) {
        synchronized (this.l) {
            this.k = false;
            this.h = true;
        }
        long b2 = this.f2527a.a().b();
        if (!this.f2527a.z().D()) {
            this.f2563c = null;
            this.f2527a.c().z(new r7(this, b2));
            return;
        }
        m7 F = F(activity);
        this.f2564d = this.f2563c;
        this.f2563c = null;
        this.f2527a.c().z(new s7(this, F, b2));
    }

    public final void B(Activity activity) {
        synchronized (this.l) {
            this.k = true;
            if (activity != this.g) {
                synchronized (this.l) {
                    this.g = activity;
                    this.h = false;
                }
                if (this.f2527a.z().D()) {
                    this.i = null;
                    this.f2527a.c().z(new t7(this));
                }
            }
        }
        if (!this.f2527a.z().D()) {
            this.f2563c = this.i;
            this.f2527a.c().z(new q7(this));
            return;
        }
        G(activity, F(activity), false);
        d2 y = this.f2527a.y();
        y.f2527a.c().z(new c1(y, y.f2527a.a().b()));
    }

    public final void C(Activity activity, Bundle bundle) {
        m7 m7Var;
        if (this.f2527a.z().D() && bundle != null && (m7Var = (m7) this.f2566f.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", m7Var.f2468c);
            bundle2.putString("name", m7Var.f2466a);
            bundle2.putString("referrer_name", m7Var.f2467b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r5.length() <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r6.length() <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            boolean r0 = r0.D()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.a(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.m7 r0 = r3.f2563c
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.a(r5)
            return
        L_0x0030:
            java.util.Map r1 = r3.f2566f
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.a(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.t(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.f2467b
            boolean r1 = com.google.android.gms.measurement.internal.n7.a(r1, r6)
            java.lang.String r0 = r0.f2466a
            boolean r0 = com.google.android.gms.measurement.internal.n7.a(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.a(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            com.google.android.gms.measurement.internal.x4 r1 = r3.f2527a
            r1.z()
            int r1 = r5.length()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.x4 r1 = r3.f2527a
            r1.z()
            int r1 = r6.length()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.x()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.b(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.c(r2, r1, r6)
            com.google.android.gms.measurement.internal.m7 r0 = new com.google.android.gms.measurement.internal.m7
            com.google.android.gms.measurement.internal.x4 r1 = r3.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            long r1 = r1.r0()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.f2566f
            r5.put(r4, r0)
            r5 = 1
            r3.G(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u7.D(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r2 > 100) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r4 > 100) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c1, code lost:
        r0 = r12.f2527a.f().v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        if (r3 != null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        if (r4 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r0.c("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r12.f2563c != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r0 = r12.f2564d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e3, code lost:
        r0 = r12.f2563c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        r2 = new com.google.android.gms.measurement.internal.m7(r3, r4, r12.f2527a.N().r0(), true, r14);
        r12.f2563c = r2;
        r12.f2564d = r0;
        r12.i = r2;
        r12.f2527a.c().z(new com.google.android.gms.measurement.internal.o7(r12, r13, r2, r0, r12.f2527a.a().b()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.l
            monitor-enter(r0)
            boolean r1 = r12.k     // Catch:{ all -> 0x011b }
            if (r1 != 0) goto L_0x0018
            com.google.android.gms.measurement.internal.x4 r13 = r12.f2527a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.k3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.a(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x0018:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x011b }
            r1 = 100
            if (r3 == 0) goto L_0x004c
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            if (r2 <= 0) goto L_0x0033
            int r2 = r3.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.x4 r4 = r12.f2527a     // Catch:{ all -> 0x011b }
            r4.z()     // Catch:{ all -> 0x011b }
            if (r2 <= r1) goto L_0x004c
        L_0x0033:
            com.google.android.gms.measurement.internal.x4 r13 = r12.f2527a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.k3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.b(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x004c:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x007e
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            if (r4 <= 0) goto L_0x0065
            int r4 = r2.length()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.x4 r5 = r12.f2527a     // Catch:{ all -> 0x011b }
            r5.z()     // Catch:{ all -> 0x011b }
            if (r4 <= r1) goto L_0x007e
        L_0x0065:
            com.google.android.gms.measurement.internal.x4 r13 = r12.f2527a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.k3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x011b }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x011b }
            r13.b(r14, r15)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x007e:
            if (r2 != 0) goto L_0x0093
            android.app.Activity r1 = r12.g     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x008f
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.t(r1, r2)     // Catch:{ all -> 0x011b }
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = "Activity"
        L_0x0091:
            r4 = r1
            goto L_0x0094
        L_0x0093:
            r4 = r2
        L_0x0094:
            com.google.android.gms.measurement.internal.m7 r1 = r12.f2563c     // Catch:{ all -> 0x011b }
            boolean r2 = r12.h     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            r2 = 0
            r12.h = r2     // Catch:{ all -> 0x011b }
            java.lang.String r2 = r1.f2467b     // Catch:{ all -> 0x011b }
            boolean r2 = com.google.android.gms.measurement.internal.n7.a(r2, r4)     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.f2466a     // Catch:{ all -> 0x011b }
            boolean r1 = com.google.android.gms.measurement.internal.n7.a(r1, r3)     // Catch:{ all -> 0x011b }
            if (r2 == 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.x4 r13 = r12.f2527a     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.k3 r13 = r13.x()     // Catch:{ all -> 0x011b }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.a(r14)     // Catch:{ all -> 0x011b }
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            return
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            com.google.android.gms.measurement.internal.x4 r0 = r12.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            if (r3 != 0) goto L_0x00d0
            java.lang.String r1 = "null"
            goto L_0x00d1
        L_0x00d0:
            r1 = r3
        L_0x00d1:
            if (r4 != 0) goto L_0x00d6
            java.lang.String r2 = "null"
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.c(r5, r1, r2)
            com.google.android.gms.measurement.internal.m7 r0 = r12.f2563c
            if (r0 != 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.m7 r0 = r12.f2564d
            goto L_0x00e5
        L_0x00e3:
            com.google.android.gms.measurement.internal.m7 r0 = r12.f2563c
        L_0x00e5:
            com.google.android.gms.measurement.internal.m7 r1 = new com.google.android.gms.measurement.internal.m7
            com.google.android.gms.measurement.internal.x4 r2 = r12.f2527a
            com.google.android.gms.measurement.internal.la r2 = r2.N()
            long r5 = r2.r0()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.f2563c = r1
            r12.f2564d = r0
            r12.i = r1
            com.google.android.gms.measurement.internal.x4 r14 = r12.f2527a
            com.google.android.gms.common.util.d r14 = r14.a()
            long r10 = r14.b()
            com.google.android.gms.measurement.internal.x4 r14 = r12.f2527a
            com.google.android.gms.measurement.internal.u4 r14 = r14.c()
            com.google.android.gms.measurement.internal.o7 r15 = new com.google.android.gms.measurement.internal.o7
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.z(r15)
            return
        L_0x011b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011b }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u7.E(android.os.Bundle, long):void");
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    public final m7 r() {
        return this.f2563c;
    }

    public final m7 s(boolean z) {
        i();
        h();
        if (!z) {
            return this.f2565e;
        }
        m7 m7Var = this.f2565e;
        return m7Var != null ? m7Var : this.j;
    }

    /* access modifiers changed from: package-private */
    public final String t(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.f2527a.z();
        if (length2 <= 100) {
            return str2;
        }
        this.f2527a.z();
        return str2.substring(0, 100);
    }

    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.f2527a.z().D() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f2566f.put(activity, new m7(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void z(Activity activity) {
        synchronized (this.l) {
            if (activity == this.g) {
                this.g = null;
            }
        }
        if (this.f2527a.z().D()) {
            this.f2566f.remove(activity);
        }
    }
}
