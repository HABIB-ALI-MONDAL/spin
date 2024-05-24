package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.g;
import c.d.a.b.h.l;
import com.google.android.gms.common.util.k;
import com.google.firebase.messaging.f0;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f2946a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f2947b;

    /* renamed from: c  reason: collision with root package name */
    private final q0 f2948c;

    public h0(Context context, q0 q0Var, ExecutorService executorService) {
        this.f2946a = executorService;
        this.f2947b = context;
        this.f2948c = q0Var;
    }

    private boolean b() {
        if (((KeyguardManager) this.f2947b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!k.f()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f2947b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.importance == 100;
            }
        }
        return false;
    }

    private void c(f0.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f2947b.getSystemService("notification")).notify(aVar.f2935b, aVar.f2936c, aVar.f2934a.b());
    }

    private n0 d() {
        n0 h = n0.h(this.f2948c.p("gcm.n.image"));
        if (h != null) {
            h.p(this.f2946a);
        }
        return h;
    }

    private void e(g.e eVar, n0 n0Var) {
        if (n0Var != null) {
            try {
                Bitmap bitmap = (Bitmap) l.b(n0Var.i(), 5, TimeUnit.SECONDS);
                eVar.o(bitmap);
                g.b bVar = new g.b();
                bVar.h(bitmap);
                bVar.g((Bitmap) null);
                eVar.w(bVar);
            } catch (ExecutionException e2) {
                Log.w("FirebaseMessaging", "Failed to download image: " + e2.getCause());
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                n0Var.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                n0Var.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f2948c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        n0 d2 = d();
        f0.a e2 = f0.e(this.f2947b, this.f2948c);
        e(e2.f2934a, d2);
        c(e2);
        return true;
    }
}
