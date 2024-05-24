package b.d.k;

import android.os.Build;
import android.view.WindowInsets;
import b.d.j.c;
import java.util.Objects;

public class x {

    /* renamed from: a  reason: collision with root package name */
    private final Object f659a;

    x(Object obj) {
        this.f659a = obj;
    }

    public static x g(WindowInsets windowInsets) {
        Objects.requireNonNull(windowInsets);
        return new x(windowInsets);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f659a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f659a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f659a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f659a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public x e(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new x(((WindowInsets) this.f659a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        return c.a(this.f659a, ((x) obj).f659a);
    }

    public WindowInsets f() {
        return (WindowInsets) this.f659a;
    }

    public int hashCode() {
        Object obj = this.f659a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
