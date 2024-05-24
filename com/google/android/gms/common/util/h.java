package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.i;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f2264a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f2265b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f2266c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f2267d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2267d == null) {
            boolean z = false;
            if (k.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            f2267d = Boolean.valueOf(z);
        }
        return f2267d.booleanValue();
    }

    public static boolean b() {
        int i = i.f2162a;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f2264a == null) {
            boolean z = false;
            if (k.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            f2264a = Boolean.valueOf(z);
        }
        return f2264a.booleanValue();
    }

    @TargetApi(26)
    public static boolean d(Context context) {
        if (c(context) && !k.g()) {
            return true;
        }
        if (e(context)) {
            return !k.h() || k.k();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean e(Context context) {
        if (f2265b == null) {
            boolean z = false;
            if (k.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            f2265b = Boolean.valueOf(z);
        }
        return f2265b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f2266c == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f2266c = Boolean.valueOf(z);
        }
        return f2266c.booleanValue();
    }
}
