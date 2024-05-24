package c.d.a.b.e.e;

public final class o3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final o3 zza;
    private int zzd;
    private String zze = "";
    private x8 zzf = s8.q();
    private boolean zzg;

    static {
        o3 o3Var = new o3();
        zza = o3Var;
        s8.w(o3.class, o3Var);
    }

    private o3() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", u3.class, "zzg"});
        } else if (i2 == 3) {
            return new o3();
        } else {
            if (i2 == 4) {
                return new n3((l3) null);
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
}
