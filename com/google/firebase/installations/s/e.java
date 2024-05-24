package com.google.firebase.installations.s;

import com.google.firebase.installations.p;
import java.util.concurrent.TimeUnit;

class e {

    /* renamed from: d  reason: collision with root package name */
    private static final long f2822d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f2823e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final p f2824a = p.c();

    /* renamed from: b  reason: collision with root package name */
    private long f2825b;

    /* renamed from: c  reason: collision with root package name */
    private int f2826c;

    e() {
    }

    private synchronized long a(int i) {
        if (!c(i)) {
            return f2822d;
        }
        double pow = Math.pow(2.0d, (double) this.f2826c);
        double e2 = (double) this.f2824a.e();
        Double.isNaN(e2);
        return (long) Math.min(pow + e2, (double) f2823e);
    }

    private static boolean c(int i) {
        return i == 429 || (i >= 500 && i < 600);
    }

    private static boolean d(int i) {
        return (i >= 200 && i < 300) || i == 401 || i == 404;
    }

    private synchronized void e() {
        this.f2826c = 0;
    }

    public synchronized boolean b() {
        return this.f2826c == 0 || this.f2824a.a() > this.f2825b;
    }

    public synchronized void f(int i) {
        if (d(i)) {
            e();
            return;
        }
        this.f2826c++;
        this.f2825b = this.f2824a.a() + a(i);
    }
}
