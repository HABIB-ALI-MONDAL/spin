package com.google.android.gms.measurement.internal;

final class d8 extends q {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ u8 f2359e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d8(u8 u8Var, t5 t5Var) {
        super(t5Var);
        this.f2359e = u8Var;
    }

    public final void c() {
        u8 u8Var = this.f2359e;
        u8Var.h();
        if (u8Var.z()) {
            u8Var.f2527a.f().v().a("Inactivity, disconnecting from the service");
            u8Var.Q();
        }
    }
}
