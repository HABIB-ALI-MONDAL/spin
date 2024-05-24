package c.d.a.b.e.e;

public final class ed implements dd {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1628a;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).a();
        a2.d("measurement.id.lifecycle.app_in_background_parameter", 0);
        a2.f("measurement.lifecycle.app_backgrounded_tracking", true);
        f1628a = a2.f("measurement.lifecycle.app_in_background_parameter", false);
        a2.d("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean a() {
        return ((Boolean) f1628a.b()).booleanValue();
    }
}
