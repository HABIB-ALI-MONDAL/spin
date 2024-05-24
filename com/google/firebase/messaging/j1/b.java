package com.google.firebase.messaging.j1;

import com.google.firebase.l.j.f;
import com.google.firebase.messaging.r0;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f2978a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a f2979a = null;

        a() {
        }

        public b a() {
            return new b(this.f2979a);
        }

        public a b(a aVar) {
            this.f2979a = aVar;
            return this;
        }
    }

    static {
        new a().a();
    }

    b(a aVar) {
        this.f2978a = aVar;
    }

    public static a b() {
        return new a();
    }

    @f(tag = 1)
    public a a() {
        return this.f2978a;
    }

    public byte[] c() {
        return r0.a(this);
    }
}
