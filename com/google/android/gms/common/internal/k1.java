package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import c.d.a.b.e.d.e;
import com.google.android.gms.common.m.a;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class k1 extends h {
    /* access modifiers changed from: private */
    @GuardedBy("connectionStatus")

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f2210f = new HashMap();
    /* access modifiers changed from: private */
    public final Context g;
    /* access modifiers changed from: private */
    public volatile Handler h;
    private final j1 i;
    /* access modifiers changed from: private */
    public final a j;
    private final long k;
    /* access modifiers changed from: private */
    public final long l;

    k1(Context context, Looper looper) {
        j1 j1Var = new j1(this, (i1) null);
        this.i = j1Var;
        this.g = context.getApplicationContext();
        this.h = new e(looper, j1Var);
        this.j = a.b();
        this.k = 5000;
        this.l = 300000;
    }

    /* access modifiers changed from: protected */
    public final void d(g1 g1Var, ServiceConnection serviceConnection, String str) {
        n.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2210f) {
            h1 h1Var = (h1) this.f2210f.get(g1Var);
            if (h1Var == null) {
                String obj = g1Var.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
            } else if (h1Var.h(serviceConnection)) {
                h1Var.f(serviceConnection, str);
                if (h1Var.i()) {
                    this.h.sendMessageDelayed(this.h.obtainMessage(0, g1Var), this.k);
                }
            } else {
                String obj2 = g1Var.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean f(g1 g1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j2;
        n.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2210f) {
            h1 h1Var = (h1) this.f2210f.get(g1Var);
            if (h1Var == null) {
                h1Var = new h1(this, g1Var);
                h1Var.d(serviceConnection, serviceConnection, str);
                h1Var.e(str, executor);
                this.f2210f.put(g1Var, h1Var);
            } else {
                this.h.removeMessages(0, g1Var);
                if (!h1Var.h(serviceConnection)) {
                    h1Var.d(serviceConnection, serviceConnection, str);
                    int a2 = h1Var.a();
                    if (a2 == 1) {
                        serviceConnection.onServiceConnected(h1Var.b(), h1Var.c());
                    } else if (a2 == 2) {
                        h1Var.e(str, executor);
                    }
                } else {
                    String obj = g1Var.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
            }
            j2 = h1Var.j();
        }
        return j2;
    }
}
