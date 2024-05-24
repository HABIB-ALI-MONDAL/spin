package com.google.android.gms.measurement.internal;

final class a7 implements Runnable {
    final /* synthetic */ boolean j;
    final /* synthetic */ e7 k;

    a7(e7 e7Var, boolean z) {
        this.k = e7Var;
        this.j = z;
    }

    public final void run() {
        boolean o = this.k.f2527a.o();
        boolean n = this.k.f2527a.n();
        this.k.f2527a.k(this.j);
        if (n == this.j) {
            this.k.f2527a.f().v().b("Default data collection state already set to", Boolean.valueOf(this.j));
        }
        if (this.k.f2527a.o() == o || this.k.f2527a.o() != this.k.f2527a.n()) {
            this.k.f2527a.f().x().c("Default data collection is different than actual status", Boolean.valueOf(this.j), Boolean.valueOf(o));
        }
        this.k.P();
    }
}
