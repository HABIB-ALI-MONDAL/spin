package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import c.d.a.b.e.e.i1;
import com.google.android.gms.common.f;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.e;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class la extends s5 {
    private static final String[] g = {"firebase_", "google_", "ga_"};
    private static final String[] h = {"_err"};

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f2455c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f2456d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private int f2457e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f2458f = null;

    la(x4 x4Var) {
        super(x4Var);
    }

    static boolean W(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean X(String str) {
        n.e(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r4 = r1.getReceiverInfo(new android.content.ComponentName(r4, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean Y(android.content.Context r4) {
        /*
            com.google.android.gms.common.internal.n.i(r4)
            r0 = 0
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001e }
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x001e }
            java.lang.String r3 = "com.google.android.gms.measurement.AppMeasurementReceiver"
            r2.<init>(r4, r3)     // Catch:{ NameNotFoundException -> 0x001e }
            android.content.pm.ActivityInfo r4 = r1.getReceiverInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x001e }
            if (r4 == 0) goto L_0x001e
            boolean r4 = r4.enabled     // Catch:{ NameNotFoundException -> 0x001e }
            if (r4 == 0) goto L_0x001e
            r4 = 1
            return r4
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.la.Y(android.content.Context):boolean");
    }

    static boolean Z(Context context, boolean z) {
        n.i(context);
        return i0(context, Build.VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean a0(String str) {
        return !h[0].equals(str);
    }

    static final boolean d0(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static final boolean e0(String str) {
        n.i(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int f0(String str) {
        if ("_ldl".equals(str)) {
            this.f2527a.z();
            return 2048;
        } else if ("_id".equals(str)) {
            this.f2527a.z();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.f2527a.z();
            return 100;
        } else {
            this.f2527a.z();
            return 36;
        }
    }

    private final Object g0(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0 : 1);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return r(obj.toString(), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle u0 = u0((Bundle) parcelable);
                    if (!u0.isEmpty()) {
                        arrayList.add(u0);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private static boolean h0(String str, String[] strArr) {
        n.i(strArr);
        for (String a2 : strArr) {
            if (ia.a(str, a2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r3 = r1.getServiceInfo(new android.content.ComponentName(r3, r4), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean i0(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0019 }
            r2.<init>(r3, r4)     // Catch:{ NameNotFoundException -> 0x0019 }
            android.content.pm.ServiceInfo r3 = r1.getServiceInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.enabled     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r3 == 0) goto L_0x0019
            r3 = 1
            return r3
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.la.i0(android.content.Context, java.lang.String):boolean");
    }

    static long q0(byte[] bArr) {
        n.i(bArr);
        int length = bArr.length;
        int i = 0;
        n.l(length > 0);
        int i2 = length - 1;
        long j = 0;
        while (i2 >= 0 && i2 >= bArr.length - 8) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
            i2--;
        }
        return j;
    }

    static MessageDigest t() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList v(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", dVar.j);
            bundle.putString("origin", dVar.k);
            bundle.putLong("creation_timestamp", dVar.m);
            bundle.putString("name", dVar.l.k);
            Object g2 = dVar.l.g();
            n.i(g2);
            u5.b(bundle, g2);
            bundle.putBoolean("active", dVar.n);
            String str = dVar.o;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            x xVar = dVar.p;
            if (xVar != null) {
                bundle.putString("timed_out_event_name", xVar.j);
                v vVar = xVar.k;
                if (vVar != null) {
                    bundle.putBundle("timed_out_event_params", vVar.j());
                }
            }
            bundle.putLong("trigger_timeout", dVar.q);
            x xVar2 = dVar.r;
            if (xVar2 != null) {
                bundle.putString("triggered_event_name", xVar2.j);
                v vVar2 = xVar2.k;
                if (vVar2 != null) {
                    bundle.putBundle("triggered_event_params", vVar2.j());
                }
            }
            bundle.putLong("triggered_timestamp", dVar.l.l);
            bundle.putLong("time_to_live", dVar.s);
            x xVar3 = dVar.t;
            if (xVar3 != null) {
                bundle.putString("expired_event_name", xVar3.j);
                v vVar3 = xVar3.k;
                if (vVar3 != null) {
                    bundle.putBundle("expired_event_params", vVar3.j());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void y(m7 m7Var, Bundle bundle, boolean z) {
        if (!(bundle == null || m7Var == null)) {
            if (!bundle.containsKey("_sc") || z) {
                String str = m7Var.f2466a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = m7Var.f2467b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", m7Var.f2468c);
                return;
            }
            z = false;
        }
        if (bundle != null && m7Var == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* access modifiers changed from: package-private */
    public final void A(n3 n3Var, int i) {
        int i2 = 0;
        for (String str : new TreeSet(n3Var.f2483d.keySet())) {
            if (X(str) && (i2 = i2 + 1) > i) {
                this.f2527a.f().s().c("Event can't contain more than " + i + " params", this.f2527a.D().d(n3Var.f2480a), this.f2527a.D().b(n3Var.f2483d));
                d0(n3Var.f2483d, 5);
                n3Var.f2483d.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(ka kaVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        d0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        kaVar.a(str, "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final void C(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                this.f2527a.f().x().c("Not putting event parameter. Invalid value type. name, type", this.f2527a.D().e(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void D(i1 i1Var, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void E(i1 i1Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning bundle list to wrapper", e2);
        }
    }

    public final void F(i1 i1Var, Bundle bundle) {
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void G(i1 i1Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning byte array to wrapper", e2);
        }
    }

    public final void H(i1 i1Var, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning int value to wrapper", e2);
        }
    }

    public final void I(i1 i1Var, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning long value to wrapper", e2);
        }
    }

    public final void J(i1 i1Var, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2527a.f().w().b("Error returning string value to wrapper", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            this.f2527a.z();
            int i3 = 0;
            for (String str6 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str6)) {
                    int m0 = !z ? m0(str6) : 0;
                    if (m0 == 0) {
                        m0 = l0(str6);
                    }
                    i = m0;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    x(bundle, i, str6, str6, i == 3 ? str6 : null);
                    bundle2.remove(str6);
                } else {
                    if (U(bundle2.get(str6))) {
                        this.f2527a.f().x().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        str4 = str6;
                        i2 = 22;
                    } else {
                        String str7 = str3;
                        str4 = str6;
                        i2 = O(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        x(bundle, i2, str4, str4, bundle2.get(str4));
                    } else if (X(str4) && !h0(str4, w5.f2605d) && (i3 = i3 + 1) > 0) {
                        this.f2527a.f().s().c("Item cannot contain custom parameters", this.f2527a.D().d(str5), this.f2527a.D().b(bundle2));
                        d0(bundle2, 23);
                    }
                    bundle2.remove(str4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean L(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (e0(str)) {
                return true;
            }
            if (this.f2527a.q()) {
                this.f2527a.f().s().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", m3.z(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.f2527a.q()) {
                this.f2527a.f().s().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (e0(str2)) {
            return true;
        } else {
            this.f2527a.f().s().b("Invalid admob_app_id. Analytics disabled.", m3.z(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str, int i, String str2) {
        if (str2 == null) {
            this.f2527a.f().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            this.f2527a.f().s().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f2527a.f().s().b("Name is required and can't be null. Type", str);
            return false;
        }
        n.i(str2);
        String[] strArr3 = g;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.f2527a.f().s().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !h0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && h0(str2, strArr2)) {
            return true;
        }
        this.f2527a.f().s().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int O(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r7 = r13
            r8 = r16
            r0 = r17
            r1 = r18
            r13.h()
            boolean r2 = r13.U(r0)
            java.lang.String r3 = "param"
            r4 = 17
            r5 = 0
            if (r2 == 0) goto L_0x00ad
            if (r21 == 0) goto L_0x00aa
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.w5.f2604c
            boolean r2 = h0(r8, r2)
            if (r2 != 0) goto L_0x0022
            r0 = 20
            return r0
        L_0x0022:
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            com.google.android.gms.measurement.internal.u8 r2 = r2.L()
            r2.h()
            r2.i()
            boolean r6 = r2.B()
            if (r6 != 0) goto L_0x0035
            goto L_0x0047
        L_0x0035:
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.la r2 = r2.N()
            int r2 = r2.o0()
            r6 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r6) goto L_0x0047
            r0 = 25
            return r0
        L_0x0047:
            com.google.android.gms.measurement.internal.x4 r2 = r7.f2527a
            r2.z()
            boolean r2 = r0 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x0055
            r6 = r0
            android.os.Parcelable[] r6 = (android.os.Parcelable[]) r6
            int r6 = r6.length
            goto L_0x0060
        L_0x0055:
            boolean r6 = r0 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x00ad
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
        L_0x0060:
            r9 = 200(0xc8, float:2.8E-43)
            if (r6 <= r9) goto L_0x00ad
            com.google.android.gms.measurement.internal.x4 r10 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r10 = r10.f()
            com.google.android.gms.measurement.internal.k3 r10 = r10.x()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r10.d(r11, r3, r8, r6)
            com.google.android.gms.measurement.internal.x4 r6 = r7.f2527a
            r6.z()
            if (r2 == 0) goto L_0x008e
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r9) goto L_0x00a7
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r9)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x00a7
        L_0x008e:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x00a7
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r9) goto L_0x00a7
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r5, r9)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x00a7:
            r9 = 17
            goto L_0x00ae
        L_0x00aa:
            r0 = 21
            return r0
        L_0x00ad:
            r9 = 0
        L_0x00ae:
            boolean r1 = W(r15)
            if (r1 != 0) goto L_0x00c3
            boolean r1 = W(r16)
            if (r1 == 0) goto L_0x00bb
            goto L_0x00c3
        L_0x00bb:
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.z()
            r1 = 100
            goto L_0x00ca
        L_0x00c3:
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            r1.z()
            r1 = 256(0x100, float:3.59E-43)
        L_0x00ca:
            boolean r1 = r13.P(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00d1
            return r9
        L_0x00d1:
            if (r21 == 0) goto L_0x015e
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e8
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.K(r1, r2, r3, r4, r5, r6)
            goto L_0x015d
        L_0x00e8:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x011f
            r10 = r0
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10
            int r11 = r10.length
            r12 = 0
        L_0x00f1:
            if (r12 >= r11) goto L_0x015d
            r0 = r10[r12]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x010d
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.x()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
        L_0x0109:
            r1.c(r2, r0, r8)
            goto L_0x015e
        L_0x010d:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.K(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x00f1
        L_0x011f:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x015e
            r10 = r0
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r11 = r10.size()
            r12 = 0
        L_0x012b:
            if (r12 >= r11) goto L_0x015d
            java.lang.Object r0 = r10.get(r12)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x014b
            com.google.android.gms.measurement.internal.x4 r1 = r7.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.x()
            if (r0 == 0) goto L_0x0146
            java.lang.Class r0 = r0.getClass()
            goto L_0x0148
        L_0x0146:
            java.lang.String r0 = "null"
        L_0x0148:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            goto L_0x0109
        L_0x014b:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.K(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x012b
        L_0x015d:
            return r9
        L_0x015e:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.la.O(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: package-private */
    public final boolean P(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.f2527a.f().x().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean Q(String str, String str2) {
        if (str2 == null) {
            this.f2527a.f().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f2527a.f().s().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.f2527a.f().s().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f2527a.f().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean R(String str, String str2) {
        if (str2 == null) {
            this.f2527a.f().s().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f2527a.f().s().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.f2527a.f().s().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f2527a.f().s().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean S(String str) {
        h();
        if (c.a(this.f2527a.d()).a(str) == 0) {
            return true;
        }
        this.f2527a.f().q().b("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean T(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String u = this.f2527a.z().u();
        this.f2527a.e();
        return u.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean U(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean V(Context context, String str) {
        k3 k3Var;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e2 = c.a(context).e(str, 64);
            if (e2 == null || (signatureArr = e2.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e3) {
            e = e3;
            k3Var = this.f2527a.f().r();
            str2 = "Error obtaining certificate";
            k3Var.b(str2, e);
            return true;
        } catch (PackageManager.NameNotFoundException e4) {
            e = e4;
            k3Var = this.f2527a.f().r();
            str2 = "Package name not found";
            k3Var.b(str2, e);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            n.i(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] c0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.f2527a.f().w().a("Utils falling back to Random for random id");
            }
        }
        this.f2456d.set(nextLong);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int j0(String str, Object obj) {
        String str2;
        int i;
        if ("_ldl".equals(str)) {
            i = f0(str);
            str2 = "user property referrer";
        } else {
            i = f0(str);
            str2 = "user property";
        }
        return P(str2, str, i, obj) ? 0 : 7;
    }

    /* access modifiers changed from: package-private */
    public final int k0(String str) {
        if (!Q("event", str)) {
            return 2;
        }
        if (!N("event", v5.f2587a, v5.f2588b, str)) {
            return 13;
        }
        this.f2527a.z();
        return !M("event", 40, str) ? 2 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int l0(String str) {
        if (!Q("event param", str)) {
            return 3;
        }
        if (!N("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f2527a.z();
        return !M("event param", 40, str) ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int m0(String str) {
        if (!R("event param", str)) {
            return 3;
        }
        if (!N("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f2527a.z();
        return !M("event param", 40, str) ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int n0(String str) {
        if (!Q("user property", str)) {
            return 6;
        }
        if (!N("user property", x5.f2632a, (String[]) null, str)) {
            return 15;
        }
        this.f2527a.z();
        return !M("user property", 24, str) ? 6 : 0;
    }

    /* access modifiers changed from: package-private */
    public final Object o(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.f2527a.z();
            return g0(256, obj, true, true);
        }
        if (W(str)) {
            this.f2527a.z();
        } else {
            this.f2527a.z();
            i = 100;
        }
        return g0(i, obj, false, true);
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int o0() {
        if (this.f2458f == null) {
            this.f2458f = Integer.valueOf(f.f().a(this.f2527a.d()) / 1000);
        }
        return this.f2458f.intValue();
    }

    /* access modifiers changed from: package-private */
    public final Object p(String str, Object obj) {
        boolean equals = "_ldl".equals(str);
        int f0 = f0(str);
        return equals ? g0(f0, obj, true, false) : g0(f0, obj, false, false);
    }

    public final int p0(int i) {
        return f.f().h(this.f2527a.d(), i.f2162a);
    }

    /* access modifiers changed from: package-private */
    public final String q() {
        byte[] bArr = new byte[16];
        u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String r(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public final long r0() {
        int i = (this.f2456d.get() > 0 ? 1 : (this.f2456d.get() == 0 ? 0 : -1));
        synchronized (this.f2456d) {
            if (i == 0) {
                long nextLong = new Random(System.nanoTime() ^ this.f2527a.a().a()).nextLong();
                int i2 = this.f2457e + 1;
                this.f2457e = i2;
                long j = nextLong + ((long) i2);
                return j;
            }
            this.f2456d.compareAndSet(-1, 1);
            long andIncrement = this.f2456d.getAndIncrement();
            return andIncrement;
        }
    }

    public final URL s(long j, String str, String str2, long j2) {
        try {
            n.e(str2);
            n.e(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{74029L, Integer.valueOf(o0())}), str2, str, Long.valueOf(j2)});
            if (str.equals(this.f2527a.z().v())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            this.f2527a.f().r().b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final long s0(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final Bundle t0(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str7 = uri.getQueryParameter("utm_campaign");
                    str6 = uri.getQueryParameter("utm_source");
                    str5 = uri.getQueryParameter("utm_medium");
                    str4 = uri.getQueryParameter("gclid");
                    str3 = uri.getQueryParameter("utm_id");
                    str2 = uri.getQueryParameter("dclid");
                    str = uri.getQueryParameter("srsltid");
                } else {
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("campaign", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("source", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("medium", str5);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("term", queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("content", queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("aclid", queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("cp1", queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("campaign_id", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("dclid", str2);
                }
                String queryParameter6 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("source_platform", queryParameter6);
                }
                String queryParameter7 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("creative_format", queryParameter7);
                }
                String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("marketing_tactic", queryParameter8);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("srsltid", str);
                }
                return bundle;
            } catch (UnsupportedOperationException e2) {
                this.f2527a.f().w().b("Install referrer url isn't a hierarchical URI", e2);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom u() {
        h();
        if (this.f2455c == null) {
            this.f2455c = new SecureRandom();
        }
        return this.f2455c;
    }

    /* access modifiers changed from: package-private */
    public final Bundle u0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object o = o(str, bundle.get(str));
                if (o == null) {
                    this.f2527a.f().x().b("Param value can't be null", this.f2527a.D().e(str));
                } else {
                    C(bundle2, str, o);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle v0(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            r20 = this;
            r9 = r20
            r10 = r22
            r11 = r23
            r12 = r24
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.v5.f2590d
            boolean r13 = h0(r10, r0)
            if (r11 == 0) goto L_0x010b
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.x4 r0 = r9.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            int r8 = r0.m()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r23.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = 0
        L_0x0030:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0109
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0048
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = 0
            goto L_0x0057
        L_0x0048:
            if (r25 != 0) goto L_0x004f
            int r0 = r9.m0(r7)
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 != 0) goto L_0x0056
            int r0 = r9.l0(r7)
        L_0x0056:
            r2 = r0
        L_0x0057:
            if (r2 == 0) goto L_0x006d
            r0 = 3
            if (r2 != r0) goto L_0x005e
            r5 = r7
            goto L_0x005f
        L_0x005e:
            r5 = 0
        L_0x005f:
            r0 = r20
            r1 = r15
            r3 = r7
            r4 = r7
            r0.x(r1, r2, r3, r4, r5)
            r15.remove(r7)
            r14 = r8
            goto L_0x0106
        L_0x006d:
            java.lang.Object r4 = r11.get(r7)
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r7
            r5 = r15
            r6 = r24
            r19 = r7
            r7 = r25
            r14 = r8
            r8 = r13
            int r2 = r0.O(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r2 != r0) goto L_0x0098
            r2 = 17
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r0 = r20
            r1 = r15
            r3 = r19
            r4 = r19
            r0.x(r1, r2, r3, r4, r5)
            goto L_0x00ba
        L_0x0098:
            if (r2 == 0) goto L_0x00ba
            java.lang.String r0 = "_ev"
            r6 = r19
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00bc
            r0 = 21
            if (r2 != r0) goto L_0x00aa
            r3 = r10
            goto L_0x00ab
        L_0x00aa:
            r3 = r6
        L_0x00ab:
            java.lang.Object r5 = r11.get(r6)
            r0 = r20
            r1 = r15
            r4 = r6
            r0.x(r1, r2, r3, r4, r5)
            r15.remove(r6)
            goto L_0x0106
        L_0x00ba:
            r6 = r19
        L_0x00bc:
            boolean r0 = X(r6)
            if (r0 == 0) goto L_0x0106
            int r0 = r18 + 1
            if (r0 <= r14) goto L_0x0104
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Event can't contain more than "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " params"
            r1.append(r2)
            com.google.android.gms.measurement.internal.x4 r2 = r9.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.s()
            java.lang.String r1 = r1.toString()
            com.google.android.gms.measurement.internal.x4 r3 = r9.f2527a
            com.google.android.gms.measurement.internal.h3 r3 = r3.D()
            java.lang.String r3 = r3.d(r10)
            com.google.android.gms.measurement.internal.x4 r4 = r9.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.b(r11)
            r2.c(r1, r3, r4)
            r1 = 5
            d0(r15, r1)
            r15.remove(r6)
        L_0x0104:
            r18 = r0
        L_0x0106:
            r8 = r14
            goto L_0x0030
        L_0x0109:
            r14 = r15
            goto L_0x010c
        L_0x010b:
            r14 = 0
        L_0x010c:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.la.v0(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final void w(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.f2527a.f().w().b("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    /* access modifiers changed from: package-private */
    public final x w0(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (k0(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle v0 = v0(str, str2, bundle3, e.b("_o"), true);
            if (z) {
                v0 = u0(v0);
            }
            n.i(v0);
            return new x(str2, new v(v0), str3, j);
        }
        this.f2527a.f().r().b("Invalid conditional property event name", this.f2527a.D().f(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final void x(Bundle bundle, int i, String str, String str2, Object obj) {
        if (d0(bundle, i)) {
            this.f2527a.z();
            bundle.putString("_ev", r(str, 40, true));
            if (obj != null) {
                n.i(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void z(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.f2527a.N().C(bundle, str, bundle2.get(str));
                }
            }
        }
    }
}
