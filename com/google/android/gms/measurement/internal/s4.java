package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class s4 extends FutureTask implements Comparable {
    private final long j;
    final boolean k;
    private final String l;
    final /* synthetic */ u4 m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s4(u4 u4Var, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.m = u4Var;
        n.i(str);
        long andIncrement = u4.l.getAndIncrement();
        this.j = andIncrement;
        this.l = str;
        this.k = z;
        if (andIncrement == Long.MAX_VALUE) {
            u4Var.f2527a.f().r().a("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s4(u4 u4Var, Callable callable, boolean z, String str) {
        super(callable);
        this.m = u4Var;
        n.i("Task exception on worker thread");
        long andIncrement = u4.l.getAndIncrement();
        this.j = andIncrement;
        this.l = "Task exception on worker thread";
        this.k = z;
        if (andIncrement == Long.MAX_VALUE) {
            u4Var.f2527a.f().r().a("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        s4 s4Var = (s4) obj;
        boolean z = this.k;
        if (z != s4Var.k) {
            return !z ? 1 : -1;
        }
        long j2 = this.j;
        long j3 = s4Var.j;
        if (j2 < j3) {
            return -1;
        }
        if (j2 > j3) {
            return 1;
        }
        this.m.f2527a.f().t().b("Two tasks share the same index. index", Long.valueOf(this.j));
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.m.f2527a.f().r().b(this.l, th);
        super.setException(th);
    }
}
