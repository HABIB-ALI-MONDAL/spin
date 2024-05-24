package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import c.d.a.b.e.e.g4;
import c.d.a.b.e.e.gc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class n extends q9 {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f2474f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d  reason: collision with root package name */
    private final m f2475d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final m9 f2476e = new m9(this.f2527a.a());

    n(ca caVar) {
        super(caVar);
        this.f2527a.z();
        this.f2475d = new m(this, this.f2527a.d(), "google_app_measurement.db");
    }

    static final void H(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.n.e("value");
        com.google.android.gms.common.internal.n.i(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long I(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = P().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long K(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = P().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j3;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j2;
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0040=Splitter:B:13:0x0040, B:31:0x008e=Splitter:B:31:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.z9 r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.n.i(r26)
            r20.h()
            r20.i()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.P()     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r5 = ""
            r13 = -1
            r15 = 2
            r12 = 1
            r11 = 0
            if (r4 == 0) goto L_0x0075
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r4 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r4[r11] = r6     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r6 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r4[r12] = r6     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r4 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r6 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r4[r11] = r6     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
        L_0x003a:
            int r6 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0040
            java.lang.String r5 = "rowid <= ? and "
        L_0x0040:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r5 = r6.toString()     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            android.database.Cursor r4 = r0.rawQuery(r5, r4)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r5 != 0) goto L_0x0066
            if (r4 == 0) goto L_0x0065
            r4.close()
        L_0x0065:
            return
        L_0x0066:
            java.lang.String r3 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0072 }
            r4.close()     // Catch:{ SQLiteException -> 0x0072 }
            goto L_0x00bb
        L_0x0072:
            r0 = move-exception
            goto L_0x021b
        L_0x0075:
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0084
            java.lang.String[] r4 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r4[r11] = r3     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r4[r12] = r6     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            goto L_0x0088
        L_0x0084:
            java.lang.String[] r4 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
        L_0x0088:
            int r6 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x008e
            java.lang.String r5 = " and rowid <= ?"
        L_0x008e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r5 = " order by rowid limit 1;"
            r6.append(r5)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            java.lang.String r5 = r6.toString()     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            android.database.Cursor r4 = r0.rawQuery(r5, r4)     // Catch:{ SQLiteException -> 0x0219, all -> 0x0217 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r5 != 0) goto L_0x00b4
            if (r4 == 0) goto L_0x00b3
            r4.close()
        L_0x00b3:
            return
        L_0x00b4:
            java.lang.String r5 = r4.getString(r11)     // Catch:{ SQLiteException -> 0x0072 }
            r4.close()     // Catch:{ SQLiteException -> 0x0072 }
        L_0x00bb:
            r16 = r4
            r17 = r5
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0213, all -> 0x020f }
            java.lang.String[] r8 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0213, all -> 0x020f }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x0213, all -> 0x020f }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0213, all -> 0x020f }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r9 = 0
            r10 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r15 = 0
            r11 = r18
            r12 = r19
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0213, all -> 0x020f }
            boolean r4 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            if (r4 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r0.b(r2, r4)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            if (r12 == 0) goto L_0x00fd
            r12.close()
        L_0x00fd:
            return
        L_0x00fe:
            byte[] r4 = r12.getBlob(r15)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            c.d.a.b.e.e.q4 r5 = c.d.a.b.e.e.r4.N1()     // Catch:{ IOException -> 0x01e8 }
            com.google.android.gms.measurement.internal.ea.C(r5, r4)     // Catch:{ IOException -> 0x01e8 }
            c.d.a.b.e.e.q4 r5 = (c.d.a.b.e.e.q4) r5     // Catch:{ IOException -> 0x01e8 }
            c.d.a.b.e.e.s8 r4 = r5.n()     // Catch:{ IOException -> 0x01e8 }
            c.d.a.b.e.e.r4 r4 = (c.d.a.b.e.e.r4) r4     // Catch:{ IOException -> 0x01e8 }
            boolean r5 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            if (r5 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.w()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r5.b(r6, r7)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
        L_0x012a:
            r12.close()     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            com.google.android.gms.common.internal.n.i(r4)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r2.f2656a = r4     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r11 = 3
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x014a
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r5[r15] = r3     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r13 = 1
            r5[r13] = r17     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r7 = 2
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r7 = r4
            r8 = r5
            goto L_0x0156
        L_0x014a:
            r13 = 1
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            r5 = 2
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r6[r15] = r3     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r6[r13] = r17     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            r7 = r4
            r8 = r6
        L_0x0156:
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r6 = "timestamp"
            java.lang.String r9 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r9}     // Catch:{ SQLiteException -> 0x020b, all -> 0x0207 }
            java.lang.String r5 = "raw_events"
            r9 = 0
            r10 = 0
            java.lang.String r14 = "rowid"
            r16 = 0
            r4 = r0
            r13 = 3
            r11 = r14
            r14 = r12
            r12 = r16
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 == 0) goto L_0x01cf
        L_0x017a:
            long r5 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x0072 }
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0072 }
            c.d.a.b.e.e.f4 r7 = c.d.a.b.e.e.g4.I()     // Catch:{ IOException -> 0x01ad }
            com.google.android.gms.measurement.internal.ea.C(r7, r0)     // Catch:{ IOException -> 0x01ad }
            c.d.a.b.e.e.f4 r7 = (c.d.a.b.e.e.f4) r7     // Catch:{ IOException -> 0x01ad }
            r8 = 1
            java.lang.String r0 = r4.getString(r8)     // Catch:{ SQLiteException -> 0x0072 }
            r7.A(r0)     // Catch:{ SQLiteException -> 0x0072 }
            r9 = 2
            long r10 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x0072 }
            r7.E(r10)     // Catch:{ SQLiteException -> 0x0072 }
            c.d.a.b.e.e.s8 r0 = r7.n()     // Catch:{ SQLiteException -> 0x0072 }
            c.d.a.b.e.e.g4 r0 = (c.d.a.b.e.e.g4) r0     // Catch:{ SQLiteException -> 0x0072 }
            boolean r0 = r2.a(r5, r0)     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 != 0) goto L_0x01c3
            if (r4 == 0) goto L_0x01ac
            r4.close()
        L_0x01ac:
            return
        L_0x01ad:
            r0 = move-exception
            r8 = 1
            r9 = 2
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0072 }
            r5.c(r6, r7, r0)     // Catch:{ SQLiteException -> 0x0072 }
        L_0x01c3:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 != 0) goto L_0x017a
            if (r4 == 0) goto L_0x0233
            r4.close()
            return
        L_0x01cf:
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0072 }
            r0.b(r2, r5)     // Catch:{ SQLiteException -> 0x0072 }
            if (r4 == 0) goto L_0x01e7
            r4.close()
        L_0x01e7:
            return
        L_0x01e8:
            r0 = move-exception
            r14 = r12
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            r2.c(r4, r5, r0)     // Catch:{ SQLiteException -> 0x0205, all -> 0x0203 }
            if (r14 == 0) goto L_0x0202
            r14.close()
        L_0x0202:
            return
        L_0x0203:
            r0 = move-exception
            goto L_0x0209
        L_0x0205:
            r0 = move-exception
            goto L_0x020d
        L_0x0207:
            r0 = move-exception
            r14 = r12
        L_0x0209:
            r3 = r14
            goto L_0x0236
        L_0x020b:
            r0 = move-exception
            r14 = r12
        L_0x020d:
            r4 = r14
            goto L_0x021b
        L_0x020f:
            r0 = move-exception
            r3 = r16
            goto L_0x0236
        L_0x0213:
            r0 = move-exception
            r4 = r16
            goto L_0x021b
        L_0x0217:
            r0 = move-exception
            goto L_0x0236
        L_0x0219:
            r0 = move-exception
            r4 = r3
        L_0x021b:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x0234 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0234 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x0234 }
            r2.c(r5, r3, r0)     // Catch:{ all -> 0x0234 }
            if (r4 == 0) goto L_0x0233
            r4.close()
        L_0x0233:
            return
        L_0x0234:
            r0 = move-exception
            r3 = r4
        L_0x0236:
            if (r3 == 0) goto L_0x023b
            r3.close()
        L_0x023b:
            goto L_0x023d
        L_0x023c:
            throw r0
        L_0x023d:
            goto L_0x023c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.G(java.lang.String, long, long, com.google.android.gms.measurement.internal.z9):void");
    }

    public final int J(String str, String str2) {
        com.google.android.gms.common.internal.n.e(str);
        com.google.android.gms.common.internal.n.e(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.f2527a.f().r().d("Error deleting conditional property", m3.z(str), this.f2527a.D().f(str2), e2);
            return 0;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final long L(String str, String str2) {
        String str3 = str;
        com.google.android.gms.common.internal.n.e(str);
        com.google.android.gms.common.internal.n.e("first_open_count");
        h();
        i();
        SQLiteDatabase P = P();
        P.beginTransaction();
        long j2 = 0;
        try {
            long K = K("select " + "first_open_count" + " from app2 where app_id=?", new String[]{str3}, -1);
            if (K == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (P.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.f2527a.f().r().c("Failed to insert column (got -1). appId", m3.z(str), "first_open_count");
                    P.endTransaction();
                    return -1;
                }
                K = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put("first_open_count", Long.valueOf(1 + K));
                if (((long) P.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    this.f2527a.f().r().c("Failed to update column (got 0). appId", m3.z(str), "first_open_count");
                    P.endTransaction();
                    return -1;
                }
                P.setTransactionSuccessful();
                P.endTransaction();
                return K;
            } catch (SQLiteException e2) {
                e = e2;
                j2 = K;
                try {
                    this.f2527a.f().r().d("Error inserting column. appId", m3.z(str), "first_open_count", e);
                    P.endTransaction();
                    return j2;
                } catch (Throwable th) {
                    P.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            this.f2527a.f().r().d("Error inserting column. appId", m3.z(str), "first_open_count", e);
            P.endTransaction();
            return j2;
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long O(String str) {
        com.google.android.gms.common.internal.n.e(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase P() {
        h();
        try {
            return this.f2475d.getWritableDatabase();
        } catch (SQLiteException e2) {
            this.f2527a.f().w().b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle Q(java.lang.String r8) {
        /*
            r7 = this;
            r7.h()
            r7.i()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.P()     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            r3 = 0
            r2[r3] = r8     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00bf }
            if (r2 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.x4 r8 = r7.f2527a     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.m3 r8 = r8.f()     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.k3 r8 = r8.v()     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch:{ SQLiteException -> 0x00bf }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r0
        L_0x0032:
            byte[] r2 = r1.getBlob(r3)     // Catch:{ SQLiteException -> 0x00bf }
            c.d.a.b.e.e.f4 r3 = c.d.a.b.e.e.g4.I()     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.measurement.internal.ea.C(r3, r2)     // Catch:{ IOException -> 0x00a5 }
            c.d.a.b.e.e.f4 r3 = (c.d.a.b.e.e.f4) r3     // Catch:{ IOException -> 0x00a5 }
            c.d.a.b.e.e.s8 r2 = r3.n()     // Catch:{ IOException -> 0x00a5 }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.measurement.internal.ca r8 = r7.f2504b     // Catch:{ SQLiteException -> 0x00bf }
            r8.f0()     // Catch:{ SQLiteException -> 0x00bf }
            java.util.List r8 = r2.M()     // Catch:{ SQLiteException -> 0x00bf }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00bf }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00bf }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00bf }
        L_0x0057:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00bf }
            if (r3 == 0) goto L_0x009f
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00bf }
            c.d.a.b.e.e.k4 r3 = (c.d.a.b.e.e.k4) r3     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r4 = r3.K()     // Catch:{ SQLiteException -> 0x00bf }
            boolean r5 = r3.X()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0075
            double r5 = r3.E()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0075:
            boolean r5 = r3.Y()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0083
            float r3 = r3.F()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0083:
            boolean r5 = r3.b0()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0091
            java.lang.String r3 = r3.L()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0091:
            boolean r5 = r3.Z()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0057
            long r5 = r3.H()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            return r2
        L_0x00a5:
            r2 = move-exception
            com.google.android.gms.measurement.internal.x4 r3 = r7.f2527a     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r8)     // Catch:{ SQLiteException -> 0x00bf }
            r3.c(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00bf }
            if (r1 == 0) goto L_0x00be
            r1.close()
        L_0x00be:
            return r0
        L_0x00bf:
            r8 = move-exception
            goto L_0x00c5
        L_0x00c1:
            r8 = move-exception
            goto L_0x00dc
        L_0x00c3:
            r8 = move-exception
            r1 = r0
        L_0x00c5:
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a     // Catch:{ all -> 0x00da }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x00da }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x00da }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00d9
            r1.close()
        L_0x00d9:
            return r0
        L_0x00da:
            r8 = move-exception
            r0 = r1
        L_0x00dc:
            if (r0 == 0) goto L_0x00e1
            r0.close()
        L_0x00e1:
            goto L_0x00e3
        L_0x00e2:
            throw r8
        L_0x00e3:
            goto L_0x00e2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.Q(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x011b A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x011f A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0153 A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x016f A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0172 A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0181 A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01c4 A[Catch:{ SQLiteException -> 0x01dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.h6 R(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            com.google.android.gms.common.internal.n.e(r35)
            r34.h()
            r34.i()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r34.P()     // Catch:{ SQLiteException -> 0x01e1, all -> 0x01df }
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String r33 = "session_stitching_token"
            java.lang.String[] r6 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x01e1, all -> 0x01df }
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x01e1, all -> 0x01df }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x01e1, all -> 0x01df }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id=?"
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x01e1, all -> 0x01df }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01dd }
            if (r5 != 0) goto L_0x006d
            if (r4 == 0) goto L_0x006c
            r4.close()
        L_0x006c:
            return r3
        L_0x006d:
            com.google.android.gms.measurement.internal.h6 r5 = new com.google.android.gms.measurement.internal.h6     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.ca r6 = r1.f2504b     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.x4 r6 = r6.b0()     // Catch:{ SQLiteException -> 0x01dd }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x01dd }
            r5.h(r6)     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r5.w(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.F(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.B(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.C(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.z(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.j(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.i(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.x(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.s(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r7 != 0) goto L_0x00d9
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r6 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r6 = 0
            goto L_0x00da
        L_0x00d9:
            r6 = 1
        L_0x00da:
            r5.D(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.r(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.p(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.o(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.m(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.l(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.u(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r7 == 0) goto L_0x011f
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0124
        L_0x011f:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01dd }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x01dd }
        L_0x0124:
            r5.k(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.v(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.n(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.q(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r5.y(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r6 = 23
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r7 != 0) goto L_0x015b
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r6 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r0 = 0
        L_0x015b:
            r5.g(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r0 = 24
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r5.f(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r0 = 25
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x01dd }
            if (r6 == 0) goto L_0x0172
            r6 = 0
            goto L_0x0176
        L_0x0172:
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x01dd }
        L_0x0176:
            r5.t(r6)     // Catch:{ SQLiteException -> 0x01dd }
            r0 = 26
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x01dd }
            if (r6 != 0) goto L_0x0193
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x01dd }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r5.G(r0)     // Catch:{ SQLiteException -> 0x01dd }
        L_0x0193:
            c.d.a.b.e.e.sd.c()     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.h r0 = r0.z()     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.x2 r6 = com.google.android.gms.measurement.internal.y2.i0     // Catch:{ SQLiteException -> 0x01dd }
            boolean r0 = r0.B(r3, r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r0 == 0) goto L_0x01bb
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.h r0 = r0.z()     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.x2 r6 = com.google.android.gms.measurement.internal.y2.k0     // Catch:{ SQLiteException -> 0x01dd }
            boolean r0 = r0.B(r2, r6)     // Catch:{ SQLiteException -> 0x01dd }
            if (r0 == 0) goto L_0x01bb
            r0 = 28
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x01dd }
            r5.H(r0)     // Catch:{ SQLiteException -> 0x01dd }
        L_0x01bb:
            r5.d()     // Catch:{ SQLiteException -> 0x01dd }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x01dd }
            if (r0 == 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x01dd }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r35)     // Catch:{ SQLiteException -> 0x01dd }
            r0.b(r6, r7)     // Catch:{ SQLiteException -> 0x01dd }
        L_0x01d7:
            if (r4 == 0) goto L_0x01dc
            r4.close()
        L_0x01dc:
            return r5
        L_0x01dd:
            r0 = move-exception
            goto L_0x01e3
        L_0x01df:
            r0 = move-exception
            goto L_0x01fe
        L_0x01e1:
            r0 = move-exception
            r4 = r3
        L_0x01e3:
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ all -> 0x01fc }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x01fc }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x01fc }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r35)     // Catch:{ all -> 0x01fc }
            r5.c(r6, r2, r0)     // Catch:{ all -> 0x01fc }
            if (r4 == 0) goto L_0x01fb
            r4.close()
        L_0x01fb:
            return r3
        L_0x01fc:
            r0 = move-exception
            r3 = r4
        L_0x01fe:
            if (r3 == 0) goto L_0x0203
            r3.close()
        L_0x0203:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.R(java.lang.String):com.google.android.gms.measurement.internal.h6");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.d S(java.lang.String r31, java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r8 = r32
            com.google.android.gms.common.internal.n.e(r31)
            com.google.android.gms.common.internal.n.e(r32)
            r30.h()
            r30.i()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r30.P()     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            r2 = 0
            r14[r2] = r31     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            r3 = 1
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r13 = "app_id=? and name=?"
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0101, all -> 0x00ff }
            boolean r4 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00fd }
            if (r4 != 0) goto L_0x0051
            if (r10 == 0) goto L_0x0050
            r10.close()
        L_0x0050:
            return r9
        L_0x0051:
            java.lang.String r4 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x00fd }
            if (r4 != 0) goto L_0x0059
            java.lang.String r4 = ""
        L_0x0059:
            r17 = r4
            java.lang.Object r6 = r1.Y(r10, r3)     // Catch:{ SQLiteException -> 0x00fd }
            int r0 = r10.getInt(r0)     // Catch:{ SQLiteException -> 0x00fd }
            if (r0 == 0) goto L_0x0068
            r21 = 1
            goto L_0x006a
        L_0x0068:
            r21 = 0
        L_0x006a:
            r0 = 3
            java.lang.String r22 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x00fd }
            r0 = 4
            long r24 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ca r0 = r1.f2504b     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ea r0 = r0.f0()     // Catch:{ SQLiteException -> 0x00fd }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fd }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.x> r3 = com.google.android.gms.measurement.internal.x.CREATOR     // Catch:{ SQLiteException -> 0x00fd }
            android.os.Parcelable r0 = r0.z(r2, r3)     // Catch:{ SQLiteException -> 0x00fd }
            r23 = r0
            com.google.android.gms.measurement.internal.x r23 = (com.google.android.gms.measurement.internal.x) r23     // Catch:{ SQLiteException -> 0x00fd }
            r0 = 6
            long r19 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ca r0 = r1.f2504b     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ea r0 = r0.f0()     // Catch:{ SQLiteException -> 0x00fd }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fd }
            android.os.Parcelable r0 = r0.z(r2, r3)     // Catch:{ SQLiteException -> 0x00fd }
            r26 = r0
            com.google.android.gms.measurement.internal.x r26 = (com.google.android.gms.measurement.internal.x) r26     // Catch:{ SQLiteException -> 0x00fd }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fd }
            r0 = 9
            long r27 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ca r0 = r1.f2504b     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.ea r0 = r0.f0()     // Catch:{ SQLiteException -> 0x00fd }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fd }
            android.os.Parcelable r0 = r0.z(r2, r3)     // Catch:{ SQLiteException -> 0x00fd }
            r29 = r0
            com.google.android.gms.measurement.internal.x r29 = (com.google.android.gms.measurement.internal.x) r29     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.fa r18 = new com.google.android.gms.measurement.internal.fa     // Catch:{ SQLiteException -> 0x00fd }
            r2 = r18
            r3 = r32
            r7 = r17
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.d r0 = new com.google.android.gms.measurement.internal.d     // Catch:{ SQLiteException -> 0x00fd }
            r15 = r0
            r16 = r31
            r15.<init>(r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r29)     // Catch:{ SQLiteException -> 0x00fd }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x00fd }
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r31)     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r5 = r5.f(r8)     // Catch:{ SQLiteException -> 0x00fd }
            r2.c(r3, r4, r5)     // Catch:{ SQLiteException -> 0x00fd }
        L_0x00f7:
            if (r10 == 0) goto L_0x00fc
            r10.close()
        L_0x00fc:
            return r0
        L_0x00fd:
            r0 = move-exception
            goto L_0x0103
        L_0x00ff:
            r0 = move-exception
            goto L_0x0128
        L_0x0101:
            r0 = move-exception
            r10 = r9
        L_0x0103:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x0126 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0126 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r31)     // Catch:{ all -> 0x0126 }
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ all -> 0x0126 }
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r5.f(r8)     // Catch:{ all -> 0x0126 }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x0126 }
            if (r10 == 0) goto L_0x0125
            r10.close()
        L_0x0125:
            return r9
        L_0x0126:
            r0 = move-exception
            r9 = r10
        L_0x0128:
            if (r9 == 0) goto L_0x012d
            r9.close()
        L_0x012d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.S(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.d");
    }

    public final l T(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return U(j2, str, 1, false, false, z3, false, z5);
    }

    public final l U(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        com.google.android.gms.common.internal.n.e(str);
        h();
        i();
        String[] strArr = {str};
        l lVar = new l();
        Cursor cursor = null;
        try {
            SQLiteDatabase P = P();
            cursor = P.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.f2527a.f().w().b("Not updating daily counts, app is not known. appId", m3.z(str));
                if (cursor != null) {
                    cursor.close();
                }
                return lVar;
            }
            if (cursor.getLong(0) == j2) {
                lVar.f2439b = cursor.getLong(1);
                lVar.f2438a = cursor.getLong(2);
                lVar.f2440c = cursor.getLong(3);
                lVar.f2441d = cursor.getLong(4);
                lVar.f2442e = cursor.getLong(5);
            }
            if (z) {
                lVar.f2439b += j3;
            }
            if (z2) {
                lVar.f2438a += j3;
            }
            if (z3) {
                lVar.f2440c += j3;
            }
            if (z4) {
                lVar.f2441d += j3;
            }
            if (z5) {
                lVar.f2442e += j3;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j2));
            contentValues.put("daily_public_events_count", Long.valueOf(lVar.f2438a));
            contentValues.put("daily_events_count", Long.valueOf(lVar.f2439b));
            contentValues.put("daily_conversions_count", Long.valueOf(lVar.f2440c));
            contentValues.put("daily_error_events_count", Long.valueOf(lVar.f2441d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(lVar.f2442e));
            P.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return lVar;
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error updating daily counts. appId", m3.z(str), e2);
            if (cursor != null) {
                cursor.close();
            }
            return lVar;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.t V(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r15 = r29
            com.google.android.gms.common.internal.n.e(r28)
            com.google.android.gms.common.internal.n.e(r29)
            r27.h()
            r27.i()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r19 = 0
            android.database.sqlite.SQLiteDatabase r2 = r27.P()     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r10 = 0
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r6[r10] = r28     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r11 = 1
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r3 = "events"
            java.lang.String r5 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r2 != 0) goto L_0x005e
            if (r13 == 0) goto L_0x005d
            r13.close()
        L_0x005d:
            return r19
        L_0x005e:
            long r5 = r13.getLong(r10)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            long r7 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            long r16 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r0 = 3
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r3 = 0
            if (r2 == 0) goto L_0x0076
            r20 = r3
            goto L_0x007a
        L_0x0076:
            long r20 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
        L_0x007a:
            r0 = 4
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r2 == 0) goto L_0x0084
            r0 = r19
            goto L_0x008c
        L_0x0084:
            long r22 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
        L_0x008c:
            r2 = 5
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x0096
            r18 = r19
            goto L_0x00a0
        L_0x0096:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r18 = r2
        L_0x00a0:
            r2 = 6
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x00aa
            r22 = r19
            goto L_0x00b4
        L_0x00aa:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r22 = r2
        L_0x00b4:
            r2 = 7
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 != 0) goto L_0x00cd
            long r23 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r25 = 1
            int r2 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r2 != 0) goto L_0x00c6
            r10 = 1
        L_0x00c6:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r23 = r2
            goto L_0x00cf
        L_0x00cd:
            r23 = r19
        L_0x00cf:
            r2 = 8
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            if (r9 == 0) goto L_0x00d9
            r9 = r3
            goto L_0x00de
        L_0x00d9:
            long r2 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r9 = r2
        L_0x00de:
            com.google.android.gms.measurement.internal.t r24 = new com.google.android.gms.measurement.internal.t     // Catch:{ SQLiteException -> 0x011f, all -> 0x0119 }
            r2 = r24
            r3 = r28
            r4 = r29
            r11 = r16
            r25 = r13
            r13 = r20
            r15 = r0
            r16 = r18
            r17 = r22
            r18 = r23
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            boolean r0 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r28)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            r0.b(r2, r3)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
        L_0x010f:
            if (r25 == 0) goto L_0x0114
            r25.close()
        L_0x0114:
            return r24
        L_0x0115:
            r0 = move-exception
            goto L_0x011c
        L_0x0117:
            r0 = move-exception
            goto L_0x0122
        L_0x0119:
            r0 = move-exception
            r25 = r13
        L_0x011c:
            r19 = r25
            goto L_0x0152
        L_0x011f:
            r0 = move-exception
            r25 = r13
        L_0x0122:
            r13 = r25
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            goto L_0x0152
        L_0x0127:
            r0 = move-exception
            r13 = r19
        L_0x012a:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x014f }
            java.lang.String r3 = "Error querying events. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r28)     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ all -> 0x014f }
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()     // Catch:{ all -> 0x014f }
            r6 = r29
            java.lang.String r5 = r5.d(r6)     // Catch:{ all -> 0x014f }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x014f }
            if (r13 == 0) goto L_0x014e
            r13.close()
        L_0x014e:
            return r19
        L_0x014f:
            r0 = move-exception
            r19 = r13
        L_0x0152:
            if (r19 == 0) goto L_0x0157
            r19.close()
        L_0x0157:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.V(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.t");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.ha X(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.n.e(r20)
            com.google.android.gms.common.internal.n.e(r21)
            r19.h()
            r19.i()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.P()     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r2 = 0
            r15[r2] = r20     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r3 = 1
            r15[r3] = r9     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            boolean r4 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x007f }
            if (r4 != 0) goto L_0x0042
            if (r11 == 0) goto L_0x0041
            r11.close()
        L_0x0041:
            return r10
        L_0x0042:
            long r6 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x007f }
            java.lang.Object r8 = r1.Y(r11, r3)     // Catch:{ SQLiteException -> 0x007f }
            if (r8 != 0) goto L_0x0052
            if (r11 == 0) goto L_0x0051
            r11.close()
        L_0x0051:
            return r10
        L_0x0052:
            java.lang.String r4 = r11.getString(r0)     // Catch:{ SQLiteException -> 0x007f }
            com.google.android.gms.measurement.internal.ha r0 = new com.google.android.gms.measurement.internal.ha     // Catch:{ SQLiteException -> 0x007f }
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x007f }
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x007f }
            if (r2 == 0) goto L_0x0079
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ SQLiteException -> 0x007f }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ SQLiteException -> 0x007f }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x007f }
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r20)     // Catch:{ SQLiteException -> 0x007f }
            r2.b(r3, r4)     // Catch:{ SQLiteException -> 0x007f }
        L_0x0079:
            if (r11 == 0) goto L_0x007e
            r11.close()
        L_0x007e:
            return r0
        L_0x007f:
            r0 = move-exception
            goto L_0x0085
        L_0x0081:
            r0 = move-exception
            goto L_0x00aa
        L_0x0083:
            r0 = move-exception
            r11 = r10
        L_0x0085:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r20)     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r5.f(r9)     // Catch:{ all -> 0x00a8 }
            r2.d(r3, r4, r5, r0)     // Catch:{ all -> 0x00a8 }
            if (r11 == 0) goto L_0x00a7
            r11.close()
        L_0x00a7:
            return r10
        L_0x00a8:
            r0 = move-exception
            r10 = r11
        L_0x00aa:
            if (r10 == 0) goto L_0x00af
            r10.close()
        L_0x00af:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.X(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.ha");
    }

    /* access modifiers changed from: package-private */
    public final Object Y(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            this.f2527a.f().r().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i2));
            }
            if (type == 3) {
                return cursor.getString(i2);
            }
            if (type != 4) {
                this.f2527a.f().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.f2527a.f().r().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String Z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.P()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            goto L_0x0042
        L_0x0026:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0029:
            com.google.android.gms.measurement.internal.x4 r3 = r6.f2527a     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()
        L_0x0047:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.Z():java.lang.String");
    }

    public final List a0(String str, String str2, String str3) {
        com.google.android.gms.common.internal.n.e(str);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return b0(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List b0(String str, String[] strArr) {
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.f2527a.z();
            Cursor query = P().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.f2527a.z();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object Y = Y(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j2 = query.getLong(6);
                        ea f0 = this.f2504b.f0();
                        byte[] blob = query.getBlob(7);
                        Parcelable.Creator<x> creator = x.CREATOR;
                        arrayList.add(new d(string, string2, new fa(string3, query.getLong(10), Y, string2), query.getLong(8), z, string4, (x) f0.z(blob, creator), j2, (x) this.f2504b.f0().z(query.getBlob(9), creator), query.getLong(11), (x) this.f2504b.f0().z(query.getBlob(12), creator)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        k3 r = this.f2527a.f().r();
                        this.f2527a.z();
                        r.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            this.f2527a.f().r().b("Error querying conditional user property value", e2);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List c0(String str) {
        com.google.android.gms.common.internal.n.e(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.f2527a.z();
            Cursor query = P().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j2 = query.getLong(2);
                    Object Y = Y(query, 3);
                    if (Y == null) {
                        this.f2527a.f().r().b("Read invalid user property value, ignoring it. appId", m3.z(str));
                    } else {
                        arrayList.add(new ha(str, str2, string, j2, Y));
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error querying user properties. appId", m3.z(str), e2);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0128 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List d0(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            com.google.android.gms.common.internal.n.e(r18)
            r17.h()
            r17.i()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            r12 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x010a }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x010a }
            r14 = r18
            r3.add(r14)     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x0108 }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x0108 }
            if (r5 != 0) goto L_0x0038
            r15 = r19
            r3.add(r15)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0104 }
            goto L_0x003a
        L_0x0038:
            r15 = r19
        L_0x003a:
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x0104 }
            if (r5 != 0) goto L_0x0059
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0104 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0104 }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0104 }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x0104 }
        L_0x0059:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x0104 }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x0104 }
            android.database.sqlite.SQLiteDatabase r3 = r17.P()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r5 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.x4 r4 = r1.f2527a     // Catch:{ SQLiteException -> 0x0104 }
            r4.z()     // Catch:{ SQLiteException -> 0x0104 }
            r9 = 0
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r16
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0104 }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0104 }
            if (r3 != 0) goto L_0x009c
            if (r12 == 0) goto L_0x009b
            r12.close()
        L_0x009b:
            return r2
        L_0x009c:
            int r3 = r2.size()     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.x4 r4 = r1.f2527a     // Catch:{ SQLiteException -> 0x0104 }
            r4.z()     // Catch:{ SQLiteException -> 0x0104 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00c2
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.x4 r5 = r1.f2527a     // Catch:{ SQLiteException -> 0x0104 }
            r5.z()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0104 }
            r0.b(r3, r4)     // Catch:{ SQLiteException -> 0x0104 }
            goto L_0x00fe
        L_0x00c2:
            r3 = 0
            java.lang.String r7 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x0104 }
            r3 = 1
            long r8 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x0104 }
            r3 = 2
            java.lang.Object r10 = r1.Y(r12, r3)     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r15 = r12.getString(r13)     // Catch:{ SQLiteException -> 0x0104 }
            if (r10 != 0) goto L_0x00eb
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ SQLiteException -> 0x0104 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x0104 }
            java.lang.String r4 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r18)     // Catch:{ SQLiteException -> 0x0104 }
            r3.d(r4, r5, r15, r0)     // Catch:{ SQLiteException -> 0x0104 }
            goto L_0x00f7
        L_0x00eb:
            com.google.android.gms.measurement.internal.ha r3 = new com.google.android.gms.measurement.internal.ha     // Catch:{ SQLiteException -> 0x0104 }
            r4 = r3
            r5 = r18
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0104 }
            r2.add(r3)     // Catch:{ SQLiteException -> 0x0104 }
        L_0x00f7:
            boolean r3 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0104 }
            if (r3 == 0) goto L_0x00fe
            goto L_0x009c
        L_0x00fe:
            if (r12 == 0) goto L_0x0103
            r12.close()
        L_0x0103:
            return r2
        L_0x0104:
            r0 = move-exception
            goto L_0x010f
        L_0x0106:
            r0 = move-exception
            goto L_0x012c
        L_0x0108:
            r0 = move-exception
            goto L_0x010d
        L_0x010a:
            r0 = move-exception
            r14 = r18
        L_0x010d:
            r15 = r19
        L_0x010f:
            com.google.android.gms.measurement.internal.x4 r2 = r1.f2527a     // Catch:{ all -> 0x0106 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0106 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r18)     // Catch:{ all -> 0x0106 }
            r2.d(r3, r4, r15, r0)     // Catch:{ all -> 0x0106 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0106 }
            if (r12 == 0) goto L_0x012b
            r12.close()
        L_0x012b:
            return r0
        L_0x012c:
            if (r12 == 0) goto L_0x0131
            r12.close()
        L_0x0131:
            goto L_0x0133
        L_0x0132:
            throw r0
        L_0x0133:
            goto L_0x0132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.d0(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void e0() {
        i();
        P().beginTransaction();
    }

    public final void f0() {
        i();
        P().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void g0(List list) {
        h();
        i();
        com.google.android.gms.common.internal.n.i(list);
        com.google.android.gms.common.internal.n.k(list.size());
        if (u()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                this.f2527a.f().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e2) {
                this.f2527a.f().r().b("Error incrementing retry count. error", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h0() {
        h();
        i();
        if (u()) {
            long a2 = this.f2504b.d0().f2607e.a();
            long b2 = this.f2527a.a().b();
            long abs = Math.abs(b2 - a2);
            this.f2527a.z();
            if (abs > ((Long) y2.y.a((Object) null)).longValue()) {
                this.f2504b.d0().f2607e.b(b2);
                h();
                i();
                if (u()) {
                    SQLiteDatabase P = P();
                    this.f2527a.z();
                    int delete = P.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.f2527a.a().a()), String.valueOf(h.i())});
                    if (delete > 0) {
                        this.f2527a.f().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        com.google.android.gms.common.internal.n.e(str);
        com.google.android.gms.common.internal.n.e(str2);
        h();
        i();
        try {
            P().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.f2527a.f().r().d("Error deleting user property. appId", m3.z(str), this.f2527a.D().f(str2), e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0325, code lost:
        r0 = java.lang.Boolean.valueOf(r3.M());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x032e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x032f, code lost:
        r11.put("session_scoped", r0);
        r11.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0343, code lost:
        if (P().insertWithOnConflict("property_filters", (java.lang.String) null, r11, 5) != -1) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0345, code lost:
        r1.f2527a.f().r().b("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.m3.z(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0359, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x035d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r3 = r1.f2527a.f().r();
        r7 = "Error storing property filter. appId";
        r8 = com.google.android.gms.measurement.internal.m3.z(r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0370, code lost:
        i();
        h();
        com.google.android.gms.common.internal.n.e(r24);
        r0 = P();
        r3 = r17;
        r0.delete("property_filters", r3, new java.lang.String[]{r2, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", r3, new java.lang.String[]{r2, java.lang.String.valueOf(r10)});
        r17 = r3;
        r7 = r21;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03a7, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0176, code lost:
        r0.c(r8, r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x017a, code lost:
        r11 = r0.L().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0186, code lost:
        if (r11.hasNext() == false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        if (((c.d.a.b.e.e.g3) r11.next()).N() != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0194, code lost:
        r0 = r1.f2527a.f().w();
        r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
        r9 = com.google.android.gms.measurement.internal.m3.z(r24);
        r10 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a9, code lost:
        r11 = r0.K().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01bf, code lost:
        if (r11.hasNext() == false) goto L_0x0295;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r12 = (c.d.a.b.e.e.y2) r11.next();
        i();
        h();
        com.google.android.gms.common.internal.n.e(r24);
        com.google.android.gms.common.internal.n.i(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01db, code lost:
        if (r12.K().isEmpty() == false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01dd, code lost:
        r0 = r1.f2527a.f().w();
        r9 = com.google.android.gms.measurement.internal.m3.z(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f5, code lost:
        if (r12.S() == false) goto L_0x0202;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01f7, code lost:
        r20 = java.lang.Integer.valueOf(r12.F());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0202, code lost:
        r20 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0204, code lost:
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r20));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x020f, code lost:
        r3 = r12.k();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0228, code lost:
        if (r12.S() == false) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x022a, code lost:
        r9 = java.lang.Integer.valueOf(r12.F());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0233, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0234, code lost:
        r7.put("filter_id", r9);
        r7.put("event_name", r12.K());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0244, code lost:
        if (r12.T() == false) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0246, code lost:
        r9 = java.lang.Boolean.valueOf(r12.Q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x024f, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0250, code lost:
        r7.put("session_scoped", r9);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0264, code lost:
        if (P().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0266, code lost:
        r1.f2527a.f().r().b("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.m3.z(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0279, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0290, code lost:
        r3.c(r7, r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0295, code lost:
        r21 = r7;
        r0 = r0.L().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02a3, code lost:
        if (r0.hasNext() == false) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02a5, code lost:
        r3 = (c.d.a.b.e.e.g3) r0.next();
        i();
        h();
        com.google.android.gms.common.internal.n.e(r24);
        com.google.android.gms.common.internal.n.i(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02bf, code lost:
        if (r3.I().isEmpty() == false) goto L_0x02ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02c1, code lost:
        r0 = r1.f2527a.f().w();
        r8 = com.google.android.gms.measurement.internal.m3.z(r24);
        r9 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02d9, code lost:
        if (r3.N() == false) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02db, code lost:
        r3 = java.lang.Integer.valueOf(r3.E());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02e4, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02e5, code lost:
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r9, java.lang.String.valueOf(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ee, code lost:
        r7 = r3.k();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r2);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0305, code lost:
        if (r3.N() == false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0307, code lost:
        r12 = java.lang.Integer.valueOf(r3.E());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0310, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0311, code lost:
        r11.put("filter_id", r12);
        r22 = r0;
        r11.put("property_name", r3.I());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0323, code lost:
        if (r3.O() == false) goto L_0x032e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.n.i(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            c.d.a.b.e.e.w2 r9 = (c.d.a.b.e.e.w2) r9
            c.d.a.b.e.e.p8 r9 = r9.B()
            c.d.a.b.e.e.v2 r9 = (c.d.a.b.e.e.v2) r9
            int r11 = r9.s()
            if (r11 == 0) goto L_0x009d
            r11 = 0
        L_0x002b:
            int r12 = r9.s()
            if (r11 >= r12) goto L_0x009d
            c.d.a.b.e.e.y2 r12 = r9.w(r11)
            c.d.a.b.e.e.p8 r12 = r12.B()
            c.d.a.b.e.e.x2 r12 = (c.d.a.b.e.e.x2) r12
            c.d.a.b.e.e.p8 r13 = r12.clone()
            c.d.a.b.e.e.x2 r13 = (c.d.a.b.e.e.x2) r13
            java.lang.String r14 = r12.w()
            java.lang.String r14 = com.google.android.gms.measurement.internal.v5.b(r14)
            if (r14 == 0) goto L_0x0050
            r13.t(r14)
            r14 = 1
            goto L_0x0051
        L_0x0050:
            r14 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r7 = r12.s()
            if (r15 >= r7) goto L_0x0088
            c.d.a.b.e.e.a3 r7 = r12.v(r15)
            java.lang.String r10 = r7.I()
            r16 = r12
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.w5.f2602a
            r17 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.w5.f2603b
            java.lang.String r4 = com.google.android.gms.measurement.internal.l7.a(r10, r12, r4)
            if (r4 == 0) goto L_0x0081
            c.d.a.b.e.e.p8 r7 = r7.B()
            c.d.a.b.e.e.z2 r7 = (c.d.a.b.e.e.z2) r7
            r7.s(r4)
            c.d.a.b.e.e.s8 r4 = r7.n()
            c.d.a.b.e.e.a3 r4 = (c.d.a.b.e.e.a3) r4
            r13.u(r15, r4)
            r14 = 1
        L_0x0081:
            int r15 = r15 + 1
            r12 = r16
            r4 = r17
            goto L_0x0052
        L_0x0088:
            r17 = r4
            if (r14 == 0) goto L_0x0098
            r9.u(r11, r13)
            c.d.a.b.e.e.s8 r4 = r9.n()
            c.d.a.b.e.e.w2 r4 = (c.d.a.b.e.e.w2) r4
            r3.set(r8, r4)
        L_0x0098:
            int r11 = r11 + 1
            r4 = r17
            goto L_0x002b
        L_0x009d:
            r17 = r4
            int r4 = r9.t()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.t()
            if (r4 >= r7) goto L_0x00d6
            c.d.a.b.e.e.g3 r7 = r9.x(r4)
            java.lang.String r10 = r7.I()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.x5.f2632a
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.x5.f2633b
            java.lang.String r10 = com.google.android.gms.measurement.internal.l7.a(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            c.d.a.b.e.e.p8 r7 = r7.B()
            c.d.a.b.e.e.f3 r7 = (c.d.a.b.e.e.f3) r7
            r7.s(r10)
            r9.v(r4, r7)
            c.d.a.b.e.e.s8 r7 = r9.n()
            c.d.a.b.e.e.w2 r7 = (c.d.a.b.e.e.w2) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r17
            goto L_0x0012
        L_0x00dc:
            r17 = r4
            r23.i()
            r23.h()
            com.google.android.gms.common.internal.n.e(r24)
            com.google.android.gms.common.internal.n.i(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.P()
            r4.beginTransaction()
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            android.database.sqlite.SQLiteDatabase r7 = r23.P()     // Catch:{ all -> 0x0490 }
            r8 = 1
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0490 }
            r10 = 0
            r9[r10] = r2     // Catch:{ all -> 0x0490 }
            r7.delete(r6, r0, r9)     // Catch:{ all -> 0x0490 }
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ all -> 0x0490 }
            r9[r10] = r2     // Catch:{ all -> 0x0490 }
            r7.delete(r5, r0, r9)     // Catch:{ all -> 0x0490 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0490 }
        L_0x0112:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0490 }
            if (r0 == 0) goto L_0x03ad
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.w2 r0 = (c.d.a.b.e.e.w2) r0     // Catch:{ all -> 0x0490 }
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.i(r0)     // Catch:{ all -> 0x0490 }
            boolean r10 = r0.O()     // Catch:{ all -> 0x0490 }
            if (r10 != 0) goto L_0x0144
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            r0.b(r8, r9)     // Catch:{ all -> 0x0490 }
            goto L_0x0112
        L_0x0144:
            int r10 = r0.E()     // Catch:{ all -> 0x0490 }
            java.util.List r11 = r0.K()     // Catch:{ all -> 0x0490 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0490 }
        L_0x0150:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0490 }
            if (r12 == 0) goto L_0x017a
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.y2 r12 = (c.d.a.b.e.e.y2) r12     // Catch:{ all -> 0x0490 }
            boolean r12 = r12.S()     // Catch:{ all -> 0x0490 }
            if (r12 != 0) goto L_0x0150
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
        L_0x0176:
            r0.c(r8, r9, r10)     // Catch:{ all -> 0x0490 }
            goto L_0x0112
        L_0x017a:
            java.util.List r11 = r0.L()     // Catch:{ all -> 0x0490 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0490 }
        L_0x0182:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0490 }
            if (r12 == 0) goto L_0x01a9
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.g3 r12 = (c.d.a.b.e.e.g3) r12     // Catch:{ all -> 0x0490 }
            boolean r12 = r12.N()     // Catch:{ all -> 0x0490 }
            if (r12 != 0) goto L_0x0182
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
            goto L_0x0176
        L_0x01a9:
            java.util.List r11 = r0.K()     // Catch:{ all -> 0x0490 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0490 }
        L_0x01b1:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = "data"
            java.lang.String r13 = "session_scoped"
            java.lang.String r14 = "filter_id"
            java.lang.String r9 = "audience_id"
            java.lang.String r15 = "app_id"
            if (r12 == 0) goto L_0x0295
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.y2 r12 = (c.d.a.b.e.e.y2) r12     // Catch:{ all -> 0x0490 }
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.i(r12)     // Catch:{ all -> 0x0490 }
            java.lang.String r21 = r12.K()     // Catch:{ all -> 0x0490 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0490 }
            if (r21 == 0) goto L_0x020f
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
            boolean r13 = r12.S()     // Catch:{ all -> 0x0490 }
            if (r13 == 0) goto L_0x0202
            int r12 = r12.F()     // Catch:{ all -> 0x0490 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0490 }
            r20 = r12
            goto L_0x0204
        L_0x0202:
            r20 = 0
        L_0x0204:
            java.lang.String r12 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x0490 }
            r0.d(r8, r9, r11, r12)     // Catch:{ all -> 0x0490 }
            r21 = r7
            goto L_0x0370
        L_0x020f:
            byte[] r3 = r12.k()     // Catch:{ all -> 0x0490 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0490 }
            r7.<init>()     // Catch:{ all -> 0x0490 }
            r7.put(r15, r2)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
            r7.put(r9, r15)     // Catch:{ all -> 0x0490 }
            boolean r9 = r12.S()     // Catch:{ all -> 0x0490 }
            if (r9 == 0) goto L_0x0233
            int r9 = r12.F()     // Catch:{ all -> 0x0490 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0490 }
            goto L_0x0234
        L_0x0233:
            r9 = 0
        L_0x0234:
            r7.put(r14, r9)     // Catch:{ all -> 0x0490 }
            java.lang.String r9 = "event_name"
            java.lang.String r14 = r12.K()     // Catch:{ all -> 0x0490 }
            r7.put(r9, r14)     // Catch:{ all -> 0x0490 }
            boolean r9 = r12.T()     // Catch:{ all -> 0x0490 }
            if (r9 == 0) goto L_0x024f
            boolean r9 = r12.Q()     // Catch:{ all -> 0x0490 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0490 }
            goto L_0x0250
        L_0x024f:
            r9 = 0
        L_0x0250:
            r7.put(r13, r9)     // Catch:{ all -> 0x0490 }
            r7.put(r8, r3)     // Catch:{ all -> 0x0490 }
            android.database.sqlite.SQLiteDatabase r3 = r23.P()     // Catch:{ SQLiteException -> 0x027f }
            r8 = 5
            r9 = 0
            long r7 = r3.insertWithOnConflict(r5, r9, r7, r8)     // Catch:{ SQLiteException -> 0x027f }
            r12 = -1
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x0279
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ SQLiteException -> 0x027f }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ SQLiteException -> 0x027f }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x027f }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ SQLiteException -> 0x027f }
            r3.b(r7, r8)     // Catch:{ SQLiteException -> 0x027f }
        L_0x0279:
            r3 = r25
            r7 = r21
            goto L_0x01b1
        L_0x027f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x0490 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
        L_0x0290:
            r3.c(r7, r8, r0)     // Catch:{ all -> 0x0490 }
            goto L_0x0370
        L_0x0295:
            r21 = r7
            java.util.List r0 = r0.L()     // Catch:{ all -> 0x0490 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0490 }
        L_0x029f:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0490 }
            if (r3 == 0) goto L_0x03a7
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.g3 r3 = (c.d.a.b.e.e.g3) r3     // Catch:{ all -> 0x0490 }
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.i(r3)     // Catch:{ all -> 0x0490 }
            java.lang.String r7 = r3.I()     // Catch:{ all -> 0x0490 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0490 }
            if (r7 == 0) goto L_0x02ee
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0490 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
            boolean r11 = r3.N()     // Catch:{ all -> 0x0490 }
            if (r11 == 0) goto L_0x02e4
            int r3 = r3.E()     // Catch:{ all -> 0x0490 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0490 }
            goto L_0x02e5
        L_0x02e4:
            r3 = 0
        L_0x02e5:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0490 }
            r0.d(r7, r8, r9, r3)     // Catch:{ all -> 0x0490 }
            goto L_0x0370
        L_0x02ee:
            byte[] r7 = r3.k()     // Catch:{ all -> 0x0490 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ all -> 0x0490 }
            r11.<init>()     // Catch:{ all -> 0x0490 }
            r11.put(r15, r2)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0490 }
            r11.put(r9, r12)     // Catch:{ all -> 0x0490 }
            boolean r12 = r3.N()     // Catch:{ all -> 0x0490 }
            if (r12 == 0) goto L_0x0310
            int r12 = r3.E()     // Catch:{ all -> 0x0490 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0490 }
            goto L_0x0311
        L_0x0310:
            r12 = 0
        L_0x0311:
            r11.put(r14, r12)     // Catch:{ all -> 0x0490 }
            java.lang.String r12 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.I()     // Catch:{ all -> 0x0490 }
            r11.put(r12, r0)     // Catch:{ all -> 0x0490 }
            boolean r0 = r3.O()     // Catch:{ all -> 0x0490 }
            if (r0 == 0) goto L_0x032e
            boolean r0 = r3.M()     // Catch:{ all -> 0x0490 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0490 }
            goto L_0x032f
        L_0x032e:
            r0 = 0
        L_0x032f:
            r11.put(r13, r0)     // Catch:{ all -> 0x0490 }
            r11.put(r8, r7)     // Catch:{ all -> 0x0490 }
            android.database.sqlite.SQLiteDatabase r0 = r23.P()     // Catch:{ SQLiteException -> 0x035d }
            r3 = 0
            r7 = 5
            long r11 = r0.insertWithOnConflict(r6, r3, r11, r7)     // Catch:{ SQLiteException -> 0x035d }
            r18 = -1
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x0359
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ SQLiteException -> 0x035d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x035d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ SQLiteException -> 0x035d }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ SQLiteException -> 0x035d }
            r0.b(r3, r7)     // Catch:{ SQLiteException -> 0x035d }
            goto L_0x0370
        L_0x0359:
            r0 = r22
            goto L_0x029f
        L_0x035d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x0490 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            goto L_0x0290
        L_0x0370:
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            android.database.sqlite.SQLiteDatabase r0 = r23.P()     // Catch:{ all -> 0x0490 }
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0490 }
            r3 = 0
            r7[r3] = r2     // Catch:{ all -> 0x0490 }
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0490 }
            r8 = 1
            r7[r8] = r3     // Catch:{ all -> 0x0490 }
            r3 = r17
            r0.delete(r6, r3, r7)     // Catch:{ all -> 0x0490 }
            r7 = 2
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x0490 }
            r8 = 0
            r7[r8] = r2     // Catch:{ all -> 0x0490 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0490 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0490 }
            r0.delete(r5, r3, r7)     // Catch:{ all -> 0x0490 }
            r17 = r3
            r7 = r21
            r3 = r25
            goto L_0x0112
        L_0x03a7:
            r3 = r25
            r7 = r21
            goto L_0x0112
        L_0x03ad:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0490 }
            r0.<init>()     // Catch:{ all -> 0x0490 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0490 }
        L_0x03b7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0490 }
            if (r6 == 0) goto L_0x03d7
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0490 }
            c.d.a.b.e.e.w2 r6 = (c.d.a.b.e.e.w2) r6     // Catch:{ all -> 0x0490 }
            boolean r7 = r6.O()     // Catch:{ all -> 0x0490 }
            if (r7 == 0) goto L_0x03d2
            int r6 = r6.E()     // Catch:{ all -> 0x0490 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0490 }
            goto L_0x03d3
        L_0x03d2:
            r9 = r3
        L_0x03d3:
            r0.add(r9)     // Catch:{ all -> 0x0490 }
            goto L_0x03b7
        L_0x03d7:
            com.google.android.gms.common.internal.n.e(r24)     // Catch:{ all -> 0x0490 }
            r23.i()     // Catch:{ all -> 0x0490 }
            r23.h()     // Catch:{ all -> 0x0490 }
            android.database.sqlite.SQLiteDatabase r3 = r23.P()     // Catch:{ all -> 0x0490 }
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0475 }
            r5 = 0
            r6[r5] = r2     // Catch:{ SQLiteException -> 0x0475 }
            java.lang.String r5 = "select count(1) from audience_filter_values where app_id=?"
            long r5 = r1.I(r5, r6)     // Catch:{ SQLiteException -> 0x0475 }
            com.google.android.gms.measurement.internal.x4 r7 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.h r7 = r7.z()     // Catch:{ all -> 0x0490 }
            r8 = 2000(0x7d0, float:2.803E-42)
            com.google.android.gms.measurement.internal.x2 r9 = com.google.android.gms.measurement.internal.y2.F     // Catch:{ all -> 0x0490 }
            int r7 = r7.o(r2, r9)     // Catch:{ all -> 0x0490 }
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0490 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0490 }
            long r8 = (long) r7     // Catch:{ all -> 0x0490 }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x040e
            goto L_0x0489
        L_0x040e:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0490 }
            r5.<init>()     // Catch:{ all -> 0x0490 }
            r10 = 0
        L_0x0414:
            int r6 = r0.size()     // Catch:{ all -> 0x0490 }
            if (r10 >= r6) goto L_0x0430
            java.lang.Object r6 = r0.get(r10)     // Catch:{ all -> 0x0490 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0490 }
            if (r6 == 0) goto L_0x0489
            int r6 = r6.intValue()     // Catch:{ all -> 0x0490 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0490 }
            r5.add(r6)     // Catch:{ all -> 0x0490 }
            int r10 = r10 + 1
            goto L_0x0414
        L_0x0430:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0490 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0490 }
            r5.<init>()     // Catch:{ all -> 0x0490 }
            java.lang.String r6 = "("
            r5.append(r6)     // Catch:{ all -> 0x0490 }
            r5.append(r0)     // Catch:{ all -> 0x0490 }
            java.lang.String r0 = ")"
            r5.append(r0)     // Catch:{ all -> 0x0490 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0490 }
            r0.<init>()     // Catch:{ all -> 0x0490 }
            java.lang.String r6 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r0.append(r6)     // Catch:{ all -> 0x0490 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0490 }
            r0.append(r5)     // Catch:{ all -> 0x0490 }
            java.lang.String r5 = " order by rowid desc limit -1 offset ?)"
            r0.append(r5)     // Catch:{ all -> 0x0490 }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0490 }
            r6 = 0
            r5[r6] = r2     // Catch:{ all -> 0x0490 }
            java.lang.String r2 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0490 }
            r6 = 1
            r5[r6] = r2     // Catch:{ all -> 0x0490 }
            java.lang.String r2 = "audience_filter_values"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0490 }
            r3.delete(r2, r0, r5)     // Catch:{ all -> 0x0490 }
            goto L_0x0489
        L_0x0475:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x0490 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x0490 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r24)     // Catch:{ all -> 0x0490 }
            r3.c(r5, r2, r0)     // Catch:{ all -> 0x0490 }
        L_0x0489:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0490 }
            r4.endTransaction()
            return
        L_0x0490:
            r0 = move-exception
            r4.endTransaction()
            goto L_0x0496
        L_0x0495:
            throw r0
        L_0x0496:
            goto L_0x0495
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n.n(java.lang.String, java.util.List):void");
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(h6 h6Var) {
        com.google.android.gms.common.internal.n.i(h6Var);
        h();
        i();
        String d0 = h6Var.d0();
        com.google.android.gms.common.internal.n.i(d0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", d0);
        contentValues.put("app_instance_id", h6Var.e0());
        contentValues.put("gmp_app_id", h6Var.i0());
        contentValues.put("resettable_device_id_hash", h6Var.a());
        contentValues.put("last_bundle_index", Long.valueOf(h6Var.Y()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(h6Var.Z()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(h6Var.X()));
        contentValues.put("app_version", h6Var.g0());
        contentValues.put("app_store", h6Var.f0());
        contentValues.put("gmp_version", Long.valueOf(h6Var.W()));
        contentValues.put("dev_cert_hash", Long.valueOf(h6Var.T()));
        contentValues.put("measurement_enabled", Boolean.valueOf(h6Var.J()));
        contentValues.put("day", Long.valueOf(h6Var.S()));
        contentValues.put("daily_public_events_count", Long.valueOf(h6Var.Q()));
        contentValues.put("daily_events_count", Long.valueOf(h6Var.P()));
        contentValues.put("daily_conversions_count", Long.valueOf(h6Var.N()));
        contentValues.put("config_fetched_time", Long.valueOf(h6Var.M()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(h6Var.V()));
        contentValues.put("app_version_int", Long.valueOf(h6Var.L()));
        contentValues.put("firebase_instance_id", h6Var.h0());
        contentValues.put("daily_error_events_count", Long.valueOf(h6Var.O()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(h6Var.R()));
        contentValues.put("health_monitor_sample", h6Var.j0());
        h6Var.A();
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(h6Var.I()));
        contentValues.put("admob_app_id", h6Var.b0());
        contentValues.put("dynamite_version", Long.valueOf(h6Var.U()));
        contentValues.put("session_stitching_token", h6Var.b());
        List c2 = h6Var.c();
        if (c2 != null) {
            if (c2.isEmpty()) {
                this.f2527a.f().w().b("Safelisted events should not be an empty list. appId", d0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", c2));
            }
        }
        gc.c();
        if (this.f2527a.z().B((String) null, y2.g0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase P = P();
            if (((long) P.update("apps", contentValues, "app_id = ?", new String[]{d0})) == 0 && P.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.f2527a.f().r().b("Failed to insert/update app (got -1). appId", m3.z(d0));
            }
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error storing app. appId", m3.z(d0), e2);
        }
    }

    public final void q(t tVar) {
        com.google.android.gms.common.internal.n.i(tVar);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", tVar.f2540a);
        contentValues.put("name", tVar.f2541b);
        contentValues.put("lifetime_count", Long.valueOf(tVar.f2542c));
        contentValues.put("current_bundle_count", Long.valueOf(tVar.f2543d));
        contentValues.put("last_fire_timestamp", Long.valueOf(tVar.f2545f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(tVar.g));
        contentValues.put("last_bundled_day", tVar.h);
        contentValues.put("last_sampled_complex_event_id", tVar.i);
        contentValues.put("last_sampling_rate", tVar.j);
        contentValues.put("current_session_count", Long.valueOf(tVar.f2544e));
        Boolean bool = tVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (P().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                this.f2527a.f().r().b("Failed to insert/update event aggregates (got -1). appId", m3.z(tVar.f2540a));
            }
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error storing event aggregates. appId", m3.z(tVar.f2540a), e2);
        }
    }

    public final boolean r() {
        return I("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean s() {
        return I("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean t() {
        return I("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        Context d2 = this.f2527a.d();
        this.f2527a.z();
        return d2.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l2, long j2, g4 g4Var) {
        h();
        i();
        com.google.android.gms.common.internal.n.i(g4Var);
        com.google.android.gms.common.internal.n.e(str);
        com.google.android.gms.common.internal.n.i(l2);
        byte[] k2 = g4Var.k();
        this.f2527a.f().v().c("Saving complex main event, appId, data size", this.f2527a.D().d(str), Integer.valueOf(k2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", k2);
        try {
            if (P().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.f2527a.f().r().b("Failed to insert complex main event (got -1). appId", m3.z(str));
            return false;
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error storing complex main event. appId", m3.z(str), e2);
            return false;
        }
    }

    public final boolean w(d dVar) {
        com.google.android.gms.common.internal.n.i(dVar);
        h();
        i();
        String str = dVar.j;
        com.google.android.gms.common.internal.n.i(str);
        if (X(str, dVar.l.k) == null) {
            long I = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f2527a.z();
            if (I >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", dVar.k);
        contentValues.put("name", dVar.l.k);
        Object g2 = dVar.l.g();
        com.google.android.gms.common.internal.n.i(g2);
        H(contentValues, "value", g2);
        contentValues.put("active", Boolean.valueOf(dVar.n));
        contentValues.put("trigger_event_name", dVar.o);
        contentValues.put("trigger_timeout", Long.valueOf(dVar.q));
        contentValues.put("timed_out_event", this.f2527a.N().c0(dVar.p));
        contentValues.put("creation_timestamp", Long.valueOf(dVar.m));
        contentValues.put("triggered_event", this.f2527a.N().c0(dVar.r));
        contentValues.put("triggered_timestamp", Long.valueOf(dVar.l.l));
        contentValues.put("time_to_live", Long.valueOf(dVar.s));
        contentValues.put("expired_event", this.f2527a.N().c0(dVar.t));
        try {
            if (P().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                this.f2527a.f().r().b("Failed to insert/update conditional user property (got -1)", m3.z(str));
            }
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error storing conditional user property", m3.z(str), e2);
        }
        return true;
    }

    public final boolean x(ha haVar) {
        com.google.android.gms.common.internal.n.i(haVar);
        h();
        i();
        if (X(haVar.f2404a, haVar.f2406c) == null) {
            if (la.X(haVar.f2406c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{haVar.f2404a}) >= ((long) this.f2527a.z().p(haVar.f2404a, y2.G, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(haVar.f2406c)) {
                long I = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{haVar.f2404a, haVar.f2405b});
                this.f2527a.z();
                if (I >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", haVar.f2404a);
        contentValues.put("origin", haVar.f2405b);
        contentValues.put("name", haVar.f2406c);
        contentValues.put("set_timestamp", Long.valueOf(haVar.f2407d));
        H(contentValues, "value", haVar.f2408e);
        try {
            if (P().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                this.f2527a.f().r().b("Failed to insert/update user property (got -1). appId", m3.z(haVar.f2404a));
            }
        } catch (SQLiteException e2) {
            this.f2527a.f().r().c("Error storing user property. appId", m3.z(haVar.f2404a), e2);
        }
        return true;
    }
}
