package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static int f2196a = 4225;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2197b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static k1 f2198c = null;

    /* renamed from: d  reason: collision with root package name */
    static HandlerThread f2199d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2200e = false;

    public static int a() {
        return f2196a;
    }

    public static h b(Context context) {
        synchronized (f2197b) {
            if (f2198c == null) {
                f2198c = new k1(context.getApplicationContext(), f2200e ? c().getLooper() : context.getMainLooper());
            }
        }
        return f2198c;
    }

    public static HandlerThread c() {
        synchronized (f2197b) {
            HandlerThread handlerThread = f2199d;
            if (handlerThread != null) {
                return handlerThread;
            }
            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
            f2199d = handlerThread2;
            handlerThread2.start();
            HandlerThread handlerThread3 = f2199d;
            return handlerThread3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(g1 g1Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        d(new g1(str, str2, i, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean f(g1 g1Var, ServiceConnection serviceConnection, String str, Executor executor);
}
