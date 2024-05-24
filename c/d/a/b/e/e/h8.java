package c.d.a.b.e.e;

final class h8 {

    /* renamed from: a  reason: collision with root package name */
    private static final f8 f1645a = new g8();

    /* renamed from: b  reason: collision with root package name */
    private static final f8 f1646b;

    static {
        f8 f8Var;
        try {
            f8Var = (f8) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            f8Var = null;
        }
        f1646b = f8Var;
    }

    static f8 a() {
        f8 f8Var = f1646b;
        if (f8Var != null) {
            return f8Var;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static f8 b() {
        return f1645a;
    }
}
