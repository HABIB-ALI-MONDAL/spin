package com.google.firebase.installations.s;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.s.b;

@AutoValue
public abstract class f {

    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(b bVar);

        public abstract a c(String str);

        public abstract a d(long j);
    }

    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a a() {
        b.C0076b bVar = new b.C0076b();
        bVar.d(0);
        return bVar;
    }

    public abstract b b();

    public abstract String c();

    public abstract long d();
}
