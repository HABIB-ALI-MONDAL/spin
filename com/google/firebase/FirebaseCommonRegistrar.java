package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.n.g;
import com.google.firebase.q.d;
import com.google.firebase.q.f;
import com.google.firebase.q.h;
import java.util.ArrayList;
import java.util.List;

public class FirebaseCommonRegistrar implements ComponentRegistrar {
    static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    static /* synthetic */ String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    static /* synthetic */ String c(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 16 || !context.getPackageManager().hasSystemFeature("android.hardware.type.television")) ? (i < 20 || !context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) ? (i < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto" : "watch" : "tv";
    }

    static /* synthetic */ String d(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? e(installerPackageName) : "";
    }

    private static String e(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    public List<n<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.b());
        arrayList.add(g.c());
        arrayList.add(h.a("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(h.a("fire-core", "20.2.0"));
        arrayList.add(h.a("device-name", e(Build.PRODUCT)));
        arrayList.add(h.a("device-model", e(Build.DEVICE)));
        arrayList.add(h.a("device-brand", e(Build.BRAND)));
        arrayList.add(h.b("android-target-sdk", d.f2741a));
        arrayList.add(h.b("android-min-sdk", e.f2743a));
        arrayList.add(h.b("android-platform", f.f2744a));
        arrayList.add(h.b("android-installer", c.f2677a));
        String a2 = f.a();
        if (a2 != null) {
            arrayList.add(h.a("kotlin", a2));
        }
        return arrayList;
    }
}
