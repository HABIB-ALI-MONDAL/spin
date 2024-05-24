package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import c.d.a.b.e.e.b;
import c.d.a.b.e.e.c1;
import c.d.a.b.e.e.w1;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class q5 extends a3 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ca f2514a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f2515b;

    /* renamed from: c  reason: collision with root package name */
    private String f2516c = null;

    public q5(ca caVar, String str) {
        n.i(caVar);
        this.f2514a = caVar;
    }

    private final void f0(qa qaVar, boolean z) {
        n.i(qaVar);
        n.e(qaVar.j);
        g0(qaVar.j, false);
        this.f2514a.g0().L(qaVar.k, qaVar.z);
    }

    private final void g0(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f2515b == null) {
                        if (!"com.google.android.gms".equals(this.f2516c) && !com.google.android.gms.common.util.n.a(this.f2514a.d(), Binder.getCallingUid())) {
                            if (!j.a(this.f2514a.d()).c(Binder.getCallingUid())) {
                                z2 = false;
                                this.f2515b = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.f2515b = Boolean.valueOf(z2);
                    }
                    if (this.f2515b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f2514a.f().r().b("Measurement Service called with invalid calling package. appId", m3.z(str));
                    throw e2;
                }
            }
            if (this.f2516c == null && i.i(this.f2514a.d(), Binder.getCallingUid(), str)) {
                this.f2516c = str;
            }
            if (!str.equals(this.f2516c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f2514a.f().r().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    private final void i(x xVar, qa qaVar) {
        this.f2514a.b();
        this.f2514a.j(xVar, qaVar);
    }

    public final List A(String str, String str2, String str3, boolean z) {
        g0(str, true);
        try {
            List<ha> list = (List) this.f2514a.c().s(new c5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ha haVar : list) {
                if (z || !la.W(haVar.f2406c)) {
                    arrayList.add(new fa(haVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().c("Failed to get user properties as. appId", m3.z(str), e2);
            return Collections.emptyList();
        }
    }

    public final void C(d dVar) {
        n.i(dVar);
        n.i(dVar.l);
        n.e(dVar.j);
        g0(dVar.j, true);
        e0(new a5(this, new d(dVar)));
    }

    public final List F(qa qaVar, boolean z) {
        f0(qaVar, false);
        String str = qaVar.j;
        n.i(str);
        try {
            List<ha> list = (List) this.f2514a.c().s(new n5(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ha haVar : list) {
                if (z || !la.W(haVar.f2406c)) {
                    arrayList.add(new fa(haVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().c("Failed to get user properties. appId", m3.z(qaVar.j), e2);
            return null;
        }
    }

    public final byte[] H(x xVar, String str) {
        n.e(str);
        n.i(xVar);
        g0(str, true);
        this.f2514a.f().q().b("Log and bundle. event", this.f2514a.W().d(xVar.j));
        long c2 = this.f2514a.a().c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f2514a.c().t(new l5(this, xVar, str)).get();
            if (bArr == null) {
                this.f2514a.f().r().b("Log and bundle returned null. appId", m3.z(str));
                bArr = new byte[0];
            }
            this.f2514a.f().q().d("Log and bundle processed. event, size, time_ms", this.f2514a.W().d(xVar.j), Integer.valueOf(bArr.length), Long.valueOf((this.f2514a.a().c() / 1000000) - c2));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().d("Failed to log and bundle. appId, event, error", m3.z(str), this.f2514a.W().d(xVar.j), e2);
            return null;
        }
    }

    public final void J(qa qaVar) {
        n.e(qaVar.j);
        n.i(qaVar.E);
        i5 i5Var = new i5(this, qaVar);
        n.i(i5Var);
        if (this.f2514a.c().C()) {
            i5Var.run();
        } else {
            this.f2514a.c().A(i5Var);
        }
    }

    public final List M(String str, String str2, boolean z, qa qaVar) {
        f0(qaVar, false);
        String str3 = qaVar.j;
        n.i(str3);
        try {
            List<ha> list = (List) this.f2514a.c().s(new b5(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (ha haVar : list) {
                if (z || !la.W(haVar.f2406c)) {
                    arrayList.add(new fa(haVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().c("Failed to query user properties. appId", m3.z(qaVar.j), e2);
            return Collections.emptyList();
        }
    }

    public final String N(qa qaVar) {
        f0(qaVar, false);
        return this.f2514a.i0(qaVar);
    }

    public final void O(x xVar, qa qaVar) {
        n.i(xVar);
        f0(qaVar, false);
        e0(new j5(this, xVar, qaVar));
    }

    public final void V(qa qaVar) {
        f0(qaVar, false);
        e0(new o5(this, qaVar));
    }

    public final List W(String str, String str2, qa qaVar) {
        f0(qaVar, false);
        String str3 = qaVar.j;
        n.i(str3);
        try {
            return (List) this.f2514a.c().s(new d5(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final List a0(String str, String str2, String str3) {
        g0(str, true);
        try {
            return (List) this.f2514a.c().s(new e5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f2514a.f().r().b("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c0(x xVar, qa qaVar) {
        k3 v;
        String str;
        String str2;
        if (!this.f2514a.Z().C(qaVar.j)) {
            i(xVar, qaVar);
            return;
        }
        this.f2514a.f().v().b("EES config found for", qaVar.j);
        p4 Z = this.f2514a.Z();
        String str3 = qaVar.j;
        c1 c1Var = TextUtils.isEmpty(str3) ? null : (c1) Z.j.c(str3);
        if (c1Var != null) {
            try {
                Map I = this.f2514a.f0().I(xVar.k.j(), true);
                String a2 = v5.a(xVar.j);
                if (a2 == null) {
                    a2 = xVar.j;
                }
                if (c1Var.e(new b(a2, xVar.m, I))) {
                    if (c1Var.g()) {
                        this.f2514a.f().v().b("EES edited event", xVar.j);
                        xVar = this.f2514a.f0().A(c1Var.a().b());
                    }
                    i(xVar, qaVar);
                    if (c1Var.f()) {
                        for (b bVar : c1Var.a().c()) {
                            this.f2514a.f().v().b("EES logging created event", bVar.d());
                            i(this.f2514a.f0().A(bVar), qaVar);
                        }
                        return;
                    }
                    return;
                }
            } catch (w1 unused) {
                this.f2514a.f().r().c("EES error. appId, eventName", qaVar.k, xVar.j);
            }
            v = this.f2514a.f().v();
            str = xVar.j;
            str2 = "EES was not applied to event";
        } else {
            v = this.f2514a.f().v();
            str = qaVar.j;
            str2 = "EES not loaded for";
        }
        v.b(str2, str);
        i(xVar, qaVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d0(String str, Bundle bundle) {
        n V = this.f2514a.V();
        V.h();
        V.i();
        byte[] k = V.f2504b.f0().B(new s(V.f2527a, "", str, "dep", 0, 0, bundle)).k();
        V.f2527a.f().v().c("Saving default event parameters, appId, data size", V.f2527a.D().d(str), Integer.valueOf(k.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", k);
        try {
            if (V.P().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                V.f2527a.f().r().b("Failed to insert default event parameters (got -1). appId", m3.z(str));
            }
        } catch (SQLiteException e2) {
            V.f2527a.f().r().c("Error storing default event parameters. appId", m3.z(str), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void e0(Runnable runnable) {
        n.i(runnable);
        if (this.f2514a.c().C()) {
            runnable.run();
        } else {
            this.f2514a.c().z(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public final x k(x xVar, qa qaVar) {
        v vVar;
        if (!(!"_cmp".equals(xVar.j) || (vVar = xVar.k) == null || vVar.g() == 0)) {
            String r = xVar.k.r("_cis");
            if ("referrer broadcast".equals(r) || "referrer API".equals(r)) {
                this.f2514a.f().u().b("Event has been filtered ", xVar.toString());
                return new x("_cmpx", xVar.k, xVar.l, xVar.m);
            }
        }
        return xVar;
    }

    public final void m(qa qaVar) {
        n.e(qaVar.j);
        g0(qaVar.j, false);
        e0(new f5(this, qaVar));
    }

    public final void n(long j, String str, String str2, String str3) {
        e0(new p5(this, str2, str3, str, j));
    }

    public final void t(x xVar, String str, String str2) {
        n.i(xVar);
        n.e(str);
        g0(str, true);
        e0(new k5(this, xVar, str));
    }

    public final void u(qa qaVar) {
        f0(qaVar, false);
        e0(new h5(this, qaVar));
    }

    public final void v(fa faVar, qa qaVar) {
        n.i(faVar);
        f0(qaVar, false);
        e0(new m5(this, faVar, qaVar));
    }

    public final void y(d dVar, qa qaVar) {
        n.i(dVar);
        n.i(dVar.l);
        f0(qaVar, false);
        d dVar2 = new d(dVar);
        dVar2.j = qaVar.j;
        e0(new z4(this, dVar2, qaVar));
    }

    public final void z(Bundle bundle, qa qaVar) {
        f0(qaVar, false);
        String str = qaVar.j;
        n.i(str);
        e0(new y4(this, str, bundle));
    }
}
