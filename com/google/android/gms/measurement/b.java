package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.measurement.internal.e7;
import com.google.android.gms.measurement.internal.x4;
import java.util.List;
import java.util.Map;

final class b extends e {

    /* renamed from: a  reason: collision with root package name */
    private final x4 f2297a;

    /* renamed from: b  reason: collision with root package name */
    private final e7 f2298b;

    public b(x4 x4Var) {
        super((d) null);
        n.i(x4Var);
        this.f2297a = x4Var;
        this.f2298b = x4Var.I();
    }

    public final int a(String str) {
        this.f2298b.Q(str);
        return 25;
    }

    public final long b() {
        return this.f2297a.N().r0();
    }

    public final void c(String str) {
        this.f2297a.y().l(str, this.f2297a.a().b());
    }

    public final Map d(String str, String str2, boolean z) {
        return this.f2298b.a0(str, str2, z);
    }

    public final void e(String str) {
        this.f2297a.y().m(str, this.f2297a.a().b());
    }

    public final String f() {
        return this.f2298b.V();
    }

    public final String g() {
        return this.f2298b.W();
    }

    public final String h() {
        return this.f2298b.X();
    }

    public final void i(Bundle bundle) {
        this.f2298b.D(bundle);
    }

    public final String j() {
        return this.f2298b.V();
    }

    public final void k(String str, String str2, Bundle bundle) {
        this.f2297a.I().o(str, str2, bundle);
    }

    public final void l(String str, String str2, Bundle bundle) {
        this.f2298b.r(str, str2, bundle);
    }

    public final List m(String str, String str2) {
        return this.f2298b.Z(str, str2);
    }
}
