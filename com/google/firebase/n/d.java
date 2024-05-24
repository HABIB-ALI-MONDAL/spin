package com.google.firebase.n;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class d implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f3030a = new d();

    private /* synthetic */ d() {
    }

    public final Thread newThread(Runnable runnable) {
        return g.j(runnable);
    }
}
