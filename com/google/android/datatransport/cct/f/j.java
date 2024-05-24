package com.google.android.datatransport.cct.f;

import com.google.auto.value.AutoValue;
import com.google.firebase.l.a;
import com.google.firebase.l.i.d;
import java.util.List;

@AutoValue
public abstract class j {
    public static j a(List<m> list) {
        return new d(list);
    }

    public static a b() {
        d dVar = new d();
        dVar.g(b.f1878a);
        dVar.h(true);
        return dVar.f();
    }

    public abstract List<m> c();
}
