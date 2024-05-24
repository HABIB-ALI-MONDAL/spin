package c.d.a.b.e.e;

import java.util.List;

public final class l5 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final l5 zza;
    private int zzd;
    private int zze;
    private x8 zzf = s8.q();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        l5 l5Var = new l5();
        zza = l5Var;
        s8.w(l5.class, l5Var);
    }

    private l5() {
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzd", "zze", j5.f1661a, "zzf", l5.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new l5();
        } else {
            if (i2 == 4) {
                return new i5((b5) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final double E() {
        return this.zzj;
    }

    public final String G() {
        return this.zzg;
    }

    public final String H() {
        return this.zzh;
    }

    public final List I() {
        return this.zzf;
    }

    public final boolean J() {
        return this.zzi;
    }

    public final boolean K() {
        return (this.zzd & 8) != 0;
    }

    public final boolean L() {
        return (this.zzd & 16) != 0;
    }

    public final boolean M() {
        return (this.zzd & 4) != 0;
    }

    public final int N() {
        int a2 = k5.a(this.zze);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }
}
