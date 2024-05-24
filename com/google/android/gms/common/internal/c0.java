package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class c0 extends e0 {
    final /* synthetic */ Intent j;
    final /* synthetic */ Activity k;
    final /* synthetic */ int l;

    c0(Intent intent, Activity activity, int i) {
        this.j = intent;
        this.k = activity;
        this.l = i;
    }

    public final void a() {
        Intent intent = this.j;
        if (intent != null) {
            this.k.startActivityForResult(intent, this.l);
        }
    }
}
