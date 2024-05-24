package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.e3;
import c.d.a.b.e.e.k3;
import com.google.android.gms.common.internal.n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class ya {

    /* renamed from: a  reason: collision with root package name */
    final String f2643a;

    /* renamed from: b  reason: collision with root package name */
    final int f2644b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f2645c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f2646d;

    /* renamed from: e  reason: collision with root package name */
    Long f2647e;

    /* renamed from: f  reason: collision with root package name */
    Long f2648f;

    ya(String str, int i) {
        this.f2643a = str;
        this.f2644b = i;
    }

    private static Boolean d(String str, int i, boolean z, String str2, List list, String str3, m3 m3Var) {
        boolean startsWith;
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (m3Var != null) {
                        m3Var.w().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                if (list != null) {
                    startsWith = list.contains(str);
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009f, code lost:
        if (r8.compareTo(r5) <= 0) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Boolean e(java.math.BigDecimal r8, c.d.a.b.e.e.e3 r9, double r10) {
        /*
            com.google.android.gms.common.internal.n.i(r9)
            boolean r0 = r9.K()
            r1 = 0
            if (r0 == 0) goto L_0x0109
            int r0 = r9.P()
            r2 = 1
            if (r0 != r2) goto L_0x0013
            goto L_0x0109
        L_0x0013:
            int r0 = r9.P()
            r3 = 5
            if (r0 != r3) goto L_0x0028
            boolean r0 = r9.O()
            if (r0 == 0) goto L_0x0027
            boolean r0 = r9.N()
            if (r0 == 0) goto L_0x0027
            goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            boolean r0 = r9.L()
            if (r0 != 0) goto L_0x002f
            return r1
        L_0x002f:
            int r0 = r9.P()
            int r4 = r9.P()
            if (r4 != r3) goto L_0x0064
            java.lang.String r4 = r9.I()
            boolean r4 = com.google.android.gms.measurement.internal.ea.N(r4)
            if (r4 == 0) goto L_0x0063
            java.lang.String r4 = r9.H()
            boolean r4 = com.google.android.gms.measurement.internal.ea.N(r4)
            if (r4 != 0) goto L_0x004e
            goto L_0x0063
        L_0x004e:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r5 = r9.I()     // Catch:{ NumberFormatException -> 0x0063 }
            r4.<init>(r5)     // Catch:{ NumberFormatException -> 0x0063 }
            java.math.BigDecimal r5 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r9 = r9.H()     // Catch:{ NumberFormatException -> 0x0063 }
            r5.<init>(r9)     // Catch:{ NumberFormatException -> 0x0063 }
            r9 = r4
            r4 = r1
            goto L_0x007a
        L_0x0063:
            return r1
        L_0x0064:
            java.lang.String r4 = r9.G()
            boolean r4 = com.google.android.gms.measurement.internal.ea.N(r4)
            if (r4 != 0) goto L_0x006f
            return r1
        L_0x006f:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0109 }
            java.lang.String r9 = r9.G()     // Catch:{ NumberFormatException -> 0x0109 }
            r4.<init>(r9)     // Catch:{ NumberFormatException -> 0x0109 }
            r9 = r1
            r5 = r9
        L_0x007a:
            if (r0 != r3) goto L_0x007f
            if (r9 == 0) goto L_0x00fb
            goto L_0x0083
        L_0x007f:
            if (r4 != 0) goto L_0x0083
            goto L_0x00fb
        L_0x0083:
            int r0 = r0 + -1
            r3 = 0
            if (r0 == r2) goto L_0x00f9
            r6 = 2
            if (r0 == r6) goto L_0x00e9
            r7 = 3
            if (r0 == r7) goto L_0x00a8
            r10 = 4
            if (r0 == r10) goto L_0x0093
            goto L_0x00fb
        L_0x0093:
            if (r9 == 0) goto L_0x00fb
            int r9 = r8.compareTo(r9)
            if (r9 < 0) goto L_0x00a2
            int r8 = r8.compareTo(r5)
            if (r8 > 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r2 = 0
        L_0x00a3:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            goto L_0x00fb
        L_0x00a8:
            if (r4 != 0) goto L_0x00ab
            goto L_0x00fb
        L_0x00ab:
            r0 = 0
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 == 0) goto L_0x00e2
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r0)
            java.math.BigDecimal r9 = r4.subtract(r9)
            int r9 = r8.compareTo(r9)
            if (r9 <= 0) goto L_0x00a2
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r10)
            java.math.BigDecimal r9 = r4.add(r9)
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00e2:
            int r8 = r8.compareTo(r4)
            if (r8 != 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00e9:
            if (r4 != 0) goto L_0x00ec
            goto L_0x00fb
        L_0x00ec:
            int r8 = r8.compareTo(r4)
            if (r8 <= 0) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r2 = 0
        L_0x00f4:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x00f9:
            if (r4 != 0) goto L_0x00fc
        L_0x00fb:
            return r1
        L_0x00fc:
            int r8 = r8.compareTo(r4)
            if (r8 >= 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r2 = 0
        L_0x0104:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x0109:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ya.e(java.math.BigDecimal, c.d.a.b.e.e.e3, double):java.lang.Boolean");
    }

    static Boolean f(String str, k3 k3Var, m3 m3Var) {
        List list;
        n.i(k3Var);
        if (str == null || !k3Var.M() || k3Var.N() == 1) {
            return null;
        }
        if (k3Var.N() == 7) {
            if (k3Var.E() == 0) {
                return null;
            }
        } else if (!k3Var.L()) {
            return null;
        }
        int N = k3Var.N();
        boolean J = k3Var.J();
        String H = (J || N == 2 || N == 7) ? k3Var.H() : k3Var.H().toUpperCase(Locale.ENGLISH);
        if (k3Var.E() == 0) {
            list = null;
        } else {
            List<String> I = k3Var.I();
            if (!J) {
                ArrayList arrayList = new ArrayList(I.size());
                for (String upperCase : I) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                I = Collections.unmodifiableList(arrayList);
            }
            list = I;
        }
        return d(str, N, J, H, list, N == 2 ? H : null, m3Var);
    }

    static Boolean g(double d2, e3 e3Var) {
        try {
            return e(new BigDecimal(d2), e3Var, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(long j, e3 e3Var) {
        try {
            return e(new BigDecimal(j), e3Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, e3 e3Var) {
        if (!ea.N(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), e3Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public abstract boolean c();
}
