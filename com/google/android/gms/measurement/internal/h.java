package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.l;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class h extends r5 {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f2386b;

    /* renamed from: c  reason: collision with root package name */
    private g f2387c = f.f2373a;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f2388d;

    h(x4 x4Var) {
        super(x4Var);
    }

    public static final long I() {
        return ((Long) y2.f2640d.a((Object) null)).longValue();
    }

    public static final long i() {
        return ((Long) y2.D.a((Object) null)).longValue();
    }

    private final String j(String str, String str2) {
        k3 k3Var;
        String str3;
        Class<String> cls = String.class;
        try {
            String str4 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, ""});
            n.i(str4);
            return str4;
        } catch (ClassNotFoundException e2) {
            e = e2;
            k3Var = this.f2527a.f().r();
            str3 = "Could not find SystemProperties class";
            k3Var.b(str3, e);
            return "";
        } catch (NoSuchMethodException e3) {
            e = e3;
            k3Var = this.f2527a.f().r();
            str3 = "Could not find SystemProperties.get() method";
            k3Var.b(str3, e);
            return "";
        } catch (IllegalAccessException e4) {
            e = e4;
            k3Var = this.f2527a.f().r();
            str3 = "Could not access SystemProperties.get()";
            k3Var.b(str3, e);
            return "";
        } catch (InvocationTargetException e5) {
            e = e5;
            k3Var = this.f2527a.f().r();
            str3 = "SystemProperties.get() threw an exception";
            k3Var.b(str3, e);
            return "";
        }
    }

    public final boolean A() {
        Boolean t = t("google_analytics_adid_collection_enabled");
        return t == null || t.booleanValue();
    }

    public final boolean B(String str, x2 x2Var) {
        Object a2;
        if (str != null) {
            String b2 = this.f2387c.b(str, x2Var.b());
            if (!TextUtils.isEmpty(b2)) {
                a2 = x2Var.a(Boolean.valueOf("1".equals(b2)));
                return ((Boolean) a2).booleanValue();
            }
        }
        a2 = x2Var.a((Object) null);
        return ((Boolean) a2).booleanValue();
    }

    public final boolean C(String str) {
        return "1".equals(this.f2387c.b(str, "gaia_collection_enabled"));
    }

    public final boolean D() {
        Boolean t = t("google_analytics_automatic_screen_reporting_enabled");
        return t == null || t.booleanValue();
    }

    public final boolean E() {
        this.f2527a.e();
        Boolean t = t("firebase_analytics_collection_deactivated");
        return t != null && t.booleanValue();
    }

    public final boolean F(String str) {
        return "1".equals(this.f2387c.b(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean G() {
        if (this.f2386b == null) {
            Boolean t = t("app_measurement_lite");
            this.f2386b = t;
            if (t == null) {
                this.f2386b = Boolean.FALSE;
            }
        }
        return this.f2386b.booleanValue() || !this.f2527a.s();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean H() {
        if (this.f2388d == null) {
            synchronized (this) {
                if (this.f2388d == null) {
                    ApplicationInfo applicationInfo = this.f2527a.d().getApplicationInfo();
                    String a2 = l.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(a2)) {
                            z = true;
                        }
                        this.f2388d = Boolean.valueOf(z);
                    }
                    if (this.f2388d == null) {
                        this.f2388d = Boolean.TRUE;
                        this.f2527a.f().r().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f2388d.booleanValue();
    }

    public final double k(String str, x2 x2Var) {
        if (str != null) {
            String b2 = this.f2387c.b(str, x2Var.b());
            if (!TextUtils.isEmpty(b2)) {
                try {
                    return ((Double) x2Var.a(Double.valueOf(Double.parseDouble(b2)))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Double) x2Var.a((Object) null)).doubleValue();
    }

    /* access modifiers changed from: package-private */
    public final int l(String str) {
        return p(str, y2.H, 500, 2000);
    }

    public final int m() {
        la N = this.f2527a.N();
        Boolean J = N.f2527a.L().J();
        if (N.o0() < 201500) {
            return (J == null || J.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int n(String str) {
        return p(str, y2.I, 25, 100);
    }

    public final int o(String str, x2 x2Var) {
        if (str != null) {
            String b2 = this.f2387c.b(str, x2Var.b());
            if (!TextUtils.isEmpty(b2)) {
                try {
                    return ((Integer) x2Var.a(Integer.valueOf(Integer.parseInt(b2)))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Integer) x2Var.a((Object) null)).intValue();
    }

    public final int p(String str, x2 x2Var, int i, int i2) {
        return Math.max(Math.min(o(str, x2Var), i2), i);
    }

    public final long q() {
        this.f2527a.e();
        return 74029;
    }

    public final long r(String str, x2 x2Var) {
        if (str != null) {
            String b2 = this.f2387c.b(str, x2Var.b());
            if (!TextUtils.isEmpty(b2)) {
                try {
                    return ((Long) x2Var.a(Long.valueOf(Long.parseLong(b2)))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Long) x2Var.a((Object) null)).longValue();
    }

    /* access modifiers changed from: package-private */
    public final Bundle s() {
        try {
            if (this.f2527a.d().getPackageManager() == null) {
                this.f2527a.f().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c2 = c.a(this.f2527a.d()).c(this.f2527a.d().getPackageName(), 128);
            if (c2 != null) {
                return c2.metaData;
            }
            this.f2527a.f().r().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            this.f2527a.f().r().b("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean t(String str) {
        n.e(str);
        Bundle s = s();
        if (s == null) {
            this.f2527a.f().r().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!s.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(s.getBoolean(str));
        }
    }

    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final String w() {
        this.f2527a.e();
        return "FA";
    }

    public final String x(String str, x2 x2Var) {
        return (String) x2Var.a(str == null ? null : this.f2387c.b(str, x2Var.b()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List y(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.n.e(r4)
            android.os.Bundle r0 = r3.s()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.x4 r4 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.d()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.h.y(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final void z(g gVar) {
        this.f2387c = gVar;
    }
}
