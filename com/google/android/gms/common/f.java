package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import c.d.a.b.e.d.d;
import com.google.android.gms.common.internal.m1;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.h;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2160a = i.f2162a;

    /* renamed from: b  reason: collision with root package name */
    private static final f f2161b = new f();

    f() {
    }

    public static f f() {
        return f2161b;
    }

    public int a(Context context) {
        return i.a(context);
    }

    public Intent b(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            if (context != null && h.d(context)) {
                return m1.a();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(f2160a);
            sb.append("-");
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    sb.append(c.a(context).e(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return m1.b("com.google.android.gms", sb.toString());
        } else if (i != 3) {
            return null;
        } else {
            return m1.c("com.google.android.gms");
        }
    }

    public PendingIntent c(Context context, int i, int i2) {
        return d(context, i, i2, (String) null);
    }

    public PendingIntent d(Context context, int i, int i2, String str) {
        Intent b2 = b(context, i, str);
        if (b2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, b2, d.f1567a | 134217728);
    }

    public String e(int i) {
        return i.b(i);
    }

    public int g(Context context) {
        return h(context, f2160a);
    }

    public int h(Context context, int i) {
        int e2 = i.e(context, i);
        if (i.f(context, e2)) {
            return 18;
        }
        return e2;
    }

    public boolean i(Context context, String str) {
        return i.j(context, str);
    }

    public boolean j(int i) {
        return i.h(i);
    }
}
