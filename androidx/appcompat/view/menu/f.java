package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import b.a.g;
import java.util.ArrayList;

public class f implements o, AdapterView.OnItemClickListener {
    Context j;
    LayoutInflater k;
    h l;
    ExpandedMenuView m;
    int n;
    int o;
    int p;
    private o.a q;
    a r;

    private class a extends BaseAdapter {
        private int j = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            j v = f.this.l.v();
            if (v != null) {
                ArrayList<j> z = f.this.l.z();
                int size = z.size();
                for (int i = 0; i < size; i++) {
                    if (z.get(i) == v) {
                        this.j = i;
                        return;
                    }
                }
            }
            this.j = -1;
        }

        /* renamed from: b */
        public j getItem(int i) {
            ArrayList<j> z = f.this.l.z();
            int i2 = i + f.this.n;
            int i3 = this.j;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return z.get(i2);
        }

        public int getCount() {
            int size = f.this.l.z().size() - f.this.n;
            return this.j < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                f fVar = f.this;
                view = fVar.k.inflate(fVar.p, viewGroup, false);
            }
            ((p.a) view).d(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public f(int i, int i2) {
        this.p = i;
        this.o = i2;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.j = context;
        this.k = LayoutInflater.from(context);
    }

    public void a(h hVar, boolean z) {
        o.a aVar = this.q;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public ListAdapter b() {
        if (this.r == null) {
            this.r = new a();
        }
        return this.r;
    }

    public boolean c() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(android.content.Context r3, androidx.appcompat.view.menu.h r4) {
        /*
            r2 = this;
            int r0 = r2.o
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.o
            r0.<init>(r3, r1)
            r2.j = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L_0x0011:
            r2.k = r3
            goto L_0x0023
        L_0x0014:
            android.content.Context r0 = r2.j
            if (r0 == 0) goto L_0x0023
            r2.j = r3
            android.view.LayoutInflater r0 = r2.k
            if (r0 != 0) goto L_0x0023
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L_0x0011
        L_0x0023:
            r2.l = r4
            androidx.appcompat.view.menu.f$a r3 = r2.r
            if (r3 == 0) goto L_0x002c
            r3.notifyDataSetChanged()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.f.d(android.content.Context, androidx.appcompat.view.menu.h):void");
    }

    public boolean e(h hVar, j jVar) {
        return false;
    }

    public p f(ViewGroup viewGroup) {
        if (this.m == null) {
            this.m = (ExpandedMenuView) this.k.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.r == null) {
                this.r = new a();
            }
            this.m.setAdapter(this.r);
            this.m.setOnItemClickListener(this);
        }
        return this.m;
    }

    public boolean h(h hVar, j jVar) {
        return false;
    }

    public void i(o.a aVar) {
        this.q = aVar;
    }

    public boolean j(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new i(uVar).d((IBinder) null);
        o.a aVar = this.q;
        if (aVar == null) {
            return true;
        }
        aVar.b(uVar);
        return true;
    }

    public void k(boolean z) {
        a aVar = this.r;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
        this.l.M(this.r.getItem(i), this, 0);
    }
}
