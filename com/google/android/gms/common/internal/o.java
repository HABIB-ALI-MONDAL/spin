package com.google.android.gms.common.internal;

public final class o {

    /* renamed from: b  reason: collision with root package name */
    private static o f2221b;

    /* renamed from: c  reason: collision with root package name */
    private static final p f2222c = new p(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private p f2223a;

    private o() {
    }

    public static synchronized o b() {
        o oVar;
        synchronized (o.class) {
            if (f2221b == null) {
                f2221b = new o();
            }
            oVar = f2221b;
        }
        return oVar;
    }

    public p a() {
        return this.f2223a;
    }

    public final synchronized void c(p pVar) {
        if (pVar == null) {
            this.f2223a = f2222c;
            return;
        }
        p pVar2 = this.f2223a;
        if (pVar2 == null || pVar2.l() < pVar.l()) {
            this.f2223a = pVar;
        }
    }
}
