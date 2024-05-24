package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.o;
import com.google.firebase.components.u;
import com.google.firebase.h;
import com.google.firebase.n.i;
import com.google.firebase.n.j;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    static /* synthetic */ i a(o oVar) {
        return new h((h) oVar.a(h.class), oVar.b(j.class));
    }

    public List<n<?>> getComponents() {
        n.b<i> a2 = n.a(i.class);
        a2.h(LIBRARY_NAME);
        a2.b(u.i(h.class));
        a2.b(u.h(j.class));
        a2.f(e.f2757a);
        return Arrays.asList(new n[]{a2.d(), i.a(), com.google.firebase.q.h.a(LIBRARY_NAME, "17.1.0")});
    }
}
