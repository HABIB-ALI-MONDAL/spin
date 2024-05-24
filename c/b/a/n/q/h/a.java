package c.b.a.n.q.h;

import android.graphics.Bitmap;
import c.b.a.n.j;
import c.b.a.n.o.u;
import c.b.a.n.q.d.b;
import java.io.ByteArrayOutputStream;

public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f1206a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1207b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        this.f1206a = compressFormat;
        this.f1207b = i;
    }

    public u<byte[]> a(u<Bitmap> uVar, j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        uVar.get().compress(this.f1206a, this.f1207b, byteArrayOutputStream);
        uVar.b();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
