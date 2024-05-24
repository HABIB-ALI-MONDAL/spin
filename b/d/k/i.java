package b.d.k;

import android.view.View;
import android.view.ViewParent;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f628a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f629b;

    /* renamed from: c  reason: collision with root package name */
    private final View f630c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f631d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f632e;

    public i(View view) {
        this.f630c = view;
    }

    private boolean f(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent g;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!j() || (g = g(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f630c.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            int[] h = h();
            h[0] = 0;
            h[1] = 0;
            iArr3 = h;
        } else {
            iArr3 = iArr2;
        }
        s.d(g, this.f630c, i, i2, i3, i4, i5, iArr3);
        if (iArr4 != null) {
            this.f630c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    private ViewParent g(int i) {
        if (i == 0) {
            return this.f628a;
        }
        if (i != 1) {
            return null;
        }
        return this.f629b;
    }

    private int[] h() {
        if (this.f632e == null) {
            this.f632e = new int[2];
        }
        return this.f632e;
    }

    private void l(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f628a = viewParent;
        } else if (i == 1) {
            this.f629b = viewParent;
        }
    }

    public boolean a(float f2, float f3, boolean z) {
        ViewParent g;
        if (!j() || (g = g(0)) == null) {
            return false;
        }
        return s.a(g, this.f630c, f2, f3, z);
    }

    public boolean b(float f2, float f3) {
        ViewParent g;
        if (!j() || (g = g(0)) == null) {
            return false;
        }
        return s.b(g, this.f630c, f2, f3);
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent g;
        int i4;
        int i5;
        if (!j() || (g = g(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f630c.getLocationInWindow(iArr2);
                i5 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                iArr = h();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            s.c(g, this.f630c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f630c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void d(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        f(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr) {
        return f(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    public boolean i(int i) {
        return g(i) != null;
    }

    public boolean j() {
        return this.f631d;
    }

    public void k(boolean z) {
        if (this.f631d) {
            p.K(this.f630c);
        }
        this.f631d = z;
    }

    public boolean m(int i, int i2) {
        if (i(i2)) {
            return true;
        }
        if (!j()) {
            return false;
        }
        View view = this.f630c;
        for (ViewParent parent = this.f630c.getParent(); parent != null; parent = parent.getParent()) {
            if (s.f(parent, view, this.f630c, i, i2)) {
                l(i2, parent);
                s.e(parent, view, this.f630c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void n(int i) {
        ViewParent g = g(i);
        if (g != null) {
            s.g(g, this.f630c, i);
            l(i, (ViewParent) null);
        }
    }
}
