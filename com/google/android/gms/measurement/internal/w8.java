package com.google.android.gms.measurement.internal;

import android.util.Pair;
import c.d.a.b.a.a.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class w8 extends q9 {

    /* renamed from: d  reason: collision with root package name */
    private final Map f2606d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final x3 f2607e;

    /* renamed from: f  reason: collision with root package name */
    public final x3 f2608f;
    public final x3 g;
    public final x3 h;
    public final x3 i;

    w8(ca caVar) {
        super(caVar);
        b4 F = this.f2527a.F();
        F.getClass();
        this.f2607e = new x3(F, "last_delete_stale", 0);
        b4 F2 = this.f2527a.F();
        F2.getClass();
        this.f2608f = new x3(F2, "backoff", 0);
        b4 F3 = this.f2527a.F();
        F3.getClass();
        this.g = new x3(F3, "last_upload", 0);
        b4 F4 = this.f2527a.F();
        F4.getClass();
        this.h = new x3(F4, "last_upload_attempt", 0);
        b4 F5 = this.f2527a.F();
        F5.getClass();
        this.i = new x3(F5, "midnight_offset", 0);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final Pair m(String str) {
        v8 v8Var;
        h();
        long b2 = this.f2527a.a().b();
        v8 v8Var2 = (v8) this.f2606d.get(str);
        if (v8Var2 != null && b2 < v8Var2.f2593c) {
            return new Pair(v8Var2.f2591a, Boolean.valueOf(v8Var2.f2592b));
        }
        a.b(true);
        long r = b2 + this.f2527a.z().r(str, y2.f2638b);
        try {
            a.C0063a a2 = a.a(this.f2527a.d());
            if (a2 == null) {
                return new Pair("", Boolean.FALSE);
            }
            String a3 = a2.a();
            v8Var = a3 != null ? new v8(a3, a2.b(), r) : new v8("", a2.b(), r);
            this.f2606d.put(str, v8Var);
            a.b(false);
            return new Pair(v8Var.f2591a, Boolean.valueOf(v8Var.f2592b));
        } catch (Exception e2) {
            this.f2527a.f().q().b("Unable to get advertising id", e2);
            v8Var = new v8("", false, r);
        }
    }

    /* access modifiers changed from: package-private */
    public final Pair n(String str, j jVar) {
        return jVar.i(i.AD_STORAGE) ? m(str) : new Pair("", Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String o(String str, boolean z) {
        h();
        String str2 = z ? (String) m(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest t = la.t();
        if (t == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, t.digest(str2.getBytes()))});
    }
}
