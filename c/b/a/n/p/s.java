package c.b.a.n.p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.b.a.n.j;
import c.b.a.n.p.n;
import java.io.InputStream;

public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f1097a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f1098b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1099a;

        public a(Resources resources) {
            this.f1099a = resources;
        }

        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f1099a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1100a;

        public b(Resources resources) {
            this.f1100a = resources;
        }

        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f1100a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1101a;

        public c(Resources resources) {
            this.f1101a = resources;
        }

        public n<Integer, InputStream> b(r rVar) {
            return new s(this.f1101a, rVar.d(Uri.class, InputStream.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1102a;

        public d(Resources resources) {
            this.f1102a = resources;
        }

        public n<Integer, Uri> b(r rVar) {
            return new s(this.f1102a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f1098b = resources;
        this.f1097a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f1098b.getResourcePackageName(num.intValue()) + '/' + this.f1098b.getResourceTypeName(num.intValue()) + '/' + this.f1098b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    /* renamed from: c */
    public n.a<Data> a(Integer num, int i, int i2, j jVar) {
        Uri d2 = d(num);
        if (d2 == null) {
            return null;
        }
        return this.f1097a.a(d2, i, i2, jVar);
    }

    /* renamed from: e */
    public boolean b(Integer num) {
        return true;
    }
}
