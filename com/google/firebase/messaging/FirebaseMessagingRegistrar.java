package com.google.firebase.messaging;

import androidx.annotation.Keep;
import c.d.a.a.g;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.o;
import com.google.firebase.components.u;
import com.google.firebase.h;
import com.google.firebase.iid.a.a;
import com.google.firebase.m.d;
import com.google.firebase.n.k;
import com.google.firebase.q.i;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    static /* synthetic */ FirebaseMessaging a(o oVar) {
        return new FirebaseMessaging((h) oVar.a(h.class), (a) oVar.a(a.class), oVar.b(i.class), oVar.b(k.class), (com.google.firebase.installations.i) oVar.a(com.google.firebase.installations.i.class), (g) oVar.a(g.class), (d) oVar.a(d.class));
    }

    @Keep
    public List<n<?>> getComponents() {
        n.b<FirebaseMessaging> a2 = n.a(FirebaseMessaging.class);
        a2.h(LIBRARY_NAME);
        a2.b(u.i(h.class));
        a2.b(u.g(a.class));
        a2.b(u.h(i.class));
        a2.b(u.h(k.class));
        a2.b(u.g(g.class));
        a2.b(u.i(com.google.firebase.installations.i.class));
        a2.b(u.i(d.class));
        a2.f(r.f2999a);
        a2.c();
        return Arrays.asList(new n[]{a2.d(), com.google.firebase.q.h.a(LIBRARY_NAME, "23.1.1")});
    }
}
