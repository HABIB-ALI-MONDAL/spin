package c.d.a.b.e.e;

import java.util.List;

public final class f5 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final f5 zza;
    private int zzd;
    private String zze = "";
    private x8 zzf = s8.q();

    static {
        f5 f5Var = new f5();
        zza = f5Var;
        s8.w(f5.class, f5Var);
    }

    private f5() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", l5.class});
        } else if (i2 == 3) {
            return new f5();
        } else {
            if (i2 == 4) {
                return new e5((b5) null);
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

    public final List G() {
        return this.zzf;
    }
}
