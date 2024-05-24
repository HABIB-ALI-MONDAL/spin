package b.d.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f649a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f650b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f651c = null;

    /* renamed from: d  reason: collision with root package name */
    int f652d = -1;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f654b;

        a(t tVar, u uVar, View view) {
            this.f653a = uVar;
            this.f654b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f653a.c(this.f654b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f653a.a(this.f654b);
        }

        public void onAnimationStart(Animator animator) {
            this.f653a.b(this.f654b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f656b;

        b(t tVar, w wVar, View view) {
            this.f655a = wVar;
            this.f656b = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f655a.a(this.f656b);
        }
    }

    static class c implements u {

        /* renamed from: a  reason: collision with root package name */
        t f657a;

        /* renamed from: b  reason: collision with root package name */
        boolean f658b;

        c(t tVar) {
            this.f657a = tVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: b.d.k.u} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r4) {
            /*
                r3 = this;
                b.d.k.t r0 = r3.f657a
                int r0 = r0.f652d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                b.d.k.t r0 = r3.f657a
                r0.f652d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f658b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                b.d.k.t r0 = r3.f657a
                java.lang.Runnable r1 = r0.f651c
                if (r1 == 0) goto L_0x0024
                r0.f651c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof b.d.k.u
                if (r1 == 0) goto L_0x0031
                r2 = r0
                b.d.k.u r2 = (b.d.k.u) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.a(r4)
            L_0x0036:
                r4 = 1
                r3.f658b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.k.t.c.a(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: b.d.k.u} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f658b = r0
                b.d.k.t r0 = r3.f657a
                int r0 = r0.f652d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                b.d.k.t r0 = r3.f657a
                java.lang.Runnable r2 = r0.f650b
                if (r2 == 0) goto L_0x001a
                r0.f650b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof b.d.k.u
                if (r2 == 0) goto L_0x0027
                r1 = r0
                b.d.k.u r1 = (b.d.k.u) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.b(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.k.t.c.b(android.view.View):void");
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            u uVar = tag instanceof u ? (u) tag : null;
            if (uVar != null) {
                uVar.c(view);
            }
        }
    }

    t(View view) {
        this.f649a = new WeakReference<>(view);
    }

    private void g(View view, u uVar) {
        if (uVar != null) {
            view.animate().setListener(new a(this, uVar, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public t a(float f2) {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = (View) this.f649a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public t d(long j) {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public t e(Interpolator interpolator) {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public t f(u uVar) {
        View view = (View) this.f649a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, uVar);
                uVar = new c(this);
            }
            g(view, uVar);
        }
        return this;
    }

    public t h(long j) {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public t i(w wVar) {
        View view = (View) this.f649a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (wVar != null) {
                bVar = new b(this, wVar, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void j() {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public t k(float f2) {
        View view = (View) this.f649a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }
}
