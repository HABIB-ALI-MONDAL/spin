package c.d.a.b.e.e;

import java.util.List;

public final class w2 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final w2 zza;
    private int zzd;
    private int zze;
    private x8 zzf = s8.q();
    private x8 zzg = s8.q();
    private boolean zzh;
    private boolean zzi;

    static {
        w2 w2Var = new w2();
        zza = w2Var;
        s8.w(w2.class, w2Var);
    }

    private w2() {
    }

    static /* synthetic */ void M(w2 w2Var, int i, g3 g3Var) {
        g3Var.getClass();
        x8 x8Var = w2Var.zzf;
        if (!x8Var.c()) {
            w2Var.zzf = s8.r(x8Var);
        }
        w2Var.zzf.set(i, g3Var);
    }

    static /* synthetic */ void N(w2 w2Var, int i, y2 y2Var) {
        y2Var.getClass();
        x8 x8Var = w2Var.zzg;
        if (!x8Var.c()) {
            w2Var.zzg = s8.r(x8Var);
        }
        w2Var.zzg.set(i, y2Var);
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", g3.class, "zzg", y2.class, "zzh", "zzi"});
        } else if (i2 == 3) {
            return new w2();
        } else {
            if (i2 == 4) {
                return new v2((u2) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zze;
    }

    public final int F() {
        return this.zzg.size();
    }

    public final int G() {
        return this.zzf.size();
    }

    public final y2 I(int i) {
        return (y2) this.zzg.get(i);
    }

    public final g3 J(int i) {
        return (g3) this.zzf.get(i);
    }

    public final List K() {
        return this.zzg;
    }

    public final List L() {
        return this.zzf;
    }

    public final boolean O() {
        return (this.zzd & 1) != 0;
    }
}
