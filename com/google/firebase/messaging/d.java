package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f2907a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f2908b;

    public /* synthetic */ d(Context context, Intent intent) {
        this.f2907a = context;
        this.f2908b = intent;
    }

    public final Object call() {
        return Integer.valueOf(y0.b().g(this.f2907a, this.f2908b));
    }
}
