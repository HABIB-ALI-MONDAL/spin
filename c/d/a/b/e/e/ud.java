package c.d.a.b.e.e;

public final class ud implements td {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1765a;

    /* renamed from: b  reason: collision with root package name */
    public static final q6 f1766b;

    /* renamed from: c  reason: collision with root package name */
    public static final q6 f1767c;

    /* renamed from: d  reason: collision with root package name */
    public static final q6 f1768d;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).b().a();
        f1765a = a2.f("measurement.collection.enable_session_stitching_token.client.dev", true);
        f1766b = a2.f("measurement.session_stitching_token_enabled", false);
        f1767c = a2.f("measurement.collection.enable_session_stitching_token.service", false);
        f1768d = a2.f("measurement.collection.enable_session_stitching_token.service_new", true);
        a2.d("measurement.id.collection.enable_session_stitching_token.client.dev", 0);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return ((Boolean) f1765a.b()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f1766b.b()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f1767c.b()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f1768d.b()).booleanValue();
    }
}
