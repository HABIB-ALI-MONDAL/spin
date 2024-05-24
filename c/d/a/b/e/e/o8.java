package c.d.a.b.e.e;

final class o8 implements v9 {

    /* renamed from: a  reason: collision with root package name */
    private static final o8 f1711a = new o8();

    private o8() {
    }

    public static o8 c() {
        return f1711a;
    }

    public final u9 a(Class cls) {
        Class<s8> cls2 = s8.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (u9) s8.C(cls.asSubclass(cls2)).D(3, (Object) null, (Object) null);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e2);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean b(Class cls) {
        return s8.class.isAssignableFrom(cls);
    }
}
