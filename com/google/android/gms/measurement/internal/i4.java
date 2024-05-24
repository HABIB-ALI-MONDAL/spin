package com.google.android.gms.measurement.internal;

import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class i4 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p4 f2412a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2413b;

    public /* synthetic */ i4(p4 p4Var, String str) {
        this.f2412a = p4Var;
        this.f2413b = str;
    }

    public final Object call() {
        p4 p4Var = this.f2412a;
        String str = this.f2413b;
        h6 R = p4Var.f2504b.V().R(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("package_name", str);
        p4Var.f2527a.z().q();
        hashMap.put("gmp_version", 74029L);
        if (R != null) {
            String g0 = R.g0();
            if (g0 != null) {
                hashMap.put("app_version", g0);
            }
            hashMap.put("app_version_int", Long.valueOf(R.L()));
            hashMap.put("dynamite_version", Long.valueOf(R.U()));
        }
        return hashMap;
    }
}
