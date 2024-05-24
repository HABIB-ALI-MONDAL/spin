package c.b.a.o;

import android.content.Context;
import android.util.Log;
import androidx.core.content.a;
import c.b.a.o.c;

public class f implements d {
    public c a(Context context, c.a aVar) {
        boolean z = a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}
