package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class x9 implements ka {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ca f2634a;

    x9(ca caVar) {
        this.f2634a = caVar;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            ca caVar = this.f2634a;
            if (caVar.l != null) {
                caVar.l.f().r().b("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.f2634a.c().z(new w9(this, str, "_err", bundle));
    }
}
