package b.g.a;

import android.view.View;
import android.view.ViewTreeObserver;

class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final View j;
    private ViewTreeObserver k;
    private final Runnable l;

    private r(View view, Runnable runnable) {
        this.j = view;
        this.k = view.getViewTreeObserver();
        this.l = runnable;
    }

    public static r a(View view, Runnable runnable) {
        r rVar = new r(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    public void b() {
        (this.k.isAlive() ? this.k : this.j.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.j.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.l.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.k = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
