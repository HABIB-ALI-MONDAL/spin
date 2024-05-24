package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.e;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class k {

    @AutoValue.Builder
    public static abstract class a {
        public abstract k a();

        public abstract a b(a aVar);

        public abstract a c(b bVar);
    }

    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private b(int i) {
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract a b();

    public abstract b c();
}
