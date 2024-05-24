package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.r.d;
import com.google.firebase.installations.t.a;
import com.google.firebase.installations.t.b;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class p {

    /* renamed from: b  reason: collision with root package name */
    public static final long f2780b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f2781c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d  reason: collision with root package name */
    private static p f2782d;

    /* renamed from: a  reason: collision with root package name */
    private final a f2783a;

    private p(a aVar) {
        this.f2783a = aVar;
    }

    public static p c() {
        return d(b.b());
    }

    public static p d(a aVar) {
        if (f2782d == null) {
            f2782d = new p(aVar);
        }
        return f2782d;
    }

    static boolean g(String str) {
        return f2781c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f2783a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f2780b;
    }
}
