package c.d.a.b.e.e;

public final class u4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final u4 zza;
    private int zzd;
    private int zze = 1;
    private x8 zzf = s8.q();

    static {
        u4 u4Var = new u4();
        zza = u4Var;
        s8.w(u4.class, u4Var);
    }

    private u4() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", t4.f1752a, "zzf", i4.class});
        } else if (i2 == 3) {
            return new u4();
        } else {
            if (i2 == 4) {
                return new s4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
