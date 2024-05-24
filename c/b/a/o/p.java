package c.b.a.o;

import c.b.a.r.i.h;
import c.b.a.t.i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<h<?>> f1237a = Collections.newSetFromMap(new WeakHashMap());

    public void i() {
        this.f1237a.clear();
    }

    public List<h<?>> j() {
        return i.i(this.f1237a);
    }

    public void k(h<?> hVar) {
        this.f1237a.add(hVar);
    }

    public void l(h<?> hVar) {
        this.f1237a.remove(hVar);
    }

    public void onDestroy() {
        for (T onDestroy : i.i(this.f1237a)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : i.i(this.f1237a)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : i.i(this.f1237a)) {
            onStop.onStop();
        }
    }
}
