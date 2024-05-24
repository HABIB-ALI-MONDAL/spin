package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import b.c.a;
import b.g.a.d;
import b.g.a.e;
import b.g.a.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class l1 extends d implements g {
    private static final WeakHashMap k0 = new WeakHashMap();
    private final Map h0 = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */
    public int i0 = 0;
    /* access modifiers changed from: private */
    public Bundle j0;

    public static l1 l1(e eVar) {
        l1 l1Var;
        WeakHashMap weakHashMap = k0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(eVar);
        if (weakReference != null && (l1Var = (l1) weakReference.get()) != null) {
            return l1Var;
        }
        try {
            l1 l1Var2 = (l1) eVar.m().c("SupportLifecycleFragmentImpl");
            if (l1Var2 == null || l1Var2.O()) {
                l1Var2 = new l1();
                n a2 = eVar.m().a();
                a2.b(l1Var2, "SupportLifecycleFragmentImpl");
                a2.d();
            }
            weakHashMap.put(eVar, new WeakReference(l1Var2));
            return l1Var2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    public final void T(int i, int i2, Intent intent) {
        super.T(i, i2, intent);
        for (LifecycleCallback e2 : this.h0.values()) {
            e2.e(i, i2, intent);
        }
    }

    public final void Y(Bundle bundle) {
        super.Y(bundle);
        this.i0 = 1;
        this.j0 = bundle;
        for (Map.Entry entry : this.h0.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (!this.h0.containsKey(str)) {
            this.h0.put(str, lifecycleCallback);
            if (this.i0 > 0) {
                new c.d.a.b.e.d.e(Looper.getMainLooper()).post(new k1(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T d(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.h0.get(str));
    }

    public final void d0() {
        super.d0();
        this.i0 = 5;
        for (LifecycleCallback g : this.h0.values()) {
            g.g();
        }
    }

    public final /* synthetic */ Activity e() {
        return k();
    }

    public final void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.h(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.h0.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void s0() {
        super.s0();
        this.i0 = 3;
        for (LifecycleCallback h : this.h0.values()) {
            h.h();
        }
    }

    public final void t0(Bundle bundle) {
        super.t0(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.h0.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void u0() {
        super.u0();
        this.i0 = 2;
        for (LifecycleCallback j : this.h0.values()) {
            j.j();
        }
    }

    public final void v0() {
        super.v0();
        this.i0 = 4;
        for (LifecycleCallback k : this.h0.values()) {
            k.k();
        }
    }
}
