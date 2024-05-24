package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import c.d.a.b.h.i;
import c.d.a.b.h.l;
import com.google.android.gms.common.util.k;
import java.util.concurrent.Executor;

public class j0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2962c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static i1 f2963d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2964a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2965b = u.f3002a;

    public j0(Context context) {
        this.f2964a = context;
    }

    private static i<Integer> a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        if (y0.b().e(context)) {
            g1.e(context, b(context, "com.google.firebase.MESSAGING_EVENT"), intent);
        } else {
            b(context, "com.google.firebase.MESSAGING_EVENT").c(intent);
        }
        return l.e(-1);
    }

    private static i1 b(Context context, String str) {
        i1 i1Var;
        synchronized (f2962c) {
            if (f2963d == null) {
                f2963d = new i1(context, str);
            }
            i1Var = f2963d;
        }
        return i1Var;
    }

    static /* synthetic */ Integer d(i iVar) {
        return 403;
    }

    static /* synthetic */ i e(Context context, Intent intent, i iVar) {
        return (!k.h() || ((Integer) iVar.i()).intValue() != 402) ? iVar : a(context, intent).f(u.f3002a, e.f2924a);
    }

    public i<Integer> f(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return g(this.f2964a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public i<Integer> g(Context context, Intent intent) {
        boolean z = true;
        boolean z2 = k.h() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        return (!z2 || z) ? l.c(this.f2965b, new d(context, intent)).g(this.f2965b, new f(context, intent)) : a(context, intent);
    }
}
