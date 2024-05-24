package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import c.d.a.a.i.c0.a;
import java.util.Objects;

final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1957a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1958b;

    /* renamed from: c  reason: collision with root package name */
    private final a f1959c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1960d;

    c(Context context, a aVar, a aVar2, String str) {
        Objects.requireNonNull(context, "Null applicationContext");
        this.f1957a = context;
        Objects.requireNonNull(aVar, "Null wallClock");
        this.f1958b = aVar;
        Objects.requireNonNull(aVar2, "Null monotonicClock");
        this.f1959c = aVar2;
        Objects.requireNonNull(str, "Null backendName");
        this.f1960d = str;
    }

    public Context b() {
        return this.f1957a;
    }

    public String c() {
        return this.f1960d;
    }

    public a d() {
        return this.f1959c;
    }

    public a e() {
        return this.f1958b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f1957a.equals(hVar.b()) && this.f1958b.equals(hVar.e()) && this.f1959c.equals(hVar.d()) && this.f1960d.equals(hVar.c());
    }

    public int hashCode() {
        return ((((((this.f1957a.hashCode() ^ 1000003) * 1000003) ^ this.f1958b.hashCode()) * 1000003) ^ this.f1959c.hashCode()) * 1000003) ^ this.f1960d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f1957a + ", wallClock=" + this.f1958b + ", monotonicClock=" + this.f1959c + ", backendName=" + this.f1960d + "}";
    }
}
