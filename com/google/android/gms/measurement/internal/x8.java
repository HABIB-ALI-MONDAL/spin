package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class x8 implements Runnable {
    public final /* synthetic */ b9 j;
    public final /* synthetic */ m3 k;
    public final /* synthetic */ JobParameters l;

    public /* synthetic */ x8(b9 b9Var, m3 m3Var, JobParameters jobParameters) {
        this.j = b9Var;
        this.k = m3Var;
        this.l = jobParameters;
    }

    public final void run() {
        this.j.d(this.k, this.l);
    }
}
