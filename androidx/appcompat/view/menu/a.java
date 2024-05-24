package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.d.f.a.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f136a;

    /* renamed from: b  reason: collision with root package name */
    private final int f137b;

    /* renamed from: c  reason: collision with root package name */
    private final int f138c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f139d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f140e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f141f;
    private char g;
    private int h = 4096;
    private char i;
    private int j = 4096;
    private Drawable k;
    private Context l;
    private CharSequence m;
    private CharSequence n;
    private ColorStateList o = null;
    private PorterDuff.Mode p = null;
    private boolean q = false;
    private boolean r = false;
    private int s = 16;

    public a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.l = context;
        this.f136a = i3;
        this.f137b = i2;
        this.f138c = i5;
        this.f139d = charSequence;
    }

    private void c() {
        Drawable drawable = this.k;
        if (drawable == null) {
            return;
        }
        if (this.q || this.r) {
            Drawable p2 = androidx.core.graphics.drawable.a.p(drawable);
            this.k = p2;
            Drawable mutate = p2.mutate();
            this.k = mutate;
            if (this.q) {
                androidx.core.graphics.drawable.a.n(mutate, this.o);
            }
            if (this.r) {
                androidx.core.graphics.drawable.a.o(this.k, this.p);
            }
        }
    }

    public b a(b.d.k.b bVar) {
        throw new UnsupportedOperationException();
    }

    public b.d.k.b b() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public b d(int i2) {
        throw new UnsupportedOperationException();
    }

    public b e(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    public b f(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.j;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    public CharSequence getContentDescription() {
        return this.m;
    }

    public int getGroupId() {
        return this.f137b;
    }

    public Drawable getIcon() {
        return this.k;
    }

    public ColorStateList getIconTintList() {
        return this.o;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    public Intent getIntent() {
        return this.f141f;
    }

    public int getItemId() {
        return this.f136a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.h;
    }

    public char getNumericShortcut() {
        return this.g;
    }

    public int getOrder() {
        return this.f138c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f139d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f140e;
        return charSequence != null ? charSequence : this.f139d;
    }

    public CharSequence getTooltipText() {
        return this.n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        d(i2);
        throw null;
    }

    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        e(view);
        throw null;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.s = z | (this.s & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & -3);
        return this;
    }

    public b setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & -17);
        return this;
    }

    public MenuItem setIcon(int i2) {
        this.k = androidx.core.content.a.f(this.l, i2);
        c();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        c();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        c();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f141f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase(c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i2);
        this.i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        f(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.f139d = this.l.getResources().getString(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f139d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f140e = charSequence;
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.s & 8;
        if (z) {
            i2 = 0;
        }
        this.s = i3 | i2;
        return this;
    }
}
