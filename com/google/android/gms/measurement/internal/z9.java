package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.g4;
import c.d.a.b.e.e.r4;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.List;

final class z9 {

    /* renamed from: a  reason: collision with root package name */
    r4 f2656a;

    /* renamed from: b  reason: collision with root package name */
    List f2657b;

    /* renamed from: c  reason: collision with root package name */
    List f2658c;

    /* renamed from: d  reason: collision with root package name */
    long f2659d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ ca f2660e;

    /* synthetic */ z9(ca caVar, y9 y9Var) {
        this.f2660e = caVar;
    }

    private static final long b(g4 g4Var) {
        return ((g4Var.H() / 1000) / 60) / 60;
    }

    public final boolean a(long j, g4 g4Var) {
        n.i(g4Var);
        if (this.f2658c == null) {
            this.f2658c = new ArrayList();
        }
        if (this.f2657b == null) {
            this.f2657b = new ArrayList();
        }
        if (!this.f2658c.isEmpty() && b((g4) this.f2658c.get(0)) != b(g4Var)) {
            return false;
        }
        long e2 = this.f2659d + ((long) g4Var.e());
        this.f2660e.T();
        if (e2 >= ((long) Math.max(0, ((Integer) y2.i.a((Object) null)).intValue()))) {
            return false;
        }
        this.f2659d = e2;
        this.f2658c.add(g4Var);
        this.f2657b.add(Long.valueOf(j));
        int size = this.f2658c.size();
        this.f2660e.T();
        return size < Math.max(1, ((Integer) y2.j.a((Object) null)).intValue());
    }
}
