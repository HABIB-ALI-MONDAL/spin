package c.b.a.n.p;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.n.h;
import c.b.a.n.n.m;
import c.b.a.n.p.n;
import java.io.InputStream;

public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final int f1050c = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f1051a;

    /* renamed from: b  reason: collision with root package name */
    private final C0047a<Data> f1052b;

    /* renamed from: c.b.a.n.p.a$a  reason: collision with other inner class name */
    public interface C0047a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, C0047a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f1053a;

        public b(AssetManager assetManager) {
            this.f1053a = assetManager;
        }

        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.f1053a, this);
        }
    }

    public static class c implements o<Uri, InputStream>, C0047a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f1054a;

        public c(AssetManager assetManager) {
            this.f1054a = assetManager;
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        public n<Uri, InputStream> b(r rVar) {
            return new a(this.f1054a, this);
        }
    }

    public a(AssetManager assetManager, C0047a<Data> aVar) {
        this.f1051a = assetManager;
        this.f1052b = aVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(uri), this.f1052b.a(this.f1051a, uri.toString().substring(f1050c)));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
