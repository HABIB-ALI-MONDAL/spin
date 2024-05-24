package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import java.util.Iterator;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    final String f2528a;

    /* renamed from: b  reason: collision with root package name */
    final String f2529b;

    /* renamed from: c  reason: collision with root package name */
    final String f2530c;

    /* renamed from: d  reason: collision with root package name */
    final long f2531d;

    /* renamed from: e  reason: collision with root package name */
    final long f2532e;

    /* renamed from: f  reason: collision with root package name */
    final v f2533f;

    s(x4 x4Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        v vVar;
        n.e(str2);
        n.e(str3);
        this.f2528a = str2;
        this.f2529b = str3;
        this.f2530c = true == TextUtils.isEmpty(str) ? null : str;
        this.f2531d = j;
        this.f2532e = j2;
        if (j2 != 0 && j2 > j) {
            x4Var.f().w().b("Event created with reverse previous/current timestamps. appId", m3.z(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            vVar = new v(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    x4Var.f().r().a("Param name can't be null");
                } else {
                    Object o = x4Var.N().o(str4, bundle2.get(str4));
                    if (o == null) {
                        x4Var.f().w().b("Param value can't be null", x4Var.D().e(str4));
                    } else {
                        x4Var.N().C(bundle2, str4, o);
                    }
                }
                it.remove();
            }
            vVar = new v(bundle2);
        }
        this.f2533f = vVar;
    }

    private s(x4 x4Var, String str, String str2, String str3, long j, long j2, v vVar) {
        n.e(str2);
        n.e(str3);
        n.i(vVar);
        this.f2528a = str2;
        this.f2529b = str3;
        this.f2530c = true == TextUtils.isEmpty(str) ? null : str;
        this.f2531d = j;
        this.f2532e = j2;
        if (j2 != 0 && j2 > j) {
            x4Var.f().w().c("Event created with reverse previous/current timestamps. appId, name", m3.z(str2), m3.z(str3));
        }
        this.f2533f = vVar;
    }

    /* access modifiers changed from: package-private */
    public final s a(x4 x4Var, long j) {
        return new s(x4Var, this.f2530c, this.f2528a, this.f2529b, this.f2531d, j, this.f2533f);
    }

    public final String toString() {
        String str = this.f2528a;
        String str2 = this.f2529b;
        String obj = this.f2533f.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }
}
