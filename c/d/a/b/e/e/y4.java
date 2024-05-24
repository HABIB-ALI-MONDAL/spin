package c.d.a.b.e.e;

import java.util.List;

public final class y4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final y4 zza;
    private int zzd;
    private int zze;
    private w8 zzf = s8.o();

    static {
        y4 y4Var = new y4();
        zza = y4Var;
        s8.w(y4.class, y4Var);
    }

    private y4() {
    }

    public static x4 H() {
        return (x4) zza.A();
    }

    static /* synthetic */ void K(y4 y4Var, int i) {
        y4Var.zzd |= 1;
        y4Var.zze = i;
    }

    static /* synthetic */ void L(y4 y4Var, Iterable iterable) {
        w8 w8Var = y4Var.zzf;
        if (!w8Var.c()) {
            y4Var.zzf = s8.p(w8Var);
        }
        d7.j(iterable, y4Var.zzf);
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new y4();
        } else {
            if (i2 == 4) {
                return new x4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzf.size();
    }

    public final int F() {
        return this.zze;
    }

    public final long G(int i) {
        return this.zzf.a(i);
    }

    public final List J() {
        return this.zzf;
    }

    public final boolean M() {
        return (this.zzd & 1) != 0;
    }
}
