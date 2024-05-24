package c.d.a.b.e.e;

public final class e3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final e3 zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        e3 e3Var = new e3();
        zza = e3Var;
        s8.w(e3.class, e3Var);
    }

    private e3() {
    }

    public static e3 F() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", c3.f1606a, "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new e3();
        } else {
            if (i2 == 4) {
                return new b3((u2) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final String G() {
        return this.zzg;
    }

    public final String H() {
        return this.zzi;
    }

    public final String I() {
        return this.zzh;
    }

    public final boolean J() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzd & 1) != 0;
    }

    public final boolean L() {
        return (this.zzd & 4) != 0;
    }

    public final boolean M() {
        return (this.zzd & 2) != 0;
    }

    public final boolean N() {
        return (this.zzd & 16) != 0;
    }

    public final boolean O() {
        return (this.zzd & 8) != 0;
    }

    public final int P() {
        int a2 = d3.a(this.zze);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }
}
