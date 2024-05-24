package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.d.f.a.a;

class r extends c<a> implements Menu {
    r(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(int i) {
        return c(((a) this.f145a).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return c(((a) this.f145a).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return c(((a) this.f145a).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return c(((a) this.f145a).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((a) this.f145a).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = c(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return d(((a) this.f145a).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return d(((a) this.f145a).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return d(((a) this.f145a).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(((a) this.f145a).addSubMenu(charSequence));
    }

    public void clear() {
        e();
        ((a) this.f145a).clear();
    }

    public void close() {
        ((a) this.f145a).close();
    }

    public MenuItem findItem(int i) {
        return c(((a) this.f145a).findItem(i));
    }

    public MenuItem getItem(int i) {
        return c(((a) this.f145a).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((a) this.f145a).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((a) this.f145a).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((a) this.f145a).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((a) this.f145a).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        f(i);
        ((a) this.f145a).removeGroup(i);
    }

    public void removeItem(int i) {
        g(i);
        ((a) this.f145a).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((a) this.f145a).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((a) this.f145a).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((a) this.f145a).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.f145a).setQwertyMode(z);
    }

    public int size() {
        return ((a) this.f145a).size();
    }
}
