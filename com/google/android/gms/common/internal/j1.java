package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class j1 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k1 f2209a;

    /* synthetic */ j1(k1 k1Var, i1 i1Var) {
        this.f2209a = k1Var;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f2209a.f2210f) {
                g1 g1Var = (g1) message.obj;
                h1 h1Var = (h1) this.f2209a.f2210f.get(g1Var);
                if (h1Var != null && h1Var.i()) {
                    if (h1Var.j()) {
                        h1Var.g("GmsClientSupervisor");
                    }
                    this.f2209a.f2210f.remove(g1Var);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f2209a.f2210f) {
                g1 g1Var2 = (g1) message.obj;
                h1 h1Var2 = (h1) this.f2209a.f2210f.get(g1Var2);
                if (h1Var2 != null && h1Var2.a() == 3) {
                    String valueOf = String.valueOf(g1Var2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName b2 = h1Var2.b();
                    if (b2 == null) {
                        b2 = g1Var2.b();
                    }
                    if (b2 == null) {
                        String d2 = g1Var2.d();
                        n.i(d2);
                        b2 = new ComponentName(d2, "unknown");
                    }
                    h1Var2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
