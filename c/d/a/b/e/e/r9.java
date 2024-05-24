package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class r9 extends LinkedHashMap {
    private static final r9 k;
    private boolean j = true;

    static {
        r9 r9Var = new r9();
        k = r9Var;
        r9Var.j = false;
    }

    private r9() {
    }

    private r9(Map map) {
        super(map);
    }

    public static r9 a() {
        return k;
    }

    private static int i(Object obj) {
        return obj instanceof byte[] ? y8.b((byte[]) obj) : obj.hashCode();
    }

    private final void j() {
        if (!this.j) {
            throw new UnsupportedOperationException();
        }
    }

    public final r9 b() {
        return isEmpty() ? new r9() : new r9(this);
    }

    public final void clear() {
        j();
        super.clear();
    }

    public final void d() {
        this.j = false;
    }

    public final void e(r9 r9Var) {
        j();
        if (!r9Var.isEmpty()) {
            putAll(r9Var);
        }
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final boolean g() {
        return this.j;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += i(entry.getValue()) ^ i(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        j();
        y8.e(obj);
        y8.e(obj2);
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        j();
        for (Object next : map.keySet()) {
            y8.e(next);
            y8.e(map.get(next));
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        j();
        return super.remove(obj);
    }
}
