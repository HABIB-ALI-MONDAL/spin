package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class a1 {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f2894a;

    static class a {

        /* renamed from: d  reason: collision with root package name */
        private static final long f2895d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f2896a;

        /* renamed from: b  reason: collision with root package name */
        final String f2897b;

        /* renamed from: c  reason: collision with root package name */
        final long f2898c;

        private a(String str, String str2, long j) {
            this.f2896a = str;
            this.f2897b = str2;
            this.f2898c = j;
        }

        static String a(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j);
                return jSONObject.toString();
            } catch (JSONException e2) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e2);
                return null;
            }
        }

        static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e2);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(String str) {
            return System.currentTimeMillis() > this.f2898c + f2895d || !str.equals(this.f2897b);
        }
    }

    public a1(Context context) {
        this.f2894a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(androidx.core.content.a.i(context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !e()) {
                    Log.i("FirebaseMessaging", "App restored, clearing state");
                    c();
                }
            } catch (IOException e2) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e2.getMessage());
                }
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|" + "*";
    }

    public synchronized void c() {
        this.f2894a.edit().clear().commit();
    }

    public synchronized a d(String str, String str2) {
        return a.c(this.f2894a.getString(b(str, str2), (String) null));
    }

    public synchronized boolean e() {
        return this.f2894a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String a2 = a.a(str3, str4, System.currentTimeMillis());
        if (a2 != null) {
            SharedPreferences.Editor edit = this.f2894a.edit();
            edit.putString(b(str, str2), a2);
            edit.commit();
        }
    }
}
