package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.n.c;
import javax.annotation.concurrent.GuardedBy;

public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2227a = new Object();
    @GuardedBy("sLock")

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2228b;

    /* renamed from: c  reason: collision with root package name */
    private static int f2229c;

    public static int a(Context context) {
        b(context);
        return f2229c;
    }

    private static void b(Context context) {
        synchronized (f2227a) {
            if (!f2228b) {
                f2228b = true;
                try {
                    Bundle bundle = c.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        bundle.getString("com.google.app.id");
                        f2229c = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}
