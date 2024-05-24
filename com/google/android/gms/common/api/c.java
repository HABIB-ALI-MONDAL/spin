package com.google.android.gms.common.api;

import android.text.TextUtils;
import b.c.a;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;

public class c extends Exception {
    private final a j;

    public c(a aVar) {
        this.j = aVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (b bVar : this.j.keySet()) {
            com.google.android.gms.common.b bVar2 = (com.google.android.gms.common.b) this.j.get(bVar);
            n.i(bVar2);
            com.google.android.gms.common.b bVar3 = bVar2;
            z &= !bVar3.l();
            String b2 = bVar.b();
            String valueOf = String.valueOf(bVar3);
            arrayList.add(b2 + ": " + valueOf);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}
