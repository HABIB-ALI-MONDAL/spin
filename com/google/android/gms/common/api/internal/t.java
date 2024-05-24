package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class t implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f2134a;

    public /* synthetic */ t(Handler handler) {
        this.f2134a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f2134a.post(runnable);
    }
}
