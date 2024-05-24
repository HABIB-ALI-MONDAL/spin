package com.google.android.gms.common.api;

import com.google.android.gms.common.d;

public final class m extends UnsupportedOperationException {
    private final d j;

    public m(d dVar) {
        this.j = dVar;
    }

    public String getMessage() {
        return "Missing ".concat(String.valueOf(String.valueOf(this.j)));
    }
}
