package c.b.a.n.p;

import android.net.Uri;
import android.text.TextUtils;
import c.b.a.n.h;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g implements h {

    /* renamed from: b  reason: collision with root package name */
    private final h f1060b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f1061c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1062d;

    /* renamed from: e  reason: collision with root package name */
    private String f1063e;

    /* renamed from: f  reason: collision with root package name */
    private URL f1064f;
    private volatile byte[] g;
    private int h;

    public g(String str) {
        this(str, h.f1065a);
    }

    public g(String str, h hVar) {
        this.f1061c = null;
        c.b.a.t.h.b(str);
        this.f1062d = str;
        c.b.a.t.h.d(hVar);
        this.f1060b = hVar;
    }

    public g(URL url) {
        this(url, h.f1065a);
    }

    public g(URL url, h hVar) {
        c.b.a.t.h.d(url);
        this.f1061c = url;
        this.f1062d = null;
        c.b.a.t.h.d(hVar);
        this.f1060b = hVar;
    }

    private byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(h.f873a);
        }
        return this.g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f1063e)) {
            String str = this.f1062d;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f1061c;
                c.b.a.t.h.d(url);
                str = url.toString();
            }
            this.f1063e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f1063e;
    }

    private URL g() {
        if (this.f1064f == null) {
            this.f1064f = new URL(f());
        }
        return this.f1064f;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f1062d;
        if (str != null) {
            return str;
        }
        URL url = this.f1061c;
        c.b.a.t.h.d(url);
        return url.toString();
    }

    public Map<String, String> e() {
        return this.f1060b.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f1060b.equals(gVar.f1060b);
    }

    public URL h() {
        return g();
    }

    public int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 31) + this.f1060b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }
}
