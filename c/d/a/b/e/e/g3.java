package c.d.a.b.e.e;

public final class g3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final g3 zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private a3 zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        g3 g3Var = new g3();
        zza = g3Var;
        s8.w(g3.class, g3Var);
    }

    private g3() {
    }

    public static f3 G() {
        return (f3) zza.A();
    }

    static /* synthetic */ void J(g3 g3Var, String str) {
        g3Var.zzd |= 2;
        g3Var.zzf = str;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new g3();
        } else {
            if (i2 == 4) {
                return new f3((u2) null);
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

    public final a3 F() {
        a3 a3Var = this.zzg;
        return a3Var == null ? a3.F() : a3Var;
    }

    public final String I() {
        return this.zzf;
    }

    public final boolean K() {
        return this.zzh;
    }

    public final boolean L() {
        return this.zzi;
    }

    public final boolean M() {
        return this.zzj;
    }

    public final boolean N() {
        return (this.zzd & 1) != 0;
    }

    public final boolean O() {
        return (this.zzd & 32) != 0;
    }
}
