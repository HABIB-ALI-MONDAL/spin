package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import c.d.a.b.e.e.jc;
import c.d.a.b.e.e.n1;
import c.d.a.b.e.e.q6;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

public final class x4 implements t5 {
    private static volatile x4 H;
    private volatile Boolean A;
    protected Boolean B;
    protected Boolean C;
    private volatile boolean D;
    private int E;
    private final AtomicInteger F = new AtomicInteger(0);
    final long G;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2626a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2627b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2628c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2629d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2630e;

    /* renamed from: f  reason: collision with root package name */
    private final c f2631f;
    private final h g;
    private final b4 h;
    private final m3 i;
    private final u4 j;
    private final l9 k;
    private final la l;
    private final h3 m;
    private final d n;
    private final u7 o;
    private final e7 p;
    private final d2 q;
    private final j7 r;
    private final String s;
    private f3 t;
    private u8 u;
    private r v;
    private c3 w;
    private boolean x = false;
    private Boolean y;
    private long z;

    x4(b6 b6Var) {
        String str;
        k3 k3Var;
        Bundle bundle;
        boolean z2 = false;
        n.i(b6Var);
        Context context = b6Var.f2323a;
        c cVar = new c(context);
        this.f2631f = cVar;
        v2.f2580a = cVar;
        this.f2626a = context;
        this.f2627b = b6Var.f2324b;
        this.f2628c = b6Var.f2325c;
        this.f2629d = b6Var.f2326d;
        this.f2630e = b6Var.h;
        this.A = b6Var.f2327e;
        this.s = b6Var.j;
        this.D = true;
        n1 n1Var = b6Var.g;
        if (!(n1Var == null || (bundle = n1Var.p) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = n1Var.p.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        q6.e(context);
        d d2 = g.d();
        this.n = d2;
        Long l2 = b6Var.i;
        this.G = l2 != null ? l2.longValue() : d2.a();
        this.g = new h(this);
        b4 b4Var = new b4(this);
        b4Var.l();
        this.h = b4Var;
        m3 m3Var = new m3(this);
        m3Var.l();
        this.i = m3Var;
        la laVar = new la(this);
        laVar.l();
        this.l = laVar;
        this.m = new h3(new a6(b6Var, this));
        this.q = new d2(this);
        u7 u7Var = new u7(this);
        u7Var.j();
        this.o = u7Var;
        e7 e7Var = new e7(this);
        e7Var.j();
        this.p = e7Var;
        l9 l9Var = new l9(this);
        l9Var.j();
        this.k = l9Var;
        j7 j7Var = new j7(this);
        j7Var.l();
        this.r = j7Var;
        u4 u4Var = new u4(this);
        u4Var.l();
        this.j = u4Var;
        n1 n1Var2 = b6Var.g;
        z2 = (n1Var2 == null || n1Var2.k == 0) ? true : z2;
        if (context.getApplicationContext() instanceof Application) {
            e7 I = I();
            if (I.f2527a.f2626a.getApplicationContext() instanceof Application) {
                Application application = (Application) I.f2527a.f2626a.getApplicationContext();
                if (I.f2369c == null) {
                    I.f2369c = new d7(I, (c7) null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(I.f2369c);
                    application.registerActivityLifecycleCallbacks(I.f2369c);
                    k3Var = I.f2527a.f().v();
                    str = "Registered activity lifecycle callback";
                }
            }
            u4Var.z(new w4(this, b6Var));
        }
        k3Var = f().w();
        str = "Application context is not an Application";
        k3Var.a(str);
        u4Var.z(new w4(this, b6Var));
    }

    public static x4 H(Context context, n1 n1Var, Long l2) {
        Bundle bundle;
        if (n1Var != null && (n1Var.n == null || n1Var.o == null)) {
            n1Var = new n1(n1Var.j, n1Var.k, n1Var.l, n1Var.m, (String) null, (String) null, n1Var.p, (String) null);
        }
        n.i(context);
        n.i(context.getApplicationContext());
        if (H == null) {
            synchronized (x4.class) {
                if (H == null) {
                    H = new x4(new b6(context, n1Var, l2));
                }
            }
        } else if (!(n1Var == null || (bundle = n1Var.p) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            n.i(H);
            H.A = Boolean.valueOf(n1Var.p.getBoolean("dataCollectionDefaultEnabled"));
        }
        n.i(H);
        return H;
    }

    static /* bridge */ /* synthetic */ void b(x4 x4Var, b6 b6Var) {
        x4Var.c().h();
        x4Var.g.w();
        r rVar = new r(x4Var);
        rVar.l();
        x4Var.v = rVar;
        c3 c3Var = new c3(x4Var, b6Var.f2328f);
        c3Var.j();
        x4Var.w = c3Var;
        f3 f3Var = new f3(x4Var);
        f3Var.j();
        x4Var.t = f3Var;
        u8 u8Var = new u8(x4Var);
        u8Var.j();
        x4Var.u = u8Var;
        x4Var.l.m();
        x4Var.h.m();
        x4Var.w.k();
        k3 u2 = x4Var.f().u();
        x4Var.g.q();
        u2.b("App measurement initialized, version", 74029L);
        x4Var.f().u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String s2 = c3Var.s();
        if (TextUtils.isEmpty(x4Var.f2627b)) {
            if (x4Var.N().T(s2)) {
                x4Var.f().u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                x4Var.f().u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(s2)));
            }
        }
        x4Var.f().q().a("Debug-level message logging enabled");
        if (x4Var.E != x4Var.F.get()) {
            x4Var.f().r().c("Not all components initialized", Integer.valueOf(x4Var.E), Integer.valueOf(x4Var.F.get()));
        }
        x4Var.x = true;
    }

    static final void t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void u(r5 r5Var) {
        if (r5Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void v(f4 f4Var) {
        if (f4Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!f4Var.m()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(f4Var.getClass()))));
        }
    }

    private static final void w(s5 s5Var) {
        if (s5Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!s5Var.n()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(s5Var.getClass()))));
        }
    }

    @Pure
    public final r A() {
        w(this.v);
        return this.v;
    }

    @Pure
    public final c3 B() {
        v(this.w);
        return this.w;
    }

    @Pure
    public final f3 C() {
        v(this.t);
        return this.t;
    }

    @Pure
    public final h3 D() {
        return this.m;
    }

    public final m3 E() {
        m3 m3Var = this.i;
        if (m3Var == null || !m3Var.n()) {
            return null;
        }
        return m3Var;
    }

    @Pure
    public final b4 F() {
        u(this.h);
        return this.h;
    }

    /* access modifiers changed from: package-private */
    @SideEffectFree
    public final u4 G() {
        return this.j;
    }

    @Pure
    public final e7 I() {
        v(this.p);
        return this.p;
    }

    @Pure
    public final j7 J() {
        w(this.r);
        return this.r;
    }

    @Pure
    public final u7 K() {
        v(this.o);
        return this.o;
    }

    @Pure
    public final u8 L() {
        v(this.u);
        return this.u;
    }

    @Pure
    public final l9 M() {
        v(this.k);
        return this.k;
    }

    @Pure
    public final la N() {
        u(this.l);
        return this.l;
    }

    @Pure
    public final String O() {
        return this.f2627b;
    }

    @Pure
    public final String P() {
        return this.f2628c;
    }

    @Pure
    public final String Q() {
        return this.f2629d;
    }

    @Pure
    public final String R() {
        return this.s;
    }

    @Pure
    public final d a() {
        return this.n;
    }

    @Pure
    public final u4 c() {
        w(this.j);
        return this.j;
    }

    @Pure
    public final Context d() {
        return this.f2626a;
    }

    @Pure
    public final c e() {
        return this.f2631f;
    }

    @Pure
    public final m3 f() {
        w(this.i);
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        this.F.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(String str, int i2, Throwable th, byte[] bArr, Map map) {
        if (!(i2 == 200 || i2 == 204)) {
            if (i2 == 304) {
                i2 = 304;
            }
            f().w().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
        }
        if (th == null) {
            F().s.a(true);
            if (bArr == null || bArr.length == 0) {
                f().q().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    f().q().a("Deferred Deep Link is empty.");
                    return;
                }
                la N = N();
                x4 x4Var = N.f2527a;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = N.f2527a.f2626a.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.p.u("auto", "_cmp", bundle);
                        la N2 = N();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = N2.f2527a.f2626a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    N2.f2527a.f2626a.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e2) {
                                N2.f2527a.f().r().b("Failed to persist Deferred Deep Link. exception", e2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                f().w().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e3) {
                f().r().b("Failed to parse the Deferred Deep Link response. exception", e3);
                return;
            }
        }
        f().w().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.E++;
    }

    public final void j() {
        c().h();
        w(J());
        String s2 = B().s();
        Pair p2 = F().p(s2);
        if (!this.g.A() || ((Boolean) p2.second).booleanValue() || TextUtils.isEmpty((CharSequence) p2.first)) {
            f().q().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        j7 J = J();
        J.k();
        ConnectivityManager connectivityManager = (ConnectivityManager) J.f2527a.f2626a.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            f().w().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        la N = N();
        B().f2527a.g.q();
        URL s3 = N.s(74029, s2, (String) p2.first, F().t.a() - 1);
        if (s3 != null) {
            j7 J2 = J();
            v4 v4Var = new v4(this);
            J2.h();
            J2.k();
            n.i(s3);
            n.i(v4Var);
            J2.f2527a.c().y(new i7(J2, s2, s3, (byte[]) null, (Map) null, v4Var, (byte[]) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(boolean z2) {
        this.A = Boolean.valueOf(z2);
    }

    public final void l(boolean z2) {
        c().h();
        this.D = z2;
    }

    /* access modifiers changed from: protected */
    public final void m(n1 n1Var) {
        j jVar;
        c().h();
        j q2 = F().q();
        b4 F2 = F();
        x4 x4Var = F2.f2527a;
        F2.h();
        int i2 = 100;
        int i3 = F2.o().getInt("consent_source", 100);
        h hVar = this.g;
        x4 x4Var2 = hVar.f2527a;
        Boolean t2 = hVar.t("google_analytics_default_allow_ad_storage");
        h hVar2 = this.g;
        x4 x4Var3 = hVar2.f2527a;
        Boolean t3 = hVar2.t("google_analytics_default_allow_analytics_storage");
        if (!(t2 == null && t3 == null) && F().w(-10)) {
            jVar = new j(t2, t3);
            i2 = -10;
        } else {
            if (!TextUtils.isEmpty(B().t()) && (i3 == 0 || i3 == 30 || i3 == 10 || i3 == 30 || i3 == 30 || i3 == 40)) {
                I().G(j.f2414b, -10, this.G);
            } else if (TextUtils.isEmpty(B().t()) && n1Var != null && n1Var.p != null && F().w(30)) {
                jVar = j.a(n1Var.p);
                if (!jVar.equals(j.f2414b)) {
                    i2 = 30;
                }
            }
            jVar = null;
        }
        if (jVar != null) {
            I().G(jVar, i2, this.G);
            q2 = jVar;
        }
        I().J(q2);
        if (F().f2317e.a() == 0) {
            f().v().b("Persisting first open", Long.valueOf(this.G));
            F().f2317e.b(this.G);
        }
        I().n.c();
        if (r()) {
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                la N = N();
                String t4 = B().t();
                b4 F3 = F();
                F3.h();
                String string = F3.o().getString("gmp_app_id", (String) null);
                String r2 = B().r();
                b4 F4 = F();
                F4.h();
                if (N.b0(t4, string, r2, F4.o().getString("admob_app_id", (String) null))) {
                    f().u().a("Rechecking which service to use due to a GMP App Id change");
                    b4 F5 = F();
                    F5.h();
                    Boolean r3 = F5.r();
                    SharedPreferences.Editor edit = F5.o().edit();
                    edit.clear();
                    edit.apply();
                    if (r3 != null) {
                        F5.s(r3);
                    }
                    C().q();
                    this.u.Q();
                    this.u.P();
                    F().f2317e.b(this.G);
                    F().g.b((String) null);
                }
                b4 F6 = F();
                String t5 = B().t();
                F6.h();
                SharedPreferences.Editor edit2 = F6.o().edit();
                edit2.putString("gmp_app_id", t5);
                edit2.apply();
                b4 F7 = F();
                String r4 = B().r();
                F7.h();
                SharedPreferences.Editor edit3 = F7.o().edit();
                edit3.putString("admob_app_id", r4);
                edit3.apply();
            }
            if (!F().q().i(i.ANALYTICS_STORAGE)) {
                F().g.b((String) null);
            }
            I().C(F().g.a());
            jc.c();
            if (this.g.B((String) null, y2.d0)) {
                try {
                    N().f2527a.f2626a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(F().u.a())) {
                        f().w().a("Remote config removed with active feature rollouts");
                        F().u.b((String) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                boolean o2 = o();
                if (!F().u() && !this.g.E()) {
                    F().t(!o2);
                }
                if (o2) {
                    I().f0();
                }
                M().f2452d.a();
                L().S(new AtomicReference());
                L().v(F().x.a());
            }
        } else if (o()) {
            if (!N().S("android.permission.INTERNET")) {
                f().r().a("App is missing INTERNET permission");
            }
            if (!N().S("android.permission.ACCESS_NETWORK_STATE")) {
                f().r().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!c.a(this.f2626a).f() && !this.g.G()) {
                if (!la.Y(this.f2626a)) {
                    f().r().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!la.Z(this.f2626a, false)) {
                    f().r().a("AppMeasurementService not registered/enabled");
                }
            }
            f().r().a("Uploading is not possible. App measurement disabled");
        }
        F().n.a(true);
    }

    public final boolean n() {
        return this.A != null && this.A.booleanValue();
    }

    public final boolean o() {
        return x() == 0;
    }

    public final boolean p() {
        c().h();
        return this.D;
    }

    @Pure
    public final boolean q() {
        return TextUtils.isEmpty(this.f2627b);
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        if (this.x) {
            c().h();
            Boolean bool = this.y;
            if (bool == null || this.z == 0 || (!bool.booleanValue() && Math.abs(this.n.b() - this.z) > 1000)) {
                this.z = this.n.b();
                boolean z2 = true;
                Boolean valueOf = Boolean.valueOf(N().S("android.permission.INTERNET") && N().S("android.permission.ACCESS_NETWORK_STATE") && (c.a(this.f2626a).f() || this.g.G() || (la.Y(this.f2626a) && la.Z(this.f2626a, false))));
                this.y = valueOf;
                if (valueOf.booleanValue()) {
                    if (!N().L(B().t(), B().r()) && TextUtils.isEmpty(B().r())) {
                        z2 = false;
                    }
                    this.y = Boolean.valueOf(z2);
                }
            }
            return this.y.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean s() {
        return this.f2630e;
    }

    public final int x() {
        c().h();
        if (this.g.E()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        c().h();
        if (!this.D) {
            return 8;
        }
        Boolean r2 = F().r();
        if (r2 != null) {
            return r2.booleanValue() ? 0 : 3;
        }
        h hVar = this.g;
        c cVar = hVar.f2527a.f2631f;
        Boolean t2 = hVar.t("firebase_analytics_collection_enabled");
        if (t2 != null) {
            return t2.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    @Pure
    public final d2 y() {
        d2 d2Var = this.q;
        if (d2Var != null) {
            return d2Var;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final h z() {
        return this.g;
    }
}
