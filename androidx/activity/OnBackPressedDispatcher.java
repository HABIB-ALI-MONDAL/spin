package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f29a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<b> f30b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements e, a {

        /* renamed from: a  reason: collision with root package name */
        private final d f31a;

        /* renamed from: b  reason: collision with root package name */
        private final b f32b;

        /* renamed from: c  reason: collision with root package name */
        private a f33c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f34d;

        public void cancel() {
            this.f31a.c(this);
            this.f32b.d(this);
            a aVar = this.f33c;
            if (aVar != null) {
                aVar.cancel();
                this.f33c = null;
            }
        }

        public void d(g gVar, d.b bVar) {
            if (bVar == d.b.ON_START) {
                this.f33c = this.f34d.a(this.f32b);
            } else if (bVar == d.b.ON_STOP) {
                a aVar = this.f33c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (bVar == d.b.ON_DESTROY) {
                cancel();
            }
        }
    }

    private class a implements a {

        /* renamed from: a  reason: collision with root package name */
        private final b f35a;

        a(b bVar) {
            this.f35a = bVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f30b.remove(this.f35a);
            this.f35a.d(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f29a = runnable;
    }

    /* access modifiers changed from: package-private */
    public a a(b bVar) {
        this.f30b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void b() {
        Iterator<b> descendingIterator = this.f30b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f29a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
