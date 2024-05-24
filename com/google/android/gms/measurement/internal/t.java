package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class t {

    /* renamed from: a  reason: collision with root package name */
    final String f2540a;

    /* renamed from: b  reason: collision with root package name */
    final String f2541b;

    /* renamed from: c  reason: collision with root package name */
    final long f2542c;

    /* renamed from: d  reason: collision with root package name */
    final long f2543d;

    /* renamed from: e  reason: collision with root package name */
    final long f2544e;

    /* renamed from: f  reason: collision with root package name */
    final long f2545f;
    final long g;
    final Long h;
    final Long i;
    final Long j;
    final Boolean k;

    t(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, Long l3, Boolean bool) {
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j6;
        n.e(str);
        n.e(str2);
        boolean z = true;
        n.a(j7 >= 0);
        n.a(j8 >= 0);
        n.a(j9 >= 0);
        n.a(j10 < 0 ? false : z);
        this.f2540a = str;
        this.f2541b = str2;
        this.f2542c = j7;
        this.f2543d = j8;
        this.f2544e = j9;
        this.f2545f = j5;
        this.g = j10;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    /* access modifiers changed from: package-private */
    public final t a(Long l, Long l2, Boolean bool) {
        return new t(this.f2540a, this.f2541b, this.f2542c, this.f2543d, this.f2544e, this.f2545f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* access modifiers changed from: package-private */
    public final t b(long j2, long j3) {
        return new t(this.f2540a, this.f2541b, this.f2542c, this.f2543d, this.f2544e, this.f2545f, j2, Long.valueOf(j3), this.i, this.j, this.k);
    }

    /* access modifiers changed from: package-private */
    public final t c(long j2) {
        return new t(this.f2540a, this.f2541b, this.f2542c, this.f2543d, this.f2544e, j2, this.g, this.h, this.i, this.j, this.k);
    }
}
