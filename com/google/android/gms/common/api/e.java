package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.r0;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.k;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public abstract class e<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2043a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2044b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2045c;

    /* renamed from: d  reason: collision with root package name */
    private final a.d f2046d;

    /* renamed from: e  reason: collision with root package name */
    private final b f2047e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2048f;
    private final m g;
    protected final com.google.android.gms.common.api.internal.e h;

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f2049c = new C0070a().a();

        /* renamed from: a  reason: collision with root package name */
        public final m f2050a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f2051b;

        /* renamed from: com.google.android.gms.common.api.e$a$a  reason: collision with other inner class name */
        public static class C0070a {

            /* renamed from: a  reason: collision with root package name */
            private m f2052a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f2053b;

            public a a() {
                if (this.f2052a == null) {
                    this.f2052a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f2053b == null) {
                    this.f2053b = Looper.getMainLooper();
                }
                return new a(this.f2052a, this.f2053b);
            }
        }

        private a(m mVar, Account account, Looper looper) {
            this.f2050a = mVar;
            this.f2051b = looper;
        }
    }

    private e(Context context, Activity activity, a aVar, a.d dVar, a aVar2) {
        n.j(context, "Null context is not permitted.");
        n.j(aVar, "Api must not be null.");
        n.j(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f2043a = context.getApplicationContext();
        String str = null;
        if (k.k()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f2044b = str;
        this.f2045c = aVar;
        this.f2046d = dVar;
        Looper looper = aVar2.f2051b;
        b a2 = b.a(aVar, dVar, str);
        this.f2047e = a2;
        com.google.android.gms.common.api.internal.e x = com.google.android.gms.common.api.internal.e.x(this.f2043a);
        this.h = x;
        this.f2048f = x.m();
        this.g = aVar2.f2050a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            r.u(activity, x, a2);
        }
        x.b(this);
    }

    public e(Context context, a<O> aVar, O o, a aVar2) {
        this(context, (Activity) null, aVar, o, aVar2);
    }

    private final i i(int i, com.google.android.gms.common.api.internal.n nVar) {
        j jVar = new j();
        this.h.D(this, i, nVar, jVar, this.g);
        return jVar.a();
    }

    /* access modifiers changed from: protected */
    public d.a b() {
        Account account;
        GoogleSignInAccount b2;
        GoogleSignInAccount b3;
        d.a aVar = new d.a();
        a.d dVar = this.f2046d;
        if (!(dVar instanceof a.d.b) || (b3 = ((a.d.b) dVar).b()) == null) {
            a.d dVar2 = this.f2046d;
            account = dVar2 instanceof a.d.C0069a ? ((a.d.C0069a) dVar2).a() : null;
        } else {
            account = b3.g();
        }
        aVar.d(account);
        a.d dVar3 = this.f2046d;
        aVar.c((!(dVar3 instanceof a.d.b) || (b2 = ((a.d.b) dVar3).b()) == null) ? Collections.emptySet() : b2.t());
        aVar.e(this.f2043a.getClass().getName());
        aVar.b(this.f2043a.getPackageName());
        return aVar;
    }

    public <TResult, A extends a.b> i<TResult> c(com.google.android.gms.common.api.internal.n<A, TResult> nVar) {
        return i(2, nVar);
    }

    public final b<O> d() {
        return this.f2047e;
    }

    /* access modifiers changed from: protected */
    public String e() {
        return this.f2044b;
    }

    public final int f() {
        return this.f2048f;
    }

    public final a.f g(Looper looper, z zVar) {
        com.google.android.gms.common.internal.d a2 = b().a();
        a.C0068a a3 = this.f2045c.a();
        n.i(a3);
        a.f a4 = a3.a(this.f2043a, looper, a2, this.f2046d, zVar, zVar);
        String e2 = e();
        if (e2 != null && (a4 instanceof c)) {
            ((c) a4).P(e2);
        }
        if (e2 != null && (a4 instanceof com.google.android.gms.common.api.internal.i)) {
            ((com.google.android.gms.common.api.internal.i) a4).r(e2);
        }
        return a4;
    }

    public final r0 h(Context context, Handler handler) {
        return new r0(context, handler, b().a());
    }
}
