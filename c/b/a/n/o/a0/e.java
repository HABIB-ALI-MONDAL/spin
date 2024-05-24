package c.b.a.n.o.a0;

import android.util.Log;
import c.b.a.l.a;
import c.b.a.n.h;
import c.b.a.n.o.a0.a;
import java.io.File;
import java.io.IOException;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f912a;

    /* renamed from: b  reason: collision with root package name */
    private final File f913b;

    /* renamed from: c  reason: collision with root package name */
    private final long f914c;

    /* renamed from: d  reason: collision with root package name */
    private final c f915d = new c();

    /* renamed from: e  reason: collision with root package name */
    private a f916e;

    @Deprecated
    protected e(File file, long j) {
        this.f913b = file;
        this.f914c = j;
        this.f912a = new j();
    }

    public static a c(File file, long j) {
        return new e(file, j);
    }

    private synchronized a d() {
        if (this.f916e == null) {
            this.f916e = a.z(this.f913b, 1, 1, this.f914c);
        }
        return this.f916e;
    }

    public void a(h hVar, a.b bVar) {
        a.c v;
        String b2 = this.f912a.b(hVar);
        this.f915d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b2 + " for for Key: " + hVar);
            }
            try {
                c.b.a.l.a d2 = d();
                if (d2.x(b2) == null) {
                    v = d2.v(b2);
                    if (v != null) {
                        if (bVar.a(v.f(0))) {
                            v.e();
                        }
                        v.b();
                        this.f915d.b(b2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                v.b();
                throw th;
            }
        } finally {
            this.f915d.b(b2);
        }
    }

    public File b(h hVar) {
        String b2 = this.f912a.b(hVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b2 + " for for Key: " + hVar);
        }
        try {
            a.e x = d().x(b2);
            if (x != null) {
                return x.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
