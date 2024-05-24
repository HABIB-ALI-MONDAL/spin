package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class x0 {

    /* renamed from: a  reason: collision with root package name */
    private Object f2235a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2236b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f2237c;

    public x0(c cVar, Object obj) {
        this.f2237c = cVar;
        this.f2235a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            obj = this.f2235a;
            if (this.f2236b) {
                String obj2 = toString();
                Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                a(obj);
            } catch (RuntimeException e2) {
                throw e2;
            }
        }
        synchronized (this) {
            this.f2236b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f2235a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f2237c.l) {
            this.f2237c.l.remove(this);
        }
    }
}
