package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class i1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2954a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f2955b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f2956c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<a> f2957d;

    /* renamed from: e  reason: collision with root package name */
    private h1 f2958e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2959f;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f2960a;

        /* renamed from: b  reason: collision with root package name */
        private final j<Void> f2961b = new j<>();

        a(Intent intent) {
            this.f2960a = intent;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f2960a.getAction() + " Releasing WakeLock.");
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(ScheduledExecutorService scheduledExecutorService) {
            c().c(scheduledExecutorService, new c0(scheduledExecutorService.schedule(new b0(this), (this.f2960a.getFlags() & 268435456) != 0 ? g1.f2940a : 9000, TimeUnit.MILLISECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2961b.e(null);
        }

        /* access modifiers changed from: package-private */
        public i<Void> c() {
            return this.f2961b.a();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    i1(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new com.google.android.gms.common.util.p.a("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    i1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f2957d = new ArrayDeque();
        this.f2959f = false;
        Context applicationContext = context.getApplicationContext();
        this.f2954a = applicationContext;
        this.f2955b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f2956c = scheduledExecutorService;
    }

    private void a() {
        while (!this.f2957d.isEmpty()) {
            this.f2957d.poll().b();
        }
    }

    private synchronized void b() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.f2957d.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            h1 h1Var = this.f2958e;
            if (h1Var == null || !h1Var.isBinderAlive()) {
                d();
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
            }
            this.f2958e.b(this.f2957d.poll());
        }
    }

    private void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f2959f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (!this.f2959f) {
            this.f2959f = true;
            try {
                if (!com.google.android.gms.common.m.a.b().a(this.f2954a, this.f2955b, this, 65)) {
                    Log.e("FirebaseMessaging", "binding to the service failed");
                    this.f2959f = false;
                    a();
                }
            } catch (SecurityException e2) {
                Log.e("FirebaseMessaging", "Exception while binding the service", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i<Void> c(Intent intent) {
        a aVar;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        aVar = new a(intent);
        aVar.a(this.f2956c);
        this.f2957d.add(aVar);
        b();
        return aVar.c();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
        }
        this.f2959f = false;
        if (!(iBinder instanceof h1)) {
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            a();
            return;
        }
        this.f2958e = (h1) iBinder;
        b();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        b();
    }
}
