package c.b.a.o;

import c.b.a.t.i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f1217a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f1218b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1219c;

    a() {
    }

    public void a(i iVar) {
        this.f1217a.add(iVar);
        if (this.f1219c) {
            iVar.onDestroy();
        } else if (this.f1218b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    public void b(i iVar) {
        this.f1217a.remove(iVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1219c = true;
        for (T onDestroy : i.i(this.f1217a)) {
            onDestroy.onDestroy();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f1218b = true;
        for (T onStart : i.i(this.f1217a)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f1218b = false;
        for (T onStop : i.i(this.f1217a)) {
            onStop.onStop();
        }
    }
}
