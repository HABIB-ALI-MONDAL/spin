package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.n;

final class u3 extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ca f2556a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2557b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2558c;

    static {
        Class<u3> cls = u3.class;
    }

    u3(ca caVar) {
        n.i(caVar);
        this.f2556a = caVar;
    }

    public final void b() {
        this.f2556a.g();
        this.f2556a.c().h();
        if (!this.f2557b) {
            this.f2556a.d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f2558c = this.f2556a.X().m();
            this.f2556a.f().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f2558c));
            this.f2557b = true;
        }
    }

    public final void c() {
        this.f2556a.g();
        this.f2556a.c().h();
        this.f2556a.c().h();
        if (this.f2557b) {
            this.f2556a.f().v().a("Unregistering connectivity change receiver");
            this.f2557b = false;
            this.f2558c = false;
            try {
                this.f2556a.d().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f2556a.f().r().b("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        this.f2556a.g();
        String action = intent.getAction();
        this.f2556a.f().v().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean m = this.f2556a.X().m();
            if (this.f2558c != m) {
                this.f2558c = m;
                this.f2556a.c().z(new t3(this, m));
                return;
            }
            return;
        }
        this.f2556a.f().w().b("NetworkBroadcastReceiver received unknown action", action);
    }
}
