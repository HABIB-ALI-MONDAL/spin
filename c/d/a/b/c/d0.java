package c.d.a.b.c;

import android.util.Log;
import c.d.a.b.h.j;
import java.io.IOException;

public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ j j;

    public /* synthetic */ d0(j jVar) {
        this.j = jVar;
    }

    public final void run() {
        if (this.j.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
