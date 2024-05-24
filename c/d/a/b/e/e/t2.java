package c.d.a.b.e.e;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.a.a;
import com.google.android.gms.measurement.internal.l7;
import com.google.android.gms.measurement.internal.q4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class t2 {
    private static volatile t2 h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1746a;

    /* renamed from: b  reason: collision with root package name */
    protected final d f1747b;

    /* renamed from: c  reason: collision with root package name */
    protected final ExecutorService f1748c;

    /* renamed from: d  reason: collision with root package name */
    private final a f1749d;

    /* renamed from: e  reason: collision with root package name */
    private int f1750e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f1751f;
    /* access modifiers changed from: private */
    public volatile f1 g;

    protected t2(Context context, String str, String str2, String str3, Bundle bundle) {
        this.f1746a = (str == null || !l(str2, str3)) ? "FA" : str;
        this.f1747b = g.d();
        z0.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new e2(this));
        boolean z = true;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f1748c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f1749d = new a(this);
        new ArrayList();
        try {
            if (l7.b(context, "google_app_id", q4.a(context)) != null && !h()) {
                this.f1751f = true;
                Log.w(this.f1746a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!l(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 != null ? false : z)) {
                    Log.w(this.f1746a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f1746a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        k(new t1(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f1746a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new s2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void i(Exception exc, boolean z, boolean z2) {
        this.f1751f |= z;
        if (z) {
            Log.w(this.f1746a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.f1746a, "Error with data collection. Data lost.", exc);
    }

    private final void j(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        k(new h2(this, l, str, str2, bundle, z, z2));
    }

    /* access modifiers changed from: private */
    public final void k(j2 j2Var) {
        this.f1748c.execute(j2Var);
    }

    /* access modifiers changed from: private */
    public final boolean l(String str, String str2) {
        return (str2 == null || str == null || h()) ? false : true;
    }

    public static t2 r(Context context, String str, String str2, String str3, Bundle bundle) {
        n.i(context);
        if (h == null) {
            synchronized (t2.class) {
                if (h == null) {
                    h = new t2(context, str, str2, str3, bundle);
                }
            }
        }
        return h;
    }

    public final void C(String str) {
        k(new u1(this, str));
    }

    public final void D(String str, String str2, Bundle bundle) {
        k(new q1(this, str, str2, bundle));
    }

    public final void E(String str) {
        k(new v1(this, str));
    }

    public final void F(String str, String str2, Bundle bundle) {
        j(str, str2, bundle, true, true, (Long) null);
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        k(new d2(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final void b(Bundle bundle) {
        k(new p1(this, bundle));
    }

    public final void c(Activity activity, String str, String str2) {
        k(new s1(this, activity, str, str2));
    }

    public final void d(boolean z) {
        k(new g2(this, z));
    }

    public final void e(String str, String str2, Object obj, boolean z) {
        k(new i2(this, str, str2, obj, z));
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int m(String str) {
        b1 b1Var = new b1();
        k(new f2(this, str, b1Var));
        Integer num = (Integer) b1.c0(b1Var.i(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long n() {
        b1 b1Var = new b1();
        k(new z1(this, b1Var));
        Long k = b1Var.k(500);
        if (k != null) {
            return k.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f1747b.a()).nextLong();
        int i = this.f1750e + 1;
        this.f1750e = i;
        return nextLong + ((long) i);
    }

    public final a o() {
        return this.f1749d;
    }

    /* access modifiers changed from: protected */
    public final f1 q(Context context, boolean z) {
        try {
            return e1.asInterface(DynamiteModule.d(context, DynamiteModule.f2280b, ModuleDescriptor.MODULE_ID).c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e2) {
            i(e2, true, false);
            return null;
        }
    }

    public final String t() {
        b1 b1Var = new b1();
        k(new y1(this, b1Var));
        return b1Var.b0(50);
    }

    public final String u() {
        b1 b1Var = new b1();
        k(new b2(this, b1Var));
        return b1Var.b0(500);
    }

    public final String v() {
        b1 b1Var = new b1();
        k(new a2(this, b1Var));
        return b1Var.b0(500);
    }

    public final String w() {
        b1 b1Var = new b1();
        k(new x1(this, b1Var));
        return b1Var.b0(500);
    }

    public final List x(String str, String str2) {
        b1 b1Var = new b1();
        k(new r1(this, str, str2, b1Var));
        List list = (List) b1.c0(b1Var.i(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map y(String str, String str2, boolean z) {
        b1 b1Var = new b1();
        k(new c2(this, str, str2, z, b1Var));
        Bundle i = b1Var.i(5000);
        if (i == null || i.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(i.size());
        for (String str3 : i.keySet()) {
            Object obj = i.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }
}
