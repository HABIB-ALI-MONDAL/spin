package c.d.a.b.e.e;

public final class u3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final u3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        u3 u3Var = new u3();
        zza = u3Var;
        s8.w(u3.class, u3Var);
    }

    private u3() {
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
            return new u3();
        } else {
            if (i2 == 4) {
                return new t3((l3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
