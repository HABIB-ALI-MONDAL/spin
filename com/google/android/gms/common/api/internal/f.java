package com.google.android.gms.common.api.internal;

import android.app.Activity;
import b.g.a.e;
import com.google.android.gms.common.internal.n;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2087a;

    public f(Activity activity) {
        n.j(activity, "Activity must not be null");
        this.f2087a = activity;
    }

    public final Activity a() {
        return (Activity) this.f2087a;
    }

    public final e b() {
        return (e) this.f2087a;
    }

    public final boolean c() {
        return this.f2087a instanceof Activity;
    }

    public final boolean d() {
        return this.f2087a instanceof e;
    }
}
