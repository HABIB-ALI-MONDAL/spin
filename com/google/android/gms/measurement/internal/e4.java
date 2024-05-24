package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.n.b;
import com.google.android.gms.common.n.c;

public final class e4 {

    /* renamed from: a  reason: collision with root package name */
    final x4 f2364a;

    e4(ca caVar) {
        this.f2364a = caVar.b0();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        try {
            b a2 = c.a(this.f2364a.d());
            if (a2 != null) {
                return a2.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f2364a.f().v().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e2) {
            this.f2364a.f().v().b("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }
}
