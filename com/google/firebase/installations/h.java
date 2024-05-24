package com.google.firebase.installations;

import android.text.TextUtils;
import c.d.a.b.h.i;
import c.d.a.b.h.l;
import com.google.android.gms.common.internal.n;
import com.google.firebase.components.z;
import com.google.firebase.installations.j;
import com.google.firebase.installations.r.d;
import com.google.firebase.installations.s.c;
import com.google.firebase.installations.s.f;
import com.google.firebase.n.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class h implements i {
    private static final Object m = new Object();
    private static final ThreadFactory n = new a();

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.h f2766a;

    /* renamed from: b  reason: collision with root package name */
    private final c f2767b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.installations.r.c f2768c;

    /* renamed from: d  reason: collision with root package name */
    private final p f2769d;

    /* renamed from: e  reason: collision with root package name */
    private final z<com.google.firebase.installations.r.b> f2770e;

    /* renamed from: f  reason: collision with root package name */
    private final n f2771f;
    private final Object g;
    private final ExecutorService h;
    private final ExecutorService i;
    private String j;
    private Set<com.google.firebase.installations.q.a> k;
    private final List<o> l;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2772a = new AtomicInteger(1);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f2772a.getAndIncrement())}));
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2773a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2774b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.google.firebase.installations.s.f$b[] r0 = com.google.firebase.installations.s.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2774b = r0
                r1 = 1
                com.google.firebase.installations.s.f$b r2 = com.google.firebase.installations.s.f.b.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2774b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.installations.s.f$b r3 = com.google.firebase.installations.s.f.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f2774b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.installations.s.f$b r3 = com.google.firebase.installations.s.f.b.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.firebase.installations.s.d$b[] r2 = com.google.firebase.installations.s.d.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f2773a = r2
                com.google.firebase.installations.s.d$b r3 = com.google.firebase.installations.s.d.b.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f2773a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.firebase.installations.s.d$b r2 = com.google.firebase.installations.s.d.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.h.b.<clinit>():void");
        }
    }

    h(com.google.firebase.h hVar, com.google.firebase.o.b<j> bVar) {
        this(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), n), hVar, new c(hVar.h(), bVar), new com.google.firebase.installations.r.c(hVar), p.c(), new z(new a(hVar)), new n());
    }

    h(ExecutorService executorService, com.google.firebase.h hVar, c cVar, com.google.firebase.installations.r.c cVar2, p pVar, z<com.google.firebase.installations.r.b> zVar, n nVar) {
        this.g = new Object();
        this.k = new HashSet();
        this.l = new ArrayList();
        this.f2766a = hVar;
        this.f2767b = cVar;
        this.f2768c = cVar2;
        this.f2769d = pVar;
        this.f2770e = zVar;
        this.f2771f = nVar;
        this.h = executorService;
        this.i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), n);
    }

    private String A(d dVar) {
        if ((!this.f2766a.j().equals("CHIME_ANDROID_SDK") && !this.f2766a.r()) || !dVar.m()) {
            return this.f2771f.a();
        }
        String f2 = l().f();
        return TextUtils.isEmpty(f2) ? this.f2771f.a() : f2;
    }

    private d B(d dVar) {
        com.google.firebase.installations.s.d d2 = this.f2767b.d(i(), dVar.d(), q(), j(), (dVar.d() == null || dVar.d().length() != 11) ? null : l().i());
        int i2 = b.f2773a[d2.e().ordinal()];
        if (i2 == 1) {
            return dVar.s(d2.c(), d2.d(), this.f2769d.b(), d2.b().c(), d2.b().d());
        } else if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            throw new j("Firebase Installations Service is unavailable. Please try again later.", j.a.UNAVAILABLE);
        }
    }

    private void C(Exception exc) {
        synchronized (this.g) {
            Iterator<o> it = this.l.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void D(d dVar) {
        synchronized (this.g) {
            Iterator<o> it = this.l.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void E(String str) {
        this.j = str;
    }

    private synchronized void F(d dVar, d dVar2) {
        if (this.k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            for (com.google.firebase.installations.q.a a2 : this.k) {
                a2.a(dVar2.d());
            }
        }
    }

    private i<m> c() {
        c.d.a.b.h.j jVar = new c.d.a.b.h.j();
        e(new k(this.f2769d, jVar));
        return jVar.a();
    }

    private i<String> d() {
        c.d.a.b.h.j jVar = new c.d.a.b.h.j();
        e(new l(jVar));
        return jVar.a();
    }

    private void e(o oVar) {
        synchronized (this.g) {
            this.l.add(oVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.r.d r0 = r2.o()
            boolean r1 = r0.i()     // Catch:{ j -> 0x005c }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.l()     // Catch:{ j -> 0x005c }
            if (r1 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            if (r3 != 0) goto L_0x001d
            com.google.firebase.installations.p r3 = r2.f2769d     // Catch:{ j -> 0x005c }
            boolean r3 = r3.f(r0)     // Catch:{ j -> 0x005c }
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.firebase.installations.r.d r3 = r2.h(r0)     // Catch:{ j -> 0x005c }
            goto L_0x0026
        L_0x0022:
            com.google.firebase.installations.r.d r3 = r2.B(r0)     // Catch:{ j -> 0x005c }
        L_0x0026:
            r2.r(r3)
            r2.F(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = r3.d()
            r2.E(r0)
        L_0x0039:
            boolean r0 = r3.i()
            if (r0 == 0) goto L_0x004a
            com.google.firebase.installations.j r3 = new com.google.firebase.installations.j
            com.google.firebase.installations.j$a r0 = com.google.firebase.installations.j.a.BAD_CONFIG
            r3.<init>(r0)
        L_0x0046:
            r2.C(r3)
            goto L_0x005b
        L_0x004a:
            boolean r0 = r3.j()
            if (r0 == 0) goto L_0x0058
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            goto L_0x0046
        L_0x0058:
            r2.D(r3)
        L_0x005b:
            return
        L_0x005c:
            r3 = move-exception
            r2.C(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.h.s(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void w(boolean z) {
        d p = p();
        if (z) {
            p = p.p();
        }
        D(p);
        this.i.execute(new c(this, z));
    }

    private d h(d dVar) {
        f e2 = this.f2767b.e(i(), dVar.d(), q(), dVar.f());
        int i2 = b.f2774b[e2.b().ordinal()];
        if (i2 == 1) {
            return dVar.o(e2.c(), e2.d(), this.f2769d.b());
        } else if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            if (i2 == 3) {
                E((String) null);
                return dVar.r();
            }
            throw new j("Firebase Installations Service is unavailable. Please try again later.", j.a.UNAVAILABLE);
        }
    }

    private synchronized String k() {
        return this.j;
    }

    private com.google.firebase.installations.r.b l() {
        return this.f2770e.get();
    }

    public static h m() {
        return n(com.google.firebase.h.i());
    }

    public static h n(com.google.firebase.h hVar) {
        n.b(hVar != null, "Null is not a valid value of FirebaseApp.");
        return (h) hVar.g(i.class);
    }

    private d o() {
        d d2;
        synchronized (m) {
            g a2 = g.a(this.f2766a.h(), "generatefid.lock");
            try {
                d2 = this.f2768c.d();
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.b();
                }
                throw th;
            }
        }
        return d2;
    }

    private d p() {
        d d2;
        synchronized (m) {
            g a2 = g.a(this.f2766a.h(), "generatefid.lock");
            try {
                d2 = this.f2768c.d();
                if (d2.j()) {
                    String A = A(d2);
                    com.google.firebase.installations.r.c cVar = this.f2768c;
                    d2 = d2.t(A);
                    cVar.b(d2);
                }
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.b();
                }
                throw th;
            }
        }
        return d2;
    }

    private void r(d dVar) {
        synchronized (m) {
            g a2 = g.a(this.f2766a.h(), "generatefid.lock");
            try {
                this.f2768c.b(dVar);
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.b();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v() {
        w(false);
    }

    static /* synthetic */ com.google.firebase.installations.r.b y(com.google.firebase.h hVar) {
        return new com.google.firebase.installations.r.b(hVar);
    }

    private void z() {
        n.f(j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        n.f(q(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        n.f(i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        n.b(p.h(j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        n.b(p.g(i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public i<String> a() {
        z();
        String k2 = k();
        if (k2 != null) {
            return l.e(k2);
        }
        i<String> d2 = d();
        this.h.execute(new b(this));
        return d2;
    }

    public i<m> b(boolean z) {
        z();
        i<m> c2 = c();
        this.h.execute(new d(this, z));
        return c2;
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return this.f2766a.k().b();
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f2766a.k().c();
    }

    /* access modifiers changed from: package-private */
    public String q() {
        return this.f2766a.k().e();
    }
}
