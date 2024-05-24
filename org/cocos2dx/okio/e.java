package org.cocos2dx.okio;

import javax.annotation.Nullable;

final class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    static d f3267a;

    /* renamed from: b  reason: collision with root package name */
    static long f3268b;

    private e() {
    }

    static void a(d dVar) {
        if (dVar.f3266f != null || dVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!dVar.f3264d) {
            synchronized (e.class) {
                long j = f3268b;
                if (j + 8192 <= 65536) {
                    f3268b = j + 8192;
                    dVar.f3266f = f3267a;
                    dVar.f3263c = 0;
                    dVar.f3262b = 0;
                    f3267a = dVar;
                }
            }
        }
    }

    static d b() {
        synchronized (e.class) {
            d dVar = f3267a;
            if (dVar == null) {
                return new d();
            }
            f3267a = dVar.f3266f;
            dVar.f3266f = null;
            f3268b -= 8192;
            return dVar;
        }
    }
}
