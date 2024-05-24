package c.d.a.b.e.e;

public final class e4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final e4 zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        e4 e4Var = new e4();
        zza = e4Var;
        s8.w(e4.class, e4Var);
    }

    private e4() {
    }

    public static d4 G() {
        return (d4) zza.A();
    }

    static /* synthetic */ void I(e4 e4Var, int i) {
        e4Var.zzd |= 1;
        e4Var.zze = i;
    }

    static /* synthetic */ void J(e4 e4Var, long j) {
        e4Var.zzd |= 2;
        e4Var.zzf = j;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new e4();
        } else {
            if (i2 == 4) {
                return new d4((x3) null);
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

    public final long F() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzd & 2) != 0;
    }

    public final boolean L() {
        return (this.zzd & 1) != 0;
    }
}
