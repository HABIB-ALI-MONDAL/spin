package c.d.a.b.e.e;

public final class c4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final c4 zza;
    private int zzd;
    private int zze;
    private w4 zzf;
    private w4 zzg;
    private boolean zzh;

    static {
        c4 c4Var = new c4();
        zza = c4Var;
        s8.w(c4.class, c4Var);
    }

    private c4() {
    }

    public static b4 F() {
        return (b4) zza.A();
    }

    static /* synthetic */ void J(c4 c4Var, int i) {
        c4Var.zzd |= 1;
        c4Var.zze = i;
    }

    static /* synthetic */ void K(c4 c4Var, w4 w4Var) {
        w4Var.getClass();
        c4Var.zzf = w4Var;
        c4Var.zzd |= 2;
    }

    static /* synthetic */ void L(c4 c4Var, w4 w4Var) {
        c4Var.zzg = w4Var;
        c4Var.zzd |= 4;
    }

    static /* synthetic */ void M(c4 c4Var, boolean z) {
        c4Var.zzd |= 8;
        c4Var.zzh = z;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new c4();
        } else {
            if (i2 == 4) {
                return new b4((x3) null);
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

    public final w4 H() {
        w4 w4Var = this.zzf;
        return w4Var == null ? w4.L() : w4Var;
    }

    public final w4 I() {
        w4 w4Var = this.zzg;
        return w4Var == null ? w4.L() : w4Var;
    }

    public final boolean N() {
        return this.zzh;
    }

    public final boolean O() {
        return (this.zzd & 1) != 0;
    }

    public final boolean P() {
        return (this.zzd & 8) != 0;
    }

    public final boolean Q() {
        return (this.zzd & 4) != 0;
    }
}
