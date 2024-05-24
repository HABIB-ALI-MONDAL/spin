package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;

public class q0 {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f2998a;

    public q0(Bundle bundle) {
        Objects.requireNonNull(bundle, "data");
        this.f2998a = new Bundle(bundle);
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        return str.startsWith("google.c.a.") || str.equals("from");
    }

    public static boolean t(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")));
    }

    private static boolean u(String str) {
        return str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.");
    }

    private static String v(String str) {
        return !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f2998a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v = v(str);
            if (this.f2998a.containsKey(v)) {
                return v;
            }
        }
        return str;
    }

    private static String z(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public boolean a(String str) {
        String p = p(str);
        return "1".equals(p) || Boolean.parseBoolean(p);
    }

    public Integer b(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p + ") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return new JSONArray(p);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + z(str) + ": " + p + ", falling back to default");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] e() {
        String str;
        JSONArray c2 = c("gcm.n.light_settings");
        if (c2 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c2.length() == 3) {
                iArr[0] = d(c2.optString(0));
                iArr[1] = c2.optInt(1);
                iArr[2] = c2.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            str = "LightSettings is invalid: " + c2 + ". Skipping setting LightSettings";
            Log.w("NotificationParams", str);
            return null;
        } catch (IllegalArgumentException e2) {
            str = "LightSettings is invalid: " + c2 + ". " + e2.getMessage() + ". Skipping setting LightSettings";
            Log.w("NotificationParams", str);
            return null;
        }
    }

    public Uri f() {
        String p = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p)) {
            p = p("gcm.n.link");
        }
        if (!TextUtils.isEmpty(p)) {
            return Uri.parse(p);
        }
        return null;
    }

    public Object[] g(String str) {
        JSONArray c2 = c(str + "_loc_args");
        if (c2 == null) {
            return null;
        }
        int length = c2.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = c2.optString(i);
        }
        return strArr;
    }

    public String h(String str) {
        return p(str + "_loc_key");
    }

    public String i(Resources resources, String str, String str2) {
        String h = h(str2);
        if (TextUtils.isEmpty(h)) {
            return null;
        }
        int identifier = resources.getIdentifier(h, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", z(str2 + "_loc_key") + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] g = g(str2);
        if (g == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g);
        } catch (MissingFormatArgumentException e2) {
            Log.w("NotificationParams", "Missing format argument for " + z(str2) + ": " + Arrays.toString(g) + " Default value will be used.", e2);
            return null;
        }
    }

    public Long j(String str) {
        String p = p(str);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p + ") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* access modifiers changed from: package-private */
    public Integer l() {
        Integer b2 = b("gcm.n.notification_count");
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= 0) {
            return b2;
        }
        Log.w("FirebaseMessaging", "notificationCount is invalid: " + b2 + ". Skipping setting notificationCount.");
        return null;
    }

    /* access modifiers changed from: package-private */
    public Integer m() {
        Integer b2 = b("gcm.n.notification_priority");
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= -2 && b2.intValue() <= 2) {
            return b2;
        }
        Log.w("FirebaseMessaging", "notificationPriority is invalid " + b2 + ". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p = p(str2);
        return !TextUtils.isEmpty(p) ? p : i(resources, str, str2);
    }

    public String o() {
        String p = p("gcm.n.sound2");
        return TextUtils.isEmpty(p) ? p("gcm.n.sound") : p;
    }

    public String p(String str) {
        return this.f2998a.getString(w(str));
    }

    public long[] q() {
        JSONArray c2 = c("gcm.n.vibrate_timings");
        if (c2 == null) {
            return null;
        }
        try {
            if (c2.length() > 1) {
                int length = c2.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = c2.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + c2 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer r() {
        Integer b2 = b("gcm.n.visibility");
        if (b2 == null) {
            return null;
        }
        if (b2.intValue() >= -1 && b2.intValue() <= 1) {
            return b2;
        }
        Log.w("NotificationParams", "visibility is invalid: " + b2 + ". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f2998a);
        for (String str : this.f2998a.keySet()) {
            if (!s(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f2998a);
        for (String str : this.f2998a.keySet()) {
            if (u(str)) {
                bundle.remove(str);
            }
        }
        return bundle;
    }
}
