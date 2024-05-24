package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.b;

public final class a1 extends n0 {
    public final IBinder g;
    final /* synthetic */ c h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(c cVar, int i, IBinder iBinder, Bundle bundle) {
        super(cVar, i, bundle);
        this.h = cVar;
        this.g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(b bVar) {
        if (this.h.p != null) {
            this.h.p.h(bVar);
        }
        this.h.L(bVar);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        String str;
        try {
            IBinder iBinder = this.g;
            n.i(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.h.E().equals(interfaceDescriptor)) {
                str = "service descriptor mismatch: " + this.h.E() + " vs. " + interfaceDescriptor;
                Log.w("GmsClient", str);
                return false;
            }
            IInterface s = this.h.s(this.g);
            if (s == null || (!c.g0(this.h, 2, 4, s) && !c.g0(this.h, 3, 4, s))) {
                return false;
            }
            this.h.t = null;
            Bundle x = this.h.x();
            c cVar = this.h;
            if (cVar.o == null) {
                return true;
            }
            cVar.o.k(x);
            return true;
        } catch (RemoteException unused) {
            str = "service probably died";
        }
    }
}
