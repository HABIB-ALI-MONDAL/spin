package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.n;
import java.util.Collections;
import java.util.Set;

public final class i implements a.f, ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final String f2093a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2094b;

    /* renamed from: c  reason: collision with root package name */
    private final ComponentName f2095c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f2096d;

    /* renamed from: e  reason: collision with root package name */
    private final d f2097e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f2098f;
    private final j g;
    private IBinder h;
    private boolean i;
    private String j;

    static {
        Class<i> cls = i.class;
    }

    private final void s() {
        if (Thread.currentThread() != this.f2098f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    public final void a(c.e eVar) {
    }

    public final boolean b() {
        s();
        return this.i;
    }

    public final d[] c() {
        return new d[0];
    }

    public final boolean d() {
        s();
        return this.h != null;
    }

    public final String e() {
        String str = this.f2093a;
        if (str != null) {
            return str;
        }
        n.i(this.f2095c);
        return this.f2095c.getPackageName();
    }

    public final String f() {
        return this.j;
    }

    public final Set<Scope> g() {
        return Collections.emptySet();
    }

    public final void h(com.google.android.gms.common.internal.i iVar, Set<Scope> set) {
    }

    public final void i(c.C0071c cVar) {
        s();
        String.valueOf(this.h);
        if (d()) {
            try {
                k("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f2095c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f2093a).setAction(this.f2094b);
            }
            boolean bindService = this.f2096d.bindService(intent, this, h.a());
            this.i = bindService;
            if (!bindService) {
                this.h = null;
                this.g.h(new b(16));
            }
            String.valueOf(this.h);
        } catch (SecurityException e2) {
            this.i = false;
            this.h = null;
            throw e2;
        }
    }

    public final void j() {
        s();
        String.valueOf(this.h);
        try {
            this.f2096d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.i = false;
        this.h = null;
    }

    public final void k(String str) {
        s();
        this.j = str;
        j();
    }

    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void m() {
        this.i = false;
        this.h = null;
        String.valueOf((Object) null);
        this.f2097e.i(1);
    }

    public final boolean n() {
        return false;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2098f.post(new l0(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f2098f.post(new k0(this));
    }

    public final int p() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void q(IBinder iBinder) {
        this.i = false;
        this.h = iBinder;
        String.valueOf(iBinder);
        this.f2097e.k(new Bundle());
    }

    public final void r(String str) {
    }
}
