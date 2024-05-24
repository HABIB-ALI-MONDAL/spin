package c.d.a.b.e.e;

final class t9 {

    /* renamed from: a  reason: collision with root package name */
    private static final s9 f1762a;

    /* renamed from: b  reason: collision with root package name */
    private static final s9 f1763b = new s9();

    static {
        s9 s9Var;
        try {
            s9Var = (s9) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            s9Var = null;
        }
        f1762a = s9Var;
    }

    static s9 a() {
        return f1762a;
    }

    static s9 b() {
        return f1763b;
    }
}
