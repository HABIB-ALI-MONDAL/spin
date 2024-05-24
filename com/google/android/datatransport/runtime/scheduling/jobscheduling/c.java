package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ JobInfoSchedulerService j;
    public final /* synthetic */ JobParameters k;

    public /* synthetic */ c(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.j = jobInfoSchedulerService;
        this.k = jobParameters;
    }

    public final void run() {
        this.j.b(this.k);
    }
}
