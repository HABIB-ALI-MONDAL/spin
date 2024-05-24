package c.b.a.n.o.a0;

import android.content.Context;
import c.b.a.n.o.a0.d;
import java.io.File;

public final class f extends d {

    class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f917a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f918b;

        a(Context context, String str) {
            this.f917a = context;
            this.f918b = str;
        }

        public File a() {
            File cacheDir = this.f917a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f918b != null ? new File(cacheDir, this.f918b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public f(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
