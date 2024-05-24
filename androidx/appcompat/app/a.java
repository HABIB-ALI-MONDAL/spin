package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.j;
import b.a.m.b;

public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public static class C0007a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f76a;

        public C0007a(int i, int i2) {
            super(i, i2);
            this.f76a = 0;
            this.f76a = 8388627;
        }

        public C0007a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f76a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.t);
            this.f76a = obtainStyledAttributes.getInt(j.u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0007a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f76a = 0;
        }

        public C0007a(C0007a aVar) {
            super(aVar);
            this.f76a = 0;
            this.f76a = aVar.f76a;
        }
    }

    public interface b {
        void a(boolean z);
    }

    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    public abstract boolean o(int i, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(int i);

    public abstract void v(Drawable drawable);

    public abstract void w(boolean z);

    public abstract void x(int i);

    public abstract void y(CharSequence charSequence);

    public b.a.m.b z(b.a aVar) {
        return null;
    }
}
