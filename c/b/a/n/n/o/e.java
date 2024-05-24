package c.b.a.n.n.o;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c.b.a.n.f;
import c.b.a.n.g;
import c.b.a.n.o.z.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class e {

    /* renamed from: f  reason: collision with root package name */
    private static final a f889f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f890a;

    /* renamed from: b  reason: collision with root package name */
    private final d f891b;

    /* renamed from: c  reason: collision with root package name */
    private final b f892c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f893d;

    /* renamed from: e  reason: collision with root package name */
    private final List<f> f894e;

    e(List<f> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f890a = aVar;
        this.f891b = dVar;
        this.f892c = bVar;
        this.f893d = contentResolver;
        this.f894e = list;
    }

    e(List<f> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f889f, dVar, bVar, contentResolver);
    }

    private String b(Uri uri) {
        Cursor a2 = this.f891b.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    return a2.getString(0);
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }

    private boolean c(File file) {
        return this.f890a.a(file) && 0 < this.f890a.c(file);
    }

    /* access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f893d.openInputStream(uri);
            int a2 = g.a(this.f894e, openInputStream, this.f892c);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream d(Uri uri) {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f890a.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.f893d.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }
}
