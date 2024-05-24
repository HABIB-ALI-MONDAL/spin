package c.d.a.b.e.e;

public final class nd implements md {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1698a;

    /* renamed from: b  reason: collision with root package name */
    public static final q6 f1699b;

    /* renamed from: c  reason: collision with root package name */
    public static final q6 f1700c;

    /* renamed from: d  reason: collision with root package name */
    public static final q6 f1701d;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).b().a();
        a2.f("measurement.redaction.app_instance_id", true);
        f1698a = a2.f("measurement.redaction.client_ephemeral_aiid_generation", true);
        a2.f("measurement.redaction.config_redacted_fields", true);
        a2.f("measurement.redaction.device_info", true);
        f1699b = a2.f("measurement.redaction.e_tag", true);
        a2.f("measurement.redaction.enhanced_uid", true);
        a2.f("measurement.redaction.populate_ephemeral_app_instance_id", true);
        a2.f("measurement.redaction.google_signals", true);
        a2.f("measurement.redaction.no_aiid_in_config_request", true);
        f1700c = a2.f("measurement.redaction.retain_major_os_version", true);
        f1701d = a2.f("measurement.redaction.scion_payload_generator", true);
        a2.f("measurement.redaction.upload_redacted_fields", true);
        a2.f("measurement.redaction.upload_subdomain_override", true);
        a2.f("measurement.redaction.user_id", true);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return ((Boolean) f1698a.b()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f1699b.b()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f1700c.b()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f1701d.b()).booleanValue();
    }
}
