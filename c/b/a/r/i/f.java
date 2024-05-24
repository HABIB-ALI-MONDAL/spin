package c.b.a.r.i;

import c.b.a.t.i;

public abstract class f<Z> extends a<Z> {

    /* renamed from: b  reason: collision with root package name */
    private final int f1257b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1258c;

    public f() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public f(int i, int i2) {
        this.f1257b = i;
        this.f1258c = i2;
    }

    public void a(g gVar) {
    }

    public final void g(g gVar) {
        if (i.r(this.f1257b, this.f1258c)) {
            gVar.f(this.f1257b, this.f1258c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f1257b + " and height: " + this.f1258c + ", either provide dimensions in the constructor or call override()");
    }
}
