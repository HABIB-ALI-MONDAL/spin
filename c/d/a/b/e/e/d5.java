package c.d.a.b.e.e;

import java.util.List;

public final class d5 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final d5 zza;
    private x8 zzd = s8.q();

    static {
        d5 d5Var = new d5();
        zza = d5Var;
        s8.w(d5.class, d5Var);
    }

    private d5() {
    }

    public static d5 G() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", f5.class});
        } else if (i2 == 3) {
            return new d5();
        } else {
            if (i2 == 4) {
                return new c5((b5) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzd.size();
    }

    public final List H() {
        return this.zzd;
    }
}
