package c.d.a.b.e.e;

public final class a4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final a4 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        a4 a4Var = new a4();
        zza = a4Var;
        s8.w(a4.class, a4Var);
    }

    private a4() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new a4();
        } else {
            if (i2 == 4) {
                return new z3((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
