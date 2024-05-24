package c.d.a.b.e.e;

import android.net.Uri;
import b.c.a;

public final class e6 {

    /* renamed from: a  reason: collision with root package name */
    private static final a f1624a = new a();

    public static synchronized Uri a(String str) {
        synchronized (e6.class) {
            a aVar = f1624a;
            Uri uri = (Uri) aVar.get("com.google.android.gms.measurement");
            if (uri != null) {
                return uri;
            }
            Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
            aVar.put("com.google.android.gms.measurement", parse);
            return parse;
        }
    }
}
