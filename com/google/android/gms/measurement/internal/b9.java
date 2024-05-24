package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import c.d.a.b.e.e.n1;
import com.google.android.gms.common.internal.n;

public final class b9 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2329a;

    public b9(Context context) {
        n.i(context);
        this.f2329a = context;
    }

    private final m3 k() {
        return x4.H(this.f2329a, (n1) null, (Long) null).f();
    }

    public final int a(Intent intent, int i, int i2) {
        x4 H = x4.H(this.f2329a, (n1) null, (Long) null);
        m3 f2 = H.f();
        if (intent == null) {
            f2.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        H.e();
        f2.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            h(new y8(this, i2, f2, intent));
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new q5(ca.e0(this.f2329a), (String) null);
        }
        k().w().b("onBind received unknown action", action);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(int i, m3 m3Var, Intent intent) {
        if (((a9) this.f2329a).b(i)) {
            m3Var.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            k().v().a("Completed wakeful intent.");
            ((a9) this.f2329a).a(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(m3 m3Var, JobParameters jobParameters) {
        m3Var.v().a("AppMeasurementJobService processed last upload request.");
        ((a9) this.f2329a).c(jobParameters, false);
    }

    public final void e() {
        x4 H = x4.H(this.f2329a, (n1) null, (Long) null);
        m3 f2 = H.f();
        H.e();
        f2.v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        x4 H = x4.H(this.f2329a, (n1) null, (Long) null);
        m3 f2 = H.f();
        H.e();
        f2.v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
            return;
        }
        k().v().b("onRebind called. action", intent.getAction());
    }

    public final void h(Runnable runnable) {
        ca e0 = ca.e0(this.f2329a);
        e0.c().z(new z8(this, e0, runnable));
    }

    @TargetApi(24)
    public final boolean i(JobParameters jobParameters) {
        x4 H = x4.H(this.f2329a, (n1) null, (Long) null);
        m3 f2 = H.f();
        String string = jobParameters.getExtras().getString("action");
        H.e();
        f2.v().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        h(new x8(this, f2, jobParameters));
        return true;
    }

    public final boolean j(Intent intent) {
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return true;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
