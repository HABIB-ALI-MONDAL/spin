package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class f0 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f2088a;

    /* renamed from: b  reason: collision with root package name */
    private final e0 f2089b;

    public f0(e0 e0Var) {
        this.f2089b = e0Var;
    }

    public final void a(Context context) {
        this.f2088a = context;
    }

    public final synchronized void b() {
        Context context = this.f2088a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f2088a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f2089b.a();
            b();
        }
    }
}
