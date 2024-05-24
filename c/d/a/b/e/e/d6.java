package c.d.a.b.e.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

public final class d6 {

    /* renamed from: a  reason: collision with root package name */
    static volatile v6 f1616a = v6.c();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f1617b = new Object();

    public static boolean a(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        }
        if (!f1616a.b()) {
            synchronized (f1617b) {
                if (f1616a.b()) {
                    boolean booleanValue = ((Boolean) f1616a.a()).booleanValue();
                    return booleanValue;
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                    if (resolveContentProvider != null) {
                        if (!"com.google.android.gms".equals(resolveContentProvider.packageName)) {
                        }
                    }
                    f1616a = v6.d(Boolean.valueOf(z));
                }
                try {
                    if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                f1616a = v6.d(Boolean.valueOf(z));
            }
        }
        return ((Boolean) f1616a.a()).booleanValue();
    }
}
