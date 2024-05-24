package c.d.a.b.h;

import java.util.concurrent.Executor;

public abstract class i<TResult> {
    public i<TResult> a(Executor executor, c cVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public i<TResult> b(d<TResult> dVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public i<TResult> c(Executor executor, d<TResult> dVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract i<TResult> d(Executor executor, e eVar);

    public abstract i<TResult> e(Executor executor, f<? super TResult> fVar);

    public <TContinuationResult> i<TContinuationResult> f(Executor executor, a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> i<TContinuationResult> g(Executor executor, a<TResult, i<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception h();

    public abstract TResult i();

    public abstract <X extends Throwable> TResult j(Class<X> cls);

    public abstract boolean k();

    public abstract boolean l();

    public abstract boolean m();

    public <TContinuationResult> i<TContinuationResult> n(h<TResult, TContinuationResult> hVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public <TContinuationResult> i<TContinuationResult> o(Executor executor, h<TResult, TContinuationResult> hVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
