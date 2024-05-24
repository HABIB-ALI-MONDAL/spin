package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.n;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class m3 extends s5 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public char f2462c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f2463d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f2464e;

    /* renamed from: f  reason: collision with root package name */
    private final k3 f2465f = new k3(this, 6, false, false);
    private final k3 g = new k3(this, 6, true, false);
    private final k3 h = new k3(this, 6, false, true);
    private final k3 i = new k3(this, 5, false, false);
    private final k3 j = new k3(this, 5, true, false);
    private final k3 k = new k3(this, 5, false, true);
    private final k3 l = new k3(this, 4, false, false);
    private final k3 m = new k3(this, 3, false, false);
    private final k3 n = new k3(this, 2, false, false);

    m3(x4 x4Var) {
        super(x4Var);
    }

    static String A(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String B = B(z, obj);
        String B2 = B(z, obj2);
        String B3 = B(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(B)) {
            sb.append(str2);
            sb.append(B);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(B2)) {
            sb.append(str2);
            sb.append(B2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(B3)) {
            sb.append(str3);
            sb.append(B3);
        }
        return sb.toString();
    }

    static String B(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return obj.toString();
            }
            if (obj.toString().charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            return str + round + "..." + str + round2;
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof l3 ? ((l3) obj).f2446a : z ? "-" : obj.toString();
            }
            Throwable th = (Throwable) obj;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String G = G(x4.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && G(className).equals(G)) {
                    sb.append(": ");
                    sb.append(stackTraceElement);
                    break;
                }
                i2++;
            }
            return sb.toString();
        }
    }

    private static String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    protected static Object z(String str) {
        if (str == null) {
            return null;
        }
        return new l3(str);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String C() {
        String str;
        synchronized (this) {
            if (this.f2464e == null) {
                this.f2464e = this.f2527a.Q() != null ? this.f2527a.Q() : this.f2527a.z().w();
            }
            n.i(this.f2464e);
            str = this.f2464e;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void F(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(C(), i2)) {
            Log.println(i2, C(), A(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            n.i(str);
            u4 G = this.f2527a.G();
            if (G == null) {
                Log.println(6, C(), "Scheduler not set. Not logging error/warn");
            } else if (!G.n()) {
                Log.println(6, C(), "Scheduler not initialized. Not logging error/warn");
            } else {
                G.z(new j3(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return false;
    }

    public final k3 q() {
        return this.m;
    }

    public final k3 r() {
        return this.f2465f;
    }

    public final k3 s() {
        return this.h;
    }

    public final k3 t() {
        return this.g;
    }

    public final k3 u() {
        return this.l;
    }

    public final k3 v() {
        return this.n;
    }

    public final k3 w() {
        return this.i;
    }

    public final k3 x() {
        return this.k;
    }

    public final k3 y() {
        return this.j;
    }
}
