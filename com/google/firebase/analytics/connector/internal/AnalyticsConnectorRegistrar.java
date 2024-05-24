package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.analytics.a.a;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.u;
import com.google.firebase.h;
import com.google.firebase.m.d;
import java.util.Arrays;
import java.util.List;

@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @SuppressLint({"MissingPermission"})
    @Keep
    public List<n<?>> getComponents() {
        n.b<a> a2 = n.a(a.class);
        a2.b(u.i(h.class));
        a2.b(u.i(Context.class));
        a2.b(u.i(d.class));
        a2.f(a.f2669a);
        a2.e();
        return Arrays.asList(new n[]{a2.d(), com.google.firebase.q.h.a("fire-analytics", "21.2.0")});
    }
}
