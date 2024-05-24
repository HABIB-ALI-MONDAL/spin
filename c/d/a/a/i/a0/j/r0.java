package c.d.a.a.i.a0.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import c.d.a.a.i.b0.b;
import c.d.a.a.i.i;
import c.d.a.a.i.j;
import c.d.a.a.i.p;
import c.d.a.a.i.x.a.a;
import c.d.a.a.i.x.a.b;
import c.d.a.a.i.x.a.c;
import c.d.a.a.i.x.a.d;
import c.d.a.a.i.x.a.e;
import c.d.a.a.i.x.a.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class r0 implements j0, c.d.a.a.i.b0.b, i0 {
    private static final c.d.a.a.b o = c.d.a.a.b.b("proto");
    private final t0 j;
    private final c.d.a.a.i.c0.a k;
    private final c.d.a.a.i.c0.a l;
    private final k0 m;
    private final d.a.a<String> n;

    interface b<T, U> {
        U a(T t);
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final String f1376a;

        /* renamed from: b  reason: collision with root package name */
        final String f1377b;

        private c(String str, String str2) {
            this.f1376a = str;
            this.f1377b = str2;
        }
    }

    interface d<T> {
        T a();
    }

    r0(c.d.a.a.i.c0.a aVar, c.d.a.a.i.c0.a aVar2, k0 k0Var, t0 t0Var, d.a.a<String> aVar3) {
        this.j = t0Var;
        this.k = aVar;
        this.l = aVar2;
        this.m = k0Var;
        this.n = aVar3;
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ Object B(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i = cursor.getInt(0);
            i((long) i, c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ Integer D(long j2, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j2)};
        s0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new j(this));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    static /* synthetic */ Object F(Throwable th) {
        throw new c.d.a.a.i.b0.a("Timed out while trying to acquire the lock.", th);
    }

    static /* synthetic */ SQLiteDatabase G(Throwable th) {
        throw new c.d.a.a.i.b0.a("Timed out while trying to open db.", th);
    }

    static /* synthetic */ Long H(Cursor cursor) {
        return Long.valueOf(cursor.moveToNext() ? cursor.getLong(0) : 0);
    }

    static /* synthetic */ f I(long j2, Cursor cursor) {
        cursor.moveToNext();
        long j3 = cursor.getLong(0);
        f.a c2 = f.c();
        c2.c(j3);
        c2.b(j2);
        return c2.a();
    }

    static /* synthetic */ f J(long j2, SQLiteDatabase sQLiteDatabase) {
        return (f) s0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new c(j2));
    }

    static /* synthetic */ Long K(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ Boolean M(p pVar, SQLiteDatabase sQLiteDatabase) {
        Long w = w(sQLiteDatabase, pVar);
        if (w == null) {
            return Boolean.FALSE;
        }
        return (Boolean) s0(r().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{w.toString()}), e0.f1332a);
    }

    static /* synthetic */ List N(SQLiteDatabase sQLiteDatabase) {
        return (List) s0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), h.f1347a);
    }

    static /* synthetic */ List O(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            p.a a2 = p.a();
            a2.b(cursor.getString(1));
            a2.d(c.d.a.a.i.d0.a.b(cursor.getInt(2)));
            a2.c(m0(cursor.getString(3)));
            arrayList.add(a2.a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ List Q(p pVar, SQLiteDatabase sQLiteDatabase) {
        List<q0> k0 = k0(sQLiteDatabase, pVar, this.m.d());
        for (c.d.a.a.d dVar : c.d.a.a.d.values()) {
            if (dVar != pVar.d()) {
                int d2 = this.m.d() - k0.size();
                if (d2 <= 0) {
                    break;
                }
                k0.addAll(k0(sQLiteDatabase, pVar.f(dVar), d2));
            }
        }
        z(k0, l0(sQLiteDatabase, k0));
        return k0;
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ c.d.a.a.i.x.a.a S(Map map, a.C0062a aVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.b n2 = n(cursor.getInt(1));
            long j2 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            c.a c2 = c.d.a.a.i.x.a.c.c();
            c2.c(n2);
            c2.b(j2);
            ((List) map.get(string)).add(c2.a());
        }
        n0(aVar, map);
        aVar.e(v());
        aVar.d(s());
        aVar.c(this.n.get());
        return aVar.b();
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ c.d.a.a.i.x.a.a U(String str, Map map, a.C0062a aVar, SQLiteDatabase sQLiteDatabase) {
        return (c.d.a.a.i.x.a.a) s0(sQLiteDatabase.rawQuery(str, new String[0]), new u(this, map, aVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public /* synthetic */ Object W(List list, p pVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j2 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            j.a a2 = j.a();
            a2.j(cursor.getString(1));
            a2.i(cursor.getLong(2));
            a2.k(cursor.getLong(3));
            a2.h(z ? new i(q0(cursor.getString(4)), cursor.getBlob(5)) : new i(q0(cursor.getString(4)), o0(j2)));
            if (!cursor.isNull(6)) {
                a2.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(q0.a(j2, pVar, a2.d()));
        }
        return null;
    }

    static /* synthetic */ Object X(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j2));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j2), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ Long Z(j jVar, p pVar, SQLiteDatabase sQLiteDatabase) {
        if (y()) {
            i(1, c.b.CACHE_FULL, jVar.j());
            return -1L;
        }
        long p = p(sQLiteDatabase, pVar);
        int e2 = this.m.e();
        byte[] a2 = jVar.e().a();
        boolean z = a2.length <= e2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(p));
        contentValues.put("transport_name", jVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(jVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(jVar.k()));
        contentValues.put("payload_encoding", jVar.e().b().a());
        contentValues.put("code", jVar.d());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z) {
            double length = (double) a2.length;
            double d2 = (double) e2;
            Double.isNaN(length);
            Double.isNaN(d2);
            int ceil = (int) Math.ceil(length / d2);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i - 1) * e2, Math.min(i * e2, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : jVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    static /* synthetic */ byte[] a0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: b0 */
    public /* synthetic */ Object c0(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i = cursor.getInt(0);
            i((long) i, c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d0 */
    public /* synthetic */ Object e0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        s0(sQLiteDatabase.rawQuery(str2, (String[]) null), new v(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    static /* synthetic */ Boolean f0(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    static /* synthetic */ Object g0(String str, c.b bVar, long j2, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) s0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())}), y.f1397a)).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.d()));
            contentValues.put("events_dropped_count", Long.valueOf(j2));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.d())});
        }
        return null;
    }

    static /* synthetic */ Object h0(long j2, p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(c.d.a.a.i.d0.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(c.d.a.a.i.d0.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ Object j0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.k.a()).execute();
        return null;
    }

    private List<q0> k0(SQLiteDatabase sQLiteDatabase, p pVar, int i) {
        ArrayList arrayList = new ArrayList();
        Long w = w(sQLiteDatabase, pVar);
        if (w == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        s0(sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{w.toString()}, (String) null, (String) null, (String) null, String.valueOf(i)), new o(this, arrayList, pVar));
        return arrayList;
    }

    private Map<Long, Set<c>> l0(SQLiteDatabase sQLiteDatabase, List<q0> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        s0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new t(hashMap));
        return hashMap;
    }

    private static byte[] m0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private c.b n(int i) {
        c.b bVar = c.b.REASON_UNKNOWN;
        if (i == bVar.d()) {
            return bVar;
        }
        c.b bVar2 = c.b.MESSAGE_TOO_OLD;
        if (i == bVar2.d()) {
            return bVar2;
        }
        c.b bVar3 = c.b.CACHE_FULL;
        if (i == bVar3.d()) {
            return bVar3;
        }
        c.b bVar4 = c.b.PAYLOAD_TOO_BIG;
        if (i == bVar4.d()) {
            return bVar4;
        }
        c.b bVar5 = c.b.MAX_RETRIES_REACHED;
        if (i == bVar5.d()) {
            return bVar5;
        }
        c.b bVar6 = c.b.INVALID_PAYLOD;
        if (i == bVar6.d()) {
            return bVar6;
        }
        c.b bVar7 = c.b.SERVER_ERROR;
        if (i == bVar7.d()) {
            return bVar7;
        }
        c.d.a.a.i.y.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i));
        return bVar;
    }

    private void n0(a.C0062a aVar, Map<String, List<c.d.a.a.i.x.a.c>> map) {
        for (Map.Entry next : map.entrySet()) {
            d.a c2 = c.d.a.a.i.x.a.d.c();
            c2.c((String) next.getKey());
            c2.b((List) next.getValue());
            aVar.a(c2.a());
        }
    }

    private void o(SQLiteDatabase sQLiteDatabase) {
        p0(new e(sQLiteDatabase), b.f1324a);
    }

    private byte[] o0(long j2) {
        return (byte[]) s0(r().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, (String) null, (String) null, "sequence_num"), g.f1336a);
    }

    private long p(SQLiteDatabase sQLiteDatabase, p pVar) {
        Long w = w(sQLiteDatabase, pVar);
        if (w != null) {
            return w.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(c.d.a.a.i.d0.a.a(pVar.d())));
        contentValues.put("next_request_ms", 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    private <T> T p0(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.l.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.l.a() >= ((long) this.m.b()) + a2) {
                    return bVar.a(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static c.d.a.a.b q0(String str) {
        return str == null ? o : c.d.a.a.b.b(str);
    }

    private static String r0(Iterable<q0> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<q0> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    private c.d.a.a.i.x.a.b s() {
        b.a b2 = c.d.a.a.i.x.a.b.b();
        e.a c2 = e.c();
        c2.b(q());
        c2.c(k0.f1357a.f());
        b2.b(c2.a());
        return b2.a();
    }

    static <T> T s0(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    private long t() {
        return r().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long u() {
        return r().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private f v() {
        return (f) x(new l(this.k.a()));
    }

    private Long w(SQLiteDatabase sQLiteDatabase, p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{pVar.b(), String.valueOf(c.d.a.a.i.d0.a.a(pVar.d()))}));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) s0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), q.f1372a);
    }

    private boolean y() {
        return t() * u() >= this.m.f();
    }

    private List<q0> z(List<q0> list, Map<Long, Set<c>> map) {
        ListIterator<q0> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            q0 next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                j.a l2 = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l2.c(cVar.f1376a, cVar.f1377b);
                }
                listIterator.set(q0.a(next.c(), next.d(), l2.d()));
            }
        }
        return list;
    }

    public int a() {
        return ((Integer) x(new w(this, this.k.a() - this.m.c()))).intValue();
    }

    public void b(Iterable<q0> iterable) {
        if (iterable.iterator().hasNext()) {
            r().compileStatement("DELETE FROM events WHERE _id in " + r0(iterable)).execute();
        }
    }

    public void c() {
        x(new p(this));
    }

    public void close() {
        this.j.close();
    }

    public long d(p pVar) {
        return ((Long) s0(r().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(c.d.a.a.i.d0.a.a(pVar.d()))}), m.f1359a)).longValue();
    }

    public boolean e(p pVar) {
        return ((Boolean) x(new k(this, pVar))).booleanValue();
    }

    public <T> T f(b.a<T> aVar) {
        SQLiteDatabase r = r();
        o(r);
        try {
            T execute = aVar.execute();
            r.setTransactionSuccessful();
            return execute;
        } finally {
            r.endTransaction();
        }
    }

    public Iterable<q0> g(p pVar) {
        return (Iterable) x(new d(this, pVar));
    }

    public c.d.a.a.i.x.a.a h() {
        return (c.d.a.a.i.x.a.a) x(new n(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), c.d.a.a.i.x.a.a.e()));
    }

    public void i(long j2, c.b bVar, String str) {
        x(new i(str, bVar, j2));
    }

    public void j(Iterable<q0> iterable) {
        if (iterable.iterator().hasNext()) {
            x(new r(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + r0(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public void k(p pVar, long j2) {
        x(new f(j2, pVar));
    }

    public q0 l(p pVar, j jVar) {
        c.d.a.a.i.y.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), jVar.j(), pVar.b());
        long longValue = ((Long) x(new s(this, jVar, pVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return q0.a(longValue, pVar, jVar);
    }

    public Iterable<p> m() {
        return (Iterable) x(x.f1396a);
    }

    /* access modifiers changed from: package-private */
    public long q() {
        return t() * u();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase r() {
        t0 t0Var = this.j;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) p0(new f0(t0Var), a.f1322a);
    }

    /* access modifiers changed from: package-private */
    public <T> T x(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase r = r();
        r.beginTransaction();
        try {
            T a2 = bVar.a(r);
            r.setTransactionSuccessful();
            return a2;
        } finally {
            r.endTransaction();
        }
    }
}
