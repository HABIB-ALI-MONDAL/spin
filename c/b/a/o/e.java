package c.b.a.o;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import c.b.a.o.c;
import c.b.a.t.h;

final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1220a;

    /* renamed from: b  reason: collision with root package name */
    final c.a f1221b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1222c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1223d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f1224e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f1222c;
            eVar.f1222c = eVar.i(context);
            if (z != e.this.f1222c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f1222c);
                }
                e eVar2 = e.this;
                eVar2.f1221b.a(eVar2.f1222c);
            }
        }
    }

    e(Context context, c.a aVar) {
        this.f1220a = context.getApplicationContext();
        this.f1221b = aVar;
    }

    private void j() {
        if (!this.f1223d) {
            this.f1222c = i(this.f1220a);
            try {
                this.f1220a.registerReceiver(this.f1224e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f1223d = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e2);
                }
            }
        }
    }

    private void k() {
        if (this.f1223d) {
            this.f1220a.unregisterReceiver(this.f1224e);
            this.f1223d = false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean i(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        h.d(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        j();
    }

    public void onStop() {
        k();
    }
}
