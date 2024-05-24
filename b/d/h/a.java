package b.d.h;

import android.util.Base64;
import b.d.j.g;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f572a;

    /* renamed from: b  reason: collision with root package name */
    private final String f573b;

    /* renamed from: c  reason: collision with root package name */
    private final String f574c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f575d;

    /* renamed from: e  reason: collision with root package name */
    private final int f576e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f577f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        g.b(str);
        String str4 = str;
        this.f572a = str4;
        g.b(str2);
        String str5 = str2;
        this.f573b = str5;
        g.b(str3);
        String str6 = str3;
        this.f574c = str6;
        g.b(list);
        this.f575d = list;
        this.f577f = str4 + "-" + str5 + "-" + str6;
    }

    public List<List<byte[]>> a() {
        return this.f575d;
    }

    public int b() {
        return this.f576e;
    }

    public String c() {
        return this.f577f;
    }

    public String d() {
        return this.f572a;
    }

    public String e() {
        return this.f573b;
    }

    public String f() {
        return this.f574c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f572a + ", mProviderPackage: " + this.f573b + ", mQuery: " + this.f574c + ", mCertificates:");
        for (int i = 0; i < this.f575d.size(); i++) {
            sb.append(" [");
            List list = this.f575d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f576e);
        return sb.toString();
    }
}
