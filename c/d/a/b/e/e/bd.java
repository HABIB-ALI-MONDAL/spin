package c.d.a.b.e.e;

public final class bd implements ad {

    /* renamed from: a  reason: collision with root package name */
    public static final q6 f1596a;

    static {
        m6 a2 = new m6(e6.a("com.google.android.gms.measurement")).a();
        a2.f("measurement.sdk.collection.enable_extend_user_property_size", true);
        a2.f("measurement.sdk.collection.last_deep_link_referrer2", true);
        f1596a = a2.f("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        a2.d("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean a() {
        return ((Boolean) f1596a.b()).booleanValue();
    }
}
