package b.d.k;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.d.k.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static Field f635a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f636b;

    /* renamed from: c  reason: collision with root package name */
    private static WeakHashMap<View, String> f637c;

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<View, t> f638d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Field f639e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f640f = false;

    static class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f641a;

        a(n nVar) {
            this.f641a = nVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return this.f641a.a(view, x.g(windowInsets)).f();
        }
    }

    static class b extends f<Boolean> {
        b(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }
    }

    static class c extends f<CharSequence> {
        c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public CharSequence c(View view) {
            return view.getAccessibilityPaneTitle();
        }
    }

    static class d extends f<Boolean> {
        d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Boolean c(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private WeakHashMap<View, Boolean> j = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    p.u(view, 16);
                }
                this.j.put(view, Boolean.valueOf(z2));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void onGlobalLayout() {
            for (Map.Entry next : this.j.entrySet()) {
                a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
            }
        }

        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f642a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f643b;

        /* renamed from: c  reason: collision with root package name */
        private final int f644c;

        f(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        f(int i, Class<T> cls, int i2, int i3) {
            this.f642a = i;
            this.f643b = cls;
            this.f644c = i3;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f644c;
        }

        /* access modifiers changed from: package-private */
        public abstract T c(View view);

        /* access modifiers changed from: package-private */
        public T d(View view) {
            if (b()) {
                return c(view);
            }
            if (!a()) {
                return null;
            }
            T tag = view.getTag(this.f642a);
            if (this.f643b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
    }

    public interface g {
        boolean a(View view, KeyEvent keyEvent);
    }

    static class h {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f645d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f646a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f647b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f648c = null;

        h() {
        }

        static h a(View view) {
            int i = b.d.c.h;
            h hVar = (h) view.getTag(i);
            if (hVar != null) {
                return hVar;
            }
            h hVar2 = new h();
            view.setTag(i, hVar2);
            return hVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f646a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c2 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f647b == null) {
                this.f647b = new SparseArray<>();
            }
            return this.f647b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(b.d.c.i);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((g) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            Boolean bool = Boolean.TRUE;
            WeakHashMap<View, Boolean> weakHashMap = this.f646a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f645d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f646a == null) {
                        this.f646a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f645d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f646a.put(view, bool);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f646a.put((View) parent, bool);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c2 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c2));
                }
            }
            return c2 != null;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f648c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f648c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d2 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d2.valueAt(indexOfKey);
                d2.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d2.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && p.r(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    static {
        new AtomicInteger(1);
        new e();
    }

    public static void A(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    private static f<Boolean> B() {
        return new b(b.d.c.f545f, Boolean.class, 28);
    }

    public static void C(View view, a aVar) {
        if (aVar == null && (e(view) instanceof a.C0027a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void D(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void E(View view, ColorStateList colorStateList) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (i == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof o) {
            ((o) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void F(View view, PorterDuff.Mode mode) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            view.setBackgroundTintMode(mode);
            if (i == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof o) {
            ((o) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void G(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void H(View view, n nVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (nVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(nVar));
        }
    }

    public static void I(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static void J(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f637c == null) {
            f637c = new WeakHashMap<>();
        }
        f637c.put(view, str);
    }

    public static void K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof h) {
            ((h) view).stopNestedScroll();
        }
    }

    private static f<Boolean> a() {
        return new d(b.d.c.f543d, Boolean.class, 28);
    }

    public static t b(View view) {
        if (f638d == null) {
            f638d = new WeakHashMap<>();
        }
        t tVar = f638d.get(view);
        if (tVar != null) {
            return tVar;
        }
        t tVar2 = new t(view);
        f638d.put(view, tVar2);
        return tVar2;
    }

    static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return h.a(view).b(view, keyEvent);
    }

    static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return h.a(view).f(keyEvent);
    }

    private static View.AccessibilityDelegate e(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : f(view);
    }

    private static View.AccessibilityDelegate f(View view) {
        if (f640f) {
            return null;
        }
        if (f639e == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f639e = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f640f = true;
                return null;
            }
        }
        try {
            Object obj = f639e.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f640f = true;
            return null;
        }
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static CharSequence h(View view) {
        return w().d(view);
    }

    public static ColorStateList i(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof o) {
            return ((o) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static PorterDuff.Mode j(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof o) {
            return ((o) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f636b) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f635a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f636b = true;
        }
        Field field = f635a;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static String m(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f637c;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static boolean o(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean q(View view) {
        Boolean d2 = a().d(view);
        if (d2 == null) {
            return false;
        }
        return d2.booleanValue();
    }

    public static boolean r(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean s(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean t(View view) {
        Boolean d2 = B().d(view);
        if (d2 == null) {
            return false;
        }
        return d2.booleanValue();
    }

    static void u(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = h(view) != null;
            if (g(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static x v(View view, x xVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return xVar;
        }
        WindowInsets f2 = xVar.f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f2);
        if (!onApplyWindowInsets.equals(f2)) {
            f2 = new WindowInsets(onApplyWindowInsets);
        }
        return x.g(f2);
    }

    private static f<CharSequence> w() {
        return new c(b.d.c.f544e, CharSequence.class, 8, 28);
    }

    public static void x(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void y(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void z(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }
}
