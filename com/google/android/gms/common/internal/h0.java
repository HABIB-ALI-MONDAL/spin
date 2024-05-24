package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.f;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f2201a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private f f2202b;

    public h0(f fVar) {
        n.i(fVar);
        this.f2202b = fVar;
    }

    public final int a(Context context, int i) {
        return this.f2201a.get(i, -1);
    }

    public final int b(Context context, a.f fVar) {
        n.i(context);
        n.i(fVar);
        int i = 0;
        if (!fVar.n()) {
            return 0;
        }
        int p = fVar.p();
        int a2 = a(context, p);
        if (a2 == -1) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f2201a.size()) {
                    i = -1;
                    break;
                }
                int keyAt = this.f2201a.keyAt(i2);
                if (keyAt > p && this.f2201a.get(keyAt) == 0) {
                    break;
                }
                i2++;
            }
            a2 = i == -1 ? this.f2202b.h(context, p) : i;
            this.f2201a.put(p, a2);
        }
        return a2;
    }

    public final void c() {
        this.f2201a.clear();
    }
}
