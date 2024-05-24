package c.b.a.n.q.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.o.u;
import java.util.List;

public class d implements k<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1178a;

    public d(Context context) {
        this.f1178a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        try {
            return this.f1178a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int f(Uri uri) {
        Integer num;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            num = Integer.valueOf(this.f1178a.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    num = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            num = null;
        }
        if (num == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (num.intValue() != 0) {
            return num.intValue();
        } else {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        }
    }

    /* renamed from: c */
    public u<Drawable> a(Uri uri, int i, int i2, j jVar) {
        int f2 = f(uri);
        String authority = uri.getAuthority();
        return c.f(a.a(authority.equals(this.f1178a.getPackageName()) ? this.f1178a : d(uri, authority), f2));
    }

    /* renamed from: e */
    public boolean b(Uri uri, j jVar) {
        return uri.getScheme().equals("android.resource");
    }
}
