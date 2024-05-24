package c.d.a.a.i;

import android.content.Context;
import c.d.a.a.b;
import c.d.a.a.g;
import c.d.a.a.h;
import c.d.a.a.i.a0.e;
import c.d.a.a.i.c0.a;
import c.d.a.a.i.j;
import c.d.a.a.i.p;
import c.d.a.a.i.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.w;
import java.util.Collections;
import java.util.Set;

public class t implements s {

    /* renamed from: e  reason: collision with root package name */
    private static volatile u f1467e;

    /* renamed from: a  reason: collision with root package name */
    private final a f1468a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1469b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1470c;

    /* renamed from: d  reason: collision with root package name */
    private final u f1471d;

    t(a aVar, a aVar2, e eVar, u uVar, w wVar) {
        this.f1468a = aVar;
        this.f1469b = aVar2;
        this.f1470c = eVar;
        this.f1471d = uVar;
        wVar.a();
    }

    private j b(o oVar) {
        j.a a2 = j.a();
        a2.i(this.f1468a.a());
        a2.k(this.f1469b.a());
        a2.j(oVar.g());
        a2.h(new i(oVar.b(), oVar.d()));
        a2.g(oVar.c().a());
        return a2.d();
    }

    public static t c() {
        u uVar = f1467e;
        if (uVar != null) {
            return uVar.f();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<b> d(g gVar) {
        return gVar instanceof h ? Collections.unmodifiableSet(((h) gVar).b()) : Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        if (f1467e == null) {
            synchronized (t.class) {
                if (f1467e == null) {
                    u.a h = f.h();
                    h.b(context);
                    f1467e = h.a();
                }
            }
        }
    }

    public void a(o oVar, h hVar) {
        this.f1470c.a(oVar.f().f(oVar.c().c()), b(oVar), hVar);
    }

    public com.google.android.datatransport.runtime.scheduling.jobscheduling.u e() {
        return this.f1471d;
    }

    public g g(g gVar) {
        Set<b> d2 = d(gVar);
        p.a a2 = p.a();
        a2.b(gVar.c());
        a2.c(gVar.a());
        return new q(d2, a2.a(), this);
    }
}
