package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import b.c.a;
import c.d.a.b.e.e.sd;
import c.d.a.b.e.e.tc;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class e7 extends f4 {

    /* renamed from: c  reason: collision with root package name */
    protected d7 f2369c;

    /* renamed from: d  reason: collision with root package name */
    private y5 f2370d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f2371e = new CopyOnWriteArraySet();

    /* renamed from: f  reason: collision with root package name */
    private boolean f2372f;
    private final AtomicReference g = new AtomicReference();
    private final Object h = new Object();
    private j i = new j((Boolean) null, (Boolean) null);
    private int j = 100;
    private final AtomicLong k = new AtomicLong(0);
    private long l = -1;
    private int m = 100;
    final sa n;
    protected boolean o = true;
    private final ka p = new s6(this);

    protected e7(x4 x4Var) {
        super(x4Var);
        this.n = new sa(x4Var);
    }

    /* access modifiers changed from: private */
    public final void O(Boolean bool, boolean z) {
        h();
        i();
        this.f2527a.f().q().b("Setting app measurement enabled (FE)", bool);
        this.f2527a.F().s(bool);
        if (z) {
            b4 F = this.f2527a.F();
            x4 x4Var = F.f2527a;
            F.h();
            SharedPreferences.Editor edit = F.o().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.f2527a.p() || (bool != null && !bool.booleanValue())) {
            P();
        }
    }

    /* access modifiers changed from: private */
    public final void P() {
        Long valueOf;
        h();
        String a2 = this.f2527a.F().m.a();
        if (a2 != null) {
            if ("unset".equals(a2)) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(true != "true".equals(a2) ? 0 : 1);
            }
            M("app", "_npa", valueOf, this.f2527a.a().a());
        }
        if (!this.f2527a.o() || !this.o) {
            this.f2527a.f().q().a("Updating Scion state (FE)");
            this.f2527a.L().w();
            return;
        }
        this.f2527a.f().q().a("Recording app launch after enabling measurement for the first time (FE)");
        f0();
        tc.c();
        if (this.f2527a.z().B((String) null, y2.e0)) {
            this.f2527a.M().f2452d.a();
        }
        this.f2527a.c().z(new g6(this));
    }

    static /* bridge */ /* synthetic */ void b0(e7 e7Var, j jVar, j jVar2) {
        boolean z;
        i[] iVarArr = {i.ANALYTICS_STORAGE, i.AD_STORAGE};
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                z = false;
                break;
            }
            i iVar = iVarArr[i2];
            if (!jVar2.i(iVar) && jVar.i(iVar)) {
                z = true;
                break;
            }
            i2++;
        }
        boolean l2 = jVar.l(jVar2, i.ANALYTICS_STORAGE, i.AD_STORAGE);
        if (z || l2) {
            e7Var.f2527a.B().v();
        }
    }

    static /* synthetic */ void c0(e7 e7Var, j jVar, int i2, long j2, boolean z, boolean z2) {
        e7Var.h();
        e7Var.i();
        if (j2 > e7Var.l || !j.j(e7Var.m, i2)) {
            b4 F = e7Var.f2527a.F();
            x4 x4Var = F.f2527a;
            F.h();
            if (F.w(i2)) {
                SharedPreferences.Editor edit = F.o().edit();
                edit.putString("consent_settings", jVar.h());
                edit.putInt("consent_source", i2);
                edit.apply();
                e7Var.l = j2;
                e7Var.m = i2;
                e7Var.f2527a.L().t(z);
                if (z2) {
                    e7Var.f2527a.L().S(new AtomicReference());
                    return;
                }
                return;
            }
            e7Var.f2527a.f().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i2));
            return;
        }
        e7Var.f2527a.f().u().b("Dropped out-of-date consent setting, proposed settings", jVar);
    }

    /* access modifiers changed from: protected */
    public final void A(String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i2];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelable);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        this.f2527a.c().z(new j6(this, str, str2, j2, bundle2, z, z2, z3, str3));
    }

    /* access modifiers changed from: package-private */
    public final void B(String str, String str2, long j2, Object obj) {
        this.f2527a.c().z(new k6(this, str, str2, obj, j2));
    }

    /* access modifiers changed from: package-private */
    public final void C(String str) {
        this.g.set(str);
    }

    public final void D(Bundle bundle) {
        E(bundle, this.f2527a.a().a());
    }

    public final void E(Bundle bundle, long j2) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        n.i(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.f2527a.f().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        n.i(bundle2);
        u5.a(bundle2, "app_id", cls2, (Object) null);
        u5.a(bundle2, "origin", cls2, (Object) null);
        u5.a(bundle2, "name", cls2, (Object) null);
        u5.a(bundle2, "value", Object.class, (Object) null);
        u5.a(bundle2, "trigger_event_name", cls2, (Object) null);
        u5.a(bundle2, "trigger_timeout", cls, 0L);
        u5.a(bundle2, "timed_out_event_name", cls2, (Object) null);
        u5.a(bundle2, "timed_out_event_params", Bundle.class, (Object) null);
        u5.a(bundle2, "triggered_event_name", cls2, (Object) null);
        u5.a(bundle2, "triggered_event_params", Bundle.class, (Object) null);
        u5.a(bundle2, "time_to_live", cls, 0L);
        u5.a(bundle2, "expired_event_name", cls2, (Object) null);
        u5.a(bundle2, "expired_event_params", Bundle.class, (Object) null);
        n.e(bundle2.getString("name"));
        n.e(bundle2.getString("origin"));
        n.i(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j2);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.f2527a.N().n0(string) != 0) {
            this.f2527a.f().r().b("Invalid conditional user property name", this.f2527a.D().f(string));
        } else if (this.f2527a.N().j0(string, obj) == 0) {
            Object p2 = this.f2527a.N().p(string, obj);
            if (p2 == null) {
                this.f2527a.f().r().c("Unable to normalize conditional user property value", this.f2527a.D().f(string), obj);
                return;
            }
            u5.b(bundle2, p2);
            long j3 = bundle2.getLong("trigger_timeout");
            if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
                this.f2527a.z();
                if (j3 > 15552000000L || j3 < 1) {
                    this.f2527a.f().r().c("Invalid conditional user property timeout", this.f2527a.D().f(string), Long.valueOf(j3));
                    return;
                }
            }
            long j4 = bundle2.getLong("time_to_live");
            this.f2527a.z();
            if (j4 > 15552000000L || j4 < 1) {
                this.f2527a.f().r().c("Invalid conditional user property time to live", this.f2527a.D().f(string), Long.valueOf(j4));
            } else {
                this.f2527a.c().z(new m6(this, bundle2));
            }
        } else {
            this.f2527a.f().r().c("Invalid conditional user property value", this.f2527a.D().f(string), obj);
        }
    }

    public final void F(Bundle bundle, int i2, long j2) {
        i();
        String g2 = j.g(bundle);
        if (g2 != null) {
            this.f2527a.f().x().b("Ignoring invalid consent setting", g2);
            this.f2527a.f().x().a("Valid consent values are 'granted', 'denied'");
        }
        G(j.a(bundle), i2, j2);
    }

    public final void G(j jVar, int i2, long j2) {
        j jVar2;
        boolean z;
        boolean z2;
        boolean z3;
        j jVar3 = jVar;
        int i3 = i2;
        i();
        if (i3 != -10 && jVar.e() == null && jVar.f() == null) {
            this.f2527a.f().x().a("Discarding empty consent settings");
            return;
        }
        synchronized (this.h) {
            jVar2 = this.i;
            z = true;
            z2 = false;
            if (j.j(i3, this.j)) {
                boolean k2 = jVar3.k(this.i);
                i iVar = i.ANALYTICS_STORAGE;
                if (jVar3.i(iVar) && !this.i.i(iVar)) {
                    z2 = true;
                }
                jVar3 = jVar3.d(this.i);
                this.i = jVar3;
                this.j = i3;
                z3 = z2;
                z2 = k2;
            } else {
                z = false;
                z3 = false;
            }
        }
        if (!z) {
            this.f2527a.f().u().b("Ignoring lower-priority consent settings, proposed settings", jVar3);
            return;
        }
        long andIncrement = this.k.getAndIncrement();
        if (z2) {
            this.g.set((Object) null);
            this.f2527a.c().A(new y6(this, jVar3, j2, i2, andIncrement, z3, jVar2));
            return;
        }
        z6 z6Var = new z6(this, jVar3, i2, andIncrement, z3, jVar2);
        if (i3 == 30 || i3 == -10) {
            this.f2527a.c().A(z6Var);
        } else {
            this.f2527a.c().z(z6Var);
        }
    }

    public final void H(y5 y5Var) {
        y5 y5Var2;
        h();
        i();
        if (!(y5Var == null || y5Var == (y5Var2 = this.f2370d))) {
            n.m(y5Var2 == null, "EventInterceptor already set.");
        }
        this.f2370d = y5Var;
    }

    public final void I(Boolean bool) {
        i();
        this.f2527a.c().z(new x6(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void J(j jVar) {
        h();
        boolean z = (jVar.i(i.ANALYTICS_STORAGE) && jVar.i(i.AD_STORAGE)) || this.f2527a.L().A();
        if (z != this.f2527a.p()) {
            this.f2527a.l(z);
            b4 F = this.f2527a.F();
            x4 x4Var = F.f2527a;
            F.h();
            Boolean valueOf = F.o().contains("measurement_enabled_from_api") ? Boolean.valueOf(F.o().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                O(Boolean.valueOf(z), false);
            }
        }
    }

    public final void K(String str, String str2, Object obj, boolean z) {
        L("auto", "_ldl", obj, true, this.f2527a.a().a());
    }

    public final void L(String str, String str2, Object obj, boolean z, long j2) {
        int i2;
        String str3 = str2;
        Object obj2 = obj;
        String str4 = str == null ? "app" : str;
        if (z) {
            i2 = this.f2527a.N().n0(str3);
        } else {
            la N = this.f2527a.N();
            if (N.R("user property", str3)) {
                if (!N.N("user property", x5.f2632a, (String[]) null, str3)) {
                    i2 = 15;
                } else {
                    N.f2527a.z();
                    if (N.M("user property", 24, str3)) {
                        i2 = 0;
                    }
                }
            }
            i2 = 6;
        }
        if (i2 != 0) {
            la N2 = this.f2527a.N();
            this.f2527a.z();
            this.f2527a.N().B(this.p, (String) null, i2, "_ev", N2.r(str3, 24, true), str3 != null ? str2.length() : 0);
        } else if (obj2 != null) {
            int j0 = this.f2527a.N().j0(str3, obj2);
            if (j0 != 0) {
                la N3 = this.f2527a.N();
                this.f2527a.z();
                this.f2527a.N().B(this.p, (String) null, j0, "_ev", N3.r(str3, 24, true), ((obj2 instanceof String) || (obj2 instanceof CharSequence)) ? obj.toString().length() : 0);
                return;
            }
            Object p2 = this.f2527a.N().p(str3, obj2);
            if (p2 != null) {
                B(str4, str2, j2, p2);
            }
        } else {
            B(str4, str2, j2, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.n.e(r9)
            com.google.android.gms.common.internal.n.e(r10)
            r8.h()
            r8.i()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0061
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x004f
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x004f
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.x4 r10 = r8.f2527a
            com.google.android.gms.measurement.internal.b4 r10 = r10.F()
            com.google.android.gms.measurement.internal.a4 r10 = r10.m
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x005b
            java.lang.String r0 = "true"
            goto L_0x005b
        L_0x004f:
            if (r11 != 0) goto L_0x0061
            com.google.android.gms.measurement.internal.x4 r10 = r8.f2527a
            com.google.android.gms.measurement.internal.b4 r10 = r10.F()
            com.google.android.gms.measurement.internal.a4 r10 = r10.m
            java.lang.String r0 = "unset"
        L_0x005b:
            r10.b(r0)
            r6 = r11
            r3 = r1
            goto L_0x0063
        L_0x0061:
            r3 = r10
            r6 = r11
        L_0x0063:
            com.google.android.gms.measurement.internal.x4 r10 = r8.f2527a
            boolean r10 = r10.o()
            if (r10 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.x4 r9 = r8.f2527a
            com.google.android.gms.measurement.internal.m3 r9 = r9.f()
            com.google.android.gms.measurement.internal.k3 r9 = r9.v()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.x4 r10 = r8.f2527a
            boolean r10 = r10.r()
            if (r10 != 0) goto L_0x0084
            return
        L_0x0084:
            com.google.android.gms.measurement.internal.fa r10 = new com.google.android.gms.measurement.internal.fa
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.x4 r9 = r8.f2527a
            com.google.android.gms.measurement.internal.u8 r9 = r9.L()
            r9.y(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e7.M(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void N(z5 z5Var) {
        i();
        n.i(z5Var);
        if (!this.f2371e.remove(z5Var)) {
            this.f2527a.f().w().a("OnEventListener had not been registered");
        }
    }

    public final int Q(String str) {
        n.e(str);
        this.f2527a.z();
        return 25;
    }

    public final Boolean R() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f2527a.c().r(atomicReference, 15000, "boolean test flag value", new p6(this, atomicReference));
    }

    public final Double S() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f2527a.c().r(atomicReference, 15000, "double test flag value", new w6(this, atomicReference));
    }

    public final Integer T() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f2527a.c().r(atomicReference, 15000, "int test flag value", new v6(this, atomicReference));
    }

    public final Long U() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f2527a.c().r(atomicReference, 15000, "long test flag value", new u6(this, atomicReference));
    }

    public final String V() {
        return (String) this.g.get();
    }

    public final String W() {
        m7 r = this.f2527a.K().r();
        if (r != null) {
            return r.f2467b;
        }
        return null;
    }

    public final String X() {
        m7 r = this.f2527a.K().r();
        if (r != null) {
            return r.f2466a;
        }
        return null;
    }

    public final String Y() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f2527a.c().r(atomicReference, 15000, "String test flag value", new t6(this, atomicReference));
    }

    public final ArrayList Z(String str, String str2) {
        if (this.f2527a.c().C()) {
            this.f2527a.f().r().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.f2527a.e();
        if (c.a()) {
            this.f2527a.f().r().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f2527a.c().r(atomicReference, 5000, "get conditional user properties", new o6(this, atomicReference, (String) null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return la.v(list);
        }
        this.f2527a.f().r().b("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final Map a0(String str, String str2, boolean z) {
        k3 r;
        String str3;
        if (this.f2527a.c().C()) {
            r = this.f2527a.f().r();
            str3 = "Cannot get user properties from analytics worker thread";
        } else {
            this.f2527a.e();
            if (c.a()) {
                r = this.f2527a.f().r();
                str3 = "Cannot get user properties from main thread";
            } else {
                AtomicReference atomicReference = new AtomicReference();
                this.f2527a.c().r(atomicReference, 5000, "get user properties", new q6(this, atomicReference, (String) null, str, str2, z));
                List<fa> list = (List) atomicReference.get();
                if (list == null) {
                    this.f2527a.f().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                    return Collections.emptyMap();
                }
                a aVar = new a(list.size());
                for (fa faVar : list) {
                    Object g2 = faVar.g();
                    if (g2 != null) {
                        aVar.put(faVar.k, g2);
                    }
                }
                return aVar;
            }
        }
        r.a(str3);
        return Collections.emptyMap();
    }

    public final void f0() {
        h();
        i();
        if (this.f2527a.r()) {
            if (this.f2527a.z().B((String) null, y2.Y)) {
                h z = this.f2527a.z();
                z.f2527a.e();
                Boolean t = z.t("google_analytics_deferred_deep_link_enabled");
                if (t != null && t.booleanValue()) {
                    this.f2527a.f().q().a("Deferred Deep Link feature enabled.");
                    this.f2527a.c().z(new f6(this));
                }
            }
            this.f2527a.L().O();
            this.o = false;
            b4 F = this.f2527a.F();
            F.h();
            String string = F.o().getString("previous_os_version", (String) null);
            F.f2527a.A().k();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = F.o().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.f2527a.A().k();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    u("auto", "_ou", bundle);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    public final void o(String str, String str2, Bundle bundle) {
        long a2 = this.f2527a.a().a();
        n.e(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", a2);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.f2527a.c().z(new n6(this, bundle2));
    }

    public final void p() {
        if ((this.f2527a.d().getApplicationContext() instanceof Application) && this.f2369c != null) {
            ((Application) this.f2527a.d().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f2369c);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(Bundle bundle) {
        if (bundle == null) {
            this.f2527a.F().x.b(new Bundle());
            return;
        }
        Bundle a2 = this.f2527a.F().x.a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.f2527a.N().U(obj)) {
                    this.f2527a.N().B(this.p, (String) null, 27, (String) null, (String) null, 0);
                }
                this.f2527a.f().x().c("Invalid default event parameter type. Name, value", str, obj);
            } else if (la.W(str)) {
                this.f2527a.f().x().b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                a2.remove(str);
            } else {
                la N = this.f2527a.N();
                this.f2527a.z();
                if (N.P("param", str, 100, obj)) {
                    this.f2527a.N().C(a2, str, obj);
                }
            }
        }
        this.f2527a.N();
        int m2 = this.f2527a.z().m();
        if (a2.size() > m2) {
            int i2 = 0;
            for (String str2 : new TreeSet(a2.keySet())) {
                i2++;
                if (i2 > m2) {
                    a2.remove(str2);
                }
            }
            this.f2527a.N().B(this.p, (String) null, 26, (String) null, (String) null, 0);
            this.f2527a.f().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.f2527a.F().x.b(a2);
        this.f2527a.L().v(a2);
    }

    public final void r(String str, String str2, Bundle bundle) {
        s(str, str2, bundle, true, true, this.f2527a.a().a());
    }

    public final void s(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) {
        String str3 = str2;
        String str4 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str3 == "screen_view" || (str3 != null && str2.equals("screen_view"))) {
            this.f2527a.K().E(bundle2, j2);
        } else {
            A(str4, str2, j2, bundle2, z2, !z2 || this.f2370d == null || la.W(str2), z, (String) null);
        }
    }

    public final void t(String str, String str2, Bundle bundle, String str3) {
        x4.t();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final void u(String str, String str2, Bundle bundle) {
        h();
        v(str, str2, this.f2527a.a().a(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void v(String str, String str2, long j2, Bundle bundle) {
        h();
        w(str, str2, j2, bundle, true, this.f2370d == null || la.W(str2), true, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: android.os.Bundle[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: android.os.Bundle[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: android.os.Bundle[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: android.os.Bundle[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(java.lang.String r20, java.lang.String r21, long r22, android.os.Bundle r24, boolean r25, boolean r26, boolean r27, java.lang.String r28) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            com.google.android.gms.common.internal.n.e(r20)
            com.google.android.gms.common.internal.n.i(r24)
            r19.h()
            r19.i()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            boolean r1 = r1.o()
            if (r1 == 0) goto L_0x04ee
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.c3 r1 = r1.B()
            java.util.List r1 = r1.u()
            if (r1 == 0) goto L_0x0043
            boolean r1 = r1.contains(r9)
            if (r1 == 0) goto L_0x0033
            goto L_0x0043
        L_0x0033:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.c(r1, r9, r8)
            return
        L_0x0043:
            boolean r1 = r7.f2372f
            r13 = 0
            r14 = 0
            r15 = 1
            if (r1 != 0) goto L_0x00a1
            r7.f2372f = r15
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a     // Catch:{ ClassNotFoundException -> 0x0092 }
            boolean r1 = r1.s()     // Catch:{ ClassNotFoundException -> 0x0092 }
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a     // Catch:{ ClassNotFoundException -> 0x0092 }
            android.content.Context r1 = r1.d()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r15, r1)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x0067
        L_0x0063:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
        L_0x0067:
            java.lang.Class[] r1 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x0081 }
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = "initialize"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r1)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0081 }
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a     // Catch:{ Exception -> 0x0081 }
            android.content.Context r2 = r2.d()     // Catch:{ Exception -> 0x0081 }
            r1[r14] = r2     // Catch:{ Exception -> 0x0081 }
            r0.invoke(r13, r1)     // Catch:{ Exception -> 0x0081 }
            goto L_0x00a1
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()     // Catch:{ ClassNotFoundException -> 0x0092 }
            com.google.android.gms.measurement.internal.k3 r1 = r1.w()     // Catch:{ ClassNotFoundException -> 0x0092 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.b(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0092 }
            goto L_0x00a1
        L_0x0092:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.u()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.a(r1)
        L_0x00a1:
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.e()
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.common.util.d r0 = r0.a()
            long r5 = r0.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r19
            r1.M(r2, r3, r4, r5)
        L_0x00cd:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            r0.e()
            if (r25 == 0) goto L_0x00ef
            boolean r0 = com.google.android.gms.measurement.internal.la.a0(r21)
            if (r0 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.la r0 = r0.N()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.w3 r1 = r1.x
            android.os.Bundle r1 = r1.a()
            r0.z(r12, r1)
        L_0x00ef:
            r0 = 40
            if (r27 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.e()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0177
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            java.lang.String r2 = "event"
            boolean r3 = r1.R(r2, r9)
            r4 = 2
            if (r3 != 0) goto L_0x0110
            goto L_0x012a
        L_0x0110:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.v5.f2587a
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.v5.f2588b
            boolean r3 = r1.N(r2, r3, r5, r9)
            if (r3 != 0) goto L_0x011d
            r4 = 13
            goto L_0x012a
        L_0x011d:
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a
            r3.z()
            boolean r1 = r1.M(r2, r0, r9)
            if (r1 != 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r4 = 0
        L_0x012a:
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.s()
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r2 = r2.D()
            java.lang.String r2 = r2.d(r9)
            java.lang.String r3 = "Invalid public event name. Event will not be logged (FE)"
            r1.b(r3, r2)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            r2.z()
            java.lang.String r0 = r1.r(r9, r0, r15)
            if (r9 == 0) goto L_0x015a
            int r14 = r21.length()
        L_0x015a:
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            com.google.android.gms.measurement.internal.ka r2 = r7.p
            r3 = 0
            java.lang.String r5 = "_ev"
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r0
            r26 = r14
            r20.B(r21, r22, r23, r24, r25, r26)
            return
        L_0x0177:
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.e()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.u7 r1 = r1.K()
            com.google.android.gms.measurement.internal.m7 r1 = r1.s(r14)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0192
            boolean r3 = r12.containsKey(r2)
            if (r3 != 0) goto L_0x0192
            r1.f2469d = r15
        L_0x0192:
            if (r25 == 0) goto L_0x0198
            if (r27 != 0) goto L_0x0198
            r3 = 1
            goto L_0x0199
        L_0x0198:
            r3 = 0
        L_0x0199:
            com.google.android.gms.measurement.internal.la.y(r1, r12, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r8)
            boolean r3 = com.google.android.gms.measurement.internal.la.W(r21)
            if (r25 == 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.y5 r4 = r7.f2370d
            if (r4 == 0) goto L_0x01e9
            if (r3 != 0) goto L_0x01e9
            if (r1 == 0) goto L_0x01b3
            r16 = 1
            goto L_0x01eb
        L_0x01b3:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r1 = r1.D()
            java.lang.String r1 = r1.d(r9)
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r2 = r2.D()
            java.lang.String r2 = r2.b(r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.c(r3, r1, r2)
            com.google.android.gms.measurement.internal.y5 r0 = r7.f2370d
            com.google.android.gms.common.internal.n.i(r0)
            com.google.android.gms.measurement.internal.y5 r1 = r7.f2370d
            r2 = r20
            r3 = r21
            r4 = r24
            r5 = r22
            r1.a(r2, r3, r4, r5)
            return
        L_0x01e9:
            r16 = r1
        L_0x01eb:
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            boolean r1 = r1.r()
            if (r1 == 0) goto L_0x04ed
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            int r1 = r1.k0(r9)
            if (r1 == 0) goto L_0x0249
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.s()
            com.google.android.gms.measurement.internal.x4 r3 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r3 = r3.D()
            java.lang.String r3 = r3.d(r9)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.la r2 = r2.N()
            com.google.android.gms.measurement.internal.x4 r3 = r7.f2527a
            r3.z()
            java.lang.String r0 = r2.r(r9, r0, r15)
            if (r9 == 0) goto L_0x022d
            int r14 = r21.length()
        L_0x022d:
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.la r2 = r2.N()
            com.google.android.gms.measurement.internal.ka r3 = r7.p
            java.lang.String r4 = "_ev"
            r20 = r2
            r21 = r3
            r22 = r28
            r23 = r1
            r24 = r4
            r25 = r0
            r26 = r14
            r20.B(r21, r22, r23, r24, r25, r26)
            return
        L_0x0249:
            java.lang.String r0 = "_o"
            java.lang.String r1 = "_sn"
            java.lang.String r3 = "_si"
            java.lang.String[] r1 = new java.lang.String[]{r0, r1, r2, r3}
            java.util.List r5 = com.google.android.gms.common.util.e.c(r1)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            r2 = r28
            r3 = r21
            r4 = r24
            r6 = r27
            android.os.Bundle r12 = r1.v0(r2, r3, r4, r5, r6)
            com.google.android.gms.common.internal.n.i(r12)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.e()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.u7 r1 = r1.K()
            com.google.android.gms.measurement.internal.m7 r1 = r1.s(r14)
            java.lang.String r5 = "_ae"
            if (r1 == 0) goto L_0x02ae
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.l9 r1 = r1.M()
            com.google.android.gms.measurement.internal.j9 r1 = r1.f2453e
            com.google.android.gms.measurement.internal.l9 r2 = r1.f2424d
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.common.util.d r2 = r2.a()
            long r14 = r2.b()
            long r3 = r1.f2422b
            long r3 = r14 - r3
            r1.f2422b = r14
            r1 = 0
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x02ae
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            r1.w(r12, r3)
        L_0x02ae:
            c.d.a.b.e.e.jc.c()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.h r1 = r1.z()
            com.google.android.gms.measurement.internal.x2 r2 = com.google.android.gms.measurement.internal.y2.d0
            boolean r1 = r1.B(r13, r2)
            if (r1 == 0) goto L_0x0338
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            java.lang.String r2 = "_ffr"
            if (r1 != 0) goto L_0x0317
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x0317
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            java.lang.String r2 = r12.getString(r2)
            boolean r3 = com.google.android.gms.common.util.m.a(r2)
            if (r3 == 0) goto L_0x02e3
            r2 = r13
            goto L_0x02e9
        L_0x02e3:
            if (r2 == 0) goto L_0x02e9
            java.lang.String r2 = r2.trim()
        L_0x02e9:
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a
            com.google.android.gms.measurement.internal.b4 r3 = r3.F()
            com.google.android.gms.measurement.internal.a4 r3 = r3.u
            java.lang.String r3 = r3.a()
            boolean r3 = com.google.android.gms.measurement.internal.ia.a(r2, r3)
            if (r3 != 0) goto L_0x0307
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.a4 r1 = r1.u
            r1.b(r2)
            goto L_0x0338
        L_0x0307:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.a(r1)
            return
        L_0x0317:
            boolean r1 = r5.equals(r9)
            if (r1 == 0) goto L_0x0338
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.a4 r1 = r1.u
            java.lang.String r1 = r1.a()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0338
            r12.putString(r2, r1)
        L_0x0338:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r12)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.x3 r1 = r1.o
            long r1 = r1.a()
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            boolean r1 = r1.v(r10)
            if (r1 == 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.v3 r1 = r1.r
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.a(r2)
            r6 = 0
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.common.util.d r1 = r1.a()
            long r17 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r15 = "_sid"
            r1 = r19
            r24 = r14
            r13 = r3
            r3 = r15
            r4 = r6
            r15 = r5
            r5 = r17
            r1.M(r2, r3, r4, r5)
            r4 = 0
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.common.util.d r1 = r1.a()
            long r5 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r19
            r1.M(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.common.util.d r1 = r1.a()
            long r5 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r19
            r1.M(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.x3 r1 = r1.p
            r1.b(r13)
            goto L_0x03ce
        L_0x03ca:
            r15 = r5
            r24 = r14
            r13 = r3
        L_0x03ce:
            java.lang.String r1 = "extend_session"
            long r1 = r12.getLong(r1, r13)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03f5
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.l9 r1 = r1.M()
            com.google.android.gms.measurement.internal.k9 r1 = r1.f2452d
            r2 = 1
            r1.b(r10, r2)
        L_0x03f5:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r12.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x0406:
            if (r3 >= r2) goto L_0x0451
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x044e
            com.google.android.gms.measurement.internal.x4 r5 = r7.f2527a
            r5.N()
            java.lang.Object r5 = r12.get(r4)
            boolean r6 = r5 instanceof android.os.Bundle
            if (r6 == 0) goto L_0x0426
            r6 = 1
            android.os.Bundle[] r13 = new android.os.Bundle[r6]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r6 = 0
            r13[r6] = r5
            goto L_0x0449
        L_0x0426:
            boolean r6 = r5 instanceof android.os.Parcelable[]
            if (r6 == 0) goto L_0x0437
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            java.lang.Class<android.os.Bundle[]> r13 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6, r13)
        L_0x0433:
            r13 = r5
            android.os.Bundle[] r13 = (android.os.Bundle[]) r13
            goto L_0x0449
        L_0x0437:
            boolean r6 = r5 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0448
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            android.os.Bundle[] r6 = new android.os.Bundle[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            goto L_0x0433
        L_0x0448:
            r13 = 0
        L_0x0449:
            if (r13 == 0) goto L_0x044e
            r12.putParcelableArray(r4, r13)
        L_0x044e:
            int r3 = r3 + 1
            goto L_0x0406
        L_0x0451:
            r12 = 0
        L_0x0452:
            int r1 = r24.size()
            if (r12 >= r1) goto L_0x04bf
            r13 = r24
            java.lang.Object r1 = r13.get(r12)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r12 == 0) goto L_0x0465
            java.lang.String r2 = "_ep"
            goto L_0x0466
        L_0x0465:
            r2 = r9
        L_0x0466:
            r1.putString(r0, r8)
            if (r26 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.x4 r3 = r7.f2527a
            com.google.android.gms.measurement.internal.la r3 = r3.N()
            android.os.Bundle r1 = r3.u0(r1)
        L_0x0475:
            r14 = r1
            com.google.android.gms.measurement.internal.x r5 = new com.google.android.gms.measurement.internal.x
            com.google.android.gms.measurement.internal.v r3 = new com.google.android.gms.measurement.internal.v
            r3.<init>(r14)
            r1 = r5
            r4 = r20
            r25 = r0
            r0 = r5
            r5 = r22
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.u8 r1 = r1.L()
            r5 = r28
            r1.o(r0, r5)
            if (r16 != 0) goto L_0x04b8
            java.util.Set r0 = r7.f2371e
            java.util.Iterator r0 = r0.iterator()
        L_0x049b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04b8
            java.lang.Object r1 = r0.next()
            com.google.android.gms.measurement.internal.z5 r1 = (com.google.android.gms.measurement.internal.z5) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r14)
            r2 = r20
            r3 = r21
            r5 = r22
            r1.a(r2, r3, r4, r5)
            r5 = r28
            goto L_0x049b
        L_0x04b8:
            int r12 = r12 + 1
            r0 = r25
            r24 = r13
            goto L_0x0452
        L_0x04bf:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            r0.e()
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.u7 r0 = r0.K()
            r1 = 0
            com.google.android.gms.measurement.internal.m7 r0 = r0.s(r1)
            if (r0 == 0) goto L_0x04ed
            boolean r0 = r15.equals(r9)
            if (r0 == 0) goto L_0x04ed
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.l9 r0 = r0.M()
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.common.util.d r1 = r1.a()
            long r1 = r1.b()
            com.google.android.gms.measurement.internal.j9 r0 = r0.f2453e
            r3 = 1
            r0.d(r3, r3, r1)
        L_0x04ed:
            return
        L_0x04ee:
            com.google.android.gms.measurement.internal.x4 r0 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e7.w(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void x(z5 z5Var) {
        i();
        n.i(z5Var);
        if (!this.f2371e.add(z5Var)) {
            this.f2527a.f().w().a("OnEventListener already registered");
        }
    }

    public final void y(long j2) {
        this.g.set((Object) null);
        this.f2527a.c().z(new l6(this, j2));
    }

    /* access modifiers changed from: package-private */
    public final void z(long j2, boolean z) {
        h();
        i();
        this.f2527a.f().q().a("Resetting analytics data (FE)");
        l9 M = this.f2527a.M();
        M.h();
        k9 k9Var = M.f2452d;
        M.f2453e.a();
        sd.c();
        if (this.f2527a.z().B((String) null, y2.j0)) {
            this.f2527a.B().v();
        }
        boolean o2 = this.f2527a.o();
        b4 F = this.f2527a.F();
        F.f2317e.b(j2);
        if (!TextUtils.isEmpty(F.f2527a.F().u.a())) {
            F.u.b((String) null);
        }
        tc.c();
        h z2 = F.f2527a.z();
        x2 x2Var = y2.e0;
        if (z2.B((String) null, x2Var)) {
            F.o.b(0);
        }
        F.p.b(0);
        if (!F.f2527a.z().E()) {
            F.t(!o2);
        }
        F.v.b((String) null);
        F.w.b(0);
        F.x.b((Bundle) null);
        if (z) {
            this.f2527a.L().q();
        }
        tc.c();
        if (this.f2527a.z().B((String) null, x2Var)) {
            this.f2527a.M().f2452d.a();
        }
        this.o = !o2;
    }
}
