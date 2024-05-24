package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class h3 {

    /* renamed from: b  reason: collision with root package name */
    protected static final AtomicReference f2392b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    protected static final AtomicReference f2393c = new AtomicReference();

    /* renamed from: d  reason: collision with root package name */
    protected static final AtomicReference f2394d = new AtomicReference();

    /* renamed from: a  reason: collision with root package name */
    private final g3 f2395a;

    public h3(g3 g3Var) {
        this.f2395a = g3Var;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        n.i(strArr);
        n.i(strArr2);
        n.i(atomicReference);
        n.a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i];
                    if (str2 == null) {
                        str2 = strArr2[i] + "(" + strArr[i] + ")";
                        strArr3[i] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final String a(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Bundle bundle : objArr) {
            String b2 = bundle instanceof Bundle ? b(bundle) : String.valueOf(bundle);
            if (b2 != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(b2);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f2395a.a()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(e(str));
            sb.append("=");
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? a(new Object[]{obj}) : obj instanceof Object[] ? a((Object[]) obj) : obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String c(x xVar) {
        if (!this.f2395a.a()) {
            return xVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(xVar.l);
        sb.append(",name=");
        sb.append(d(xVar.j));
        sb.append(",params=");
        v vVar = xVar.k;
        sb.append(vVar == null ? null : !this.f2395a.a() ? vVar.toString() : b(vVar.j()));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.f2395a.a() ? str : g(str, v5.f2589c, v5.f2587a, f2392b);
    }

    /* access modifiers changed from: protected */
    public final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.f2395a.a() ? str : g(str, w5.f2603b, w5.f2602a, f2393c);
    }

    /* access modifiers changed from: protected */
    public final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f2395a.a()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, x5.f2633b, x5.f2632a, f2394d);
        }
        return "experiment_id(" + str + ")";
    }
}
