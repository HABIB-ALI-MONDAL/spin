package androidx.appcompat.app;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z0;
import b.a.m.b;
import b.a.m.f;
import b.d.k.d;
import b.d.k.p;
import b.d.k.t;
import b.d.k.u;
import b.d.k.v;
import b.d.k.x;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

class f extends e implements h.a, LayoutInflater.Factory2 {
    private static final boolean b0;
    private static final int[] c0 = {16842836};
    private static boolean d0 = true;
    private boolean A = true;
    private boolean B;
    private ViewGroup C;
    private TextView D;
    private View E;
    private boolean F;
    private boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    private boolean M;
    private m[] N;
    private m O;
    private boolean P;
    boolean Q;
    private int R = -100;
    private boolean S;
    private k T;
    boolean U;
    int V;
    private final Runnable W = new b();
    private boolean X;
    private Rect Y;
    private Rect Z;
    private AppCompatViewInflater a0;
    final Context k;
    final Window l;
    final Window.Callback m;
    final Window.Callback n;
    final d o;
    a p;
    MenuInflater q;
    private CharSequence r;
    private a0 s;
    private h t;
    private n u;
    b.a.m.b v;
    ActionBarContextView w;
    PopupWindow x;
    Runnable y;
    t z = null;

    static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f79a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f79a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f79a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f79a.uncaughtException(thread, th);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            f fVar = f.this;
            if ((fVar.V & 1) != 0) {
                fVar.J(0);
            }
            f fVar2 = f.this;
            if ((fVar2.V & 4096) != 0) {
                fVar2.J(108);
            }
            f fVar3 = f.this;
            fVar3.U = false;
            fVar3.V = 0;
        }
    }

    class c implements b.d.k.n {
        c() {
        }

        public x a(View view, x xVar) {
            int d2 = xVar.d();
            int w0 = f.this.w0(d2);
            if (d2 != w0) {
                xVar = xVar.e(xVar.b(), w0, xVar.c(), xVar.a());
            }
            return p.v(view, xVar);
        }
    }

    class d implements e0.a {
        d() {
        }

        public void a(Rect rect) {
            rect.top = f.this.w0(rect.top);
        }
    }

    class e implements ContentFrameLayout.a {
        e() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            f.this.H();
        }
    }

    /* renamed from: androidx.appcompat.app.f$f  reason: collision with other inner class name */
    class C0008f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        class a extends v {
            a() {
            }

            public void a(View view) {
                f.this.w.setAlpha(1.0f);
                f.this.z.f((u) null);
                f.this.z = null;
            }

            public void b(View view) {
                f.this.w.setVisibility(0);
            }
        }

        C0008f() {
        }

        public void run() {
            f fVar = f.this;
            fVar.x.showAtLocation(fVar.w, 55, 0, 0);
            f.this.K();
            if (f.this.p0()) {
                f.this.w.setAlpha(0.0f);
                f fVar2 = f.this;
                t b2 = p.b(fVar2.w);
                b2.a(1.0f);
                fVar2.z = b2;
                f.this.z.f(new a());
                return;
            }
            f.this.w.setAlpha(1.0f);
            f.this.w.setVisibility(0);
        }
    }

    class g extends v {
        g() {
        }

        public void a(View view) {
            f.this.w.setAlpha(1.0f);
            f.this.z.f((u) null);
            f.this.z = null;
        }

        public void b(View view) {
            f.this.w.setVisibility(0);
            f.this.w.sendAccessibilityEvent(32);
            if (f.this.w.getParent() instanceof View) {
                p.A((View) f.this.w.getParent());
            }
        }
    }

    private final class h implements o.a {
        h() {
        }

        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            f.this.C(hVar);
        }

        public boolean b(androidx.appcompat.view.menu.h hVar) {
            Window.Callback S = f.this.S();
            if (S == null) {
                return true;
            }
            S.onMenuOpened(108, hVar);
            return true;
        }
    }

    class i implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f85a;

        class a extends v {
            a() {
            }

            public void a(View view) {
                f.this.w.setVisibility(8);
                f fVar = f.this;
                PopupWindow popupWindow = fVar.x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.w.getParent() instanceof View) {
                    p.A((View) f.this.w.getParent());
                }
                f.this.w.removeAllViews();
                f.this.z.f((u) null);
                f.this.z = null;
            }
        }

        public i(b.a aVar) {
            this.f85a = aVar;
        }

        public boolean a(b.a.m.b bVar, Menu menu) {
            return this.f85a.a(bVar, menu);
        }

        public boolean b(b.a.m.b bVar, MenuItem menuItem) {
            return this.f85a.b(bVar, menuItem);
        }

        public boolean c(b.a.m.b bVar, Menu menu) {
            return this.f85a.c(bVar, menu);
        }

        public void d(b.a.m.b bVar) {
            this.f85a.d(bVar);
            f fVar = f.this;
            if (fVar.x != null) {
                fVar.l.getDecorView().removeCallbacks(f.this.y);
            }
            f fVar2 = f.this;
            if (fVar2.w != null) {
                fVar2.K();
                f fVar3 = f.this;
                t b2 = p.b(fVar3.w);
                b2.a(0.0f);
                fVar3.z = b2;
                f.this.z.f(new a());
            }
            f fVar4 = f.this;
            d dVar = fVar4.o;
            if (dVar != null) {
                dVar.h(fVar4.v);
            }
            f.this.v = null;
        }
    }

    class j extends b.a.m.i {
        j(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.k, callback);
            b.a.m.b s0 = f.this.s0(aVar);
            if (s0 != null) {
                return aVar.e(s0);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.d0(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.g0(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.h0(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.h hVar = menu instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.a0(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.a0(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            androidx.appcompat.view.menu.h hVar;
            m Q = f.this.Q(0, true);
            if (Q == null || (hVar = Q.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, hVar, i);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return f.this.Y() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (!f.this.Y() || i != 0) ? super.onWindowStartingActionMode(callback, i) : a(callback);
        }
    }

    final class k {

        /* renamed from: a  reason: collision with root package name */
        private k f88a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f89b;

        /* renamed from: c  reason: collision with root package name */
        private BroadcastReceiver f90c;

        /* renamed from: d  reason: collision with root package name */
        private IntentFilter f91d;

        class a extends BroadcastReceiver {
            a() {
            }

            public void onReceive(Context context, Intent intent) {
                k.this.b();
            }
        }

        k(k kVar) {
            this.f88a = kVar;
            this.f89b = kVar.d();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f90c;
            if (broadcastReceiver != null) {
                f.this.k.unregisterReceiver(broadcastReceiver);
                this.f90c = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean d2 = this.f88a.d();
            if (d2 != this.f89b) {
                this.f89b = d2;
                f.this.d();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            boolean d2 = this.f88a.d();
            this.f89b = d2;
            return d2 ? 2 : 1;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            a();
            if (this.f90c == null) {
                this.f90c = new a();
            }
            if (this.f91d == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.f91d = intentFilter;
                intentFilter.addAction("android.intent.action.TIME_SET");
                this.f91d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f91d.addAction("android.intent.action.TIME_TICK");
            }
            f.this.k.registerReceiver(this.f90c, this.f91d);
        }
    }

    private class l extends ContentFrameLayout {
        public l(Context context) {
            super(context);
        }

        private boolean c(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.I(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            f.this.D(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(b.a.k.a.a.d(getContext(), i));
        }
    }

    protected static final class m {

        /* renamed from: a  reason: collision with root package name */
        int f94a;

        /* renamed from: b  reason: collision with root package name */
        int f95b;

        /* renamed from: c  reason: collision with root package name */
        int f96c;

        /* renamed from: d  reason: collision with root package name */
        int f97d;

        /* renamed from: e  reason: collision with root package name */
        int f98e;

        /* renamed from: f  reason: collision with root package name */
        int f99f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.h j;
        androidx.appcompat.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        m(int i2) {
            this.f94a = i2;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.p a(o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.f fVar = new androidx.appcompat.view.menu.f(this.l, b.a.g.abc_list_menu_item_layout);
                this.k = fVar;
                fVar.i(aVar);
                this.j.b(this.k);
            }
            return this.k.f(this.g);
        }

        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.b().getCount() > 0;
        }

        /* access modifiers changed from: package-private */
        public void c(androidx.appcompat.view.menu.h hVar) {
            androidx.appcompat.view.menu.f fVar;
            androidx.appcompat.view.menu.h hVar2 = this.j;
            if (hVar != hVar2) {
                if (hVar2 != null) {
                    hVar2.O(this.k);
                }
                this.j = hVar;
                if (hVar != null && (fVar = this.k) != null) {
                    hVar.b(fVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(b.a.a.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(b.a.a.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 == 0) {
                i3 = b.a.i.Theme_AppCompat_CompactMenu;
            }
            newTheme.applyStyle(i3, true);
            b.a.m.d dVar = new b.a.m.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(b.a.j.B0);
            this.f95b = obtainStyledAttributes.getResourceId(b.a.j.E0, 0);
            this.f99f = obtainStyledAttributes.getResourceId(b.a.j.D0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private final class n implements o.a {
        n() {
        }

        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            androidx.appcompat.view.menu.h D = hVar.D();
            boolean z2 = D != hVar;
            f fVar = f.this;
            if (z2) {
                hVar = D;
            }
            m N = fVar.N(hVar);
            if (N == null) {
                return;
            }
            if (z2) {
                f.this.B(N.f94a, N, D);
                f.this.E(N, true);
                return;
            }
            f.this.E(N, z);
        }

        public boolean b(androidx.appcompat.view.menu.h hVar) {
            Window.Callback S;
            if (hVar != null) {
                return true;
            }
            f fVar = f.this;
            if (!fVar.H || (S = fVar.S()) == null || f.this.Q) {
                return true;
            }
            S.onMenuOpened(108, hVar);
            return true;
        }
    }

    static {
        boolean z2 = Build.VERSION.SDK_INT < 21;
        b0 = z2;
        if (z2 && !d0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    f(Context context, Window window, d dVar) {
        this.k = context;
        this.l = window;
        this.o = dVar;
        Window.Callback callback = window.getCallback();
        this.m = callback;
        if (!(callback instanceof j)) {
            j jVar = new j(callback);
            this.n = jVar;
            window.setCallback(jVar);
            t0 s2 = t0.s(context, (AttributeSet) null, c0);
            Drawable g2 = s2.g(0);
            if (g2 != null) {
                window.setBackgroundDrawable(g2);
            }
            s2.u();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void A() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.C.findViewById(16908290);
        View decorView = this.l.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(b.a.j.B0);
        obtainStyledAttributes.getValue(b.a.j.N0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(b.a.j.O0, contentFrameLayout.getMinWidthMinor());
        int i2 = b.a.j.L0;
        if (obtainStyledAttributes.hasValue(i2)) {
            obtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = b.a.j.M0;
        if (obtainStyledAttributes.hasValue(i3)) {
            obtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = b.a.j.J0;
        if (obtainStyledAttributes.hasValue(i4)) {
            obtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = b.a.j.K0;
        if (obtainStyledAttributes.hasValue(i5)) {
            obtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup F() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(b.a.j.B0);
        int i2 = b.a.j.G0;
        if (obtainStyledAttributes.hasValue(i2)) {
            if (obtainStyledAttributes.getBoolean(b.a.j.P0, false)) {
                u(1);
            } else if (obtainStyledAttributes.getBoolean(i2, false)) {
                u(108);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.H0, false)) {
                u(109);
            }
            if (obtainStyledAttributes.getBoolean(b.a.j.I0, false)) {
                u(10);
            }
            this.K = obtainStyledAttributes.getBoolean(b.a.j.C0, false);
            obtainStyledAttributes.recycle();
            this.l.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.k);
            if (this.L) {
                viewGroup = (ViewGroup) from.inflate(this.J ? b.a.g.abc_screen_simple_overlay_action_mode : b.a.g.abc_screen_simple, (ViewGroup) null);
                if (Build.VERSION.SDK_INT >= 21) {
                    p.H(viewGroup, new c());
                } else {
                    ((e0) viewGroup).setOnFitSystemWindowsListener(new d());
                }
            } else if (this.K) {
                viewGroup = (ViewGroup) from.inflate(b.a.g.abc_dialog_title_material, (ViewGroup) null);
                this.I = false;
                this.H = false;
            } else if (this.H) {
                TypedValue typedValue = new TypedValue();
                this.k.getTheme().resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new b.a.m.d(this.k, typedValue.resourceId) : this.k).inflate(b.a.g.abc_screen_toolbar, (ViewGroup) null);
                a0 a0Var = (a0) viewGroup.findViewById(b.a.f.decor_content_parent);
                this.s = a0Var;
                a0Var.setWindowCallback(S());
                if (this.I) {
                    this.s.k(109);
                }
                if (this.F) {
                    this.s.k(2);
                }
                if (this.G) {
                    this.s.k(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.s == null) {
                    this.D = (TextView) viewGroup.findViewById(b.a.f.M);
                }
                z0.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(b.a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.l.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.H + ", windowActionBarOverlay: " + this.I + ", android:windowIsFloating: " + this.K + ", windowActionModeOverlay: " + this.J + ", windowNoTitle: " + this.L + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void L() {
        if (this.T == null) {
            this.T = new k(k.a(this.k));
        }
    }

    private void M() {
        if (!this.B) {
            this.C = F();
            CharSequence R2 = R();
            if (!TextUtils.isEmpty(R2)) {
                a0 a0Var = this.s;
                if (a0Var != null) {
                    a0Var.setWindowTitle(R2);
                } else if (k0() != null) {
                    k0().y(R2);
                } else {
                    TextView textView = this.D;
                    if (textView != null) {
                        textView.setText(R2);
                    }
                }
            }
            A();
            i0(this.C);
            this.B = true;
            m Q2 = Q(0, false);
            if (this.Q) {
                return;
            }
            if (Q2 == null || Q2.j == null) {
                X(108);
            }
        }
    }

    private int P() {
        int i2 = this.R;
        return i2 != -100 ? i2 : e.h();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void T() {
        /*
            r3 = this;
            r3.M()
            boolean r0 = r3.H
            if (r0 == 0) goto L_0x0037
            androidx.appcompat.app.a r0 = r3.p
            if (r0 == 0) goto L_0x000c
            goto L_0x0037
        L_0x000c:
            android.view.Window$Callback r0 = r3.m
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0020
            androidx.appcompat.app.l r0 = new androidx.appcompat.app.l
            android.view.Window$Callback r1 = r3.m
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.I
            r0.<init>(r1, r2)
        L_0x001d:
            r3.p = r0
            goto L_0x002e
        L_0x0020:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L_0x002e
            androidx.appcompat.app.l r0 = new androidx.appcompat.app.l
            android.view.Window$Callback r1 = r3.m
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L_0x001d
        L_0x002e:
            androidx.appcompat.app.a r0 = r3.p
            if (r0 == 0) goto L_0x0037
            boolean r1 = r3.X
            r0.r(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.T():void");
    }

    private boolean U(m mVar) {
        View view = mVar.i;
        if (view != null) {
            mVar.h = view;
            return true;
        } else if (mVar.j == null) {
            return false;
        } else {
            if (this.u == null) {
                this.u = new n();
            }
            View view2 = (View) mVar.a(this.u);
            mVar.h = view2;
            return view2 != null;
        }
    }

    private boolean V(m mVar) {
        mVar.d(O());
        mVar.g = new l(mVar.l);
        mVar.f96c = 81;
        return true;
    }

    private boolean W(m mVar) {
        Context context = this.k;
        int i2 = mVar.f94a;
        if ((i2 == 0 || i2 == 108) && this.s != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(b.a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                b.a.m.d dVar = new b.a.m.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
        hVar.R(this);
        mVar.c(hVar);
        return true;
    }

    private void X(int i2) {
        this.V = (1 << i2) | this.V;
        if (!this.U) {
            p.y(this.l.getDecorView(), this.W);
            this.U = true;
        }
    }

    private boolean c0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        m Q2 = Q(i2, true);
        if (!Q2.o) {
            return m0(Q2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            b.a.m.b r0 = r4.v
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.f$m r2 = r4.Q(r5, r0)
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.a0 r5 = r4.s
            if (r5 == 0) goto L_0x0043
            boolean r5 = r5.g()
            if (r5 == 0) goto L_0x0043
            android.content.Context r5 = r4.k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L_0x0043
            androidx.appcompat.widget.a0 r5 = r4.s
            boolean r5 = r5.c()
            if (r5 != 0) goto L_0x003c
            boolean r5 = r4.Q
            if (r5 != 0) goto L_0x0062
            boolean r5 = r4.m0(r2, r6)
            if (r5 == 0) goto L_0x0062
            androidx.appcompat.widget.a0 r5 = r4.s
            boolean r0 = r5.e()
            goto L_0x0068
        L_0x003c:
            androidx.appcompat.widget.a0 r5 = r4.s
            boolean r0 = r5.d()
            goto L_0x0068
        L_0x0043:
            boolean r5 = r2.o
            if (r5 != 0) goto L_0x0064
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r5 = r2.m
            if (r5 == 0) goto L_0x0062
            boolean r5 = r2.r
            if (r5 == 0) goto L_0x005b
            r2.m = r1
            boolean r5 = r4.m0(r2, r6)
            goto L_0x005c
        L_0x005b:
            r5 = 1
        L_0x005c:
            if (r5 == 0) goto L_0x0062
            r4.j0(r2, r6)
            goto L_0x0068
        L_0x0062:
            r0 = 0
            goto L_0x0068
        L_0x0064:
            r4.E(r2, r0)
            r0 = r5
        L_0x0068:
            if (r0 == 0) goto L_0x0081
            android.content.Context r5 = r4.k
            java.lang.String r6 = "audio"
            java.lang.Object r5 = r5.getSystemService(r6)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007a
            r5.playSoundEffect(r1)
            goto L_0x0081
        L_0x007a:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r6 = "Couldn't get audio manager"
            android.util.Log.w(r5, r6)
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.f0(int, android.view.KeyEvent):boolean");
    }

    private void j0(m mVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!mVar.o && !this.Q) {
            if (mVar.f94a == 0) {
                if ((this.k.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback S2 = S();
            if (S2 == null || S2.onMenuOpened(mVar.f94a, mVar.j)) {
                WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
                if (windowManager != null && m0(mVar, keyEvent)) {
                    ViewGroup viewGroup = mVar.g;
                    if (viewGroup == null || mVar.q) {
                        if (viewGroup == null) {
                            if (!V(mVar) || mVar.g == null) {
                                return;
                            }
                        } else if (mVar.q && viewGroup.getChildCount() > 0) {
                            mVar.g.removeAllViews();
                        }
                        if (U(mVar) && mVar.b()) {
                            ViewGroup.LayoutParams layoutParams2 = mVar.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            mVar.g.setBackgroundResource(mVar.f95b);
                            ViewParent parent = mVar.h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(mVar.h);
                            }
                            mVar.g.addView(mVar.h, layoutParams2);
                            if (!mVar.h.hasFocus()) {
                                mVar.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = mVar.i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i2 = -1;
                            mVar.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, mVar.f97d, mVar.f98e, 1002, 8519680, -3);
                            layoutParams3.gravity = mVar.f96c;
                            layoutParams3.windowAnimations = mVar.f99f;
                            windowManager.addView(mVar.g, layoutParams3);
                            mVar.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    mVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, mVar.f97d, mVar.f98e, 1002, 8519680, -3);
                    layoutParams32.gravity = mVar.f96c;
                    layoutParams32.windowAnimations = mVar.f99f;
                    windowManager.addView(mVar.g, layoutParams32);
                    mVar.o = true;
                    return;
                }
                return;
            }
            E(mVar, true);
        }
    }

    private boolean l0(m mVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.h hVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((mVar.m || m0(mVar, keyEvent)) && (hVar = mVar.j) != null) {
            z2 = hVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.s == null) {
            E(mVar, true);
        }
        return z2;
    }

    private boolean m0(m mVar, KeyEvent keyEvent) {
        a0 a0Var;
        a0 a0Var2;
        a0 a0Var3;
        a0 a0Var4;
        if (this.Q) {
            return false;
        }
        if (mVar.m) {
            return true;
        }
        m mVar2 = this.O;
        if (!(mVar2 == null || mVar2 == mVar)) {
            E(mVar2, false);
        }
        Window.Callback S2 = S();
        if (S2 != null) {
            mVar.i = S2.onCreatePanelView(mVar.f94a);
        }
        int i2 = mVar.f94a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (a0Var4 = this.s) != null) {
            a0Var4.f();
        }
        if (mVar.i == null && (!z2 || !(k0() instanceof i))) {
            androidx.appcompat.view.menu.h hVar = mVar.j;
            if (hVar == null || mVar.r) {
                if (hVar == null && (!W(mVar) || mVar.j == null)) {
                    return false;
                }
                if (z2 && (a0Var3 = this.s) != null) {
                    if (this.t == null) {
                        this.t = new h();
                    }
                    a0Var3.a(mVar.j, this.t);
                }
                mVar.j.d0();
                if (!S2.onCreatePanelMenu(mVar.f94a, mVar.j)) {
                    mVar.c((androidx.appcompat.view.menu.h) null);
                    if (z2 && (a0Var2 = this.s) != null) {
                        a0Var2.a((Menu) null, this.t);
                    }
                    return false;
                }
                mVar.r = false;
            }
            mVar.j.d0();
            Bundle bundle = mVar.s;
            if (bundle != null) {
                mVar.j.P(bundle);
                mVar.s = null;
            }
            if (!S2.onPreparePanel(0, mVar.i, mVar.j)) {
                if (z2 && (a0Var = this.s) != null) {
                    a0Var.a((Menu) null, this.t);
                }
                mVar.j.c0();
                return false;
            }
            boolean z3 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            mVar.p = z3;
            mVar.j.setQwertyMode(z3);
            mVar.j.c0();
        }
        mVar.m = true;
        mVar.n = false;
        this.O = mVar;
        return true;
    }

    private void n0(androidx.appcompat.view.menu.h hVar, boolean z2) {
        a0 a0Var = this.s;
        if (a0Var == null || !a0Var.g() || (ViewConfiguration.get(this.k).hasPermanentMenuKey() && !this.s.b())) {
            m Q2 = Q(0, true);
            Q2.q = true;
            E(Q2, false);
            j0(Q2, (KeyEvent) null);
            return;
        }
        Window.Callback S2 = S();
        if (this.s.c() && z2) {
            this.s.d();
            if (!this.Q) {
                S2.onPanelClosed(108, Q(0, true).j);
            }
        } else if (S2 != null && !this.Q) {
            if (this.U && (this.V & 1) != 0) {
                this.l.getDecorView().removeCallbacks(this.W);
                this.W.run();
            }
            m Q3 = Q(0, true);
            androidx.appcompat.view.menu.h hVar2 = Q3.j;
            if (hVar2 != null && !Q3.r && S2.onPreparePanel(0, Q3.i, hVar2)) {
                S2.onMenuOpened(108, Q3.j);
                this.s.e();
            }
        }
    }

    private int o0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private boolean q0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || p.r((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean r0() {
        if (this.S) {
            Context context = this.k;
            if (context instanceof Activity) {
                PackageManager packageManager = context.getPackageManager();
                try {
                    Context context2 = this.k;
                    return (packageManager.getActivityInfo(new ComponentName(context2, context2.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    private void u0() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private boolean v0(int i2) {
        Resources resources = this.k.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 == i4) {
            return false;
        }
        if (r0()) {
            ((Activity) this.k).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i4 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        h.a(resources);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void B(int i2, m mVar, Menu menu) {
        if (menu == null) {
            if (mVar == null && i2 >= 0) {
                m[] mVarArr = this.N;
                if (i2 < mVarArr.length) {
                    mVar = mVarArr[i2];
                }
            }
            if (mVar != null) {
                menu = mVar.j;
            }
        }
        if ((mVar == null || mVar.o) && !this.Q) {
            this.m.onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(androidx.appcompat.view.menu.h hVar) {
        if (!this.M) {
            this.M = true;
            this.s.l();
            Window.Callback S2 = S();
            if (S2 != null && !this.Q) {
                S2.onPanelClosed(108, hVar);
            }
            this.M = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void D(int i2) {
        E(Q(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void E(m mVar, boolean z2) {
        ViewGroup viewGroup;
        a0 a0Var;
        if (!z2 || mVar.f94a != 0 || (a0Var = this.s) == null || !a0Var.c()) {
            WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
            if (!(windowManager == null || !mVar.o || (viewGroup = mVar.g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    B(mVar.f94a, mVar, (Menu) null);
                }
            }
            mVar.m = false;
            mVar.n = false;
            mVar.o = false;
            mVar.h = null;
            mVar.q = true;
            if (this.O == mVar) {
                this.O = null;
                return;
            }
            return;
        }
        C(mVar.j);
    }

    public View G(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        AppCompatViewInflater appCompatViewInflater;
        boolean z3 = false;
        if (this.a0 == null) {
            String string = this.k.obtainStyledAttributes(b.a.j.B0).getString(b.a.j.F0);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.a0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                }
            }
            this.a0 = appCompatViewInflater;
        }
        boolean z4 = b0;
        if (z4) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = q0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.a0.p(view, str, context, attributeSet, z2, z4, true, y0.b());
    }

    /* access modifiers changed from: package-private */
    public void H() {
        androidx.appcompat.view.menu.h hVar;
        a0 a0Var = this.s;
        if (a0Var != null) {
            a0Var.l();
        }
        if (this.x != null) {
            this.l.getDecorView().removeCallbacks(this.y);
            if (this.x.isShowing()) {
                try {
                    this.x.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.x = null;
        }
        K();
        m Q2 = Q(0, false);
        if (Q2 != null && (hVar = Q2.j) != null) {
            hVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.m;
        boolean z2 = true;
        if (((callback instanceof d.a) || (callback instanceof g)) && (decorView = this.l.getDecorView()) != null && b.d.k.d.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.m.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? b0(keyCode, keyEvent) : e0(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public void J(int i2) {
        m Q2;
        m Q3 = Q(i2, true);
        if (Q3.j != null) {
            Bundle bundle = new Bundle();
            Q3.j.Q(bundle);
            if (bundle.size() > 0) {
                Q3.s = bundle;
            }
            Q3.j.d0();
            Q3.j.clear();
        }
        Q3.r = true;
        Q3.q = true;
        if ((i2 == 108 || i2 == 0) && this.s != null && (Q2 = Q(0, false)) != null) {
            Q2.m = false;
            m0(Q2, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        t tVar = this.z;
        if (tVar != null) {
            tVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public m N(Menu menu) {
        m[] mVarArr = this.N;
        int length = mVarArr != null ? mVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            m mVar = mVarArr[i2];
            if (mVar != null && mVar.j == menu) {
                return mVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Context O() {
        a j2 = j();
        Context k2 = j2 != null ? j2.k() : null;
        return k2 == null ? this.k : k2;
    }

    /* access modifiers changed from: protected */
    public m Q(int i2, boolean z2) {
        m[] mVarArr = this.N;
        if (mVarArr == null || mVarArr.length <= i2) {
            m[] mVarArr2 = new m[(i2 + 1)];
            if (mVarArr != null) {
                System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
            }
            this.N = mVarArr2;
            mVarArr = mVarArr2;
        }
        m mVar = mVarArr[i2];
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(i2);
        mVarArr[i2] = mVar2;
        return mVar2;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence R() {
        Window.Callback callback = this.m;
        return callback instanceof Activity ? ((Activity) callback).getTitle() : this.r;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback S() {
        return this.l.getCallback();
    }

    public boolean Y() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public int Z(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.k.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        L();
        return this.T.c();
    }

    public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        m N2;
        Window.Callback S2 = S();
        if (S2 == null || this.Q || (N2 = N(hVar.D())) == null) {
            return false;
        }
        return S2.onMenuItemSelected(N2.f94a, menuItem);
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        b.a.m.b bVar = this.v;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        a j2 = j();
        return j2 != null && j2.h();
    }

    public void b(androidx.appcompat.view.menu.h hVar) {
        n0(hVar, true);
    }

    /* access modifiers changed from: package-private */
    public boolean b0(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.P = z2;
        } else if (i2 == 82) {
            c0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        M();
        ((ViewGroup) this.C.findViewById(16908290)).addView(view, layoutParams);
        this.m.onContentChanged();
    }

    public boolean d() {
        int P2 = P();
        int Z2 = Z(P2);
        boolean v0 = Z2 != -1 ? v0(Z2) : false;
        if (P2 == 0) {
            L();
            this.T.d();
        }
        this.S = true;
        return v0;
    }

    /* access modifiers changed from: package-private */
    public boolean d0(int i2, KeyEvent keyEvent) {
        a j2 = j();
        if (j2 != null && j2.o(i2, keyEvent)) {
            return true;
        }
        m mVar = this.O;
        if (mVar == null || !l0(mVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.O == null) {
                m Q2 = Q(0, true);
                m0(Q2, keyEvent);
                boolean l0 = l0(Q2, keyEvent.getKeyCode(), keyEvent, 1);
                Q2.m = false;
                if (l0) {
                    return true;
                }
            }
            return false;
        }
        m mVar2 = this.O;
        if (mVar2 != null) {
            mVar2.n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean e0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.P;
            this.P = false;
            m Q2 = Q(0, false);
            if (Q2 != null && Q2.o) {
                if (!z2) {
                    E(Q2, true);
                }
                return true;
            } else if (a0()) {
                return true;
            }
        } else if (i2 == 82) {
            f0(0, keyEvent);
            return true;
        }
        return false;
    }

    public <T extends View> T g(int i2) {
        M();
        return this.l.findViewById(i2);
    }

    /* access modifiers changed from: package-private */
    public void g0(int i2) {
        a j2;
        if (i2 == 108 && (j2 = j()) != null) {
            j2.i(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void h0(int i2) {
        if (i2 == 108) {
            a j2 = j();
            if (j2 != null) {
                j2.i(false);
            }
        } else if (i2 == 0) {
            m Q2 = Q(i2, true);
            if (Q2.o) {
                E(Q2, false);
            }
        }
    }

    public MenuInflater i() {
        if (this.q == null) {
            T();
            a aVar = this.p;
            this.q = new b.a.m.g(aVar != null ? aVar.k() : this.k);
        }
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void i0(ViewGroup viewGroup) {
    }

    public a j() {
        T();
        return this.p;
    }

    public void k() {
        LayoutInflater from = LayoutInflater.from(this.k);
        if (from.getFactory() == null) {
            b.d.k.e.b(from, this);
        } else if (!(from.getFactory2() instanceof f)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* access modifiers changed from: package-private */
    public final a k0() {
        return this.p;
    }

    public void l() {
        a j2 = j();
        if (j2 == null || !j2.l()) {
            X(0);
        }
    }

    public void m(Configuration configuration) {
        a j2;
        if (this.H && this.B && (j2 = j()) != null) {
            j2.m(configuration);
        }
        androidx.appcompat.widget.j.n().y(this.k);
        d();
    }

    public void n(Bundle bundle) {
        Window.Callback callback = this.m;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.e.c((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                a k0 = k0();
                if (k0 == null) {
                    this.X = true;
                } else {
                    k0.r(true);
                }
            }
        }
        if (bundle != null && this.R == -100) {
            this.R = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void o() {
        if (this.U) {
            this.l.getDecorView().removeCallbacks(this.W);
        }
        this.Q = true;
        a aVar = this.p;
        if (aVar != null) {
            aVar.n();
        }
        k kVar = this.T;
        if (kVar != null) {
            kVar.a();
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return G(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void p(Bundle bundle) {
        M();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.C;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p0() {
        /*
            r1 = this;
            boolean r0 = r1.B
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.C
            if (r0 == 0) goto L_0x0010
            boolean r0 = b.d.k.p.s(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.p0():boolean");
    }

    public void q() {
        a j2 = j();
        if (j2 != null) {
            j2.w(true);
        }
    }

    public void r(Bundle bundle) {
        int i2 = this.R;
        if (i2 != -100) {
            bundle.putInt("appcompat:local_night_mode", i2);
        }
    }

    public void s() {
        d();
    }

    public b.a.m.b s0(b.a aVar) {
        d dVar;
        if (aVar != null) {
            b.a.m.b bVar = this.v;
            if (bVar != null) {
                bVar.c();
            }
            i iVar = new i(aVar);
            a j2 = j();
            if (j2 != null) {
                b.a.m.b z2 = j2.z(iVar);
                this.v = z2;
                if (!(z2 == null || (dVar = this.o) == null)) {
                    dVar.f(z2);
                }
            }
            if (this.v == null) {
                this.v = t0(iVar);
            }
            return this.v;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void t() {
        a j2 = j();
        if (j2 != null) {
            j2.w(false);
        }
        k kVar = this.T;
        if (kVar != null) {
            kVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b.a.m.b t0(b.a.m.b.a r8) {
        /*
            r7 = this;
            r7.K()
            b.a.m.b r0 = r7.v
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.f.i
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.f$i r0 = new androidx.appcompat.app.f$i
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.d r0 = r7.o
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.Q
            if (r2 != 0) goto L_0x0022
            b.a.m.b r0 = r0.i(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.v = r0
            goto L_0x0161
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.w
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.K
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.k
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = b.a.a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.k
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            b.a.m.d r4 = new b.a.m.d
            android.content.Context r6 = r7.k
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.k
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.w = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = b.a.a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.x = r5
            r6 = 2
            androidx.core.widget.h.b(r5, r6)
            android.widget.PopupWindow r5 = r7.x
            androidx.appcompat.widget.ActionBarContextView r6 = r7.w
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.x
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = b.a.a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.w
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.x
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.f$f r0 = new androidx.appcompat.app.f$f
            r0.<init>()
            r7.y = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.C
            int r4 = b.a.f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.O()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.w = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.w
            if (r0 == 0) goto L_0x0161
            r7.K()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.w
            r0.k()
            b.a.m.e r0 = new b.a.m.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.w
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.w
            android.widget.PopupWindow r6 = r7.x
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = 0
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.e()
            boolean r8 = r8.c(r0, r3)
            if (r8 == 0) goto L_0x015f
            r0.k()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            r8.h(r0)
            r7.v = r0
            boolean r8 = r7.p0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0129
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            b.d.k.t r8 = b.d.k.p.b(r8)
            r8.a(r0)
            r7.z = r8
            androidx.appcompat.app.f$g r0 = new androidx.appcompat.app.f$g
            r0.<init>()
            r8.f(r0)
            goto L_0x014f
        L_0x0129:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x014f
            androidx.appcompat.widget.ActionBarContextView r8 = r7.w
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            b.d.k.p.A(r8)
        L_0x014f:
            android.widget.PopupWindow r8 = r7.x
            if (r8 == 0) goto L_0x0161
            android.view.Window r8 = r7.l
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.y
            r8.post(r0)
            goto L_0x0161
        L_0x015f:
            r7.v = r1
        L_0x0161:
            b.a.m.b r8 = r7.v
            if (r8 == 0) goto L_0x016c
            androidx.appcompat.app.d r0 = r7.o
            if (r0 == 0) goto L_0x016c
            r0.f(r8)
        L_0x016c:
            b.a.m.b r8 = r7.v
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.t0(b.a.m.b$a):b.a.m.b");
    }

    public boolean u(int i2) {
        int o0 = o0(i2);
        if (this.L && o0 == 108) {
            return true;
        }
        if (this.H && o0 == 1) {
            this.H = true;
        }
        if (o0 == 1) {
            u0();
            this.L = true;
            return true;
        } else if (o0 == 2) {
            u0();
            this.F = true;
            return true;
        } else if (o0 == 5) {
            u0();
            this.G = true;
            return true;
        } else if (o0 == 10) {
            u0();
            this.J = true;
            return true;
        } else if (o0 == 108) {
            u0();
            this.H = true;
            return true;
        } else if (o0 == 109) {
            return this.l.requestFeature(o0);
        } else {
            u0();
            this.I = true;
            return true;
        }
    }

    public void v(int i2) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i2, viewGroup);
        this.m.onContentChanged();
    }

    public void w(View view) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public int w0(int i2) {
        boolean z2;
        boolean z3;
        ActionBarContextView actionBarContextView = this.w;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
            boolean z4 = true;
            if (this.w.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect = this.Y;
                Rect rect2 = this.Z;
                rect.set(0, i2, 0, 0);
                z0.a(this.C, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.E;
                    if (view == null) {
                        View view2 = new View(this.k);
                        this.E = view2;
                        view2.setBackgroundColor(this.k.getResources().getColor(b.a.c.abc_input_method_navigation_guard));
                        this.C.addView(this.E, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.E.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.E == null) {
                    z4 = false;
                }
                if (!this.J && z4) {
                    i2 = 0;
                }
                boolean z5 = z4;
                z4 = z3;
                z2 = z5;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.w.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.E;
        if (view3 != null) {
            if (!z2) {
                i3 = 8;
            }
            view3.setVisibility(i3);
        }
        return i2;
    }

    public void x(View view, ViewGroup.LayoutParams layoutParams) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.onContentChanged();
    }

    public void y(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.m instanceof Activity) {
            a j2 = j();
            if (!(j2 instanceof l)) {
                this.q = null;
                if (j2 != null) {
                    j2.n();
                }
                if (toolbar != null) {
                    i iVar = new i(toolbar, ((Activity) this.m).getTitle(), this.n);
                    this.p = iVar;
                    window = this.l;
                    callback = iVar.B();
                } else {
                    this.p = null;
                    window = this.l;
                    callback = this.n;
                }
                window.setCallback(callback);
                l();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public final void z(CharSequence charSequence) {
        this.r = charSequence;
        a0 a0Var = this.s;
        if (a0Var != null) {
            a0Var.setWindowTitle(charSequence);
        } else if (k0() != null) {
            k0().y(charSequence);
        } else {
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }
}
