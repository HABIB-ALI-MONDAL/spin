package com.google.firebase.messaging;

import c.d.a.b.h.d;
import c.d.a.b.h.i;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class c0 implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f2902a;

    public /* synthetic */ c0(ScheduledFuture scheduledFuture) {
        this.f2902a = scheduledFuture;
    }

    public final void a(i iVar) {
        this.f2902a.cancel(false);
    }
}
