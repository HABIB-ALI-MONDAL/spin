package c.d.a.b.e.e;

import java.util.List;

public final class s3 extends s8 implements y9 {
    /* access modifiers changed from: private */
    public static final s3 zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private int zzg;
    private x8 zzh = s8.q();
    private x8 zzi = s8.q();
    /* access modifiers changed from: private */
    public x8 zzj = s8.q();
    private String zzk = "";
    private boolean zzl;
    private x8 zzm = s8.q();
    private x8 zzn = s8.q();
    private String zzo = "";

    static {
        s3 s3Var = new s3();
        zza = s3Var;
        s8.w(s3.class, s3Var);
    }

    private s3() {
    }

    public static r3 I() {
        return (r3) zza.A();
    }

    public static s3 K() {
        return zza;
    }

    static /* synthetic */ void R(s3 s3Var, int i, q3 q3Var) {
        q3Var.getClass();
        x8 x8Var = s3Var.zzi;
        if (!x8Var.c()) {
            s3Var.zzi = s8.r(x8Var);
        }
        s3Var.zzi.set(i, q3Var);
    }

    /* access modifiers changed from: protected */
    public final Object D(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return s8.t(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", w3.class, "zzi", q3.class, "zzj", w2.class, "zzk", "zzl", "zzm", h5.class, "zzn", o3.class, "zzo"});
        } else if (i2 == 3) {
            return new s3();
        } else {
            if (i2 == 4) {
                return new r3((l3) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int E() {
        return this.zzm.size();
    }

    public final int F() {
        return this.zzi.size();
    }

    public final long G() {
        return this.zze;
    }

    public final q3 H(int i) {
        return (q3) this.zzi.get(i);
    }

    public final String L() {
        return this.zzf;
    }

    public final String M() {
        return this.zzo;
    }

    public final List N() {
        return this.zzj;
    }

    public final List O() {
        return this.zzn;
    }

    public final List P() {
        return this.zzm;
    }

    public final List Q() {
        return this.zzh;
    }

    public final boolean T() {
        return this.zzl;
    }

    public final boolean U() {
        return (this.zzd & 2) != 0;
    }

    public final boolean V() {
        return (this.zzd & 1) != 0;
    }
}
