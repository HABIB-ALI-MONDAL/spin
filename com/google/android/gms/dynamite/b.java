package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ClassLoader f2289a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Thread f2290b;

    public static synchronized ClassLoader a() {
        ClassLoader classLoader;
        synchronized (b.class) {
            if (f2289a == null) {
                f2289a = b();
            }
            classLoader = f2289a;
        }
        return classLoader;
    }

    private static synchronized ClassLoader b() {
        synchronized (b.class) {
            ClassLoader classLoader = null;
            if (f2290b == null) {
                f2290b = c();
                if (f2290b == null) {
                    return null;
                }
            }
            synchronized (f2290b) {
                try {
                    classLoader = f2290b.getContextClassLoader();
                } catch (SecurityException e2) {
                    String message = e2.getMessage();
                    Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + message);
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread c() {
        a aVar;
        a aVar2;
        SecurityException e2;
        ThreadGroup threadGroup;
        synchronized (b.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i2];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i2++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i >= activeCount) {
                            aVar = null;
                            break;
                        }
                        aVar = threadArr[i];
                        if ("GmsDynamite".equals(aVar.getName())) {
                            break;
                        }
                        i++;
                    }
                    if (aVar == null) {
                        try {
                            aVar2 = new a(threadGroup, "GmsDynamite");
                            try {
                                aVar2.setContextClassLoader((ClassLoader) null);
                                aVar2.start();
                            } catch (SecurityException e3) {
                                e2 = e3;
                            }
                        } catch (SecurityException e4) {
                            e2 = e4;
                            aVar2 = aVar;
                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e2.getMessage());
                            aVar = aVar2;
                            return aVar;
                        }
                        aVar = aVar2;
                    }
                } catch (SecurityException e5) {
                    e2 = e5;
                    aVar2 = null;
                    Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e2.getMessage());
                    aVar = aVar2;
                    return aVar;
                }
            }
            return aVar;
        }
    }
}
