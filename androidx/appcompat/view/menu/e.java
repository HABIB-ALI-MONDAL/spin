package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.j0;
import b.a.g;
import b.d.k.p;
import java.util.ArrayList;
import java.util.List;

final class e extends m implements o, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int K = g.abc_cascading_menu_item_layout;
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private o.a G;
    ViewTreeObserver H;
    private PopupWindow.OnDismissListener I;
    boolean J;
    private final Context k;
    private final int l;
    private final int m;
    private final int n;
    private final boolean o;
    final Handler p;
    private final List<h> q = new ArrayList();
    final List<d> r = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener s = new a();
    private final View.OnAttachStateChangeListener t = new b();
    private final i0 u = new c();
    private int v = 0;
    private int w = 0;
    private View x;
    View y;
    private int z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (e.this.f() && e.this.r.size() > 0 && !e.this.r.get(0).f146a.p()) {
                View view = e.this.y;
                if (view == null || !view.isShown()) {
                    e.this.dismiss();
                    return;
                }
                for (d dVar : e.this.r) {
                    dVar.f146a.b();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = e.this.H;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    e.this.H = view.getViewTreeObserver();
                }
                e eVar = e.this;
                eVar.H.removeGlobalOnLayoutListener(eVar.s);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements i0 {

        class a implements Runnable {
            final /* synthetic */ d j;
            final /* synthetic */ MenuItem k;
            final /* synthetic */ h l;

            a(d dVar, MenuItem menuItem, h hVar) {
                this.j = dVar;
                this.k = menuItem;
                this.l = hVar;
            }

            public void run() {
                d dVar = this.j;
                if (dVar != null) {
                    e.this.J = true;
                    dVar.f147b.e(false);
                    e.this.J = false;
                }
                if (this.k.isEnabled() && this.k.hasSubMenu()) {
                    this.l.L(this.k, 4);
                }
            }
        }

        c() {
        }

        public void a(h hVar, MenuItem menuItem) {
            d dVar = null;
            e.this.p.removeCallbacksAndMessages((Object) null);
            int size = e.this.r.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.r.get(i).f147b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < e.this.r.size()) {
                    dVar = e.this.r.get(i2);
                }
                e.this.p.postAtTime(new a(dVar, menuItem, hVar), hVar, SystemClock.uptimeMillis() + 200);
            }
        }

        public void c(h hVar, MenuItem menuItem) {
            e.this.p.removeCallbacksAndMessages(hVar);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final j0 f146a;

        /* renamed from: b  reason: collision with root package name */
        public final h f147b;

        /* renamed from: c  reason: collision with root package name */
        public final int f148c;

        public d(j0 j0Var, h hVar, int i) {
            this.f146a = j0Var;
            this.f147b = hVar;
            this.f148c = i;
        }

        public ListView a() {
            return this.f146a.g();
        }
    }

    public e(Context context, View view, int i, int i2, boolean z2) {
        this.k = context;
        this.x = view;
        this.m = i;
        this.n = i2;
        this.o = z2;
        this.E = false;
        this.z = D();
        Resources resources = context.getResources();
        this.l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.a.d.abc_config_prefDialogWidth));
        this.p = new Handler();
    }

    private int A(h hVar) {
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            if (hVar == this.r.get(i).f147b) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem B(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View C(d dVar, h hVar) {
        int i;
        g gVar;
        int firstVisiblePosition;
        MenuItem B2 = B(dVar.f147b, hVar);
        if (B2 == null) {
            return null;
        }
        ListView a2 = dVar.a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            i = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (B2 == gVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int D() {
        return p.k(this.x) == 1 ? 0 : 1;
    }

    private int E(int i) {
        List<d> list = this.r;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.y.getWindowVisibleDisplayFrame(rect);
        return this.z == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    private void F(h hVar) {
        View view;
        d dVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.k);
        g gVar = new g(hVar, from, this.o, K);
        if (!f() && this.E) {
            gVar.d(true);
        } else if (f()) {
            gVar.d(m.x(hVar));
        }
        int o2 = m.o(gVar, (ViewGroup) null, this.k, this.l);
        j0 z2 = z();
        z2.r(gVar);
        z2.v(o2);
        z2.w(this.w);
        if (this.r.size() > 0) {
            List<d> list = this.r;
            dVar = list.get(list.size() - 1);
            view = C(dVar, hVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            z2.M(false);
            z2.J((Object) null);
            int E2 = E(o2);
            boolean z3 = E2 == 1;
            this.z = E2;
            if (Build.VERSION.SDK_INT >= 26) {
                z2.s(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.x.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.w & 7) == 5) {
                    iArr[0] = iArr[0] + this.x.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.w & 5) != 5) {
                if (z3) {
                    o2 = view.getWidth();
                }
                i3 = i - o2;
                z2.y(i3);
                z2.D(true);
                z2.H(i2);
            } else if (!z3) {
                o2 = view.getWidth();
                i3 = i - o2;
                z2.y(i3);
                z2.D(true);
                z2.H(i2);
            }
            i3 = i + o2;
            z2.y(i3);
            z2.D(true);
            z2.H(i2);
        } else {
            if (this.A) {
                z2.y(this.C);
            }
            if (this.B) {
                z2.H(this.D);
            }
            z2.x(n());
        }
        this.r.add(new d(z2, hVar, this.z));
        z2.b();
        ListView g = z2.g();
        g.setOnKeyListener(this);
        if (dVar == null && this.F && hVar.x() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, g, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(hVar.x());
            g.addHeaderView(frameLayout, (Object) null, false);
            z2.b();
        }
    }

    private j0 z() {
        j0 j0Var = new j0(this.k, (AttributeSet) null, this.m, this.n);
        j0Var.L(this.u);
        j0Var.C(this);
        j0Var.B(this);
        j0Var.s(this.x);
        j0Var.w(this.w);
        j0Var.A(true);
        j0Var.z(2);
        return j0Var;
    }

    public void a(h hVar, boolean z2) {
        int A2 = A(hVar);
        if (A2 >= 0) {
            int i = A2 + 1;
            if (i < this.r.size()) {
                this.r.get(i).f147b.e(false);
            }
            d remove = this.r.remove(A2);
            remove.f147b.O(this);
            if (this.J) {
                remove.f146a.K((Object) null);
                remove.f146a.t(0);
            }
            remove.f146a.dismiss();
            int size = this.r.size();
            this.z = size > 0 ? this.r.get(size - 1).f148c : D();
            if (size == 0) {
                dismiss();
                o.a aVar = this.G;
                if (aVar != null) {
                    aVar.a(hVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.H;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.H.removeGlobalOnLayoutListener(this.s);
                    }
                    this.H = null;
                }
                this.y.removeOnAttachStateChangeListener(this.t);
                this.I.onDismiss();
            } else if (z2) {
                this.r.get(0).f147b.e(false);
            }
        }
    }

    public void b() {
        if (!f()) {
            for (h F2 : this.q) {
                F(F2);
            }
            this.q.clear();
            View view = this.x;
            this.y = view;
            if (view != null) {
                boolean z2 = this.H == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.H = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.s);
                }
                this.y.addOnAttachStateChangeListener(this.t);
            }
        }
    }

    public boolean c() {
        return false;
    }

    public void dismiss() {
        int size = this.r.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.r.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.f146a.f()) {
                    dVar.f146a.dismiss();
                }
            }
        }
    }

    public boolean f() {
        return this.r.size() > 0 && this.r.get(0).f146a.f();
    }

    public ListView g() {
        if (this.r.isEmpty()) {
            return null;
        }
        List<d> list = this.r;
        return list.get(list.size() - 1).a();
    }

    public void i(o.a aVar) {
        this.G = aVar;
    }

    public boolean j(u uVar) {
        for (d next : this.r) {
            if (uVar == next.f147b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        l(uVar);
        o.a aVar = this.G;
        if (aVar != null) {
            aVar.b(uVar);
        }
        return true;
    }

    public void k(boolean z2) {
        for (d a2 : this.r) {
            m.y(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    public void l(h hVar) {
        hVar.c(this, this.k);
        if (f()) {
            F(hVar);
        } else {
            this.q.add(hVar);
        }
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return false;
    }

    public void onDismiss() {
        d dVar;
        int size = this.r.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = this.r.get(i);
            if (!dVar.f146a.f()) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            dVar.f147b.e(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void p(View view) {
        if (this.x != view) {
            this.x = view;
            this.w = b.d.k.c.a(this.v, p.k(view));
        }
    }

    public void r(boolean z2) {
        this.E = z2;
    }

    public void s(int i) {
        if (this.v != i) {
            this.v = i;
            this.w = b.d.k.c.a(i, p.k(this.x));
        }
    }

    public void t(int i) {
        this.A = true;
        this.C = i;
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.I = onDismissListener;
    }

    public void v(boolean z2) {
        this.F = z2;
    }

    public void w(int i) {
        this.B = true;
        this.D = i;
    }
}
