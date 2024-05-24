package c.d.a.b.e.e;

import java.util.List;

public final class k4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final k4 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;
    /* access modifiers changed from: private */
    public x8 zzj = s8.q();

    static {
        k4 k4Var = new k4();
        zza = k4Var;
        s8.w(k4.class, k4Var);
    }

    private k4() {
    }

    public static j4 I() {
        return (j4) zza.A();
    }

    static /* synthetic */ void N(k4 k4Var, String str) {
        str.getClass();
        k4Var.zzd |= 1;
        k4Var.zze = str;
    }

    static /* synthetic */ void O(k4 k4Var, String str) {
        str.getClass();
        k4Var.zzd |= 2;
        k4Var.zzf = str;
    }

    static /* synthetic */ void P(k4 k4Var) {
        k4Var.zzd &= -3;
        k4Var.zzf = zza.zzf;
    }

    static /* synthetic */ void Q(k4 k4Var, long j) {
        k4Var.zzd |= 4;
        k4Var.zzg = j;
    }

    static /* synthetic */ void R(k4 k4Var) {
        k4Var.zzd &= -5;
        k4Var.zzg = 0;
    }

    static /* synthetic */ void S(k4 k4Var, double d2) {
        k4Var.zzd |= 16;
        k4Var.zzi = d2;
    }

    static /* synthetic */ void T(k4 k4Var) {
        k4Var.zzd &= -17;
        k4Var.zzi = 0.0d;
    }

    static /* synthetic */ void U(k4 k4Var, k4 k4Var2) {
        k4Var2.getClass();
        k4Var.c0();
        k4Var.zzj.add(k4Var2);
    }

    static /* synthetic */ void V(k4 k4Var, Iterable iterable) {
        k4Var.c0();
        d7.j(iterable, k4Var.zzj);
    }

    private final void c0() {
        x8 x8Var = this.zzj;
        if (!x8Var.c()) {
            this.zzj = s8.r(x8Var);
        }
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", k4.class});
        } else if (i2 == 3) {
            return new k4();
        } else {
            if (i2 == 4) {
                return new j4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final double E() {
        return this.zzi;
    }

    public final float F() {
        return this.zzh;
    }

    public final int G() {
        return this.zzj.size();
    }

    public final long H() {
        return this.zzg;
    }

    public final String K() {
        return this.zze;
    }

    public final String L() {
        return this.zzf;
    }

    public final List M() {
        return this.zzj;
    }

    public final boolean X() {
        return (this.zzd & 16) != 0;
    }

    public final boolean Y() {
        return (this.zzd & 8) != 0;
    }

    public final boolean Z() {
        return (this.zzd & 4) != 0;
    }

    public final boolean a0() {
        return (this.zzd & 1) != 0;
    }

    public final boolean b0() {
        return (this.zzd & 2) != 0;
    }
}
