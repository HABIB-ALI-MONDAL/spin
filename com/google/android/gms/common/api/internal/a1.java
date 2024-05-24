package com.google.android.gms.common.api.internal;

import b.c.a;
import c.d.a.b.h.j;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.b;
import java.util.Set;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    private final a f2060a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2061b;

    /* renamed from: c  reason: collision with root package name */
    private final j f2062c;

    /* renamed from: d  reason: collision with root package name */
    private int f2063d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2064e;

    public final Set a() {
        return this.f2060a.keySet();
    }

    public final void b(b bVar, b bVar2, String str) {
        this.f2060a.put(bVar, bVar2);
        this.f2061b.put(bVar, str);
        this.f2063d--;
        if (!bVar2.l()) {
            this.f2064e = true;
        }
        if (this.f2063d != 0) {
            return;
        }
        if (this.f2064e) {
            this.f2062c.b(new c(this.f2060a));
            return;
        }
        this.f2062c.c(this.f2061b);
    }
}
