package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class z0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2150a;

    public z0(int i) {
        this.f2150a = i;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(z zVar);

    public abstract void d(q qVar, boolean z);
}
