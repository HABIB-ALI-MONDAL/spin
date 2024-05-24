package c.b.a.q;

import c.b.a.n.f;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f1242a = new ArrayList();

    public synchronized void a(f fVar) {
        this.f1242a.add(fVar);
    }

    public synchronized List<f> b() {
        return this.f1242a;
    }
}
