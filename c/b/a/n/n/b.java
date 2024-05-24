package c.b.a.n.n;

import android.content.res.AssetManager;
import android.util.Log;
import c.b.a.g;
import c.b.a.n.a;
import c.b.a.n.n.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {
    private final String j;
    private final AssetManager k;
    private T l;

    public b(AssetManager assetManager, String str) {
        this.k = assetManager;
        this.j = str;
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

    public void d(g gVar, d.a<? super T> aVar) {
        try {
            T f2 = f(this.k, this.j);
            this.l = f2;
            aVar.h(f2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.g(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void e(T t);

    /* access modifiers changed from: protected */
    public abstract T f(AssetManager assetManager, String str);
}
