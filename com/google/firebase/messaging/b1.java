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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class b1 implements Runnable {
    private final long j;
    private final PowerManager.WakeLock k;
    /* access modifiers changed from: private */
    public final FirebaseMessaging l;

    static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private b1 f2901a;

        public a(b1 b1Var) {
            this.f2901a = b1Var;
        }

        public void a() {
            if (b1.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.f2901a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public void onReceive(Context context, Intent intent) {
            b1 b1Var = this.f2901a;
            if (b1Var != null && b1Var.d()) {
                if (b1.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f2901a.l.d(this.f2901a, 0);
                this.f2901a.b().unregisterReceiver(this);
                this.f2901a = null;
            }
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public b1(FirebaseMessaging firebaseMessaging, long j2) {
        new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.google.android.gms.common.util.p.a("firebase-iid-executor"));
        this.l = firebaseMessaging;
        this.j = j2;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.k = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    /* access modifiers changed from: package-private */
    public Context b() {
        return this.l.e();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        String str;
        try {
            if (this.l.c() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            } else if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            } else {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
                return true;
            }
        } catch (IOException e2) {
            if (m0.f(e2.getMessage())) {
                str = "Token retrieval failed: " + e2.getMessage() + ". Will retry token retrieval";
            } else if (e2.getMessage() == null) {
                str = "Token retrieval failed without exception message. Will retry token retrieval";
            } else {
                throw e2;
            }
            Log.w("FirebaseMessaging", str);
            return false;
        } catch (SecurityException unused) {
            str = "Token retrieval failed with SecurityException. Will retry token retrieval";
            Log.w("FirebaseMessaging", str);
            return false;
        }
    }

    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (y0.b().e(b())) {
            this.k.acquire();
        }
        try {
            this.l.C(true);
            if (!this.l.n()) {
                this.l.C(false);
                if (y0.b().e(b())) {
                    this.k.release();
                }
            } else if (!y0.b().d(b()) || d()) {
                if (e()) {
                    this.l.C(false);
                } else {
                    this.l.G(this.j);
                }
                if (!y0.b().e(b())) {
                    return;
                }
                this.k.release();
            } else {
                new a(this).a();
                if (y0.b().e(b())) {
                    this.k.release();
                }
            }
        } catch (IOException e2) {
            Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e2.getMessage() + ". Won't retry the operation.");
            this.l.C(false);
            if (!y0.b().e(b())) {
            }
        } catch (Throwable th) {
            if (y0.b().e(b())) {
                this.k.release();
            }
            throw th;
        }
    }
}
