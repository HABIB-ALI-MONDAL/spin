package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import c.d.a.b.h.l;
import com.google.firebase.messaging.h1;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class i0 extends Service {
    private static final String TAG = "EnhancedIntentService";
    private Binder binder;
    final ExecutorService executor = k0.d();
    private int lastStartId;
    private final Object lock = new Object();
    private int runningTasks = 0;

    class a implements h1.a {
        a() {
        }

        public i<Void> a(Intent intent) {
            return i0.this.processIntent(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(Intent intent, i iVar) {
        finishTask(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(Intent intent, j jVar) {
        try {
            handleIntent(intent);
        } finally {
            jVar.c(null);
        }
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            g1.b(intent);
        }
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* access modifiers changed from: private */
    public i<Void> processIntent(Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return l.e(null);
        }
        j jVar = new j();
        this.executor.execute(new c(this, intent, jVar));
        return jVar.a();
    }

    /* access modifiers changed from: protected */
    public abstract Intent getStartCommandIntent(Intent intent);

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Service received bind request");
        }
        if (this.binder == null) {
            this.binder = new h1(new a());
        }
        return this.binder;
    }

    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.lastStartId = i2;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        i<Void> processIntent = processIntent(startCommandIntent);
        if (processIntent.l()) {
            finishTask(intent);
            return 2;
        }
        processIntent.c(u.f3002a, new b(this, intent));
        return 3;
    }

    /* access modifiers changed from: package-private */
    public boolean stopSelfResultHook(int i) {
        return stopSelfResult(i);
    }
}
