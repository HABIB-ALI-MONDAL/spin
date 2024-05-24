package c.b.a.t;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class e<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f1277a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private long f1278b;

    /* renamed from: c  reason: collision with root package name */
    private long f1279c;

    public e(long j) {
        this.f1278b = j;
    }

    private void f() {
        m(this.f1278b);
    }

    public void b() {
        m(0);
    }

    public synchronized Y g(T t) {
        return this.f1277a.get(t);
    }

    public synchronized long h() {
        return this.f1278b;
    }

    /* access modifiers changed from: protected */
    public int i(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void j(T t, Y y) {
    }

    public synchronized Y k(T t, Y y) {
        long i = (long) i(y);
        if (i >= this.f1278b) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.f1279c += i;
        }
        Y put = this.f1277a.put(t, y);
        if (put != null) {
            this.f1279c -= (long) i(put);
            if (!put.equals(y)) {
                j(t, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t) {
        Y remove;
        remove = this.f1277a.remove(t);
        if (remove != null) {
            this.f1279c -= (long) i(remove);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public synchronized void m(long j) {
        while (this.f1279c > j) {
            Iterator<Map.Entry<T, Y>> it = this.f1277a.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.f1279c -= (long) i(value);
            Object key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
