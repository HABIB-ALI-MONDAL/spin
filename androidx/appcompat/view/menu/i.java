package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.o;
import b.a.g;

class i implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, o.a {
    private h j;
    private b k;
    f l;
    private o.a m;

    public i(h hVar) {
        this.j = hVar;
    }

    public void a(h hVar, boolean z) {
        if (z || hVar == this.j) {
            c();
        }
        o.a aVar = this.m;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public boolean b(h hVar) {
        o.a aVar = this.m;
        if (aVar != null) {
            return aVar.b(hVar);
        }
        return false;
    }

    public void c() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        h hVar = this.j;
        b.a aVar = new b.a(hVar.u());
        f fVar = new f(aVar.b(), g.abc_list_menu_item_layout);
        this.l = fVar;
        fVar.i(this);
        this.j.b(this.l);
        aVar.c(this.l.b(), this);
        View y = hVar.y();
        if (y != null) {
            aVar.d(y);
        } else {
            aVar.e(hVar.w());
            aVar.g(hVar.x());
        }
        aVar.f(this);
        b a2 = aVar.a();
        this.k = a2;
        a2.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.k.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.k.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.j.L((j) this.l.b().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.l.a(this.j, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.k.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.k.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.j.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.j.performShortcut(i, keyEvent, 0);
    }
}
