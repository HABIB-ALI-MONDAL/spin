package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.d.f.a.c;

class v extends r implements SubMenu {
    v(Context context, c cVar) {
        super(context, cVar);
    }

    public void clearHeader() {
        h().clearHeader();
    }

    public MenuItem getItem() {
        return c(h().getItem());
    }

    public c h() {
        return (c) this.f145a;
    }

    public SubMenu setHeaderIcon(int i) {
        h().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        h().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        h().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        h().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        h().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        h().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        h().setIcon(drawable);
        return this;
    }
}
