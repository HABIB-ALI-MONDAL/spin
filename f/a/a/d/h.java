package f.a.a.d;

import android.net.Uri;
import java.io.Serializable;

public class h implements Serializable {
    private String j;
    private String k;
    private boolean l;

    public enum a {
        CAMERA,
        OTHER
    }

    private h(Uri uri, a aVar) {
        this.j = uri.getPath();
    }

    private h(String str, a aVar) {
        this.j = str;
    }

    public static h d(Uri uri, a aVar) {
        return new h(uri, aVar);
    }

    public static h e(String str, a aVar) {
        return new h(str, aVar);
    }

    public String a() {
        return this.k;
    }

    public String b() {
        return this.j;
    }

    public boolean c() {
        return this.l;
    }

    public void f(String str) {
        this.k = str;
    }

    public void g(boolean z) {
        this.l = z;
    }

    public void h(boolean z) {
    }

    public void i(String str) {
        this.j = str;
    }
}
