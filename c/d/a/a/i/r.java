package c.d.a.a.i;

import c.d.a.a.b;
import c.d.a.a.c;
import c.d.a.a.e;
import c.d.a.a.f;
import c.d.a.a.h;
import c.d.a.a.i.o;

final class r<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final p f1462a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1463b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1464c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T, byte[]> f1465d;

    /* renamed from: e  reason: collision with root package name */
    private final s f1466e;

    r(p pVar, String str, b bVar, e<T, byte[]> eVar, s sVar) {
        this.f1462a = pVar;
        this.f1463b = str;
        this.f1464c = bVar;
        this.f1465d = eVar;
        this.f1466e = sVar;
    }

    static /* synthetic */ void b(Exception exc) {
    }

    public void a(c<T> cVar) {
        c(cVar, a.f1302a);
    }

    public void c(c<T> cVar, h hVar) {
        s sVar = this.f1466e;
        o.a a2 = o.a();
        a2.e(this.f1462a);
        a2.c(cVar);
        a2.f(this.f1463b);
        a2.d(this.f1465d);
        a2.b(this.f1464c);
        sVar.a(a2.a(), hVar);
    }
}
