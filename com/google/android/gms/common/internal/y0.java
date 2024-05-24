package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class y0 extends o0 {

    /* renamed from: a  reason: collision with root package name */
    private c f2238a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2239b;

    public y0(c cVar, int i) {
        this.f2238a = cVar;
        this.f2239b = i;
    }

    public final void Y(int i, IBinder iBinder, Bundle bundle) {
        n.j(this.f2238a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f2238a.N(i, iBinder, bundle, this.f2239b);
        this.f2238a = null;
    }

    public final void q(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void s(int i, IBinder iBinder, c1 c1Var) {
        c cVar = this.f2238a;
        n.j(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        n.i(c1Var);
        c.c0(cVar, c1Var);
        Y(i, iBinder, c1Var.j);
    }
}
