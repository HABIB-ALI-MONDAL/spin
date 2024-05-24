package com.google.firebase.analytics.a;

import android.content.Context;
import android.os.Bundle;
import c.d.a.b.e.e.t2;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.measurement.a.a;
import com.google.firebase.g;
import com.google.firebase.h;
import com.google.firebase.m.d;
import java.util.concurrent.ConcurrentHashMap;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f2664b;

    /* renamed from: a  reason: collision with root package name */
    final a f2665a;

    b(a aVar) {
        n.i(aVar);
        this.f2665a = aVar;
        new ConcurrentHashMap();
    }

    public static a c(h hVar, Context context, d dVar) {
        n.i(hVar);
        n.i(context);
        n.i(dVar);
        n.i(context.getApplicationContext());
        if (f2664b == null) {
            synchronized (b.class) {
                if (f2664b == null) {
                    Bundle bundle = new Bundle(1);
                    if (hVar.r()) {
                        dVar.b(g.class, c.f2666a, d.f2667a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", hVar.q());
                    }
                    f2664b = new b(t2.r(context, (String) null, (String) null, (String) null, bundle).o());
                }
            }
        }
        return f2664b;
    }

    static /* synthetic */ void d(com.google.firebase.m.a aVar) {
        boolean z = ((g) aVar.a()).f2745a;
        synchronized (b.class) {
            a aVar2 = f2664b;
            n.i(aVar2);
            ((b) aVar2).f2665a.c(z);
        }
    }

    public void a(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.b.d(str) && com.google.firebase.analytics.connector.internal.b.e(str, str2)) {
            this.f2665a.b(str, str2, obj);
        }
    }

    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.b.d(str) && com.google.firebase.analytics.connector.internal.b.c(str2, bundle) && com.google.firebase.analytics.connector.internal.b.b(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle);
            this.f2665a.a(str, str2, bundle);
        }
    }
}
