package androidx.lifecycle;

import androidx.lifecycle.d;
import b.b.a.b.b;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object j = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f388a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private b<m<? super T>, LiveData<T>.a> f389b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    int f390c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f391d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f392e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f393f;
    private int g;
    private boolean h;
    private boolean i;

    class LifecycleBoundObserver extends LiveData<T>.a implements e {

        /* renamed from: e  reason: collision with root package name */
        final g f394e;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.f394e = gVar;
        }

        public void d(g gVar, d.b bVar) {
            d.c b2 = this.f394e.a().b();
            if (b2 == d.c.DESTROYED) {
                LiveData.this.h(this.f396a);
                return;
            }
            d.c cVar = null;
            while (cVar != b2) {
                h(k());
                cVar = b2;
                b2 = this.f394e.a().b();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f394e.a().c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean j(g gVar) {
            return this.f394e == gVar;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return this.f394e.a().b().d(d.c.STARTED);
        }
    }

    private abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f396a;

        /* renamed from: b  reason: collision with root package name */
        boolean f397b;

        /* renamed from: c  reason: collision with root package name */
        int f398c = -1;

        a(m<? super T> mVar) {
            this.f396a = mVar;
        }

        /* access modifiers changed from: package-private */
        public void h(boolean z) {
            if (z != this.f397b) {
                this.f397b = z;
                LiveData.this.b(z ? 1 : -1);
                if (this.f397b) {
                    LiveData.this.d(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
        }

        /* access modifiers changed from: package-private */
        public boolean j(g gVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean k();
    }

    public LiveData() {
        Object obj = j;
        this.f393f = obj;
        this.f392e = obj;
        this.g = -1;
    }

    static void a(String str) {
        if (!b.b.a.a.a.b().a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void c(LiveData<T>.a aVar) {
        if (aVar.f397b) {
            if (!aVar.k()) {
                aVar.h(false);
                return;
            }
            int i2 = aVar.f398c;
            int i3 = this.g;
            if (i2 < i3) {
                aVar.f398c = i3;
                aVar.f396a.a(this.f392e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        int i3 = this.f390c;
        this.f390c = i2 + i3;
        if (!this.f391d) {
            this.f391d = true;
            while (true) {
                try {
                    int i4 = this.f390c;
                    if (i3 != i4) {
                        boolean z = i3 == 0 && i4 > 0;
                        boolean z2 = i3 > 0 && i4 == 0;
                        if (z) {
                            f();
                        } else if (z2) {
                            g();
                        }
                        i3 = i4;
                    } else {
                        return;
                    }
                } finally {
                    this.f391d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                b<K, V>.d j2 = this.f389b.j();
                while (j2.hasNext()) {
                    c((a) ((Map.Entry) j2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                c(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void e(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.a().b() != d.c.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
            a p = this.f389b.p(mVar, lifecycleBoundObserver);
            if (p != null && !p.j(gVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (p == null) {
                gVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public void h(m<? super T> mVar) {
        a("removeObserver");
        a r = this.f389b.r(mVar);
        if (r != null) {
            r.i();
            r.h(false);
        }
    }

    /* access modifiers changed from: protected */
    public void i(T t) {
        a("setValue");
        this.g++;
        this.f392e = t;
        d((LiveData<T>.a) null);
    }
}
