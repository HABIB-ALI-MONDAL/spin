package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import b.c.a;
import c.d.a.b.e.d.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class j1 extends Fragment implements g {
    private static final WeakHashMap m = new WeakHashMap();
    private final Map j = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */
    public int k = 0;
    /* access modifiers changed from: private */
    public Bundle l;

    public static j1 f(Activity activity) {
        j1 j1Var;
        WeakHashMap weakHashMap = m;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (j1Var = (j1) weakReference.get()) != null) {
            return j1Var;
        }
        try {
            j1 j1Var2 = (j1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (j1Var2 == null || j1Var2.isRemoving()) {
                j1Var2 = new j1();
                activity.getFragmentManager().beginTransaction().add(j1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(j1Var2));
            return j1Var2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    public final void b(String str, LifecycleCallback lifecycleCallback) {
        if (!this.j.containsKey(str)) {
            this.j.put(str, lifecycleCallback);
            if (this.k > 0) {
                new e(Looper.getMainLooper()).post(new i1(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final <T extends LifecycleCallback> T d(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.j.get(str));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.j.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final Activity e() {
        return getActivity();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback e2 : this.j.values()) {
            e2.e(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = 1;
        this.l = bundle;
        for (Map.Entry entry : this.j.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k = 5;
        for (LifecycleCallback g : this.j.values()) {
            g.g();
        }
    }

    public final void onResume() {
        super.onResume();
        this.k = 3;
        for (LifecycleCallback h : this.j.values()) {
            h.h();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.j.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.k = 2;
        for (LifecycleCallback j2 : this.j.values()) {
            j2.j();
        }
    }

    public final void onStop() {
        super.onStop();
        this.k = 4;
        for (LifecycleCallback k2 : this.j.values()) {
            k2.k();
        }
    }
}
