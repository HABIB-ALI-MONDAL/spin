package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.a;

public class u implements a.d {

    /* renamed from: b  reason: collision with root package name */
    public static final u f2230b = c().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f2231a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f2232a;

        /* synthetic */ a(y yVar) {
        }

        public u a() {
            return new u(this.f2232a, (z) null);
        }
    }

    /* synthetic */ u(String str, z zVar) {
        this.f2231a = str;
    }

    public static a c() {
        return new a((y) null);
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        String str = this.f2231a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return m.a(this.f2231a, ((u) obj).f2231a);
    }

    public final int hashCode() {
        return m.b(this.f2231a);
    }
}
