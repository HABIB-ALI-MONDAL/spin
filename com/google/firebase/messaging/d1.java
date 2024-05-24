package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class d1 {

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<d1> f2920d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f2921a;

    /* renamed from: b  reason: collision with root package name */
    private z0 f2922b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2923c;

    private d1(SharedPreferences sharedPreferences, Executor executor) {
        this.f2923c = executor;
        this.f2921a = sharedPreferences;
    }

    public static synchronized d1 b(Context context, Executor executor) {
        d1 d1Var;
        synchronized (d1.class) {
            d1Var = null;
            WeakReference<d1> weakReference = f2920d;
            if (weakReference != null) {
                d1Var = (d1) weakReference.get();
            }
            if (d1Var == null) {
                d1Var = new d1(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                d1Var.d();
                f2920d = new WeakReference<>(d1Var);
            }
        }
        return d1Var;
    }

    private synchronized void d() {
        this.f2922b = z0.c(this.f2921a, "topic_operation_queue", ",", this.f2923c);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(c1 c1Var) {
        return this.f2922b.a(c1Var.e());
    }

    /* access modifiers changed from: package-private */
    public synchronized c1 c() {
        return c1.a(this.f2922b.f());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean e(c1 c1Var) {
        return this.f2922b.g(c1Var.e());
    }
}
