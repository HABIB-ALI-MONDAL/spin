package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import c.d.a.a.g;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.u;
import com.google.firebase.q.h;
import java.util.Arrays;
import java.util.List;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    public List<n<?>> getComponents() {
        n.b<g> a2 = n.a(g.class);
        a2.h(LIBRARY_NAME);
        a2.b(u.i(Context.class));
        a2.f(a.f2742a);
        return Arrays.asList(new n[]{a2.d(), h.a(LIBRARY_NAME, "18.1.7")});
    }
}
