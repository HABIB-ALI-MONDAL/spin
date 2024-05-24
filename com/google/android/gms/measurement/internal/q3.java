package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.util.Map;

final class q3 implements Runnable {
    private final o3 j;
    private final int k;
    private final Throwable l;
    private final byte[] m;
    private final String n;
    private final Map o;

    /* synthetic */ q3(String str, o3 o3Var, int i, Throwable th, byte[] bArr, Map map, p3 p3Var) {
        n.i(o3Var);
        this.j = o3Var;
        this.k = i;
        this.l = th;
        this.m = bArr;
        this.n = str;
        this.o = map;
    }

    public final void run() {
        this.j.a(this.n, this.k, this.l, this.m, this.o);
    }
}
