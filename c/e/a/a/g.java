package c.e.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

public final class g {
    private static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b b(Context context) {
        String a2 = a(context);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return c.a(new File(a2));
    }
}
