package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import b.c.a;
import com.google.android.gms.common.internal.n;
import java.util.Map;

public final class d2 extends e3 {

    /* renamed from: b  reason: collision with root package name */
    private final Map f2350b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Map f2351c = new a();

    /* renamed from: d  reason: collision with root package name */
    private long f2352d;

    public d2(x4 x4Var) {
        super(x4Var);
    }

    static /* synthetic */ void i(d2 d2Var, String str, long j) {
        d2Var.h();
        n.e(str);
        if (d2Var.f2351c.isEmpty()) {
            d2Var.f2352d = j;
        }
        Integer num = (Integer) d2Var.f2351c.get(str);
        if (num != null) {
            d2Var.f2351c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (d2Var.f2351c.size() >= 100) {
            d2Var.f2527a.f().w().a("Too many ads visible");
        } else {
            d2Var.f2351c.put(str, 1);
            d2Var.f2350b.put(str, Long.valueOf(j));
        }
    }

    static /* synthetic */ void j(d2 d2Var, String str, long j) {
        d2Var.h();
        n.e(str);
        Integer num = (Integer) d2Var.f2351c.get(str);
        if (num != null) {
            m7 s = d2Var.f2527a.K().s(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                d2Var.f2351c.remove(str);
                Long l = (Long) d2Var.f2350b.get(str);
                if (l == null) {
                    d2Var.f2527a.f().r().a("First ad unit exposure time was never set");
                } else {
                    long longValue = l.longValue();
                    d2Var.f2350b.remove(str);
                    d2Var.p(str, j - longValue, s);
                }
                if (d2Var.f2351c.isEmpty()) {
                    long j2 = d2Var.f2352d;
                    if (j2 == 0) {
                        d2Var.f2527a.f().r().a("First ad exposure time was never set");
                        return;
                    }
                    d2Var.o(j - j2, s);
                    d2Var.f2352d = 0;
                    return;
                }
                return;
            }
            d2Var.f2351c.put(str, Integer.valueOf(intValue));
            return;
        }
        d2Var.f2527a.f().r().b("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void o(long j, m7 m7Var) {
        if (m7Var == null) {
            this.f2527a.f().v().a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            this.f2527a.f().v().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            la.y(m7Var, bundle, true);
            this.f2527a.I().u("am", "_xa", bundle);
        }
    }

    private final void p(String str, long j, m7 m7Var) {
        if (m7Var == null) {
            this.f2527a.f().v().a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            this.f2527a.f().v().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            la.y(m7Var, bundle, true);
            this.f2527a.I().u("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void q(long j) {
        for (String put : this.f2350b.keySet()) {
            this.f2350b.put(put, Long.valueOf(j));
        }
        if (!this.f2350b.isEmpty()) {
            this.f2352d = j;
        }
    }

    public final void l(String str, long j) {
        if (str == null || str.length() == 0) {
            this.f2527a.f().r().a("Ad unit id must be a non-empty string");
        } else {
            this.f2527a.c().z(new a(this, str, j));
        }
    }

    public final void m(String str, long j) {
        if (str == null || str.length() == 0) {
            this.f2527a.f().r().a("Ad unit id must be a non-empty string");
        } else {
            this.f2527a.c().z(new b0(this, str, j));
        }
    }

    public final void n(long j) {
        m7 s = this.f2527a.K().s(false);
        for (String str : this.f2350b.keySet()) {
            p(str, j - ((Long) this.f2350b.get(str)).longValue(), s);
        }
        if (!this.f2350b.isEmpty()) {
            o(j - this.f2352d, s);
        }
        q(j);
    }
}
