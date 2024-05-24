package c.b.a.n.p;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f1058a;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f1059a;

        public a(d<Data> dVar) {
            this.f1059a = dVar;
        }

        public final n<File, Data> b(r rVar) {
            return new f(this.f1059a);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {

        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: d */
            public void b(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            /* renamed from: e */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    private static final class c<Data> implements c.b.a.n.n.d<Data> {
        private final File j;
        private final d<Data> k;
        private Data l;

        c(File file, d<Data> dVar) {
            this.j = file;
            this.k = dVar;
        }

        public Class<Data> a() {
            return this.k.a();
        }

        public void b() {
            Data data = this.l;
            if (data != null) {
                try {
                    this.k.b(data);
                } catch (IOException unused) {
                }
            }
        }

        public c.b.a.n.a c() {
            return c.b.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public void d(g gVar, d.a<? super Data> aVar) {
            try {
                Data c2 = this.k.c(this.j);
                this.l = c2;
                aVar.h(c2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.g(e2);
            }
        }
    }

    public interface d<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(File file);
    }

    public static class e extends a<InputStream> {

        class a implements d<InputStream> {
            a() {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f1058a = dVar;
    }

    /* renamed from: c */
    public n.a<Data> a(File file, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(file), new c(file, this.f1058a));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
