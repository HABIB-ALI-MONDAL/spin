package c.b.a.n.n.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import c.b.a.n.n.d;
import c.b.a.n.n.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c implements d<InputStream> {
    private final Uri j;
    private final e k;
    private InputStream l;

    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f885b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f886a;

        a(ContentResolver contentResolver) {
            this.f886a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f886a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f885b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f887b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f888a;

        b(ContentResolver contentResolver) {
            this.f888a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f888a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f887b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    c(Uri uri, e eVar) {
        this.j = uri;
        this.k = eVar;
    }

    private static c e(Context context, Uri uri, d dVar) {
        return new c(uri, new e(c.b.a.c.c(context).j().g(), dVar, c.b.a.c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return e(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return e(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() {
        InputStream d2 = this.k.d(this.j);
        int a2 = d2 != null ? this.k.a(this.j) : -1;
        return a2 != -1 ? new g(d2, a2) : d2;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.l;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public c.b.a.n.a c() {
        return c.b.a.n.a.LOCAL;
    }

    public void cancel() {
    }

    public void d(c.b.a.g gVar, d.a<? super InputStream> aVar) {
        try {
            InputStream h = h();
            this.l = h;
            aVar.h(h);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.g(e2);
        }
    }
}
