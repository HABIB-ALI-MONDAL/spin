package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class y implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3009a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f3010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f3011c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ p0 f3012d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m0 f3013e;

    public /* synthetic */ y(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, p0 p0Var, m0 m0Var) {
        this.f3009a = context;
        this.f3010b = scheduledExecutorService;
        this.f3011c = firebaseMessaging;
        this.f3012d = p0Var;
        this.f3013e = m0Var;
    }

    public final Object call() {
        return e1.i(this.f3009a, this.f3010b, this.f3011c, this.f3012d, this.f3013e);
    }
}
