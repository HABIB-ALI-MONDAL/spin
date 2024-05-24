package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.d.a.b.f.b.d;
import c.d.a.b.f.b.l;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.l0;
import com.google.android.gms.common.internal.n;
import java.util.Set;

public final class r0 extends d implements f, g {
    private static final a.C0068a h = c.d.a.b.f.f.f1805c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2125a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2126b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0068a f2127c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f2128d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f2129e;

    /* renamed from: f  reason: collision with root package name */
    private c.d.a.b.f.g f2130f;
    /* access modifiers changed from: private */
    public q0 g;

    public r0(Context context, Handler handler, com.google.android.gms.common.internal.d dVar) {
        a.C0068a aVar = h;
        this.f2125a = context;
        this.f2126b = handler;
        n.j(dVar, "ClientSettings must not be null");
        this.f2129e = dVar;
        this.f2128d = dVar.e();
        this.f2127c = aVar;
    }

    static /* bridge */ /* synthetic */ void d0(r0 r0Var, l lVar) {
        b g2 = lVar.g();
        if (g2.l()) {
            l0 i = lVar.i();
            n.i(i);
            l0 l0Var = i;
            g2 = l0Var.g();
            if (!g2.l()) {
                String valueOf = String.valueOf(g2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(valueOf)), new Exception());
            } else {
                r0Var.g.b(l0Var.i(), r0Var.f2128d);
                r0Var.f2130f.j();
            }
        }
        r0Var.g.c(g2);
        r0Var.f2130f.j();
    }

    public final void R(l lVar) {
        this.f2126b.post(new p0(this, lVar));
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.common.api.a$f, c.d.a.b.f.g] */
    public final void e0(q0 q0Var) {
        c.d.a.b.f.g gVar = this.f2130f;
        if (gVar != null) {
            gVar.j();
        }
        this.f2129e.i(Integer.valueOf(System.identityHashCode(this)));
        a.C0068a aVar = this.f2127c;
        Context context = this.f2125a;
        Looper looper = this.f2126b.getLooper();
        com.google.android.gms.common.internal.d dVar = this.f2129e;
        this.f2130f = aVar.a(context, looper, dVar, dVar.f(), this, this);
        this.g = q0Var;
        Set set = this.f2128d;
        if (set == null || set.isEmpty()) {
            this.f2126b.post(new o0(this));
        } else {
            this.f2130f.m();
        }
    }

    public final void f0() {
        c.d.a.b.f.g gVar = this.f2130f;
        if (gVar != null) {
            gVar.j();
        }
    }

    public final void h(b bVar) {
        this.g.c(bVar);
    }

    public final void i(int i) {
        this.f2130f.j();
    }

    public final void k(Bundle bundle) {
        this.f2130f.o(this);
    }
}
