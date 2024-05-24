package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.l;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.p;
import com.google.firebase.components.s;
import com.google.firebase.components.z;
import com.google.firebase.n.g;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class h {
    /* access modifiers changed from: private */
    public static final Object j = new Object();
    private static final Executor k = new d();
    static final Map<String, h> l = new b.c.a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f2746a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2747b;

    /* renamed from: c  reason: collision with root package name */
    private final j f2748c;

    /* renamed from: d  reason: collision with root package name */
    private final s f2749d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f2750e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f2751f = new AtomicBoolean();
    private final z<com.google.firebase.p.a> g;
    private final com.google.firebase.o.b<g> h;
    private final List<b> i = new CopyOnWriteArrayList();

    public interface b {
        void a(boolean z);
    }

    @TargetApi(14)
    private static class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<c> f2752a = new AtomicReference<>();

        private c() {
        }

        /* access modifiers changed from: private */
        public static void c(Context context) {
            if (k.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f2752a.get() == null) {
                    c cVar = new c();
                    if (f2752a.compareAndSet((Object) null, cVar)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(cVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (h.j) {
                Iterator it = new ArrayList(h.l.values()).iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (hVar.f2750e.get()) {
                        hVar.x(z);
                    }
                }
            }
        }
    }

    private static class d implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private static final Handler f2753a = new Handler(Looper.getMainLooper());

        private d() {
        }

        public void execute(Runnable runnable) {
            f2753a.post(runnable);
        }
    }

    @TargetApi(24)
    private static class e extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<e> f2754b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f2755a;

        public e(Context context) {
            this.f2755a = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f2754b.get() == null) {
                e eVar = new e(context);
                if (f2754b.compareAndSet((Object) null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f2755a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (h.j) {
                for (h b2 : h.l.values()) {
                    b2.m();
                }
            }
            c();
        }
    }

    protected h(Context context, String str, j jVar) {
        new CopyOnWriteArrayList();
        n.i(context);
        this.f2746a = context;
        n.e(str);
        this.f2747b = str;
        n.i(jVar);
        this.f2748c = jVar;
        com.google.firebase.r.c.b("Firebase");
        com.google.firebase.r.c.b("ComponentDiscovery");
        List<com.google.firebase.o.b<ComponentRegistrar>> a2 = p.b(context, ComponentDiscoveryService.class).a();
        com.google.firebase.r.c.a();
        com.google.firebase.r.c.b("Runtime");
        s.b e2 = s.e(k);
        e2.c(a2);
        e2.b(new FirebaseCommonRegistrar());
        e2.a(com.google.firebase.components.n.o(context, Context.class, new Class[0]));
        e2.a(com.google.firebase.components.n.o(this, h.class, new Class[0]));
        e2.a(com.google.firebase.components.n.o(jVar, j.class, new Class[0]));
        e2.f(new com.google.firebase.r.b());
        s d2 = e2.d();
        this.f2749d = d2;
        com.google.firebase.r.c.a();
        this.g = new z<>(new b(this, context));
        this.h = d2.b(g.class);
        e(new a(this));
        com.google.firebase.r.c.a();
    }

    private void f() {
        n.m(!this.f2751f.get(), "FirebaseApp was deleted");
    }

    public static h i() {
        h hVar;
        synchronized (j) {
            hVar = l.get("[DEFAULT]");
            if (hVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + l.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return hVar;
    }

    /* access modifiers changed from: private */
    public void m() {
        if (!b.d.g.g.a(this.f2746a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + j());
            e.b(this.f2746a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + j());
        this.f2749d.h(r());
        this.h.get().k();
    }

    public static h n(Context context) {
        synchronized (j) {
            if (l.containsKey("[DEFAULT]")) {
                h i2 = i();
                return i2;
            }
            j a2 = j.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            h o = o(context, a2);
            return o;
        }
    }

    public static h o(Context context, j jVar) {
        return p(context, jVar, "[DEFAULT]");
    }

    public static h p(Context context, j jVar, String str) {
        h hVar;
        c.c(context);
        String w = w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (j) {
            Map<String, h> map = l;
            boolean z = !map.containsKey(w);
            n.m(z, "FirebaseApp name " + w + " already exists!");
            n.j(context, "Application context cannot be null.");
            hVar = new h(context, w, jVar);
            map.put(w, hVar);
        }
        hVar.m();
        return hVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ com.google.firebase.p.a t(Context context) {
        return new com.google.firebase.p.a(context, l(), (com.google.firebase.m.c) this.f2749d.a(com.google.firebase.m.c.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(boolean z) {
        if (!z) {
            this.h.get().k();
        }
    }

    private static String w(String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    public void x(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (b a2 : this.i) {
            a2.a(z);
        }
    }

    public void e(b bVar) {
        f();
        if (this.f2750e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            bVar.a(true);
        }
        this.i.add(bVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f2747b.equals(((h) obj).j());
    }

    public <T> T g(Class<T> cls) {
        f();
        return this.f2749d.a(cls);
    }

    public Context h() {
        f();
        return this.f2746a;
    }

    public int hashCode() {
        return this.f2747b.hashCode();
    }

    public String j() {
        f();
        return this.f2747b;
    }

    public j k() {
        f();
        return this.f2748c;
    }

    public String l() {
        return com.google.android.gms.common.util.c.a(j().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.c.a(k().c().getBytes(Charset.defaultCharset()));
    }

    public boolean q() {
        f();
        return this.g.get().b();
    }

    public boolean r() {
        return "[DEFAULT]".equals(j());
    }

    public String toString() {
        m.a c2 = m.c(this);
        c2.a("name", this.f2747b);
        c2.a("options", this.f2748c);
        return c2.toString();
    }
}
