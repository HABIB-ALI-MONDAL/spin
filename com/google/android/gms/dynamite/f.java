package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class f implements DynamiteModule.b {
    f() {
    }

    public final DynamiteModule.b.C0072b a(Context context, String str, DynamiteModule.b.a aVar) {
        DynamiteModule.b.C0072b bVar = new DynamiteModule.b.C0072b();
        bVar.f2286a = aVar.a(context, str);
        int b2 = aVar.b(context, str, true);
        bVar.f2287b = b2;
        int i = bVar.f2286a;
        if (i == 0) {
            if (b2 == 0) {
                bVar.f2288c = 0;
                return bVar;
            }
            i = 0;
        }
        if (i >= b2) {
            bVar.f2288c = -1;
        } else {
            bVar.f2288c = 1;
        }
        return bVar;
    }
}
