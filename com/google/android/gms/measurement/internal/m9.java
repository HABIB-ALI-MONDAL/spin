package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.d;

final class m9 {

    /* renamed from: a  reason: collision with root package name */
    private final d f2472a;

    /* renamed from: b  reason: collision with root package name */
    private long f2473b;

    public m9(d dVar) {
        n.i(dVar);
        this.f2472a = dVar;
    }

    public final void a() {
        this.f2473b = 0;
    }

    public final void b() {
        this.f2473b = this.f2472a.b();
    }

    public final boolean c(long j) {
        return this.f2473b == 0 || this.f2472a.b() - this.f2473b >= 3600000;
    }
}
