package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class c1 extends e0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f2073a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d1 f2074b;

    c1(d1 d1Var, Dialog dialog) {
        this.f2074b = d1Var;
        this.f2073a = dialog;
    }

    public final void a() {
        this.f2074b.k.o();
        if (this.f2073a.isShowing()) {
            this.f2073a.dismiss();
        }
    }
}
