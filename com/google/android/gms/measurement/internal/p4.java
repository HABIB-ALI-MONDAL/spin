package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import b.c.a;
import b.c.e;
import c.d.a.b.e.e.a9;
import c.d.a.b.e.e.c1;
import c.d.a.b.e.e.f5;
import c.d.a.b.e.e.h5;
import c.d.a.b.e.e.ie;
import c.d.a.b.e.e.o3;
import c.d.a.b.e.e.p3;
import c.d.a.b.e.e.r3;
import c.d.a.b.e.e.s3;
import c.d.a.b.e.e.w1;
import c.d.a.b.e.e.w3;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class p4 extends q9 implements g {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map f2501d = new a();

    /* renamed from: e  reason: collision with root package name */
    final Map f2502e = new a();

    /* renamed from: f  reason: collision with root package name */
    final Map f2503f = new a();
    final Map g = new a();
    private final Map h = new a();
    private final Map i = new a();
    final e j = new m4(this, 20);
    final ie k = new n4(this);
    private final Map l = new a();
    private final Map m = new a();
    private final Map n = new a();

    p4(ca caVar) {
        super(caVar);
    }

    private final s3 m(String str, byte[] bArr) {
        if (bArr == null) {
            return s3.K();
        }
        try {
            r3 I = s3.I();
            ea.C(I, bArr);
            s3 s3Var = (s3) I.n();
            k3 v = this.f2527a.f().v();
            String str2 = null;
            Long valueOf = s3Var.V() ? Long.valueOf(s3Var.G()) : null;
            if (s3Var.U()) {
                str2 = s3Var.L();
            }
            v.c("Parsed config. version, gmp_app_id", valueOf, str2);
            return s3Var;
        } catch (a9 | RuntimeException e2) {
            this.f2527a.f().w().c("Unable to merge remote config. appId", m3.z(str), e2);
            return s3.K();
        }
    }

    private final void n(String str, r3 r3Var) {
        Boolean bool = Boolean.TRUE;
        HashSet hashSet = new HashSet();
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        for (o3 F : r3Var.y()) {
            hashSet.add(F.F());
        }
        for (int i2 = 0; i2 < r3Var.s(); i2++) {
            p3 p3Var = (p3) r3Var.t(i2).B();
            if (p3Var.u().isEmpty()) {
                this.f2527a.f().w().a("EventConfig contained null event name");
            } else {
                String u = p3Var.u();
                String b2 = v5.b(p3Var.u());
                if (!TextUtils.isEmpty(b2)) {
                    p3Var.t(b2);
                    r3Var.v(i2, p3Var);
                }
                if (p3Var.x() && p3Var.v()) {
                    aVar.put(u, bool);
                }
                if (p3Var.y() && p3Var.w()) {
                    aVar2.put(p3Var.u(), bool);
                }
                if (p3Var.z()) {
                    if (p3Var.s() < 2 || p3Var.s() > 65535) {
                        this.f2527a.f().w().c("Invalid sampling rate. Event name, sample rate", p3Var.u(), Integer.valueOf(p3Var.s()));
                    } else {
                        aVar3.put(p3Var.u(), Integer.valueOf(p3Var.s()));
                    }
                }
            }
        }
        this.f2502e.put(str, hashSet);
        this.f2503f.put(str, aVar);
        this.g.put(str, aVar2);
        this.i.put(str, aVar3);
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00aa, code lost:
        if (r2 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void o(java.lang.String r13) {
        /*
            r12 = this;
            r12.i()
            r12.h()
            com.google.android.gms.common.internal.n.e(r13)
            java.util.Map r0 = r12.h
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x012f
            com.google.android.gms.measurement.internal.ca r0 = r12.f2504b
            com.google.android.gms.measurement.internal.n r0 = r0.V()
            com.google.android.gms.common.internal.n.e(r13)
            r0.h()
            r0.i()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.P()     // Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
            r11 = 0
            r6[r11] = r13     // Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0094, all -> 0x0091 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x008f }
            if (r3 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x00af
            goto L_0x00ac
        L_0x0049:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x008f }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x008f }
            com.google.android.gms.measurement.internal.x4 r5 = r0.f2527a     // Catch:{ SQLiteException -> 0x008f }
            com.google.android.gms.measurement.internal.h r5 = r5.z()     // Catch:{ SQLiteException -> 0x008f }
            com.google.android.gms.measurement.internal.x2 r6 = com.google.android.gms.measurement.internal.y2.l0     // Catch:{ SQLiteException -> 0x008f }
            boolean r5 = r5.B(r1, r6)     // Catch:{ SQLiteException -> 0x008f }
            if (r5 == 0) goto L_0x0065
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x008f }
            goto L_0x0066
        L_0x0065:
            r5 = r1
        L_0x0066:
            boolean r6 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x008f }
            if (r6 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.x4 r6 = r0.f2527a     // Catch:{ SQLiteException -> 0x008f }
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()     // Catch:{ SQLiteException -> 0x008f }
            com.google.android.gms.measurement.internal.k3 r6 = r6.r()     // Catch:{ SQLiteException -> 0x008f }
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r13)     // Catch:{ SQLiteException -> 0x008f }
            r6.b(r7, r8)     // Catch:{ SQLiteException -> 0x008f }
        L_0x007f:
            if (r3 != 0) goto L_0x0084
            if (r2 == 0) goto L_0x00af
            goto L_0x00ac
        L_0x0084:
            com.google.android.gms.measurement.internal.k r6 = new com.google.android.gms.measurement.internal.k     // Catch:{ SQLiteException -> 0x008f }
            r6.<init>(r3, r4, r5)     // Catch:{ SQLiteException -> 0x008f }
            if (r2 == 0) goto L_0x00b0
            r2.close()
            goto L_0x00b0
        L_0x008f:
            r3 = move-exception
            goto L_0x0097
        L_0x0091:
            r13 = move-exception
            goto L_0x0129
        L_0x0094:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0097:
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ all -> 0x0127 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0127 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r13)     // Catch:{ all -> 0x0127 }
            r0.c(r4, r5, r3)     // Catch:{ all -> 0x0127 }
            if (r2 == 0) goto L_0x00af
        L_0x00ac:
            r2.close()
        L_0x00af:
            r6 = r1
        L_0x00b0:
            if (r6 != 0) goto L_0x00e0
            java.util.Map r0 = r12.f2501d
            r0.put(r13, r1)
            java.util.Map r0 = r12.f2503f
            r0.put(r13, r1)
            java.util.Map r0 = r12.f2502e
            r0.put(r13, r1)
            java.util.Map r0 = r12.g
            r0.put(r13, r1)
            java.util.Map r0 = r12.h
            r0.put(r13, r1)
            java.util.Map r0 = r12.l
            r0.put(r13, r1)
            java.util.Map r0 = r12.m
            r0.put(r13, r1)
            java.util.Map r0 = r12.n
            r0.put(r13, r1)
            java.util.Map r0 = r12.i
        L_0x00dc:
            r0.put(r13, r1)
            return
        L_0x00e0:
            byte[] r0 = r6.f2425a
            c.d.a.b.e.e.s3 r0 = r12.m(r13, r0)
            c.d.a.b.e.e.p8 r0 = r0.B()
            c.d.a.b.e.e.r3 r0 = (c.d.a.b.e.e.r3) r0
            r12.n(r13, r0)
            java.util.Map r1 = r12.f2501d
            c.d.a.b.e.e.s8 r2 = r0.n()
            c.d.a.b.e.e.s3 r2 = (c.d.a.b.e.e.s3) r2
            java.util.Map r2 = q(r2)
            r1.put(r13, r2)
            java.util.Map r1 = r12.h
            c.d.a.b.e.e.s8 r2 = r0.n()
            c.d.a.b.e.e.s3 r2 = (c.d.a.b.e.e.s3) r2
            r1.put(r13, r2)
            c.d.a.b.e.e.s8 r1 = r0.n()
            c.d.a.b.e.e.s3 r1 = (c.d.a.b.e.e.s3) r1
            r12.p(r13, r1)
            java.util.Map r1 = r12.l
            java.lang.String r0 = r0.w()
            r1.put(r13, r0)
            java.util.Map r0 = r12.m
            java.lang.String r1 = r6.f2426b
            r0.put(r13, r1)
            java.util.Map r0 = r12.n
            java.lang.String r1 = r6.f2427c
            goto L_0x00dc
        L_0x0127:
            r13 = move-exception
            r1 = r2
        L_0x0129:
            if (r1 == 0) goto L_0x012e
            r1.close()
        L_0x012e:
            throw r13
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p4.o(java.lang.String):void");
    }

    private final void p(String str, s3 s3Var) {
        if (s3Var.E() != 0) {
            this.f2527a.f().v().b("EES programs found", Integer.valueOf(s3Var.E()));
            h5 h5Var = (h5) s3Var.P().get(0);
            try {
                c1 c1Var = new c1();
                c1Var.d("internal.remoteConfig", new j4(this, str));
                c1Var.d("internal.appMetadata", new k4(this, str));
                c1Var.d("internal.logger", new l4(this));
                c1Var.c(h5Var);
                this.j.d(str, c1Var);
                this.f2527a.f().v().c("EES program loaded for appId, activities", str, Integer.valueOf(h5Var.E().E()));
                for (f5 F : h5Var.E().H()) {
                    this.f2527a.f().v().b("EES program activity", F.F());
                }
            } catch (w1 unused) {
                this.f2527a.f().r().b("Failed to load EES program. appId", str);
            }
        } else {
            this.j.e(str);
        }
    }

    private static final Map q(s3 s3Var) {
        a aVar = new a();
        if (s3Var != null) {
            for (w3 w3Var : s3Var.Q()) {
                aVar.put(w3Var.F(), w3Var.G());
            }
        }
        return aVar;
    }

    static /* bridge */ /* synthetic */ c1 s(p4 p4Var, String str) {
        p4Var.i();
        n.e(str);
        if (!p4Var.C(str)) {
            return null;
        }
        if (!p4Var.h.containsKey(str) || p4Var.h.get(str) == null) {
            p4Var.o(str);
        } else {
            p4Var.p(str, (s3) p4Var.h.get(str));
        }
        return (c1) p4Var.j.h().get(str);
    }

    /* access modifiers changed from: package-private */
    public final void A(String str) {
        h();
        this.h.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean B(String str) {
        h();
        s3 t = t(str);
        if (t == null) {
            return false;
        }
        return t.T();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r3 = (c.d.a.b.e.e.s3) r2.h.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean C(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map r0 = r2.h
            java.lang.Object r3 = r0.get(r3)
            c.d.a.b.e.e.s3 r3 = (c.d.a.b.e.e.s3) r3
            if (r3 != 0) goto L_0x0013
            return r1
        L_0x0013:
            int r3 = r3.E()
            if (r3 == 0) goto L_0x001b
            r3 = 1
            return r3
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.p4.C(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean D(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean E(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean F(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if (D(str) && la.W(str2)) {
            return true;
        }
        if (G(str) && la.X(str2)) {
            return true;
        }
        Map map = (Map) this.f2503f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean G(String str) {
        return "1".equals(b(str, "measurement.upload.blacklist_public"));
    }

    /* access modifiers changed from: protected */
    public final boolean H(String str, byte[] bArr, String str2, String str3) {
        i();
        h();
        n.e(str);
        r3 r3Var = (r3) m(str, bArr).B();
        n(str, r3Var);
        p(str, (s3) r3Var.n());
        this.h.put(str, (s3) r3Var.n());
        this.l.put(str, r3Var.w());
        this.m.put(str, str2);
        this.n.put(str, str3);
        this.f2501d.put(str, q((s3) r3Var.n()));
        this.f2504b.V().n(str, new ArrayList(r3Var.x()));
        try {
            r3Var.u();
            bArr = ((s3) r3Var.n()).k();
        } catch (RuntimeException e2) {
            this.f2527a.f().w().c("Unable to serialize reduced-size config. Storing full config instead. appId", m3.z(str), e2);
        }
        n V = this.f2504b.V();
        n.e(str);
        V.h();
        V.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        if (V.f2527a.z().B((String) null, y2.l0)) {
            contentValues.put("e_tag", str3);
        }
        try {
            if (((long) V.P().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                V.f2527a.f().r().b("Failed to update remote config (got 0). appId", m3.z(str));
            }
        } catch (SQLiteException e3) {
            V.f2527a.f().r().c("Error storing remote config. appId", m3.z(str), e3);
        }
        this.h.put(str, (s3) r3Var.n());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean I(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && ((Set) this.f2502e.get(str)).contains("app_instance_id");
    }

    /* access modifiers changed from: package-private */
    public final boolean J(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && (((Set) this.f2502e.get(str)).contains("device_model") || ((Set) this.f2502e.get(str)).contains("device_info"));
    }

    /* access modifiers changed from: package-private */
    public final boolean K(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && ((Set) this.f2502e.get(str)).contains("enhanced_user_id");
    }

    /* access modifiers changed from: package-private */
    public final boolean L(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && ((Set) this.f2502e.get(str)).contains("google_signals");
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && (((Set) this.f2502e.get(str)).contains("os_version") || ((Set) this.f2502e.get(str)).contains("device_info"));
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str) {
        h();
        o(str);
        return this.f2502e.get(str) != null && ((Set) this.f2502e.get(str)).contains("user_id");
    }

    public final String b(String str, String str2) {
        h();
        o(str);
        Map map = (Map) this.f2501d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int r(String str, String str2) {
        Integer num;
        h();
        o(str);
        Map map = (Map) this.i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final s3 t(String str) {
        i();
        h();
        n.e(str);
        o(str);
        return (s3) this.h.get(str);
    }

    /* access modifiers changed from: protected */
    public final String u(String str) {
        h();
        return (String) this.n.get(str);
    }

    /* access modifiers changed from: protected */
    public final String v(String str) {
        h();
        return (String) this.m.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String w(String str) {
        h();
        o(str);
        return (String) this.l.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Set y(String str) {
        h();
        o(str);
        return (Set) this.f2502e.get(str);
    }

    /* access modifiers changed from: protected */
    public final void z(String str) {
        h();
        this.m.put(str, (Object) null);
    }
}
