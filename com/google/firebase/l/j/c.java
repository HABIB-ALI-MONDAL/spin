package com.google.firebase.l.j;

import com.google.firebase.l.j.f;
import java.lang.annotation.Annotation;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f2857a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f2858b = f.a.DEFAULT;

    private static final class a implements f {

        /* renamed from: a  reason: collision with root package name */
        private final int f2859a;

        /* renamed from: b  reason: collision with root package name */
        private final f.a f2860b;

        a(int i, f.a aVar) {
            this.f2859a = i;
            this.f2860b = aVar;
        }

        public Class<? extends Annotation> annotationType() {
            return f.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f2859a == fVar.tag() && this.f2860b.equals(fVar.intEncoding());
        }

        public int hashCode() {
            return (this.f2859a ^ 14552422) + (this.f2860b.hashCode() ^ 2041407134);
        }

        public f.a intEncoding() {
            return this.f2860b;
        }

        public int tag() {
            return this.f2859a;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.f2859a + "intEncoding=" + this.f2860b + ')';
        }
    }

    public static c b() {
        return new c();
    }

    public f a() {
        return new a(this.f2857a, this.f2858b);
    }

    public c c(int i) {
        this.f2857a = i;
        return this;
    }
}
