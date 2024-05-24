package c.d.a.b.e.e;

public final class yc implements xc {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1785a;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).b().a();
        a2.f("measurement.client.global_params", true);
        a2.f("measurement.service.global_params_in_payload", true);
        f1785a = a2.f("measurement.service.clear_global_params_on_uninstall", true);
        a2.f("measurement.service.global_params", true);
        a2.d("measurement.id.service.global_params", 0);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return ((Boolean) f1785a.b()).booleanValue();
    }
}
