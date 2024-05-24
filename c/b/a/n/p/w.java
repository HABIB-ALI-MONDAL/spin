package c.b.a.n.p;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import c.b.a.n.j;
import c.b.a.n.n.i;
import c.b.a.n.n.n;
import c.b.a.n.p.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class w<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f1107b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: a  reason: collision with root package name */
    private final c<Data> f1108a;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1109a;

        public a(ContentResolver contentResolver) {
            this.f1109a = contentResolver;
        }

        public c.b.a.n.n.d<AssetFileDescriptor> a(Uri uri) {
            return new c.b.a.n.n.a(this.f1109a, uri);
        }

        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1110a;

        public b(ContentResolver contentResolver) {
            this.f1110a = contentResolver;
        }

        public c.b.a.n.n.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f1110a, uri);
        }

        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    public interface c<Data> {
        c.b.a.n.n.d<Data> a(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1111a;

        public d(ContentResolver contentResolver) {
            this.f1111a = contentResolver;
        }

        public c.b.a.n.n.d<InputStream> a(Uri uri) {
            return new n(this.f1111a, uri);
        }

        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f1108a = cVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(uri), this.f1108a.a(uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f1107b.contains(uri.getScheme());
    }
}
