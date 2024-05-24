package c.b.a.n.o.z;

import android.graphics.Bitmap;

public class f implements e {
    public void a(int i) {
    }

    public void b() {
    }

    public Bitmap c(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }
}
