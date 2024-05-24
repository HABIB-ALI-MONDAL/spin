package b.e.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import b.e.a.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {
    protected boolean j;
    protected boolean k;
    protected Cursor l;
    protected Context m;
    protected int n;
    protected C0030a o;
    protected DataSetObserver p;
    protected b q;

    /* renamed from: b.e.a.a$a  reason: collision with other inner class name */
    private class C0030a extends ContentObserver {
        C0030a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            a.this.i();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.j = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.j = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    public abstract CharSequence a(Cursor cursor);

    public void b(Cursor cursor) {
        Cursor j2 = j(cursor);
        if (j2 != null) {
            j2.close();
        }
    }

    public Cursor c() {
        return this.l;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    /* access modifiers changed from: package-private */
    public void f(Context context, Cursor cursor, int i) {
        b bVar;
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.k = true;
        } else {
            this.k = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.l = cursor;
        this.j = z;
        this.m = context;
        this.n = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.o = new C0030a();
            bVar = new b();
        } else {
            bVar = null;
            this.o = null;
        }
        this.p = bVar;
        if (z) {
            C0030a aVar = this.o;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.p;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.j || (cursor = this.l) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.j) {
            return null;
        }
        this.l.moveToPosition(i);
        if (view == null) {
            view = g(this.m, this.l, viewGroup);
        }
        e(view, this.m, this.l);
        return view;
    }

    public Filter getFilter() {
        if (this.q == null) {
            this.q = new b(this);
        }
        return this.q;
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.j || (cursor = this.l) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.l;
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.j || (cursor = this.l) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.l.getLong(this.n);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.j) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.l.moveToPosition(i)) {
            if (view == null) {
                view = h(this.m, this.l, viewGroup);
            }
            e(view, this.m, this.l);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void i() {
        Cursor cursor;
        if (this.k && (cursor = this.l) != null && !cursor.isClosed()) {
            this.j = this.l.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.l;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0030a aVar = this.o;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.p;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.l = cursor;
        if (cursor != null) {
            C0030a aVar2 = this.o;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.p;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.n = cursor.getColumnIndexOrThrow("_id");
            this.j = true;
            notifyDataSetChanged();
        } else {
            this.n = -1;
            this.j = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
