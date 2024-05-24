package c.d.a.b.e.e;

public final class fc implements ec {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1635a;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).a();
        a2.f("measurement.client.consent_state_v1", true);
        a2.f("measurement.client.3p_consent_state_v1", true);
        a2.f("measurement.service.consent_state_v1_W36", true);
        f1635a = a2.d("measurement.service.storage_consent_support_version", 203600);
    }

    public final long a() {
        return ((Long) f1635a.b()).longValue();
    }
}
