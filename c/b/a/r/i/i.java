package c.b.a.r.i;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import c.b.a.r.b;
import c.b.a.t.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class i<T extends View, Z> extends a<Z> {
    private static Integer g;

    /* renamed from: b  reason: collision with root package name */
    protected final T f1259b;

    /* renamed from: c  reason: collision with root package name */
    private final a f1260c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f1261d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1262e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1263f;

    static final class a {

        /* renamed from: e  reason: collision with root package name */
        static Integer f1264e;

        /* renamed from: a  reason: collision with root package name */
        private final View f1265a;

        /* renamed from: b  reason: collision with root package name */
        private final List<g> f1266b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f1267c;

        /* renamed from: d  reason: collision with root package name */
        private C0055a f1268d;

        /* renamed from: c.b.a.r.i.i$a$a  reason: collision with other inner class name */
        private static final class C0055a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<a> j;

            C0055a(a aVar) {
                this.j = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.j.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f1265a = view;
        }

        private static int c(Context context) {
            if (f1264e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                h.d(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f1264e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f1264e.intValue();
        }

        private int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f1267c && this.f1265a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f1265a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f1265a.getContext());
        }

        private int f() {
            int paddingTop = this.f1265a.getPaddingTop() + this.f1265a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f1265a.getLayoutParams();
            return e(this.f1265a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f1265a.getPaddingLeft() + this.f1265a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f1265a.getLayoutParams();
            return e(this.f1265a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.f1266b).iterator();
            while (it.hasNext()) {
                ((g) it.next()).f(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f1266b.isEmpty()) {
                int g = g();
                int f2 = f();
                if (i(g, f2)) {
                    j(g, f2);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f1265a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f1268d);
            }
            this.f1268d = null;
            this.f1266b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(g gVar) {
            int g = g();
            int f2 = f();
            if (i(g, f2)) {
                gVar.f(g, f2);
                return;
            }
            if (!this.f1266b.contains(gVar)) {
                this.f1266b.add(gVar);
            }
            if (this.f1268d == null) {
                ViewTreeObserver viewTreeObserver = this.f1265a.getViewTreeObserver();
                C0055a aVar = new C0055a(this);
                this.f1268d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(g gVar) {
            this.f1266b.remove(gVar);
        }
    }

    public i(T t) {
        h.d(t);
        this.f1259b = (View) t;
        this.f1260c = new a(t);
    }

    private Object i() {
        Integer num = g;
        return num == null ? this.f1259b.getTag() : this.f1259b.getTag(num.intValue());
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f1261d;
        if (onAttachStateChangeListener != null && !this.f1263f) {
            this.f1259b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f1263f = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f1261d;
        if (onAttachStateChangeListener != null && this.f1263f) {
            this.f1259b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f1263f = false;
        }
    }

    private void l(Object obj) {
        Integer num = g;
        if (num == null) {
            this.f1259b.setTag(obj);
        } else {
            this.f1259b.setTag(num.intValue(), obj);
        }
    }

    public void a(g gVar) {
        this.f1260c.k(gVar);
    }

    public void b(Drawable drawable) {
        super.b(drawable);
        j();
    }

    public b e() {
        Object i = i();
        if (i == null) {
            return null;
        }
        if (i instanceof b) {
            return (b) i;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void f(Drawable drawable) {
        super.f(drawable);
        this.f1260c.b();
        if (!this.f1262e) {
            k();
        }
    }

    public void g(g gVar) {
        this.f1260c.d(gVar);
    }

    public void h(b bVar) {
        l(bVar);
    }

    public String toString() {
        return "Target for: " + this.f1259b;
    }
}
