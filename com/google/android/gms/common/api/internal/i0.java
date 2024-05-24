package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import c.d.a.b.h.d;
import c.d.a.b.h.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.util.b;

final class i0 implements d {

    /* renamed from: a  reason: collision with root package name */
    private final e f2099a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2100b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2101c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2102d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2103e;

    i0(e eVar, int i, b bVar, long j, long j2, String str, String str2) {
        this.f2099a = eVar;
        this.f2100b = i;
        this.f2101c = bVar;
        this.f2102d = j;
        this.f2103e = j2;
    }

    static i0 b(e eVar, int i, b bVar) {
        boolean z;
        if (!eVar.f()) {
            return null;
        }
        p a2 = o.b().a();
        if (a2 == null) {
            z = true;
        } else if (!a2.j()) {
            return null;
        } else {
            z = a2.k();
            z w = eVar.w(bVar);
            if (w != null) {
                if (!(w.v() instanceof c)) {
                    return null;
                }
                c cVar = (c) w.v();
                if (cVar.J() && !cVar.b()) {
                    e c2 = c(w, cVar, i);
                    if (c2 == null) {
                        return null;
                    }
                    w.G();
                    z = c2.l();
                }
            }
        }
        return new i0(eVar, i, bVar, z ? System.currentTimeMillis() : 0, z ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    private static e c(z zVar, c cVar, int i) {
        int[] i2;
        int[] j;
        e H = cVar.H();
        if (H == null || !H.k() || ((i2 = H.i()) != null ? !b.b(i2, i) : !((j = H.j()) == null || !b.b(j, i))) || zVar.s() >= H.g()) {
            return null;
        }
        return H;
    }

    public final void a(i iVar) {
        z w;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j;
        long j2;
        if (this.f2099a.f()) {
            p a2 = o.b().a();
            if ((a2 == null || a2.j()) && (w = this.f2099a.w(this.f2101c)) != null && (w.v() instanceof c)) {
                c cVar = (c) w.v();
                boolean z = true;
                boolean z2 = this.f2102d > 0;
                int z3 = cVar.z();
                if (a2 != null) {
                    boolean k = z2 & a2.k();
                    int g = a2.g();
                    int i7 = a2.i();
                    i3 = a2.l();
                    if (cVar.J() && !cVar.b()) {
                        e c2 = c(w, cVar, this.f2100b);
                        if (c2 != null) {
                            if (!c2.l() || this.f2102d <= 0) {
                                z = false;
                            }
                            i7 = c2.g();
                            k = z;
                        } else {
                            return;
                        }
                    }
                    i2 = g;
                    i = i7;
                } else {
                    i3 = 0;
                    i2 = 5000;
                    i = 100;
                }
                e eVar = this.f2099a;
                if (iVar.m()) {
                    i5 = 0;
                    i4 = 0;
                } else {
                    if (iVar.k()) {
                        i5 = 100;
                    } else {
                        Exception h = iVar.h();
                        if (h instanceof com.google.android.gms.common.api.b) {
                            Status a3 = ((com.google.android.gms.common.api.b) h).a();
                            int i8 = a3.i();
                            com.google.android.gms.common.b g2 = a3.g();
                            i4 = g2 == null ? -1 : g2.g();
                            i5 = i8;
                        } else {
                            i5 = 101;
                        }
                    }
                    i4 = -1;
                }
                if (z2) {
                    long j3 = this.f2102d;
                    j = System.currentTimeMillis();
                    j2 = j3;
                    i6 = (int) (SystemClock.elapsedRealtime() - this.f2103e);
                } else {
                    j2 = 0;
                    j = 0;
                    i6 = -1;
                }
                eVar.E(new l(this.f2100b, i5, i4, j2, j, (String) null, (String) null, z3, i6), i3, (long) i2, i);
            }
        }
    }
}
