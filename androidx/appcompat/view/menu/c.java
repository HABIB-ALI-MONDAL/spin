package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.c.a;
import b.d.f.a.b;
import java.util.Iterator;
import java.util.Map;

abstract class c<T> extends d<T> {

    /* renamed from: b  reason: collision with root package name */
    final Context f142b;

    /* renamed from: c  reason: collision with root package name */
    private Map<b, MenuItem> f143c;

    /* renamed from: d  reason: collision with root package name */
    private Map<b.d.f.a.c, SubMenu> f144d;

    c(Context context, T t) {
        super(t);
        this.f142b = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f143c == null) {
            this.f143c = new a();
        }
        MenuItem menuItem2 = this.f143c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem b2 = q.b(this.f142b, bVar);
        this.f143c.put(bVar, b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof b.d.f.a.c)) {
            return subMenu;
        }
        b.d.f.a.c cVar = (b.d.f.a.c) subMenu;
        if (this.f144d == null) {
            this.f144d = new a();
        }
        SubMenu subMenu2 = this.f144d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu c2 = q.c(this.f142b, cVar);
        this.f144d.put(cVar, c2);
        return c2;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        Map<b, MenuItem> map = this.f143c;
        if (map != null) {
            map.clear();
        }
        Map<b.d.f.a.c, SubMenu> map2 = this.f144d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i) {
        Map<b, MenuItem> map = this.f143c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(int i) {
        Map<b, MenuItem> map = this.f143c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
