package f.a.a.f;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import c.c.a.h.b;
import f.a.a.a;
import f.a.a.d.e;
import f.a.a.d.f;
import f.a.a.d.h;
import f.a.a.d.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3124a = b.class.getName();

    public static void a(e eVar, i iVar) {
        if (!eVar.a().getPackageManager().queryIntentActivities(iVar.a(), 131072).isEmpty()) {
            j(eVar, iVar);
        } else {
            Toast.makeText(eVar.a(), eVar.a().getResources().getText(a.tip_no_camera), 0).show();
            throw new f(f.a.a.d.g.TYPE_NO_CAMERA);
        }
    }

    public static ArrayList<Uri> b(Context context, ArrayList<b> arrayList) {
        ArrayList<Uri> arrayList2 = new ArrayList<>();
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(FileProvider.getUriForFile(context, c.a(context), new File(it.next().l)));
        }
        return arrayList2;
    }

    public static void c(e eVar, Uri uri, Uri uri2, f.a.a.d.a aVar) {
        if (eVar.a().getPackageManager().queryIntentActivities(b.b(uri, uri2, aVar), 131072).isEmpty()) {
            d(eVar, uri, uri2, aVar);
        } else {
            j(eVar, new i(b.b(uri, uri2, aVar), 1001));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (r5 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        if (r0 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        r3.d(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0054, code lost:
        if (r0 != null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(f.a.a.d.e r2, android.net.Uri r3, android.net.Uri r4, f.a.a.d.a r5) {
        /*
            int r0 = r5.a()
            int r1 = r5.b()
            int r0 = r0 * r1
            if (r0 <= 0) goto L_0x0035
            b.g.a.d r0 = r2.b()
            com.soundcloud.android.crop.a r3 = com.soundcloud.android.crop.a.c(r3, r4)
            int r4 = r5.a()
            int r5 = r5.b()
            r3.h(r4, r5)
            if (r0 == 0) goto L_0x002d
        L_0x0021:
            android.app.Activity r4 = r2.a()
            b.g.a.d r2 = r2.b()
            r3.f(r4, r2)
            goto L_0x0065
        L_0x002d:
            android.app.Activity r2 = r2.a()
            r3.d(r2)
            goto L_0x0065
        L_0x0035:
            int r0 = r5.c()
            int r1 = r5.d()
            int r0 = r0 * r1
            if (r0 <= 0) goto L_0x0057
            b.g.a.d r0 = r2.b()
            com.soundcloud.android.crop.a r3 = com.soundcloud.android.crop.a.c(r3, r4)
            int r4 = r5.c()
            int r5 = r5.d()
            r3.i(r4, r5)
            if (r0 == 0) goto L_0x002d
            goto L_0x0021
        L_0x0057:
            b.g.a.d r5 = r2.b()
            com.soundcloud.android.crop.a r3 = com.soundcloud.android.crop.a.c(r3, r4)
            r3.a()
            if (r5 == 0) goto L_0x002d
            goto L_0x0021
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.f.g.d(f.a.a.d.e, android.net.Uri, android.net.Uri, f.a.a.d.a):void");
    }

    public static ArrayList<h> e(ArrayList<b> arrayList, h.a aVar) {
        ArrayList<h> arrayList2 = new ArrayList<>();
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(h.e(it.next().l, aVar));
        }
        return arrayList2;
    }

    public static ArrayList<h> f(ArrayList<Uri> arrayList, h.a aVar) {
        ArrayList<h> arrayList2 = new ArrayList<>();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(h.d(it.next(), aVar));
        }
        return arrayList2;
    }

    public static boolean g() {
        String str = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str2 = f3124a;
        Log.i(str2, "release:" + str + "sdk:" + i);
        String str3 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str3) && str3.toLowerCase().contains("lenovo");
    }

    public static void h(e eVar, List<i> list, int i, boolean z) {
        int i2 = i + 1;
        if (i2 > list.size()) {
            throw new f(z ? f.a.a.d.g.TYPE_NO_MATCH_PICK_INTENT : f.a.a.d.g.TYPE_NO_MATCH_CROP_INTENT);
        }
        i iVar = list.get(i);
        if (eVar.a().getPackageManager().queryIntentActivities(iVar.a(), 131072).isEmpty()) {
            h(eVar, list, i2, z);
        } else {
            j(eVar, iVar);
        }
    }

    public static ProgressDialog i(Activity activity, String... strArr) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        String string = activity.getResources().getString(a.tip_tips);
        if (strArr != null && strArr.length > 0) {
            string = strArr[0];
        }
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(string);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }

    public static void j(e eVar, i iVar) {
        if (eVar.b() != null) {
            eVar.b().startActivityForResult(iVar.a(), iVar.b());
        } else {
            eVar.a().startActivityForResult(iVar.a(), iVar.b());
        }
    }
}
