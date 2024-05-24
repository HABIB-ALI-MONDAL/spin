package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class b extends q9 {

    /* renamed from: d  reason: collision with root package name */
    private String f2310d;

    /* renamed from: e  reason: collision with root package name */
    private Set f2311e;

    /* renamed from: f  reason: collision with root package name */
    private Map f2312f;
    private Long g;
    private Long h;

    b(ca caVar) {
        super(caVar);
    }

    private final ua n(Integer num) {
        if (this.f2312f.containsKey(num)) {
            return (ua) this.f2312f.get(num);
        }
        ua uaVar = new ua(this, this.f2310d, (ta) null);
        this.f2312f.put(num, uaVar);
        return uaVar;
    }

    private final boolean o(int i, int i2) {
        ua uaVar = (ua) this.f2312f.get(Integer.valueOf(i));
        if (uaVar == null) {
            return false;
        }
        return uaVar.f2575d.get(i2);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ca, code lost:
        if (r5 != null) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02cc, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02d4, code lost:
        if (r5 != null) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f9, code lost:
        if (r5 != null) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02fc, code lost:
        com.google.android.gms.common.internal.n.e(r1);
        com.google.android.gms.common.internal.n.i(r13);
        r1 = new b.c.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030b, code lost:
        if (r13.isEmpty() == false) goto L_0x0311;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x030d, code lost:
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0311, code lost:
        r3 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x031d, code lost:
        if (r3.hasNext() == false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x031f, code lost:
        r4 = ((java.lang.Integer) r3.next()).intValue();
        r5 = java.lang.Integer.valueOf(r4);
        r6 = (c.d.a.b.e.e.w4) r13.get(r5);
        r7 = (java.util.List) r0.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0339, code lost:
        if (r7 == null) goto L_0x0449;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x033f, code lost:
        if (r7.isEmpty() == false) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0343, code lost:
        r17 = r0;
        r0 = r10.f2504b.f0().G(r6.O(), r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0357, code lost:
        if (r0.isEmpty() != false) goto L_0x0445;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0359, code lost:
        r5 = (c.d.a.b.e.e.v4) r6.B();
        r5.x();
        r5.t(r0);
        r20 = r3;
        r0 = r10.f2504b.f0().G(r6.Q(), r7);
        r5.z();
        r5.v(r0);
        c.d.a.b.e.e.qc.c();
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x038d, code lost:
        if (r10.f2527a.z().B((java.lang.String) null, com.google.android.gms.measurement.internal.y2.p0) == false) goto L_0x03f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x038f, code lost:
        r0 = new java.util.ArrayList();
        r3 = r6.N().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a0, code lost:
        if (r3.hasNext() == false) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03a2, code lost:
        r8 = (c.d.a.b.e.e.e4) r3.next();
        r23 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03b8, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r8.E())) != false) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03ba, code lost:
        r0.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03bd, code lost:
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03c1, code lost:
        r5.w();
        r5.s(r0);
        r0 = new java.util.ArrayList();
        r3 = r6.P().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03d8, code lost:
        if (r3.hasNext() == false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03da, code lost:
        r6 = (c.d.a.b.e.e.y4) r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ec, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.F())) != false) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03ee, code lost:
        r0.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03f2, code lost:
        r5.y();
        r5.u(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03f9, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03fe, code lost:
        if (r0 >= r6.E()) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0410, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.I(r0).E())) == false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0412, code lost:
        r5.A(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0415, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0418, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x041d, code lost:
        if (r0 >= r6.G()) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x042f, code lost:
        if (r7.contains(java.lang.Integer.valueOf(r6.M(r0).F())) == false) goto L_0x0434;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0431, code lost:
        r5.B(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0434, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0437, code lost:
        r1.put(java.lang.Integer.valueOf(r4), (c.d.a.b.e.e.w4) r5.n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0445, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0449, code lost:
        r17 = r0;
        r20 = r3;
        r21 = r8;
        r1.put(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0452, code lost:
        r0 = r17;
        r3 = r20;
        r8 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x045a, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0791, code lost:
        if (r5 != null) goto L_0x0793;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0793, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x07a1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x07a3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x07a4, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x07c3, code lost:
        if (r5 == null) goto L_0x07c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x07cc, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0941, code lost:
        if (r13 != null) goto L_0x0943;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0943, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0969, code lost:
        if (r13 == null) goto L_0x096c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0a95, code lost:
        if (r7 != false) goto L_0x0aa0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0150, code lost:
        if (r5 != null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0152, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0174, code lost:
        if (r5 != null) goto L_0x0152;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x045e  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0615  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x07a3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:266:0x0700] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07cc  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0879  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0974  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x0ac6  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0b5a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b3 A[Catch:{ SQLiteException -> 0x0226 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c3 A[SYNTHETIC, Splitter:B:70:0x01c3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List m(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            r64 = this;
            r10 = r64
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.n.e(r65)
            com.google.android.gms.common.internal.n.i(r66)
            com.google.android.gms.common.internal.n.i(r67)
            r0 = r65
            r10.f2310d = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.f2311e = r0
            b.c.a r0 = new b.c.a
            r0.<init>()
            r10.f2312f = r0
            r0 = r68
            r10.g = r0
            r0 = r69
            r10.h = r0
            java.util.Iterator r0 = r66.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            c.d.a.b.e.e.g4 r1 = (c.d.a.b.e.e.g4) r1
            java.lang.String r1 = r1.L()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0048
        L_0x0047:
            r1 = 0
        L_0x0048:
            c.d.a.b.e.e.mc.c()
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            java.lang.String r2 = r10.f2310d
            com.google.android.gms.measurement.internal.x2 r3 = com.google.android.gms.measurement.internal.y2.X
            boolean r14 = r0.B(r2, r3)
            c.d.a.b.e.e.mc.c()
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            java.lang.String r2 = r10.f2310d
            com.google.android.gms.measurement.internal.x2 r3 = com.google.android.gms.measurement.internal.y2.W
            boolean r15 = r0.B(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r2 = r0.V()
            java.lang.String r3 = r10.f2310d
            r2.i()
            r2.h()
            com.google.android.gms.common.internal.n.e(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.P()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x009b }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.c(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017d
            if (r14 == 0) goto L_0x017d
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r2 = r0.V()
            java.lang.String r3 = r10.f2310d
            com.google.android.gms.common.internal.n.e(r3)
            b.c.a r4 = new b.c.a
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.P()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String[] r0 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            r0[r12] = r3     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015d, all -> 0x015a }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 == 0) goto L_0x014c
        L_0x00f1:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0158 }
            c.d.a.b.e.e.x2 r13 = c.d.a.b.e.e.y2.G()     // Catch:{ IOException -> 0x012a }
            com.google.android.gms.measurement.internal.ea.C(r13, r0)     // Catch:{ IOException -> 0x012a }
            c.d.a.b.e.e.x2 r13 = (c.d.a.b.e.e.x2) r13     // Catch:{ IOException -> 0x012a }
            c.d.a.b.e.e.s8 r0 = r13.n()     // Catch:{ IOException -> 0x012a }
            c.d.a.b.e.e.y2 r0 = (c.d.a.b.e.e.y2) r0     // Catch:{ IOException -> 0x012a }
            boolean r13 = r0.R()     // Catch:{ SQLiteException -> 0x0158 }
            if (r13 != 0) goto L_0x010b
            goto L_0x013c
        L_0x010b:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0158 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0158 }
            if (r16 != 0) goto L_0x0124
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0158 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0158 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x0126
        L_0x0124:
            r12 = r16
        L_0x0126:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0158 }
            goto L_0x013c
        L_0x012a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r12 = r2.f2527a     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.m3 r12 = r12.f()     // Catch:{ SQLiteException -> 0x0158 }
            com.google.android.gms.measurement.internal.k3 r12 = r12.r()     // Catch:{ SQLiteException -> 0x0158 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0158 }
            r12.c(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0158 }
        L_0x013c:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0158 }
            if (r0 != 0) goto L_0x0149
            if (r5 == 0) goto L_0x0147
            r5.close()
        L_0x0147:
            r12 = r4
            goto L_0x017e
        L_0x0149:
            r12 = 0
            r13 = 1
            goto L_0x00f1
        L_0x014c:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0158 }
            if (r5 == 0) goto L_0x017d
        L_0x0152:
            r5.close()
            goto L_0x017d
        L_0x0156:
            r0 = move-exception
            goto L_0x0177
        L_0x0158:
            r0 = move-exception
            goto L_0x015f
        L_0x015a:
            r0 = move-exception
            r5 = 0
            goto L_0x0177
        L_0x015d:
            r0 = move-exception
            r5 = 0
        L_0x015f:
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0156 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x0156 }
            r2.c(r8, r3, r0)     // Catch:{ all -> 0x0156 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0156 }
            if (r5 == 0) goto L_0x017d
            goto L_0x0152
        L_0x0177:
            if (r5 == 0) goto L_0x017c
            r5.close()
        L_0x017c:
            throw r0
        L_0x017d:
            r12 = r0
        L_0x017e:
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r2 = r0.V()
            java.lang.String r3 = r10.f2310d
            r2.i()
            r2.h()
            com.google.android.gms.common.internal.n.e(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.P()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r4 = 1
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            r4 = 0
            r0[r4] = r3     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0230, all -> 0x022c }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0226 }
            if (r0 != 0) goto L_0x01c3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0226 }
            if (r4 == 0) goto L_0x01bc
            r4.close()
        L_0x01bc:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0253
        L_0x01c3:
            b.c.a r5 = new b.c.a     // Catch:{ SQLiteException -> 0x0226 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0226 }
        L_0x01c8:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0226 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0226 }
            c.d.a.b.e.e.v4 r13 = c.d.a.b.e.e.w4.J()     // Catch:{ IOException -> 0x01ef }
            com.google.android.gms.measurement.internal.ea.C(r13, r0)     // Catch:{ IOException -> 0x01ef }
            c.d.a.b.e.e.v4 r13 = (c.d.a.b.e.e.v4) r13     // Catch:{ IOException -> 0x01ef }
            c.d.a.b.e.e.s8 r0 = r13.n()     // Catch:{ IOException -> 0x01ef }
            c.d.a.b.e.e.w4 r0 = (c.d.a.b.e.e.w4) r0     // Catch:{ IOException -> 0x01ef }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0226 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020d
        L_0x01ef:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r13 = r2.f2527a     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.k3 r13 = r13.r()     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0224 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0222 }
            r13.d(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0222 }
        L_0x020d:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0222 }
            if (r0 != 0) goto L_0x021b
            if (r4 == 0) goto L_0x0218
            r4.close()
        L_0x0218:
            r13 = r17
            goto L_0x0253
        L_0x021b:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c8
        L_0x0222:
            r0 = move-exception
            goto L_0x0236
        L_0x0224:
            r0 = move-exception
            goto L_0x0229
        L_0x0226:
            r0 = move-exception
            r18 = r6
        L_0x0229:
            r19 = r7
            goto L_0x0236
        L_0x022c:
            r0 = move-exception
            r5 = 0
            goto L_0x0b58
        L_0x0230:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0236:
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0b56 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0b56 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0b56 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x0b56 }
            r2.c(r5, r3, r0)     // Catch:{ all -> 0x0b56 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b56 }
            if (r4 == 0) goto L_0x0252
            r4.close()
        L_0x0252:
            r13 = r0
        L_0x0253:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0262
            r12 = r8
            r13 = r9
            r28 = r18
            r29 = r19
            goto L_0x0609
        L_0x0262:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0462
            java.lang.String r1 = r10.f2310d
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r3 = r0.V()
            java.lang.String r4 = r10.f2310d
            r3.i()
            r3.h()
            com.google.android.gms.common.internal.n.e(r4)
            b.c.a r0 = new b.c.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.P()
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02dc }
            r16 = 0
            r6[r16] = r4     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02dc }
            r16 = 1
            r6[r16] = r4     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02dc }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02e0, all -> 0x02dc }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02da }
            if (r6 == 0) goto L_0x02d0
        L_0x029f:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02da }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02da }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02da }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02da }
            if (r7 != 0) goto L_0x02b8
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02da }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02da }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02da }
        L_0x02b8:
            r6 = 1
            int r17 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02da }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ SQLiteException -> 0x02da }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02da }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02da }
            if (r6 != 0) goto L_0x029f
            if (r5 == 0) goto L_0x02fc
        L_0x02cc:
            r5.close()
            goto L_0x02fc
        L_0x02d0:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02da }
            if (r5 == 0) goto L_0x02fc
            goto L_0x02cc
        L_0x02d7:
            r0 = move-exception
            goto L_0x045c
        L_0x02da:
            r0 = move-exception
            goto L_0x02e2
        L_0x02dc:
            r0 = move-exception
            r5 = 0
            goto L_0x045c
        L_0x02e0:
            r0 = move-exception
            r5 = 0
        L_0x02e2:
            com.google.android.gms.measurement.internal.x4 r3 = r3.f2527a     // Catch:{ all -> 0x02d7 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x02d7 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x02d7 }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r4)     // Catch:{ all -> 0x02d7 }
            r3.c(r6, r4, r0)     // Catch:{ all -> 0x02d7 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02d7 }
            if (r5 == 0) goto L_0x02fc
            goto L_0x02cc
        L_0x02fc:
            com.google.android.gms.common.internal.n.e(r1)
            com.google.android.gms.common.internal.n.i(r13)
            b.c.a r1 = new b.c.a
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x0311
        L_0x030d:
            r21 = r8
            goto L_0x045a
        L_0x0311:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0319:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x030d
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            c.d.a.b.e.e.w4 r6 = (c.d.a.b.e.e.w4) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x0449
            boolean r17 = r7.isEmpty()
            if (r17 == 0) goto L_0x0343
            goto L_0x0449
        L_0x0343:
            com.google.android.gms.measurement.internal.ca r5 = r10.f2504b
            com.google.android.gms.measurement.internal.ea r5 = r5.f0()
            r17 = r0
            java.util.List r0 = r6.O()
            java.util.List r0 = r5.G(r0, r7)
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0445
            c.d.a.b.e.e.p8 r5 = r6.B()
            c.d.a.b.e.e.v4 r5 = (c.d.a.b.e.e.v4) r5
            r5.x()
            r5.t(r0)
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.ea r0 = r0.f0()
            r20 = r3
            java.util.List r3 = r6.Q()
            java.util.List r0 = r0.G(r3, r7)
            r5.z()
            r5.v(r0)
            c.d.a.b.e.e.qc.c()
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            com.google.android.gms.measurement.internal.x2 r3 = com.google.android.gms.measurement.internal.y2.p0
            r21 = r8
            r8 = 0
            boolean r0 = r0.B(r8, r3)
            if (r0 == 0) goto L_0x03f9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.N()
            java.util.Iterator r3 = r3.iterator()
        L_0x039c:
            boolean r22 = r3.hasNext()
            if (r22 == 0) goto L_0x03c1
            java.lang.Object r22 = r3.next()
            r8 = r22
            c.d.a.b.e.e.e4 r8 = (c.d.a.b.e.e.e4) r8
            int r22 = r8.E()
            r23 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            boolean r3 = r7.contains(r3)
            if (r3 != 0) goto L_0x03bd
            r0.add(r8)
        L_0x03bd:
            r3 = r23
            r8 = 0
            goto L_0x039c
        L_0x03c1:
            r5.w()
            r5.s(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.P()
            java.util.Iterator r3 = r3.iterator()
        L_0x03d4:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x03f2
            java.lang.Object r6 = r3.next()
            c.d.a.b.e.e.y4 r6 = (c.d.a.b.e.e.y4) r6
            int r8 = r6.F()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r7.contains(r8)
            if (r8 != 0) goto L_0x03d4
            r0.add(r6)
            goto L_0x03d4
        L_0x03f2:
            r5.y()
            r5.u(r0)
            goto L_0x0437
        L_0x03f9:
            r0 = 0
        L_0x03fa:
            int r3 = r6.E()
            if (r0 >= r3) goto L_0x0418
            c.d.a.b.e.e.e4 r3 = r6.I(r0)
            int r3 = r3.E()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0415
            r5.A(r0)
        L_0x0415:
            int r0 = r0 + 1
            goto L_0x03fa
        L_0x0418:
            r0 = 0
        L_0x0419:
            int r3 = r6.G()
            if (r0 >= r3) goto L_0x0437
            c.d.a.b.e.e.y4 r3 = r6.M(r0)
            int r3 = r3.F()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x0434
            r5.B(r0)
        L_0x0434:
            int r0 = r0 + 1
            goto L_0x0419
        L_0x0437:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            c.d.a.b.e.e.s8 r3 = r5.n()
            c.d.a.b.e.e.w4 r3 = (c.d.a.b.e.e.w4) r3
            r1.put(r0, r3)
            goto L_0x0452
        L_0x0445:
            r0 = r17
            goto L_0x0319
        L_0x0449:
            r17 = r0
            r20 = r3
            r21 = r8
            r1.put(r5, r6)
        L_0x0452:
            r0 = r17
            r3 = r20
            r8 = r21
            goto L_0x0319
        L_0x045a:
            r0 = r1
            goto L_0x0465
        L_0x045c:
            if (r5 == 0) goto L_0x0461
            r5.close()
        L_0x0461:
            throw r0
        L_0x0462:
            r21 = r8
            r0 = r13
        L_0x0465:
            java.util.Iterator r17 = r2.iterator()
        L_0x0469:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0602
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r20 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r0.get(r1)
            c.d.a.b.e.e.w4 r1 = (c.d.a.b.e.e.w4) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            b.c.a r7 = new b.c.a
            r7.<init>()
            if (r1 == 0) goto L_0x04d1
            int r2 = r1.E()
            if (r2 != 0) goto L_0x049b
            goto L_0x04d1
        L_0x049b:
            java.util.List r2 = r1.N()
            java.util.Iterator r2 = r2.iterator()
        L_0x04a3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d1
            java.lang.Object r3 = r2.next()
            c.d.a.b.e.e.e4 r3 = (c.d.a.b.e.e.e4) r3
            boolean r4 = r3.L()
            if (r4 == 0) goto L_0x04a3
            int r4 = r3.E()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.K()
            if (r8 == 0) goto L_0x04cc
            long r22 = r3.F()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x04cd
        L_0x04cc:
            r3 = 0
        L_0x04cd:
            r7.put(r4, r3)
            goto L_0x04a3
        L_0x04d1:
            b.c.a r8 = new b.c.a
            r8.<init>()
            if (r1 == 0) goto L_0x051d
            int r2 = r1.G()
            if (r2 != 0) goto L_0x04df
            goto L_0x051d
        L_0x04df:
            java.util.List r2 = r1.P()
            java.util.Iterator r2 = r2.iterator()
        L_0x04e7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x051d
            java.lang.Object r3 = r2.next()
            c.d.a.b.e.e.y4 r3 = (c.d.a.b.e.e.y4) r3
            boolean r4 = r3.M()
            if (r4 == 0) goto L_0x04e7
            int r4 = r3.E()
            if (r4 <= 0) goto L_0x04e7
            int r4 = r3.F()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.E()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.G(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x04e7
        L_0x051d:
            r23 = r0
            if (r1 == 0) goto L_0x056c
            r0 = 0
        L_0x0522:
            int r2 = r1.H()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x056c
            java.util.List r2 = r1.Q()
            boolean r2 = com.google.android.gms.measurement.internal.ea.L(r2, r0)
            if (r2 == 0) goto L_0x055e
            com.google.android.gms.measurement.internal.x4 r2 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.v()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.c(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.O()
            boolean r2 = com.google.android.gms.measurement.internal.ea.L(r2, r0)
            if (r2 == 0) goto L_0x0560
            r5.set(r0)
            goto L_0x0567
        L_0x055e:
            r22 = r9
        L_0x0560:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0567:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x0522
        L_0x056c:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            c.d.a.b.e.e.w4 r4 = (c.d.a.b.e.e.w4) r4
            if (r15 == 0) goto L_0x05d9
            if (r14 == 0) goto L_0x05d9
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x05d9
            java.lang.Long r1 = r10.h
            if (r1 == 0) goto L_0x05d9
            java.lang.Long r1 = r10.g
            if (r1 != 0) goto L_0x058e
            goto L_0x05d9
        L_0x058e:
            java.util.Iterator r0 = r0.iterator()
        L_0x0592:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05d9
            java.lang.Object r1 = r0.next()
            c.d.a.b.e.e.y2 r1 = (c.d.a.b.e.e.y2) r1
            int r2 = r1.F()
            java.lang.Long r3 = r10.h
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.P()
            if (r1 == 0) goto L_0x05ba
            java.lang.Long r1 = r10.g
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x05ba:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x05cb
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x05cb:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0592
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0592
        L_0x05d9:
            com.google.android.gms.measurement.internal.ua r0 = new com.google.android.gms.measurement.internal.ua
            java.lang.String r3 = r10.f2310d
            r9 = 0
            r1 = r0
            r2 = r64
            r28 = r18
            r29 = r19
            r16 = r12
            r12 = r21
            r65 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.f2312f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r1.put(r2, r0)
            r9 = r13
            r12 = r16
            r0 = r23
            r13 = r65
            goto L_0x0469
        L_0x0602:
            r13 = r9
            r28 = r18
            r29 = r19
            r12 = r21
        L_0x0609:
            boolean r0 = r66.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x0615
        L_0x0611:
            r24 = r11
            goto L_0x086f
        L_0x0615:
            com.google.android.gms.measurement.internal.wa r2 = new com.google.android.gms.measurement.internal.wa
            r3 = 0
            r2.<init>(r10, r3)
            b.c.a r4 = new b.c.a
            r4.<init>()
            java.util.Iterator r5 = r66.iterator()
        L_0x0624:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0611
            java.lang.Object r0 = r5.next()
            c.d.a.b.e.e.g4 r0 = (c.d.a.b.e.e.g4) r0
            java.lang.String r6 = r10.f2310d
            c.d.a.b.e.e.g4 r6 = r2.a(r6, r0)
            if (r6 == 0) goto L_0x0624
            com.google.android.gms.measurement.internal.ca r7 = r10.f2504b
            com.google.android.gms.measurement.internal.n r7 = r7.V()
            java.lang.String r8 = r10.f2310d
            java.lang.String r9 = r6.L()
            java.lang.String r14 = r0.L()
            com.google.android.gms.measurement.internal.t r14 = r7.V(r8, r14)
            if (r14 != 0) goto L_0x068d
            com.google.android.gms.measurement.internal.x4 r14 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r14 = r14.f()
            com.google.android.gms.measurement.internal.k3 r14 = r14.w()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.m3.z(r8)
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r7 = r7.d(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.c(r9, r15, r7)
            com.google.android.gms.measurement.internal.t r7 = new com.google.android.gms.measurement.internal.t
            r30 = r7
            java.lang.String r32 = r0.L()
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r0.H()
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r31 = r8
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)
            goto L_0x06c2
        L_0x068d:
            com.google.android.gms.measurement.internal.t r7 = new com.google.android.gms.measurement.internal.t
            r47 = r7
            java.lang.String r0 = r14.f2540a
            r48 = r0
            java.lang.String r0 = r14.f2541b
            r49 = r0
            long r8 = r14.f2542c
            r15 = 1
            long r50 = r8 + r15
            long r8 = r14.f2543d
            long r52 = r8 + r15
            long r8 = r14.f2544e
            long r54 = r8 + r15
            long r8 = r14.f2545f
            r56 = r8
            long r8 = r14.g
            r58 = r8
            java.lang.Long r0 = r14.h
            r60 = r0
            java.lang.Long r0 = r14.i
            r61 = r0
            java.lang.Long r0 = r14.j
            r62 = r0
            java.lang.Boolean r0 = r14.k
            r63 = r0
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r60, r61, r62, r63)
        L_0x06c2:
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r0 = r0.V()
            r0.q(r7)
            long r8 = r7.f2542c
            java.lang.String r14 = r6.L()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07d0
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r15 = r0.V()
            java.lang.String r3 = r10.f2310d
            r15.i()
            r15.h()
            com.google.android.gms.common.internal.n.e(r3)
            com.google.android.gms.common.internal.n.e(r14)
            r65 = r2
            b.c.a r2 = new b.c.a
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r15.P()
            r66 = r5
            r24 = r11
            r11 = r28
            r5 = r29
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x07a6, all -> 0x07a3 }
            r29 = r5
            r5 = 2
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x07a1, all -> 0x07a3 }
            r17 = 0
            r0[r17] = r3     // Catch:{ SQLiteException -> 0x07a1, all -> 0x07a3 }
            r17 = 1
            r0[r17] = r14     // Catch:{ SQLiteException -> 0x07a1, all -> 0x07a3 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r21 = 0
            r22 = 0
            r23 = 0
            r20 = r0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x07a1, all -> 0x07a3 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x079b }
            if (r0 == 0) goto L_0x0789
            r28 = r11
        L_0x0729:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0785 }
            c.d.a.b.e.e.x2 r11 = c.d.a.b.e.e.y2.G()     // Catch:{ IOException -> 0x0761 }
            com.google.android.gms.measurement.internal.ea.C(r11, r0)     // Catch:{ IOException -> 0x0761 }
            c.d.a.b.e.e.x2 r11 = (c.d.a.b.e.e.x2) r11     // Catch:{ IOException -> 0x0761 }
            c.d.a.b.e.e.s8 r0 = r11.n()     // Catch:{ IOException -> 0x0761 }
            c.d.a.b.e.e.y2 r0 = (c.d.a.b.e.e.y2) r0     // Catch:{ IOException -> 0x0761 }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x0785 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0785 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x0785 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0785 }
            if (r16 != 0) goto L_0x0759
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0797 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0797 }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x0797 }
            goto L_0x075d
        L_0x0759:
            r22 = r7
            r7 = r16
        L_0x075d:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x0797 }
            goto L_0x0775
        L_0x0761:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.x4 r7 = r15.f2527a     // Catch:{ SQLiteException -> 0x0797 }
            com.google.android.gms.measurement.internal.m3 r7 = r7.f()     // Catch:{ SQLiteException -> 0x0797 }
            com.google.android.gms.measurement.internal.k3 r7 = r7.r()     // Catch:{ SQLiteException -> 0x0797 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0797 }
            r7.c(r13, r11, r0)     // Catch:{ SQLiteException -> 0x0797 }
        L_0x0775:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0797 }
            if (r0 != 0) goto L_0x0782
            if (r5 == 0) goto L_0x0780
            r5.close()
        L_0x0780:
            r0 = r2
            goto L_0x07c6
        L_0x0782:
            r7 = r22
            goto L_0x0729
        L_0x0785:
            r0 = move-exception
            r22 = r7
            goto L_0x07ae
        L_0x0789:
            r22 = r7
            r28 = r11
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0797 }
            if (r5 == 0) goto L_0x07c6
        L_0x0793:
            r5.close()
            goto L_0x07c6
        L_0x0797:
            r0 = move-exception
            goto L_0x07ae
        L_0x0799:
            r0 = move-exception
            goto L_0x07ca
        L_0x079b:
            r0 = move-exception
            r22 = r7
            r28 = r11
            goto L_0x07ae
        L_0x07a1:
            r0 = move-exception
            goto L_0x07a9
        L_0x07a3:
            r0 = move-exception
            r5 = 0
            goto L_0x07ca
        L_0x07a6:
            r0 = move-exception
            r29 = r5
        L_0x07a9:
            r22 = r7
            r28 = r11
            r5 = 0
        L_0x07ae:
            com.google.android.gms.measurement.internal.x4 r2 = r15.f2527a     // Catch:{ all -> 0x0799 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0799 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0799 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x0799 }
            r2.c(r12, r3, r0)     // Catch:{ all -> 0x0799 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0799 }
            if (r5 == 0) goto L_0x07c6
            goto L_0x0793
        L_0x07c6:
            r4.put(r14, r0)
            goto L_0x07d8
        L_0x07ca:
            if (r5 == 0) goto L_0x07cf
            r5.close()
        L_0x07cf:
            throw r0
        L_0x07d0:
            r65 = r2
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x07d8:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07e0:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0866
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.f2311e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x080a
            com.google.android.gms.measurement.internal.x4 r3 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.v()
            r3.b(r1, r7)
            goto L_0x07e0
        L_0x080a:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x0815:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x0859
            java.lang.Object r7 = r5.next()
            c.d.a.b.e.e.y2 r7 = (c.d.a.b.e.e.y2) r7
            com.google.android.gms.measurement.internal.xa r11 = new com.google.android.gms.measurement.internal.xa
            java.lang.String r14 = r10.f2310d
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r15 = r10.g
            java.lang.Long r14 = r10.h
            int r7 = r7.F()
            boolean r21 = r10.o(r3, r7)
            r7 = r14
            r14 = r11
            r16 = r7
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r7 = r14.k(r15, r16, r17, r18, r20, r21)
            if (r7 == 0) goto L_0x0850
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.ua r14 = r10.n(r14)
            r14.c(r11)
            goto L_0x0815
        L_0x0850:
            java.util.Set r5 = r10.f2311e
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x0859:
            if (r7 != 0) goto L_0x07e0
            java.util.Set r5 = r10.f2311e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x07e0
        L_0x0866:
            r2 = r65
            r5 = r66
            r11 = r24
            r3 = 0
            goto L_0x0624
        L_0x086f:
            boolean r0 = r67.isEmpty()
            if (r0 == 0) goto L_0x0879
        L_0x0875:
            r11 = r28
            goto L_0x0aac
        L_0x0879:
            b.c.a r2 = new b.c.a
            r2.<init>()
            java.util.Iterator r3 = r67.iterator()
        L_0x0882:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0875
            java.lang.Object r0 = r3.next()
            r4 = r0
            c.d.a.b.e.e.a5 r4 = (c.d.a.b.e.e.a5) r4
            java.lang.String r5 = r4.J()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0978
            com.google.android.gms.measurement.internal.ca r0 = r10.f2504b
            com.google.android.gms.measurement.internal.n r6 = r0.V()
            java.lang.String r7 = r10.f2310d
            r6.i()
            r6.h()
            com.google.android.gms.common.internal.n.e(r7)
            com.google.android.gms.common.internal.n.e(r5)
            b.c.a r8 = new b.c.a
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.P()
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0950, all -> 0x094d }
            r14 = 2
            java.lang.String[] r0 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0950, all -> 0x094d }
            r14 = 0
            r0[r14] = r7     // Catch:{ SQLiteException -> 0x0950, all -> 0x094d }
            r14 = 1
            r0[r14] = r5     // Catch:{ SQLiteException -> 0x0950, all -> 0x094d }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0950, all -> 0x094d }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0949 }
            if (r0 == 0) goto L_0x093b
        L_0x08df:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x0949 }
            c.d.a.b.e.e.f3 r15 = c.d.a.b.e.e.g3.G()     // Catch:{ IOException -> 0x0915 }
            com.google.android.gms.measurement.internal.ea.C(r15, r0)     // Catch:{ IOException -> 0x0915 }
            c.d.a.b.e.e.f3 r15 = (c.d.a.b.e.e.f3) r15     // Catch:{ IOException -> 0x0915 }
            c.d.a.b.e.e.s8 r0 = r15.n()     // Catch:{ IOException -> 0x0915 }
            c.d.a.b.e.e.g3 r0 = (c.d.a.b.e.e.g3) r0     // Catch:{ IOException -> 0x0915 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x0949 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0949 }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x0949 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0949 }
            if (r16 != 0) goto L_0x090d
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0949 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x0949 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x0949 }
            goto L_0x090f
        L_0x090d:
            r15 = r16
        L_0x090f:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x0949 }
            r65 = r3
            goto L_0x092b
        L_0x0915:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r14 = r6.f2527a     // Catch:{ SQLiteException -> 0x0949 }
            com.google.android.gms.measurement.internal.m3 r14 = r14.f()     // Catch:{ SQLiteException -> 0x0949 }
            com.google.android.gms.measurement.internal.k3 r14 = r14.r()     // Catch:{ SQLiteException -> 0x0949 }
            java.lang.String r15 = "Failed to merge filter"
            r65 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r7)     // Catch:{ SQLiteException -> 0x0947 }
            r14.c(r15, r3, r0)     // Catch:{ SQLiteException -> 0x0947 }
        L_0x092b:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0947 }
            if (r0 != 0) goto L_0x0938
            if (r13 == 0) goto L_0x0936
            r13.close()
        L_0x0936:
            r0 = r8
            goto L_0x096c
        L_0x0938:
            r3 = r65
            goto L_0x08df
        L_0x093b:
            r65 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0947 }
            if (r13 == 0) goto L_0x096c
        L_0x0943:
            r13.close()
            goto L_0x096c
        L_0x0947:
            r0 = move-exception
            goto L_0x0954
        L_0x0949:
            r0 = move-exception
            r65 = r3
            goto L_0x0954
        L_0x094d:
            r0 = move-exception
            r5 = 0
            goto L_0x0972
        L_0x0950:
            r0 = move-exception
            r65 = r3
            r13 = 0
        L_0x0954:
            com.google.android.gms.measurement.internal.x4 r3 = r6.f2527a     // Catch:{ all -> 0x0970 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x0970 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x0970 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r7)     // Catch:{ all -> 0x0970 }
            r3.c(r12, r6, r0)     // Catch:{ all -> 0x0970 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0970 }
            if (r13 == 0) goto L_0x096c
            goto L_0x0943
        L_0x096c:
            r2.put(r5, r0)
            goto L_0x097e
        L_0x0970:
            r0 = move-exception
            r5 = r13
        L_0x0972:
            if (r5 == 0) goto L_0x0977
            r5.close()
        L_0x0977:
            throw r0
        L_0x0978:
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x097e:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0986:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0aa4
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.f2311e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x09b1
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            r0.b(r1, r7)
            goto L_0x0aa4
        L_0x09b1:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x09bc:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a93
            java.lang.Object r7 = r6.next()
            c.d.a.b.e.e.g3 r7 = (c.d.a.b.e.e.g3) r7
            com.google.android.gms.measurement.internal.x4 r8 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r8 = r8.f()
            java.lang.String r8 = r8.C()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x0a26
            com.google.android.gms.measurement.internal.x4 r8 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r8 = r8.f()
            com.google.android.gms.measurement.internal.k3 r8 = r8.v()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.N()
            if (r15 == 0) goto L_0x09f6
            int r15 = r7.E()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09f7
        L_0x09f6:
            r15 = 0
        L_0x09f7:
            com.google.android.gms.measurement.internal.x4 r13 = r10.f2527a
            com.google.android.gms.measurement.internal.h3 r13 = r13.D()
            r66 = r0
            java.lang.String r0 = r7.I()
            java.lang.String r0 = r13.f(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.d(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            com.google.android.gms.measurement.internal.ca r8 = r10.f2504b
            com.google.android.gms.measurement.internal.ea r8 = r8.f0()
            java.lang.String r8 = r8.F(r7)
            java.lang.String r13 = "Filter definition"
            r0.b(r13, r8)
            goto L_0x0a28
        L_0x0a26:
            r66 = r0
        L_0x0a28:
            boolean r0 = r7.N()
            if (r0 == 0) goto L_0x0a69
            int r0 = r7.E()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x0a37
            goto L_0x0a69
        L_0x0a37:
            com.google.android.gms.measurement.internal.za r0 = new com.google.android.gms.measurement.internal.za
            java.lang.String r8 = r10.f2310d
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.g
            java.lang.Long r13 = r10.h
            int r7 = r7.E()
            boolean r7 = r10.o(r5, r7)
            boolean r7 = r0.k(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a5f
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.ua r8 = r10.n(r8)
            r8.c(r0)
            r0 = r66
            goto L_0x09bc
        L_0x0a5f:
            java.util.Set r0 = r10.f2311e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a95
        L_0x0a69:
            com.google.android.gms.measurement.internal.x4 r0 = r10.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.String r6 = r10.f2310d
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r6)
            boolean r8 = r7.N()
            if (r8 == 0) goto L_0x0a88
            int r7 = r7.E()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a89
        L_0x0a88:
            r7 = 0
        L_0x0a89:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.c(r8, r6, r7)
            goto L_0x0a97
        L_0x0a93:
            r66 = r0
        L_0x0a95:
            if (r7 != 0) goto L_0x0aa0
        L_0x0a97:
            java.util.Set r0 = r10.f2311e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0aa0:
            r0 = r66
            goto L_0x0986
        L_0x0aa4:
            r3 = r65
            r29 = r9
            r28 = r11
            goto L_0x0882
        L_0x0aac:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.f2312f
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.f2311e
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0ac0:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b55
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.f2312f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.ua r3 = (com.google.android.gms.measurement.internal.ua) r3
            com.google.android.gms.common.internal.n.i(r3)
            c.d.a.b.e.e.c4 r0 = r3.a(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.ca r3 = r10.f2504b
            com.google.android.gms.measurement.internal.n r3 = r3.V()
            java.lang.String r5 = r10.f2310d
            c.d.a.b.e.e.w4 r0 = r0.H()
            r3.i()
            r3.h()
            com.google.android.gms.common.internal.n.e(r5)
            com.google.android.gms.common.internal.n.i(r0)
            byte[] r0 = r0.k()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r24
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.P()     // Catch:{ SQLiteException -> 0x0b3c }
            java.lang.String r7 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r6 = r0.insertWithOnConflict(r7, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0b3a }
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b51
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a     // Catch:{ SQLiteException -> 0x0b3a }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x0b3a }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0b3a }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r5)     // Catch:{ SQLiteException -> 0x0b3a }
            r0.b(r6, r7)     // Catch:{ SQLiteException -> 0x0b3a }
            goto L_0x0b51
        L_0x0b3a:
            r0 = move-exception
            goto L_0x0b3e
        L_0x0b3c:
            r0 = move-exception
            r9 = 0
        L_0x0b3e:
            com.google.android.gms.measurement.internal.x4 r3 = r3.f2527a
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.c(r6, r5, r0)
        L_0x0b51:
            r24 = r4
            goto L_0x0ac0
        L_0x0b55:
            return r1
        L_0x0b56:
            r0 = move-exception
            r5 = r4
        L_0x0b58:
            if (r5 == 0) goto L_0x0b5d
            r5.close()
        L_0x0b5d:
            goto L_0x0b5f
        L_0x0b5e:
            throw r0
        L_0x0b5f:
            goto L_0x0b5e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.b.m(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
