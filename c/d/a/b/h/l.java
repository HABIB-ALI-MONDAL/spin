package c.d.a.b.h;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class l {
    public static <TResult> TResult a(i<TResult> iVar) {
        n.g();
        n.j(iVar, "Task must not be null");
        if (iVar.l()) {
            return f(iVar);
        }
        n nVar = new n((m) null);
        g(iVar, nVar);
        nVar.c();
        return f(iVar);
    }

    public static <TResult> TResult b(i<TResult> iVar, long j, TimeUnit timeUnit) {
        n.g();
        n.j(iVar, "Task must not be null");
        n.j(timeUnit, "TimeUnit must not be null");
        if (iVar.l()) {
            return f(iVar);
        }
        n nVar = new n((m) null);
        g(iVar, nVar);
        if (nVar.e(j, timeUnit)) {
            return f(iVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @Deprecated
    public static <TResult> i<TResult> c(Executor executor, Callable<TResult> callable) {
        n.j(executor, "Executor must not be null");
        n.j(callable, "Callback must not be null");
        h0 h0Var = new h0();
        executor.execute(new i0(h0Var, callable));
        return h0Var;
    }

    public static <TResult> i<TResult> d(Exception exc) {
        h0 h0Var = new h0();
        h0Var.p(exc);
        return h0Var;
    }

    public static <TResult> i<TResult> e(TResult tresult) {
        h0 h0Var = new h0();
        h0Var.q(tresult);
        return h0Var;
    }

    private static Object f(i iVar) {
        if (iVar.m()) {
            return iVar.i();
        }
        if (iVar.k()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(iVar.h());
    }

    private static void g(i iVar, o oVar) {
        Executor executor = k.f1832b;
        iVar.e(executor, oVar);
        iVar.d(executor, oVar);
        iVar.a(executor, oVar);
    }
}
