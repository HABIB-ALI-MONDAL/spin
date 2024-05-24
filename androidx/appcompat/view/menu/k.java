package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c<b.d.f.a.b> implements MenuItem {

    /* renamed from: e  reason: collision with root package name */
    private Method f162e;

    class a extends b.d.k.b {

        /* renamed from: b  reason: collision with root package name */
        final ActionProvider f163b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f163b = actionProvider;
        }

        public boolean a() {
            return this.f163b.hasSubMenu();
        }

        public View c() {
            return this.f163b.onCreateActionView();
        }

        public boolean e() {
            return this.f163b.onPerformDefaultAction();
        }

        public void f(SubMenu subMenu) {
            this.f163b.onPrepareSubMenu(k.this.d(subMenu));
        }
    }

    static class b extends FrameLayout implements b.a.m.c {
        final CollapsibleActionView j;

        b(View view) {
            super(view.getContext());
            this.j = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.j;
        }

        public void c() {
            this.j.onActionViewExpanded();
        }

        public void d() {
            this.j.onActionViewCollapsed();
        }
    }

    private class c extends d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f145a).onMenuItemActionCollapse(k.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f145a).onMenuItemActionExpand(k.this.c(menuItem));
        }
    }

    private class d extends d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f145a).onMenuItemClick(k.this.c(menuItem));
        }
    }

    k(Context context, b.d.f.a.b bVar) {
        super(context, bVar);
    }

    public boolean collapseActionView() {
        return ((b.d.f.a.b) this.f145a).collapseActionView();
    }

    public boolean expandActionView() {
        return ((b.d.f.a.b) this.f145a).expandActionView();
    }

    public ActionProvider getActionProvider() {
        b.d.k.b b2 = ((b.d.f.a.b) this.f145a).b();
        if (b2 instanceof a) {
            return ((a) b2).f163b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = ((b.d.f.a.b) this.f145a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return ((b.d.f.a.b) this.f145a).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((b.d.f.a.b) this.f145a).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((b.d.f.a.b) this.f145a).getContentDescription();
    }

    public int getGroupId() {
        return ((b.d.f.a.b) this.f145a).getGroupId();
    }

    public Drawable getIcon() {
        return ((b.d.f.a.b) this.f145a).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((b.d.f.a.b) this.f145a).getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return ((b.d.f.a.b) this.f145a).getIconTintMode();
    }

    public Intent getIntent() {
        return ((b.d.f.a.b) this.f145a).getIntent();
    }

    public int getItemId() {
        return ((b.d.f.a.b) this.f145a).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((b.d.f.a.b) this.f145a).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((b.d.f.a.b) this.f145a).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((b.d.f.a.b) this.f145a).getNumericShortcut();
    }

    public int getOrder() {
        return ((b.d.f.a.b) this.f145a).getOrder();
    }

    public SubMenu getSubMenu() {
        return d(((b.d.f.a.b) this.f145a).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((b.d.f.a.b) this.f145a).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((b.d.f.a.b) this.f145a).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((b.d.f.a.b) this.f145a).getTooltipText();
    }

    /* access modifiers changed from: package-private */
    public a h(ActionProvider actionProvider) {
        return new a(this.f142b, actionProvider);
    }

    public boolean hasSubMenu() {
        return ((b.d.f.a.b) this.f145a).hasSubMenu();
    }

    public void i(boolean z) {
        try {
            if (this.f162e == null) {
                this.f162e = ((b.d.f.a.b) this.f145a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f162e.invoke(this.f145a, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean isActionViewExpanded() {
        return ((b.d.f.a.b) this.f145a).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((b.d.f.a.b) this.f145a).isCheckable();
    }

    public boolean isChecked() {
        return ((b.d.f.a.b) this.f145a).isChecked();
    }

    public boolean isEnabled() {
        return ((b.d.f.a.b) this.f145a).isEnabled();
    }

    public boolean isVisible() {
        return ((b.d.f.a.b) this.f145a).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((b.d.f.a.b) this.f145a).a(actionProvider != null ? h(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((b.d.f.a.b) this.f145a).setActionView(i);
        View actionView = ((b.d.f.a.b) this.f145a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((b.d.f.a.b) this.f145a).setActionView((View) new b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((b.d.f.a.b) this.f145a).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((b.d.f.a.b) this.f145a).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((b.d.f.a.b) this.f145a).setAlphabeticShortcut(c2, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((b.d.f.a.b) this.f145a).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((b.d.f.a.b) this.f145a).setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((b.d.f.a.b) this.f145a).setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((b.d.f.a.b) this.f145a).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((b.d.f.a.b) this.f145a).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((b.d.f.a.b) this.f145a).setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((b.d.f.a.b) this.f145a).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((b.d.f.a.b) this.f145a).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((b.d.f.a.b) this.f145a).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((b.d.f.a.b) this.f145a).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        ((b.d.f.a.b) this.f145a).setNumericShortcut(c2, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((b.d.f.a.b) this.f145a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((b.d.f.a.b) this.f145a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((b.d.f.a.b) this.f145a).setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((b.d.f.a.b) this.f145a).setShortcut(c2, c3, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((b.d.f.a.b) this.f145a).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((b.d.f.a.b) this.f145a).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((b.d.f.a.b) this.f145a).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((b.d.f.a.b) this.f145a).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((b.d.f.a.b) this.f145a).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((b.d.f.a.b) this.f145a).setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((b.d.f.a.b) this.f145a).setVisible(z);
    }
}
