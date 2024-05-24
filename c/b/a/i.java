package c.b.a;

import android.content.Context;
import android.widget.ImageView;
import c.b.a.r.b;
import c.b.a.r.c;
import c.b.a.r.d;
import c.b.a.r.e;
import c.b.a.r.g;
import c.b.a.r.i.h;

public class i<TranscodeType> implements Cloneable {
    private final Context j;
    private final j k;
    private final Class<TranscodeType> l;
    private final e m;
    private final e n;
    protected e o;
    private k<?, ? super TranscodeType> p;
    private Object q;
    private d<TranscodeType> r;
    private i<TranscodeType> s;
    private i<TranscodeType> t;
    private Float u;
    private boolean v = true;
    private boolean w;
    private boolean x;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f829a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f830b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        static {
            /*
                c.b.a.g[] r0 = c.b.a.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f830b = r0
                r1 = 1
                c.b.a.g r2 = c.b.a.g.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f830b     // Catch:{ NoSuchFieldError -> 0x001d }
                c.b.a.g r3 = c.b.a.g.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f830b     // Catch:{ NoSuchFieldError -> 0x0028 }
                c.b.a.g r4 = c.b.a.g.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f830b     // Catch:{ NoSuchFieldError -> 0x0033 }
                c.b.a.g r5 = c.b.a.g.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f829a = r4
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f829a     // Catch:{ NoSuchFieldError -> 0x004e }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x0058 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x0062 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x006d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x0078 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x0083 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f829a     // Catch:{ NoSuchFieldError -> 0x008f }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.i.a.<clinit>():void");
        }
    }

    static {
        new e().j(c.b.a.n.o.i.f972b).W(g.LOW).d0(true);
    }

    protected i(c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.k = jVar;
        this.l = cls;
        e m2 = jVar.m();
        this.m = m2;
        this.j = context;
        this.p = jVar.n(cls);
        this.o = m2;
        this.n = cVar.i();
    }

    private b b(h<TranscodeType> hVar, d<TranscodeType> dVar, e eVar) {
        return d(hVar, dVar, (c) null, this.p, eVar.x(), eVar.u(), eVar.t(), eVar);
    }

    private b d(h<TranscodeType> hVar, d<TranscodeType> dVar, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, e eVar) {
        c.b.a.r.a aVar;
        c.b.a.r.a aVar2;
        if (this.t != null) {
            aVar2 = new c.b.a.r.a(cVar);
            aVar = aVar2;
        } else {
            aVar = null;
            aVar2 = cVar;
        }
        b e2 = e(hVar, dVar, aVar2, kVar, gVar, i, i2, eVar);
        if (aVar == null) {
            return e2;
        }
        int u2 = this.t.o.u();
        int t2 = this.t.o.t();
        if (c.b.a.t.i.r(i, i2) && !this.t.o.N()) {
            u2 = eVar.u();
            t2 = eVar.t();
        }
        i<TranscodeType> iVar = this.t;
        c.b.a.r.a aVar3 = aVar;
        aVar3.s(e2, iVar.d(hVar, dVar, aVar, iVar.p, iVar.o.x(), u2, t2, this.t.o));
        return aVar3;
    }

    private b e(h<TranscodeType> hVar, d<TranscodeType> dVar, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2, e eVar) {
        c cVar2 = cVar;
        g gVar2 = gVar;
        i<TranscodeType> iVar = this.s;
        if (iVar != null) {
            if (!this.x) {
                k<?, ? super TranscodeType> kVar2 = iVar.v ? kVar : iVar.p;
                g x2 = iVar.o.G() ? this.s.o.x() : j(gVar2);
                int u2 = this.s.o.u();
                int t2 = this.s.o.t();
                if (c.b.a.t.i.r(i, i2) && !this.s.o.N()) {
                    u2 = eVar.u();
                    t2 = eVar.t();
                }
                c.b.a.r.h hVar2 = new c.b.a.r.h(cVar2);
                b s2 = s(hVar, dVar, eVar, hVar2, kVar, gVar, i, i2);
                this.x = true;
                i<TranscodeType> iVar2 = this.s;
                c.b.a.r.h hVar3 = hVar2;
                b d2 = iVar2.d(hVar, dVar, hVar2, kVar2, x2, u2, t2, iVar2.o);
                this.x = false;
                hVar3.r(s2, d2);
                return hVar3;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.u == null) {
            return s(hVar, dVar, eVar, cVar, kVar, gVar, i, i2);
        } else {
            c.b.a.r.h hVar4 = new c.b.a.r.h(cVar2);
            d<TranscodeType> dVar2 = dVar;
            c.b.a.r.h hVar5 = hVar4;
            k<?, ? super TranscodeType> kVar3 = kVar;
            int i3 = i;
            int i4 = i2;
            hVar4.r(s(hVar, dVar2, eVar, hVar5, kVar3, gVar, i3, i4), s(hVar, dVar2, eVar.clone().c0(this.u.floatValue()), hVar5, kVar3, j(gVar2), i3, i4));
            return hVar4;
        }
    }

    private g j(g gVar) {
        int i = a.f830b[gVar.ordinal()];
        if (i == 1) {
            return g.NORMAL;
        }
        if (i == 2) {
            return g.HIGH;
        }
        if (i == 3 || i == 4) {
            return g.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.o.x());
    }

    private <Y extends h<TranscodeType>> Y m(Y y, d<TranscodeType> dVar, e eVar) {
        c.b.a.t.i.a();
        c.b.a.t.h.d(y);
        if (this.w) {
            eVar.b();
            b b2 = b(y, dVar, eVar);
            b e2 = y.e();
            if (!b2.g(e2) || o(eVar, e2)) {
                this.k.l(y);
                y.h(b2);
                this.k.s(y, b2);
                return y;
            }
            b2.b();
            c.b.a.t.h.d(e2);
            if (!e2.isRunning()) {
                e2.e();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean o(e eVar, b bVar) {
        return !eVar.F() && bVar.j();
    }

    private i<TranscodeType> r(Object obj) {
        this.q = obj;
        this.w = true;
        return this;
    }

    private b s(h<TranscodeType> hVar, d<TranscodeType> dVar, e eVar, c cVar, k<?, ? super TranscodeType> kVar, g gVar, int i, int i2) {
        Context context = this.j;
        e eVar2 = this.n;
        return g.A(context, eVar2, this.q, this.l, eVar, i, i2, gVar, hVar, dVar, this.r, cVar, eVar2.e(), kVar.b());
    }

    public i<TranscodeType> a(e eVar) {
        c.b.a.t.h.d(eVar);
        this.o = i().a(eVar);
        return this;
    }

    /* renamed from: g */
    public i<TranscodeType> clone() {
        try {
            i<TranscodeType> iVar = (i) super.clone();
            iVar.o = iVar.o.clone();
            iVar.p = iVar.p.clone();
            return iVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public e i() {
        e eVar = this.m;
        e eVar2 = this.o;
        return eVar == eVar2 ? eVar2.clone() : eVar2;
    }

    public <Y extends h<TranscodeType>> Y k(Y y) {
        l(y, (d) null);
        return y;
    }

    /* access modifiers changed from: package-private */
    public <Y extends h<TranscodeType>> Y l(Y y, d<TranscodeType> dVar) {
        m(y, dVar, i());
        return y;
    }

    public c.b.a.r.i.i<ImageView, TranscodeType> n(ImageView imageView) {
        c.b.a.t.i.a();
        c.b.a.t.h.d(imageView);
        e eVar = this.o;
        if (!eVar.M() && eVar.K() && imageView.getScaleType() != null) {
            switch (a.f829a[imageView.getScaleType().ordinal()]) {
                case 1:
                    eVar = eVar.clone().P();
                    break;
                case 2:
                case 6:
                    eVar = eVar.clone().Q();
                    break;
                case 3:
                case 4:
                case 5:
                    eVar = eVar.clone().R();
                    break;
            }
        }
        c.b.a.r.i.i<ImageView, TranscodeType> a2 = this.n.a(imageView, this.l);
        m(a2, (d) null, eVar);
        return a2;
    }

    public i<TranscodeType> p(Object obj) {
        r(obj);
        return this;
    }

    public i<TranscodeType> q(String str) {
        r(str);
        return this;
    }
}
