package c.b.a.n.p;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1072a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1073a;

        public a(Context context) {
            this.f1073a = context;
        }

        public n<Uri, File> b(r rVar) {
            return new k(this.f1073a);
        }
    }

    private static class b implements d<File> {
        private static final String[] l = {"_data"};
        private final Context j;
        private final Uri k;

        b(Context context, Uri uri) {
            this.j = context;
            this.k = uri;
        }

        public Class<File> a() {
            return File.class;
        }

        public void b() {
        }

        public c.b.a.n.a c() {
            return c.b.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public void d(g gVar, d.a<? super File> aVar) {
            Cursor query = this.j.getContentResolver().query(this.k, l, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.g(new FileNotFoundException("Failed to find file path for: " + this.k));
                return;
            }
            aVar.h(new File(str));
        }
    }

    public k(Context context) {
        this.f1072a = context;
    }

    /* renamed from: c */
    public n.a<File> a(Uri uri, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(uri), new b(this.f1072a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return c.b.a.n.n.o.b.b(uri);
    }
}
