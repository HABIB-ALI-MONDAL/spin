package c.d.a.b.e.e;

import java.util.List;

public final class k3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final k3 zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private x8 zzh = s8.q();

    static {
        k3 k3Var = new k3();
        zza = k3Var;
        s8.w(k3.class, k3Var);
    }

    private k3() {
    }

    public static k3 G() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzd", "zze", i3.f1658a, "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new k3();
        } else {
            if (i2 == 4) {
                return new h3((u2) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzh.size();
    }

    public final String H() {
        return this.zzf;
    }

    public final List I() {
        return this.zzh;
    }

    public final boolean J() {
        return this.zzg;
    }

    public final boolean K() {
        return (this.zzd & 4) != 0;
    }

    public final boolean L() {
        return (this.zzd & 2) != 0;
    }

    public final boolean M() {
        return (this.zzd & 1) != 0;
    }

    public final int N() {
        int a2 = j3.a(this.zze);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }
}
