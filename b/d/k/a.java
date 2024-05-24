package b.d.k;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import b.d.k.y.b;
import b.d.k.y.c;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f617c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f618a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f619b;

    /* renamed from: b.d.k.a$a  reason: collision with other inner class name */
    static final class C0027a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f620a;

        C0027a(a aVar) {
            this.f620a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f620a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c b2 = this.f620a.b(view);
            if (b2 != null) {
                return (AccessibilityNodeProvider) b2.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f620a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            b O = b.O(accessibilityNodeInfo);
            O.L(p.t(view));
            O.J(p.q(view));
            O.K(p.h(view));
            this.f620a.g(view, O);
            O.c(accessibilityNodeInfo.getText(), view);
            List<b.a> c2 = a.c(view);
            for (int i = 0; i < c2.size(); i++) {
                O.a(c2.get(i));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f620a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f620a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f620a.j(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f620a.l(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f620a.m(view, accessibilityEvent);
        }
    }

    public a() {
        this(f617c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f618a = accessibilityDelegate;
        this.f619b = new C0027a(this);
    }

    static List<b.a> c(View view) {
        List<b.a> list = (List) view.getTag(b.d.c.f541b);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] l = b.l(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (l != null && i < l.length) {
                if (clickableSpan.equals(l[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private boolean k(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(b.d.c.f542c);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f618a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public c b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f618a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new c(accessibilityNodeProvider);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f619b;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f618a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, b bVar) {
        this.f618a.onInitializeAccessibilityNodeInfo(view, bVar.N());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f618a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f618a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i, Bundle bundle) {
        List<b.a> c2 = c(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= c2.size()) {
                break;
            }
            b.a aVar = c2.get(i2);
            if (aVar.a() == i) {
                z = aVar.c(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f618a.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != b.d.c.f540a) ? z : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(View view, int i) {
        this.f618a.sendAccessibilityEvent(view, i);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f618a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
