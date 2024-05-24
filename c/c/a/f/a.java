package c.c.a.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.b.a.i;
import c.b.a.r.e;
import c.c.a.c;
import java.util.ArrayList;

public class a extends b<c.c.a.h.a> {

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f1291a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1292b;

        private b() {
        }
    }

    public a(Context context, ArrayList<c.c.a.h.a> arrayList) {
        super(context, arrayList);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.l.inflate(c.grid_view_item_album_select, (ViewGroup) null);
            bVar = new b();
            bVar.f1291a = (ImageView) view.findViewById(c.c.a.b.image_view_album_image);
            bVar.f1292b = (TextView) view.findViewById(c.c.a.b.text_view_album_name);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f1291a.getLayoutParams().width = this.m;
        bVar.f1291a.getLayoutParams().height = this.m;
        bVar.f1292b.setText(((c.c.a.h.a) this.j.get(i)).f1296a);
        e V = new e().d().V(c.c.a.a.image_placeholder);
        i<Drawable> o = c.b.a.c.t(this.k).o(((c.c.a.h.a) this.j.get(i)).f1297b);
        o.a(V);
        o.n(bVar.f1291a);
        return view;
    }
}
