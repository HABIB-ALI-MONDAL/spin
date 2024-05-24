package c.d.a.b.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ b j;
    public final /* synthetic */ Intent k;
    public final /* synthetic */ Context l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ BroadcastReceiver.PendingResult n;

    public /* synthetic */ j(b bVar, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.j = bVar;
        this.k = intent;
        this.l = context;
        this.m = z;
        this.n = pendingResult;
    }

    public final void run() {
        this.j.d(this.k, this.l, this.m, this.n);
    }
}
