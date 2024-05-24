package c.b.a.n.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import c.b.a.n.h;
import c.b.a.n.o.o;
import c.b.a.t.i;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f895a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f896b = new Handler(Looper.getMainLooper(), new C0040a());

    /* renamed from: c  reason: collision with root package name */
    final Map<h, d> f897c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private o.a f898d;

    /* renamed from: e  reason: collision with root package name */
    private ReferenceQueue<o<?>> f899e;

    /* renamed from: f  reason: collision with root package name */
    private Thread f900f;
    private volatile boolean g;
    private volatile c h;

    /* renamed from: c.b.a.n.o.a$a  reason: collision with other inner class name */
    class C0040a implements Handler.Callback {
        C0040a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            a.this.c((d) message.obj);
            return true;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Process.setThreadPriority(10);
            a.this.b();
        }
    }

    interface c {
        void a();
    }

    static final class d extends WeakReference<o<?>> {

        /* renamed from: a  reason: collision with root package name */
        final h f902a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f903b;

        /* renamed from: c  reason: collision with root package name */
        u<?> f904c;

        d(h hVar, o<?> oVar, ReferenceQueue<? super o<?>> referenceQueue, boolean z) {
            super(oVar, referenceQueue);
            u<?> uVar;
            c.b.a.t.h.d(hVar);
            this.f902a = hVar;
            if (!oVar.f() || !z) {
                uVar = null;
            } else {
                u<?> e2 = oVar.e();
                c.b.a.t.h.d(e2);
                uVar = e2;
            }
            this.f904c = uVar;
            this.f903b = oVar.f();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f904c = null;
            clear();
        }
    }

    a(boolean z) {
        this.f895a = z;
    }

    private ReferenceQueue<o<?>> f() {
        if (this.f899e == null) {
            this.f899e = new ReferenceQueue<>();
            Thread thread = new Thread(new b(), "glide-active-resources");
            this.f900f = thread;
            thread.start();
        }
        return this.f899e;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, o<?> oVar) {
        d put = this.f897c.put(hVar, new d(hVar, oVar, f(), this.f895a));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        while (!this.g) {
            try {
                this.f896b.obtainMessage(1, (d) this.f899e.remove()).sendToTarget();
                c cVar = this.h;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(d dVar) {
        u<?> uVar;
        i.a();
        this.f897c.remove(dVar.f902a);
        if (dVar.f903b && (uVar = dVar.f904c) != null) {
            o oVar = new o(uVar, true, false);
            oVar.h(dVar.f902a, this.f898d);
            this.f898d.a(dVar.f902a, oVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(h hVar) {
        d remove = this.f897c.remove(hVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    public o<?> e(h hVar) {
        d dVar = this.f897c.get(hVar);
        if (dVar == null) {
            return null;
        }
        o<?> oVar = (o) dVar.get();
        if (oVar == null) {
            c(dVar);
        }
        return oVar;
    }

    /* access modifiers changed from: package-private */
    public void g(o.a aVar) {
        this.f898d = aVar;
    }
}
