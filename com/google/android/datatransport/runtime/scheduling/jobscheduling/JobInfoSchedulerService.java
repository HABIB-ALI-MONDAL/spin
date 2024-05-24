package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import c.d.a.a.i.d0.a;
import c.d.a.a.i.p;
import c.d.a.a.i.t;

public class JobInfoSchedulerService extends JobService {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        t.f(getApplicationContext());
        p.a a2 = p.a();
        a2.b(string);
        a2.d(a.b(i));
        if (string2 != null) {
            a2.c(Base64.decode(string2, 0));
        }
        t.c().e().v(a2.a(), i2, new c(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
