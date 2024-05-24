package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import c.d.a.b.e.b.j;

@SuppressLint({"HandlerLeak"})
final class o extends j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2258a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f2259b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(e eVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f2259b = eVar;
        this.f2258a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int g = this.f2259b.g(this.f2258a);
        if (this.f2259b.j(g)) {
            this.f2259b.q(this.f2258a, g);
        }
    }
}
