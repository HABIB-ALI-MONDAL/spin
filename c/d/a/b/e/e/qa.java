package c.d.a.b.e.e;

import java.util.Map;

final class qa implements Map.Entry, Comparable {
    private final Comparable j;
    private Object k;
    final /* synthetic */ wa l;

    qa(wa waVar, Comparable comparable, Object obj) {
        this.l = waVar;
        this.j = comparable;
        this.k = obj;
    }

    private static final boolean e(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.j.compareTo(((qa) obj).j);
    }

    public final Comparable d() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return e(this.j, entry.getKey()) && e(this.k, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.j;
    }

    public final Object getValue() {
        return this.k;
    }

    public final int hashCode() {
        Comparable comparable = this.j;
        int i = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.k;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode ^ i;
    }

    public final Object setValue(Object obj) {
        this.l.n();
        Object obj2 = this.k;
        this.k = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.j);
        String valueOf2 = String.valueOf(this.k);
        return valueOf + "=" + valueOf2;
    }
}
