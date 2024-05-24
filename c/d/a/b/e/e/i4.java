package c.d.a.b.e.e;

public final class i4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final i4 zza;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        i4 i4Var = new i4();
        zza = i4Var;
        s8.w(i4.class, i4Var);
    }

    private i4() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new i4();
        } else {
            if (i2 == 4) {
                return new h4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
