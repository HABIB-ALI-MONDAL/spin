package com.google.firebase.r;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.o;
import com.google.firebase.components.r;
import java.util.ArrayList;
import java.util.List;

public class b implements r {
    static /* synthetic */ Object b(String str, n nVar, o oVar) {
        try {
            c.b(str);
            return nVar.d().a(oVar);
        } finally {
            c.a();
        }
    }

    public List<n<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (n next : componentRegistrar.getComponents()) {
            String e2 = next.e();
            if (e2 != null) {
                next = next.p(new a(e2, next));
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
