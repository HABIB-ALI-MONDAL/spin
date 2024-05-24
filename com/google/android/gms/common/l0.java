package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

class l0 {

    /* renamed from: d  reason: collision with root package name */
    private static final l0 f2246d = new l0(true, 3, 1, (String) null, (Throwable) null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f2247a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    final String f2248b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final Throwable f2249c;

    private l0(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.f2247a = z;
        this.f2248b = str;
        this.f2249c = th;
    }

    /* synthetic */ l0(boolean z, int i, int i2, String str, Throwable th, k0 k0Var) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }

    @Deprecated
    static l0 b() {
        return f2246d;
    }

    static l0 c(String str) {
        return new l0(false, 1, 5, str, (Throwable) null);
    }

    static l0 d(String str, Throwable th) {
        return new l0(false, 1, 5, str, th);
    }

    static l0 f(int i) {
        return new l0(true, i, 1, (String) null, (Throwable) null);
    }

    static l0 g(int i, int i2, String str, @Nullable Throwable th) {
        return new l0(false, i, i2, str, th);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String a() {
        return this.f2248b;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (!this.f2247a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f2249c != null) {
                Log.d("GoogleCertificatesRslt", a(), this.f2249c);
            } else {
                Log.d("GoogleCertificatesRslt", a());
            }
        }
    }
}
