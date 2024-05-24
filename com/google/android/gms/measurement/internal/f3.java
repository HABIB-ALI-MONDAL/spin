package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

public final class f3 extends f4 {

    /* renamed from: c  reason: collision with root package name */
    private final d3 f2377c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2378d;

    f3(x4 x4Var) {
        super(x4Var);
        Context d2 = this.f2527a.d();
        this.f2527a.z();
        this.f2377c = new d3(this, d2, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A[SYNTHETIC, Splitter:B:47:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean x(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.h()
            boolean r0 = r1.f2378d
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a
            r0.z()
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0028:
            if (r5 >= r4) goto L_0x012d
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.o()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00c2, all -> 0x00bf }
            if (r9 != 0) goto L_0x0035
            r1.f2378d = r7     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b7 }
            r11 = 0
            if (r10 == 0) goto L_0x0054
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0054
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            goto L_0x0121
        L_0x0050:
            r0 = move-exception
            goto L_0x00b9
        L_0x0052:
            r0 = move-exception
            goto L_0x00bd
        L_0x0054:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x009f
            com.google.android.gms.measurement.internal.x4 r15 = r1.f2527a     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.m3 r15 = r15.f()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.k3 r15 = r15.r()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r15.a(r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            r11 = 1
            long r13 = r13 + r11
            java.lang.String[] r4 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            int r4 = r9.delete(r0, r11, r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r11 = (long) r4     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x009f
            com.google.android.gms.measurement.internal.x4 r4 = r1.f2527a     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4.d(r15, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009f:
            r9.insertOrThrow(r0, r8, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            r9.close()
            r2 = 1
            return r2
        L_0x00b2:
            r8 = r10
            goto L_0x00ea
        L_0x00b4:
            r0 = move-exception
            goto L_0x0122
        L_0x00b7:
            r0 = move-exception
            r10 = r8
        L_0x00b9:
            r8 = r9
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            r10 = r8
        L_0x00bd:
            r8 = r9
            goto L_0x00fd
        L_0x00bf:
            r0 = move-exception
            r9 = r8
            goto L_0x0122
        L_0x00c2:
            r0 = move-exception
            r10 = r8
        L_0x00c4:
            if (r8 == 0) goto L_0x00cf
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x00cf
            r8.endTransaction()     // Catch:{ all -> 0x011f }
        L_0x00cf:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry to local database"
            r2.b(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.f2378d = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x00e6
            r10.close()
        L_0x00e6:
            if (r8 == 0) goto L_0x0119
            goto L_0x0116
        L_0x00e9:
            r9 = r8
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b4 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x00f5
            r8.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0119
            r9.close()
            goto L_0x0119
        L_0x00fb:
            r0 = move-exception
            r10 = r8
        L_0x00fd:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.b(r4, r0)     // Catch:{ all -> 0x011f }
            r2 = 1
            r1.f2378d = r2     // Catch:{ all -> 0x011f }
            if (r10 == 0) goto L_0x0114
            r10.close()
        L_0x0114:
            if (r8 == 0) goto L_0x0119
        L_0x0116:
            r8.close()
        L_0x0119:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x011f:
            r0 = move-exception
            r9 = r8
        L_0x0121:
            r8 = r10
        L_0x0122:
            if (r8 == 0) goto L_0x0127
            r8.close()
        L_0x0127:
            if (r9 == 0) goto L_0x012c
            r9.close()
        L_0x012c:
            throw r0
        L_0x012d:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.a(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f3.x(int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase o() {
        if (this.f2378d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f2377c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f2378d = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:70|71|72|73) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:85|86|87|88) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:57|58|59|60|203) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r1.f2527a.f().r().a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r1.f2527a.f().r().a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r1.f2527a.f().r().a("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00da */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x010c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0141 */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01d6 A[SYNTHETIC, Splitter:B:129:0x01d6] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01fb A[SYNTHETIC, Splitter:B:157:0x01fb] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x01d9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0248 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0248 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0248 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List p(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "rowid"
            java.lang.String r3 = "Error reading entries from local database"
            r22.h()
            boolean r0 = r1.f2378d
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r22.s()
            if (r0 == 0) goto L_0x0269
            r6 = 5
            r7 = 0
            r8 = 0
            r9 = 5
        L_0x001e:
            if (r8 >= r6) goto L_0x0259
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.o()     // Catch:{ SQLiteFullException -> 0x022e, SQLiteDatabaseLockedException -> 0x021b, SQLiteException -> 0x01f6, all -> 0x01f3 }
            if (r15 != 0) goto L_0x002a
            r1.f2378d = r10     // Catch:{ SQLiteFullException -> 0x01ee, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01e0 }
            return r4
        L_0x002a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01ee, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01e0 }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[]{r2}     // Catch:{ all -> 0x01d1 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01d1 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r11 = r15
            r23 = r15
            r15 = r0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01cd }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x01c9 }
            r20 = -1
            if (r0 == 0) goto L_0x005d
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x01c9 }
            if (r11 == 0) goto L_0x0078
            r11.close()     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            goto L_0x0078
        L_0x005d:
            if (r11 == 0) goto L_0x0076
            r11.close()     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            goto L_0x0076
        L_0x0063:
            r0 = move-exception
            r14 = r23
            goto L_0x01e2
        L_0x0068:
            r0 = move-exception
            r14 = r23
            goto L_0x01e7
        L_0x006d:
            r14 = r23
            goto L_0x01eb
        L_0x0071:
            r0 = move-exception
            r14 = r23
            goto L_0x01f0
        L_0x0076:
            r12 = r20
        L_0x0078:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            r14 = r0
            r15 = r11
            goto L_0x008b
        L_0x0089:
            r14 = r4
            r15 = r14
        L_0x008b:
            java.lang.String r0 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r13 = new java.lang.String[]{r2, r0, r11}     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            java.lang.String r12 = "messages"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r0 = 100
            java.lang.String r19 = java.lang.Integer.toString(r0)     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
            r11 = r23
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x006d, SQLiteException -> 0x0068, all -> 0x0063 }
        L_0x00a7:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r0 == 0) goto L_0x017d
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r0 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r12 = 2
            byte[] r13 = r11.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r0 != 0) goto L_0x00f1
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r0 = r13.length     // Catch:{ a -> 0x00da }
            r12.unmarshall(r13, r7, r0)     // Catch:{ a -> 0x00da }
            r12.setDataPosition(r7)     // Catch:{ a -> 0x00da }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.x> r0 = com.google.android.gms.measurement.internal.x.CREATOR     // Catch:{ a -> 0x00da }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x00da }
            com.google.android.gms.measurement.internal.x r0 = (com.google.android.gms.measurement.internal.x) r0     // Catch:{ a -> 0x00da }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            if (r0 == 0) goto L_0x00a7
        L_0x00d4:
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a7
        L_0x00d8:
            r0 = move-exception
            goto L_0x00ed
        L_0x00da:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x00d8 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x00d8 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = "Failed to load event from local database"
            r0.a(r13)     // Catch:{ all -> 0x00d8 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a7
        L_0x00ed:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x00f1:
            if (r0 != r10) goto L_0x0126
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r0 = r13.length     // Catch:{ a -> 0x010c }
            r12.unmarshall(r13, r7, r0)     // Catch:{ a -> 0x010c }
            r12.setDataPosition(r7)     // Catch:{ a -> 0x010c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.fa> r0 = com.google.android.gms.measurement.internal.fa.CREATOR     // Catch:{ a -> 0x010c }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x010c }
            com.google.android.gms.measurement.internal.fa r0 = (com.google.android.gms.measurement.internal.fa) r0     // Catch:{ a -> 0x010c }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x011f
        L_0x010a:
            r0 = move-exception
            goto L_0x0122
        L_0x010c:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x010a }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x010a }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x010a }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.a(r13)     // Catch:{ all -> 0x010a }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r0 = r4
        L_0x011f:
            if (r0 == 0) goto L_0x00a7
            goto L_0x00d4
        L_0x0122:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x0126:
            if (r0 != r12) goto L_0x015c
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            int r0 = r13.length     // Catch:{ a -> 0x0141 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ a -> 0x0141 }
            r12.setDataPosition(r7)     // Catch:{ a -> 0x0141 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.d> r0 = com.google.android.gms.measurement.internal.d.CREATOR     // Catch:{ a -> 0x0141 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x0141 }
            com.google.android.gms.measurement.internal.d r0 = (com.google.android.gms.measurement.internal.d) r0     // Catch:{ a -> 0x0141 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x0154
        L_0x013f:
            r0 = move-exception
            goto L_0x0158
        L_0x0141:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x013f }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x013f }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x013f }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r0.a(r13)     // Catch:{ all -> 0x013f }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r0 = r4
        L_0x0154:
            if (r0 == 0) goto L_0x00a7
            goto L_0x00d4
        L_0x0158:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            throw r0     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
        L_0x015c:
            r12 = 3
            if (r0 != r12) goto L_0x0170
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r12 = "Skipping app launch break"
        L_0x016b:
            r0.a(r12)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            goto L_0x00a7
        L_0x0170:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r12 = "Unknown record type in local database"
            goto L_0x016b
        L_0x017d:
            java.lang.String[] r0 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r12 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            r0[r7] = r12     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01b9 }
            java.lang.String r12 = "messages"
            java.lang.String r13 = "rowid <= ?"
            r14 = r23
            int r0 = r14.delete(r12, r13, r0)     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            int r12 = r5.size()     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            if (r0 >= r12) goto L_0x01a4
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            java.lang.String r12 = "Fewer entries removed from local database than expected"
            r0.a(r12)     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
        L_0x01a4:
            r14.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            r14.endTransaction()     // Catch:{ SQLiteFullException -> 0x01b7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01b5, all -> 0x01b3 }
            if (r11 == 0) goto L_0x01af
            r11.close()
        L_0x01af:
            r14.close()
            return r5
        L_0x01b3:
            r0 = move-exception
            goto L_0x01bc
        L_0x01b5:
            r0 = move-exception
            goto L_0x01e8
        L_0x01b7:
            r0 = move-exception
            goto L_0x01f1
        L_0x01b9:
            r0 = move-exception
            r14 = r23
        L_0x01bc:
            r4 = r11
            goto L_0x01e2
        L_0x01be:
            r0 = move-exception
            r14 = r23
            goto L_0x01e8
        L_0x01c2:
            r14 = r23
            goto L_0x01ec
        L_0x01c5:
            r0 = move-exception
            r14 = r23
            goto L_0x01f1
        L_0x01c9:
            r0 = move-exception
            r14 = r23
            goto L_0x01d4
        L_0x01cd:
            r0 = move-exception
            r14 = r23
            goto L_0x01d3
        L_0x01d1:
            r0 = move-exception
            r14 = r15
        L_0x01d3:
            r11 = r4
        L_0x01d4:
            if (r11 == 0) goto L_0x01d9
            r11.close()     // Catch:{ SQLiteFullException -> 0x01de, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01dc, all -> 0x01da }
        L_0x01d9:
            throw r0     // Catch:{ SQLiteFullException -> 0x01de, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01dc, all -> 0x01da }
        L_0x01da:
            r0 = move-exception
            goto L_0x01e2
        L_0x01dc:
            r0 = move-exception
            goto L_0x01e7
        L_0x01de:
            r0 = move-exception
            goto L_0x01f0
        L_0x01e0:
            r0 = move-exception
            r14 = r15
        L_0x01e2:
            r15 = r14
            goto L_0x024e
        L_0x01e5:
            r0 = move-exception
            r14 = r15
        L_0x01e7:
            r11 = r4
        L_0x01e8:
            r15 = r14
            goto L_0x01f9
        L_0x01ea:
            r14 = r15
        L_0x01eb:
            r11 = r4
        L_0x01ec:
            r15 = r14
            goto L_0x021d
        L_0x01ee:
            r0 = move-exception
            r14 = r15
        L_0x01f0:
            r11 = r4
        L_0x01f1:
            r15 = r14
            goto L_0x0231
        L_0x01f3:
            r0 = move-exception
            r15 = r4
            goto L_0x024e
        L_0x01f6:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x01f9:
            if (r15 == 0) goto L_0x0204
            boolean r12 = r15.inTransaction()     // Catch:{ all -> 0x024c }
            if (r12 == 0) goto L_0x0204
            r15.endTransaction()     // Catch:{ all -> 0x024c }
        L_0x0204:
            com.google.android.gms.measurement.internal.x4 r12 = r1.f2527a     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.m3 r12 = r12.f()     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.k3 r12 = r12.r()     // Catch:{ all -> 0x024c }
            r12.b(r3, r0)     // Catch:{ all -> 0x024c }
            r1.f2378d = r10     // Catch:{ all -> 0x024c }
            if (r11 == 0) goto L_0x0218
            r11.close()
        L_0x0218:
            if (r15 == 0) goto L_0x0248
            goto L_0x022a
        L_0x021b:
            r11 = r4
            r15 = r11
        L_0x021d:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x024c }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x0228
            r11.close()
        L_0x0228:
            if (r15 == 0) goto L_0x0248
        L_0x022a:
            r15.close()
            goto L_0x0248
        L_0x022e:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0231:
            com.google.android.gms.measurement.internal.x4 r12 = r1.f2527a     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.m3 r12 = r12.f()     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.k3 r12 = r12.r()     // Catch:{ all -> 0x024c }
            r12.b(r3, r0)     // Catch:{ all -> 0x024c }
            r1.f2378d = r10     // Catch:{ all -> 0x024c }
            if (r11 == 0) goto L_0x0245
            r11.close()
        L_0x0245:
            if (r15 == 0) goto L_0x0248
            goto L_0x022a
        L_0x0248:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x024c:
            r0 = move-exception
            r4 = r11
        L_0x024e:
            if (r4 == 0) goto L_0x0253
            r4.close()
        L_0x0253:
            if (r15 == 0) goto L_0x0258
            r15.close()
        L_0x0258:
            throw r0
        L_0x0259:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.a(r2)
            return r4
        L_0x0269:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f3.p(int):java.util.List");
    }

    public final void q() {
        int delete;
        h();
        try {
            SQLiteDatabase o = o();
            if (o != null && (delete = o.delete("messages", (String) null, (String[]) null)) > 0) {
                this.f2527a.f().v().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            this.f2527a.f().r().b("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean r() {
        return x(3, new byte[0]);
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        Context d2 = this.f2527a.d();
        this.f2527a.z();
        return d2.getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final boolean t() {
        h();
        if (!this.f2378d && s()) {
            int i = 0;
            int i2 = 5;
            while (i < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase o = o();
                    if (o == null) {
                        this.f2378d = true;
                        return false;
                    }
                    o.beginTransaction();
                    o.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    o.setTransactionSuccessful();
                    o.endTransaction();
                    o.close();
                    return true;
                } catch (SQLiteFullException e2) {
                    this.f2527a.f().r().b("Error deleting app launch break from local database", e2);
                    this.f2378d = true;
                    if (sQLiteDatabase == null) {
                        i++;
                    }
                    sQLiteDatabase.close();
                    i++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i2);
                    i2 += 20;
                    if (sQLiteDatabase == null) {
                        i++;
                    }
                    sQLiteDatabase.close();
                    i++;
                } catch (SQLiteException e3) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.f2527a.f().r().b("Error deleting app launch break from local database", e3);
                    this.f2378d = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i++;
                    } else {
                        i++;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            this.f2527a.f().w().a("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean u(d dVar) {
        byte[] c0 = this.f2527a.N().c0(dVar);
        if (c0.length <= 131072) {
            return x(2, c0);
        }
        this.f2527a.f().t().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean v(x xVar) {
        Parcel obtain = Parcel.obtain();
        y.a(xVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return x(0, marshall);
        }
        this.f2527a.f().t().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean w(fa faVar) {
        Parcel obtain = Parcel.obtain();
        ga.a(faVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return x(1, marshall);
        }
        this.f2527a.f().t().a("User property too long for local database. Sending directly to service");
        return false;
    }
}
