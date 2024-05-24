package androidx.appcompat.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.y0;
import androidx.core.app.a;
import androidx.core.app.l;
import b.a.m.b;
import b.g.a.e;

public class c extends e implements d, l.a {
    private e v;
    private int w = 0;
    private Resources x;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean C(int r2, android.view.KeyEvent r3) {
        /*
            r1 = this;
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r2 >= r0) goto L_0x003e
            boolean r2 = r3.isCtrlPressed()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getMetaState()
            boolean r2 = android.view.KeyEvent.metaStateHasNoModifiers(r2)
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getRepeatCount()
            if (r2 != 0) goto L_0x003e
            int r2 = r3.getKeyCode()
            boolean r2 = android.view.KeyEvent.isModifierKey(r2)
            if (r2 != 0) goto L_0x003e
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L_0x003e
            android.view.View r0 = r2.getDecorView()
            if (r0 == 0) goto L_0x003e
            android.view.View r2 = r2.getDecorView()
            boolean r2 = r2.dispatchKeyShortcutEvent(r3)
            if (r2 == 0) goto L_0x003e
            r2 = 1
            return r2
        L_0x003e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.c.C(int, android.view.KeyEvent):boolean");
    }

    @Deprecated
    public void A() {
    }

    public boolean B() {
        Intent e2 = e();
        if (e2 == null) {
            return true;
        }
        if (F(e2)) {
            l j = l.j(this);
            y(j);
            z(j);
            j.k();
            try {
                a.k(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            E(e2);
            return true;
        }
    }

    public void D(Toolbar toolbar) {
        w().y(toolbar);
    }

    public void E(Intent intent) {
        androidx.core.app.e.e(this, intent);
    }

    public boolean F(Intent intent) {
        return androidx.core.app.e.f(this, intent);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        w().c(view, layoutParams);
    }

    public void closeOptionsMenu() {
        a x2 = x();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (x2 == null || !x2.g()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a x2 = x();
        if (keyCode != 82 || x2 == null || !x2.p(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public Intent e() {
        return androidx.core.app.e.a(this);
    }

    public void f(b bVar) {
    }

    public <T extends View> T findViewById(int i) {
        return w().g(i);
    }

    public MenuInflater getMenuInflater() {
        return w().i();
    }

    public Resources getResources() {
        if (this.x == null && y0.b()) {
            this.x = new y0(this, super.getResources());
        }
        Resources resources = this.x;
        return resources == null ? super.getResources() : resources;
    }

    public void h(b bVar) {
    }

    public b i(b.a aVar) {
        return null;
    }

    public void invalidateOptionsMenu() {
        w().l();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w().m(configuration);
        if (this.x != null) {
            this.x.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        A();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        e w2 = w();
        w2.k();
        w2.n(bundle);
        if (w2.d() && (i = this.w) != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.w, false);
            } else {
                setTheme(i);
            }
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        w().o();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (C(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a x2 = x();
        if (menuItem.getItemId() != 16908332 || x2 == null || (x2.j() & 4) == 0) {
            return false;
        }
        return B();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        w().p(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        w().q();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        w().r(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        w().s();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        w().t();
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        w().z(charSequence);
    }

    public void openOptionsMenu() {
        a x2 = x();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (x2 == null || !x2.q()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        w().v(i);
    }

    public void setContentView(View view) {
        w().w(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        w().x(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.w = i;
    }

    public void v() {
        w().l();
    }

    public e w() {
        if (this.v == null) {
            this.v = e.e(this, this);
        }
        return this.v;
    }

    public a x() {
        return w().j();
    }

    public void y(l lVar) {
        lVar.g(this);
    }

    public void z(l lVar) {
    }
}
