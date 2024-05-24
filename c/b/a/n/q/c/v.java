package c.b.a.n.q.c;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import c.b.a.n.i;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.o.u;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class v<T> implements k<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final i<Long> f1168d = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e  reason: collision with root package name */
    public static final i<Integer> f1169e = i.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f  reason: collision with root package name */
    private static final d f1170f = new d();

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f1171a;

    /* renamed from: b  reason: collision with root package name */
    private final c.b.a.n.o.z.e f1172b;

    /* renamed from: c  reason: collision with root package name */
    private final d f1173c;

    class a implements i.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1174a = ByteBuffer.allocate(8);

        a() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f1174a) {
                this.f1174a.position(0);
                messageDigest.update(this.f1174a.putLong(l.longValue()).array());
            }
        }
    }

    class b implements i.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1175a = ByteBuffer.allocate(4);

        b() {
        }

        /* renamed from: b */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f1175a) {
                    this.f1175a.position(0);
                    messageDigest.update(this.f1175a.putInt(num.intValue()).array());
                }
            }
        }
    }

    private static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    v(c.b.a.n.o.z.e eVar, e<T> eVar2) {
        this(eVar, eVar2, f1170f);
    }

    v(c.b.a.n.o.z.e eVar, e<T> eVar2, d dVar) {
        this.f1172b = eVar;
        this.f1171a = eVar2;
        this.f1173c = dVar;
    }

    public static k<AssetFileDescriptor, Bitmap> c(c.b.a.n.o.z.e eVar) {
        return new v(eVar, new c((a) null));
    }

    @TargetApi(27)
    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3) {
        return (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE) ? mediaMetadataRetriever.getFrameAtTime(j, i) : mediaMetadataRetriever.getScaledFrameAtTime(j, i, i2, i3);
    }

    public static k<ParcelFileDescriptor, Bitmap> e(c.b.a.n.o.z.e eVar) {
        return new v(eVar, new f());
    }

    public u<Bitmap> a(T t, int i, int i2, j jVar) {
        long longValue = ((Long) jVar.c(f1168d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) jVar.c(f1169e);
            if (num == null) {
                num = 2;
            }
            MediaMetadataRetriever a2 = this.f1173c.a();
            try {
                this.f1171a.a(a2, t);
                Bitmap d2 = d(a2, longValue, num.intValue(), i, i2);
                a2.release();
                return d.f(d2, this.f1172b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean b(T t, j jVar) {
        return true;
    }
}
