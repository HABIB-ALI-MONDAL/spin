package c.d.a.b.e.e;

import java.util.List;

public final class p4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final p4 zza;
    private x8 zzd = s8.q();

    static {
        p4 p4Var = new p4();
        zza = p4Var;
        s8.w(p4.class, p4Var);
    }

    private p4() {
    }

    public static o4 E() {
        return (o4) zza.A();
    }

    static /* synthetic */ void I(p4 p4Var, r4 r4Var) {
        r4Var.getClass();
        x8 x8Var = p4Var.zzd;
        if (!x8Var.c()) {
            p4Var.zzd = s8.r(x8Var);
        }
        p4Var.zzd.add(r4Var);
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", r4.class});
        } else if (i2 == 3) {
            return new p4();
        } else {
            if (i2 == 4) {
                return new o4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final r4 G(int i) {
        return (r4) this.zzd.get(0);
    }

    public final List H() {
        return this.zzd;
    }
}
