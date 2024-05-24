package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import c.d.a.b.e.b.j;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import java.util.concurrent.atomic.AtomicReference;

public abstract class e1 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean k;
    protected final AtomicReference l = new AtomicReference((Object) null);
    private final Handler m = new j(Looper.getMainLooper());
    protected final e n;

    e1(g gVar, e eVar) {
        super(gVar);
        this.n = eVar;
    }

    /* access modifiers changed from: private */
    public final void l(b bVar, int i) {
        this.l.set((Object) null);
        m(bVar, i);
    }

    /* access modifiers changed from: private */
    public final void o() {
        this.l.set((Object) null);
        n();
    }

    private static final int p(b1 b1Var) {
        if (b1Var == null) {
            return -1;
        }
        return b1Var.a();
    }

    public final void e(int i, int i2, Intent intent) {
        b1 b1Var = (b1) this.l.get();
        if (i != 1) {
            if (i == 2) {
                int g = this.n.g(b());
                if (g == 0) {
                    o();
                    return;
                } else if (b1Var != null) {
                    if (b1Var.b().g() == 18 && g == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 == -1) {
            o();
            return;
        } else if (i2 == 0) {
            if (b1Var != null) {
                int i3 = 13;
                if (intent != null) {
                    i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                l(new b(i3, (PendingIntent) null, b1Var.b().toString()), p(b1Var));
                return;
            }
            return;
        }
        if (b1Var != null) {
            l(b1Var.b(), b1Var.a());
        }
    }

    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.l.set(bundle.getBoolean("resolving_error", false) ? new b1(new b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void i(Bundle bundle) {
        super.i(bundle);
        b1 b1Var = (b1) this.l.get();
        if (b1Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", b1Var.a());
            bundle.putInt("failed_status", b1Var.b().g());
            bundle.putParcelable("failed_resolution", b1Var.b().j());
        }
    }

    public void j() {
        super.j();
        this.k = true;
    }

    public void k() {
        super.k();
        this.k = false;
    }

    /* access modifiers changed from: protected */
    public abstract void m(b bVar, int i);

    /* access modifiers changed from: protected */
    public abstract void n();

    public final void onCancel(DialogInterface dialogInterface) {
        l(new b(13, (PendingIntent) null), p((b1) this.l.get()));
    }

    public final void s(b bVar, int i) {
        b1 b1Var = new b1(bVar, i);
        AtomicReference atomicReference = this.l;
        while (!atomicReference.compareAndSet((Object) null, b1Var)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.m.post(new d1(this, b1Var));
    }
}
