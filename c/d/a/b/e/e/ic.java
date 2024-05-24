package c.d.a.b.e.e;

public final class ic implements hc {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1659a;

    /* renamed from: b  reason: collision with root package name */
    public static final q6 f1660b;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).b().a();
        a2.f("measurement.collection.event_safelist", true);
        f1659a = a2.f("measurement.service.store_null_safelist", true);
        f1660b = a2.f("measurement.service.store_safelist", true);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return ((Boolean) f1659a.b()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f1660b.b()).booleanValue();
    }
}
