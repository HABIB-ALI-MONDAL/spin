package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.ie;
import java.util.List;

final class n4 implements ie {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p4 f2484a;

    n4(p4 p4Var) {
        this.f2484a = p4Var;
    }

    public final void a(int i, String str, List list, boolean z, boolean z2) {
        k3 k3Var;
        int i2 = i - 1;
        if (i2 == 0) {
            k3Var = this.f2484a.f2527a.f().q();
        } else if (i2 == 1) {
            m3 f2 = this.f2484a.f2527a.f();
            k3Var = z ? f2.t() : !z2 ? f2.s() : f2.r();
        } else if (i2 == 3) {
            k3Var = this.f2484a.f2527a.f().v();
        } else if (i2 != 4) {
            k3Var = this.f2484a.f2527a.f().u();
        } else {
            m3 f3 = this.f2484a.f2527a.f();
            k3Var = z ? f3.y() : !z2 ? f3.x() : f3.w();
        }
        int size = list.size();
        if (size == 1) {
            k3Var.b(str, list.get(0));
        } else if (size == 2) {
            k3Var.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            k3Var.a(str);
        } else {
            k3Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
