package f.a.a.f;

import android.content.Context;
import android.util.Log;
import java.io.File;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f3121a = "takephoto_cache";

    public static void a(String str) {
        if (str != null) {
            try {
                File file = new File(str);
                if (!file.delete()) {
                    file.deleteOnExit();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static File b(Context context, File file) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file2 = new File(cacheDir, f3121a);
            return (file2.mkdirs() || (file2.exists() && file2.isDirectory())) ? new File(file2, file.getName()) : file;
        }
        if (Log.isLoggable("TFileUtils", 6)) {
            Log.e("TFileUtils", "default disk cache dir is null");
        }
        return file;
    }
}
