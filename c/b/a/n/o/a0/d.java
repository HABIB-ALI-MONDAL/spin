package c.b.a.n.o.a0;

import c.b.a.n.o.a0.a;
import java.io.File;

public class d implements a.C0041a {

    /* renamed from: a  reason: collision with root package name */
    private final long f910a;

    /* renamed from: b  reason: collision with root package name */
    private final a f911b;

    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f910a = j;
        this.f911b = aVar;
    }

    public a a() {
        File a2 = this.f911b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.c(a2, this.f910a);
        }
        return null;
    }
}
