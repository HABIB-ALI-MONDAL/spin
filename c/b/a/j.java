package c.b.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import c.b.a.o.c;
import c.b.a.o.d;
import c.b.a.o.h;
import c.b.a.o.i;
import c.b.a.o.m;
import c.b.a.o.n;
import c.b.a.o.p;
import c.b.a.r.e;

public class j implements i {
    private static final e k;

    /* renamed from: a  reason: collision with root package name */
    protected final c f831a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f832b;

    /* renamed from: c  reason: collision with root package name */
    final h f833c;

    /* renamed from: d  reason: collision with root package name */
    private final n f834d;

    /* renamed from: e  reason: collision with root package name */
    private final m f835e;

    /* renamed from: f  reason: collision with root package name */
    private final p f836f;
    private final Runnable g;
    private final Handler h;
    private final c.b.a.o.c i;
    private e j;

    class a implements Runnable {
        a() {
        }

        public void run() {
            j jVar = j.this;
            jVar.f833c.a(jVar);
        }
    }

    class b implements Runnable {
        final /* synthetic */ c.b.a.r.i.h j;

        b(c.b.a.r.i.h hVar) {
            this.j = hVar;
        }

        public void run() {
            j.this.l(this.j);
        }
    }

    private static class c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f837a;

        c(n nVar) {
            this.f837a = nVar;
        }

        public void a(boolean z) {
            if (z) {
                this.f837a.e();
            }
        }
    }

    static {
        e i2 = e.i(Bitmap.class);
        i2.O();
        k = i2;
        e.i(c.b.a.n.q.g.c.class).O();
        e.k(c.b.a.n.o.i.f972b).W(g.LOW).d0(true);
    }

    public j(c cVar, h hVar, m mVar, Context context) {
        this(cVar, hVar, mVar, new n(), cVar.g(), context);
    }

    j(c cVar, h hVar, m mVar, n nVar, d dVar, Context context) {
        this.f836f = new p();
        a aVar = new a();
        this.g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.h = handler;
        this.f831a = cVar;
        this.f833c = hVar;
        this.f835e = mVar;
        this.f834d = nVar;
        this.f832b = context;
        c.b.a.o.c a2 = dVar.a(context.getApplicationContext(), new c(nVar));
        this.i = a2;
        if (c.b.a.t.i.o()) {
            handler.post(aVar);
        } else {
            hVar.a(this);
        }
        hVar.a(a2);
        r(cVar.i().c());
        cVar.o(this);
    }

    private void u(c.b.a.r.i.h<?> hVar) {
        if (!t(hVar) && !this.f831a.p(hVar) && hVar.e() != null) {
            c.b.a.r.b e2 = hVar.e();
            hVar.h((c.b.a.r.b) null);
            e2.clear();
        }
    }

    public <ResourceType> i<ResourceType> i(Class<ResourceType> cls) {
        return new i<>(this.f831a, this, cls, this.f832b);
    }

    public i<Bitmap> j() {
        i<Bitmap> i2 = i(Bitmap.class);
        i2.a(k);
        return i2;
    }

    public i<Drawable> k() {
        return i(Drawable.class);
    }

    public void l(c.b.a.r.i.h<?> hVar) {
        if (hVar != null) {
            if (c.b.a.t.i.p()) {
                u(hVar);
            } else {
                this.h.post(new b(hVar));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e m() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public <T> k<?, T> n(Class<T> cls) {
        return this.f831a.i().d(cls);
    }

    public i<Drawable> o(String str) {
        i<Drawable> k2 = k();
        k2.q(str);
        return k2;
    }

    public void onDestroy() {
        this.f836f.onDestroy();
        for (c.b.a.r.i.h<?> l : this.f836f.j()) {
            l(l);
        }
        this.f836f.i();
        this.f834d.c();
        this.f833c.b(this);
        this.f833c.b(this.i);
        this.h.removeCallbacks(this.g);
        this.f831a.s(this);
    }

    public void onStart() {
        q();
        this.f836f.onStart();
    }

    public void onStop() {
        p();
        this.f836f.onStop();
    }

    public void p() {
        c.b.a.t.i.a();
        this.f834d.d();
    }

    public void q() {
        c.b.a.t.i.a();
        this.f834d.f();
    }

    /* access modifiers changed from: protected */
    public void r(e eVar) {
        e e2 = eVar.clone();
        e2.b();
        this.j = e2;
    }

    /* access modifiers changed from: package-private */
    public void s(c.b.a.r.i.h<?> hVar, c.b.a.r.b bVar) {
        this.f836f.k(hVar);
        this.f834d.g(bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean t(c.b.a.r.i.h<?> hVar) {
        c.b.a.r.b e2 = hVar.e();
        if (e2 == null) {
            return true;
        }
        if (!this.f834d.b(e2)) {
            return false;
        }
        this.f836f.l(hVar);
        hVar.h((c.b.a.r.b) null);
        return true;
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.f834d + ", treeNode=" + this.f835e + "}";
    }
}
