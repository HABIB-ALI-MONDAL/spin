package e.a.a;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static String f3071d = "luban_disk_cache";

    /* renamed from: a  reason: collision with root package name */
    private File f3072a;

    /* renamed from: b  reason: collision with root package name */
    private List<File> f3073b;

    /* renamed from: c  reason: collision with root package name */
    private b f3074c;

    private a(File file) {
        this.f3074c = new b(file);
    }

    public static a a(Context context, File file) {
        a aVar = new a(c(context));
        aVar.f3072a = file;
        aVar.f3073b = Collections.singletonList(file);
        return aVar;
    }

    public static a b(Context context, List<File> list) {
        a aVar = new a(c(context));
        aVar.f3073b = list;
        aVar.f3072a = list.get(0);
        return aVar;
    }

    private static File c(Context context) {
        return d(context, f3071d);
    }

    private static File d(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        if (Log.isLoggable("Luban", 6)) {
            Log.e("Luban", "default disk cache dir is null");
        }
        return null;
    }

    public a e(int i) {
        this.f3074c.f3077c = i;
        return this;
    }
}
