package b.d.k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private C0028b f621a;

    public interface a {
    }

    /* renamed from: b.d.k.b$b  reason: collision with other inner class name */
    public interface C0028b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public b(Context context) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f621a = null;
    }

    public void i(a aVar) {
    }

    public void j(C0028b bVar) {
        if (!(this.f621a == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f621a = bVar;
    }
}
