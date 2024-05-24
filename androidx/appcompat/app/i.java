package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.u0;
import b.d.k.p;
import java.util.ArrayList;

class i extends a {

    /* renamed from: a  reason: collision with root package name */
    b0 f106a;

    /* renamed from: b  reason: collision with root package name */
    boolean f107b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f108c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f109d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f110e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<a.b> f111f = new ArrayList<>();
    private final Runnable g = new a();
    private final Toolbar.f h;

    class a implements Runnable {
        a() {
        }

        public void run() {
            i.this.C();
        }
    }

    class b implements Toolbar.f {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return i.this.f108c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements o.a {
        private boolean j;

        c() {
        }

        public void a(h hVar, boolean z) {
            if (!this.j) {
                this.j = true;
                i.this.f106a.h();
                Window.Callback callback = i.this.f108c;
                if (callback != null) {
                    callback.onPanelClosed(108, hVar);
                }
                this.j = false;
            }
        }

        public boolean b(h hVar) {
            Window.Callback callback = i.this.f108c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, hVar);
            return true;
        }
    }

    private final class d implements h.a {
        d() {
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }

        public void b(h hVar) {
            i iVar = i.this;
            if (iVar.f108c == null) {
                return;
            }
            if (iVar.f106a.c()) {
                i.this.f108c.onPanelClosed(108, hVar);
            } else if (i.this.f108c.onPreparePanel(0, (View) null, hVar)) {
                i.this.f108c.onMenuOpened(108, hVar);
            }
        }
    }

    private class e extends b.a.m.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            return i == 0 ? new View(i.this.f106a.q()) : super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                i iVar = i.this;
                if (!iVar.f107b) {
                    iVar.f106a.f();
                    i.this.f107b = true;
                }
            }
            return onPreparePanel;
        }
    }

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.h = bVar;
        this.f106a = new u0(toolbar, false);
        e eVar = new e(callback);
        this.f108c = eVar;
        this.f106a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f106a.setWindowTitle(charSequence);
    }

    private Menu A() {
        if (!this.f109d) {
            this.f106a.i(new c(), new d());
            this.f109d = true;
        }
        return this.f106a.l();
    }

    public Window.Callback B() {
        return this.f108c;
    }

    /* access modifiers changed from: package-private */
    public void C() {
        Menu A = A();
        h hVar = A instanceof h ? (h) A : null;
        if (hVar != null) {
            hVar.d0();
        }
        try {
            A.clear();
            if (!this.f108c.onCreatePanelMenu(0, A) || !this.f108c.onPreparePanel(0, (View) null, A)) {
                A.clear();
            }
        } finally {
            if (hVar != null) {
                hVar.c0();
            }
        }
    }

    public void D(int i, int i2) {
        this.f106a.y((i & i2) | ((i2 ^ -1) & this.f106a.j()));
    }

    public boolean g() {
        return this.f106a.d();
    }

    public boolean h() {
        if (!this.f106a.u()) {
            return false;
        }
        this.f106a.collapseActionView();
        return true;
    }

    public void i(boolean z) {
        if (z != this.f110e) {
            this.f110e = z;
            int size = this.f111f.size();
            for (int i = 0; i < size; i++) {
                this.f111f.get(i).a(z);
            }
        }
    }

    public int j() {
        return this.f106a.j();
    }

    public Context k() {
        return this.f106a.q();
    }

    public boolean l() {
        this.f106a.o().removeCallbacks(this.g);
        p.y(this.f106a.o(), this.g);
        return true;
    }

    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f106a.o().removeCallbacks(this.g);
    }

    public boolean o(int i, KeyEvent keyEvent) {
        Menu A = A();
        if (A == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        A.setQwertyMode(z);
        return A.performShortcut(i, keyEvent, 0);
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    public boolean q() {
        return this.f106a.e();
    }

    public void r(boolean z) {
    }

    public void s(boolean z) {
        D(z ? 4 : 0, 4);
    }

    public void t(boolean z) {
        D(z ? 8 : 0, 8);
    }

    public void u(int i) {
        this.f106a.z(i);
    }

    public void v(Drawable drawable) {
        this.f106a.w(drawable);
    }

    public void w(boolean z) {
    }

    public void x(int i) {
        b0 b0Var = this.f106a;
        b0Var.setTitle(i != 0 ? b0Var.q().getText(i) : null);
    }

    public void y(CharSequence charSequence) {
        this.f106a.setWindowTitle(charSequence);
    }
}
