package c.b.a.n.q.g;

import android.util.Log;
import c.b.a.n.f;
import c.b.a.n.g;
import c.b.a.n.k;
import c.b.a.n.o.u;
import c.b.a.n.o.z.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j implements k<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f1203a;

    /* renamed from: b  reason: collision with root package name */
    private final k<ByteBuffer, c> f1204b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1205c;

    public j(List<f> list, k<ByteBuffer, c> kVar, b bVar) {
        this.f1203a = list;
        this.f1204b = kVar;
        this.f1205c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: c */
    public u<c> a(InputStream inputStream, int i, int i2, c.b.a.n.j jVar) {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f1204b.a(ByteBuffer.wrap(e2), i, i2, jVar);
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, c.b.a.n.j jVar) {
        return !((Boolean) jVar.c(i.f1202b)).booleanValue() && g.b(this.f1203a, inputStream, this.f1205c) == f.a.GIF;
    }
}
