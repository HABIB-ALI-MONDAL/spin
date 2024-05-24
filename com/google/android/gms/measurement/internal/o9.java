package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import c.d.a.b.e.e.u0;
import c.d.a.b.e.e.v0;

public final class o9 extends q9 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f2493d = ((AlarmManager) this.f2527a.d().getSystemService("alarm"));

    /* renamed from: e  reason: collision with root package name */
    private q f2494e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f2495f;

    protected o9(ca caVar) {
        super(caVar);
    }

    private final int o() {
        if (this.f2495f == null) {
            this.f2495f = Integer.valueOf("measurement".concat(String.valueOf(this.f2527a.d().getPackageName())).hashCode());
        }
        return this.f2495f.intValue();
    }

    private final PendingIntent p() {
        Context d2 = this.f2527a.d();
        return PendingIntent.getBroadcast(d2, 0, new Intent().setClassName(d2, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), u0.f1764a);
    }

    private final q q() {
        if (this.f2494e == null) {
            this.f2494e = new n9(this, this.f2504b.b0());
        }
        return this.f2494e;
    }

    @TargetApi(24)
    private final void r() {
        JobScheduler jobScheduler = (JobScheduler) this.f2527a.d().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        AlarmManager alarmManager = this.f2493d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        r();
        return false;
    }

    public final void m() {
        i();
        this.f2527a.f().v().a("Unscheduling upload");
        AlarmManager alarmManager = this.f2493d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        q().b();
        if (Build.VERSION.SDK_INT >= 24) {
            r();
        }
    }

    public final void n(long j) {
        i();
        this.f2527a.e();
        Context d2 = this.f2527a.d();
        if (!la.Y(d2)) {
            this.f2527a.f().q().a("Receiver not registered/enabled");
        }
        if (!la.Z(d2, false)) {
            this.f2527a.f().q().a("Service not registered/enabled");
        }
        m();
        this.f2527a.f().v().b("Scheduling upload, millis", Long.valueOf(j));
        long b2 = this.f2527a.a().b() + j;
        this.f2527a.z();
        if (j < Math.max(0, ((Long) y2.x.a((Object) null)).longValue()) && !q().e()) {
            q().d(j);
        }
        this.f2527a.e();
        if (Build.VERSION.SDK_INT >= 24) {
            Context d3 = this.f2527a.d();
            ComponentName componentName = new ComponentName(d3, "com.google.android.gms.measurement.AppMeasurementJobService");
            int o = o();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            v0.a(d3, new JobInfo.Builder(o, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        AlarmManager alarmManager = this.f2493d;
        if (alarmManager != null) {
            this.f2527a.z();
            alarmManager.setInexactRepeating(2, b2, Math.max(((Long) y2.s.a((Object) null)).longValue(), j), p());
        }
    }
}
