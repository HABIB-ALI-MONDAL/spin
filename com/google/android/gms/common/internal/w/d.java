package com.google.android.gms.common.internal.w;

import android.content.Context;
import c.d.a.b.e.b.f;
import c.d.a.b.h.i;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.u;

public final class d extends e implements t {
    private static final a.g i;
    private static final a.C0068a j;
    private static final a k;
    public static final /* synthetic */ int l = 0;

    static {
        a.g gVar = new a.g();
        i = gVar;
        c cVar = new c();
        j = cVar;
        k = new a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, u uVar) {
        super(context, k, uVar, e.a.f2049c);
    }

    public final i<Void> a(r rVar) {
        n.a a2 = n.a();
        a2.d(f.f1559a);
        a2.c(false);
        a2.b(new b(rVar));
        return c(a2.a());
    }
}
