package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public final class g1 {

    /* renamed from: f  reason: collision with root package name */
    private static final Uri f2190f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a  reason: collision with root package name */
    private final String f2191a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2192b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f2193c = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f2194d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2195e;

    public g1(String str, String str2, int i, boolean z) {
        n.e(str);
        this.f2191a = str;
        n.e(str2);
        this.f2192b = str2;
        this.f2194d = i;
        this.f2195e = z;
    }

    public final int a() {
        return this.f2194d;
    }

    public final ComponentName b() {
        return this.f2193c;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f2191a == null) {
            return new Intent().setComponent(this.f2193c);
        }
        Intent intent = null;
        if (this.f2195e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f2191a);
            try {
                bundle = context.getContentResolver().call(f2190f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e2.toString()));
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f2191a)));
            }
        }
        return intent != null ? intent : new Intent(this.f2191a).setPackage(this.f2192b);
    }

    public final String d() {
        return this.f2192b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return m.a(this.f2191a, g1Var.f2191a) && m.a(this.f2192b, g1Var.f2192b) && m.a(this.f2193c, g1Var.f2193c) && this.f2194d == g1Var.f2194d && this.f2195e == g1Var.f2195e;
    }

    public final int hashCode() {
        return m.b(this.f2191a, this.f2192b, this.f2193c, Integer.valueOf(this.f2194d), Boolean.valueOf(this.f2195e));
    }

    public final String toString() {
        String str = this.f2191a;
        if (str != null) {
            return str;
        }
        n.i(this.f2193c);
        return this.f2193c.flattenToString();
    }
}
