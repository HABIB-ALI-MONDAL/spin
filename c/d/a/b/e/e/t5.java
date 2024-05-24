package c.d.a.b.e.e;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import b.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class t5 implements y5 {
    private static final Map h = new a();
    public static final String[] i = {"key", "value"};

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f1753a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f1754b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f1755c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentObserver f1756d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f1757e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private volatile Map f1758f;
    private final List g = new ArrayList();

    private t5(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        s5 s5Var = new s5(this, (Handler) null);
        this.f1756d = s5Var;
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.f1753a = contentResolver;
        this.f1754b = uri;
        this.f1755c = runnable;
        contentResolver.registerContentObserver(uri, false, s5Var);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static c.d.a.b.e.e.t5 b(android.content.ContentResolver r4, android.net.Uri r5, java.lang.Runnable r6) {
        /*
            java.lang.Class<c.d.a.b.e.e.t5> r0 = c.d.a.b.e.e.t5.class
            monitor-enter(r0)
            java.util.Map r1 = h     // Catch:{ all -> 0x0018 }
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0018 }
            c.d.a.b.e.e.t5 r2 = (c.d.a.b.e.e.t5) r2     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x0016
            c.d.a.b.e.e.t5 r3 = new c.d.a.b.e.e.t5     // Catch:{ SecurityException -> 0x0016 }
            r3.<init>(r4, r5, r6)     // Catch:{ SecurityException -> 0x0016 }
            r1.put(r5, r3)     // Catch:{ SecurityException -> 0x0015 }
        L_0x0015:
            r2 = r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r2
        L_0x0018:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.t5.b(android.content.ContentResolver, android.net.Uri, java.lang.Runnable):c.d.a.b.e.e.t5");
    }

    static synchronized void e() {
        synchronized (t5.class) {
            for (t5 t5Var : h.values()) {
                t5Var.f1753a.unregisterContentObserver(t5Var.f1756d);
            }
            h.clear();
        }
    }

    public final /* bridge */ /* synthetic */ Object a(String str) {
        return (String) c().get(str);
    }

    /* JADX INFO: finally extract failed */
    public final Map c() {
        Map map;
        Map map2 = this.f1758f;
        if (map2 == null) {
            synchronized (this.f1757e) {
                map2 = this.f1758f;
                if (map2 == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        map = (Map) w5.a(new r5(this));
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                        try {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = null;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                    this.f1758f = map;
                    map2 = map;
                }
            }
        }
        return map2 != null ? map2 : Collections.emptyMap();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map d() {
        Cursor query = this.f1753a.query(this.f1754b, i, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map aVar = count <= 256 ? new a(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                aVar.put(query.getString(0), query.getString(1));
            }
            query.close();
            return aVar;
        } finally {
            query.close();
        }
    }

    public final void f() {
        synchronized (this.f1757e) {
            this.f1758f = null;
            this.f1755c.run();
        }
        synchronized (this) {
            for (u5 a2 : this.g) {
                a2.a();
            }
        }
    }
}
