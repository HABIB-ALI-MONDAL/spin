package c.d.a.b.e.e;

public final class w3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final w3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        w3 w3Var = new w3();
        zza = w3Var;
        s8.w(w3.class, w3Var);
    }

    private w3() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new w3();
        } else {
            if (i2 == 4) {
                return new v3((l3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final String F() {
        return this.zze;
    }

    public final String G() {
        return this.zzf;
    }
}
