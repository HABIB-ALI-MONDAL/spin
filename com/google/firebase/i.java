package com.google.firebase;

import com.google.android.gms.common.internal.n;

public class i extends Exception {
    @Deprecated
    protected i() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(String str) {
        super(str);
        n.f(str, "Detail message must not be empty");
    }
}
