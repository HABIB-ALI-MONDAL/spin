package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.p;
import java.util.ArrayList;

public class g extends BaseAdapter {
    h j;
    private int k = -1;
    private boolean l;
    private final boolean m;
    private final LayoutInflater n;
    private final int o;

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.m = z;
        this.n = layoutInflater;
        this.j = hVar;
        this.o = i;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        j v = this.j.v();
        if (v != null) {
            ArrayList<j> z = this.j.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (z.get(i) == v) {
                    this.k = i;
                    return;
                }
            }
        }
        this.k = -1;
    }

    public h b() {
        return this.j;
    }

    /* renamed from: c */
    public j getItem(int i) {
        ArrayList<j> z = this.m ? this.j.z() : this.j.E();
        int i2 = this.k;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return z.get(i);
    }

    public void d(boolean z) {
        this.l = z;
    }

    public int getCount() {
        ArrayList<j> z = this.m ? this.j.z() : this.j.E();
        int i = this.k;
        int size = z.size();
        return i < 0 ? size : size - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.n.inflate(this.o, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.j.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        p.a aVar = (p.a) view;
        if (this.l) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.d(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
