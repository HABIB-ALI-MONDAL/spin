package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.d0.a;
import c.d.a.a.i.p;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

public class s implements y {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2009a;

    /* renamed from: b  reason: collision with root package name */
    private final j0 f2010b;

    /* renamed from: c  reason: collision with root package name */
    private final t f2011c;

    public s(Context context, j0 j0Var, t tVar) {
        this.f2009a = context;
        this.f2010b = j0Var;
        this.f2011c = tVar;
    }

    private boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            int i3 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    public void a(p pVar, int i) {
        b(pVar, i, false);
    }

    public void b(p pVar, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.f2009a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f2009a.getSystemService("jobscheduler");
        int c2 = c(pVar);
        if (z || !d(jobScheduler, c2, i)) {
            long d2 = this.f2010b.d(pVar);
            t tVar = this.f2011c;
            JobInfo.Builder builder = new JobInfo.Builder(c2, componentName);
            tVar.c(builder, pVar.d(), d2, i);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", pVar.b());
            persistableBundle.putInt("priority", a.a(pVar.d()));
            if (pVar.c() != null) {
                persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
            }
            builder.setExtras(persistableBundle);
            c.d.a.a.i.y.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c2), Long.valueOf(this.f2011c.g(pVar.d(), d2, i)), Long.valueOf(d2), Integer.valueOf(i));
            jobScheduler.schedule(builder.build());
            return;
        }
        c.d.a.a.i.y.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
    }

    /* access modifiers changed from: package-private */
    public int c(p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f2009a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }
}
