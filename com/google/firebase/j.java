package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.m;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f2828a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2829b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2830c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2831d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2832e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2833f;
    private final String g;

    private j(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        n.m(!m.a(str), "ApplicationId must be set.");
        this.f2829b = str;
        this.f2828a = str2;
        this.f2830c = str3;
        this.f2831d = str4;
        this.f2832e = str5;
        this.f2833f = str6;
        this.g = str7;
    }

    public static j a(Context context) {
        q qVar = new q(context);
        String a2 = qVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new j(a2, qVar.a("google_api_key"), qVar.a("firebase_database_url"), qVar.a("ga_trackingId"), qVar.a("gcm_defaultSenderId"), qVar.a("google_storage_bucket"), qVar.a("project_id"));
    }

    public String b() {
        return this.f2828a;
    }

    public String c() {
        return this.f2829b;
    }

    public String d() {
        return this.f2832e;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return com.google.android.gms.common.internal.m.a(this.f2829b, jVar.f2829b) && com.google.android.gms.common.internal.m.a(this.f2828a, jVar.f2828a) && com.google.android.gms.common.internal.m.a(this.f2830c, jVar.f2830c) && com.google.android.gms.common.internal.m.a(this.f2831d, jVar.f2831d) && com.google.android.gms.common.internal.m.a(this.f2832e, jVar.f2832e) && com.google.android.gms.common.internal.m.a(this.f2833f, jVar.f2833f) && com.google.android.gms.common.internal.m.a(this.g, jVar.g);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.m.b(this.f2829b, this.f2828a, this.f2830c, this.f2831d, this.f2832e, this.f2833f, this.g);
    }

    public String toString() {
        m.a c2 = com.google.android.gms.common.internal.m.c(this);
        c2.a("applicationId", this.f2829b);
        c2.a("apiKey", this.f2828a);
        c2.a("databaseUrl", this.f2830c);
        c2.a("gcmSenderId", this.f2832e);
        c2.a("storageBucket", this.f2833f);
        c2.a("projectId", this.g);
        return c2.toString();
    }
}
