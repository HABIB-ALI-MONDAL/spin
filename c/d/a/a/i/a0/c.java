package c.d.a.a.i.a0;

import c.d.a.a.h;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.b0.b;
import c.d.a.a.i.j;
import c.d.a.a.i.p;
import c.d.a.a.i.t;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class c implements e {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f1306f = Logger.getLogger(t.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final y f1307a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f1308b;

    /* renamed from: c  reason: collision with root package name */
    private final e f1309c;

    /* renamed from: d  reason: collision with root package name */
    private final j0 f1310d;

    /* renamed from: e  reason: collision with root package name */
    private final b f1311e;

    public c(Executor executor, e eVar, y yVar, j0 j0Var, b bVar) {
        this.f1308b = executor;
        this.f1309c = eVar;
        this.f1307a = yVar;
        this.f1310d = j0Var;
        this.f1311e = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Object c(p pVar, j jVar) {
        this.f1310d.l(pVar, jVar);
        this.f1307a.a(pVar, 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(p pVar, h hVar, j jVar) {
        try {
            m a2 = this.f1309c.a(pVar.b());
            if (a2 == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{pVar.b()});
                f1306f.warning(format);
                hVar.a(new IllegalArgumentException(format));
                return;
            }
            this.f1311e.f(new b(this, pVar, a2.a(jVar)));
            hVar.a((Exception) null);
        } catch (Exception e2) {
            Logger logger = f1306f;
            logger.warning("Error scheduling event " + e2.getMessage());
            hVar.a(e2);
        }
    }

    public void a(p pVar, j jVar, h hVar) {
        this.f1308b.execute(new a(this, pVar, hVar, jVar));
    }
}
