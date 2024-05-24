package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f38b;

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f38b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f37a;
    }

    /* access modifiers changed from: package-private */
    public void d(a aVar) {
        this.f38b.remove(aVar);
    }
}
