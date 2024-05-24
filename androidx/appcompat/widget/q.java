package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.h;
import b.a.j;

class q extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f242b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a  reason: collision with root package name */
    private boolean f243a;

    public q(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        t0 t = t0.t(context, attributeSet, j.W1, i, i2);
        int i3 = j.Y1;
        if (t.q(i3)) {
            b(t.a(i3, false));
        }
        setBackgroundDrawable(t.f(j.X1));
        t.u();
    }

    private void b(boolean z) {
        if (f242b) {
            this.f243a = z;
        } else {
            h.a(this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f242b && this.f243a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f242b && this.f243a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f242b && this.f243a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
