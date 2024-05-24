package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.r0;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.util.a;
import com.google.android.gms.common.util.i;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

final class b0 {

    /* renamed from: a  reason: collision with root package name */
    static final z f2151a = new v(x.k("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: b  reason: collision with root package name */
    static final z f2152b = new w(x.k("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: c  reason: collision with root package name */
    private static volatile s0 f2153c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2154d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static Context f2155e;

    static {
        new t(x.k("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
        new u(x.k("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    }

    static l0 a(String str, x xVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, xVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static l0 b(String str, boolean z, boolean z2, boolean z3) {
        return g(str, z, false, false, true);
    }

    static /* synthetic */ String c(boolean z, String str, x xVar) {
        String str2 = true != (!z && f(str, xVar, true, false).f2247a) ? "not allowed" : "debug cert rejected";
        MessageDigest b2 = a.b("SHA-256");
        n.i(b2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, i.a(b2.digest(xVar.b0())), Boolean.valueOf(z), "12451000.false"});
    }

    static synchronized void d(Context context) {
        synchronized (b0.class) {
            if (f2155e != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f2155e = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    static boolean e() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            h();
            boolean g = f2153c.g();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return g;
        } catch (RemoteException | DynamiteModule.a e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    private static l0 f(String str, x xVar, boolean z, boolean z2) {
        try {
            h();
            n.i(f2155e);
            try {
                return f2153c.E(new g0(str, xVar, z, z2), b.b0(f2155e.getPackageManager())) ? l0.b() : new j0(new s(z, str, xVar), (i0) null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return l0.d("module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return l0.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [c.d.a.b.d.a, android.os.IBinder] */
    private static l0 g(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        l0 l0Var;
        String concat;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            n.i(f2155e);
            try {
                h();
                c0 c0Var = new c0(str, z, false, b.b0(f2155e), false);
                e0 K = z4 ? f2153c.K(c0Var) : f2153c.o(c0Var);
                if (K.i()) {
                    l0Var = l0.f(K.j());
                } else {
                    String g = K.g();
                    PackageManager.NameNotFoundException nameNotFoundException = K.k() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (g == null) {
                        g = "error checking package certificate";
                    }
                    l0Var = l0.g(K.j(), K.k(), g, nameNotFoundException);
                }
            } catch (DynamiteModule.a e2) {
                e = e2;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                concat = "module init: ".concat(String.valueOf(e.getMessage()));
                l0Var = l0.d(concat, e);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return l0Var;
            }
        } catch (RemoteException e3) {
            e = e3;
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            concat = "module call";
            l0Var = l0.d(concat, e);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return l0Var;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return l0Var;
    }

    private static void h() {
        if (f2153c == null) {
            n.i(f2155e);
            synchronized (f2154d) {
                if (f2153c == null) {
                    f2153c = r0.i(DynamiteModule.d(f2155e, DynamiteModule.f2281c, "com.google.android.gms.googlecertificates").c("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
