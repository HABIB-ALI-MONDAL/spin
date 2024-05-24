package b.a.m;

import android.view.View;
import android.view.animation.Interpolator;
import b.d.k.t;
import b.d.k.u;
import b.d.k.v;
import java.util.ArrayList;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<t> f508a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f509b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f510c;

    /* renamed from: d  reason: collision with root package name */
    u f511d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f512e;

    /* renamed from: f  reason: collision with root package name */
    private final v f513f = new a();

    class a extends v {

        /* renamed from: a  reason: collision with root package name */
        private boolean f514a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f515b = 0;

        a() {
        }

        public void a(View view) {
            int i = this.f515b + 1;
            this.f515b = i;
            if (i == h.this.f508a.size()) {
                u uVar = h.this.f511d;
                if (uVar != null) {
                    uVar.a((View) null);
                }
                d();
            }
        }

        public void b(View view) {
            if (!this.f514a) {
                this.f514a = true;
                u uVar = h.this.f511d;
                if (uVar != null) {
                    uVar.b((View) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f515b = 0;
            this.f514a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f512e) {
            Iterator<t> it = this.f508a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f512e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f512e = false;
    }

    public h c(t tVar) {
        if (!this.f512e) {
            this.f508a.add(tVar);
        }
        return this;
    }

    public h d(t tVar, t tVar2) {
        this.f508a.add(tVar);
        tVar2.h(tVar.c());
        this.f508a.add(tVar2);
        return this;
    }

    public h e(long j) {
        if (!this.f512e) {
            this.f509b = j;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f512e) {
            this.f510c = interpolator;
        }
        return this;
    }

    public h g(u uVar) {
        if (!this.f512e) {
            this.f511d = uVar;
        }
        return this;
    }

    public void h() {
        if (!this.f512e) {
            Iterator<t> it = this.f508a.iterator();
            while (it.hasNext()) {
                t next = it.next();
                long j = this.f509b;
                if (j >= 0) {
                    next.d(j);
                }
                Interpolator interpolator = this.f510c;
                if (interpolator != null) {
                    next.e(interpolator);
                }
                if (this.f511d != null) {
                    next.f(this.f513f);
                }
                next.j();
            }
            this.f512e = true;
        }
    }
}
