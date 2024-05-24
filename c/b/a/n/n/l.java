package c.b.a.n.n;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import c.b.a.g;
import c.b.a.n.a;
import c.b.a.n.n.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {
    private final Uri j;
    private final ContentResolver k;
    private T l;

    public l(ContentResolver contentResolver, Uri uri) {
        this.k = contentResolver;
        this.j = uri;
    }

    public void b() {
        T t = this.l;
        if (t != null) {
            try {
                e(t);
            } catch (IOException unused) {
            }
        }
    }

    public a c() {
        return a.LOCAL;
    }

    public void cancel() {
    }

    public final void d(g gVar, d.a<? super T> aVar) {
        try {
            T f2 = f(this.j, this.k);
            this.l = f2;
            aVar.h(f2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.g(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void e(T t);

    /* access modifiers changed from: protected */
    public abstract T f(Uri uri, ContentResolver contentResolver);
}
