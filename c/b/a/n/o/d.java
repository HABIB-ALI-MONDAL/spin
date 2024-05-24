package c.b.a.n.o;

import c.b.a.n.j;
import c.b.a.n.o.a0.a;
import java.io.File;

class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final c.b.a.n.d<DataType> f946a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f947b;

    /* renamed from: c  reason: collision with root package name */
    private final j f948c;

    d(c.b.a.n.d<DataType> dVar, DataType datatype, j jVar) {
        this.f946a = dVar;
        this.f947b = datatype;
        this.f948c = jVar;
    }

    public boolean a(File file) {
        return this.f946a.a(this.f947b, file, this.f948c);
    }
}
