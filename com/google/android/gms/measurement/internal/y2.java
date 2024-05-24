package com.google.android.gms.measurement.internal;

import android.content.Context;
import c.d.a.b.e.e.e6;
import c.d.a.b.e.e.t5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class y2 {
    public static final x2 A = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, j0.f2416a);
    public static final x2 B = a("measurement.upload.retry_time", 1800000L, 1800000L, k0.f2428a);
    public static final x2 C = a("measurement.upload.retry_count", 6, 6, m0.f2459a);
    public static final x2 D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, n0.f2477a);
    public static final x2 E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, o0.f2488a);
    public static final x2 F = a("measurement.audience.filter_result_max_count", 200, 200, q0.f2511a);
    public static final x2 G = a("measurement.upload.max_public_user_properties", 25, 25, (u2) null);
    public static final x2 H = a("measurement.upload.max_event_name_cardinality", 500, 500, (u2) null);
    public static final x2 I = a("measurement.upload.max_public_event_params", 25, 25, (u2) null);
    public static final x2 J = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, r0.f2522a);
    public static final x2 K;
    public static final x2 L = a("measurement.test.string_flag", "---", "---", t0.f2546a);
    public static final x2 M = a("measurement.test.long_flag", -1L, -1L, u0.f2554a);
    public static final x2 N = a("measurement.test.int_flag", -2, -2, v0.f2578a);
    public static final x2 O;
    public static final x2 P = a("measurement.experiment.max_ids", 50, 50, y0.f2635a);
    public static final x2 Q = a("measurement.max_bundles_per_iteration", 100, 100, z0.f2649a);
    public static final x2 R = a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, a1.f2303a);
    public static final x2 S = a("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, d1.f2349a);
    public static final x2 T;
    public static final x2 U;
    public static final x2 V;
    public static final x2 W;
    public static final x2 X;
    public static final x2 Y;
    public static final x2 Z;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List f2637a = Collections.synchronizedList(new ArrayList());
    public static final x2 a0;

    /* renamed from: b  reason: collision with root package name */
    public static final x2 f2638b = a("measurement.ad_id_cache_time", 10000L, 10000L, l0.f2443a);
    public static final x2 b0;

    /* renamed from: c  reason: collision with root package name */
    public static final x2 f2639c = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, d0.f2348a);
    public static final x2 c0;

    /* renamed from: d  reason: collision with root package name */
    public static final x2 f2640d = a("measurement.config.cache_time", 86400000L, 3600000L, p0.f2498a);
    public static final x2 d0;

    /* renamed from: e  reason: collision with root package name */
    public static final x2 f2641e = a("measurement.config.url_scheme", "https", "https", b1.f2313a);
    public static final x2 e0;

    /* renamed from: f  reason: collision with root package name */
    public static final x2 f2642f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", o1.f2489a);
    public static final x2 f0 = a("measurement.service.storage_consent_support_version", 203600, 203600, s1.f2535a);
    public static final x2 g = a("measurement.upload.max_bundles", 100, 100, a2.f2304a);
    public static final x2 g0;
    public static final x2 h = a("measurement.upload.max_batch_size", 65536, 65536, m2.f2461a);
    public static final x2 h0;
    public static final x2 i = a("measurement.upload.max_bundle_size", 65536, 65536, n2.f2479a);
    public static final x2 i0;
    public static final x2 j = a("measurement.upload.max_events_per_bundle", 1000, 1000, o2.f2490a);
    public static final x2 j0;
    public static final x2 k = a("measurement.upload.max_events_per_day", 100000, 100000, p2.f2500a);
    public static final x2 k0;
    public static final x2 l = a("measurement.upload.max_error_events_per_day", 1000, 1000, w0.f2596a);
    public static final x2 l0;
    public static final x2 m = a("measurement.upload.max_public_events_per_day", 50000, 50000, i1.f2410a);
    public static final x2 m0;
    public static final x2 n = a("measurement.upload.max_conversions_per_day", 10000, 10000, t1.f2547a);
    public static final x2 n0;
    public static final x2 o = a("measurement.upload.max_realtime_events_per_day", 10, 10, f2.f2376a);
    public static final x2 o0;
    public static final x2 p = a("measurement.store.max_stored_events_per_app", 100000, 100000, q2.f2513a);
    public static final x2 p0;
    public static final x2 q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", r2.f2524a);
    public static final x2 q0;
    public static final x2 r = a("measurement.upload.backoff_period", 43200000L, 43200000L, s2.f2536a);
    public static final x2 r0;
    public static final x2 s = a("measurement.upload.window_interval", 3600000L, 3600000L, t2.f2548a);
    public static final x2 t = a("measurement.upload.interval", 3600000L, 3600000L, a0.f2302a);
    public static final x2 u = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, c0.f2332a);
    public static final x2 v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, e0.f2361a);
    public static final x2 w = a("measurement.upload.minimum_delay", 500L, 500L, f0.f2374a);
    public static final x2 x = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, g0.f2381a);
    public static final x2 y = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, h0.f2389a);
    public static final x2 z = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, i0.f2409a);

    static {
        Collections.synchronizedSet(new HashSet());
        Boolean bool = Boolean.FALSE;
        K = a("measurement.test.boolean_flag", bool, bool, s0.f2534a);
        Double valueOf = Double.valueOf(-3.0d);
        O = a("measurement.test.double_flag", valueOf, valueOf, x0.f2613a);
        Boolean bool2 = Boolean.TRUE;
        T = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, e1.f2362a);
        U = a("measurement.quality.checksum", bool, bool, (u2) null);
        V = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, f1.f2375a);
        W = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, g1.f2382a);
        X = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, h1.f2390a);
        Y = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, j1.f2417a);
        Z = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, k1.f2429a);
        a0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, l1.f2444a);
        b0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, m1.f2460a);
        c0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, n1.f2478a);
        d0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, p1.f2499a);
        e0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, q1.f2512a);
        a("measurement.collection.synthetic_data_mitigation", bool, bool, r1.f2523a);
        a("measurement.client.click_identifier_control.dev", bool, bool, u1.f2555a);
        a("measurement.service.click_identifier_control", bool, bool, v1.f2579a);
        g0 = a("measurement.service.store_null_safelist", bool2, bool2, w1.f2597a);
        h0 = a("measurement.service.store_safelist", bool2, bool2, x1.f2614a);
        a("measurement.collection.enable_session_stitching_token.service", bool, bool, y1.f2636a);
        i0 = a("measurement.collection.enable_session_stitching_token.service_new", bool2, bool2, z1.f2650a);
        j0 = a("measurement.collection.enable_session_stitching_token.client.dev", bool2, bool2, b2.f2314a);
        k0 = a("measurement.session_stitching_token_enabled", bool, bool, c2.f2333a);
        l0 = a("measurement.redaction.e_tag", bool2, bool2, e2.f2363a);
        m0 = a("measurement.redaction.client_ephemeral_aiid_generation", bool2, bool2, g2.f2383a);
        n0 = a("measurement.redaction.retain_major_os_version", bool2, bool2, h2.f2391a);
        o0 = a("measurement.redaction.scion_payload_generator", bool2, bool2, i2.f2411a);
        p0 = a("measurement.audience.dynamic_filters.oob_fix", bool2, bool2, j2.f2418a);
        q0 = a("measurement.service.clear_global_params_on_uninstall", bool2, bool2, k2.f2430a);
        r0 = a("measurement.sessionid.enable_client_session_id", bool2, bool2, l2.f2445a);
    }

    static x2 a(String str, Object obj, Object obj2, u2 u2Var) {
        x2 x2Var = new x2(str, obj, obj2, u2Var, (w2) null);
        f2637a.add(x2Var);
        return x2Var;
    }

    public static Map c(Context context) {
        t5 b2 = t5.b(context.getContentResolver(), e6.a("com.google.android.gms.measurement"), z.j);
        return b2 == null ? Collections.emptyMap() : b2.c();
    }
}
