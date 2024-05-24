package com.google.android.datatransport.runtime.backends;

import c.d.a.a.i.j;
import com.google.android.datatransport.runtime.backends.a;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class f {

    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<j> iterable);

        public abstract a c(byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<j> b();

    public abstract byte[] c();
}
