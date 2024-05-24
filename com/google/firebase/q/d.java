package com.google.firebase.q;

import com.google.firebase.components.n;
import com.google.firebase.components.o;
import com.google.firebase.components.u;
import java.util.Iterator;
import java.util.Set;

public class d implements i {

    /* renamed from: a  reason: collision with root package name */
    private final String f3050a;

    /* renamed from: b  reason: collision with root package name */
    private final e f3051b;

    d(Set<g> set, e eVar) {
        this.f3050a = d(set);
        this.f3051b = eVar;
    }

    public static n<i> b() {
        n.b<i> a2 = n.a(i.class);
        a2.b(u.k(g.class));
        a2.f(a.f3045a);
        return a2.d();
    }

    static /* synthetic */ i c(o oVar) {
        return new d(oVar.c(g.class), e.a());
    }

    private static String d(Set<g> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = set.iterator();
        while (it.hasNext()) {
            g next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public String a() {
        if (this.f3051b.b().isEmpty()) {
            return this.f3050a;
        }
        return this.f3050a + ' ' + d(this.f3051b.b());
    }
}
