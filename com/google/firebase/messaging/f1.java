package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

class f1 implements Runnable {
    private static final Object o = new Object();
    private static Boolean p;
    private static Boolean q;
    /* access modifiers changed from: private */
    public final Context j;
    private final p0 k;
    private final PowerManager.WakeLock l;
    /* access modifiers changed from: private */
    public final e1 m;
    private final long n;

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private f1 f2937a;

        public a(f1 f1Var) {
            this.f2937a = f1Var;
        }

        public void a() {
            if (f1.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            f1.this.j.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            f1 f1Var = this.f2937a;
            if (f1Var != null) {
                if (f1Var.i()) {
                    if (f1.j()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    this.f2937a.m.l(this.f2937a, 0);
                    context.unregisterReceiver(this);
                    this.f2937a = null;
                }
            }
        }
    }

    f1(e1 e1Var, Context context, p0 p0Var, long j2) {
        this.m = e1Var;
        this.j = context;
        this.n = j2;
        this.k = p0Var;
        this.l = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean booleanValue;
        synchronized (o) {
            Boolean bool = q;
            Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            q = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z;
    }

    private static boolean h(Context context) {
        boolean booleanValue;
        synchronized (o) {
            Boolean bool = p;
            Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            p = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.j.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.j)) {
            this.l.acquire(g0.f2939a);
        }
        try {
            this.m.n(true);
            if (!this.k.g()) {
                this.m.n(false);
                if (h(this.j)) {
                    try {
                        this.l.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!f(this.j) || i()) {
                if (this.m.r()) {
                    this.m.n(false);
                } else {
                    this.m.s(this.n);
                }
                if (h(this.j)) {
                    try {
                        wakeLock = this.l;
                        wakeLock.release();
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                new a(this).a();
                if (h(this.j)) {
                    try {
                        this.l.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e2) {
            Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e2.getMessage());
            this.m.n(false);
            if (h(this.j)) {
                wakeLock = this.l;
            }
        } catch (Throwable th) {
            if (h(this.j)) {
                try {
                    this.l.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
