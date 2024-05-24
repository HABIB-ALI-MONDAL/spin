package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.nc;
import java.util.Map;

final class o4 implements nc {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2491a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p4 f2492b;

    o4(p4 p4Var, String str) {
        this.f2492b = p4Var;
        this.f2491a = str;
    }

    public final String a(String str) {
        Map map = (Map) this.f2492b.f2501d.get(this.f2491a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
