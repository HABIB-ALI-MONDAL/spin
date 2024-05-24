package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import java.util.regex.Pattern;

final class c1 {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f2903d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private final String f2904a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2905b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2906c;

    private c1(String str, String str2) {
        this.f2904a = d(str2, str);
        this.f2905b = str;
        this.f2906c = str + "!" + str2;
    }

    static c1 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new c1(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str != null && f2903d.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, "[a-zA-Z0-9-_.~%]{1,900}"}));
    }

    public static c1 f(String str) {
        return new c1("S", str);
    }

    public static c1 g(String str) {
        return new c1("U", str);
    }

    public String b() {
        return this.f2905b;
    }

    public String c() {
        return this.f2904a;
    }

    public String e() {
        return this.f2906c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f2904a.equals(c1Var.f2904a) && this.f2905b.equals(c1Var.f2905b);
    }

    public int hashCode() {
        return m.b(this.f2905b, this.f2904a);
    }
}
