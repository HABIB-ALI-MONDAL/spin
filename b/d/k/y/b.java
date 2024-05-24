package b.d.k.y;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import b.d.c;
import b.d.k.y.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b {

    /* renamed from: d  reason: collision with root package name */
    private static int f660d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f661a;

    /* renamed from: b  reason: collision with root package name */
    public int f662b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f663c = -1;

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final a f664d = new a(4096, (CharSequence) null);

        /* renamed from: e  reason: collision with root package name */
        public static final a f665e = new a(8192, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f666f;
        public static final a g;

        /* renamed from: a  reason: collision with root package name */
        final Object f667a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<? extends e.a> f668b;

        /* renamed from: c  reason: collision with root package name */
        protected final e f669c;

        static {
            Class<e.c> cls = e.c.class;
            Class<e.b> cls2 = e.b.class;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            new a(1, (CharSequence) null);
            new a(2, (CharSequence) null);
            new a(4, (CharSequence) null);
            new a(8, (CharSequence) null);
            new a(16, (CharSequence) null);
            new a(32, (CharSequence) null);
            new a(64, (CharSequence) null);
            new a(128, (CharSequence) null);
            new a(256, (CharSequence) null, cls2);
            new a(512, (CharSequence) null, cls2);
            new a(1024, (CharSequence) null, cls);
            new a(2048, (CharSequence) null, cls);
            new a(16384, (CharSequence) null);
            new a(32768, (CharSequence) null);
            new a(65536, (CharSequence) null);
            new a(131072, (CharSequence) null, e.g.class);
            new a(262144, (CharSequence) null);
            new a(524288, (CharSequence) null);
            new a(1048576, (CharSequence) null);
            new a(2097152, (CharSequence) null, e.h.class);
            int i = Build.VERSION.SDK_INT;
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (e) null, e.C0029e.class);
            f666f = new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            g = new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            new a(i >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (e) null, e.f.class);
            new a(i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (e) null, e.d.class);
            new a(i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
            if (i >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            new a(accessibilityAction, 16908357, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
        }

        public a(int i, CharSequence charSequence) {
            this((Object) null, i, charSequence, (e) null, (Class<? extends e.a>) null);
        }

        private a(int i, CharSequence charSequence, Class<? extends e.a> cls) {
            this((Object) null, i, charSequence, (e) null, cls);
        }

        a(Object obj) {
            this(obj, 0, (CharSequence) null, (e) null, (Class<? extends e.a>) null);
        }

        a(Object obj, int i, CharSequence charSequence, e eVar, Class<? extends e.a> cls) {
            this.f669c = eVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                obj = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            }
            this.f667a = obj;
            this.f668b = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f667a).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f667a).getLabel();
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                b.d.k.y.e r0 = r4.f669c
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends b.d.k.y.e$a> r2 = r4.f668b
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                b.d.k.y.e$a r1 = (b.d.k.y.e.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends b.d.k.y.e$a> r1 = r4.f668b
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                b.d.k.y.e r6 = r4.f669c
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.k.y.b.a.c(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f667a;
            Object obj3 = ((a) obj).f667a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f667a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f661a = accessibilityNodeInfo;
    }

    private void G(View view) {
        SparseArray<WeakReference<ClickableSpan>> q = q(view);
        if (q != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < q.size(); i++) {
                if (q.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                q.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    private void H(int i, boolean z) {
        Bundle n = n();
        if (n != null) {
            int i2 = n.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ -1);
            if (!z) {
                i = 0;
            }
            n.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public static b O(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private void b(ClickableSpan clickableSpan, Spanned spanned, int i) {
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f661a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f661a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f661a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f661a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private List<Integer> e(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f661a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f661a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String g(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] l(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> o(View view) {
        SparseArray<WeakReference<ClickableSpan>> q = q(view);
        if (q != null) {
            return q;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(c.f542c, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> q(View view) {
        return (SparseArray) view.getTag(c.f542c);
    }

    private boolean t() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int u(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f660d;
        f660d = i2 + 1;
        return i2;
    }

    public boolean A() {
        return this.f661a.isFocused();
    }

    public boolean B() {
        return this.f661a.isLongClickable();
    }

    public boolean C() {
        return this.f661a.isPassword();
    }

    public boolean D() {
        return this.f661a.isScrollable();
    }

    public boolean E() {
        return this.f661a.isSelected();
    }

    public boolean F(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f661a.performAction(i, bundle);
        }
        return false;
    }

    public void I(CharSequence charSequence) {
        this.f661a.setClassName(charSequence);
    }

    public void J(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f661a.setHeading(z);
        } else {
            H(2, z);
        }
    }

    public void K(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f661a.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f661a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void L(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f661a.setScreenReaderFocusable(z);
        } else {
            H(1, z);
        }
    }

    public void M(boolean z) {
        this.f661a.setScrollable(z);
    }

    public AccessibilityNodeInfo N() {
        return this.f661a;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f661a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f667a);
        }
    }

    public void c(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 26) {
            d();
            G(view);
            ClickableSpan[] l = l(charSequence);
            if (l != null && l.length > 0) {
                n().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", c.f540a);
                SparseArray<WeakReference<ClickableSpan>> o = o(view);
                int i2 = 0;
                while (l != null && i2 < l.length) {
                    int u = u(l[i2], o);
                    o.put(u, new WeakReference(l[i2]));
                    b(l[i2], (Spanned) charSequence, u);
                    i2++;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f661a;
        if (accessibilityNodeInfo == null) {
            if (bVar.f661a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.f661a)) {
            return false;
        }
        return this.f663c == bVar.f663c && this.f662b == bVar.f662b;
    }

    public List<a> f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f661a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public int h() {
        return this.f661a.getActions();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f661a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    public void i(Rect rect) {
        this.f661a.getBoundsInParent(rect);
    }

    public void j(Rect rect) {
        this.f661a.getBoundsInScreen(rect);
    }

    public CharSequence k() {
        return this.f661a.getClassName();
    }

    public CharSequence m() {
        return this.f661a.getContentDescription();
    }

    public Bundle n() {
        return Build.VERSION.SDK_INT >= 19 ? this.f661a.getExtras() : new Bundle();
    }

    public CharSequence p() {
        return this.f661a.getPackageName();
    }

    public CharSequence r() {
        if (!t()) {
            return this.f661a.getText();
        }
        List<Integer> e2 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> e3 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> e4 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> e5 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f661a.getText(), 0, this.f661a.getText().length()));
        for (int i = 0; i < e2.size(); i++) {
            spannableString.setSpan(new a(e5.get(i).intValue(), this, n().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), e2.get(i).intValue(), e3.get(i).intValue(), e4.get(i).intValue());
        }
        return spannableString;
    }

    public String s() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f661a.getViewIdResourceName();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        i(rect);
        sb.append("; boundsInParent: " + rect);
        j(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(p());
        sb.append("; className: ");
        sb.append(k());
        sb.append("; text: ");
        sb.append(r());
        sb.append("; contentDescription: ");
        sb.append(m());
        sb.append("; viewId: ");
        sb.append(s());
        sb.append("; checkable: ");
        sb.append(v());
        sb.append("; checked: ");
        sb.append(w());
        sb.append("; focusable: ");
        sb.append(z());
        sb.append("; focused: ");
        sb.append(A());
        sb.append("; selected: ");
        sb.append(E());
        sb.append("; clickable: ");
        sb.append(x());
        sb.append("; longClickable: ");
        sb.append(B());
        sb.append("; enabled: ");
        sb.append(y());
        sb.append("; password: ");
        sb.append(C());
        sb.append("; scrollable: " + D());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> f2 = f();
            for (int i = 0; i < f2.size(); i++) {
                a aVar = f2.get(i);
                String g = g(aVar.a());
                if (g.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    g = aVar.b().toString();
                }
                sb.append(g);
                if (i != f2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int h = h();
            while (h != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(h);
                h &= numberOfTrailingZeros ^ -1;
                sb.append(g(numberOfTrailingZeros));
                if (h != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean v() {
        return this.f661a.isCheckable();
    }

    public boolean w() {
        return this.f661a.isChecked();
    }

    public boolean x() {
        return this.f661a.isClickable();
    }

    public boolean y() {
        return this.f661a.isEnabled();
    }

    public boolean z() {
        return this.f661a.isFocusable();
    }
}
