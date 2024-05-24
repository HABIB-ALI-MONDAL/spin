package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import c.d.a.b.e.e.a3;
import c.d.a.b.e.e.a5;
import c.d.a.b.e.e.c4;
import c.d.a.b.e.e.e3;
import c.d.a.b.e.e.e4;
import c.d.a.b.e.e.e8;
import c.d.a.b.e.e.f4;
import c.d.a.b.e.e.g3;
import c.d.a.b.e.e.g4;
import c.d.a.b.e.e.j4;
import c.d.a.b.e.e.k3;
import c.d.a.b.e.e.k4;
import c.d.a.b.e.e.p4;
import c.d.a.b.e.e.q4;
import c.d.a.b.e.e.r4;
import c.d.a.b.e.e.sd;
import c.d.a.b.e.e.w4;
import c.d.a.b.e.e.w9;
import c.d.a.b.e.e.y2;
import c.d.a.b.e.e.y4;
import c.d.a.b.e.e.z4;
import com.google.android.gms.common.internal.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class ea extends q9 {
    ea(ca caVar) {
        super(caVar);
    }

    static w9 C(w9 w9Var, byte[] bArr) {
        e8 a2 = e8.a();
        if (a2 != null) {
            w9Var.h(bArr, a2);
            return w9Var;
        }
        w9Var.c(bArr);
        return w9Var;
    }

    static List H(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    static boolean L(List list, int i) {
        if (i >= list.size() * 64) {
            return false;
        }
        return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
    }

    static boolean N(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static final void P(f4 f4Var, String str, Object obj) {
        List H = f4Var.H();
        int i = 0;
        while (true) {
            if (i >= H.size()) {
                i = -1;
                break;
            } else if (str.equals(((k4) H.get(i)).K())) {
                break;
            } else {
                i++;
            }
        }
        j4 I = k4.I();
        I.B(str);
        if (obj instanceof Long) {
            I.A(((Long) obj).longValue());
        }
        if (i >= 0) {
            f4Var.B(i, I);
        } else {
            f4Var.w(I);
        }
    }

    static final boolean m(x xVar, qa qaVar) {
        n.i(xVar);
        n.i(qaVar);
        return !TextUtils.isEmpty(qaVar.k) || !TextUtils.isEmpty(qaVar.z);
    }

    static final k4 n(g4 g4Var, String str) {
        for (k4 k4Var : g4Var.M()) {
            if (k4Var.K().equals(str)) {
                return k4Var;
            }
        }
        return null;
    }

    static final Object o(g4 g4Var, String str) {
        k4 n = n(g4Var, str);
        if (n == null) {
            return null;
        }
        if (n.b0()) {
            return n.L();
        }
        if (n.Z()) {
            return Long.valueOf(n.H());
        }
        if (n.X()) {
            return Double.valueOf(n.E());
        }
        if (n.G() <= 0) {
            return null;
        }
        List<k4> M = n.M();
        ArrayList arrayList = new ArrayList();
        for (k4 k4Var : M) {
            if (k4Var != null) {
                Bundle bundle = new Bundle();
                for (k4 k4Var2 : k4Var.M()) {
                    if (k4Var2.b0()) {
                        bundle.putString(k4Var2.K(), k4Var2.L());
                    } else if (k4Var2.Z()) {
                        bundle.putLong(k4Var2.K(), k4Var2.H());
                    } else if (k4Var2.X()) {
                        bundle.putDouble(k4Var2.K(), k4Var2.E());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void p(StringBuilder sb, int i, List list) {
        if (list != null) {
            int i2 = i + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k4 k4Var = (k4) it.next();
                if (k4Var != null) {
                    r(sb, i2);
                    sb.append("param {\n");
                    Double d2 = null;
                    u(sb, i2, "name", k4Var.a0() ? this.f2527a.D().e(k4Var.K()) : null);
                    u(sb, i2, "string_value", k4Var.b0() ? k4Var.L() : null);
                    u(sb, i2, "int_value", k4Var.Z() ? Long.valueOf(k4Var.H()) : null);
                    if (k4Var.X()) {
                        d2 = Double.valueOf(k4Var.E());
                    }
                    u(sb, i2, "double_value", d2);
                    if (k4Var.G() > 0) {
                        p(sb, i2, k4Var.M());
                    }
                    r(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void q(StringBuilder sb, int i, a3 a3Var) {
        String str;
        if (a3Var != null) {
            r(sb, i);
            sb.append("filter {\n");
            if (a3Var.L()) {
                u(sb, i, "complement", Boolean.valueOf(a3Var.K()));
            }
            if (a3Var.N()) {
                u(sb, i, "param_name", this.f2527a.D().e(a3Var.I()));
            }
            if (a3Var.O()) {
                int i2 = i + 1;
                k3 H = a3Var.H();
                if (H != null) {
                    r(sb, i2);
                    sb.append("string_filter {\n");
                    if (H.M()) {
                        switch (H.N()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        u(sb, i2, "match_type", str);
                    }
                    if (H.L()) {
                        u(sb, i2, "expression", H.H());
                    }
                    if (H.K()) {
                        u(sb, i2, "case_sensitive", Boolean.valueOf(H.J()));
                    }
                    if (H.E() > 0) {
                        r(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : H.I()) {
                            r(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    r(sb, i2);
                    sb.append("}\n");
                }
            }
            if (a3Var.M()) {
                v(sb, i + 1, "number_filter", a3Var.G());
            }
            r(sb, i);
            sb.append("}\n");
        }
    }

    private static final void r(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final String s(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void t(StringBuilder sb, int i, String str, w4 w4Var) {
        if (w4Var != null) {
            r(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (w4Var.F() != 0) {
                r(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : w4Var.O()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (w4Var.H() != 0) {
                r(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : w4Var.Q()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (w4Var.E() != 0) {
                r(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (e4 e4Var : w4Var.N()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(e4Var.L() ? Integer.valueOf(e4Var.E()) : null);
                    sb.append(":");
                    sb.append(e4Var.K() ? Long.valueOf(e4Var.F()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (w4Var.G() != 0) {
                r(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (y4 y4Var : w4Var.P()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(y4Var.M() ? Integer.valueOf(y4Var.F()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : y4Var.J()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            r(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void u(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            r(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static final void v(StringBuilder sb, int i, String str, e3 e3Var) {
        if (e3Var != null) {
            r(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (e3Var.K()) {
                int P = e3Var.P();
                u(sb, i, "comparison_type", P != 1 ? P != 2 ? P != 3 ? P != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
            }
            if (e3Var.M()) {
                u(sb, i, "match_as_float", Boolean.valueOf(e3Var.J()));
            }
            if (e3Var.L()) {
                u(sb, i, "comparison_value", e3Var.G());
            }
            if (e3Var.O()) {
                u(sb, i, "min_comparison_value", e3Var.I());
            }
            if (e3Var.N()) {
                u(sb, i, "max_comparison_value", e3Var.H());
            }
            r(sb, i);
            sb.append("}\n");
        }
    }

    static int w(q4 q4Var, String str) {
        for (int i = 0; i < q4Var.m0(); i++) {
            if (str.equals(q4Var.g0(i).J())) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r0.get("_o");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.x A(c.d.a.b.e.e.b r9) {
        /*
            r8 = this;
            java.util.Map r0 = r9.e()
            r1 = 1
            android.os.Bundle r0 = r8.y(r0, r1)
            java.lang.String r1 = "_o"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x001c
            java.lang.Object r1 = r0.get(r1)
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.toString()
            goto L_0x001e
        L_0x001c:
            java.lang.String r1 = "app"
        L_0x001e:
            r5 = r1
            java.lang.String r1 = r9.d()
            java.lang.String r1 = com.google.android.gms.measurement.internal.v5.b(r1)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = r9.d()
        L_0x002d:
            r3 = r1
            com.google.android.gms.measurement.internal.x r1 = new com.google.android.gms.measurement.internal.x
            com.google.android.gms.measurement.internal.v r4 = new com.google.android.gms.measurement.internal.v
            r4.<init>(r0)
            long r6 = r9.a()
            r2 = r1
            r2.<init>(r3, r4, r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ea.A(c.d.a.b.e.e.b):com.google.android.gms.measurement.internal.x");
    }

    /* access modifiers changed from: package-private */
    public final g4 B(s sVar) {
        f4 I = g4.I();
        I.D(sVar.f2532e);
        u uVar = new u(sVar.f2533f);
        while (uVar.hasNext()) {
            String b2 = uVar.next();
            j4 I2 = k4.I();
            I2.B(b2);
            Object p = sVar.f2533f.p(b2);
            n.i(p);
            J(I2, p);
            I.w(I2);
        }
        return (g4) I.n();
    }

    /* access modifiers changed from: package-private */
    public final String D(p4 p4Var) {
        if (p4Var == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (r4 r4Var : p4Var.H()) {
            if (r4Var != null) {
                r(sb, 1);
                sb.append("bundle {\n");
                if (r4Var.p1()) {
                    u(sb, 1, "protocol_version", Integer.valueOf(r4Var.y1()));
                }
                sd.c();
                if (this.f2527a.z().B((String) null, y2.i0) && this.f2527a.z().B(r4Var.R1(), y2.k0) && r4Var.s1()) {
                    u(sb, 1, "session_stitching_token", r4Var.O());
                }
                u(sb, 1, "platform", r4Var.M());
                if (r4Var.l1()) {
                    u(sb, 1, "gmp_version", Long.valueOf(r4Var.G1()));
                }
                if (r4Var.w1()) {
                    u(sb, 1, "uploading_gmp_version", Long.valueOf(r4Var.L1()));
                }
                if (r4Var.j1()) {
                    u(sb, 1, "dynamite_version", Long.valueOf(r4Var.E1()));
                }
                if (r4Var.g1()) {
                    u(sb, 1, "config_version", Long.valueOf(r4Var.C1()));
                }
                u(sb, 1, "gmp_app_id", r4Var.J());
                u(sb, 1, "admob_app_id", r4Var.Q1());
                u(sb, 1, "app_id", r4Var.R1());
                u(sb, 1, "app_version", r4Var.E());
                if (r4Var.C0()) {
                    u(sb, 1, "app_version_major", Integer.valueOf(r4Var.d0()));
                }
                u(sb, 1, "firebase_instance_id", r4Var.I());
                if (r4Var.i1()) {
                    u(sb, 1, "dev_cert_hash", Long.valueOf(r4Var.D1()));
                }
                u(sb, 1, "app_store", r4Var.T1());
                if (r4Var.v1()) {
                    u(sb, 1, "upload_timestamp_millis", Long.valueOf(r4Var.K1()));
                }
                if (r4Var.t1()) {
                    u(sb, 1, "start_timestamp_millis", Long.valueOf(r4Var.J1()));
                }
                if (r4Var.k1()) {
                    u(sb, 1, "end_timestamp_millis", Long.valueOf(r4Var.F1()));
                }
                if (r4Var.o1()) {
                    u(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(r4Var.I1()));
                }
                if (r4Var.n1()) {
                    u(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(r4Var.H1()));
                }
                u(sb, 1, "app_instance_id", r4Var.S1());
                u(sb, 1, "resettable_device_id", r4Var.N());
                u(sb, 1, "ds_id", r4Var.H());
                if (r4Var.m1()) {
                    u(sb, 1, "limited_ad_tracking", Boolean.valueOf(r4Var.A0()));
                }
                u(sb, 1, "os_version", r4Var.L());
                u(sb, 1, "device_model", r4Var.G());
                u(sb, 1, "user_default_language", r4Var.P());
                if (r4Var.u1()) {
                    u(sb, 1, "time_zone_offset_minutes", Integer.valueOf(r4Var.A1()));
                }
                if (r4Var.D0()) {
                    u(sb, 1, "bundle_sequential_index", Integer.valueOf(r4Var.d1()));
                }
                if (r4Var.r1()) {
                    u(sb, 1, "service_upload", Boolean.valueOf(r4Var.B0()));
                }
                u(sb, 1, "health_monitor", r4Var.K());
                if (r4Var.q1()) {
                    u(sb, 1, "retry_counter", Integer.valueOf(r4Var.z1()));
                }
                if (r4Var.h1()) {
                    u(sb, 1, "consent_signals", r4Var.F());
                }
                List<a5> S = r4Var.S();
                if (S != null) {
                    for (a5 a5Var : S) {
                        if (a5Var != null) {
                            r(sb, 2);
                            sb.append("user_property {\n");
                            u(sb, 2, "set_timestamp_millis", a5Var.V() ? Long.valueOf(a5Var.G()) : null);
                            u(sb, 2, "name", this.f2527a.D().f(a5Var.J()));
                            u(sb, 2, "string_value", a5Var.K());
                            u(sb, 2, "int_value", a5Var.U() ? Long.valueOf(a5Var.F()) : null);
                            u(sb, 2, "double_value", a5Var.T() ? Double.valueOf(a5Var.E()) : null);
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<c4> Q = r4Var.Q();
                if (Q != null) {
                    for (c4 c4Var : Q) {
                        if (c4Var != null) {
                            r(sb, 2);
                            sb.append("audience_membership {\n");
                            if (c4Var.O()) {
                                u(sb, 2, "audience_id", Integer.valueOf(c4Var.E()));
                            }
                            if (c4Var.P()) {
                                u(sb, 2, "new_audience", Boolean.valueOf(c4Var.N()));
                            }
                            t(sb, 2, "current_data", c4Var.H());
                            if (c4Var.Q()) {
                                t(sb, 2, "previous_data", c4Var.I());
                            }
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<g4> R = r4Var.R();
                if (R != null) {
                    for (g4 g4Var : R) {
                        if (g4Var != null) {
                            r(sb, 2);
                            sb.append("event {\n");
                            u(sb, 2, "name", this.f2527a.D().d(g4Var.L()));
                            if (g4Var.X()) {
                                u(sb, 2, "timestamp_millis", Long.valueOf(g4Var.H()));
                            }
                            if (g4Var.W()) {
                                u(sb, 2, "previous_timestamp_millis", Long.valueOf(g4Var.G()));
                            }
                            if (g4Var.V()) {
                                u(sb, 2, "count", Integer.valueOf(g4Var.E()));
                            }
                            if (g4Var.F() != 0) {
                                p(sb, 2, g4Var.M());
                            }
                            r(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                r(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String E(y2 y2Var) {
        if (y2Var == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (y2Var.S()) {
            u(sb, 0, "filter_id", Integer.valueOf(y2Var.F()));
        }
        u(sb, 0, "event_name", this.f2527a.D().d(y2Var.K()));
        String s = s(y2Var.O(), y2Var.P(), y2Var.Q());
        if (!s.isEmpty()) {
            u(sb, 0, "filter_type", s);
        }
        if (y2Var.R()) {
            v(sb, 1, "event_count_filter", y2Var.J());
        }
        if (y2Var.E() > 0) {
            sb.append("  filters {\n");
            for (a3 q : y2Var.L()) {
                q(sb, 2, q);
            }
        }
        r(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String F(g3 g3Var) {
        if (g3Var == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (g3Var.N()) {
            u(sb, 0, "filter_id", Integer.valueOf(g3Var.E()));
        }
        u(sb, 0, "property_name", this.f2527a.D().f(g3Var.I()));
        String s = s(g3Var.K(), g3Var.L(), g3Var.M());
        if (!s.isEmpty()) {
            u(sb, 0, "filter_type", s);
        }
        q(sb, 1, g3Var.F());
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final List G(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.f2527a.f().w().b("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.f2527a.f().w().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    /* access modifiers changed from: package-private */
    public final Map I(Bundle bundle, boolean z) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(I((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(I((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(I((Bundle) obj, false));
                    }
                    hashMap.put(str, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void J(j4 j4Var, Object obj) {
        n.i(obj);
        j4Var.y();
        j4Var.w();
        j4Var.v();
        j4Var.x();
        if (obj instanceof String) {
            j4Var.C((String) obj);
        } else if (obj instanceof Long) {
            j4Var.A(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            j4Var.z(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    j4 I = k4.I();
                    for (String str : bundle.keySet()) {
                        j4 I2 = k4.I();
                        I2.B(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            I2.A(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            I2.C((String) obj2);
                        } else if (obj2 instanceof Double) {
                            I2.z(((Double) obj2).doubleValue());
                        }
                        I.u(I2);
                    }
                    if (I.s() > 0) {
                        arrayList.add((k4) I.n());
                    }
                }
            }
            j4Var.t(arrayList);
        } else {
            this.f2527a.f().r().b("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(z4 z4Var, Object obj) {
        n.i(obj);
        z4Var.u();
        z4Var.t();
        z4Var.s();
        if (obj instanceof String) {
            z4Var.z((String) obj);
        } else if (obj instanceof Long) {
            z4Var.w(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            z4Var.v(((Double) obj).doubleValue());
        } else {
            this.f2527a.f().r().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean M(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.f2527a.a().a() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final byte[] O(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            this.f2527a.f().r().b("Failed to gzip content", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long x(byte[] bArr) {
        n.i(bArr);
        this.f2527a.N().h();
        MessageDigest t = la.t();
        if (t != null) {
            return la.q0(t.digest(bArr));
        }
        this.f2527a.f().r().a("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Bundle y(Map map, boolean z) {
        String obj;
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj2 = map.get(str);
            if (obj2 == null) {
                obj = null;
            } else if (obj2 instanceof Long) {
                bundle.putLong(str, ((Long) obj2).longValue());
            } else if (obj2 instanceof Double) {
                bundle.putDouble(str, ((Double) obj2).doubleValue());
            } else if (!(obj2 instanceof ArrayList)) {
                obj = obj2.toString();
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj2;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(y((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
            bundle.putString(str, obj);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.f2527a.f().r().a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable z(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ a -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ a -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ a -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ a -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ a -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002f
        L_0x001c:
            com.google.android.gms.measurement.internal.x4 r5 = r4.f2527a     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002f:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ea.z(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }
}
