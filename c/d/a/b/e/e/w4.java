package c.d.a.b.e.e;

import java.util.List;

public final class w4 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final w4 zza;
    /* access modifiers changed from: private */
    public w8 zzd = s8.o();
    /* access modifiers changed from: private */
    public w8 zze = s8.o();
    /* access modifiers changed from: private */
    public x8 zzf = s8.q();
    /* access modifiers changed from: private */
    public x8 zzg = s8.q();

    static {
        w4 w4Var = new w4();
        zza = w4Var;
        s8.w(w4.class, w4Var);
    }

    private w4() {
    }

    public static v4 J() {
        return (v4) zza.A();
    }

    public static w4 L() {
        return zza;
    }

    static /* synthetic */ void R(w4 w4Var, Iterable iterable) {
        w8 w8Var = w4Var.zzd;
        if (!w8Var.c()) {
            w4Var.zzd = s8.p(w8Var);
        }
        d7.j(iterable, w4Var.zzd);
    }

    static /* synthetic */ void T(w4 w4Var, Iterable iterable) {
        w8 w8Var = w4Var.zze;
        if (!w8Var.c()) {
            w4Var.zze = s8.p(w8Var);
        }
        d7.j(iterable, w4Var.zze);
    }

    static /* synthetic */ void V(w4 w4Var, Iterable iterable) {
        w4Var.b0();
        d7.j(iterable, w4Var.zzf);
    }

    static /* synthetic */ void X(w4 w4Var, int i) {
        w4Var.b0();
        w4Var.zzf.remove(i);
    }

    static /* synthetic */ void Y(w4 w4Var, Iterable iterable) {
        w4Var.c0();
        d7.j(iterable, w4Var.zzg);
    }

    static /* synthetic */ void a0(w4 w4Var, int i) {
        w4Var.c0();
        w4Var.zzg.remove(i);
    }

    private final void b0() {
        x8 x8Var = this.zzf;
        if (!x8Var.c()) {
            this.zzf = s8.r(x8Var);
        }
    }

    private final void c0() {
        x8 x8Var = this.zzg;
        if (!x8Var.c()) {
            this.zzg = s8.r(x8Var);
        }
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzd", "zze", "zzf", e4.class, "zzg", y4.class});
        } else if (i2 == 3) {
            return new w4();
        } else {
            if (i2 == 4) {
                return new v4((x3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzf.size();
    }

    public final int F() {
        return this.zze.size();
    }

    public final int G() {
        return this.zzg.size();
    }

    public final int H() {
        return this.zzd.size();
    }

    public final e4 I(int i) {
        return (e4) this.zzf.get(i);
    }

    public final y4 M(int i) {
        return (y4) this.zzg.get(i);
    }

    public final List N() {
        return this.zzf;
    }

    public final List O() {
        return this.zze;
    }

    public final List P() {
        return this.zzg;
    }

    public final List Q() {
        return this.zzd;
    }
}
