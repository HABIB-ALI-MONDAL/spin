package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.Callable;

final class v9 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ qa f2594a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ca f2595b;

    v9(ca caVar, qa qaVar) {
        this.f2595b = caVar;
        this.f2594a = qaVar;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        ca caVar = this.f2595b;
        String str = this.f2594a.j;
        n.i(str);
        j U = caVar.U(str);
        i iVar = i.ANALYTICS_STORAGE;
        if (U.i(iVar) && j.b(this.f2594a.E).i(iVar)) {
            return this.f2595b.S(this.f2594a).e0();
        }
        this.f2595b.f().v().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
