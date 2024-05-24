package com.google.firebase.q;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f3052b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<g> f3053a = new HashSet();

    e() {
    }

    public static e a() {
        e eVar = f3052b;
        if (eVar == null) {
            synchronized (e.class) {
                eVar = f3052b;
                if (eVar == null) {
                    eVar = new e();
                    f3052b = eVar;
                }
            }
        }
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public Set<g> b() {
        Set<g> unmodifiableSet;
        synchronized (this.f3053a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f3053a);
        }
        return unmodifiableSet;
    }
}
