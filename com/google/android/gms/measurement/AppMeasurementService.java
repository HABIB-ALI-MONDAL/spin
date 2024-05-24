package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import b.i.a.a;
import com.google.android.gms.measurement.internal.a9;
import com.google.android.gms.measurement.internal.b9;

public final class AppMeasurementService extends Service implements a9 {
    private b9 j;

    private final b9 d() {
        if (this.j == null) {
            this.j = new b9(this);
        }
        return this.j;
    }

    public final void a(Intent intent) {
        a.b(intent);
    }

    public final boolean b(int i) {
        return stopSelfResult(i);
    }

    public final void c(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public IBinder onBind(Intent intent) {
        return d().b(intent);
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

    public int onStartCommand(Intent intent, int i, int i2) {
        d().a(intent, i, i2);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
