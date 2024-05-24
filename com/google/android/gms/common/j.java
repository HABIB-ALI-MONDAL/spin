package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import com.google.errorprone.annotations.RestrictedInheritance;
import javax.annotation.Nullable;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class j {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static j f2242c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2243a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f2244b;

    public j(Context context) {
        this.f2243a = context.getApplicationContext();
    }

    public static j a(Context context) {
        n.i(context);
        synchronized (j.class) {
            if (f2242c == null) {
                b0.d(context);
                f2242c = new j(context);
            }
        }
        return f2242c;
    }

    @Nullable
    static final x d(PackageInfo packageInfo, x... xVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        y yVar = new y(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < xVarArr.length; i++) {
            if (xVarArr[i].equals(yVar)) {
                return xVarArr[i];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z) {
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if ((z ? d(packageInfo, a0.f2040a) : d(packageInfo, a0.f2040a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final l0 f(String str, boolean z, boolean z2) {
        l0 l0Var;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return l0.c(str2);
        }
        if (str.equals(this.f2244b)) {
            return l0.b();
        }
        if (b0.e()) {
            l0Var = b0.b(str, i.d(this.f2243a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f2243a.getPackageManager().getPackageInfo(str, 64);
                boolean d2 = i.d(this.f2243a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        y yVar = new y(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        l0 a2 = b0.a(str3, yVar, d2, false);
                        if (!a2.f2247a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !b0.a(str3, yVar, false, true).f2247a) {
                            l0Var = a2;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                }
                l0Var = l0.c(str2);
            } catch (PackageManager.NameNotFoundException e2) {
                return l0.d("no pkg ".concat(str), e2);
            }
        }
        if (l0Var.f2247a) {
            this.f2244b = str;
        }
        return l0Var;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (i.d(this.f2243a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i) {
        l0 l0Var;
        int length;
        String[] packagesForUid = this.f2243a.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            l0Var = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    n.i(l0Var);
                    break;
                }
                l0Var = f(packagesForUid[i2], false, false);
                if (l0Var.f2247a) {
                    break;
                }
                i2++;
            }
        } else {
            l0Var = l0.c("no pkgs");
        }
        l0Var.e();
        return l0Var.f2247a;
    }
}
