package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import c.d.a.a.g;
import c.d.a.b.h.j;
import c.d.a.b.h.l;
import com.google.android.gms.common.internal.n;
import com.google.firebase.h;
import com.google.firebase.installations.i;
import com.google.firebase.m.b;
import com.google.firebase.m.d;
import com.google.firebase.messaging.a1;
import com.google.firebase.n.k;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {
    private static final long n = TimeUnit.HOURS.toSeconds(8);
    private static a1 o;
    @SuppressLint({"FirebaseUnknownNullness"})
    static g p;
    static ScheduledExecutorService q;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f2881a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.iid.a.a f2882b;

    /* renamed from: c  reason: collision with root package name */
    private final i f2883c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f2884d;

    /* renamed from: e  reason: collision with root package name */
    private final m0 f2885e;

    /* renamed from: f  reason: collision with root package name */
    private final w0 f2886f;
    private final a g;
    private final Executor h;
    private final Executor i;
    private final c.d.a.b.h.i<e1> j;
    private final p0 k;
    private boolean l;
    private final Application.ActivityLifecycleCallbacks m;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private final d f2887a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2888b;

        /* renamed from: c  reason: collision with root package name */
        private b<com.google.firebase.g> f2889c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f2890d;

        a(d dVar) {
            this.f2887a = dVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(com.google.firebase.m.a aVar) {
            if (b()) {
                FirebaseMessaging.this.E();
            }
        }

        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context h = FirebaseMessaging.this.f2881a.h();
            SharedPreferences sharedPreferences = h.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = h.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(h.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void a() {
            if (!this.f2888b) {
                Boolean e2 = e();
                this.f2890d = e2;
                if (e2 == null) {
                    k kVar = new k(this);
                    this.f2889c = kVar;
                    this.f2887a.a(com.google.firebase.g.class, kVar);
                }
                this.f2888b = true;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            Boolean bool;
            a();
            bool = this.f2890d;
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f2881a.q();
        }
    }

    FirebaseMessaging(h hVar, com.google.firebase.iid.a.a aVar, i iVar, g gVar, d dVar, p0 p0Var, m0 m0Var, Executor executor, Executor executor2, Executor executor3) {
        this.l = false;
        p = gVar;
        this.f2881a = hVar;
        this.f2882b = aVar;
        this.f2883c = iVar;
        this.g = new a(dVar);
        Context h2 = hVar.h();
        this.f2884d = h2;
        l0 l0Var = new l0();
        this.m = l0Var;
        this.k = p0Var;
        this.f2885e = m0Var;
        this.f2886f = new w0(executor);
        this.h = executor2;
        this.i = executor3;
        Context h3 = hVar.h();
        if (h3 instanceof Application) {
            ((Application) h3).registerActivityLifecycleCallbacks(l0Var);
        } else {
            Log.w("FirebaseMessaging", "Context " + h3 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new m(this));
        }
        executor2.execute(new o(this));
        c.d.a.b.h.i<e1> e2 = e1.e(this, p0Var, m0Var, h2, k0.g());
        this.j = e2;
        e2.e(executor2, new n(this));
        executor2.execute(new j(this));
    }

    FirebaseMessaging(h hVar, com.google.firebase.iid.a.a aVar, com.google.firebase.o.b<com.google.firebase.q.i> bVar, com.google.firebase.o.b<k> bVar2, i iVar, g gVar, d dVar) {
        this(hVar, aVar, bVar, bVar2, iVar, gVar, dVar, new p0(hVar.h()));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FirebaseMessaging(com.google.firebase.h r12, com.google.firebase.iid.a.a r13, com.google.firebase.o.b<com.google.firebase.q.i> r14, com.google.firebase.o.b<com.google.firebase.n.k> r15, com.google.firebase.installations.i r16, c.d.a.a.g r17, com.google.firebase.m.d r18, com.google.firebase.messaging.p0 r19) {
        /*
            r11 = this;
            com.google.firebase.messaging.m0 r7 = new com.google.firebase.messaging.m0
            r0 = r7
            r1 = r12
            r2 = r19
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r8 = com.google.firebase.messaging.k0.f()
            java.util.concurrent.ScheduledExecutorService r9 = com.google.firebase.messaging.k0.c()
            java.util.concurrent.Executor r10 = com.google.firebase.messaging.k0.b()
            r0 = r11
            r2 = r13
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(com.google.firebase.h, com.google.firebase.iid.a.a, com.google.firebase.o.b, com.google.firebase.o.b, com.google.firebase.installations.i, c.d.a.a.g, com.google.firebase.m.d, com.google.firebase.messaging.p0):void");
    }

    private synchronized void D() {
        if (!this.l) {
            G(0);
        }
    }

    /* access modifiers changed from: private */
    public void E() {
        com.google.firebase.iid.a.a aVar = this.f2882b;
        if (aVar != null) {
            aVar.c();
        } else if (H(j())) {
            D();
        }
    }

    public static synchronized FirebaseMessaging f() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(h.i());
        }
        return instance;
    }

    private static synchronized a1 g(Context context) {
        a1 a1Var;
        synchronized (FirebaseMessaging.class) {
            if (o == null) {
                o = new a1(context);
            }
            a1Var = o;
        }
        return a1Var;
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(h hVar) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseMessaging = (FirebaseMessaging) hVar.g(cls);
            n.j(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    private String h() {
        return "[DEFAULT]".equals(this.f2881a.j()) ? "" : this.f2881a.l();
    }

    public static g k() {
        return p;
    }

    private void l(String str) {
        if ("[DEFAULT]".equals(this.f2881a.j())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f2881a.j());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new j0(this.f2884d).f(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ c.d.a.b.h.i p(String str, a1.a aVar) {
        return this.f2885e.d().o(this.i, new i(this, str, aVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ c.d.a.b.h.i r(String str, a1.a aVar, String str2) {
        g(this.f2884d).f(h(), str, str2, this.k.a());
        if (aVar == null || !str2.equals(aVar.f2896a)) {
            l(str2);
        }
        return l.e(str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(j jVar) {
        try {
            jVar.c(c());
        } catch (Exception e2) {
            jVar.b(e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v() {
        if (m()) {
            E();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void x(e1 e1Var) {
        if (m()) {
            e1Var.p();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z() {
        s0.b(this.f2884d);
    }

    /* access modifiers changed from: package-private */
    public synchronized void C(boolean z) {
        this.l = z;
    }

    public c.d.a.b.h.i<Void> F(String str) {
        return this.j.n(new q(str));
    }

    /* access modifiers changed from: package-private */
    public synchronized void G(long j2) {
        d(new b1(this, Math.min(Math.max(30, 2 * j2), n)), j2);
        this.l = true;
    }

    /* access modifiers changed from: package-private */
    public boolean H(a1.a aVar) {
        return aVar == null || aVar.b(this.k.a());
    }

    public c.d.a.b.h.i<Void> I(String str) {
        return this.j.n(new l(str));
    }

    /* access modifiers changed from: package-private */
    public String c() {
        com.google.firebase.iid.a.a aVar = this.f2882b;
        if (aVar != null) {
            try {
                return (String) l.a(aVar.b());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        } else {
            a1.a j2 = j();
            if (!H(j2)) {
                return j2.f2896a;
            }
            String c2 = p0.c(this.f2881a);
            try {
                return (String) l.a(this.f2886f.a(c2, new h(this, c2, j2)));
            } catch (InterruptedException | ExecutionException e3) {
                throw new IOException(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public void d(Runnable runnable, long j2) {
        synchronized (FirebaseMessaging.class) {
            if (q == null) {
                q = new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.p.a("TAG"));
            }
            q.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    public Context e() {
        return this.f2884d;
    }

    public c.d.a.b.h.i<String> i() {
        com.google.firebase.iid.a.a aVar = this.f2882b;
        if (aVar != null) {
            return aVar.b();
        }
        j jVar = new j();
        this.h.execute(new p(this, jVar));
        return jVar.a();
    }

    /* access modifiers changed from: package-private */
    public a1.a j() {
        return g(this.f2884d).d(h(), p0.c(this.f2881a));
    }

    public boolean m() {
        return this.g.b();
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.k.g();
    }
}
