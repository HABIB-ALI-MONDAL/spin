package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

public class y0 {

    /* renamed from: e  reason: collision with root package name */
    private static y0 f3014e;

    /* renamed from: a  reason: collision with root package name */
    private String f3015a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3016b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f3017c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f3018d = new ArrayDeque();

    private y0() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentName;
        String f2 = f(context, intent);
        if (f2 != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + f2);
            }
            intent.setClassName(context.getPackageName(), f2);
        }
        try {
            if (e(context)) {
                componentName = g1.g(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e2) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        } catch (IllegalStateException e3) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e3);
            return 402;
        }
    }

    static synchronized y0 b() {
        y0 y0Var;
        synchronized (y0.class) {
            if (f3014e == null) {
                f3014e = new y0();
            }
            y0Var = f3014e;
        }
        return y0Var;
    }

    private synchronized String f(Context context, Intent intent) {
        String str;
        String str2 = this.f3015a;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (serviceInfo != null) {
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    String str3 = serviceInfo.name;
                    if (str3 != null) {
                        if (str3.startsWith(".")) {
                            str = context.getPackageName() + serviceInfo.name;
                        } else {
                            str = serviceInfo.name;
                        }
                        this.f3015a = str;
                        return this.f3015a;
                    }
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
        }
        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    /* access modifiers changed from: package-private */
    public Intent c() {
        return this.f3018d.poll();
    }

    /* access modifiers changed from: package-private */
    public boolean d(Context context) {
        if (this.f3017c == null) {
            this.f3017c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f3016b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f3017c.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean e(Context context) {
        if (this.f3016b == null) {
            this.f3016b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f3016b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f3016b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f3018d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
