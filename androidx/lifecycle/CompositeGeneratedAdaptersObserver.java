package androidx.lifecycle;

import androidx.lifecycle.d;

class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f383a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f383a = cVarArr;
    }

    public void d(g gVar, d.b bVar) {
        k kVar = new k();
        for (c a2 : this.f383a) {
            a2.a(gVar, bVar, false, kVar);
        }
        for (c a3 : this.f383a) {
            a3.a(gVar, bVar, true, kVar);
        }
    }
}
