package c.d.a.b.e.e;

import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f1577a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1578b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f1579c;

    public b(String str, long j, Map map) {
        this.f1577a = str;
        this.f1578b = j;
        HashMap hashMap = new HashMap();
        this.f1579c = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public final long a() {
        return this.f1578b;
    }

    /* renamed from: b */
    public final b clone() {
        return new b(this.f1577a, this.f1578b, new HashMap(this.f1579c));
    }

    public final Object c(String str) {
        if (this.f1579c.containsKey(str)) {
            return this.f1579c.get(str);
        }
        return null;
    }

    public final String d() {
        return this.f1577a;
    }

    public final Map e() {
        return this.f1579c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f1578b == bVar.f1578b && this.f1577a.equals(bVar.f1577a)) {
            return this.f1579c.equals(bVar.f1579c);
        }
        return false;
    }

    public final void f(String str) {
        this.f1577a = str;
    }

    public final void g(String str, Object obj) {
        if (obj == null) {
            this.f1579c.remove(str);
        } else {
            this.f1579c.put(str, obj);
        }
    }

    public final int hashCode() {
        int hashCode = this.f1577a.hashCode();
        long j = this.f1578b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f1579c.hashCode();
    }

    public final String toString() {
        String str = this.f1577a;
        long j = this.f1578b;
        String obj = this.f1579c.toString();
        return "Event{name='" + str + "', timestamp=" + j + ", params=" + obj + "}";
    }
}
