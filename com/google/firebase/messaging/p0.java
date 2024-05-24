package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.k;
import com.google.firebase.h;
import java.util.List;

class p0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2992a;

    /* renamed from: b  reason: collision with root package name */
    private String f2993b;

    /* renamed from: c  reason: collision with root package name */
    private String f2994c;

    /* renamed from: d  reason: collision with root package name */
    private int f2995d;

    /* renamed from: e  reason: collision with root package name */
    private int f2996e = 0;

    p0(Context context) {
        this.f2992a = context;
    }

    static String c(h hVar) {
        String d2 = hVar.k().d();
        if (d2 != null) {
            return d2;
        }
        String c2 = hVar.k().c();
        if (!c2.startsWith("1:")) {
            return c2;
        }
        String[] split = c2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f2992a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("FirebaseMessaging", "Failed to find package " + e2);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f2 = f(this.f2992a.getPackageName());
        if (f2 != null) {
            this.f2993b = Integer.toString(f2.versionCode);
            this.f2994c = f2.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String a() {
        if (this.f2993b == null) {
            h();
        }
        return this.f2993b;
    }

    /* access modifiers changed from: package-private */
    public synchronized String b() {
        if (this.f2994c == null) {
            h();
        }
        return this.f2994c;
    }

    /* access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f2;
        if (this.f2995d == 0 && (f2 = f("com.google.android.gms")) != null) {
            this.f2995d = f2.versionCode;
        }
        return this.f2995d;
    }

    /* access modifiers changed from: package-private */
    public synchronized int e() {
        int i = this.f2996e;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.f2992a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!k.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f2996e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
            if (k.h()) {
                this.f2996e = 2;
            } else {
                this.f2996e = 1;
            }
            return this.f2996e;
        }
        this.f2996e = 2;
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return e() != 0;
    }
}
