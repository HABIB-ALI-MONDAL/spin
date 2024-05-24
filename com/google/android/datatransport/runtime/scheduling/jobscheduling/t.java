package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import c.d.a.a.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
public abstract class t {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private c.d.a.a.i.c0.a f2012a;

        /* renamed from: b  reason: collision with root package name */
        private Map<d, b> f2013b = new HashMap();

        public a a(d dVar, b bVar) {
            this.f2013b.put(dVar, bVar);
            return this;
        }

        public t b() {
            Objects.requireNonNull(this.f2012a, "missing required property: clock");
            if (this.f2013b.keySet().size() >= d.values().length) {
                Map<d, b> map = this.f2013b;
                this.f2013b = new HashMap();
                return t.d(this.f2012a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public a c(c.d.a.a.i.c0.a aVar) {
            this.f2012a = aVar;
            return this;
        }
    }

    @AutoValue
    public static abstract class b {

        @AutoValue.Builder
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j);

            public abstract a c(Set<c> set);

            public abstract a d(long j);
        }

        public static a a() {
            r.b bVar = new r.b();
            bVar.c(Collections.emptySet());
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set<c> c();

        /* access modifiers changed from: package-private */
        public abstract long d();
    }

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i, long j) {
        int i2 = i - 1;
        double max = Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((j > 1 ? j : 2) * ((long) i2))));
        double pow = Math.pow(3.0d, (double) i2);
        double d2 = (double) j;
        Double.isNaN(d2);
        return (long) (pow * d2 * max);
    }

    public static a b() {
        return new a();
    }

    static t d(c.d.a.a.i.c0.a aVar, Map<d, b> map) {
        return new q(aVar, map);
    }

    public static t f(c.d.a.a.i.c0.a aVar) {
        a b2 = b();
        d dVar = d.DEFAULT;
        b.a a2 = b.a();
        a2.b(30000);
        a2.d(86400000);
        b2.a(dVar, a2.a());
        d dVar2 = d.HIGHEST;
        b.a a3 = b.a();
        a3.b(1000);
        a3.d(86400000);
        b2.a(dVar2, a3.a());
        d dVar3 = d.VERY_LOW;
        b.a a4 = b.a();
        a4.b(86400000);
        a4.d(86400000);
        a4.c(i(c.DEVICE_IDLE));
        b2.a(dVar3, a4.a());
        b2.c(aVar);
        return b2.b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void j(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, d dVar, long j, int i) {
        builder.setMinimumLatency(g(dVar, j, i));
        j(builder, h().get(dVar).c());
        return builder;
    }

    /* access modifiers changed from: package-private */
    public abstract c.d.a.a.i.c0.a e();

    public long g(d dVar, long j, int i) {
        long a2 = j - e().a();
        b bVar = h().get(dVar);
        return Math.min(Math.max(a(i, bVar.b()), a2), bVar.d());
    }

    /* access modifiers changed from: package-private */
    public abstract Map<d, b> h();
}
