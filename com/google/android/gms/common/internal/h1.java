package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.util.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class h1 implements ServiceConnection, l1 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2203a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f2204b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2205c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f2206d;

    /* renamed from: e  reason: collision with root package name */
    private final g1 f2207e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f2208f;
    final /* synthetic */ k1 g;

    public h1(k1 k1Var, g1 g1Var) {
        this.g = k1Var;
        this.f2207e = g1Var;
    }

    public final int a() {
        return this.f2204b;
    }

    public final ComponentName b() {
        return this.f2208f;
    }

    public final IBinder c() {
        return this.f2206d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f2203a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f2204b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (k.l()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            k1 k1Var = this.g;
            boolean d2 = k1Var.j.d(k1Var.g, str, this.f2207e.c(k1Var.g), this, this.f2207e.a(), executor);
            this.f2205c = d2;
            if (d2) {
                this.g.h.sendMessageDelayed(this.g.h.obtainMessage(1, this.f2207e), this.g.l);
            } else {
                this.f2204b = 2;
                try {
                    k1 k1Var2 = this.g;
                    k1Var2.j.c(k1Var2.g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f2203a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.g.h.removeMessages(1, this.f2207e);
        k1 k1Var = this.g;
        k1Var.j.c(k1Var.g, this);
        this.f2205c = false;
        this.f2204b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f2203a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f2203a.isEmpty();
    }

    public final boolean j() {
        return this.f2205c;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f2210f) {
            this.g.h.removeMessages(1, this.f2207e);
            this.f2206d = iBinder;
            this.f2208f = componentName;
            for (ServiceConnection onServiceConnected : this.f2203a.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f2204b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f2210f) {
            this.g.h.removeMessages(1, this.f2207e);
            this.f2206d = null;
            this.f2208f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f2203a.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f2204b = 2;
        }
    }
}
