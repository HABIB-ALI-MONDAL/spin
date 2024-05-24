package c.b.a.n.q.g;

import android.util.Log;
import c.b.a.n.c;
import c.b.a.n.j;
import c.b.a.n.l;
import c.b.a.n.o.u;
import c.b.a.t.a;
import java.io.File;
import java.io.IOException;

public class d implements l<c> {
    public c b(j jVar) {
        return c.SOURCE;
    }

    /* renamed from: c */
    public boolean a(u<c> uVar, File file, j jVar) {
        try {
            a.d(uVar.get().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
