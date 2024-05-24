package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.g0;
import java.util.Map;

public final class u0 extends com.google.android.gms.common.internal.v.a {
    public static final Parcelable.Creator<u0> CREATOR = new v0();
    Bundle j;
    private Map<String, String> k;
    private b l;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f3003a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3004b;

        private b(q0 q0Var) {
            this.f3003a = q0Var.p("gcm.n.title");
            q0Var.h("gcm.n.title");
            b(q0Var, "gcm.n.title");
            this.f3004b = q0Var.p("gcm.n.body");
            q0Var.h("gcm.n.body");
            b(q0Var, "gcm.n.body");
            q0Var.p("gcm.n.icon");
            q0Var.o();
            q0Var.p("gcm.n.tag");
            q0Var.p("gcm.n.color");
            q0Var.p("gcm.n.click_action");
            q0Var.p("gcm.n.android_channel_id");
            q0Var.f();
            q0Var.p("gcm.n.image");
            q0Var.p("gcm.n.ticker");
            q0Var.b("gcm.n.notification_priority");
            q0Var.b("gcm.n.visibility");
            q0Var.b("gcm.n.notification_count");
            q0Var.a("gcm.n.sticky");
            q0Var.a("gcm.n.local_only");
            q0Var.a("gcm.n.default_sound");
            q0Var.a("gcm.n.default_vibrate_timings");
            q0Var.a("gcm.n.default_light_settings");
            q0Var.j("gcm.n.event_time");
            q0Var.e();
            q0Var.q();
        }

        private static String[] b(q0 q0Var, String str) {
            Object[] g = q0Var.g(str);
            if (g == null) {
                return null;
            }
            String[] strArr = new String[g.length];
            for (int i = 0; i < g.length; i++) {
                strArr[i] = String.valueOf(g[i]);
            }
            return strArr;
        }

        public String a() {
            return this.f3004b;
        }

        public String c() {
            return this.f3003a;
        }
    }

    public u0(Bundle bundle) {
        this.j = bundle;
    }

    public Map<String, String> g() {
        if (this.k == null) {
            this.k = g0.a.a(this.j);
        }
        return this.k;
    }

    public String i() {
        return this.j.getString("from");
    }

    public b j() {
        if (this.l == null && q0.t(this.j)) {
            this.l = new b(new q0(this.j));
        }
        return this.l;
    }

    public void writeToParcel(Parcel parcel, int i) {
        v0.c(this, parcel, i);
    }
}
