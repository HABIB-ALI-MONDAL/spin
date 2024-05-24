package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import java.util.ArrayList;

public abstract class b implements o {
    protected Context j;
    protected Context k;
    protected h l;
    protected LayoutInflater m;
    private o.a n;
    private int o;
    private int p;
    protected p q;

    public b(Context context, int i, int i2) {
        this.j = context;
        this.m = LayoutInflater.from(context);
        this.o = i;
        this.p = i2;
    }

    public void a(h hVar, boolean z) {
        o.a aVar = this.n;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    /* access modifiers changed from: protected */
    public void b(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.q).addView(view, i);
    }

    public void d(Context context, h hVar) {
        this.k = context;
        LayoutInflater.from(context);
        this.l = hVar;
    }

    public boolean e(h hVar, j jVar) {
        return false;
    }

    public abstract void f(j jVar, p.a aVar);

    public p.a g(ViewGroup viewGroup) {
        return (p.a) this.m.inflate(this.p, viewGroup, false);
    }

    public boolean h(h hVar, j jVar) {
        return false;
    }

    public void i(o.a aVar) {
        this.n = aVar;
    }

    public boolean j(u uVar) {
        o.a aVar = this.n;
        if (aVar != null) {
            return aVar.b(uVar);
        }
        return false;
    }

    public void k(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.q;
        if (viewGroup != null) {
            h hVar = this.l;
            int i = 0;
            if (hVar != null) {
                hVar.r();
                ArrayList<j> E = this.l.E();
                int size = E.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    j jVar = E.get(i3);
                    if (q(i2, jVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        j itemData = childAt instanceof p.a ? ((p.a) childAt).getItemData() : null;
                        View n2 = n(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            n2.setPressed(false);
                            n2.jumpDrawablesToCurrentState();
                        }
                        if (n2 != childAt) {
                            b(n2, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!l(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public o.a m() {
        return this.n;
    }

    public View n(j jVar, View view, ViewGroup viewGroup) {
        p.a g = view instanceof p.a ? (p.a) view : g(viewGroup);
        f(jVar, g);
        return (View) g;
    }

    public p o(ViewGroup viewGroup) {
        if (this.q == null) {
            p pVar = (p) this.m.inflate(this.o, viewGroup, false);
            this.q = pVar;
            pVar.b(this.l);
            k(true);
        }
        return this.q;
    }

    public void p(int i) {
    }

    public abstract boolean q(int i, j jVar);
}
