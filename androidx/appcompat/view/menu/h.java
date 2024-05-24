package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import b.d.k.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements b.d.f.a.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f149a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f150b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f151c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f152d;

    /* renamed from: e  reason: collision with root package name */
    private a f153e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<j> f154f;
    private ArrayList<j> g;
    private boolean h;
    private ArrayList<j> i;
    private ArrayList<j> j;
    private boolean k;
    private int l = 0;
    private ContextMenu.ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<j> v = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<o>> w = new CopyOnWriteArrayList<>();
    private j x;
    private boolean y = false;
    private boolean z;

    public interface a {
        boolean a(h hVar, MenuItem menuItem);

        void b(h hVar);
    }

    public interface b {
        boolean a(j jVar);
    }

    public h(Context context) {
        this.f149a = context;
        this.f150b = context.getResources();
        this.f154f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = true;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = true;
        b0(true);
    }

    private static int B(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = A;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f154f.size()) {
            this.f154f.remove(i2);
            if (z2) {
                K(true);
            }
        }
    }

    private void W(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i2 > 0) {
                this.n = C.getText(i2);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i3 > 0) {
                this.o = androidx.core.content.a.f(u(), i3);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        K(false);
    }

    private void b0(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.f150b.getConfiguration().keyboard == 1 || !q.b(ViewConfiguration.get(this.f149a), this.f149a)) {
            z3 = false;
        }
        this.f152d = z3;
    }

    private j g(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new j(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void i(boolean z2) {
        if (!this.w.isEmpty()) {
            d0();
            Iterator<WeakReference<o>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.w.remove(next);
                } else {
                    oVar.k(z2);
                }
            }
            c0();
        }
    }

    private boolean j(u uVar, o oVar) {
        boolean z2 = false;
        if (this.w.isEmpty()) {
            return false;
        }
        if (oVar != null) {
            z2 = oVar.j(uVar);
        }
        Iterator<WeakReference<o>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar2 = (o) next.get();
            if (oVar2 == null) {
                this.w.remove(next);
            } else if (!z2) {
                z2 = oVar2.j(uVar);
            }
        }
        return z2;
    }

    private static int n(ArrayList<j> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public Resources C() {
        return this.f150b;
    }

    public h D() {
        return this;
    }

    public ArrayList<j> E() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f154f.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.f154f.get(i2);
            if (jVar.isVisible()) {
                this.g.add(jVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean F() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.f151c;
    }

    public boolean H() {
        return this.f152d;
    }

    /* access modifiers changed from: package-private */
    public void I(j jVar) {
        this.k = true;
        K(true);
    }

    /* access modifiers changed from: package-private */
    public void J(j jVar) {
        this.h = true;
        K(true);
    }

    public void K(boolean z2) {
        if (!this.q) {
            if (z2) {
                this.h = true;
                this.k = true;
            }
            i(z2);
            return;
        }
        this.r = true;
        if (z2) {
            this.s = true;
        }
    }

    public boolean L(MenuItem menuItem, int i2) {
        return M(menuItem, (o) null, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean M(android.view.MenuItem r7, androidx.appcompat.view.menu.o r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.j r7 = (androidx.appcompat.view.menu.j) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.k()
            b.d.k.b r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.a()
            if (r4 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            boolean r5 = r7.j()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.e(r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.e(r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.u r9 = new androidx.appcompat.view.menu.u
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.u r7 = (androidx.appcompat.view.menu.u) r7
            if (r4 == 0) goto L_0x0063
            r2.f(r7)
        L_0x0063:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.h.M(android.view.MenuItem, androidx.appcompat.view.menu.o, int):boolean");
    }

    public void O(o oVar) {
        Iterator<WeakReference<o>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar2 = (o) next.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(t());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((u) item.getSubMenu()).P(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f153e = aVar;
    }

    public h S(int i2) {
        this.l = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f154f.size();
        d0();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.f154f.get(i2);
            if (jVar.getGroupId() == groupId && jVar.m() && jVar.isCheckable()) {
                jVar.s(jVar == menuItem);
            }
        }
        c0();
    }

    /* access modifiers changed from: protected */
    public h U(int i2) {
        W(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public h V(Drawable drawable) {
        W(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public h X(int i2) {
        W(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public h Y(CharSequence charSequence) {
        W(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public h Z(View view) {
        W(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int B = B(i4);
        j g2 = g(i2, i3, i4, B, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            g2.v(contextMenuInfo);
        }
        ArrayList<j> arrayList = this.f154f;
        arrayList.add(n(arrayList, B), g2);
        K(true);
        return g2;
    }

    public void a0(boolean z2) {
        this.z = z2;
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f150b.getString(i2));
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f150b.getString(i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f149a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f150b.getString(i2));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f150b.getString(i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        j jVar = (j) a(i2, i3, i4, charSequence);
        u uVar = new u(this.f149a, this, jVar);
        jVar.x(uVar);
        return uVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(o oVar) {
        c(oVar, this.f149a);
    }

    public void c(o oVar, Context context) {
        this.w.add(new WeakReference(oVar));
        oVar.d(context, this);
        this.k = true;
    }

    public void c0() {
        this.q = false;
        if (this.r) {
            this.r = false;
            K(this.s);
        }
    }

    public void clear() {
        j jVar = this.x;
        if (jVar != null) {
            f(jVar);
        }
        this.f154f.clear();
        K(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        K(false);
    }

    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f153e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    public final void e(boolean z2) {
        if (!this.u) {
            this.u = true;
            Iterator<WeakReference<o>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.w.remove(next);
                } else {
                    oVar.a(this, z2);
                }
            }
            this.u = false;
        }
    }

    public boolean f(j jVar) {
        boolean z2 = false;
        if (!this.w.isEmpty() && this.x == jVar) {
            d0();
            Iterator<WeakReference<o>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.w.remove(next);
                } else {
                    z2 = oVar.e(this, jVar);
                    if (z2) {
                        break;
                    }
                }
            }
            c0();
            if (z2) {
                this.x = null;
            }
        }
        return z2;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.f154f.get(i3);
            if (jVar.getItemId() == i2) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (findItem = jVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public MenuItem getItem(int i2) {
        return this.f154f.get(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean h(h hVar, MenuItem menuItem) {
        a aVar = this.f153e;
        return aVar != null && aVar.a(hVar, menuItem);
    }

    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f154f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return p(i2, keyEvent) != null;
    }

    public boolean k(j jVar) {
        boolean z2 = false;
        if (this.w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<o>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            o oVar = (o) next.get();
            if (oVar == null) {
                this.w.remove(next);
            } else {
                z2 = oVar.h(this, jVar);
                if (z2) {
                    break;
                }
            }
        }
        c0();
        if (z2) {
            this.x = jVar;
        }
        return z2;
    }

    public int l(int i2) {
        return m(i2, 0);
    }

    public int m(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.f154f.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int o(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f154f.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public j p(int i2, KeyEvent keyEvent) {
        ArrayList<j> arrayList = this.v;
        arrayList.clear();
        q(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = arrayList.get(i3);
            char alphabeticShortcut = G ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == 8 && i2 == 67))) {
                return jVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return L(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        j p2 = p(i2, keyEvent);
        boolean L = p2 != null ? L(p2, i3) : false;
        if ((i3 & 2) != 0) {
            e(true);
        }
        return L;
    }

    /* access modifiers changed from: package-private */
    public void q(List<j> list, int i2, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f154f.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar = this.f154f.get(i3);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).q(list, i2, keyEvent);
                }
                char alphabeticShortcut = G ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & 69647) == ((G ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == 8 && i2 == 67)) && jVar.isEnabled()) {
                        list.add(jVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<j> E = E();
        if (this.k) {
            Iterator<WeakReference<o>> it = this.w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                o oVar = (o) next.get();
                if (oVar == null) {
                    this.w.remove(next);
                } else {
                    z2 |= oVar.c();
                }
            }
            if (z2) {
                this.i.clear();
                this.j.clear();
                int size = E.size();
                for (int i2 = 0; i2 < size; i2++) {
                    j jVar = E.get(i2);
                    (jVar.l() ? this.i : this.j).add(jVar);
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(E());
            }
            this.k = false;
        }
    }

    public void removeGroup(int i2) {
        int l2 = l(i2);
        if (l2 >= 0) {
            int size = this.f154f.size() - l2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.f154f.get(l2).getGroupId() != i2) {
                    K(true);
                } else {
                    N(l2, false);
                    i3 = i4;
                }
            }
            K(true);
        }
    }

    public void removeItem(int i2) {
        N(o(i2), true);
    }

    public ArrayList<j> s() {
        r();
        return this.i;
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f154f.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.f154f.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.t(z3);
                jVar.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.y = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f154f.size();
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.f154f.get(i3);
            if (jVar.getGroupId() == i2) {
                jVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f154f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            j jVar = this.f154f.get(i3);
            if (jVar.getGroupId() == i2 && jVar.y(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            K(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f151c = z2;
        K(false);
    }

    public int size() {
        return this.f154f.size();
    }

    /* access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f149a;
    }

    public j v() {
        return this.x;
    }

    public Drawable w() {
        return this.o;
    }

    public CharSequence x() {
        return this.n;
    }

    public View y() {
        return this.p;
    }

    public ArrayList<j> z() {
        r();
        return this.j;
    }
}
