package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class a extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static c f300c;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    static class C0012a implements Runnable {
        final /* synthetic */ String[] j;
        final /* synthetic */ Activity k;
        final /* synthetic */ int l;

        C0012a(String[] strArr, Activity activity, int i) {
            this.j = strArr;
            this.k = activity;
            this.l = i;
        }

        public void run() {
            int[] iArr = new int[this.j.length];
            PackageManager packageManager = this.k.getPackageManager();
            String packageName = this.k.getPackageName();
            int length = this.j.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.j[i], packageName);
            }
            ((b) this.k).onRequestPermissionsResult(this.l, this.j, iArr);
        }
    }

    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface c {
        boolean a(Activity activity, String[] strArr, int i);

        boolean b(Activity activity, int i, int i2, Intent intent);
    }

    public interface d {
        void b(int i);
    }

    public static void k(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static c l() {
        return f300c;
    }

    public static void m(Activity activity, String[] strArr, int i) {
        c cVar = f300c;
        if (cVar != null && cVar.a(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof d) {
                ((d) activity).b(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new C0012a(strArr, activity, i));
        }
    }

    public static void n(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }
}
