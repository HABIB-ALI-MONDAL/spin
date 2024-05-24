package f.a.a.f;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import f.a.a.d.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3123a = b.class.getName();

    public static Uri a(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        return "file".equals(uri.getScheme()) ? f(context, new File(uri.getPath())) : uri;
    }

    public static String b(Uri uri, Activity activity) {
        if (uri == null) {
            Log.e(f3123a, "uri is null,activity may have been recovered?");
            return null;
        } else if (!"content".equals(uri.getScheme()) || !uri.getPath().contains("document")) {
            return c(uri, activity);
        } else {
            File d2 = e.d(activity, uri);
            try {
                e.e(activity.getContentResolver().openInputStream(uri), d2);
                return d2.getPath();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                throw new f.a.a.d.f(g.TYPE_NO_FIND);
            }
        }
    }

    public static String c(Uri uri, Activity activity) {
        if (uri != null) {
            File d2 = d(uri, activity);
            String path = d2 == null ? null : d2.getPath();
            if (TextUtils.isEmpty(path)) {
                throw new f.a.a.d.f(g.TYPE_URI_PARSE_FAIL);
            } else if (e.a(activity, e.b(activity, uri))) {
                return path;
            } else {
                throw new f.a.a.d.f(g.TYPE_NOT_IMAGE);
            }
        } else {
            Log.w(f3123a, "uri is null,activity may have been recovered?");
            throw new f.a.a.d.f(g.TYPE_URI_NULL);
        }
    }

    public static File d(Uri uri, Activity activity) {
        String str;
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            String[] strArr = {"_data"};
            Cursor query = activity.getContentResolver().query(uri, strArr, (String) null, (String[]) null, (String) null);
            query.moveToFirst();
            int columnIndex = query.getColumnIndex(strArr[0]);
            str = columnIndex >= 0 ? query.getString(columnIndex) : TextUtils.equals(uri.getAuthority(), c.a(activity)) ? g(activity, uri) : null;
            query.close();
        } else {
            str = "file".equals(scheme) ? uri.getPath() : null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str);
    }

    public static Uri e(Context context) {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, "/images/" + format + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return f(context, file);
    }

    public static Uri f(Context context, File file) {
        return FileProvider.getUriForFile(context, c.a(context), file);
    }

    public static String g(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        return TextUtils.equals(uri.getAuthority(), c.a(context)) ? new File(uri.getPath().replace("camera_photos/", "")).getAbsolutePath() : uri.getPath();
    }
}
