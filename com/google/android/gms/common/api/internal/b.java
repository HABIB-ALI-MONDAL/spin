package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.m;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final int f2065a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2066b;

    /* renamed from: c  reason: collision with root package name */
    private final a.d f2067c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2068d;

    private b(a aVar, a.d dVar, String str) {
        this.f2066b = aVar;
        this.f2067c = dVar;
        this.f2068d = str;
        this.f2065a = m.b(aVar, dVar, str);
    }

    public static <O extends a.d> b<O> a(a<O> aVar, O o, String str) {
        return new b<>(aVar, o, str);
    }

    public final String b() {
        return this.f2066b.b();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return m.a(this.f2066b, bVar.f2066b) && m.a(this.f2067c, bVar.f2067c) && m.a(this.f2068d, bVar.f2068d);
    }

    public final int hashCode() {
        return this.f2065a;
    }
}
