package com.google.android.gms.common.util.p;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f2274a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f2275b = Executors.defaultThreadFactory();

    public a(String str) {
        n.j(str, "Name must not be null");
        this.f2274a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f2275b.newThread(new b(runnable, 0));
        newThread.setName(this.f2274a);
        return newThread;
    }
}
