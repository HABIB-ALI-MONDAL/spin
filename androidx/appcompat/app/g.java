package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.m.b;
import b.d.k.d;

public class g extends Dialog implements d {
    private e j;
    private final d.a k = new a();

    class a implements d.a {
        a() {
        }

        public boolean d(KeyEvent keyEvent) {
            return g.this.c(keyEvent);
        }
    }

    public g(Context context, int i) {
        super(context, b(context, i));
        a().n((Bundle) null);
        a().d();
    }

    private static int b(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public e a() {
        if (this.j == null) {
            this.j = e.f(this, this);
        }
        return this.j;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i) {
        return a().u(i);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.e(this.k, getWindow().getDecorView(), this, keyEvent);
    }

    public void f(b bVar) {
    }

    public <T extends View> T findViewById(int i) {
        return a().g(i);
    }

    public void h(b bVar) {
    }

    public b i(b.a aVar) {
        return null;
    }

    public void invalidateOptionsMenu() {
        a().l();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        a().k();
        super.onCreate(bundle);
        a().n(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        a().t();
    }

    public void setContentView(int i) {
        a().v(i);
    }

    public void setContentView(View view) {
        a().w(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().x(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().z(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().z(charSequence);
    }
}
