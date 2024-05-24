package c.d.a.b.e.e;

public final class pc implements oc {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1719a;

    /* renamed from: b  reason: collision with root package name */
    public static final q6 f1720b;

    /* renamed from: c  reason: collision with root package name */
    public static final q6 f1721c;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).a();
        a2.f("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f1719a = a2.f("measurement.audience.refresh_event_count_filters_timestamp", false);
        f1720b = a2.f("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f1721c = a2.f("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return ((Boolean) f1719a.b()).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) f1720b.b()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) f1721c.b()).booleanValue();
    }
}
