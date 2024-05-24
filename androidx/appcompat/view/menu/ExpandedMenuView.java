package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.t0;

public final class ExpandedMenuView extends ListView implements h.b, p, AdapterView.OnItemClickListener {
    private static final int[] l = {16842964, 16843049};
    private h j;
    private int k;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        t0 t = t0.t(context, attributeSet, l, i, 0);
        if (t.q(0)) {
            setBackgroundDrawable(t.f(0));
        }
        if (t.q(1)) {
            setDivider(t.f(1));
        }
        t.u();
    }

    public boolean a(j jVar) {
        return this.j.L(jVar, 0);
    }

    public void b(h hVar) {
        this.j = hVar;
    }

    public int getWindowAnimations() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        a((j) getAdapter().getItem(i));
    }
}
