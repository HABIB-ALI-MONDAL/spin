package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import c.d.a.a.i.a0.j.i0;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.a0.j.q0;
import c.d.a.a.i.b0.b;
import c.d.a.a.i.c0.a;
import c.d.a.a.i.i;
import c.d.a.a.i.j;
import c.d.a.a.i.p;
import c.d.a.a.i.x.a.c;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2014a;

    /* renamed from: b  reason: collision with root package name */
    private final e f2015b;

    /* renamed from: c  reason: collision with root package name */
    private final j0 f2016c;

    /* renamed from: d  reason: collision with root package name */
    private final y f2017d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f2018e;

    /* renamed from: f  reason: collision with root package name */
    private final b f2019f;
    private final a g;
    private final a h;
    private final i0 i;

    public u(Context context, e eVar, j0 j0Var, y yVar, Executor executor, b bVar, a aVar, a aVar2, i0 i0Var) {
        this.f2014a = context;
        this.f2015b = eVar;
        this.f2016c = j0Var;
        this.f2017d = yVar;
        this.f2018e = executor;
        this.f2019f = bVar;
        this.g = aVar;
        this.h = aVar2;
        this.i = i0Var;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ Boolean d(p pVar) {
        return Boolean.valueOf(this.f2016c.e(pVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ Iterable f(p pVar) {
        return this.f2016c.g(pVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ Object h(Iterable iterable, p pVar, long j) {
        this.f2016c.j(iterable);
        this.f2016c.k(pVar, this.g.a() + j);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ Object j(Iterable iterable) {
        this.f2016c.b(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ Object l() {
        this.i.c();
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ Object n(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.i.i((long) ((Integer) entry.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ Object p(p pVar, long j) {
        this.f2016c.k(pVar, this.g.a() + j);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ Object r(p pVar, int i2) {
        this.f2017d.a(pVar, i2 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r3.f2017d.a(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void t(c.d.a.a.i.p r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            c.d.a.a.i.b0.b r0 = r3.f2019f     // Catch:{ a -> 0x0026 }
            c.d.a.a.i.a0.j.j0 r1 = r3.f2016c     // Catch:{ a -> 0x0026 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ a -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.b r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.b     // Catch:{ a -> 0x0026 }
            r2.<init>(r1)     // Catch:{ a -> 0x0026 }
            r0.f(r2)     // Catch:{ a -> 0x0026 }
            boolean r0 = r3.b()     // Catch:{ a -> 0x0026 }
            if (r0 != 0) goto L_0x0020
            c.d.a.a.i.b0.b r0 = r3.f2019f     // Catch:{ a -> 0x0026 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.k r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.k     // Catch:{ a -> 0x0026 }
            r1.<init>(r3, r4, r5)     // Catch:{ a -> 0x0026 }
            r0.f(r1)     // Catch:{ a -> 0x0026 }
            goto L_0x002d
        L_0x0020:
            r3.u(r4, r5)     // Catch:{ a -> 0x0026 }
            goto L_0x002d
        L_0x0024:
            r4 = move-exception
            goto L_0x0031
        L_0x0026:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.y r0 = r3.f2017d     // Catch:{ all -> 0x0024 }
            int r5 = r5 + 1
            r0.a(r4, r5)     // Catch:{ all -> 0x0024 }
        L_0x002d:
            r6.run()
            return
        L_0x0031:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.u.t(c.d.a.a.i.p, int, java.lang.Runnable):void");
    }

    public j a(m mVar) {
        b bVar = this.f2019f;
        i0 i0Var = this.i;
        Objects.requireNonNull(i0Var);
        j.a a2 = j.a();
        a2.i(this.g.a());
        a2.k(this.h.a());
        a2.j("GDT_CLIENT_METRICS");
        a2.h(new i(c.d.a.a.b.b("proto"), ((c.d.a.a.i.x.a.a) bVar.f(new o(i0Var))).f()));
        return mVar.a(a2.d());
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2014a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public g u(p pVar, int i2) {
        g b2;
        m a2 = this.f2015b.a(pVar.b());
        long j = 0;
        g e2 = g.e(0);
        while (true) {
            long j2 = j;
            while (((Boolean) this.f2019f.f(new e(this, pVar))).booleanValue()) {
                Iterable<q0> iterable = (Iterable) this.f2019f.f(new g(this, pVar));
                if (!iterable.iterator().hasNext()) {
                    return e2;
                }
                if (a2 == null) {
                    c.d.a.a.i.y.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    b2 = g.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (q0 b3 : iterable) {
                        arrayList.add(b3.b());
                    }
                    if (pVar.e()) {
                        arrayList.add(a(a2));
                    }
                    f.a a3 = f.a();
                    a3.b(arrayList);
                    a3.c(pVar.c());
                    b2 = a2.b(a3.a());
                }
                e2 = b2;
                if (e2.c() == g.a.TRANSIENT_ERROR) {
                    this.f2019f.f(new h(this, iterable, pVar, j2));
                    this.f2017d.b(pVar, i2 + 1, true);
                    return e2;
                }
                this.f2019f.f(new j(this, iterable));
                if (e2.c() == g.a.OK) {
                    j = Math.max(j2, e2.b());
                    if (pVar.e()) {
                        this.f2019f.f(new l(this));
                    }
                } else if (e2.c() == g.a.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (q0 b4 : iterable) {
                        String j3 = b4.b().j();
                        hashMap.put(j3, !hashMap.containsKey(j3) ? 1 : Integer.valueOf(((Integer) hashMap.get(j3)).intValue() + 1));
                    }
                    this.f2019f.f(new f(this, hashMap));
                }
            }
            this.f2019f.f(new i(this, pVar, j2));
            return e2;
        }
    }

    public void v(p pVar, int i2, Runnable runnable) {
        this.f2018e.execute(new d(this, pVar, i2, runnable));
    }
}
