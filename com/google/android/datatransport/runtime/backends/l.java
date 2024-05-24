package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import c.d.a.a.i.w.a.b;
import d.a.a;

public final class l implements b<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f1972a;

    /* renamed from: b  reason: collision with root package name */
    private final a<i> f1973b;

    public l(a<Context> aVar, a<i> aVar2) {
        this.f1972a = aVar;
        this.f1973b = aVar2;
    }

    public static l a(a<Context> aVar, a<i> aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    /* renamed from: b */
    public k get() {
        return c(this.f1972a.get(), this.f1973b.get());
    }
}
