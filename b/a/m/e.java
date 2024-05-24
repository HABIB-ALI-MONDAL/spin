package b.a.m;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import b.a.m.b;
import java.lang.ref.WeakReference;

public class e extends b implements h.a {
    private Context l;
    private ActionBarContextView m;
    private b.a n;
    private WeakReference<View> o;
    private boolean p;
    private h q;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.l = context;
        this.m = actionBarContextView;
        this.n = aVar;
        h hVar = new h(actionBarContextView.getContext());
        hVar.S(1);
        this.q = hVar;
        hVar.R(this);
    }

    public boolean a(h hVar, MenuItem menuItem) {
        return this.n.b(this, menuItem);
    }

    public void b(h hVar) {
        k();
        this.m.l();
    }

    public void c() {
        if (!this.p) {
            this.p = true;
            this.m.sendAccessibilityEvent(32);
            this.n.d(this);
        }
    }

    public View d() {
        WeakReference<View> weakReference = this.o;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public Menu e() {
        return this.q;
    }

    public MenuInflater f() {
        return new g(this.m.getContext());
    }

    public CharSequence g() {
        return this.m.getSubtitle();
    }

    public CharSequence i() {
        return this.m.getTitle();
    }

    public void k() {
        this.n.a(this, this.q);
    }

    public boolean l() {
        return this.m.j();
    }

    public void m(View view) {
        this.m.setCustomView(view);
        this.o = view != null ? new WeakReference<>(view) : null;
    }

    public void n(int i) {
        o(this.l.getString(i));
    }

    public void o(CharSequence charSequence) {
        this.m.setSubtitle(charSequence);
    }

    public void q(int i) {
        r(this.l.getString(i));
    }

    public void r(CharSequence charSequence) {
        this.m.setTitle(charSequence);
    }

    public void s(boolean z) {
        super.s(z);
        this.m.setTitleOptional(z);
    }
}
