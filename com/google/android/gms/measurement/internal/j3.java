package com.google.android.gms.measurement.internal;

import android.util.Log;

final class j3 implements Runnable {
    final /* synthetic */ int j;
    final /* synthetic */ String k;
    final /* synthetic */ Object l;
    final /* synthetic */ Object m;
    final /* synthetic */ Object n;
    final /* synthetic */ m3 o;

    j3(m3 m3Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.o = m3Var;
        this.j = i;
        this.k = str;
        this.l = obj;
        this.m = obj2;
        this.n = obj3;
    }

    public final void run() {
        char c2;
        m3 m3Var;
        b4 F = this.o.f2527a.F();
        if (F.n()) {
            m3 m3Var2 = this.o;
            if (m3Var2.f2462c == 0) {
                if (m3Var2.f2527a.z().H()) {
                    m3Var = this.o;
                    m3Var.f2527a.e();
                    c2 = 'C';
                } else {
                    m3Var = this.o;
                    m3Var.f2527a.e();
                    c2 = 'c';
                }
                m3Var.f2462c = c2;
            }
            m3 m3Var3 = this.o;
            if (m3Var3.f2463d < 0) {
                m3Var3.f2527a.z().q();
                m3Var3.f2463d = 74029;
            }
            char charAt = "01VDIWEA?".charAt(this.j);
            m3 m3Var4 = this.o;
            String str = "2" + charAt + m3Var4.f2462c + m3Var4.f2463d + ":" + m3.A(true, this.k, this.l, this.m, this.n);
            if (str.length() > 1024) {
                str = this.k.substring(0, 1024);
            }
            z3 z3Var = F.f2316d;
            if (z3Var != null) {
                z3Var.b(str, 1);
                return;
            }
            return;
        }
        Log.println(6, this.o.C(), "Persisted config not initialized. Not logging error/warn");
    }
}
