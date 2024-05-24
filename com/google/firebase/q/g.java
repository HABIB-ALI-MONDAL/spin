package com.google.firebase.q;

import com.google.auto.value.AutoValue;
import javax.annotation.Nonnull;

@AutoValue
abstract class g {
    g() {
    }

    /* access modifiers changed from: package-private */
    public static g a(String str, String str2) {
        return new c(str, str2);
    }

    @Nonnull
    public abstract String b();

    @Nonnull
    public abstract String c();
}
