package com.google.android.gms.common.n;

import android.content.Context;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f2256b = new c();

    /* renamed from: a  reason: collision with root package name */
    private b f2257a = null;

    public static b a(Context context) {
        return f2256b.b(context);
    }

    public final synchronized b b(Context context) {
        if (this.f2257a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f2257a = new b(context);
        }
        return this.f2257a;
    }
}
