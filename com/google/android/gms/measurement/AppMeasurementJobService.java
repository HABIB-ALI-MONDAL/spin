package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.a9;
import com.google.android.gms.measurement.internal.b9;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements a9 {
    private b9 j;

    private final b9 d() {
        if (this.j == null) {
            this.j = new b9(this);
        }
        return this.j;
    }

    public final void a(Intent intent) {
    }

    public final boolean b(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void c(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public void onCreate() {
        super.onCreate();
        d().e();
    }

    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        d().g(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        d().i(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
