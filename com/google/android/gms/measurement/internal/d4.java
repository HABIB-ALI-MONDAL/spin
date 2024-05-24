package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.d.a.b.e.e.s0;
import c.d.a.b.e.e.t0;

public final class d4 implements ServiceConnection {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f2353a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e4 f2354b;

    d4(e4 e4Var, String str) {
        this.f2354b = e4Var;
        this.f2353a = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                t0 i = s0.i(iBinder);
                if (i == null) {
                    this.f2354b.f2364a.f().w().a("Install Referrer Service implementation was not found");
                    return;
                }
                this.f2354b.f2364a.f().v().a("Install Referrer Service connected");
                this.f2354b.f2364a.c().z(new c4(this, i, this));
            } catch (RuntimeException e2) {
                this.f2354b.f2364a.f().w().b("Exception occurred while calling Install Referrer API", e2);
            }
        } else {
            this.f2354b.f2364a.f().w().a("Install Referrer connection returned with null binder");
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2354b.f2364a.f().v().a("Install Referrer Service disconnected");
    }
}
