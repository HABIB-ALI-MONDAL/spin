package com.google.firebase.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.m.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3041a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f3042b;

    /* renamed from: c  reason: collision with root package name */
    private final c f3043c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3044d = c();

    public a(Context context, String str, c cVar) {
        Context a2 = a(context);
        this.f3041a = a2;
        this.f3042b = a2.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f3043c = cVar;
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : androidx.core.content.a.b(context);
    }

    private boolean c() {
        return this.f3042b.contains("firebase_data_collection_default_enabled") ? this.f3042b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f3041a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f3041a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized boolean b() {
        return this.f3044d;
    }
}
