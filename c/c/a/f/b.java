package c.c.a.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class b<T> extends BaseAdapter {
    protected ArrayList<T> j;
    protected Context k;
    protected LayoutInflater l;
    protected int m;

    public b(Context context, ArrayList<T> arrayList) {
        this.j = arrayList;
        this.k = context;
        this.l = LayoutInflater.from(context);
    }

    public void a() {
        this.j = null;
        this.k = null;
    }

    public void b(int i) {
        this.m = i;
    }

    public int getCount() {
        return this.j.size();
    }

    public T getItem(int i) {
        return this.j.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
