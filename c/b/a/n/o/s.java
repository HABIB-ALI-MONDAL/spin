package c.b.a.n.o;

import b.d.j.d;
import c.b.a.n.j;
import c.b.a.n.n.e;
import c.b.a.n.o.h;
import c.b.a.t.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final d<List<Throwable>> f1002a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends h<Data, ResourceType, Transcode>> f1003b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1004c;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, d<List<Throwable>> dVar) {
        this.f1002a = dVar;
        h.c(list);
        this.f1003b = list;
        this.f1004c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> b(e<Data> eVar, j jVar, int i, int i2, h.a<ResourceType> aVar, List<Throwable> list) {
        List<Throwable> list2 = list;
        int size = this.f1003b.size();
        u<Transcode> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                uVar = ((h) this.f1003b.get(i3)).a(eVar, i, i2, jVar, aVar);
            } catch (p e2) {
                list2.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.f1004c, (List<Throwable>) new ArrayList(list2));
    }

    public u<Transcode> a(e<Data> eVar, j jVar, int i, int i2, h.a<ResourceType> aVar) {
        List<Throwable> b2 = this.f1002a.b();
        c.b.a.t.h.d(b2);
        List list = b2;
        try {
            return b(eVar, jVar, i, i2, aVar, list);
        } finally {
            this.f1002a.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f1003b.toArray()) + '}';
    }
}
