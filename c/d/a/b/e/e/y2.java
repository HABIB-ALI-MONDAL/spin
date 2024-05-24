package c.d.a.b.e.e;

import java.util.List;

public final class y2 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final y2 zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private x8 zzg = s8.q();
    private boolean zzh;
    private e3 zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        y2 y2Var = new y2();
        zza = y2Var;
        s8.w(y2.class, y2Var);
    }

    private y2() {
    }

    public static x2 G() {
        return (x2) zza.A();
    }

    static /* synthetic */ void M(y2 y2Var, String str) {
        y2Var.zzd |= 2;
        y2Var.zzf = str;
    }

    static /* synthetic */ void N(y2 y2Var, int i, a3 a3Var) {
        a3Var.getClass();
        x8 x8Var = y2Var.zzg;
        if (!x8Var.c()) {
            y2Var.zzg = s8.r(x8Var);
        }
        y2Var.zzg.set(i, a3Var);
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", a3.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i2 == 3) {
            return new y2();
        } else {
            if (i2 == 4) {
                return new x2((u2) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzg.size();
    }

    public final int F() {
        return this.zze;
    }

    public final a3 I(int i) {
        return (a3) this.zzg.get(i);
    }

    public final e3 J() {
        e3 e3Var = this.zzi;
        return e3Var == null ? e3.F() : e3Var;
    }

    public final String K() {
        return this.zzf;
    }

    public final List L() {
        return this.zzg;
    }

    public final boolean O() {
        return this.zzj;
    }

    public final boolean P() {
        return this.zzk;
    }

    public final boolean Q() {
        return this.zzl;
    }

    public final boolean R() {
        return (this.zzd & 8) != 0;
    }

    public final boolean S() {
        return (this.zzd & 1) != 0;
    }

    public final boolean T() {
        return (this.zzd & 64) != 0;
    }
}
