package c.d.a.b.e.e;

import java.util.List;

public final class g4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final g4 zza;
    private int zzd;
    /* access modifiers changed from: private */
    public x8 zze = s8.q();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        g4 g4Var = new g4();
        zza = g4Var;
        s8.w(g4.class, g4Var);
    }

    private g4() {
    }

    public static f4 I() {
        return (f4) zza.A();
    }

    static /* synthetic */ void N(g4 g4Var, int i, k4 k4Var) {
        k4Var.getClass();
        g4Var.Y();
        g4Var.zze.set(i, k4Var);
    }

    static /* synthetic */ void O(g4 g4Var, k4 k4Var) {
        k4Var.getClass();
        g4Var.Y();
        g4Var.zze.add(k4Var);
    }

    static /* synthetic */ void P(g4 g4Var, Iterable iterable) {
        g4Var.Y();
        d7.j(iterable, g4Var.zze);
    }

    static /* synthetic */ void R(g4 g4Var, int i) {
        g4Var.Y();
        g4Var.zze.remove(i);
    }

    static /* synthetic */ void S(g4 g4Var, String str) {
        str.getClass();
        g4Var.zzd |= 1;
        g4Var.zzf = str;
    }

    static /* synthetic */ void T(g4 g4Var, long j) {
        g4Var.zzd |= 2;
        g4Var.zzg = j;
    }

    static /* synthetic */ void U(g4 g4Var, long j) {
        g4Var.zzd |= 4;
        g4Var.zzh = j;
    }

    private final void Y() {
        x8 x8Var = this.zze;
        if (!x8Var.c()) {
            this.zze = s8.r(x8Var);
        }
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", k4.class, "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new g4();
        } else {
            if (i2 == 4) {
                return new f4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzi;
    }

    public final int F() {
        return this.zze.size();
    }

    public final long G() {
        return this.zzh;
    }

    public final long H() {
        return this.zzg;
    }

    public final k4 K(int i) {
        return (k4) this.zze.get(i);
    }

    public final String L() {
        return this.zzf;
    }

    public final List M() {
        return this.zze;
    }

    public final boolean V() {
        return (this.zzd & 8) != 0;
    }

    public final boolean W() {
        return (this.zzd & 4) != 0;
    }

    public final boolean X() {
        return (this.zzd & 2) != 0;
    }
}
