package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class s6 implements ka {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e7 f2538a;

    s6(e7 e7Var) {
        this.f2538a = e7Var;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f2538a.r("auto", "_err", bundle);
        } else {
            this.f2538a.t("auto", "_err", bundle, str);
            throw null;
        }
    }
}
