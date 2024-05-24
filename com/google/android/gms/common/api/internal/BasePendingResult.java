package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import c.d.a.b.e.b.j;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends k> extends h<R> {
    public static final /* synthetic */ int l = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object f2054a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected final a f2055b = new a(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f2056c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList f2057d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private l f2058e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference f2059f = new AtomicReference();
    /* access modifiers changed from: private */
    public k g;
    private Status h;
    private volatile boolean i;
    private boolean j;
    private boolean k;
    @KeepName
    private h1 mResultGuardian;

    public static class a<R extends k> extends j {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(l lVar, k kVar) {
            int i = BasePendingResult.l;
            n.i(lVar);
            sendMessage(obtainMessage(1, new Pair(lVar, kVar)));
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                l lVar = (l) pair.first;
                k kVar = (k) pair.second;
                try {
                    lVar.a(kVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.h(kVar);
                    throw e2;
                }
            } else if (i != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i, new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.p);
            }
        }
    }

    static {
        new f1();
    }

    @Deprecated
    BasePendingResult() {
        new WeakReference((Object) null);
    }

    private final k e() {
        k kVar;
        synchronized (this.f2054a) {
            n.m(!this.i, "Result has already been consumed.");
            n.m(c(), "Result is not ready.");
            kVar = this.g;
            this.g = null;
            this.f2058e = null;
            this.i = true;
        }
        v0 v0Var = (v0) this.f2059f.getAndSet((Object) null);
        if (v0Var != null) {
            v0Var.f2137a.f2138a.remove(this);
        }
        n.i(kVar);
        return kVar;
    }

    private final void f(k kVar) {
        this.g = kVar;
        this.h = kVar.d();
        this.f2056c.countDown();
        if (this.j) {
            this.f2058e = null;
        } else {
            l lVar = this.f2058e;
            if (lVar != null) {
                this.f2055b.removeMessages(2);
                this.f2055b.a(lVar, e());
            } else if (this.g instanceof i) {
                this.mResultGuardian = new h1(this, (g1) null);
            }
        }
        ArrayList arrayList = this.f2057d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((h.a) arrayList.get(i2)).a(this.h);
        }
        this.f2057d.clear();
    }

    public static void h(k kVar) {
        if (kVar instanceof i) {
            try {
                ((i) kVar).a();
            } catch (RuntimeException e2) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(String.valueOf(kVar))), e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract R a(Status status);

    @Deprecated
    public final void b(Status status) {
        synchronized (this.f2054a) {
            if (!c()) {
                d(a(status));
                this.k = true;
            }
        }
    }

    public final boolean c() {
        return this.f2056c.getCount() == 0;
    }

    public final void d(R r) {
        synchronized (this.f2054a) {
            if (this.k || this.j) {
                h(r);
                return;
            }
            c();
            n.m(!c(), "Results have already been set");
            n.m(!this.i, "Result has already been consumed");
            f(r);
        }
    }
}
