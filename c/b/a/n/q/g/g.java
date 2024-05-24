package c.b.a.n.q.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import c.b.a.i;
import c.b.a.j;
import c.b.a.n.h;
import c.b.a.n.m;
import c.b.a.n.o.z.e;
import c.b.a.r.i.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final c.b.a.m.a f1190a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1191b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f1192c;

    /* renamed from: d  reason: collision with root package name */
    final j f1193d;

    /* renamed from: e  reason: collision with root package name */
    private final e f1194e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1195f;
    private boolean g;
    private boolean h;
    private i<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private m<Bitmap> n;
    private a o;
    private d p;

    static class a extends f<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f1196d;

        /* renamed from: e  reason: collision with root package name */
        final int f1197e;

        /* renamed from: f  reason: collision with root package name */
        private final long f1198f;
        private Bitmap g;

        a(Handler handler, int i, long j) {
            this.f1196d = handler;
            this.f1197e = i;
            this.f1198f = j;
        }

        /* access modifiers changed from: package-private */
        public Bitmap i() {
            return this.g;
        }

        /* renamed from: j */
        public void c(Bitmap bitmap, c.b.a.r.j.b<? super Bitmap> bVar) {
            this.g = bitmap;
            this.f1196d.sendMessageAtTime(this.f1196d.obtainMessage(1, this), this.f1198f);
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                g.this.n((a) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                g.this.f1193d.l((a) message.obj);
                return false;
            }
        }
    }

    interface d {
        void a();
    }

    g(c.b.a.c cVar, c.b.a.m.a aVar, int i2, int i3, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.f(), c.b.a.c.t(cVar.h()), aVar, (Handler) null, j(c.b.a.c.t(cVar.h()), i2, i3), mVar, bitmap);
    }

    g(e eVar, j jVar, c.b.a.m.a aVar, Handler handler, i<Bitmap> iVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f1192c = new ArrayList();
        this.f1193d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f1194e = eVar;
        this.f1191b = handler;
        this.i = iVar;
        this.f1190a = aVar;
        p(mVar, bitmap);
    }

    private static h g() {
        return new c.b.a.s.b(Double.valueOf(Math.random()));
    }

    private int h() {
        return c.b.a.t.i.f(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private static i<Bitmap> j(j jVar, int i2, int i3) {
        i<Bitmap> j2 = jVar.j();
        j2.a(c.b.a.r.e.k(c.b.a.n.o.i.f971a).i0(true).d0(true).U(i2, i3));
        return j2;
    }

    private void m() {
        if (this.f1195f && !this.g) {
            if (this.h) {
                c.b.a.t.h.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f1190a.i();
                this.h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                n(aVar);
                return;
            }
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f1190a.g());
            this.f1190a.e();
            this.l = new a(this.f1191b, this.f1190a.a(), uptimeMillis);
            i<Bitmap> iVar = this.i;
            iVar.a(c.b.a.r.e.b0(g()));
            iVar.p(this.f1190a);
            iVar.k(this.l);
        }
    }

    private void o() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f1194e.d(bitmap);
            this.m = null;
        }
    }

    private void q() {
        if (!this.f1195f) {
            this.f1195f = true;
            this.k = false;
            m();
        }
    }

    private void r() {
        this.f1195f = false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f1192c.clear();
        o();
        r();
        a aVar = this.j;
        if (aVar != null) {
            this.f1193d.l(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f1193d.l(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f1193d.l(aVar3);
            this.o = null;
        }
        this.f1190a.clear();
        this.k = true;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f1190a.h().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.i() : this.m;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f1197e;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Bitmap e() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1190a.f();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return c().getHeight();
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f1190a.b() + h();
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return c().getWidth();
    }

    /* access modifiers changed from: package-private */
    public void n(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.g = false;
        if (this.k) {
            this.f1191b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f1195f) {
            this.o = aVar;
        } else {
            if (aVar.i() != null) {
                o();
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.f1192c.size() - 1; size >= 0; size--) {
                    this.f1192c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f1191b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(m<Bitmap> mVar, Bitmap bitmap) {
        c.b.a.t.h.d(mVar);
        this.n = mVar;
        c.b.a.t.h.d(bitmap);
        this.m = bitmap;
        i<Bitmap> iVar = this.i;
        iVar.a(new c.b.a.r.e().e0(mVar));
        this.i = iVar;
    }

    /* access modifiers changed from: package-private */
    public void s(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f1192c.contains(bVar)) {
            boolean isEmpty = this.f1192c.isEmpty();
            this.f1192c.add(bVar);
            if (isEmpty) {
                q();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void t(b bVar) {
        this.f1192c.remove(bVar);
        if (this.f1192c.isEmpty()) {
            r();
        }
    }
}
