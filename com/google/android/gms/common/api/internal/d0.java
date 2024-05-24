package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.i;
import java.util.Set;

final class d0 implements c.C0071c, q0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a.f f2075a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b f2076b;

    /* renamed from: c  reason: collision with root package name */
    private i f2077c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f2078d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f2079e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ e f2080f;

    public d0(e eVar, a.f fVar, b bVar) {
        this.f2080f = eVar;
        this.f2075a = fVar;
        this.f2076b = bVar;
    }

    /* access modifiers changed from: private */
    public final void h() {
        i iVar;
        if (this.f2079e && (iVar = this.f2077c) != null) {
            this.f2075a.h(iVar, this.f2078d);
        }
    }

    public final void a(b bVar) {
        this.f2080f.p.post(new c0(this, bVar));
    }

    public final void b(i iVar, Set set) {
        if (iVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new b(4));
            return;
        }
        this.f2077c = iVar;
        this.f2078d = set;
        h();
    }

    public final void c(b bVar) {
        z zVar = (z) this.f2080f.l.get(this.f2076b);
        if (zVar != null) {
            zVar.I(bVar);
        }
    }
}
