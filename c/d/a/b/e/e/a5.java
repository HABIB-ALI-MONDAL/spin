package c.d.a.b.e.e;

public final class a5 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final a5 zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        a5 a5Var = new a5();
        zza = a5Var;
        s8.w(a5.class, a5Var);
    }

    private a5() {
    }

    public static z4 H() {
        return (z4) zza.A();
    }

    static /* synthetic */ void L(a5 a5Var, long j) {
        a5Var.zzd |= 1;
        a5Var.zze = j;
    }

    static /* synthetic */ void M(a5 a5Var, String str) {
        str.getClass();
        a5Var.zzd |= 2;
        a5Var.zzf = str;
    }

    static /* synthetic */ void N(a5 a5Var, String str) {
        str.getClass();
        a5Var.zzd |= 4;
        a5Var.zzg = str;
    }

    static /* synthetic */ void O(a5 a5Var) {
        a5Var.zzd &= -5;
        a5Var.zzg = zza.zzg;
    }

    static /* synthetic */ void P(a5 a5Var, long j) {
        a5Var.zzd |= 8;
        a5Var.zzh = j;
    }

    static /* synthetic */ void Q(a5 a5Var) {
        a5Var.zzd &= -9;
        a5Var.zzh = 0;
    }

    static /* synthetic */ void R(a5 a5Var, double d2) {
        a5Var.zzd |= 32;
        a5Var.zzj = d2;
    }

    static /* synthetic */ void S(a5 a5Var) {
        a5Var.zzd &= -33;
        a5Var.zzj = 0.0d;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new a5();
        } else {
            if (i2 == 4) {
                return new z4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final double E() {
        return this.zzj;
    }

    public final long F() {
        return this.zzh;
    }

    public final long G() {
        return this.zze;
    }

    public final String J() {
        return this.zzf;
    }

    public final String K() {
        return this.zzg;
    }

    public final boolean T() {
        return (this.zzd & 32) != 0;
    }

    public final boolean U() {
        return (this.zzd & 8) != 0;
    }

    public final boolean V() {
        return (this.zzd & 1) != 0;
    }

    public final boolean W() {
        return (this.zzd & 4) != 0;
    }
}
