package c.d.a.b.e.e;

public final class hd implements gd {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1651a;

    /* renamed from: b  reason: collision with root package name */
    public static final q6 f1652b;

    /* renamed from: c  reason: collision with root package name */
    public static final q6 f1653c;

    /* renamed from: d  reason: collision with root package name */
    public static final q6 f1654d;

    /* renamed from: e  reason: collision with root package name */
    public static final q6 f1655e;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).a();
        f1651a = a2.f("measurement.test.boolean_flag", false);
        f1652b = a2.c("measurement.test.double_flag", -3.0d);
        f1653c = a2.d("measurement.test.int_flag", -2);
        f1654d = a2.d("measurement.test.long_flag", -1);
        f1655e = a2.e("measurement.test.string_flag", "---");
    }

    public final double a() {
        return ((Double) f1652b.b()).doubleValue();
    }

    public final long b() {
        return ((Long) f1653c.b()).longValue();
    }

    public final long c() {
        return ((Long) f1654d.b()).longValue();
    }

    public final String d() {
        return (String) f1655e.b();
    }

    public final boolean e() {
        return ((Boolean) f1651a.b()).booleanValue();
    }
}
