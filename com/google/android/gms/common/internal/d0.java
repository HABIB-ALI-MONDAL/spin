package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.g;

final class d0 extends e0 {
    final /* synthetic */ Intent j;
    final /* synthetic */ g k;

    d0(Intent intent, g gVar, int i) {
        this.j = intent;
        this.k = gVar;
    }

    public final void a() {
        Intent intent = this.j;
        if (intent != null) {
            this.k.startActivityForResult(intent, 2);
        }
    }
}
