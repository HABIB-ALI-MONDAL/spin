package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import c.d.a.a.i.w.a.b;
import d.a.a;

public final class j implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f1964a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1965b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1966c;

    public j(a<Context> aVar, a<c.d.a.a.i.c0.a> aVar2, a<c.d.a.a.i.c0.a> aVar3) {
        this.f1964a = aVar;
        this.f1965b = aVar2;
        this.f1966c = aVar3;
    }

    public static j a(a<Context> aVar, a<c.d.a.a.i.c0.a> aVar2, a<c.d.a.a.i.c0.a> aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, c.d.a.a.i.c0.a aVar, c.d.a.a.i.c0.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    /* renamed from: b */
    public i get() {
        return c(this.f1964a.get(), this.f1965b.get(), this.f1966c.get());
    }
}
