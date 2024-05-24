package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

public final class sa {

    /* renamed from: a  reason: collision with root package name */
    private final x4 f2539a;

    public sa(x4 x4Var) {
        this.f2539a = x4Var;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, Bundle bundle) {
        String str2;
        this.f2539a.c().h();
        if (!this.f2539a.o()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f2539a.F().v.b(str2);
                this.f2539a.F().w.b(this.f2539a.a().a());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f2539a.c().h();
        if (d()) {
            if (e()) {
                this.f2539a.F().v.b((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.f2539a.I().u("auto", "_cmpx", bundle);
            } else {
                String a2 = this.f2539a.F().v.a();
                if (TextUtils.isEmpty(a2)) {
                    this.f2539a.f().t().a("Cache still valid but referrer not found");
                } else {
                    long a3 = ((this.f2539a.F().w.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", a3);
                    Object obj = pair.first;
                    this.f2539a.I().u(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.f2539a.F().v.b((String) null);
            }
            this.f2539a.F().w.b(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (d() && e()) {
            this.f2539a.F().v.b((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.f2539a.F().w.a() > 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return d() && this.f2539a.a().a() - this.f2539a.F().w.a() > this.f2539a.z().r((String) null, y2.R);
    }
}
