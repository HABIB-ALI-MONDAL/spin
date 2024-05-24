package c.b.a.o;

import c.b.a.r.b;
import c.b.a.t.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f1233a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f1234b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1235c;

    private boolean a(b bVar, boolean z) {
        boolean z2 = true;
        if (bVar == null) {
            return true;
        }
        boolean remove = this.f1233a.remove(bVar);
        if (!this.f1234b.remove(bVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            bVar.clear();
            if (z) {
                bVar.b();
            }
        }
        return z2;
    }

    public boolean b(b bVar) {
        return a(bVar, true);
    }

    public void c() {
        for (T a2 : i.i(this.f1233a)) {
            a(a2, false);
        }
        this.f1234b.clear();
    }

    public void d() {
        this.f1235c = true;
        for (T t : i.i(this.f1233a)) {
            if (t.isRunning()) {
                t.d();
                this.f1234b.add(t);
            }
        }
    }

    public void e() {
        for (T t : i.i(this.f1233a)) {
            if (!t.j() && !t.isCancelled()) {
                t.d();
                if (!this.f1235c) {
                    t.e();
                } else {
                    this.f1234b.add(t);
                }
            }
        }
    }

    public void f() {
        this.f1235c = false;
        for (T t : i.i(this.f1233a)) {
            if (!t.j() && !t.isCancelled() && !t.isRunning()) {
                t.e();
            }
        }
        this.f1234b.clear();
    }

    public void g(b bVar) {
        this.f1233a.add(bVar);
        if (!this.f1235c) {
            bVar.e();
        } else {
            this.f1234b.add(bVar);
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f1233a.size() + ", isPaused=" + this.f1235c + "}";
    }
}
