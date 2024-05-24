package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

final class u implements c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2135a;

    u(e eVar) {
        this.f2135a = eVar;
    }

    public final void a(boolean z) {
        e eVar = this.f2135a;
        eVar.p.sendMessage(eVar.p.obtainMessage(1, Boolean.valueOf(z)));
    }
}
