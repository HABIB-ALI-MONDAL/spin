package com.google.android.gms.measurement.internal;

import java.util.Map;

public final /* synthetic */ class g7 implements Runnable {
    public final /* synthetic */ i7 j;
    public final /* synthetic */ int k;
    public final /* synthetic */ Exception l;
    public final /* synthetic */ byte[] m;
    public final /* synthetic */ Map n;

    public /* synthetic */ g7(i7 i7Var, int i, Exception exc, byte[] bArr, Map map) {
        this.j = i7Var;
        this.k = i;
        this.l = exc;
        this.m = bArr;
        this.n = map;
    }

    public final void run() {
        this.j.a(this.k, this.l, this.m, this.n);
    }
}
