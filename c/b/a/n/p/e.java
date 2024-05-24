package c.b.a.n.p;

import android.util.Base64;
import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f1056a;

    public interface a<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(String str);
    }

    private static final class b<Data> implements d<Data> {
        private final String j;
        private final a<Data> k;
        private Data l;

        b(String str, a<Data> aVar) {
            this.j = str;
            this.k = aVar;
        }

        public Class<Data> a() {
            return this.k.a();
        }

        public void b() {
            try {
                this.k.b(this.l);
            } catch (IOException unused) {
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
            } catch (IllegalArgumentException e2) {
                aVar.g(e2);
            }
        }
    }

    public static final class c implements o<String, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f1057a = new a(this);

        class a implements a<InputStream> {
            a(c cVar) {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: d */
            public void b(InputStream inputStream) {
                inputStream.close();
            }

            /* renamed from: e */
            public InputStream c(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        public n<String, InputStream> b(r rVar) {
            return new e(this.f1057a);
        }
    }

    public e(a<Data> aVar) {
        this.f1056a = aVar;
    }

    /* renamed from: c */
    public n.a<Data> a(String str, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(str), new b(str, this.f1056a));
    }

    /* renamed from: d */
    public boolean b(String str) {
        return str.startsWith("data:image");
    }
}
