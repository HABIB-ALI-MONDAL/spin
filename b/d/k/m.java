package b.d.k;

import android.view.View;
import android.view.ViewGroup;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private int f633a;

    /* renamed from: b  reason: collision with root package name */
    private int f634b;

    public m(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f633a | this.f634b;
    }

    public void b(View view, View view2, int i) {
        c(view, view2, i, 0);
    }

    public void c(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f634b = i;
        } else {
            this.f633a = i;
        }
    }

    public void d(View view, int i) {
        if (i == 1) {
            this.f634b = 0;
        } else {
            this.f633a = 0;
        }
    }
}
