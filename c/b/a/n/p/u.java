package c.b.a.n.p;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import c.b.a.n.j;
import c.b.a.n.p.n;
import java.io.File;
import java.io.InputStream;

public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f1104a;

    public static final class a implements o<String, AssetFileDescriptor> {
        public n<String, AssetFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public n<String, ParcelFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<String, InputStream> {
        public n<String, InputStream> b(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f1104a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null) {
                return parse;
            }
        }
        return f(str);
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public n.a<Data> a(String str, int i, int i2, j jVar) {
        Uri e2 = e(str);
        if (e2 == null) {
            return null;
        }
        return this.f1104a.a(e2, i, i2, jVar);
    }

    /* renamed from: d */
    public boolean b(String str) {
        return true;
    }
}
