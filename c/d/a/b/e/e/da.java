package c.d.a.b.e.e;

final class da {

    /* renamed from: a  reason: collision with root package name */
    private static final ca f1620a;

    /* renamed from: b  reason: collision with root package name */
    private static final ca f1621b = new ca();

    static {
        ca caVar;
        try {
            caVar = (ca) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            caVar = null;
        }
        f1620a = caVar;
    }

    static ca a() {
        return f1620a;
    }

    static ca b() {
        return f1621b;
    }
}
