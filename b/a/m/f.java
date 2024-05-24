package b.a.m;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.q;
import b.a.m.b;
import b.c.g;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f487a;

    /* renamed from: b  reason: collision with root package name */
    final b f488b;

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f489a;

        /* renamed from: b  reason: collision with root package name */
        final Context f490b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f491c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final g<Menu, Menu> f492d = new g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f490b = context;
            this.f489a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f492d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a2 = q.a(this.f490b, (b.d.f.a.a) menu);
            this.f492d.put(menu, a2);
            return a2;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f489a.onPrepareActionMode(e(bVar), f(menu));
        }

        public boolean b(b bVar, MenuItem menuItem) {
            return this.f489a.onActionItemClicked(e(bVar), q.b(this.f490b, (b.d.f.a.b) menuItem));
        }

        public boolean c(b bVar, Menu menu) {
            return this.f489a.onCreateActionMode(e(bVar), f(menu));
        }

        public void d(b bVar) {
            this.f489a.onDestroyActionMode(e(bVar));
        }

        public ActionMode e(b bVar) {
            int size = this.f491c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f491c.get(i);
                if (fVar != null && fVar.f488b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f490b, bVar);
            this.f491c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f487a = context;
        this.f488b = bVar;
    }

    public void finish() {
        this.f488b.c();
    }

    public View getCustomView() {
        return this.f488b.d();
    }

    public Menu getMenu() {
        return q.a(this.f487a, (b.d.f.a.a) this.f488b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f488b.f();
    }

    public CharSequence getSubtitle() {
        return this.f488b.g();
    }

    public Object getTag() {
        return this.f488b.h();
    }

    public CharSequence getTitle() {
        return this.f488b.i();
    }

    public boolean getTitleOptionalHint() {
        return this.f488b.j();
    }

    public void invalidate() {
        this.f488b.k();
    }

    public boolean isTitleOptional() {
        return this.f488b.l();
    }

    public void setCustomView(View view) {
        this.f488b.m(view);
    }

    public void setSubtitle(int i) {
        this.f488b.n(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f488b.o(charSequence);
    }

    public void setTag(Object obj) {
        this.f488b.p(obj);
    }

    public void setTitle(int i) {
        this.f488b.q(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f488b.r(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f488b.s(z);
    }
}
