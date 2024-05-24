package c.d.a.b.e.e;

import java.util.List;

public final class h5 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final h5 zza;
    private int zzd;
    private x8 zze = s8.q();
    private d5 zzf;

    static {
        h5 h5Var = new h5();
        zza = h5Var;
        s8.w(h5.class, h5Var);
    }

    private h5() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", l5.class, "zzf"});
        } else if (i2 == 3) {
            return new h5();
        } else {
            if (i2 == 4) {
                return new g5((b5) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final d5 E() {
        d5 d5Var = this.zzf;
        return d5Var == null ? d5.G() : d5Var;
    }

    public final List G() {
        return this.zze;
    }
}
