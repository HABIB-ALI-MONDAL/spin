package com.google.firebase.installations;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.f;

@AutoValue
public abstract class m {

    @AutoValue.Builder
    public static abstract class a {
        public abstract m a();

        public abstract a b(String str);

        public abstract a c(long j);

        public abstract a d(long j);
    }

    public static a a() {
        return new f.b();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
