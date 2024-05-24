package b.d.g;

import android.content.res.Configuration;
import android.os.Build;

public final class a {
    public static b a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.d(configuration.getLocales());
        }
        return b.a(configuration.locale);
    }
}
