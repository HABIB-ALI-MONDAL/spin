package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.h;
import c.b.a.n.o.z.e;
import java.security.MessageDigest;

public class n extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f1153b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(h.f873a);

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f1153b);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return t.e(eVar, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof n;
    }

    public int hashCode() {
        return 1572326941;
    }
}
