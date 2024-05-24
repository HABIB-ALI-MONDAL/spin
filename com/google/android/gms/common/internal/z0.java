package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class z0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f2240a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f2241b;

    public z0(c cVar, int i) {
        this.f2241b = cVar;
        this.f2240a = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c cVar = this.f2241b;
        if (iBinder == null) {
            c.d0(cVar, 16);
            return;
        }
        synchronized (cVar.h) {
            c cVar2 = this.f2241b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            cVar2.i = (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new p0(iBinder) : (k) queryLocalInterface;
        }
        this.f2241b.e0(0, (Bundle) null, this.f2240a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f2241b.h) {
            this.f2241b.i = null;
        }
        Handler handler = this.f2241b.f2175f;
        handler.sendMessage(handler.obtainMessage(6, this.f2240a, 1));
    }
}
