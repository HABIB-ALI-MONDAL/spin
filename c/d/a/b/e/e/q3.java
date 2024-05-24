package c.d.a.b.e.e;

public final class q3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final q3 zza;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        q3 q3Var = new q3();
        zza = q3Var;
        s8.w(q3.class, q3Var);
    }

    private q3() {
    }

    static /* synthetic */ void H(q3 q3Var, String str) {
        str.getClass();
        q3Var.zzd |= 1;
        q3Var.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new q3();
        } else {
            if (i2 == 4) {
                return new p3((l3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzh;
    }

    public final String G() {
        return this.zze;
    }

    public final boolean I() {
        return this.zzf;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final boolean K() {
        return (this.zzd & 2) != 0;
    }

    public final boolean L() {
        return (this.zzd & 4) != 0;
    }

    public final boolean M() {
        return (this.zzd & 8) != 0;
    }
}
