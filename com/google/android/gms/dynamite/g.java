package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class g implements DynamiteModule.b {
    g() {
    }

    public final DynamiteModule.b.C0072b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0072b bVar = new DynamiteModule.b.C0072b();
        int a2 = aVar.a(context, str);
        bVar.f2286a = a2;
        int i = 0;
        int b2 = a2 != 0 ? aVar.b(context, str, false) : aVar.b(context, str, true);
        bVar.f2287b = b2;
        int i2 = bVar.f2286a;
        if (i2 != 0) {
            i = i2;
        } else if (b2 == 0) {
            bVar.f2288c = 0;
            return bVar;
        }
        if (i >= b2) {
            bVar.f2288c = -1;
        } else {
            bVar.f2288c = 1;
        }
        return bVar;
    }
}
