package c.d.a.b.e.e;

public final class a3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final a3 zza;
    private int zzd;
    private k3 zze;
    private e3 zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        a3 a3Var = new a3();
        zza = a3Var;
        s8.w(a3.class, a3Var);
    }

    private a3() {
    }

    public static a3 F() {
        return zza;
    }

    static /* synthetic */ void J(a3 a3Var, String str) {
        a3Var.zzd |= 8;
        a3Var.zzh = str;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new a3();
        } else {
            if (i2 == 4) {
                return new z2((u2) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final e3 G() {
        e3 e3Var = this.zzf;
        return e3Var == null ? e3.F() : e3Var;
    }

    public final k3 H() {
        k3 k3Var = this.zze;
        return k3Var == null ? k3.G() : k3Var;
    }

    public final String I() {
        return this.zzh;
    }

    public final boolean K() {
        return this.zzg;
    }

    public final boolean L() {
        return (this.zzd & 4) != 0;
    }

    public final boolean M() {
        return (this.zzd & 2) != 0;
    }

    public final boolean N() {
        return (this.zzd & 8) != 0;
    }

    public final boolean O() {
        return (this.zzd & 1) != 0;
    }
}
