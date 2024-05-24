package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import b.c.b;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Account f2177a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f2178b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f2179c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f2180d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2181e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2182f;
    private final c.d.a.b.f.a g;
    private Integer h;

    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f2183a;

        /* renamed from: b  reason: collision with root package name */
        private b f2184b;

        /* renamed from: c  reason: collision with root package name */
        private String f2185c;

        /* renamed from: d  reason: collision with root package name */
        private String f2186d;

        /* renamed from: e  reason: collision with root package name */
        private c.d.a.b.f.a f2187e = c.d.a.b.f.a.j;

        public d a() {
            return new d(this.f2183a, this.f2184b, (Map) null, 0, (View) null, this.f2185c, this.f2186d, this.f2187e, false);
        }

        public a b(String str) {
            this.f2185c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f2184b == null) {
                this.f2184b = new b();
            }
            this.f2184b.addAll(collection);
            return this;
        }

        public final a d(@Nullable Account account) {
            this.f2183a = account;
            return this;
        }

        public final a e(String str) {
            this.f2186d = str;
            return this;
        }
    }

    public d(@Nullable Account account, Set set, Map map, int i, @Nullable View view, String str, String str2, @Nullable c.d.a.b.f.a aVar, boolean z) {
        this.f2177a = account;
        Set emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f2178b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f2180d = map;
        this.f2181e = str;
        this.f2182f = str2;
        this.g = aVar == null ? c.d.a.b.f.a.j : aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (a0 a0Var : map.values()) {
            hashSet.addAll(a0Var.f2167a);
        }
        this.f2179c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f2177a;
    }

    public Account b() {
        Account account = this.f2177a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> c() {
        return this.f2179c;
    }

    public String d() {
        return this.f2181e;
    }

    public Set<Scope> e() {
        return this.f2178b;
    }

    public final c.d.a.b.f.a f() {
        return this.g;
    }

    public final Integer g() {
        return this.h;
    }

    public final String h() {
        return this.f2182f;
    }

    public final void i(Integer num) {
        this.h = num;
    }
}
