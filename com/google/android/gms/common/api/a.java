package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.n;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final C0068a f2041a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2042b;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0068a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, f fVar, g gVar) {
            return b(context, looper, dVar, o, fVar, gVar);
        }

        public T b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, com.google.android.gms.common.api.internal.d dVar2, j jVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0069a extends d {
            Account a();
        }

        public interface b extends d {
            GoogleSignInAccount b();
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(c.e eVar);

        boolean b();

        com.google.android.gms.common.d[] c();

        boolean d();

        String e();

        String f();

        Set<Scope> g();

        void h(i iVar, Set<Scope> set);

        void i(c.C0071c cVar);

        void j();

        void k(String str);

        boolean l();

        boolean n();

        int p();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> a(String str, C0068a<C, O> aVar, g<C> gVar) {
        n.j(aVar, "Cannot construct an Api with a null ClientBuilder");
        n.j(gVar, "Cannot construct an Api with a null ClientKey");
        this.f2042b = str;
        this.f2041a = aVar;
    }

    public final C0068a a() {
        return this.f2041a;
    }

    public final String b() {
        return this.f2042b;
    }
}
