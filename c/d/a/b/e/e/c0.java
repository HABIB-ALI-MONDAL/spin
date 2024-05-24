package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Comparator;

final class c0 implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1600a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n4 f1601b;

    c0(j jVar, n4 n4Var) {
        this.f1600a = jVar;
        this.f1601b = n4Var;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        j jVar = this.f1600a;
        n4 n4Var = this.f1601b;
        if (qVar instanceof v) {
            return !(qVar2 instanceof v) ? 1 : 0;
        }
        if (qVar2 instanceof v) {
            return -1;
        }
        if (jVar == null) {
            return qVar.g().compareTo(qVar2.g());
        }
        return (int) n5.a(jVar.a(n4Var, Arrays.asList(new q[]{qVar, qVar2})).f().doubleValue());
    }
}
