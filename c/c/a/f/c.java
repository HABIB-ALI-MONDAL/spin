package c.c.a.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.b.a.i;
import c.b.a.r.e;
import java.util.ArrayList;

public class c extends b<c.c.a.h.b> {

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f1293a;

        /* renamed from: b  reason: collision with root package name */
        public View f1294b;

        private b() {
        }
    }

    public c(Context context, ArrayList<c.c.a.h.b> arrayList) {
        super(context, arrayList);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.l.inflate(c.c.a.c.grid_view_item_image_select, (ViewGroup) null);
            bVar = new b();
            bVar.f1293a = (ImageView) view.findViewById(c.c.a.b.image_view_image_select);
            bVar.f1294b = view.findViewById(c.c.a.b.view_alpha);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f1293a.getLayoutParams().width = this.m;
        bVar.f1293a.getLayoutParams().height = this.m;
        bVar.f1294b.getLayoutParams().width = this.m;
        bVar.f1294b.getLayoutParams().height = this.m;
        if (((c.c.a.h.b) this.j.get(i)).m) {
            bVar.f1294b.setAlpha(0.5f);
            ((FrameLayout) view).setForeground(this.k.getResources().getDrawable(c.c.a.a.ic_done_white));
        } else {
            bVar.f1294b.setAlpha(0.0f);
            ((FrameLayout) view).setForeground((Drawable) null);
        }
        e V = new e().V(c.c.a.a.image_placeholder);
        i<Drawable> o = c.b.a.c.t(this.k).o(((c.c.a.h.b) this.j.get(i)).l);
        o.a(V);
        o.n(bVar.f1293a);
        return view;
    }
}
