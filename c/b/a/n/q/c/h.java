package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.o.z.e;
import java.security.MessageDigest;

public class h extends e {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f1134b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(c.b.a.n.h.f873a);

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f1134b);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(e eVar, Bitmap bitmap, int i, int i2) {
        return t.c(eVar, bitmap, i, i2);
    }

    public boolean equals(Object obj) {
        return obj instanceof h;
    }

    public int hashCode() {
        return -670243078;
    }
}
