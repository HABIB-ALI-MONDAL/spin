package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.h;

public class u extends h implements SubMenu {
    private h B;
    private j C;

    public u(Context context, h hVar, j jVar) {
        super(context);
        this.B = hVar;
        this.C = jVar;
    }

    public h D() {
        return this.B.D();
    }

    public boolean F() {
        return this.B.F();
    }

    public boolean G() {
        return this.B.G();
    }

    public boolean H() {
        return this.B.H();
    }

    public void R(h.a aVar) {
        this.B.R(aVar);
    }

    public Menu e0() {
        return this.B;
    }

    public boolean f(j jVar) {
        return this.B.f(jVar);
    }

    public MenuItem getItem() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean h(h hVar, MenuItem menuItem) {
        return super.h(hVar, menuItem) || this.B.h(hVar, menuItem);
    }

    public boolean k(j jVar) {
        return this.B.k(jVar);
    }

    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(int i) {
        super.U(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.V(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.X(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.Y(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.Z(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public String t() {
        j jVar = this.C;
        int itemId = jVar != null ? jVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.t() + ":" + itemId;
    }
}
