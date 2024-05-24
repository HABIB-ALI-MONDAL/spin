package c.b.a.n.o;

import android.util.Log;
import b.d.j.d;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.q.h.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class h<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f966a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends k<DataType, ResourceType>> f967b;

    /* renamed from: c  reason: collision with root package name */
    private final e<ResourceType, Transcode> f968c;

    /* renamed from: d  reason: collision with root package name */
    private final d<List<Throwable>> f969d;

    /* renamed from: e  reason: collision with root package name */
    private final String f970e;

    interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends k<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, d<List<Throwable>> dVar) {
        this.f966a = cls;
        this.f967b = list;
        this.f968c = eVar;
        this.f969d = dVar;
        this.f970e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<ResourceType> b(c.b.a.n.n.e<DataType> eVar, int i, int i2, j jVar) {
        List<Throwable> b2 = this.f969d.b();
        c.b.a.t.h.d(b2);
        List list = b2;
        try {
            return c(eVar, i, i2, jVar, list);
        } finally {
            this.f969d.a(list);
        }
    }

    private u<ResourceType> c(c.b.a.n.n.e<DataType> eVar, int i, int i2, j jVar, List<Throwable> list) {
        int size = this.f967b.size();
        u<ResourceType> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) this.f967b.get(i3);
            try {
                if (kVar.b(eVar.a(), jVar)) {
                    uVar = kVar.a(eVar.a(), i, i2, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e2);
                }
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.f970e, (List<Throwable>) new ArrayList(list));
    }

    public u<Transcode> a(c.b.a.n.n.e<DataType> eVar, int i, int i2, j jVar, a<ResourceType> aVar) {
        return this.f968c.a(aVar.a(b(eVar, i, i2, jVar)), jVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f966a + ", decoders=" + this.f967b + ", transcoder=" + this.f968c + '}';
    }
}
