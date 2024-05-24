package com.google.firebase.q;

import java.util.Objects;
import javax.annotation.Nonnull;

final class c extends g {

    /* renamed from: a  reason: collision with root package name */
    private final String f3048a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3049b;

    c(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f3048a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f3049b = str2;
    }

    @Nonnull
    public String b() {
        return this.f3048a;
    }

    @Nonnull
    public String c() {
        return this.f3049b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3048a.equals(gVar.b()) && this.f3049b.equals(gVar.c());
    }

    public int hashCode() {
        return ((this.f3048a.hashCode() ^ 1000003) * 1000003) ^ this.f3049b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f3048a + ", version=" + this.f3049b + "}";
    }
}
