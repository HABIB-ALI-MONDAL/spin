package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c.d.a.b.c.d;
import c.d.a.b.h.l;
import com.google.firebase.h;
import com.google.firebase.installations.m;
import com.google.firebase.n.k;
import com.google.firebase.o.b;
import com.google.firebase.q.i;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final h f2985a;

    /* renamed from: b  reason: collision with root package name */
    private final p0 f2986b;

    /* renamed from: c  reason: collision with root package name */
    private final d f2987c;

    /* renamed from: d  reason: collision with root package name */
    private final b<i> f2988d;

    /* renamed from: e  reason: collision with root package name */
    private final b<k> f2989e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.installations.i f2990f;

    m0(h hVar, p0 p0Var, d dVar, b<i> bVar, b<k> bVar2, com.google.firebase.installations.i iVar) {
        this.f2985a = hVar;
        this.f2986b = p0Var;
        this.f2987c = dVar;
        this.f2988d = bVar;
        this.f2989e = bVar2;
        this.f2990f = iVar;
    }

    m0(h hVar, p0 p0Var, b<i> bVar, b<k> bVar2, com.google.firebase.installations.i iVar) {
        this(hVar, p0Var, new d(hVar.h()), bVar, bVar2, iVar);
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private c.d.a.b.h.i<String> b(c.d.a.b.h.i<Bundle> iVar) {
        return iVar.f(u.f3002a, new s(this));
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(this.f2985a.j().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String e(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static boolean f(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ String h(c.d.a.b.h.i iVar) {
        return e((Bundle) iVar.j(IOException.class));
    }

    private void i(String str, String str2, Bundle bundle) {
        k.a b2;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f2985a.k().c());
        bundle.putString("gmsv", Integer.toString(this.f2986b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f2986b.a());
        bundle.putString("app_ver_name", this.f2986b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String b3 = ((m) l.a(this.f2990f.b(false))).b();
            if (!TextUtils.isEmpty(b3)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b3);
            } else {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e2);
        }
        bundle.putString("appid", (String) l.a(this.f2990f.a()));
        bundle.putString("cliv", "fcm-" + "23.1.1");
        k kVar = this.f2989e.get();
        i iVar = this.f2988d.get();
        if (kVar != null && iVar != null && (b2 = kVar.b("fire-iid")) != k.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(b2.d()));
            bundle.putString("Firebase-Client", iVar.a());
        }
    }

    private c.d.a.b.h.i<Bundle> j(String str, String str2, Bundle bundle) {
        try {
            i(str, str2, bundle);
            return this.f2987c.a(bundle);
        } catch (InterruptedException | ExecutionException e2) {
            return l.d(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public c.d.a.b.h.i<String> d() {
        return b(j(p0.c(this.f2985a), "*", new Bundle()));
    }

    /* access modifiers changed from: package-private */
    public c.d.a.b.h.i<?> k(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return b(j(str, "/topics/" + str2, bundle));
    }

    /* access modifiers changed from: package-private */
    public c.d.a.b.h.i<?> l(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return b(j(str, "/topics/" + str2, bundle));
    }
}
