package c.d.a.b.e.e;

public final class m4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final m4 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private a4 zzg;

    static {
        m4 m4Var = new m4();
        zza = m4Var;
        s8.w(m4.class, m4Var);
    }

    private m4() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new m4();
        } else {
            if (i2 == 4) {
                return new l4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
