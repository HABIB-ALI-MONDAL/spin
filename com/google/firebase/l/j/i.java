package com.google.firebase.l.j;

import com.google.firebase.l.b;
import com.google.firebase.l.c;
import com.google.firebase.l.g;

class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2875a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2876b = false;

    /* renamed from: c  reason: collision with root package name */
    private c f2877c;

    /* renamed from: d  reason: collision with root package name */
    private final g f2878d;

    i(g gVar) {
        this.f2878d = gVar;
    }

    private void c() {
        if (!this.f2875a) {
            this.f2875a = true;
            return;
        }
        throw new b("Cannot encode a second value in the ValueEncoderContext");
    }

    public g a(String str) {
        c();
        this.f2878d.f(this.f2877c, str, this.f2876b);
        return this;
    }

    public g b(boolean z) {
        c();
        this.f2878d.k(this.f2877c, z, this.f2876b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void d(c cVar, boolean z) {
        this.f2875a = false;
        this.f2877c = cVar;
        this.f2876b = z;
    }
}
