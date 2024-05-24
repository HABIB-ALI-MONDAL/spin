package com.google.firebase.q;

import android.content.Context;
import com.google.firebase.components.n;
import com.google.firebase.components.u;

public class h {

    public interface a<T> {
        String a(T t);
    }

    public static n<?> a(String str, String str2) {
        return n.h(g.a(str, str2), g.class);
    }

    public static n<?> b(String str, a<Context> aVar) {
        n.b<g> i = n.i(g.class);
        i.b(u.i(Context.class));
        i.f(new b(str, aVar));
        return i.d();
    }
}
