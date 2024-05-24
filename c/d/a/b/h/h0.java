package c.d.a.b.h;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class h0<TResult> extends i<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1824a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final e0 f1825b = new e0();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private boolean f1826c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1827d;
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    private Object f1828e;
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    private Exception f1829f;

    h0() {
    }

    @GuardedBy("mLock")
    private final void u() {
        n.m(this.f1826c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void v() {
        if (this.f1827d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @GuardedBy("mLock")
    private final void w() {
        if (this.f1826c) {
            throw b.a(this);
        }
    }

    private final void x() {
        synchronized (this.f1824a) {
            if (this.f1826c) {
                this.f1825b.b(this);
            }
        }
    }

    public final i<TResult> a(Executor executor, c cVar) {
        this.f1825b.a(new u(executor, cVar));
        x();
        return this;
    }

    public final i<TResult> b(d<TResult> dVar) {
        this.f1825b.a(new w(k.f1831a, dVar));
        x();
        return this;
    }

    public final i<TResult> c(Executor executor, d<TResult> dVar) {
        this.f1825b.a(new w(executor, dVar));
        x();
        return this;
    }

    public final i<TResult> d(Executor executor, e eVar) {
        this.f1825b.a(new y(executor, eVar));
        x();
        return this;
    }

    public final i<TResult> e(Executor executor, f<? super TResult> fVar) {
        this.f1825b.a(new a0(executor, fVar));
        x();
        return this;
    }

    public final <TContinuationResult> i<TContinuationResult> f(Executor executor, a<TResult, TContinuationResult> aVar) {
        h0 h0Var = new h0();
        this.f1825b.a(new q(executor, aVar, h0Var));
        x();
        return h0Var;
    }

    public final <TContinuationResult> i<TContinuationResult> g(Executor executor, a<TResult, i<TContinuationResult>> aVar) {
        h0 h0Var = new h0();
        this.f1825b.a(new s(executor, aVar, h0Var));
        x();
        return h0Var;
    }

    public final Exception h() {
        Exception exc;
        synchronized (this.f1824a) {
            exc = this.f1829f;
        }
        return exc;
    }

    public final TResult i() {
        TResult tresult;
        synchronized (this.f1824a) {
            u();
            v();
            Exception exc = this.f1829f;
            if (exc == null) {
                tresult = this.f1828e;
            } else {
                throw new g(exc);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult j(Class<X> cls) {
        TResult tresult;
        synchronized (this.f1824a) {
            u();
            v();
            if (!cls.isInstance(this.f1829f)) {
                Exception exc = this.f1829f;
                if (exc == null) {
                    tresult = this.f1828e;
                } else {
                    throw new g(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.f1829f));
            }
        }
        return tresult;
    }

    public final boolean k() {
        return this.f1827d;
    }

    public final boolean l() {
        boolean z;
        synchronized (this.f1824a) {
            z = this.f1826c;
        }
        return z;
    }

    public final boolean m() {
        boolean z;
        synchronized (this.f1824a) {
            z = false;
            if (this.f1826c && !this.f1827d && this.f1829f == null) {
                z = true;
            }
        }
        return z;
    }

    public final <TContinuationResult> i<TContinuationResult> n(h<TResult, TContinuationResult> hVar) {
        Executor executor = k.f1831a;
        h0 h0Var = new h0();
        this.f1825b.a(new c0(executor, hVar, h0Var));
        x();
        return h0Var;
    }

    public final <TContinuationResult> i<TContinuationResult> o(Executor executor, h<TResult, TContinuationResult> hVar) {
        h0 h0Var = new h0();
        this.f1825b.a(new c0(executor, hVar, h0Var));
        x();
        return h0Var;
    }

    public final void p(Exception exc) {
        n.j(exc, "Exception must not be null");
        synchronized (this.f1824a) {
            w();
            this.f1826c = true;
            this.f1829f = exc;
        }
        this.f1825b.b(this);
    }

    public final void q(Object obj) {
        synchronized (this.f1824a) {
            w();
            this.f1826c = true;
            this.f1828e = obj;
        }
        this.f1825b.b(this);
    }

    public final boolean r() {
        synchronized (this.f1824a) {
            if (this.f1826c) {
                return false;
            }
            this.f1826c = true;
            this.f1827d = true;
            this.f1825b.b(this);
            return true;
        }
    }

    public final boolean s(Exception exc) {
        n.j(exc, "Exception must not be null");
        synchronized (this.f1824a) {
            if (this.f1826c) {
                return false;
            }
            this.f1826c = true;
            this.f1829f = exc;
            this.f1825b.b(this);
            return true;
        }
    }

    public final boolean t(Object obj) {
        synchronized (this.f1824a) {
            if (this.f1826c) {
                return false;
            }
            this.f1826c = true;
            this.f1828e = obj;
            this.f1825b.b(this);
            return true;
        }
    }
}
