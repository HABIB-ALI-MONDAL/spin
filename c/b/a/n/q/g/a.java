package c.b.a.n.q.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c.b.a.m.a;
import c.b.a.m.c;
import c.b.a.m.d;
import c.b.a.m.e;
import c.b.a.n.f;
import c.b.a.n.g;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.t.i;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class a implements k<ByteBuffer, c> {

    /* renamed from: f  reason: collision with root package name */
    private static final C0053a f1179f = new C0053a();
    private static final b g = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f1180a;

    /* renamed from: b  reason: collision with root package name */
    private final List<f> f1181b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1182c;

    /* renamed from: d  reason: collision with root package name */
    private final C0053a f1183d;

    /* renamed from: e  reason: collision with root package name */
    private final b f1184e;

    /* renamed from: c.b.a.n.q.g.a$a  reason: collision with other inner class name */
    static class C0053a {
        C0053a() {
        }

        /* access modifiers changed from: package-private */
        public c.b.a.m.a a(a.C0039a aVar, c cVar, ByteBuffer byteBuffer, int i) {
            return new e(aVar, cVar, byteBuffer, i);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<d> f1185a = i.e(0);

        b() {
        }

        /* access modifiers changed from: package-private */
        public synchronized d a(ByteBuffer byteBuffer) {
            d poll;
            poll = this.f1185a.poll();
            if (poll == null) {
                poll = new d();
            }
            poll.p(byteBuffer);
            return poll;
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(d dVar) {
            dVar.a();
            this.f1185a.offer(dVar);
        }
    }

    public a(Context context, List<f> list, c.b.a.n.o.z.e eVar, c.b.a.n.o.z.b bVar) {
        this(context, list, eVar, bVar, g, f1179f);
    }

    a(Context context, List<f> list, c.b.a.n.o.z.e eVar, c.b.a.n.o.z.b bVar, b bVar2, C0053a aVar) {
        this.f1180a = context.getApplicationContext();
        this.f1181b = list;
        this.f1183d = aVar;
        this.f1184e = new b(eVar, bVar);
        this.f1182c = bVar2;
    }

    private e c(ByteBuffer byteBuffer, int i, int i2, d dVar, j jVar) {
        long b2 = c.b.a.t.d.b();
        try {
            c c2 = dVar.c();
            if (c2.b() > 0) {
                if (c2.c() == 0) {
                    Bitmap.Config config = jVar.c(i.f1201a) == c.b.a.n.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    c.b.a.m.a a2 = this.f1183d.a(this.f1184e, c2, byteBuffer, e(c2, i, i2));
                    a2.c(config);
                    a2.e();
                    Bitmap d2 = a2.d();
                    if (d2 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c.b.a.t.d.a(b2));
                        }
                        return null;
                    }
                    e eVar = new e(new c(this.f1180a, a2, c.b.a.n.q.b.c(), i, i2, d2));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c.b.a.t.d.a(b2));
                    }
                    return eVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + c.b.a.t.d.a(b2));
            }
        }
    }

    private static int e(c cVar, int i, int i2) {
        int min = Math.min(cVar.a() / i2, cVar.d() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    /* renamed from: d */
    public e a(ByteBuffer byteBuffer, int i, int i2, j jVar) {
        d a2 = this.f1182c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, a2, jVar);
        } finally {
            this.f1182c.b(a2);
        }
    }

    /* renamed from: f */
    public boolean b(ByteBuffer byteBuffer, j jVar) {
        return !((Boolean) jVar.c(i.f1202b)).booleanValue() && g.c(this.f1181b, byteBuffer) == f.a.GIF;
    }
}
