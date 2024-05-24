package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class j8 {

    /* renamed from: d  reason: collision with root package name */
    private static final j8 f1662d = new j8(true);

    /* renamed from: a  reason: collision with root package name */
    final wa f1663a = new ma(16);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1664b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1665c;

    private j8() {
    }

    private j8(boolean z) {
        b();
        b();
    }

    public static j8 a() {
        throw null;
    }

    private static final void d(i8 i8Var, Object obj) {
        boolean z;
        rb b2 = i8Var.b();
        y8.e(obj);
        rb rbVar = rb.DOUBLE;
        sb sbVar = sb.INT;
        switch (b2.d().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof r7) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if (obj instanceof Integer) {
                    return;
                }
                break;
            case 8:
                if (obj instanceof x9) {
                    return;
                }
                break;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(i8Var.a()), i8Var.b().d(), obj.getClass().getName()}));
    }

    public final void b() {
        if (!this.f1664b) {
            for (int i = 0; i < this.f1663a.b(); i++) {
                Map.Entry g = this.f1663a.g(i);
                if (g.getValue() instanceof s8) {
                    ((s8) g.getValue()).u();
                }
            }
            this.f1663a.a();
            this.f1664b = true;
        }
    }

    public final void c(i8 i8Var, Object obj) {
        if (!i8Var.c()) {
            d(i8Var, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d(i8Var, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.f1663a.put(i8Var, obj);
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        j8 j8Var = new j8();
        for (int i = 0; i < this.f1663a.b(); i++) {
            Map.Entry g = this.f1663a.g(i);
            j8Var.c((i8) g.getKey(), g.getValue());
        }
        for (Map.Entry entry : this.f1663a.c()) {
            j8Var.c((i8) entry.getKey(), entry.getValue());
        }
        j8Var.f1665c = this.f1665c;
        return j8Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j8)) {
            return false;
        }
        return this.f1663a.equals(((j8) obj).f1663a);
    }

    public final int hashCode() {
        return this.f1663a.hashCode();
    }
}
