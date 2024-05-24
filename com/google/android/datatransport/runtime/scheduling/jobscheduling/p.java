package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.c0.a;

public class p implements y {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1996a;

    /* renamed from: b  reason: collision with root package name */
    private final j0 f1997b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f1998c;

    /* renamed from: d  reason: collision with root package name */
    private final t f1999d;

    /* renamed from: e  reason: collision with root package name */
    private final a f2000e;

    p(Context context, j0 j0Var, AlarmManager alarmManager, a aVar, t tVar) {
        this.f1996a = context;
        this.f1997b = j0Var;
        this.f1998c = alarmManager;
        this.f2000e = aVar;
        this.f1999d = tVar;
    }

    public p(Context context, j0 j0Var, a aVar, t tVar) {
        this(context, j0Var, (AlarmManager) context.getSystemService("alarm"), aVar, tVar);
    }

    public void a(c.d.a.a.i.p pVar, int i) {
        b(pVar, i, false);
    }

    public void b(c.d.a.a.i.p pVar, int i, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", pVar.b());
        builder.appendQueryParameter("priority", String.valueOf(c.d.a.a.i.d0.a.a(pVar.d())));
        if (pVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(pVar.c(), 0));
        }
        Intent intent = new Intent(this.f1996a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (z || !c(intent)) {
            long d2 = this.f1997b.d(pVar);
            long g = this.f1999d.g(pVar.d(), d2, i);
            c.d.a.a.i.y.a.c("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", pVar, Long.valueOf(g), Long.valueOf(d2), Integer.valueOf(i));
            this.f1998c.set(3, this.f2000e.a() + g, PendingIntent.getBroadcast(this.f1996a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            return;
        }
        c.d.a.a.i.y.a.b("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
    }

    /* access modifiers changed from: package-private */
    public boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f1996a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }
}
