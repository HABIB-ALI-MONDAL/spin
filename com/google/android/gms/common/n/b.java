package com.google.android.gms.common.n;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.k;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f2255a;

    public b(Context context) {
        this.f2255a = context;
    }

    public int a(String str) {
        return this.f2255a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f2255a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i) {
        return this.f2255a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence d(String str) {
        return this.f2255a.getPackageManager().getApplicationLabel(this.f2255a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i) {
        return this.f2255a.getPackageManager().getPackageInfo(str, i);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f2255a);
        }
        if (!k.h() || (nameForUid = this.f2255a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f2255a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean g(int i, String str) {
        if (k.d()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f2255a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f2255a.getPackageManager().getPackagesForUid(i);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
