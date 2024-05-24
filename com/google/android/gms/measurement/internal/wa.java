package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.g4;

final class wa {

    /* renamed from: a  reason: collision with root package name */
    private g4 f2609a;

    /* renamed from: b  reason: collision with root package name */
    private Long f2610b;

    /* renamed from: c  reason: collision with root package name */
    private long f2611c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ b f2612d;

    /* synthetic */ wa(b bVar, va vaVar) {
        this.f2612d = bVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e5, code lost:
        if (r14 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ff, code lost:
        if (r14 != null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0101, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.g4 a(java.lang.String r18, c.d.a.b.e.e.g4 r19) {
        /*
            r17 = this;
            r1 = r17
            r3 = r18
            r8 = r19
            java.lang.String r0 = r19.L()
            java.util.List r9 = r19.M()
            com.google.android.gms.measurement.internal.b r2 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r2 = r2.f2504b
            r2.f0()
            java.lang.String r2 = "_eid"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.ea.o(r8, r2)
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x0237
            java.lang.String r5 = "_ep"
            boolean r5 = r0.equals(r5)
            r6 = 0
            if (r5 == 0) goto L_0x01eb
            com.google.android.gms.common.internal.n.i(r4)
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b
            r0.f0()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.ea.o(r8, r0)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r5 = 0
            if (r0 == 0) goto L_0x0055
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.t()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.b(r2, r4)
            return r5
        L_0x0055:
            c.d.a.b.e.e.g4 r0 = r1.f2609a
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x006d
            java.lang.Long r0 = r1.f2610b
            if (r0 == 0) goto L_0x006d
            long r13 = r4.longValue()
            java.lang.Long r0 = r1.f2610b
            long r15 = r0.longValue()
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x012c
        L_0x006d:
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b
            com.google.android.gms.measurement.internal.n r13 = r0.V()
            r13.h()
            r13.i()
            android.database.sqlite.SQLiteDatabase r0 = r13.P()     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            r14 = 2
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            r14[r12] = r3     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            r14[r11] = r15     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            java.lang.String r15 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            android.database.Cursor r14 = r0.rawQuery(r15, r14)     // Catch:{ SQLiteException -> 0x00ee, all -> 0x00ea }
            boolean r0 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x00e8 }
            if (r0 != 0) goto L_0x00ac
            com.google.android.gms.measurement.internal.x4 r0 = r13.f2527a     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()     // Catch:{ SQLiteException -> 0x00e8 }
            java.lang.String r15 = "Main event not found"
            r0.a(r15)     // Catch:{ SQLiteException -> 0x00e8 }
            if (r14 == 0) goto L_0x00aa
            r14.close()
        L_0x00aa:
            r0 = r5
            goto L_0x0105
        L_0x00ac:
            byte[] r0 = r14.getBlob(r12)     // Catch:{ SQLiteException -> 0x00e8 }
            long r15 = r14.getLong(r11)     // Catch:{ SQLiteException -> 0x00e8 }
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x00e8 }
            c.d.a.b.e.e.f4 r5 = c.d.a.b.e.e.g4.I()     // Catch:{ IOException -> 0x00d1 }
            com.google.android.gms.measurement.internal.ea.C(r5, r0)     // Catch:{ IOException -> 0x00d1 }
            c.d.a.b.e.e.f4 r5 = (c.d.a.b.e.e.f4) r5     // Catch:{ IOException -> 0x00d1 }
            c.d.a.b.e.e.s8 r0 = r5.n()     // Catch:{ IOException -> 0x00d1 }
            c.d.a.b.e.e.g4 r0 = (c.d.a.b.e.e.g4) r0     // Catch:{ IOException -> 0x00d1 }
            android.util.Pair r0 = android.util.Pair.create(r0, r15)     // Catch:{ SQLiteException -> 0x00e8 }
            if (r14 == 0) goto L_0x0105
            r14.close()
            goto L_0x0105
        L_0x00d1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r5 = r13.f2527a     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ SQLiteException -> 0x00e8 }
            java.lang.String r15 = "Failed to merge main event. appId, eventId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.m3.z(r18)     // Catch:{ SQLiteException -> 0x00e8 }
            r5.d(r15, r12, r4, r0)     // Catch:{ SQLiteException -> 0x00e8 }
            if (r14 == 0) goto L_0x0104
            goto L_0x0101
        L_0x00e8:
            r0 = move-exception
            goto L_0x00f0
        L_0x00ea:
            r0 = move-exception
            r5 = 0
            goto L_0x01e5
        L_0x00ee:
            r0 = move-exception
            r14 = 0
        L_0x00f0:
            com.google.android.gms.measurement.internal.x4 r5 = r13.f2527a     // Catch:{ all -> 0x01e3 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x01e3 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x01e3 }
            java.lang.String r12 = "Error selecting main event"
            r5.b(r12, r0)     // Catch:{ all -> 0x01e3 }
            if (r14 == 0) goto L_0x0104
        L_0x0101:
            r14.close()
        L_0x0104:
            r0 = 0
        L_0x0105:
            if (r0 == 0) goto L_0x01d0
            java.lang.Object r5 = r0.first
            if (r5 != 0) goto L_0x010d
            goto L_0x01d0
        L_0x010d:
            c.d.a.b.e.e.g4 r5 = (c.d.a.b.e.e.g4) r5
            r1.f2609a = r5
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r12 = r0.longValue()
            r1.f2611c = r12
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b
            r0.f0()
            c.d.a.b.e.e.g4 r0 = r1.f2609a
            java.lang.Object r0 = com.google.android.gms.measurement.internal.ea.o(r0, r2)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.f2610b = r0
        L_0x012c:
            long r12 = r1.f2611c
            r14 = -1
            long r12 = r12 + r14
            r1.f2611c = r12
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0171
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b
            com.google.android.gms.measurement.internal.n r2 = r0.V()
            r2.h()
            com.google.android.gms.measurement.internal.x4 r0 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r0.b(r4, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch:{ SQLiteException -> 0x0160 }
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0160 }
            r5 = 0
            r4[r5] = r3     // Catch:{ SQLiteException -> 0x0160 }
            java.lang.String r3 = "delete from main_event_params where app_id=?"
            r0.execSQL(r3, r4)     // Catch:{ SQLiteException -> 0x0160 }
            goto L_0x0182
        L_0x0160:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()
            java.lang.String r3 = "Error clearing complex main event"
            r2.b(r3, r0)
            goto L_0x0182
        L_0x0171:
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b
            com.google.android.gms.measurement.internal.n r2 = r0.V()
            long r5 = r1.f2611c
            c.d.a.b.e.e.g4 r7 = r1.f2609a
            r3 = r18
            r2.v(r3, r4, r5, r7)
        L_0x0182:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            c.d.a.b.e.e.g4 r2 = r1.f2609a
            java.util.List r2 = r2.M()
            java.util.Iterator r2 = r2.iterator()
        L_0x0191:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01b2
            java.lang.Object r3 = r2.next()
            c.d.a.b.e.e.k4 r3 = (c.d.a.b.e.e.k4) r3
            com.google.android.gms.measurement.internal.b r4 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r4 = r4.f2504b
            r4.f0()
            java.lang.String r4 = r3.K()
            c.d.a.b.e.e.k4 r4 = com.google.android.gms.measurement.internal.ea.n(r8, r4)
            if (r4 != 0) goto L_0x0191
            r0.add(r3)
            goto L_0x0191
        L_0x01b2:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x01bd
            r0.addAll(r9)
            r9 = r0
            goto L_0x01ce
        L_0x01bd:
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.t()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.b(r2, r10)
        L_0x01ce:
            r0 = r10
            goto L_0x0237
        L_0x01d0:
            com.google.android.gms.measurement.internal.b r0 = r1.f2612d
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.t()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.c(r2, r10, r4)
            r2 = 0
            return r2
        L_0x01e3:
            r0 = move-exception
            r5 = r14
        L_0x01e5:
            if (r5 == 0) goto L_0x01ea
            r5.close()
        L_0x01ea:
            throw r0
        L_0x01eb:
            r1.f2610b = r4
            r1.f2609a = r8
            com.google.android.gms.measurement.internal.b r2 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r2 = r2.f2504b
            r2.f0()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r5 = "_epc"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.ea.o(r8, r5)
            if (r5 == 0) goto L_0x0203
            r2 = r5
        L_0x0203:
            java.lang.Long r2 = (java.lang.Long) r2
            long r10 = r2.longValue()
            r1.f2611c = r10
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0221
            com.google.android.gms.measurement.internal.b r2 = r1.f2612d
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.t()
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.b(r3, r0)
            goto L_0x0237
        L_0x0221:
            com.google.android.gms.measurement.internal.b r2 = r1.f2612d
            com.google.android.gms.measurement.internal.ca r2 = r2.f2504b
            com.google.android.gms.measurement.internal.n r2 = r2.V()
            com.google.android.gms.common.internal.n.i(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r5 = r1.f2611c
            r3 = r18
            r7 = r19
            r2.v(r3, r4, r5, r7)
        L_0x0237:
            c.d.a.b.e.e.p8 r2 = r19.B()
            c.d.a.b.e.e.f4 r2 = (c.d.a.b.e.e.f4) r2
            r2.A(r0)
            r2.y()
            r2.v(r9)
            c.d.a.b.e.e.s8 r0 = r2.n()
            c.d.a.b.e.e.g4 r0 = (c.d.a.b.e.e.g4) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.wa.a(java.lang.String, c.d.a.b.e.e.g4):c.d.a.b.e.e.g4");
    }
}
