package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b.c.a;
import c.d.a.b.e.e.a5;
import c.d.a.b.e.e.f4;
import c.d.a.b.e.e.g4;
import c.d.a.b.e.e.gc;
import c.d.a.b.e.e.j4;
import c.d.a.b.e.e.k4;
import c.d.a.b.e.e.ld;
import c.d.a.b.e.e.n1;
import c.d.a.b.e.e.q4;
import c.d.a.b.e.e.s3;
import c.d.a.b.e.e.sd;
import c.d.a.b.e.e.z4;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class ca implements t5 {
    private static volatile ca F;
    private final Map A;
    private final Map B;
    private m7 C;
    private String D;
    private final ka E = new x9(this);

    /* renamed from: a  reason: collision with root package name */
    private final p4 f2342a;

    /* renamed from: b  reason: collision with root package name */
    private final s3 f2343b;

    /* renamed from: c  reason: collision with root package name */
    private n f2344c;

    /* renamed from: d  reason: collision with root package name */
    private u3 f2345d;

    /* renamed from: e  reason: collision with root package name */
    private o9 f2346e;

    /* renamed from: f  reason: collision with root package name */
    private b f2347f;
    private final ea g;
    private k7 h;
    private w8 i;
    private final r9 j;
    private e4 k;
    /* access modifiers changed from: private */
    public final x4 l;
    private boolean m = false;
    private boolean n;
    long o;
    private List p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private FileLock v;
    private FileChannel w;
    private List x;
    private List y;
    private long z;

    ca(da daVar, x4 x4Var) {
        n.i(daVar);
        this.l = x4.H(daVar.f2360a, (n1) null, (Long) null);
        this.z = -1;
        this.j = new r9(this);
        ea eaVar = new ea(this);
        eaVar.j();
        this.g = eaVar;
        s3 s3Var = new s3(this);
        s3Var.j();
        this.f2343b = s3Var;
        p4 p4Var = new p4(this);
        p4Var.j();
        this.f2342a = p4Var;
        this.A = new HashMap();
        this.B = new HashMap();
        c().z(new s9(this, daVar));
    }

    static final void G(f4 f4Var, int i2, String str) {
        List H = f4Var.H();
        int i3 = 0;
        while (i3 < H.size()) {
            if (!"_err".equals(((k4) H.get(i3)).K())) {
                i3++;
            } else {
                return;
            }
        }
        j4 I = k4.I();
        I.B("_err");
        I.A(Long.valueOf((long) i2).longValue());
        j4 I2 = k4.I();
        I2.B("_ev");
        I2.C(str);
        f4Var.x((k4) I.n());
        f4Var.x((k4) I2.n());
    }

    static final void H(f4 f4Var, String str) {
        List H = f4Var.H();
        for (int i2 = 0; i2 < H.size(); i2++) {
            if (str.equals(((k4) H.get(i2)).K())) {
                f4Var.z(i2);
                return;
            }
        }
    }

    private final qa I(String str) {
        k3 q2;
        String str2;
        Object obj;
        String str3 = str;
        n nVar = this.f2344c;
        R(nVar);
        h6 R = nVar.R(str3);
        if (R == null || TextUtils.isEmpty(R.g0())) {
            q2 = f().q();
            str2 = "No app data available; dropping";
            obj = str3;
        } else {
            Boolean J = J(R);
            if (J == null || J.booleanValue()) {
                String i0 = R.i0();
                String g0 = R.g0();
                long L = R.L();
                String f0 = R.f0();
                long W = R.W();
                long T = R.T();
                boolean J2 = R.J();
                String h0 = R.h0();
                R.A();
                h6 h6Var = R;
                return new qa(str, i0, g0, L, f0, W, T, (String) null, J2, false, h0, 0, 0, 0, h6Var.I(), false, h6Var.b0(), h6Var.a0(), h6Var.U(), h6Var.c(), (String) null, U(str).h(), "", (String) null);
            }
            q2 = f().r();
            str2 = "App version does not match; dropping. appId";
            obj = m3.z(str);
        }
        q2.b(str2, obj);
        return null;
    }

    private final Boolean J(h6 h6Var) {
        Boolean bool = Boolean.TRUE;
        try {
            if (h6Var.L() != -2147483648L) {
                if (h6Var.L() == ((long) c.a(this.l.d()).e(h6Var.d0(), 0).versionCode)) {
                    return bool;
                }
            } else {
                String str = c.a(this.l.d()).e(h6Var.d0(), 0).versionName;
                String g0 = h6Var.g0();
                if (g0 != null && g0.equals(str)) {
                    return bool;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void K() {
        c().h();
        if (this.s || this.t || this.u) {
            f().v().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.s), Boolean.valueOf(this.t), Boolean.valueOf(this.u));
            return;
        }
        f().v().a("Stopping uploading service(s)");
        List<Runnable> list = this.p;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            List list2 = this.p;
            n.i(list2);
            list2.clear();
        }
    }

    private final void L(q4 q4Var, long j2, boolean z2) {
        String str = true != z2 ? "_lte" : "_se";
        n nVar = this.f2344c;
        R(nVar);
        ha X = nVar.X(q4Var.h0(), str);
        ha haVar = (X == null || X.f2408e == null) ? new ha(q4Var.h0(), "auto", str, a().a(), Long.valueOf(j2)) : new ha(q4Var.h0(), "auto", str, a().a(), Long.valueOf(((Long) X.f2408e).longValue() + j2));
        z4 H = a5.H();
        H.x(str);
        H.y(a().a());
        H.w(((Long) haVar.f2408e).longValue());
        a5 a5Var = (a5) H.n();
        int w2 = ea.w(q4Var, str);
        if (w2 >= 0) {
            q4Var.e0(w2, a5Var);
        } else {
            q4Var.w0(a5Var);
        }
        if (j2 > 0) {
            n nVar2 = this.f2344c;
            R(nVar2);
            nVar2.x(haVar);
            f().v().c("Updated engagement user property. scope, value", true != z2 ? "lifetime" : "session-scoped", haVar.f2408e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x021c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void M() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.u4 r1 = r20.c()
            r1.h()
            r20.g()
            long r1 = r0.o
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.d r5 = r20.a()
            long r5 = r5.b()
            long r7 = r0.o
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.m3 r3 = r20.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.v()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.b(r2, r1)
            com.google.android.gms.measurement.internal.u3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.o9 r1 = r0.f2346e
            R(r1)
            r1.m()
            return
        L_0x004c:
            r0.o = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.x4 r1 = r0.l
            boolean r1 = r1.r()
            if (r1 == 0) goto L_0x0239
            boolean r1 = r20.O()
            if (r1 != 0) goto L_0x005e
            goto L_0x0239
        L_0x005e:
            com.google.android.gms.common.util.d r1 = r20.a()
            long r1 = r1.a()
            r20.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.A
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.n r5 = r0.f2344c
            R(r5)
            boolean r5 = r5.t()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.n r5 = r0.f2344c
            R(r5)
            boolean r5 = r5.s()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.h r5 = r20.T()
            java.lang.String r5 = r5.u()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00b1
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00b1
            r20.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.v
            goto L_0x00bc
        L_0x00b1:
            r20.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.u
            goto L_0x00bc
        L_0x00b7:
            r20.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.t
        L_0x00bc:
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            com.google.android.gms.measurement.internal.w8 r5 = r0.i
            com.google.android.gms.measurement.internal.x3 r5 = r5.g
            long r13 = r5.a()
            com.google.android.gms.measurement.internal.w8 r5 = r0.i
            com.google.android.gms.measurement.internal.x3 r5 = r5.h
            long r15 = r5.a()
            com.google.android.gms.measurement.internal.n r5 = r0.f2344c
            R(r5)
            r17 = r10
            long r9 = r5.M()
            com.google.android.gms.measurement.internal.n r5 = r0.f2344c
            R(r5)
            r18 = r7
            long r6 = r5.N()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x00fb
        L_0x00f8:
            r7 = r3
            goto L_0x0173
        L_0x00fb:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x0120
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0120
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x0120:
            com.google.android.gms.measurement.internal.ea r13 = r0.g
            R(r13)
            boolean r13 = r13.M(r1, r11)
            if (r13 != 0) goto L_0x012d
            long r7 = r1 + r11
        L_0x012d:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0173
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0173
            r1 = 0
        L_0x0136:
            r20.T()
            r2 = 20
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.C
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r11 = 0
            int r5 = java.lang.Math.max(r11, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x00f8
            r20.T()
            com.google.android.gms.measurement.internal.x2 r2 = com.google.android.gms.measurement.internal.y2.B
            java.lang.Object r2 = r2.a(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            r12 = 1
            long r12 = r12 << r1
            long r5 = r5 * r12
            long r7 = r7 + r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x0173
            int r1 = r1 + 1
            goto L_0x0136
        L_0x0173:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x021c
            com.google.android.gms.measurement.internal.s3 r1 = r0.f2343b
            R(r1)
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.w8 r1 = r0.i
            com.google.android.gms.measurement.internal.x3 r1 = r1.f2608f
            long r1 = r1.a()
            r20.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.r
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.ea r9 = r0.g
            R(r9)
            boolean r9 = r9.M(r1, r5)
            if (r9 != 0) goto L_0x01ae
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01ae:
            com.google.android.gms.measurement.internal.u3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.common.util.d r1 = r20.a()
            long r1 = r1.a()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x01e5
            r20.T()
            com.google.android.gms.measurement.internal.x2 r1 = com.google.android.gms.measurement.internal.y2.w
            r2 = 0
            java.lang.Object r1 = r1.a(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.w8 r1 = r0.i
            com.google.android.gms.measurement.internal.x3 r1 = r1.g
            com.google.android.gms.common.util.d r2 = r20.a()
            long r2 = r2.a()
            r1.b(r2)
        L_0x01e5:
            com.google.android.gms.measurement.internal.m3 r1 = r20.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.b(r3, r2)
            com.google.android.gms.measurement.internal.o9 r1 = r0.f2346e
            R(r1)
            r1.n(r7)
            return
        L_0x01ff:
            com.google.android.gms.measurement.internal.m3 r1 = r20.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.String r2 = "No network"
            r1.a(r2)
            com.google.android.gms.measurement.internal.u3 r1 = r20.Y()
            r1.b()
            com.google.android.gms.measurement.internal.o9 r1 = r0.f2346e
            R(r1)
            r1.m()
            return
        L_0x021c:
            com.google.android.gms.measurement.internal.m3 r1 = r20.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.String r2 = "Next upload time is 0"
            r1.a(r2)
            com.google.android.gms.measurement.internal.u3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.o9 r1 = r0.f2346e
            R(r1)
            r1.m()
            return
        L_0x0239:
            com.google.android.gms.measurement.internal.m3 r1 = r20.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.a(r2)
            com.google.android.gms.measurement.internal.u3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.o9 r1 = r0.f2346e
            R(r1)
            r1.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.M():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0b74, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.h.i() + r8)) goto L_0x0b76;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03a7 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x046b A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04c5 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x081d A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0866 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0886 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x08fd A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x08ff A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0907 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0930 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0b64 A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0beb A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0c07 A[Catch:{ SQLiteException -> 0x0c1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x0c6e A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0c9f A[Catch:{ NumberFormatException -> 0x07e2, all -> 0x0d0b }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01e4=Splitter:B:69:0x01e4, B:420:0x0cf9=Splitter:B:420:0x0cf9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean N(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.n r4 = r1.f2344c
            R(r4)
            r4.e0()
            com.google.android.gms.measurement.internal.z9 r4 = new com.google.android.gms.measurement.internal.z9     // Catch:{ all -> 0x0d0b }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            r6 = 0
            long r9 = r1.z     // Catch:{ all -> 0x0d0b }
            r7 = r45
            r11 = r4
            r5.G(r6, r7, r9, r11)     // Catch:{ all -> 0x0d0b }
            java.util.List r5 = r4.f2658c     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x0cf9
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x002e
            goto L_0x0cf9
        L_0x002e:
            c.d.a.b.e.e.r4 r5 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.p8 r5 = r5.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.q4 r5 = (c.d.a.b.e.e.q4) r5     // Catch:{ all -> 0x0d0b }
            r5.B0()     // Catch:{ all -> 0x0d0b }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.f2658c     // Catch:{ all -> 0x0d0b }
            int r12 = r12.size()     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r2
            r18 = r3
            if (r8 >= r12) goto L_0x0543
            java.util.List r3 = r4.f2658c     // Catch:{ all -> 0x0d0b }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r3 = (c.d.a.b.e.e.g4) r3     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.p8 r3 = r3.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.f4 r3 = (c.d.a.b.e.e.f4) r3     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.p4 r12 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r12)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r2 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r2 = r2.R1()     // Catch:{ all -> 0x0d0b }
            r22 = r9
            java.lang.String r9 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r12.F(r2, r9)     // Catch:{ all -> 0x0d0b }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.m3 r2 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            c.d.a.b.e.e.r4 r7 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r7.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r7)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r12 = r1.l     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h3 r12 = r12.D()     // Catch:{ all -> 0x0d0b }
            java.lang.String r15 = r3.G()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r12.d(r15)     // Catch:{ all -> 0x0d0b }
            r2.c(r6, r7, r12)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.p4 r2 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r6 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r6.R1()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r2.D(r6)     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.p4 r2 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r6 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r6.R1()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r2.G(r6)     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.la r23 = r43.g0()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ka r2 = r1.E     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r6 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r25 = r6.R1()     // Catch:{ all -> 0x0d0b }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r3.G()     // Catch:{ all -> 0x0d0b }
            r29 = 0
            r24 = r2
            r23.B(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0d0b }
        L_0x00e8:
            r7 = r8
            r25 = r10
            r15 = r16
            r9 = r22
            r10 = r5
            r5 = -1
            goto L_0x0538
        L_0x00f3:
            java.lang.String r2 = r3.G()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = com.google.android.gms.measurement.internal.v5.a(r18)     // Catch:{ all -> 0x0d0b }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x016d
            r2 = r18
            r3.A(r2)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r12 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r12 = r12.v()     // Catch:{ all -> 0x0d0b }
            r18 = r2
            java.lang.String r2 = "Renaming ad_impression to _ai"
            r12.a(r2)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r2 = r43.f()     // Catch:{ all -> 0x0d0b }
            java.lang.String r2 = r2.C()     // Catch:{ all -> 0x0d0b }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r12 = r3.s()     // Catch:{ all -> 0x0d0b }
            if (r2 >= r12) goto L_0x016d
            java.lang.String r12 = "ad_platform"
            c.d.a.b.e.e.k4 r23 = r3.F(r2)     // Catch:{ all -> 0x0d0b }
            r24 = r8
            java.lang.String r8 = r23.K()     // Catch:{ all -> 0x0d0b }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x0d0b }
            if (r8 == 0) goto L_0x0168
            c.d.a.b.e.e.k4 r8 = r3.F(r2)     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = r8.L()     // Catch:{ all -> 0x0d0b }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0d0b }
            if (r8 != 0) goto L_0x0168
            java.lang.String r8 = "admob"
            c.d.a.b.e.e.k4 r12 = r3.F(r2)     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r12.L()     // Catch:{ all -> 0x0d0b }
            boolean r8 = r8.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0d0b }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.m3 r8 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r8 = r8.x()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r8.a(r12)     // Catch:{ all -> 0x0d0b }
        L_0x0168:
            int r2 = r2 + 1
            r8 = r24
            goto L_0x0125
        L_0x016d:
            r24 = r8
            com.google.android.gms.measurement.internal.p4 r2 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r8 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = r8.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r2.E(r8, r12)     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = "_c"
            if (r2 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.ea r12 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r12)     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r3.G()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.e(r12)     // Catch:{ all -> 0x0d0b }
            r23 = r11
            int r11 = r12.hashCode()     // Catch:{ all -> 0x0d0b }
            r25 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r11 == r10) goto L_0x01be
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r11 == r10) goto L_0x01b4
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r10) goto L_0x01aa
            goto L_0x01c8
        L_0x01aa:
            java.lang.String r10 = "_ui"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 1
            goto L_0x01c9
        L_0x01b4:
            java.lang.String r10 = "_ug"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 2
            goto L_0x01c9
        L_0x01be:
            java.lang.String r10 = "_in"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 0
            goto L_0x01c9
        L_0x01c8:
            r10 = -1
        L_0x01c9:
            if (r10 == 0) goto L_0x01df
            r11 = 1
            if (r10 == r11) goto L_0x01df
            r11 = 2
            if (r10 == r11) goto L_0x01df
            r27 = r5
            r26 = r7
            r7 = r13
            r19 = r14
            r2 = 0
            goto L_0x03a5
        L_0x01db:
            r25 = r10
            r23 = r11
        L_0x01df:
            r26 = r7
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x01e4:
            int r7 = r3.s()     // Catch:{ all -> 0x0d0b }
            r27 = r5
            java.lang.String r5 = "_r"
            if (r10 >= r7) goto L_0x024b
            c.d.a.b.e.e.k4 r7 = r3.F(r10)     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r7.K()     // Catch:{ all -> 0x0d0b }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0d0b }
            if (r7 == 0) goto L_0x0219
            c.d.a.b.e.e.k4 r5 = r3.F(r10)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.p8 r5 = r5.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r5 = (c.d.a.b.e.e.j4) r5     // Catch:{ all -> 0x0d0b }
            r7 = r13
            r19 = r14
            r13 = 1
            r5.A(r13)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r5 = r5.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r5 = (c.d.a.b.e.e.k4) r5     // Catch:{ all -> 0x0d0b }
            r3.C(r10, r5)     // Catch:{ all -> 0x0d0b }
            r11 = 1
            goto L_0x0243
        L_0x0219:
            r7 = r13
            r19 = r14
            c.d.a.b.e.e.k4 r13 = r3.F(r10)     // Catch:{ all -> 0x0d0b }
            java.lang.String r13 = r13.K()     // Catch:{ all -> 0x0d0b }
            boolean r5 = r5.equals(r13)     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x0243
            c.d.a.b.e.e.k4 r5 = r3.F(r10)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.p8 r5 = r5.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r5 = (c.d.a.b.e.e.j4) r5     // Catch:{ all -> 0x0d0b }
            r12 = 1
            r5.A(r12)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r5 = r5.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r5 = (c.d.a.b.e.e.k4) r5     // Catch:{ all -> 0x0d0b }
            r3.C(r10, r5)     // Catch:{ all -> 0x0d0b }
            r12 = 1
        L_0x0243:
            int r10 = r10 + 1
            r13 = r7
            r14 = r19
            r5 = r27
            goto L_0x01e4
        L_0x024b:
            r7 = r13
            r19 = r14
            if (r11 != 0) goto L_0x027c
            if (r2 == 0) goto L_0x027c
            com.google.android.gms.measurement.internal.m3 r10 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r10 = r10.v()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.x4 r13 = r1.l     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h3 r13 = r13.D()     // Catch:{ all -> 0x0d0b }
            java.lang.String r14 = r3.G()     // Catch:{ all -> 0x0d0b }
            java.lang.String r13 = r13.d(r14)     // Catch:{ all -> 0x0d0b }
            r10.b(r11, r13)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r10 = c.d.a.b.e.e.k4.I()     // Catch:{ all -> 0x0d0b }
            r10.B(r8)     // Catch:{ all -> 0x0d0b }
            r13 = 1
            r10.A(r13)     // Catch:{ all -> 0x0d0b }
            r3.w(r10)     // Catch:{ all -> 0x0d0b }
        L_0x027c:
            if (r12 != 0) goto L_0x02a8
            com.google.android.gms.measurement.internal.m3 r10 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r10 = r10.v()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.x4 r12 = r1.l     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h3 r12 = r12.D()     // Catch:{ all -> 0x0d0b }
            java.lang.String r13 = r3.G()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r12.d(r13)     // Catch:{ all -> 0x0d0b }
            r10.b(r11, r12)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r10 = c.d.a.b.e.e.k4.I()     // Catch:{ all -> 0x0d0b }
            r10.B(r5)     // Catch:{ all -> 0x0d0b }
            r11 = 1
            r10.A(r11)     // Catch:{ all -> 0x0d0b }
            r3.w(r10)     // Catch:{ all -> 0x0d0b }
        L_0x02a8:
            com.google.android.gms.measurement.internal.n r10 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r10)     // Catch:{ all -> 0x0d0b }
            long r29 = r43.F()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r11 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r31 = r11.R1()     // Catch:{ all -> 0x0d0b }
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 1
            r28 = r10
            com.google.android.gms.measurement.internal.l r10 = r28.T(r29, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0d0b }
            long r10 = r10.f2442e     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h r12 = r43.T()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r13 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r13 = r13.R1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x2 r14 = com.google.android.gms.measurement.internal.y2.o     // Catch:{ all -> 0x0d0b }
            int r12 = r12.o(r13, r14)     // Catch:{ all -> 0x0d0b }
            long r12 = (long) r12     // Catch:{ all -> 0x0d0b }
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x02e2
            H(r3, r5)     // Catch:{ all -> 0x0d0b }
            goto L_0x02e4
        L_0x02e2:
            r16 = 1
        L_0x02e4:
            java.lang.String r5 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r5 = com.google.android.gms.measurement.internal.la.X(r5)     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x03a5
            if (r2 == 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            long r29 = r43.F()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r10 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r31 = r10.R1()     // Catch:{ all -> 0x0d0b }
            r32 = 0
            r33 = 0
            r34 = 1
            r35 = 0
            r36 = 0
            r28 = r5
            com.google.android.gms.measurement.internal.l r5 = r28.T(r29, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0d0b }
            long r10 = r5.f2440c     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h r5 = r43.T()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r12 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r12.R1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x2 r13 = com.google.android.gms.measurement.internal.y2.n     // Catch:{ all -> 0x0d0b }
            int r5 = r5.o(r12, r13)     // Catch:{ all -> 0x0d0b }
            long r12 = (long) r5     // Catch:{ all -> 0x0d0b }
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.m3 r5 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "Too many conversions. Not logging as conversion. appId"
            c.d.a.b.e.e.r4 r11 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r11.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.m3.z(r11)     // Catch:{ all -> 0x0d0b }
            r5.b(r10, r11)     // Catch:{ all -> 0x0d0b }
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = -1
        L_0x0341:
            int r13 = r3.s()     // Catch:{ all -> 0x0d0b }
            if (r10 >= r13) goto L_0x036b
            c.d.a.b.e.e.k4 r13 = r3.F(r10)     // Catch:{ all -> 0x0d0b }
            java.lang.String r14 = r13.K()     // Catch:{ all -> 0x0d0b }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0d0b }
            if (r14 == 0) goto L_0x035d
            c.d.a.b.e.e.p8 r5 = r13.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r5 = (c.d.a.b.e.e.j4) r5     // Catch:{ all -> 0x0d0b }
            r12 = r10
            goto L_0x0368
        L_0x035d:
            java.lang.String r13 = r13.K()     // Catch:{ all -> 0x0d0b }
            boolean r13 = r9.equals(r13)     // Catch:{ all -> 0x0d0b }
            if (r13 == 0) goto L_0x0368
            r11 = 1
        L_0x0368:
            int r10 = r10 + 1
            goto L_0x0341
        L_0x036b:
            if (r11 == 0) goto L_0x0374
            if (r5 == 0) goto L_0x0373
            r3.z(r12)     // Catch:{ all -> 0x0d0b }
            goto L_0x03a5
        L_0x0373:
            r5 = 0
        L_0x0374:
            if (r5 == 0) goto L_0x038e
            c.d.a.b.e.e.p8 r5 = r5.clone()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.j4 r5 = (c.d.a.b.e.e.j4) r5     // Catch:{ all -> 0x0d0b }
            r5.B(r9)     // Catch:{ all -> 0x0d0b }
            r9 = 10
            r5.A(r9)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r5 = r5.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r5 = (c.d.a.b.e.e.k4) r5     // Catch:{ all -> 0x0d0b }
            r3.C(r12, r5)     // Catch:{ all -> 0x0d0b }
            goto L_0x03a5
        L_0x038e:
            com.google.android.gms.measurement.internal.m3 r5 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r9 = "Did not find conversion parameter. appId"
            c.d.a.b.e.e.r4 r10 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = r10.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0d0b }
            r5.b(r9, r10)     // Catch:{ all -> 0x0d0b }
        L_0x03a5:
            if (r2 == 0) goto L_0x045e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d0b }
            java.util.List r5 = r3.H()     // Catch:{ all -> 0x0d0b }
            r2.<init>(r5)     // Catch:{ all -> 0x0d0b }
            r5 = 0
            r9 = -1
            r10 = -1
        L_0x03b3:
            int r11 = r2.size()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r11) goto L_0x03e3
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r11 = (c.d.a.b.e.e.k4) r11     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r11.K()     // Catch:{ all -> 0x0d0b }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x0d0b }
            if (r11 == 0) goto L_0x03cf
            r9 = r5
            goto L_0x03e0
        L_0x03cf:
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r11 = (c.d.a.b.e.e.k4) r11     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r11.K()     // Catch:{ all -> 0x0d0b }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d0b }
            if (r11 == 0) goto L_0x03e0
            r10 = r5
        L_0x03e0:
            int r5 = r5 + 1
            goto L_0x03b3
        L_0x03e3:
            r5 = -1
            if (r9 != r5) goto L_0x03e8
            goto L_0x045f
        L_0x03e8:
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r5 = (c.d.a.b.e.e.k4) r5     // Catch:{ all -> 0x0d0b }
            boolean r5 = r5.Z()     // Catch:{ all -> 0x0d0b }
            if (r5 != 0) goto L_0x0419
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r5 = (c.d.a.b.e.e.k4) r5     // Catch:{ all -> 0x0d0b }
            boolean r5 = r5.X()     // Catch:{ all -> 0x0d0b }
            if (r5 != 0) goto L_0x0419
            com.google.android.gms.measurement.internal.m3 r2 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.x()     // Catch:{ all -> 0x0d0b }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.a(r5)     // Catch:{ all -> 0x0d0b }
            r3.z(r9)     // Catch:{ all -> 0x0d0b }
            H(r3, r8)     // Catch:{ all -> 0x0d0b }
            r2 = 18
            G(r3, r2, r13)     // Catch:{ all -> 0x0d0b }
            goto L_0x045e
        L_0x0419:
            r5 = -1
            if (r10 != r5) goto L_0x041d
            goto L_0x0445
        L_0x041d:
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r2 = (c.d.a.b.e.e.k4) r2     // Catch:{ all -> 0x0d0b }
            java.lang.String r2 = r2.L()     // Catch:{ all -> 0x0d0b }
            int r10 = r2.length()     // Catch:{ all -> 0x0d0b }
            r11 = 3
            if (r10 != r11) goto L_0x0445
            r10 = 0
        L_0x042f:
            int r11 = r2.length()     // Catch:{ all -> 0x0d0b }
            if (r10 >= r11) goto L_0x045f
            int r11 = r2.codePointAt(r10)     // Catch:{ all -> 0x0d0b }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x0d0b }
            if (r13 == 0) goto L_0x0445
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0d0b }
            int r10 = r10 + r11
            goto L_0x042f
        L_0x0445:
            com.google.android.gms.measurement.internal.m3 r2 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.x()     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r10)     // Catch:{ all -> 0x0d0b }
            r3.z(r9)     // Catch:{ all -> 0x0d0b }
            H(r3, r8)     // Catch:{ all -> 0x0d0b }
            r2 = 19
            G(r3, r2, r12)     // Catch:{ all -> 0x0d0b }
            goto L_0x045f
        L_0x045e:
            r5 = -1
        L_0x045f:
            java.lang.String r2 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x0d0b }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04c5
            com.google.android.gms.measurement.internal.ea r2 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r2 = r3.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r2 = com.google.android.gms.measurement.internal.ea.n(r2, r6)     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x04c0
            if (r7 == 0) goto L_0x04b4
            long r10 = r7.u()     // Catch:{ all -> 0x0d0b }
            long r12 = r3.u()     // Catch:{ all -> 0x0d0b }
            long r10 = r10 - r12
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d0b }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04b4
            c.d.a.b.e.e.p8 r2 = r7.clone()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.f4 r2 = (c.d.a.b.e.e.f4) r2     // Catch:{ all -> 0x0d0b }
            boolean r6 = r1.P(r3, r2)     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x04a7
            r6 = r19
            r10 = r27
            r10.K(r6, r2)     // Catch:{ all -> 0x0d0b }
            r11 = r23
            r2 = 0
            r13 = 0
            goto L_0x04af
        L_0x04a7:
            r6 = r19
            r10 = r27
            r2 = r3
            r13 = r7
            r11 = r22
        L_0x04af:
            r25 = r2
            r14 = r6
            goto L_0x0524
        L_0x04b4:
            r6 = r19
            r10 = r27
            r25 = r3
            r14 = r6
            r13 = r7
            r11 = r22
            goto L_0x0524
        L_0x04c0:
            r6 = r19
            r10 = r27
            goto L_0x051f
        L_0x04c5:
            r6 = r19
            r10 = r27
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r3.G()     // Catch:{ all -> 0x0d0b }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x051f
            com.google.android.gms.measurement.internal.ea r2 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r2 = r3.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ all -> 0x0d0b }
            r11 = r26
            c.d.a.b.e.e.k4 r2 = com.google.android.gms.measurement.internal.ea.n(r2, r11)     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x051f
            if (r25 == 0) goto L_0x0518
            long r11 = r25.u()     // Catch:{ all -> 0x0d0b }
            long r13 = r3.u()     // Catch:{ all -> 0x0d0b }
            long r11 = r11 - r13
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0d0b }
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0518
            c.d.a.b.e.e.p8 r2 = r25.clone()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.f4 r2 = (c.d.a.b.e.e.f4) r2     // Catch:{ all -> 0x0d0b }
            boolean r7 = r1.P(r2, r3)     // Catch:{ all -> 0x0d0b }
            if (r7 == 0) goto L_0x0511
            r8 = r23
            r10.K(r8, r2)     // Catch:{ all -> 0x0d0b }
            r14 = r6
            r2 = 0
            r25 = 0
            goto L_0x0516
        L_0x0511:
            r8 = r23
            r2 = r3
            r14 = r22
        L_0x0516:
            r13 = r2
            goto L_0x0523
        L_0x0518:
            r8 = r23
            r13 = r3
            r11 = r8
            r14 = r22
            goto L_0x0524
        L_0x051f:
            r8 = r23
            r14 = r6
            r13 = r7
        L_0x0523:
            r11 = r8
        L_0x0524:
            java.util.List r2 = r4.f2658c     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r6 = r3.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r6 = (c.d.a.b.e.e.g4) r6     // Catch:{ all -> 0x0d0b }
            r7 = r24
            r2.set(r7, r6)     // Catch:{ all -> 0x0d0b }
            int r9 = r22 + 1
            r10.u0(r3)     // Catch:{ all -> 0x0d0b }
            r15 = r16
        L_0x0538:
            int r8 = r7 + 1
            r5 = r10
            r2 = r17
            r3 = r18
            r10 = r25
            goto L_0x0040
        L_0x0543:
            r10 = r5
            r11 = r7
            r22 = r9
            r2 = 0
            r7 = r2
            r5 = 0
        L_0x054b:
            if (r5 >= r9) goto L_0x059b
            c.d.a.b.e.e.g4 r12 = r10.p0(r5)     // Catch:{ all -> 0x0d0b }
            java.lang.String r13 = r12.L()     // Catch:{ all -> 0x0d0b }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0d0b }
            if (r13 == 0) goto L_0x056e
            com.google.android.gms.measurement.internal.ea r13 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r13)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r13 = com.google.android.gms.measurement.internal.ea.n(r12, r6)     // Catch:{ all -> 0x0d0b }
            if (r13 == 0) goto L_0x056e
            r10.s(r5)     // Catch:{ all -> 0x0d0b }
            int r9 = r9 + -1
            int r5 = r5 + -1
            goto L_0x0598
        L_0x056e:
            com.google.android.gms.measurement.internal.ea r13 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r13)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r12 = com.google.android.gms.measurement.internal.ea.n(r12, r11)     // Catch:{ all -> 0x0d0b }
            if (r12 == 0) goto L_0x0598
            boolean r13 = r12.Z()     // Catch:{ all -> 0x0d0b }
            if (r13 == 0) goto L_0x0588
            long r12 = r12.H()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0d0b }
            goto L_0x0589
        L_0x0588:
            r12 = 0
        L_0x0589:
            if (r12 == 0) goto L_0x0598
            long r13 = r12.longValue()     // Catch:{ all -> 0x0d0b }
            int r18 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r18 <= 0) goto L_0x0598
            long r12 = r12.longValue()     // Catch:{ all -> 0x0d0b }
            long r7 = r7 + r12
        L_0x0598:
            r12 = 1
            int r5 = r5 + r12
            goto L_0x054b
        L_0x059b:
            r5 = 0
            r1.L(r10, r7, r5)     // Catch:{ all -> 0x0d0b }
            java.util.List r5 = r10.k0()     // Catch:{ all -> 0x0d0b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0d0b }
        L_0x05a7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0d0b }
            java.lang.String r9 = "_se"
            if (r6 == 0) goto L_0x05cd
            java.lang.String r6 = "_s"
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r11 = (c.d.a.b.e.e.g4) r11     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r11.L()     // Catch:{ all -> 0x0d0b }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x05a7
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r10.h0()     // Catch:{ all -> 0x0d0b }
            r5.m(r6, r9)     // Catch:{ all -> 0x0d0b }
        L_0x05cd:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.ea.w(r10, r5)     // Catch:{ all -> 0x0d0b }
            if (r5 < 0) goto L_0x05da
            r5 = 1
            r1.L(r10, r7, r5)     // Catch:{ all -> 0x0d0b }
            goto L_0x05fa
        L_0x05da:
            int r5 = com.google.android.gms.measurement.internal.ea.w(r10, r9)     // Catch:{ all -> 0x0d0b }
            if (r5 < 0) goto L_0x05fa
            r10.t(r5)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r5 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "Session engagement user property is in the bundle without session ID. appId"
            c.d.a.b.e.e.r4 r7 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r7.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r7)     // Catch:{ all -> 0x0d0b }
            r5.b(r6, r7)     // Catch:{ all -> 0x0d0b }
        L_0x05fa:
            com.google.android.gms.measurement.internal.ea r5 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r6 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r6 = r6.v()     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.a(r7)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ca r6 = r5.f2504b     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.p4 r6 = r6.f2342a     // Catch:{ all -> 0x0d0b }
            R(r6)     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r10.h0()     // Catch:{ all -> 0x0d0b }
            boolean r6 = r6.B(r7)     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.ca r6 = r5.f2504b     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r6 = r6.f2344c     // Catch:{ all -> 0x0d0b }
            R(r6)     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r10.h0()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h6 r6 = r6.R(r7)     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x0691
            boolean r6 = r6.I()     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.x4 r6 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.r r6 = r6.A()     // Catch:{ all -> 0x0d0b }
            boolean r6 = r6.s()     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.x4 r6 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r6 = r6.q()     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r6.a(r7)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.z4 r6 = c.d.a.b.e.e.a5.H()     // Catch:{ all -> 0x0d0b }
            r7 = r17
            r6.x(r7)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.r r5 = r5.A()     // Catch:{ all -> 0x0d0b }
            long r8 = r5.o()     // Catch:{ all -> 0x0d0b }
            r6.y(r8)     // Catch:{ all -> 0x0d0b }
            r8 = 1
            r6.w(r8)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r5 = r6.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.a5 r5 = (c.d.a.b.e.e.a5) r5     // Catch:{ all -> 0x0d0b }
            r6 = 0
        L_0x0673:
            int r8 = r10.m0()     // Catch:{ all -> 0x0d0b }
            if (r6 >= r8) goto L_0x068e
            c.d.a.b.e.e.a5 r8 = r10.g0(r6)     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = r8.J()     // Catch:{ all -> 0x0d0b }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d0b }
            if (r8 == 0) goto L_0x068b
            r10.e0(r6, r5)     // Catch:{ all -> 0x0d0b }
            goto L_0x0691
        L_0x068b:
            int r6 = r6 + 1
            goto L_0x0673
        L_0x068e:
            r10.w0(r5)     // Catch:{ all -> 0x0d0b }
        L_0x0691:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10.a0(r5)     // Catch:{ all -> 0x0d0b }
            r5 = -9223372036854775808
            r10.I(r5)     // Catch:{ all -> 0x0d0b }
            r5 = 0
        L_0x069f:
            int r6 = r10.S()     // Catch:{ all -> 0x0d0b }
            if (r5 >= r6) goto L_0x06d2
            c.d.a.b.e.e.g4 r6 = r10.p0(r5)     // Catch:{ all -> 0x0d0b }
            long r7 = r6.H()     // Catch:{ all -> 0x0d0b }
            long r11 = r10.o0()     // Catch:{ all -> 0x0d0b }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x06bc
            long r7 = r6.H()     // Catch:{ all -> 0x0d0b }
            r10.a0(r7)     // Catch:{ all -> 0x0d0b }
        L_0x06bc:
            long r7 = r6.H()     // Catch:{ all -> 0x0d0b }
            long r11 = r10.n0()     // Catch:{ all -> 0x0d0b }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x06cf
            long r6 = r6.H()     // Catch:{ all -> 0x0d0b }
            r10.I(r6)     // Catch:{ all -> 0x0d0b }
        L_0x06cf:
            int r5 = r5 + 1
            goto L_0x069f
        L_0x06d2:
            r10.J0()     // Catch:{ all -> 0x0d0b }
            r10.y0()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.b r5 = r1.f2347f     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            java.lang.String r23 = r10.h0()     // Catch:{ all -> 0x0d0b }
            java.util.List r24 = r10.k0()     // Catch:{ all -> 0x0d0b }
            java.util.List r25 = r10.l0()     // Catch:{ all -> 0x0d0b }
            long r6 = r10.o0()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r26 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d0b }
            long r6 = r10.n0()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r27 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d0b }
            r22 = r5
            java.util.List r5 = r22.m(r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0d0b }
            r10.q0(r5)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h r5 = r43.T()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r6 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r6.R1()     // Catch:{ all -> 0x0d0b }
            boolean r5 = r5.F(r6)     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x0a47
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0d0b }
            r5.<init>()     // Catch:{ all -> 0x0d0b }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0d0b }
            r6.<init>()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.la r7 = r43.g0()     // Catch:{ all -> 0x0d0b }
            java.security.SecureRandom r7 = r7.u()     // Catch:{ all -> 0x0d0b }
            r8 = 0
        L_0x0725:
            int r9 = r10.S()     // Catch:{ all -> 0x0d0b }
            if (r8 >= r9) goto L_0x0a0d
            c.d.a.b.e.e.g4 r9 = r10.p0(r8)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.p8 r9 = r9.B()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.f4 r9 = (c.d.a.b.e.e.f4) r9     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r9.G()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07c6
            com.google.android.gms.measurement.internal.ea r11 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r11)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r11 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r11 = (c.d.a.b.e.e.g4) r11     // Catch:{ all -> 0x0d0b }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.ea.o(r11, r14)     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0d0b }
            java.lang.Object r14 = r5.get(r11)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r14 = (com.google.android.gms.measurement.internal.t) r14     // Catch:{ all -> 0x0d0b }
            if (r14 != 0) goto L_0x077a
            com.google.android.gms.measurement.internal.n r14 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r14)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r15 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r15 = r15.R1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.i(r11)     // Catch:{ all -> 0x0d0b }
            r2 = r11
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r14 = r14.V(r15, r2)     // Catch:{ all -> 0x0d0b }
            if (r14 == 0) goto L_0x077a
            r5.put(r11, r14)     // Catch:{ all -> 0x0d0b }
        L_0x077a:
            if (r14 == 0) goto L_0x07b9
            java.lang.Long r2 = r14.i     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x07b9
            java.lang.Long r2 = r14.j     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x0798
            long r2 = r2.longValue()     // Catch:{ all -> 0x0d0b }
            r20 = 1
            int r11 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0798
            com.google.android.gms.measurement.internal.ea r2 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            java.lang.Long r2 = r14.j     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ea.P(r9, r13, r2)     // Catch:{ all -> 0x0d0b }
        L_0x0798:
            java.lang.Boolean r2 = r14.k     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x07b0
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x07b0
            com.google.android.gms.measurement.internal.ea r2 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            r2 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ea.P(r9, r12, r11)     // Catch:{ all -> 0x0d0b }
        L_0x07b0:
            c.d.a.b.e.e.s8 r2 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ all -> 0x0d0b }
            r6.add(r2)     // Catch:{ all -> 0x0d0b }
        L_0x07b9:
            r10.K(r8, r9)     // Catch:{ all -> 0x0d0b }
            r26 = r4
            r24 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a01
        L_0x07c6:
            com.google.android.gms.measurement.internal.p4 r2 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r3 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r3 = r3.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r2.b(r3, r11)     // Catch:{ all -> 0x0d0b }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0d0b }
            if (r14 != 0) goto L_0x07f7
            long r2 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07e2 }
            goto L_0x07f9
        L_0x07e2:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x0d0b }
            r2.c(r14, r3, r11)     // Catch:{ all -> 0x0d0b }
        L_0x07f7:
            r2 = 0
        L_0x07f9:
            com.google.android.gms.measurement.internal.la r11 = r43.g0()     // Catch:{ all -> 0x0d0b }
            long r14 = r9.u()     // Catch:{ all -> 0x0d0b }
            long r14 = r11.s0(r14, r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r11 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r11 = (c.d.a.b.e.e.g4) r11     // Catch:{ all -> 0x0d0b }
            r46 = r12
            r20 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0d0b }
            r22 = r2
            java.lang.String r2 = "_dbg"
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0d0b }
            if (r3 != 0) goto L_0x0851
            java.util.List r3 = r11.M()     // Catch:{ all -> 0x0d0b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d0b }
        L_0x0825:
            boolean r11 = r3.hasNext()     // Catch:{ all -> 0x0d0b }
            if (r11 == 0) goto L_0x0851
            java.lang.Object r11 = r3.next()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.k4 r11 = (c.d.a.b.e.e.k4) r11     // Catch:{ all -> 0x0d0b }
            r24 = r3
            java.lang.String r3 = r11.K()     // Catch:{ all -> 0x0d0b }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0d0b }
            if (r3 == 0) goto L_0x084e
            long r2 = r11.H()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d0b }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x084c
            goto L_0x0851
        L_0x084c:
            r2 = 1
            goto L_0x0864
        L_0x084e:
            r3 = r24
            goto L_0x0825
        L_0x0851:
            com.google.android.gms.measurement.internal.p4 r2 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r3 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r3 = r3.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r9.G()     // Catch:{ all -> 0x0d0b }
            int r2 = r2.r(r3, r11)     // Catch:{ all -> 0x0d0b }
        L_0x0864:
            if (r2 > 0) goto L_0x0886
            com.google.android.gms.measurement.internal.m3 r3 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.G()     // Catch:{ all -> 0x0d0b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d0b }
            r3.c(r11, r12, r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r2 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ all -> 0x0d0b }
            r6.add(r2)     // Catch:{ all -> 0x0d0b }
            goto L_0x07b9
        L_0x0886:
            java.lang.String r3 = r9.G()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r3 = (com.google.android.gms.measurement.internal.t) r3     // Catch:{ all -> 0x0d0b }
            if (r3 != 0) goto L_0x08e6
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r3)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r11 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = r11.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r9.G()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r3 = r3.V(r11, r12)     // Catch:{ all -> 0x0d0b }
            if (r3 != 0) goto L_0x08e6
            com.google.android.gms.measurement.internal.m3 r3 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            c.d.a.b.e.e.r4 r12 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = r12.R1()     // Catch:{ all -> 0x0d0b }
            r24 = r14
            java.lang.String r14 = r9.G()     // Catch:{ all -> 0x0d0b }
            r3.c(r11, r12, r14)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r3 = new com.google.android.gms.measurement.internal.t     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r11 = r4.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r27 = r11.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.String r28 = r9.G()     // Catch:{ all -> 0x0d0b }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r9.u()     // Catch:{ all -> 0x0d0b }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r3
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0d0b }
            goto L_0x08e8
        L_0x08e6:
            r24 = r14
        L_0x08e8:
            com.google.android.gms.measurement.internal.ea r11 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r11)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r11 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r11 = (c.d.a.b.e.e.g4) r11     // Catch:{ all -> 0x0d0b }
            java.lang.String r12 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.ea.o(r11, r12)     // Catch:{ all -> 0x0d0b }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0d0b }
            if (r11 == 0) goto L_0x08ff
            r12 = 1
            goto L_0x0900
        L_0x08ff:
            r12 = 0
        L_0x0900:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d0b }
            r14 = 1
            if (r2 != r14) goto L_0x0930
            c.d.a.b.e.e.s8 r2 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r2 = (c.d.a.b.e.e.g4) r2     // Catch:{ all -> 0x0d0b }
            r6.add(r2)     // Catch:{ all -> 0x0d0b }
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x07b9
            java.lang.Long r2 = r3.i     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x0922
            java.lang.Long r2 = r3.j     // Catch:{ all -> 0x0d0b }
            if (r2 != 0) goto L_0x0922
            java.lang.Boolean r2 = r3.k     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x07b9
        L_0x0922:
            r2 = 0
            com.google.android.gms.measurement.internal.t r3 = r3.a(r2, r2, r2)     // Catch:{ all -> 0x0d0b }
            java.lang.String r2 = r9.G()     // Catch:{ all -> 0x0d0b }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d0b }
            goto L_0x07b9
        L_0x0930:
            int r14 = r7.nextInt(r2)     // Catch:{ all -> 0x0d0b }
            if (r14 != 0) goto L_0x0972
            com.google.android.gms.measurement.internal.ea r11 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r11)     // Catch:{ all -> 0x0d0b }
            long r14 = (long) r2     // Catch:{ all -> 0x0d0b }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ea.P(r9, r13, r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r11 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r11 = (c.d.a.b.e.e.g4) r11     // Catch:{ all -> 0x0d0b }
            r6.add(r11)     // Catch:{ all -> 0x0d0b }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0d0b }
            if (r11 == 0) goto L_0x0957
            r11 = 0
            com.google.android.gms.measurement.internal.t r3 = r3.a(r11, r2, r11)     // Catch:{ all -> 0x0d0b }
        L_0x0957:
            java.lang.String r2 = r9.G()     // Catch:{ all -> 0x0d0b }
            long r11 = r9.u()     // Catch:{ all -> 0x0d0b }
            r14 = r24
            com.google.android.gms.measurement.internal.t r3 = r3.b(r11, r14)     // Catch:{ all -> 0x0d0b }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d0b }
            r26 = r4
            r24 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x09fe
        L_0x0972:
            r14 = r24
            r24 = r7
            java.lang.Long r7 = r3.h     // Catch:{ all -> 0x0d0b }
            if (r7 == 0) goto L_0x0987
            long r22 = r7.longValue()     // Catch:{ all -> 0x0d0b }
            r26 = r4
            r28 = r5
            r27 = r10
            r25 = r11
            goto L_0x099d
        L_0x0987:
            com.google.android.gms.measurement.internal.la r7 = r43.g0()     // Catch:{ all -> 0x0d0b }
            r27 = r10
            r25 = r11
            long r10 = r9.t()     // Catch:{ all -> 0x0d0b }
            r26 = r4
            r28 = r5
            r4 = r22
            long r22 = r7.s0(r10, r4)     // Catch:{ all -> 0x0d0b }
        L_0x099d:
            int r4 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x09e6
            com.google.android.gms.measurement.internal.ea r4 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r4)     // Catch:{ all -> 0x0d0b }
            r4 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d0b }
            r10 = r46
            com.google.android.gms.measurement.internal.ea.P(r9, r10, r7)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ea r7 = r1.g     // Catch:{ all -> 0x0d0b }
            R(r7)     // Catch:{ all -> 0x0d0b }
            long r10 = (long) r2     // Catch:{ all -> 0x0d0b }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ea.P(r9, r13, r2)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r7 = r9.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.g4 r7 = (c.d.a.b.e.e.g4) r7     // Catch:{ all -> 0x0d0b }
            r6.add(r7)     // Catch:{ all -> 0x0d0b }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0d0b }
            if (r7 == 0) goto L_0x09d4
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0d0b }
            r10 = 0
            com.google.android.gms.measurement.internal.t r3 = r3.a(r10, r2, r7)     // Catch:{ all -> 0x0d0b }
        L_0x09d4:
            java.lang.String r2 = r9.G()     // Catch:{ all -> 0x0d0b }
            long r10 = r9.u()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r3 = r3.b(r10, r14)     // Catch:{ all -> 0x0d0b }
            r7 = r28
        L_0x09e2:
            r7.put(r2, r3)     // Catch:{ all -> 0x0d0b }
            goto L_0x09fc
        L_0x09e6:
            r7 = r28
            r4 = 1
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d0b }
            if (r2 == 0) goto L_0x09fc
            java.lang.String r2 = r9.G()     // Catch:{ all -> 0x0d0b }
            r11 = r25
            r10 = 0
            com.google.android.gms.measurement.internal.t r3 = r3.a(r11, r10, r10)     // Catch:{ all -> 0x0d0b }
            goto L_0x09e2
        L_0x09fc:
            r2 = r27
        L_0x09fe:
            r2.K(r8, r9)     // Catch:{ all -> 0x0d0b }
        L_0x0a01:
            int r8 = r8 + 1
            r10 = r2
            r5 = r7
            r7 = r24
            r4 = r26
            r2 = 0
            goto L_0x0725
        L_0x0a0d:
            r26 = r4
            r7 = r5
            r2 = r10
            int r3 = r6.size()     // Catch:{ all -> 0x0d0b }
            int r4 = r2.S()     // Catch:{ all -> 0x0d0b }
            if (r3 >= r4) goto L_0x0a21
            r2.B0()     // Catch:{ all -> 0x0d0b }
            r2.r0(r6)     // Catch:{ all -> 0x0d0b }
        L_0x0a21:
            java.util.Set r3 = r7.entrySet()     // Catch:{ all -> 0x0d0b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d0b }
        L_0x0a29:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0d0b }
            if (r4 == 0) goto L_0x0a44
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0d0b }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.t r4 = (com.google.android.gms.measurement.internal.t) r4     // Catch:{ all -> 0x0d0b }
            r5.q(r4)     // Catch:{ all -> 0x0d0b }
            goto L_0x0a29
        L_0x0a44:
            r3 = r26
            goto L_0x0a49
        L_0x0a47:
            r2 = r10
            r3 = r4
        L_0x0a49:
            c.d.a.b.e.e.r4 r4 = r3.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r4 = r4.R1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.h6 r5 = r5.R(r4)     // Catch:{ all -> 0x0d0b }
            if (r5 != 0) goto L_0x0a72
            com.google.android.gms.measurement.internal.m3 r5 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            c.d.a.b.e.e.r4 r7 = r3.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = r7.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.m3.z(r7)     // Catch:{ all -> 0x0d0b }
            r5.b(r6, r7)     // Catch:{ all -> 0x0d0b }
            goto L_0x0ace
        L_0x0a72:
            int r6 = r2.S()     // Catch:{ all -> 0x0d0b }
            if (r6 <= 0) goto L_0x0ace
            long r6 = r5.X()     // Catch:{ all -> 0x0d0b }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a86
            r2.T(r6)     // Catch:{ all -> 0x0d0b }
            goto L_0x0a89
        L_0x0a86:
            r2.F0()     // Catch:{ all -> 0x0d0b }
        L_0x0a89:
            long r8 = r5.Z()     // Catch:{ all -> 0x0d0b }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0a94
            goto L_0x0a95
        L_0x0a94:
            r6 = r8
        L_0x0a95:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0a9d
            r2.U(r6)     // Catch:{ all -> 0x0d0b }
            goto L_0x0aa0
        L_0x0a9d:
            r2.G0()     // Catch:{ all -> 0x0d0b }
        L_0x0aa0:
            r5.e()     // Catch:{ all -> 0x0d0b }
            long r6 = r5.Y()     // Catch:{ all -> 0x0d0b }
            int r7 = (int) r6     // Catch:{ all -> 0x0d0b }
            r2.A(r7)     // Catch:{ all -> 0x0d0b }
            long r6 = r2.o0()     // Catch:{ all -> 0x0d0b }
            r5.C(r6)     // Catch:{ all -> 0x0d0b }
            long r6 = r2.n0()     // Catch:{ all -> 0x0d0b }
            r5.z(r6)     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r5.c0()     // Catch:{ all -> 0x0d0b }
            if (r6 == 0) goto L_0x0ac3
            r2.O(r6)     // Catch:{ all -> 0x0d0b }
            goto L_0x0ac6
        L_0x0ac3:
            r2.C0()     // Catch:{ all -> 0x0d0b }
        L_0x0ac6:
            com.google.android.gms.measurement.internal.n r6 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r6)     // Catch:{ all -> 0x0d0b }
            r6.p(r5)     // Catch:{ all -> 0x0d0b }
        L_0x0ace:
            int r5 = r2.S()     // Catch:{ all -> 0x0d0b }
            if (r5 <= 0) goto L_0x0c50
            com.google.android.gms.measurement.internal.x4 r5 = r1.l     // Catch:{ all -> 0x0d0b }
            r5.e()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.p4 r5 = r1.f2342a     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r6 = r3.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = r6.R1()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s3 r5 = r5.t(r6)     // Catch:{ all -> 0x0d0b }
            r6 = -1
            if (r5 == 0) goto L_0x0afb
            boolean r8 = r5.V()     // Catch:{ all -> 0x0d0b }
            if (r8 != 0) goto L_0x0af3
            goto L_0x0afb
        L_0x0af3:
            long r8 = r5.G()     // Catch:{ all -> 0x0d0b }
            r2.C(r8)     // Catch:{ all -> 0x0d0b }
            goto L_0x0b22
        L_0x0afb:
            c.d.a.b.e.e.r4 r5 = r3.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r5 = r5.J()     // Catch:{ all -> 0x0d0b }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d0b }
            if (r5 == 0) goto L_0x0b0b
            r2.C(r6)     // Catch:{ all -> 0x0d0b }
            goto L_0x0b22
        L_0x0b0b:
            com.google.android.gms.measurement.internal.m3 r5 = r43.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            c.d.a.b.e.e.r4 r9 = r3.f2656a     // Catch:{ all -> 0x0d0b }
            java.lang.String r9 = r9.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r9)     // Catch:{ all -> 0x0d0b }
            r5.b(r8, r9)     // Catch:{ all -> 0x0d0b }
        L_0x0b22:
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r5)     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.s8 r2 = r2.n()     // Catch:{ all -> 0x0d0b }
            c.d.a.b.e.e.r4 r2 = (c.d.a.b.e.e.r4) r2     // Catch:{ all -> 0x0d0b }
            r5.h()     // Catch:{ all -> 0x0d0b }
            r5.i()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.i(r2)     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = r2.R1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.e(r8)     // Catch:{ all -> 0x0d0b }
            boolean r8 = r2.k1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.l(r8)     // Catch:{ all -> 0x0d0b }
            r5.h0()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r8 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.util.d r8 = r8.a()     // Catch:{ all -> 0x0d0b }
            long r8 = r8.a()     // Catch:{ all -> 0x0d0b }
            long r10 = r2.F1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r12 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            r12.z()     // Catch:{ all -> 0x0d0b }
            long r12 = com.google.android.gms.measurement.internal.h.i()     // Catch:{ all -> 0x0d0b }
            long r12 = r8 - r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0b76
            long r10 = r2.F1()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.x4 r12 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            r12.z()     // Catch:{ all -> 0x0d0b }
            long r12 = com.google.android.gms.measurement.internal.h.i()     // Catch:{ all -> 0x0d0b }
            long r12 = r12 + r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0b99
        L_0x0b76:
            com.google.android.gms.measurement.internal.x4 r10 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r10 = r10.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r10 = r10.w()     // Catch:{ all -> 0x0d0b }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r2.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.m3.z(r12)     // Catch:{ all -> 0x0d0b }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0d0b }
            long r13 = r2.F1()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d0b }
            r10.d(r11, r12, r8, r9)     // Catch:{ all -> 0x0d0b }
        L_0x0b99:
            byte[] r8 = r2.k()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.ca r9 = r5.f2504b     // Catch:{ IOException -> 0x0c39 }
            com.google.android.gms.measurement.internal.ea r9 = r9.g     // Catch:{ IOException -> 0x0c39 }
            R(r9)     // Catch:{ IOException -> 0x0c39 }
            byte[] r8 = r9.O(r8)     // Catch:{ IOException -> 0x0c39 }
            com.google.android.gms.measurement.internal.x4 r9 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r9 = r9.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r9 = r9.v()     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0d0b }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d0b }
            r9.b(r10, r11)     // Catch:{ all -> 0x0d0b }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0d0b }
            r9.<init>()     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r2.R1()     // Catch:{ all -> 0x0d0b }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r2.F1()     // Catch:{ all -> 0x0d0b }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d0b }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d0b }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0d0b }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0d0b }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d0b }
            boolean r8 = r2.q1()     // Catch:{ all -> 0x0d0b }
            if (r8 == 0) goto L_0x0bf8
            java.lang.String r8 = "retry_count"
            int r10 = r2.z1()     // Catch:{ all -> 0x0d0b }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0d0b }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d0b }
        L_0x0bf8:
            android.database.sqlite.SQLiteDatabase r8 = r5.P()     // Catch:{ SQLiteException -> 0x0c1f }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c1f }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0c50
            com.google.android.gms.measurement.internal.x4 r6 = r5.f2527a     // Catch:{ SQLiteException -> 0x0c1f }
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()     // Catch:{ SQLiteException -> 0x0c1f }
            com.google.android.gms.measurement.internal.k3 r6 = r6.r()     // Catch:{ SQLiteException -> 0x0c1f }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r2.R1()     // Catch:{ SQLiteException -> 0x0c1f }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.m3.z(r8)     // Catch:{ SQLiteException -> 0x0c1f }
            r6.b(r7, r8)     // Catch:{ SQLiteException -> 0x0c1f }
            goto L_0x0c50
        L_0x0c1f:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r2 = r2.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r2)     // Catch:{ all -> 0x0d0b }
        L_0x0c35:
            r5.c(r7, r2, r6)     // Catch:{ all -> 0x0d0b }
            goto L_0x0c50
        L_0x0c39:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r2 = r2.R1()     // Catch:{ all -> 0x0d0b }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r2)     // Catch:{ all -> 0x0d0b }
            goto L_0x0c35
        L_0x0c50:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            java.util.List r3 = r3.f2657b     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.common.internal.n.i(r3)     // Catch:{ all -> 0x0d0b }
            r2.h()     // Catch:{ all -> 0x0d0b }
            r2.i()     // Catch:{ all -> 0x0d0b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d0b }
            r6 = 0
        L_0x0c68:
            int r7 = r3.size()     // Catch:{ all -> 0x0d0b }
            if (r6 >= r7) goto L_0x0c85
            if (r6 == 0) goto L_0x0c75
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d0b }
        L_0x0c75:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0d0b }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d0b }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d0b }
            r5.append(r7)     // Catch:{ all -> 0x0d0b }
            int r6 = r6 + 1
            goto L_0x0c68
        L_0x0c85:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d0b }
            android.database.sqlite.SQLiteDatabase r6 = r2.P()     // Catch:{ all -> 0x0d0b }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d0b }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d0b }
            int r6 = r3.size()     // Catch:{ all -> 0x0d0b }
            if (r5 == r6) goto L_0x0cba
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d0b }
            int r3 = r3.size()     // Catch:{ all -> 0x0d0b }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d0b }
            r2.c(r6, r5, r3)     // Catch:{ all -> 0x0d0b }
        L_0x0cba:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            android.database.sqlite.SQLiteDatabase r3 = r2.P()     // Catch:{ all -> 0x0d0b }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0cd2 }
            r6 = 0
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0cd2 }
            r6 = 1
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0cd2 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r3.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0cd2 }
            goto L_0x0ce7
        L_0x0cd2:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0d0b }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r4)     // Catch:{ all -> 0x0d0b }
            r2.c(r5, r4, r3)     // Catch:{ all -> 0x0d0b }
        L_0x0ce7:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            r2.o()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            r2 = 1
            return r2
        L_0x0cf9:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0d0b }
            R(r2)     // Catch:{ all -> 0x0d0b }
            r2.o()     // Catch:{ all -> 0x0d0b }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            r2 = 0
            return r2
        L_0x0d0b:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c
            R(r3)
            r3.f0()
            goto L_0x0d17
        L_0x0d16:
            throw r2
        L_0x0d17:
            goto L_0x0d16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.N(java.lang.String, long):boolean");
    }

    private final boolean O() {
        c().h();
        g();
        n nVar = this.f2344c;
        R(nVar);
        if (nVar.r()) {
            return true;
        }
        n nVar2 = this.f2344c;
        R(nVar2);
        return !TextUtils.isEmpty(nVar2.Z());
    }

    private final boolean P(f4 f4Var, f4 f4Var2) {
        n.a("_e".equals(f4Var.G()));
        R(this.g);
        k4 n2 = ea.n((g4) f4Var.n(), "_sc");
        String str = null;
        String L = n2 == null ? null : n2.L();
        R(this.g);
        k4 n3 = ea.n((g4) f4Var2.n(), "_pc");
        if (n3 != null) {
            str = n3.L();
        }
        if (str == null || !str.equals(L)) {
            return false;
        }
        n.a("_e".equals(f4Var.G()));
        R(this.g);
        k4 n4 = ea.n((g4) f4Var.n(), "_et");
        if (n4 == null || !n4.Z() || n4.H() <= 0) {
            return true;
        }
        long H = n4.H();
        R(this.g);
        k4 n5 = ea.n((g4) f4Var2.n(), "_et");
        if (n5 != null && n5.H() > 0) {
            H += n5.H();
        }
        R(this.g);
        ea.P(f4Var2, "_et", Long.valueOf(H));
        R(this.g);
        ea.P(f4Var, "_fr", 1L);
        return true;
    }

    private static final boolean Q(qa qaVar) {
        return !TextUtils.isEmpty(qaVar.k) || !TextUtils.isEmpty(qaVar.z);
    }

    private static final q9 R(q9 q9Var) {
        if (q9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (q9Var.k()) {
            return q9Var;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(q9Var.getClass()))));
        }
    }

    public static ca e0(Context context) {
        n.i(context);
        n.i(context.getApplicationContext());
        if (F == null) {
            synchronized (ca.class) {
                if (F == null) {
                    da daVar = new da(context);
                    n.i(daVar);
                    F = new ca(daVar, (x4) null);
                }
            }
        }
        return F;
    }

    static /* bridge */ /* synthetic */ void j0(ca caVar, da daVar) {
        caVar.c().h();
        caVar.k = new e4(caVar);
        n nVar = new n(caVar);
        nVar.j();
        caVar.f2344c = nVar;
        h T = caVar.T();
        p4 p4Var = caVar.f2342a;
        n.i(p4Var);
        T.z(p4Var);
        w8 w8Var = new w8(caVar);
        w8Var.j();
        caVar.i = w8Var;
        b bVar = new b(caVar);
        bVar.j();
        caVar.f2347f = bVar;
        k7 k7Var = new k7(caVar);
        k7Var.j();
        caVar.h = k7Var;
        o9 o9Var = new o9(caVar);
        o9Var.j();
        caVar.f2346e = o9Var;
        caVar.f2345d = new u3(caVar);
        if (caVar.q != caVar.r) {
            caVar.f().r().c("Not all upload components initialized", Integer.valueOf(caVar.q), Integer.valueOf(caVar.r));
        }
        caVar.m = true;
    }

    /* access modifiers changed from: package-private */
    public final void A(String str, j jVar) {
        c().h();
        g();
        this.A.put(str, jVar);
        n nVar = this.f2344c;
        R(nVar);
        n.i(str);
        n.i(jVar);
        nVar.h();
        nVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", jVar.h());
        try {
            if (nVar.P().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                nVar.f2527a.f().r().b("Failed to insert/update consent setting (got -1). appId", m3.z(str));
            }
        } catch (SQLiteException e2) {
            nVar.f2527a.f().r().c("Error storing consent setting. appId, error", m3.z(str), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(fa faVar, qa qaVar) {
        long j2;
        fa faVar2 = faVar;
        qa qaVar2 = qaVar;
        c().h();
        g();
        if (Q(qaVar)) {
            if (!qaVar2.q) {
                S(qaVar2);
                return;
            }
            int n0 = g0().n0(faVar2.k);
            if (n0 != 0) {
                la g0 = g0();
                String str = faVar2.k;
                T();
                String r2 = g0.r(str, 24, true);
                String str2 = faVar2.k;
                g0().B(this.E, qaVar2.j, n0, "_ev", r2, str2 != null ? str2.length() : 0);
                return;
            }
            int j0 = g0().j0(faVar2.k, faVar.g());
            if (j0 != 0) {
                la g02 = g0();
                String str3 = faVar2.k;
                T();
                String r3 = g02.r(str3, 24, true);
                Object g2 = faVar.g();
                g0().B(this.E, qaVar2.j, j0, "_ev", r3, (g2 == null || (!(g2 instanceof String) && !(g2 instanceof CharSequence))) ? 0 : g2.toString().length());
                return;
            }
            Object p2 = g0().p(faVar2.k, faVar.g());
            if (p2 != null) {
                if ("_sid".equals(faVar2.k)) {
                    long j3 = faVar2.l;
                    String str4 = faVar2.o;
                    String str5 = qaVar2.j;
                    n.i(str5);
                    String str6 = str5;
                    n nVar = this.f2344c;
                    R(nVar);
                    ha X = nVar.X(str6, "_sno");
                    if (X != null) {
                        Object obj = X.f2408e;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            B(new fa("_sno", j3, Long.valueOf(j2 + 1), str4), qaVar2);
                        }
                    }
                    if (X != null) {
                        f().w().b("Retrieved last session number from database does not contain a valid (long) value", X.f2408e);
                    }
                    n nVar2 = this.f2344c;
                    R(nVar2);
                    t V = nVar2.V(str6, "_s");
                    if (V != null) {
                        j2 = V.f2542c;
                        f().v().b("Backfill the session number. Last used session number", Long.valueOf(j2));
                    } else {
                        j2 = 0;
                    }
                    B(new fa("_sno", j3, Long.valueOf(j2 + 1), str4), qaVar2);
                }
                String str7 = qaVar2.j;
                n.i(str7);
                String str8 = faVar2.o;
                n.i(str8);
                ha haVar = new ha(str7, str8, faVar2.k, faVar2.l, p2);
                f().v().c("Setting user property", this.l.D().f(haVar.f2406c), p2);
                n nVar3 = this.f2344c;
                R(nVar3);
                nVar3.e0();
                try {
                    if ("_id".equals(haVar.f2406c)) {
                        n nVar4 = this.f2344c;
                        R(nVar4);
                        ha X2 = nVar4.X(qaVar2.j, "_id");
                        if (X2 != null && !haVar.f2408e.equals(X2.f2408e)) {
                            n nVar5 = this.f2344c;
                            R(nVar5);
                            nVar5.m(qaVar2.j, "_lair");
                        }
                    }
                    S(qaVar2);
                    n nVar6 = this.f2344c;
                    R(nVar6);
                    boolean x2 = nVar6.x(haVar);
                    n nVar7 = this.f2344c;
                    R(nVar7);
                    nVar7.o();
                    if (!x2) {
                        f().r().c("Too many unique user properties are set. Ignoring user property", this.l.D().f(haVar.f2406c), haVar.f2408e);
                        g0().B(this.E, qaVar2.j, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    n nVar8 = this.f2344c;
                    R(nVar8);
                    nVar8.f0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:209|210) */
    /* JADX WARNING: Code restructure failed: missing block: B:210:?, code lost:
        f().r().c("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.m3.z(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x052c, code lost:
        if (r11 != null) goto L_0x052e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0553, code lost:
        if (r11 != null) goto L_0x052e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0556, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        if (r11 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        if (r11 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0119, code lost:
        if (r11 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1.z = r7;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:209:0x04d0 */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0288 A[SYNTHETIC, Splitter:B:140:0x0288] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0291 A[Catch:{ all -> 0x011f, all -> 0x0578 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04e7 A[Catch:{ all -> 0x011f, all -> 0x0578 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0574 A[SYNTHETIC, Splitter:B:251:0x0574] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0123 A[Catch:{ all -> 0x011f, all -> 0x0578 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:200:0x0451=Splitter:B:200:0x0451, B:241:0x0557=Splitter:B:241:0x0557, B:41:0x00f9=Splitter:B:41:0x00f9, B:50:0x010a=Splitter:B:50:0x010a, B:53:0x011c=Splitter:B:53:0x011c, B:224:0x052e=Splitter:B:224:0x052e, B:137:0x026f=Splitter:B:137:0x026f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.u4 r0 = r22.c()
            r0.h()
            r22.g()
            r2 = 1
            r1.u = r2
            r3 = 0
            com.google.android.gms.measurement.internal.x4 r0 = r1.l     // Catch:{ all -> 0x0578 }
            r0.e()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x4 r0 = r1.l     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.u8 r0 = r0.L()     // Catch:{ all -> 0x0578 }
            java.lang.Boolean r0 = r0.J()     // Catch:{ all -> 0x0578 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x0578 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
        L_0x002b:
            r0.a(r2)     // Catch:{ all -> 0x0578 }
        L_0x002e:
            r1.u = r3
        L_0x0030:
            r22.K()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0578 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x0578 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            goto L_0x002b
        L_0x0045:
            long r4 = r1.o     // Catch:{ all -> 0x0578 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0051
        L_0x004d:
            r22.M()     // Catch:{ all -> 0x0578 }
            goto L_0x002e
        L_0x0051:
            com.google.android.gms.measurement.internal.u4 r0 = r22.c()     // Catch:{ all -> 0x0578 }
            r0.h()     // Catch:{ all -> 0x0578 }
            java.util.List r0 = r1.x     // Catch:{ all -> 0x0578 }
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()     // Catch:{ all -> 0x0578 }
            java.lang.String r2 = "Uploading requested multiple times"
            goto L_0x002b
        L_0x0067:
            com.google.android.gms.measurement.internal.s3 r0 = r1.f2343b     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            boolean r0 = r0.m()     // Catch:{ all -> 0x0578 }
            if (r0 != 0) goto L_0x0080
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()     // Catch:{ all -> 0x0578 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.a(r2)     // Catch:{ all -> 0x0578 }
            goto L_0x004d
        L_0x0080:
            com.google.android.gms.common.util.d r0 = r22.a()     // Catch:{ all -> 0x0578 }
            long r4 = r0.a()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h r0 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r8 = com.google.android.gms.measurement.internal.y2.Q     // Catch:{ all -> 0x0578 }
            r9 = 0
            int r0 = r0.o(r9, r8)     // Catch:{ all -> 0x0578 }
            r22.T()     // Catch:{ all -> 0x0578 }
            long r10 = com.google.android.gms.measurement.internal.h.I()     // Catch:{ all -> 0x0578 }
            long r10 = r4 - r10
            r8 = 0
        L_0x009d:
            if (r8 >= r0) goto L_0x00a8
            boolean r12 = r1.N(r9, r10)     // Catch:{ all -> 0x0578 }
            if (r12 == 0) goto L_0x00a8
            int r8 = r8 + 1
            goto L_0x009d
        L_0x00a8:
            com.google.android.gms.measurement.internal.w8 r0 = r1.i     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x3 r0 = r0.g     // Catch:{ all -> 0x0578 }
            long r10 = r0.a()     // Catch:{ all -> 0x0578 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()     // Catch:{ all -> 0x0578 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0578 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0578 }
            r0.b(r6, r7)     // Catch:{ all -> 0x0578 }
        L_0x00cb:
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            java.lang.String r6 = r0.Z()     // Catch:{ all -> 0x0578 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0578 }
            r7 = -1
            if (r0 != 0) goto L_0x04eb
            long r10 = r1.z     // Catch:{ all -> 0x0578 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0127
            com.google.android.gms.measurement.internal.n r10 = r1.f2344c     // Catch:{ all -> 0x0578 }
            R(r10)     // Catch:{ all -> 0x0578 }
            android.database.sqlite.SQLiteDatabase r0 = r10.P()     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0108, all -> 0x0106 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0104 }
            if (r0 != 0) goto L_0x00fd
            if (r11 == 0) goto L_0x011c
        L_0x00f9:
            r11.close()     // Catch:{ all -> 0x0578 }
            goto L_0x011c
        L_0x00fd:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0104 }
            if (r11 == 0) goto L_0x011c
            goto L_0x00f9
        L_0x0104:
            r0 = move-exception
            goto L_0x010a
        L_0x0106:
            r0 = move-exception
            goto L_0x0121
        L_0x0108:
            r0 = move-exception
            r11 = r9
        L_0x010a:
            com.google.android.gms.measurement.internal.x4 r10 = r10.f2527a     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.m3 r10 = r10.f()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.k3 r10 = r10.r()     // Catch:{ all -> 0x011f }
            java.lang.String r12 = "Error querying raw events"
            r10.b(r12, r0)     // Catch:{ all -> 0x011f }
            if (r11 == 0) goto L_0x011c
            goto L_0x00f9
        L_0x011c:
            r1.z = r7     // Catch:{ all -> 0x0578 }
            goto L_0x0127
        L_0x011f:
            r0 = move-exception
            r9 = r11
        L_0x0121:
            if (r9 == 0) goto L_0x0126
            r9.close()     // Catch:{ all -> 0x0578 }
        L_0x0126:
            throw r0     // Catch:{ all -> 0x0578 }
        L_0x0127:
            com.google.android.gms.measurement.internal.h r0 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r7 = com.google.android.gms.measurement.internal.y2.g     // Catch:{ all -> 0x0578 }
            int r0 = r0.o(r6, r7)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h r7 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r8 = com.google.android.gms.measurement.internal.y2.h     // Catch:{ all -> 0x0578 }
            int r7 = r7.o(r6, r8)     // Catch:{ all -> 0x0578 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.n r8 = r1.f2344c     // Catch:{ all -> 0x0578 }
            R(r8)     // Catch:{ all -> 0x0578 }
            r8.h()     // Catch:{ all -> 0x0578 }
            r8.i()     // Catch:{ all -> 0x0578 }
            if (r0 <= 0) goto L_0x014e
            r10 = 1
            goto L_0x014f
        L_0x014e:
            r10 = 0
        L_0x014f:
            com.google.android.gms.common.internal.n.a(r10)     // Catch:{ all -> 0x0578 }
            if (r7 <= 0) goto L_0x0156
            r10 = 1
            goto L_0x0157
        L_0x0156:
            r10 = 0
        L_0x0157:
            com.google.android.gms.common.internal.n.a(r10)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.common.internal.n.e(r6)     // Catch:{ all -> 0x0578 }
            android.database.sqlite.SQLiteDatabase r11 = r8.P()     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x026b, all -> 0x0267 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0263 }
            if (r0 != 0) goto L_0x0194
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0263 }
            if (r11 == 0) goto L_0x0190
            r11.close()     // Catch:{ all -> 0x0578 }
        L_0x0190:
            r20 = r4
            goto L_0x028b
        L_0x0194:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0263 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0263 }
            r13 = 0
        L_0x019a:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0263 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0236 }
            com.google.android.gms.measurement.internal.ca r2 = r8.f2504b     // Catch:{ IOException -> 0x0236 }
            com.google.android.gms.measurement.internal.ea r2 = r2.g     // Catch:{ IOException -> 0x0236 }
            R(r2)     // Catch:{ IOException -> 0x0236 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0221 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0221 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0221 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0221 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0221 }
            r3.<init>()     // Catch:{ IOException -> 0x0221 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0221 }
            r20 = r4
        L_0x01be:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x021f }
            if (r4 > 0) goto L_0x021a
            r0.close()     // Catch:{ IOException -> 0x021f }
            r9.close()     // Catch:{ IOException -> 0x021f }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x021f }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0261 }
            if (r2 != 0) goto L_0x01da
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0261 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01da
            goto L_0x025a
        L_0x01da:
            c.d.a.b.e.e.q4 r2 = c.d.a.b.e.e.r4.N1()     // Catch:{ IOException -> 0x0205 }
            com.google.android.gms.measurement.internal.ea.C(r2, r0)     // Catch:{ IOException -> 0x0205 }
            c.d.a.b.e.e.q4 r2 = (c.d.a.b.e.e.q4) r2     // Catch:{ IOException -> 0x0205 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0261 }
            if (r4 != 0) goto L_0x01f1
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0261 }
            r2.X(r4)     // Catch:{ SQLiteException -> 0x0261 }
        L_0x01f1:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0261 }
            int r13 = r13 + r0
            c.d.a.b.e.e.s8 r0 = r2.n()     // Catch:{ SQLiteException -> 0x0261 }
            c.d.a.b.e.e.r4 r0 = (c.d.a.b.e.e.r4) r0     // Catch:{ SQLiteException -> 0x0261 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0261 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0261 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0261 }
            goto L_0x024a
        L_0x0205:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r2 = r8.f2527a     // Catch:{ SQLiteException -> 0x0261 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ SQLiteException -> 0x0261 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x0261 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ SQLiteException -> 0x0261 }
        L_0x0216:
            r2.c(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0261 }
            goto L_0x024a
        L_0x021a:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x021f }
            goto L_0x01be
        L_0x021f:
            r0 = move-exception
            goto L_0x0224
        L_0x0221:
            r0 = move-exception
            r20 = r4
        L_0x0224:
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ IOException -> 0x0234 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ IOException -> 0x0234 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ IOException -> 0x0234 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.b(r3, r0)     // Catch:{ IOException -> 0x0234 }
            throw r0     // Catch:{ IOException -> 0x0234 }
        L_0x0234:
            r0 = move-exception
            goto L_0x0239
        L_0x0236:
            r0 = move-exception
            r20 = r4
        L_0x0239:
            com.google.android.gms.measurement.internal.x4 r2 = r8.f2527a     // Catch:{ SQLiteException -> 0x0261 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ SQLiteException -> 0x0261 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x0261 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ SQLiteException -> 0x0261 }
            goto L_0x0216
        L_0x024a:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0261 }
            if (r0 == 0) goto L_0x025a
            if (r13 <= r7) goto L_0x0253
            goto L_0x025a
        L_0x0253:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x019a
        L_0x025a:
            if (r11 == 0) goto L_0x025f
            r11.close()     // Catch:{ all -> 0x0578 }
        L_0x025f:
            r0 = r12
            goto L_0x028b
        L_0x0261:
            r0 = move-exception
            goto L_0x026f
        L_0x0263:
            r0 = move-exception
            r20 = r4
            goto L_0x026f
        L_0x0267:
            r0 = move-exception
            r9 = 0
            goto L_0x04e5
        L_0x026b:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x026f:
            com.google.android.gms.measurement.internal.x4 r2 = r8.f2527a     // Catch:{ all -> 0x04e3 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x04e3 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x04e3 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ all -> 0x04e3 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x04e3 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04e3 }
            if (r11 == 0) goto L_0x028b
            r11.close()     // Catch:{ all -> 0x0578 }
        L_0x028b:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0578 }
            if (r2 != 0) goto L_0x056b
            com.google.android.gms.measurement.internal.j r2 = r1.U(r6)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.i r3 = com.google.android.gms.measurement.internal.i.AD_STORAGE     // Catch:{ all -> 0x0578 }
            boolean r2 = r2.i(r3)     // Catch:{ all -> 0x0578 }
            if (r2 == 0) goto L_0x02f2
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0578 }
        L_0x02a1:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0578 }
            if (r3 == 0) goto L_0x02c0
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0578 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0578 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.r4 r3 = (c.d.a.b.e.e.r4) r3     // Catch:{ all -> 0x0578 }
            java.lang.String r4 = r3.N()     // Catch:{ all -> 0x0578 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0578 }
            if (r4 != 0) goto L_0x02a1
            java.lang.String r2 = r3.N()     // Catch:{ all -> 0x0578 }
            goto L_0x02c1
        L_0x02c0:
            r2 = 0
        L_0x02c1:
            if (r2 == 0) goto L_0x02f2
            r3 = 0
        L_0x02c4:
            int r4 = r0.size()     // Catch:{ all -> 0x0578 }
            if (r3 >= r4) goto L_0x02f2
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0578 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0578 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.r4 r4 = (c.d.a.b.e.e.r4) r4     // Catch:{ all -> 0x0578 }
            java.lang.String r5 = r4.N()     // Catch:{ all -> 0x0578 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0578 }
            if (r5 == 0) goto L_0x02df
            goto L_0x02ef
        L_0x02df:
            java.lang.String r4 = r4.N()     // Catch:{ all -> 0x0578 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0578 }
            if (r4 != 0) goto L_0x02ef
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0578 }
            goto L_0x02f2
        L_0x02ef:
            int r3 = r3 + 1
            goto L_0x02c4
        L_0x02f2:
            c.d.a.b.e.e.o4 r2 = c.d.a.b.e.e.p4.E()     // Catch:{ all -> 0x0578 }
            int r3 = r0.size()     // Catch:{ all -> 0x0578 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0578 }
            int r5 = r0.size()     // Catch:{ all -> 0x0578 }
            r4.<init>(r5)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h r5 = r22.T()     // Catch:{ all -> 0x0578 }
            boolean r5 = r5.C(r6)     // Catch:{ all -> 0x0578 }
            if (r5 == 0) goto L_0x031b
            com.google.android.gms.measurement.internal.j r5 = r1.U(r6)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.i r7 = com.google.android.gms.measurement.internal.i.AD_STORAGE     // Catch:{ all -> 0x0578 }
            boolean r5 = r5.i(r7)     // Catch:{ all -> 0x0578 }
            if (r5 == 0) goto L_0x031b
            r5 = 1
            goto L_0x031c
        L_0x031b:
            r5 = 0
        L_0x031c:
            com.google.android.gms.measurement.internal.j r7 = r1.U(r6)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.i r8 = com.google.android.gms.measurement.internal.i.AD_STORAGE     // Catch:{ all -> 0x0578 }
            boolean r7 = r7.i(r8)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.j r8 = r1.U(r6)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.i r9 = com.google.android.gms.measurement.internal.i.ANALYTICS_STORAGE     // Catch:{ all -> 0x0578 }
            boolean r8 = r8.i(r9)     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.sd.c()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h r9 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r10 = com.google.android.gms.measurement.internal.y2.i0     // Catch:{ all -> 0x0578 }
            r11 = 0
            boolean r9 = r9.B(r11, r10)     // Catch:{ all -> 0x0578 }
            if (r9 == 0) goto L_0x034e
            com.google.android.gms.measurement.internal.h r9 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r10 = com.google.android.gms.measurement.internal.y2.k0     // Catch:{ all -> 0x0578 }
            boolean r9 = r9.B(r6, r10)     // Catch:{ all -> 0x0578 }
            if (r9 == 0) goto L_0x034e
            r9 = 1
            goto L_0x034f
        L_0x034e:
            r9 = 0
        L_0x034f:
            r10 = 0
        L_0x0350:
            if (r10 >= r3) goto L_0x03ce
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0578 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0578 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.r4 r11 = (c.d.a.b.e.e.r4) r11     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.p8 r11 = r11.B()     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.q4 r11 = (c.d.a.b.e.e.q4) r11     // Catch:{ all -> 0x0578 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0578 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0578 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0578 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0578 }
            r4.add(r12)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h r12 = r22.T()     // Catch:{ all -> 0x0578 }
            r12.q()     // Catch:{ all -> 0x0578 }
            r12 = 74029(0x1212d, double:3.6575E-319)
            r11.d0(r12)     // Catch:{ all -> 0x0578 }
            r12 = r20
            r11.c0(r12)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x4 r14 = r1.l     // Catch:{ all -> 0x0578 }
            r14.e()     // Catch:{ all -> 0x0578 }
            r14 = 0
            r11.Y(r14)     // Catch:{ all -> 0x0578 }
            if (r5 != 0) goto L_0x038f
            r11.A0()     // Catch:{ all -> 0x0578 }
        L_0x038f:
            if (r7 != 0) goto L_0x0397
            r11.H0()     // Catch:{ all -> 0x0578 }
            r11.D0()     // Catch:{ all -> 0x0578 }
        L_0x0397:
            if (r8 != 0) goto L_0x039c
            r11.x0()     // Catch:{ all -> 0x0578 }
        L_0x039c:
            r1.h(r6, r11)     // Catch:{ all -> 0x0578 }
            if (r9 != 0) goto L_0x03a4
            r11.I0()     // Catch:{ all -> 0x0578 }
        L_0x03a4:
            com.google.android.gms.measurement.internal.h r14 = r22.T()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.x2 r15 = com.google.android.gms.measurement.internal.y2.U     // Catch:{ all -> 0x0578 }
            boolean r14 = r14.B(r6, r15)     // Catch:{ all -> 0x0578 }
            if (r14 == 0) goto L_0x03c6
            c.d.a.b.e.e.s8 r14 = r11.n()     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.r4 r14 = (c.d.a.b.e.e.r4) r14     // Catch:{ all -> 0x0578 }
            byte[] r14 = r14.k()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.ea r15 = r1.g     // Catch:{ all -> 0x0578 }
            R(r15)     // Catch:{ all -> 0x0578 }
            long r14 = r15.x(r14)     // Catch:{ all -> 0x0578 }
            r11.B(r14)     // Catch:{ all -> 0x0578 }
        L_0x03c6:
            r2.s(r11)     // Catch:{ all -> 0x0578 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x0350
        L_0x03ce:
            r12 = r20
            com.google.android.gms.measurement.internal.m3 r0 = r22.f()     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = r0.C()     // Catch:{ all -> 0x0578 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0578 }
            if (r0 == 0) goto L_0x03f0
            com.google.android.gms.measurement.internal.ea r0 = r1.g     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.s8 r5 = r2.n()     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.p4 r5 = (c.d.a.b.e.e.p4) r5     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = r0.D(r5)     // Catch:{ all -> 0x0578 }
            r11 = r0
            goto L_0x03f1
        L_0x03f0:
            r11 = 0
        L_0x03f1:
            com.google.android.gms.measurement.internal.ea r0 = r1.g     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.s8 r0 = r2.n()     // Catch:{ all -> 0x0578 }
            c.d.a.b.e.e.p4 r0 = (c.d.a.b.e.e.p4) r0     // Catch:{ all -> 0x0578 }
            byte[] r14 = r0.k()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.r9 r0 = r1.j     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.ca r0 = r0.f2504b     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.p4 r0 = r0.f2342a     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = r0.w(r6)     // Catch:{ all -> 0x0578 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0578 }
            if (r5 != 0) goto L_0x0448
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.q     // Catch:{ all -> 0x0578 }
            r7 = 0
            java.lang.Object r5 = r5.a(r7)     // Catch:{ all -> 0x0578 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0578 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x0578 }
            android.net.Uri$Builder r7 = r5.buildUpon()     // Catch:{ all -> 0x0578 }
            java.lang.String r5 = r5.getAuthority()     // Catch:{ all -> 0x0578 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0578 }
            r8.<init>()     // Catch:{ all -> 0x0578 }
            r8.append(r0)     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = "."
            r8.append(r0)     // Catch:{ all -> 0x0578 }
            r8.append(r5)     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0578 }
            r7.authority(r0)     // Catch:{ all -> 0x0578 }
            android.net.Uri r0 = r7.build()     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0578 }
            goto L_0x0451
        L_0x0448:
            com.google.android.gms.measurement.internal.x2 r0 = com.google.android.gms.measurement.internal.y2.q     // Catch:{ all -> 0x0578 }
            r5 = 0
            java.lang.Object r0 = r0.a(r5)     // Catch:{ all -> 0x0578 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0578 }
        L_0x0451:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04d0 }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x04d0 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04d0 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.n.a(r7)     // Catch:{ MalformedURLException -> 0x04d0 }
            java.util.List r7 = r1.x     // Catch:{ MalformedURLException -> 0x04d0 }
            if (r7 == 0) goto L_0x0471
            com.google.android.gms.measurement.internal.m3 r4 = r22.f()     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()     // Catch:{ MalformedURLException -> 0x04d0 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.a(r7)     // Catch:{ MalformedURLException -> 0x04d0 }
            goto L_0x0478
        L_0x0471:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04d0 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04d0 }
            r1.x = r7     // Catch:{ MalformedURLException -> 0x04d0 }
        L_0x0478:
            com.google.android.gms.measurement.internal.w8 r4 = r1.i     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.x3 r4 = r4.h     // Catch:{ MalformedURLException -> 0x04d0 }
            r4.b(r12)     // Catch:{ MalformedURLException -> 0x04d0 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x048c
            r3 = 0
            c.d.a.b.e.e.r4 r2 = r2.t(r3)     // Catch:{ MalformedURLException -> 0x04d0 }
            java.lang.String r4 = r2.R1()     // Catch:{ MalformedURLException -> 0x04d0 }
        L_0x048c:
            com.google.android.gms.measurement.internal.m3 r2 = r22.f()     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.v()     // Catch:{ MalformedURLException -> 0x04d0 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04d0 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04d0 }
            r2.d(r3, r4, r7, r11)     // Catch:{ MalformedURLException -> 0x04d0 }
            r2 = 1
            r1.t = r2     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.s3 r11 = r1.f2343b     // Catch:{ MalformedURLException -> 0x04d0 }
            R(r11)     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.t9 r2 = new com.google.android.gms.measurement.internal.t9     // Catch:{ MalformedURLException -> 0x04d0 }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04d0 }
            r11.h()     // Catch:{ MalformedURLException -> 0x04d0 }
            r11.i()     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.common.internal.n.i(r5)     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.common.internal.n.i(r14)     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.common.internal.n.i(r2)     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.x4 r3 = r11.f2527a     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.u4 r3 = r3.c()     // Catch:{ MalformedURLException -> 0x04d0 }
            com.google.android.gms.measurement.internal.r3 r4 = new com.google.android.gms.measurement.internal.r3     // Catch:{ MalformedURLException -> 0x04d0 }
            r15 = 0
            r10 = r4
            r12 = r6
            r13 = r5
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04d0 }
            r3.y(r4)     // Catch:{ MalformedURLException -> 0x04d0 }
            goto L_0x056b
        L_0x04d0:
            com.google.android.gms.measurement.internal.m3 r2 = r22.f()     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0578 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ all -> 0x0578 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x0578 }
            goto L_0x056b
        L_0x04e3:
            r0 = move-exception
            r9 = r11
        L_0x04e5:
            if (r9 == 0) goto L_0x04ea
            r9.close()     // Catch:{ all -> 0x0578 }
        L_0x04ea:
            throw r0     // Catch:{ all -> 0x0578 }
        L_0x04eb:
            r12 = r4
            r5 = r9
            r1.z = r7     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0578 }
            R(r2)     // Catch:{ all -> 0x0578 }
            r22.T()     // Catch:{ all -> 0x0578 }
            long r3 = com.google.android.gms.measurement.internal.h.I()     // Catch:{ all -> 0x0578 }
            long r3 = r12 - r3
            r2.h()     // Catch:{ all -> 0x0578 }
            r2.i()     // Catch:{ all -> 0x0578 }
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch:{ SQLiteException -> 0x0542, all -> 0x053f }
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0542, all -> 0x053f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x0542, all -> 0x053f }
            r4 = 0
            r6[r4] = r3     // Catch:{ SQLiteException -> 0x0542, all -> 0x053f }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x0542, all -> 0x053f }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x053d }
            if (r0 != 0) goto L_0x0532
            com.google.android.gms.measurement.internal.x4 r0 = r2.f2527a     // Catch:{ SQLiteException -> 0x053d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x053d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()     // Catch:{ SQLiteException -> 0x053d }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.a(r3)     // Catch:{ SQLiteException -> 0x053d }
            if (r11 == 0) goto L_0x0556
        L_0x052e:
            r11.close()     // Catch:{ all -> 0x0578 }
            goto L_0x0556
        L_0x0532:
            r3 = 0
            java.lang.String r9 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x053d }
            if (r11 == 0) goto L_0x0557
            r11.close()     // Catch:{ all -> 0x0578 }
            goto L_0x0557
        L_0x053d:
            r0 = move-exception
            goto L_0x0544
        L_0x053f:
            r0 = move-exception
            r9 = r5
            goto L_0x0572
        L_0x0542:
            r0 = move-exception
            r11 = r5
        L_0x0544:
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0570 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0570 }
            java.lang.String r3 = "Error selecting expired configs"
            r2.b(r3, r0)     // Catch:{ all -> 0x0570 }
            if (r11 == 0) goto L_0x0556
            goto L_0x052e
        L_0x0556:
            r9 = r5
        L_0x0557:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0578 }
            if (r0 != 0) goto L_0x056b
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x0578 }
            R(r0)     // Catch:{ all -> 0x0578 }
            com.google.android.gms.measurement.internal.h6 r0 = r0.R(r9)     // Catch:{ all -> 0x0578 }
            if (r0 == 0) goto L_0x056b
            r1.i(r0)     // Catch:{ all -> 0x0578 }
        L_0x056b:
            r2 = 0
            r1.u = r2
            goto L_0x0030
        L_0x0570:
            r0 = move-exception
            r9 = r11
        L_0x0572:
            if (r9 == 0) goto L_0x0577
            r9.close()     // Catch:{ all -> 0x0578 }
        L_0x0577:
            throw r0     // Catch:{ all -> 0x0578 }
        L_0x0578:
            r0 = move-exception
            r2 = 0
            r1.u = r2
            r22.K()
            goto L_0x0581
        L_0x0580:
            throw r0
        L_0x0581:
            goto L_0x0580
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.C():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x074b, code lost:
        if (r14.isEmpty() != false) goto L_0x074d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x030f A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0312 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0376 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0506 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0545 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05be A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x060b A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0618 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0625 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x065d A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x066e A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x06ae A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06c9 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0750 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0795 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x07dd A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x07f8 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0883 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x08a1 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0933 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x09de A[Catch:{ SQLiteException -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x09f4  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x093f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0155 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b A[SYNTHETIC, Splitter:B:46:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e9 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02c5 A[Catch:{ NumberFormatException -> 0x0735, all -> 0x0a75 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(com.google.android.gms.measurement.internal.x r35, com.google.android.gms.measurement.internal.qa r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.n.i(r36)
            java.lang.String r8 = r3.j
            com.google.android.gms.common.internal.n.e(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.u4 r10 = r34.c()
            r10.h()
            r34.g()
            java.lang.String r10 = r3.j
            com.google.android.gms.measurement.internal.ea r11 = r1.g
            R(r11)
            boolean r11 = com.google.android.gms.measurement.internal.ea.m(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.q
            if (r11 == 0) goto L_0x0a80
            com.google.android.gms.measurement.internal.p4 r11 = r1.f2342a
            R(r11)
            java.lang.String r12 = r2.j
            boolean r11 = r11.F(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.m3 r3 = r34.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r10)
            com.google.android.gms.measurement.internal.x4 r5 = r1.l
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r6 = r2.j
            java.lang.String r5 = r5.d(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.c(r6, r4, r5)
            com.google.android.gms.measurement.internal.p4 r3 = r1.f2342a
            R(r3)
            boolean r3 = r3.D(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.p4 r3 = r1.f2342a
            R(r3)
            boolean r3 = r3.G(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.j
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.la r11 = r34.g0()
            com.google.android.gms.measurement.internal.ka r12 = r1.E
            r14 = 11
            java.lang.String r2 = r2.j
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.B(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            com.google.android.gms.measurement.internal.h6 r2 = r2.R(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.V()
            long r5 = r2.M()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.d r5 = r34.a()
            long r5 = r5.a()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.T()
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.z
            java.lang.Object r5 = r5.a(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.m3 r3 = r34.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.q()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.a(r4)
            r1.i(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.n3 r2 = com.google.android.gms.measurement.internal.n3.b(r35)
            com.google.android.gms.measurement.internal.la r11 = r34.g0()
            com.google.android.gms.measurement.internal.h r12 = r34.T()
            int r12 = r12.n(r10)
            r11.A(r2, r12)
            com.google.android.gms.measurement.internal.x r2 = r2.a()
            com.google.android.gms.measurement.internal.m3 r11 = r34.f()
            java.lang.String r11 = r11.C()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.m3 r11 = r34.f()
            com.google.android.gms.measurement.internal.k3 r11 = r11.v()
            com.google.android.gms.measurement.internal.x4 r12 = r1.l
            com.google.android.gms.measurement.internal.h3 r12 = r12.D()
            java.lang.String r12 = r12.c(r2)
            java.lang.String r13 = "Logging event"
            r11.b(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c
            R(r11)
            r11.e0()
            r1.S(r3)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x014a
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a75 }
            if (r9 != 0) goto L_0x014a
            java.lang.String r9 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a75 }
            if (r9 == 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            r9 = 0
            goto L_0x014b
        L_0x014a:
            r9 = 1
        L_0x014b:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a75 }
            if (r11 != 0) goto L_0x015f
            if (r9 == 0) goto L_0x0159
            r9 = 1
            goto L_0x015f
        L_0x0159:
            r33 = r4
            r8 = r15
        L_0x015c:
            r4 = 2
            goto L_0x02fc
        L_0x015f:
            com.google.android.gms.measurement.internal.v r11 = r2.k     // Catch:{ all -> 0x0a75 }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.r(r13)     // Catch:{ all -> 0x0a75 }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.v r9 = r2.k     // Catch:{ all -> 0x0a75 }
            java.lang.Double r9 = r9.k(r13)     // Catch:{ all -> 0x0a75 }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a75 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x0195
            com.google.android.gms.measurement.internal.v r9 = r2.k     // Catch:{ all -> 0x0a75 }
            java.lang.Long r9 = r9.l(r13)     // Catch:{ all -> 0x0a75 }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0a75 }
            double r13 = (double) r14
            java.lang.Double.isNaN(r13)
            double r17 = r13 * r19
            goto L_0x0197
        L_0x0195:
            r21 = r15
        L_0x0197:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01b1
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01b1
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a75 }
            if (r9 == 0) goto L_0x01e3
            long r13 = -r13
            goto L_0x01e3
        L_0x01b1:
            com.google.android.gms.measurement.internal.m3 r2 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a75 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            r2.o()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            return
        L_0x01d7:
            r21 = r15
            com.google.android.gms.measurement.internal.v r9 = r2.k     // Catch:{ all -> 0x0a75 }
            java.lang.Long r9 = r9.l(r13)     // Catch:{ all -> 0x0a75 }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a75 }
        L_0x01e3:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a75 }
            if (r9 != 0) goto L_0x02f6
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a75 }
            if (r11 == 0) goto L_0x02f6
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r11)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r11 = r11.X(r10, r9)     // Catch:{ all -> 0x0a75 }
            if (r11 == 0) goto L_0x0241
            java.lang.Object r11 = r11.f2408e     // Catch:{ all -> 0x0a75 }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a75 }
            if (r12 != 0) goto L_0x0213
            goto L_0x0241
        L_0x0213:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a75 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r18 = new com.google.android.gms.measurement.internal.ha     // Catch:{ all -> 0x0a75 }
            java.lang.String r15 = r2.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.util.d r17 = r34.a()     // Catch:{ all -> 0x0a75 }
            long r19 = r17.a()     // Catch:{ all -> 0x0a75 }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a75 }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = 0
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a75 }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02ba
        L_0x0241:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r11)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r12 = r34.T()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r8 = com.google.android.gms.measurement.internal.y2.E     // Catch:{ all -> 0x0a75 }
            int r8 = r12.o(r10, r8)     // Catch:{ all -> 0x0a75 }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.n.e(r10)     // Catch:{ all -> 0x0a75 }
            r11.h()     // Catch:{ all -> 0x0a75 }
            r11.i()     // Catch:{ all -> 0x0a75 }
            android.database.sqlite.SQLiteDatabase r12 = r11.P()     // Catch:{ SQLiteException -> 0x0284 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x0280 }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x0280 }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x0280 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0280 }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x027e }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x027e }
            goto L_0x029e
        L_0x027e:
            r0 = move-exception
            goto L_0x028a
        L_0x0280:
            r0 = move-exception
            r33 = r4
            goto L_0x0289
        L_0x0284:
            r0 = move-exception
            r33 = r4
            r21 = r15
        L_0x0289:
            r4 = 2
        L_0x028a:
            r8 = r0
            com.google.android.gms.measurement.internal.x4 r11 = r11.f2527a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.m3 r11 = r11.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r11 = r11.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            r11.c(r12, r15, r8)     // Catch:{ all -> 0x0a75 }
        L_0x029e:
            com.google.android.gms.measurement.internal.ha r18 = new com.google.android.gms.measurement.internal.ha     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r2.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.util.d r11 = r34.a()     // Catch:{ all -> 0x0a75 }
            long r15 = r11.a()     // Catch:{ all -> 0x0a75 }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a75 }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a75 }
            r9 = r18
        L_0x02ba:
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r11)     // Catch:{ all -> 0x0a75 }
            boolean r11 = r11.x(r9)     // Catch:{ all -> 0x0a75 }
            if (r11 != 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.m3 r11 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r11 = r11.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r14 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h3 r14 = r14.D()     // Catch:{ all -> 0x0a75 }
            java.lang.String r15 = r9.f2406c     // Catch:{ all -> 0x0a75 }
            java.lang.String r14 = r14.f(r15)     // Catch:{ all -> 0x0a75 }
            java.lang.Object r9 = r9.f2408e     // Catch:{ all -> 0x0a75 }
            r11.d(r12, r13, r14, r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.la r11 = r34.g0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ka r12 = r1.E     // Catch:{ all -> 0x0a75 }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.B(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a75 }
            goto L_0x02fc
        L_0x02f6:
            r33 = r4
            r8 = r21
            goto L_0x015c
        L_0x02fc:
            java.lang.String r9 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r9 = com.google.android.gms.measurement.internal.la.X(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a75 }
            r34.g0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.v r11 = r2.k     // Catch:{ all -> 0x0a75 }
            if (r11 != 0) goto L_0x0312
            r16 = 0
            goto L_0x0332
        L_0x0312:
            com.google.android.gms.measurement.internal.u r12 = new com.google.android.gms.measurement.internal.u     // Catch:{ all -> 0x0a75 }
            r12.<init>(r11)     // Catch:{ all -> 0x0a75 }
            r16 = 0
        L_0x0319:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a75 }
            if (r13 == 0) goto L_0x0332
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0a75 }
            java.lang.Object r13 = r11.p(r13)     // Catch:{ all -> 0x0a75 }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a75 }
            if (r14 == 0) goto L_0x0319
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a75 }
            int r13 = r13.length     // Catch:{ all -> 0x0a75 }
            long r13 = (long) r13     // Catch:{ all -> 0x0a75 }
            long r16 = r16 + r13
            goto L_0x0319
        L_0x0332:
            r22 = 1
            long r16 = r16 + r22
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r11)     // Catch:{ all -> 0x0a75 }
            long r12 = r34.F()     // Catch:{ all -> 0x0a75 }
            r20 = 1
            r21 = 0
            r24 = 0
            r30 = r5
            r4 = 0
            r14 = r10
            r15 = r16
            r17 = r20
            r18 = r9
            r19 = r21
            r20 = r8
            r21 = r24
            com.google.android.gms.measurement.internal.l r11 = r11.U(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a75 }
            long r12 = r11.f2439b     // Catch:{ all -> 0x0a75 }
            r34.T()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r14 = com.google.android.gms.measurement.internal.y2.k     // Catch:{ all -> 0x0a75 }
            r15 = 0
            java.lang.Object r14 = r14.a(r15)     // Catch:{ all -> 0x0a75 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a75 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a75 }
            long r4 = (long) r14     // Catch:{ all -> 0x0a75 }
            long r12 = r12 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            r16 = 0
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x03a3
            long r12 = r12 % r4
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0392
            com.google.android.gms.measurement.internal.m3 r2 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            long r5 = r11.f2439b     // Catch:{ all -> 0x0a75 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a75 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0a75 }
        L_0x0392:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            r2.o()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            return
        L_0x03a3:
            if (r9 == 0) goto L_0x0401
            long r12 = r11.f2438a     // Catch:{ all -> 0x0a75 }
            r34.T()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r14 = com.google.android.gms.measurement.internal.y2.m     // Catch:{ all -> 0x0a75 }
            java.lang.Object r14 = r14.a(r15)     // Catch:{ all -> 0x0a75 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a75 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a75 }
            long r4 = (long) r14     // Catch:{ all -> 0x0a75 }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x0401
            r4 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r4
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03dc
            com.google.android.gms.measurement.internal.m3 r3 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            long r6 = r11.f2438a     // Catch:{ all -> 0x0a75 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a75 }
            r3.c(r4, r5, r6)     // Catch:{ all -> 0x0a75 }
        L_0x03dc:
            com.google.android.gms.measurement.internal.la r11 = r34.g0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ka r12 = r1.E     // Catch:{ all -> 0x0a75 }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.j     // Catch:{ all -> 0x0a75 }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.B(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            r2.o()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            return
        L_0x0401:
            r4 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x0451
            long r12 = r11.f2441d     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r5 = r34.T()     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r14 = com.google.android.gms.measurement.internal.y2.l     // Catch:{ all -> 0x0a75 }
            int r5 = r5.o(r8, r14)     // Catch:{ all -> 0x0a75 }
            int r5 = java.lang.Math.min(r4, r5)     // Catch:{ all -> 0x0a75 }
            r8 = 0
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x0a75 }
            long r4 = (long) r5     // Catch:{ all -> 0x0a75 }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x0451
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0440
            com.google.android.gms.measurement.internal.m3 r2 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            long r5 = r11.f2441d     // Catch:{ all -> 0x0a75 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a75 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0a75 }
        L_0x0440:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            r2.o()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            return
        L_0x0451:
            com.google.android.gms.measurement.internal.v r4 = r2.k     // Catch:{ all -> 0x0a75 }
            android.os.Bundle r4 = r4.j()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.la r5 = r34.g0()     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.l     // Catch:{ all -> 0x0a75 }
            r5.C(r4, r11, r12)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.la r5 = r34.g0()     // Catch:{ all -> 0x0a75 }
            boolean r5 = r5.T(r10)     // Catch:{ all -> 0x0a75 }
            java.lang.String r14 = "_r"
            if (r5 == 0) goto L_0x0482
            com.google.android.gms.measurement.internal.la r5 = r34.g0()     // Catch:{ all -> 0x0a75 }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = "_dbg"
            r5.C(r4, r12, r11)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.la r5 = r34.g0()     // Catch:{ all -> 0x0a75 }
            r5.C(r4, r14, r11)     // Catch:{ all -> 0x0a75 }
        L_0x0482:
            java.lang.String r5 = "_s"
            java.lang.String r11 = r2.j     // Catch:{ all -> 0x0a75 }
            boolean r5 = r5.equals(r11)     // Catch:{ all -> 0x0a75 }
            if (r5 == 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r5)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r5 = r5.X(r11, r7)     // Catch:{ all -> 0x0a75 }
            if (r5 == 0) goto L_0x04a8
            java.lang.Object r11 = r5.f2408e     // Catch:{ all -> 0x0a75 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a75 }
            if (r11 == 0) goto L_0x04a8
            com.google.android.gms.measurement.internal.la r11 = r34.g0()     // Catch:{ all -> 0x0a75 }
            java.lang.Object r5 = r5.f2408e     // Catch:{ all -> 0x0a75 }
            r11.C(r4, r7, r5)     // Catch:{ all -> 0x0a75 }
        L_0x04a8:
            com.google.android.gms.measurement.internal.n r5 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r5)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.e(r10)     // Catch:{ all -> 0x0a75 }
            r5.h()     // Catch:{ all -> 0x0a75 }
            r5.i()     // Catch:{ all -> 0x0a75 }
            android.database.sqlite.SQLiteDatabase r7 = r5.P()     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.x4 r11 = r5.f2527a     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.h r11 = r11.z()     // Catch:{ SQLiteException -> 0x04e8 }
            com.google.android.gms.measurement.internal.x2 r12 = com.google.android.gms.measurement.internal.y2.p     // Catch:{ SQLiteException -> 0x04e8 }
            int r11 = r11.o(r10, r12)     // Catch:{ SQLiteException -> 0x04e8 }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r8, r11)     // Catch:{ SQLiteException -> 0x04e8 }
            r13 = 0
            int r8 = java.lang.Math.max(r13, r8)     // Catch:{ SQLiteException -> 0x04e6 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x04e6 }
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x04e6 }
            r11[r13] = r10     // Catch:{ SQLiteException -> 0x04e6 }
            r12 = 1
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x04e6 }
            java.lang.String r8 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r5 = r7.delete(r6, r8, r11)     // Catch:{ SQLiteException -> 0x04e6 }
            long r7 = (long) r5
            goto L_0x0500
        L_0x04e6:
            r0 = move-exception
            goto L_0x04ea
        L_0x04e8:
            r0 = move-exception
            r13 = 0
        L_0x04ea:
            r7 = r0
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            r5.c(r8, r11, r7)     // Catch:{ all -> 0x0a75 }
            r7 = 0
        L_0x0500:
            r11 = 0
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x051b
            com.google.android.gms.measurement.internal.m3 r5 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r5 = r5.w()     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0a75 }
            r5.c(r11, r12, r7)     // Catch:{ all -> 0x0a75 }
        L_0x051b:
            com.google.android.gms.measurement.internal.s r5 = new com.google.android.gms.measurement.internal.s     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r12 = r1.l     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = r2.l     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r2.j     // Catch:{ all -> 0x0a75 }
            long r2 = r2.m     // Catch:{ all -> 0x0a75 }
            r18 = 0
            r11 = r5
            r31 = 0
            r13 = r7
            r7 = r14
            r14 = r10
            r32 = r6
            r6 = r15
            r15 = r8
            r16 = r2
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.x4) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = r5.f2529b     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.t r2 = r2.V(r10, r3)     // Catch:{ all -> 0x0a75 }
            if (r2 != 0) goto L_0x05be
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            long r2 = r2.O(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r4 = r34.T()     // Catch:{ all -> 0x0a75 }
            int r4 = r4.l(r10)     // Catch:{ all -> 0x0a75 }
            long r11 = (long) r4     // Catch:{ all -> 0x0a75 }
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x05a0
            if (r9 == 0) goto L_0x05a0
            com.google.android.gms.measurement.internal.m3 r2 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.m3.z(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r6 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h3 r6 = r6.D()     // Catch:{ all -> 0x0a75 }
            java.lang.String r5 = r5.f2529b     // Catch:{ all -> 0x0a75 }
            java.lang.String r5 = r6.d(r5)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r6 = r34.T()     // Catch:{ all -> 0x0a75 }
            int r6 = r6.l(r10)     // Catch:{ all -> 0x0a75 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a75 }
            r2.d(r3, r4, r5, r6)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.la r11 = r34.g0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ka r12 = r1.E     // Catch:{ all -> 0x0a75 }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.B(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            return
        L_0x05a0:
            com.google.android.gms.measurement.internal.t r2 = new com.google.android.gms.measurement.internal.t     // Catch:{ all -> 0x0a75 }
            java.lang.String r13 = r5.f2529b     // Catch:{ all -> 0x0a75 }
            long r3 = r5.f2531d     // Catch:{ all -> 0x0a75 }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r2
            r12 = r10
            r20 = r3
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a75 }
            goto L_0x05cc
        L_0x05be:
            com.google.android.gms.measurement.internal.x4 r3 = r1.l     // Catch:{ all -> 0x0a75 }
            long r8 = r2.f2545f     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.s r5 = r5.a(r3, r8)     // Catch:{ all -> 0x0a75 }
            long r3 = r5.f2531d     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.t r2 = r2.c(r3)     // Catch:{ all -> 0x0a75 }
        L_0x05cc:
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r3)     // Catch:{ all -> 0x0a75 }
            r3.q(r2)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.u4 r2 = r34.c()     // Catch:{ all -> 0x0a75 }
            r2.h()     // Catch:{ all -> 0x0a75 }
            r34.g()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r5)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r36)     // Catch:{ all -> 0x0a75 }
            java.lang.String r2 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.e(r2)     // Catch:{ all -> 0x0a75 }
            java.lang.String r2 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            r3 = r36
            java.lang.String r4 = r3.j     // Catch:{ all -> 0x0a75 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.a(r2)     // Catch:{ all -> 0x0a75 }
            c.d.a.b.e.e.q4 r2 = c.d.a.b.e.e.r4.N1()     // Catch:{ all -> 0x0a75 }
            r4 = 1
            r2.V(r4)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = "android"
            r2.R(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r3.j     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x0610
            java.lang.String r8 = r3.j     // Catch:{ all -> 0x0a75 }
            r2.v(r8)     // Catch:{ all -> 0x0a75 }
        L_0x0610:
            java.lang.String r8 = r3.m     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x061d
            java.lang.String r8 = r3.m     // Catch:{ all -> 0x0a75 }
            r2.x(r8)     // Catch:{ all -> 0x0a75 }
        L_0x061d:
            java.lang.String r8 = r3.l     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x062a
            java.lang.String r8 = r3.l     // Catch:{ all -> 0x0a75 }
            r2.y(r8)     // Catch:{ all -> 0x0a75 }
        L_0x062a:
            c.d.a.b.e.e.sd.c()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r8 = r34.T()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r9 = com.google.android.gms.measurement.internal.y2.i0     // Catch:{ all -> 0x0a75 }
            boolean r8 = r8.B(r6, r9)     // Catch:{ all -> 0x0a75 }
            if (r8 == 0) goto L_0x0654
            com.google.android.gms.measurement.internal.h r8 = r34.T()     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r10 = com.google.android.gms.measurement.internal.y2.k0     // Catch:{ all -> 0x0a75 }
            boolean r8 = r8.B(r9, r10)     // Catch:{ all -> 0x0a75 }
            if (r8 == 0) goto L_0x0654
            java.lang.String r8 = r3.G     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x0654
            java.lang.String r8 = r3.G     // Catch:{ all -> 0x0a75 }
            r2.Z(r8)     // Catch:{ all -> 0x0a75 }
        L_0x0654:
            long r8 = r3.s     // Catch:{ all -> 0x0a75 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0661
            int r9 = (int) r8     // Catch:{ all -> 0x0a75 }
            r2.z(r9)     // Catch:{ all -> 0x0a75 }
        L_0x0661:
            long r8 = r3.n     // Catch:{ all -> 0x0a75 }
            r2.N(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r3.k     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x0673
            java.lang.String r8 = r3.k     // Catch:{ all -> 0x0a75 }
            r2.M(r8)     // Catch:{ all -> 0x0a75 }
        L_0x0673:
            java.lang.String r8 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r8 = r1.U(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r3.E     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r9 = com.google.android.gms.measurement.internal.j.b(r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r8 = r8.c(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r8.h()     // Catch:{ all -> 0x0a75 }
            r2.D(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r2.i0()     // Catch:{ all -> 0x0a75 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0a75 }
            if (r8 == 0) goto L_0x06a6
            java.lang.String r8 = r3.z     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x06a6
            java.lang.String r8 = r3.z     // Catch:{ all -> 0x0a75 }
            r2.u(r8)     // Catch:{ all -> 0x0a75 }
        L_0x06a6:
            long r8 = r3.o     // Catch:{ all -> 0x0a75 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06b1
            r2.E(r8)     // Catch:{ all -> 0x0a75 }
        L_0x06b1:
            long r8 = r3.B     // Catch:{ all -> 0x0a75 }
            r2.H(r8)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ea r8 = r1.g     // Catch:{ all -> 0x0a75 }
            R(r8)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ca r9 = r8.f2504b     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r9 = r9.l     // Catch:{ all -> 0x0a75 }
            android.content.Context r9 = r9.d()     // Catch:{ all -> 0x0a75 }
            java.util.Map r9 = com.google.android.gms.measurement.internal.y2.c(r9)     // Catch:{ all -> 0x0a75 }
            if (r9 == 0) goto L_0x074d
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x06d1
            goto L_0x074d
        L_0x06d1:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a75 }
            r14.<init>()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r10 = com.google.android.gms.measurement.internal.y2.P     // Catch:{ all -> 0x0a75 }
            java.lang.Object r10 = r10.a(r6)     // Catch:{ all -> 0x0a75 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a75 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a75 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0a75 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a75 }
        L_0x06ea:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0a75 }
            if (r11 == 0) goto L_0x0747
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0a75 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0a75 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0a75 }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0a75 }
            if (r12 == 0) goto L_0x06ea
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0735 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0735 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0735 }
            if (r11 == 0) goto L_0x06ea
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x0735 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x0735 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x0735 }
            if (r11 < r10) goto L_0x06ea
            com.google.android.gms.measurement.internal.x4 r11 = r8.f2527a     // Catch:{ NumberFormatException -> 0x0735 }
            com.google.android.gms.measurement.internal.m3 r11 = r11.f()     // Catch:{ NumberFormatException -> 0x0735 }
            com.google.android.gms.measurement.internal.k3 r11 = r11.w()     // Catch:{ NumberFormatException -> 0x0735 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x0735 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x0735 }
            r11.b(r12, r13)     // Catch:{ NumberFormatException -> 0x0735 }
            goto L_0x0747
        L_0x0735:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.x4 r12 = r8.f2527a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.m3 r12 = r12.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r12 = r12.w()     // Catch:{ all -> 0x0a75 }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.b(r13, r11)     // Catch:{ all -> 0x0a75 }
            goto L_0x06ea
        L_0x0747:
            boolean r8 = r14.isEmpty()     // Catch:{ all -> 0x0a75 }
            if (r8 == 0) goto L_0x074e
        L_0x074d:
            r14 = r6
        L_0x074e:
            if (r14 == 0) goto L_0x0753
            r2.s0(r14)     // Catch:{ all -> 0x0a75 }
        L_0x0753:
            java.lang.String r8 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r8 = r1.U(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r3.E     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r9 = com.google.android.gms.measurement.internal.j.b(r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.j r8 = r8.c(r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.i r9 = com.google.android.gms.measurement.internal.i.AD_STORAGE     // Catch:{ all -> 0x0a75 }
            boolean r10 = r8.i(r9)     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x079e
            boolean r10 = r3.x     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x079e
            com.google.android.gms.measurement.internal.w8 r10 = r1.i     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.j     // Catch:{ all -> 0x0a75 }
            android.util.Pair r10 = r10.n(r11, r8)     // Catch:{ all -> 0x0a75 }
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x0a75 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x0a75 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a75 }
            if (r11 != 0) goto L_0x079e
            boolean r11 = r3.x     // Catch:{ all -> 0x0a75 }
            if (r11 == 0) goto L_0x079e
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0a75 }
            r2.W(r11)     // Catch:{ all -> 0x0a75 }
            java.lang.Object r10 = r10.second     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x079e
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0a75 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0a75 }
            r2.P(r10)     // Catch:{ all -> 0x0a75 }
        L_0x079e:
            com.google.android.gms.measurement.internal.x4 r10 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.r r10 = r10.A()     // Catch:{ all -> 0x0a75 }
            r10.k()     // Catch:{ all -> 0x0a75 }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ all -> 0x0a75 }
            r2.F(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r10 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.r r10 = r10.A()     // Catch:{ all -> 0x0a75 }
            r10.k()     // Catch:{ all -> 0x0a75 }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a75 }
            r2.Q(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r10 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.r r10 = r10.A()     // Catch:{ all -> 0x0a75 }
            long r10 = r10.p()     // Catch:{ all -> 0x0a75 }
            int r11 = (int) r10     // Catch:{ all -> 0x0a75 }
            r2.b0(r11)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r10 = r1.l     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.r r10 = r10.A()     // Catch:{ all -> 0x0a75 }
            java.lang.String r10 = r10.q()     // Catch:{ all -> 0x0a75 }
            r2.f0(r10)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r10 = r1.l     // Catch:{ all -> 0x0a75 }
            boolean r10 = r10.o()     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x07eb
            r2.h0()     // Catch:{ all -> 0x0a75 }
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a75 }
            if (r10 == 0) goto L_0x07e7
            goto L_0x07eb
        L_0x07e7:
            r2.G(r6)     // Catch:{ all -> 0x0a75 }
            throw r6
        L_0x07eb:
            com.google.android.gms.measurement.internal.n r10 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r10)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.j     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h6 r10 = r10.R(r11)     // Catch:{ all -> 0x0a75 }
            if (r10 != 0) goto L_0x085b
            com.google.android.gms.measurement.internal.h6 r10 = new com.google.android.gms.measurement.internal.h6     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x4 r11 = r1.l     // Catch:{ all -> 0x0a75 }
            java.lang.String r12 = r3.j     // Catch:{ all -> 0x0a75 }
            r10.<init>(r11, r12)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r1.h0(r8)     // Catch:{ all -> 0x0a75 }
            r10.h(r11)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.t     // Catch:{ all -> 0x0a75 }
            r10.v(r11)     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.k     // Catch:{ all -> 0x0a75 }
            r10.w(r11)     // Catch:{ all -> 0x0a75 }
            boolean r9 = r8.i(r9)     // Catch:{ all -> 0x0a75 }
            if (r9 == 0) goto L_0x0825
            com.google.android.gms.measurement.internal.w8 r9 = r1.i     // Catch:{ all -> 0x0a75 }
            java.lang.String r11 = r3.j     // Catch:{ all -> 0x0a75 }
            boolean r12 = r3.x     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r9.o(r11, r12)     // Catch:{ all -> 0x0a75 }
            r10.F(r9)     // Catch:{ all -> 0x0a75 }
        L_0x0825:
            r11 = 0
            r10.B(r11)     // Catch:{ all -> 0x0a75 }
            r10.C(r11)     // Catch:{ all -> 0x0a75 }
            r10.z(r11)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r3.l     // Catch:{ all -> 0x0a75 }
            r10.j(r9)     // Catch:{ all -> 0x0a75 }
            long r11 = r3.s     // Catch:{ all -> 0x0a75 }
            r10.k(r11)     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r3.m     // Catch:{ all -> 0x0a75 }
            r10.i(r9)     // Catch:{ all -> 0x0a75 }
            long r11 = r3.n     // Catch:{ all -> 0x0a75 }
            r10.x(r11)     // Catch:{ all -> 0x0a75 }
            long r11 = r3.o     // Catch:{ all -> 0x0a75 }
            r10.s(r11)     // Catch:{ all -> 0x0a75 }
            boolean r9 = r3.q     // Catch:{ all -> 0x0a75 }
            r10.D(r9)     // Catch:{ all -> 0x0a75 }
            long r11 = r3.B     // Catch:{ all -> 0x0a75 }
            r10.t(r11)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r9 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r9)     // Catch:{ all -> 0x0a75 }
            r9.p(r10)     // Catch:{ all -> 0x0a75 }
        L_0x085b:
            com.google.android.gms.measurement.internal.i r9 = com.google.android.gms.measurement.internal.i.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a75 }
            boolean r8 = r8.i(r9)     // Catch:{ all -> 0x0a75 }
            if (r8 == 0) goto L_0x0879
            java.lang.String r8 = r10.e0()     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x0879
            java.lang.String r8 = r10.e0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a75 }
            r2.w(r8)     // Catch:{ all -> 0x0a75 }
        L_0x0879:
            java.lang.String r8 = r10.h0()     // Catch:{ all -> 0x0a75 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a75 }
            if (r8 != 0) goto L_0x088f
            java.lang.String r8 = r10.h0()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a75 }
            r2.L(r8)     // Catch:{ all -> 0x0a75 }
        L_0x088f:
            com.google.android.gms.measurement.internal.n r8 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = r3.j     // Catch:{ all -> 0x0a75 }
            java.util.List r3 = r8.c0(r3)     // Catch:{ all -> 0x0a75 }
            r13 = 0
        L_0x089b:
            int r8 = r3.size()     // Catch:{ all -> 0x0a75 }
            if (r13 >= r8) goto L_0x08d1
            c.d.a.b.e.e.z4 r8 = c.d.a.b.e.e.a5.H()     // Catch:{ all -> 0x0a75 }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r9 = (com.google.android.gms.measurement.internal.ha) r9     // Catch:{ all -> 0x0a75 }
            java.lang.String r9 = r9.f2406c     // Catch:{ all -> 0x0a75 }
            r8.x(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r9 = (com.google.android.gms.measurement.internal.ha) r9     // Catch:{ all -> 0x0a75 }
            long r9 = r9.f2407d     // Catch:{ all -> 0x0a75 }
            r8.y(r9)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ea r9 = r1.g     // Catch:{ all -> 0x0a75 }
            R(r9)     // Catch:{ all -> 0x0a75 }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ha r10 = (com.google.android.gms.measurement.internal.ha) r10     // Catch:{ all -> 0x0a75 }
            java.lang.Object r10 = r10.f2408e     // Catch:{ all -> 0x0a75 }
            r9.K(r8, r10)     // Catch:{ all -> 0x0a75 }
            r2.v0(r8)     // Catch:{ all -> 0x0a75 }
            int r13 = r13 + 1
            goto L_0x089b
        L_0x08d1:
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c     // Catch:{ IOException -> 0x0a2b }
            R(r3)     // Catch:{ IOException -> 0x0a2b }
            c.d.a.b.e.e.s8 r8 = r2.n()     // Catch:{ IOException -> 0x0a2b }
            c.d.a.b.e.e.r4 r8 = (c.d.a.b.e.e.r4) r8     // Catch:{ IOException -> 0x0a2b }
            r3.h()     // Catch:{ IOException -> 0x0a2b }
            r3.i()     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.common.internal.n.i(r8)     // Catch:{ IOException -> 0x0a2b }
            java.lang.String r9 = r8.R1()     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.common.internal.n.e(r9)     // Catch:{ IOException -> 0x0a2b }
            byte[] r9 = r8.k()     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.measurement.internal.ca r10 = r3.f2504b     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.measurement.internal.ea r10 = r10.g     // Catch:{ IOException -> 0x0a2b }
            R(r10)     // Catch:{ IOException -> 0x0a2b }
            long r10 = r10.x(r9)     // Catch:{ IOException -> 0x0a2b }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a2b }
            r12.<init>()     // Catch:{ IOException -> 0x0a2b }
            java.lang.String r13 = r8.R1()     // Catch:{ IOException -> 0x0a2b }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a2b }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a2b }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a2b }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a2b }
            android.database.sqlite.SQLiteDatabase r9 = r3.P()     // Catch:{ SQLiteException -> 0x0a11 }
            java.lang.String r13 = "raw_events_metadata"
            r4 = 4
            r9.insertWithOnConflict(r13, r6, r12, r4)     // Catch:{ SQLiteException -> 0x0a11 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.v r3 = r5.f2533f     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.u r4 = new com.google.android.gms.measurement.internal.u     // Catch:{ all -> 0x0a75 }
            r4.<init>(r3)     // Catch:{ all -> 0x0a75 }
        L_0x092d:
            boolean r3 = r4.hasNext()     // Catch:{ all -> 0x0a75 }
            if (r3 == 0) goto L_0x093f
            java.lang.String r3 = r4.next()     // Catch:{ all -> 0x0a75 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0a75 }
            if (r3 == 0) goto L_0x092d
        L_0x093d:
            r13 = 1
            goto L_0x0980
        L_0x093f:
            com.google.android.gms.measurement.internal.p4 r3 = r1.f2342a     // Catch:{ all -> 0x0a75 }
            R(r3)     // Catch:{ all -> 0x0a75 }
            java.lang.String r4 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = r5.f2529b     // Catch:{ all -> 0x0a75 }
            boolean r3 = r3.E(r4, r7)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r4 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r4)     // Catch:{ all -> 0x0a75 }
            long r17 = r34.F()     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r16 = r4
            r19 = r7
            com.google.android.gms.measurement.internal.l r4 = r16.T(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0a75 }
            if (r3 == 0) goto L_0x097f
            long r3 = r4.f2442e     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.h r7 = r34.T()     // Catch:{ all -> 0x0a75 }
            java.lang.String r8 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.x2 r9 = com.google.android.gms.measurement.internal.y2.o     // Catch:{ all -> 0x0a75 }
            int r7 = r7.o(r8, r9)     // Catch:{ all -> 0x0a75 }
            long r7 = (long) r7     // Catch:{ all -> 0x0a75 }
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x097f
            goto L_0x093d
        L_0x097f:
            r13 = 0
        L_0x0980:
            r2.h()     // Catch:{ all -> 0x0a75 }
            r2.i()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.i(r5)     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.common.internal.n.e(r3)     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ca r3 = r2.f2504b     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.ea r3 = r3.g     // Catch:{ all -> 0x0a75 }
            R(r3)     // Catch:{ all -> 0x0a75 }
            c.d.a.b.e.e.g4 r3 = r3.B(r5)     // Catch:{ all -> 0x0a75 }
            byte[] r3 = r3.k()     // Catch:{ all -> 0x0a75 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0a75 }
            r4.<init>()     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            r4.put(r14, r7)     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.f2529b     // Catch:{ all -> 0x0a75 }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = "timestamp"
            long r8 = r5.f2531d     // Catch:{ all -> 0x0a75 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a75 }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a75 }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a75 }
            r4.put(r15, r7)     // Catch:{ all -> 0x0a75 }
            java.lang.String r7 = "data"
            r4.put(r7, r3)     // Catch:{ all -> 0x0a75 }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0a75 }
            r4.put(r3, r7)     // Catch:{ all -> 0x0a75 }
            android.database.sqlite.SQLiteDatabase r3 = r2.P()     // Catch:{ SQLiteException -> 0x09f9 }
            r7 = r32
            long r3 = r3.insert(r7, r6, r4)     // Catch:{ SQLiteException -> 0x09f9 }
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x09f4
            com.google.android.gms.measurement.internal.x4 r3 = r2.f2527a     // Catch:{ SQLiteException -> 0x09f9 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ SQLiteException -> 0x09f9 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ SQLiteException -> 0x09f9 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.f2528a     // Catch:{ SQLiteException -> 0x09f9 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ SQLiteException -> 0x09f9 }
            r3.b(r4, r6)     // Catch:{ SQLiteException -> 0x09f9 }
            goto L_0x0a42
        L_0x09f4:
            r3 = 0
            r1.o = r3     // Catch:{ all -> 0x0a75 }
            goto L_0x0a42
        L_0x09f9:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.f2528a     // Catch:{ all -> 0x0a75 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.m3.z(r5)     // Catch:{ all -> 0x0a75 }
            r2.c(r4, r5, r3)     // Catch:{ all -> 0x0a75 }
            goto L_0x0a42
        L_0x0a11:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.x4 r3 = r3.f2527a     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ IOException -> 0x0a2b }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ IOException -> 0x0a2b }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.R1()     // Catch:{ IOException -> 0x0a2b }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r6)     // Catch:{ IOException -> 0x0a2b }
            r3.c(r5, r6, r4)     // Catch:{ IOException -> 0x0a2b }
            throw r4     // Catch:{ IOException -> 0x0a2b }
        L_0x0a2b:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.m3 r4 = r34.f()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()     // Catch:{ all -> 0x0a75 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.h0()     // Catch:{ all -> 0x0a75 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r2)     // Catch:{ all -> 0x0a75 }
            r4.c(r5, r2, r3)     // Catch:{ all -> 0x0a75 }
        L_0x0a42:
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c     // Catch:{ all -> 0x0a75 }
            R(r2)     // Catch:{ all -> 0x0a75 }
            r2.o()     // Catch:{ all -> 0x0a75 }
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            r34.M()
            com.google.android.gms.measurement.internal.m3 r2 = r34.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.v()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.b(r4, r3)
            return
        L_0x0a75:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c
            R(r3)
            r3.f0()
            throw r2
        L_0x0a80:
            r1.S(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.D(com.google.android.gms.measurement.internal.x, com.google.android.gms.measurement.internal.qa):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean E() {
        String str;
        k3 k3Var;
        c().h();
        FileLock fileLock = this.v;
        if (fileLock == null || !fileLock.isValid()) {
            this.f2344c.f2527a.z();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.l.d().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.w = channel;
                FileLock tryLock = channel.tryLock();
                this.v = tryLock;
                if (tryLock != null) {
                    f().v().a("Storage concurrent access okay");
                    return true;
                }
                f().r().a("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e2) {
                e = e2;
                k3Var = f().r();
                str = "Failed to acquire storage lock";
                k3Var.b(str, e);
                return false;
            } catch (IOException e3) {
                e = e3;
                k3Var = f().r();
                str = "Failed to access storage lock file";
                k3Var.b(str, e);
                return false;
            } catch (OverlappingFileLockException e4) {
                e = e4;
                k3Var = f().w();
                str = "Storage lock already acquired";
                k3Var.b(str, e);
                return false;
            }
        } else {
            f().v().a("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long F() {
        long a2 = a().a();
        w8 w8Var = this.i;
        w8Var.i();
        w8Var.h();
        long a3 = w8Var.i.a();
        if (a3 == 0) {
            a3 = ((long) w8Var.f2527a.N().u().nextInt(86400000)) + 1;
            w8Var.i.b(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final h6 S(qa qaVar) {
        c().h();
        g();
        n.i(qaVar);
        n.e(qaVar.j);
        if (!qaVar.F.isEmpty()) {
            this.B.put(qaVar.j, new ba(this, qaVar.F));
        }
        n nVar = this.f2344c;
        R(nVar);
        h6 R = nVar.R(qaVar.j);
        j c2 = U(qaVar.j).c(j.b(qaVar.E));
        i iVar = i.AD_STORAGE;
        String o2 = c2.i(iVar) ? this.i.o(qaVar.j, qaVar.x) : "";
        if (R == null) {
            R = new h6(this.l, qaVar.j);
            if (c2.i(i.ANALYTICS_STORAGE)) {
                R.h(h0(c2));
            }
            if (c2.i(iVar)) {
                R.F(o2);
            }
        } else if (c2.i(iVar) && o2 != null && !o2.equals(R.a())) {
            R.F(o2);
            if (qaVar.x && !"00000000-0000-0000-0000-000000000000".equals(this.i.n(qaVar.j, c2).first)) {
                R.h(h0(c2));
                n nVar2 = this.f2344c;
                R(nVar2);
                if (nVar2.X(qaVar.j, "_id") != null) {
                    n nVar3 = this.f2344c;
                    R(nVar3);
                    if (nVar3.X(qaVar.j, "_lair") == null) {
                        ha haVar = new ha(qaVar.j, "auto", "_lair", a().a(), 1L);
                        n nVar4 = this.f2344c;
                        R(nVar4);
                        nVar4.x(haVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(R.e0()) && c2.i(i.ANALYTICS_STORAGE)) {
            R.h(h0(c2));
        }
        R.w(qaVar.k);
        R.f(qaVar.z);
        if (!TextUtils.isEmpty(qaVar.t)) {
            R.v(qaVar.t);
        }
        long j2 = qaVar.n;
        if (j2 != 0) {
            R.x(j2);
        }
        if (!TextUtils.isEmpty(qaVar.l)) {
            R.j(qaVar.l);
        }
        R.k(qaVar.s);
        String str = qaVar.m;
        if (str != null) {
            R.i(str);
        }
        R.s(qaVar.o);
        R.D(qaVar.q);
        if (!TextUtils.isEmpty(qaVar.p)) {
            R.y(qaVar.p);
        }
        R.g(qaVar.x);
        R.E(qaVar.A);
        R.t(qaVar.B);
        sd.c();
        if (T().B((String) null, y2.i0) && T().B(qaVar.j, y2.k0)) {
            R.H(qaVar.G);
        }
        gc.c();
        if (T().B((String) null, y2.h0)) {
            R.G(qaVar.C);
        } else {
            gc.c();
            if (T().B((String) null, y2.g0)) {
                R.G((List) null);
            }
        }
        if (R.K()) {
            n nVar5 = this.f2344c;
            R(nVar5);
            nVar5.p(R);
        }
        return R;
    }

    public final h T() {
        x4 x4Var = this.l;
        n.i(x4Var);
        return x4Var.z();
    }

    /* access modifiers changed from: package-private */
    public final j U(String str) {
        String str2;
        j jVar = j.f2414b;
        c().h();
        g();
        j jVar2 = (j) this.A.get(str);
        if (jVar2 != null) {
            return jVar2;
        }
        n nVar = this.f2344c;
        R(nVar);
        n.i(str);
        nVar.h();
        nVar.i();
        Cursor cursor = null;
        try {
            Cursor rawQuery = nVar.P().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            j b2 = j.b(str2);
            A(str, b2);
            return b2;
        } catch (SQLiteException e2) {
            nVar.f2527a.f().r().c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final n V() {
        n nVar = this.f2344c;
        R(nVar);
        return nVar;
    }

    public final h3 W() {
        return this.l.D();
    }

    public final s3 X() {
        s3 s3Var = this.f2343b;
        R(s3Var);
        return s3Var;
    }

    public final u3 Y() {
        u3 u3Var = this.f2345d;
        if (u3Var != null) {
            return u3Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final p4 Z() {
        p4 p4Var = this.f2342a;
        R(p4Var);
        return p4Var;
    }

    public final d a() {
        x4 x4Var = this.l;
        n.i(x4Var);
        return x4Var.a();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        k3 r2;
        Integer valueOf;
        Integer valueOf2;
        String str;
        c().h();
        g();
        if (!this.n) {
            this.n = true;
            if (E()) {
                FileChannel fileChannel = this.w;
                c().h();
                int i2 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    f().r().a("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i2 = allocate.getInt();
                        } else if (read != -1) {
                            f().w().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e2) {
                        f().r().b("Failed to read from channel", e2);
                    }
                }
                int p2 = this.l.B().p();
                c().h();
                if (i2 > p2) {
                    r2 = f().r();
                    valueOf = Integer.valueOf(i2);
                    valueOf2 = Integer.valueOf(p2);
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (i2 < p2) {
                    FileChannel fileChannel2 = this.w;
                    c().h();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        f().r().a("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(p2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                f().r().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            r2 = f().v();
                            valueOf = Integer.valueOf(i2);
                            valueOf2 = Integer.valueOf(p2);
                            str = "Storage version upgraded. Previous, current version";
                        } catch (IOException e3) {
                            f().r().b("Failed to write to channel", e3);
                        }
                    }
                    r2 = f().r();
                    valueOf = Integer.valueOf(i2);
                    valueOf2 = Integer.valueOf(p2);
                    str = "Storage version upgrade failed. Previous, current version";
                } else {
                    return;
                }
                r2.c(str, valueOf, valueOf2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final x4 b0() {
        return this.l;
    }

    public final u4 c() {
        x4 x4Var = this.l;
        n.i(x4Var);
        return x4Var.c();
    }

    public final k7 c0() {
        k7 k7Var = this.h;
        R(k7Var);
        return k7Var;
    }

    public final Context d() {
        return this.l.d();
    }

    public final w8 d0() {
        return this.i;
    }

    public final c e() {
        throw null;
    }

    public final m3 f() {
        x4 x4Var = this.l;
        n.i(x4Var);
        return x4Var.f();
    }

    public final ea f0() {
        ea eaVar = this.g;
        R(eaVar);
        return eaVar;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (!this.m) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final la g0() {
        x4 x4Var = this.l;
        n.i(x4Var);
        return x4Var.N();
    }

    /* access modifiers changed from: package-private */
    public final void h(String str, q4 q4Var) {
        int w2;
        int indexOf;
        p4 p4Var = this.f2342a;
        R(p4Var);
        Set y2 = p4Var.y(str);
        if (y2 != null) {
            q4Var.t0(y2);
        }
        p4 p4Var2 = this.f2342a;
        R(p4Var2);
        if (p4Var2.J(str)) {
            q4Var.z0();
        }
        p4 p4Var3 = this.f2342a;
        R(p4Var3);
        if (p4Var3.M(str)) {
            if (T().B(str, y2.n0)) {
                String j0 = q4Var.j0();
                if (!TextUtils.isEmpty(j0) && (indexOf = j0.indexOf(".")) != -1) {
                    q4Var.Q(j0.substring(0, indexOf));
                }
            } else {
                q4Var.E0();
            }
        }
        p4 p4Var4 = this.f2342a;
        R(p4Var4);
        if (p4Var4.N(str) && (w2 = ea.w(q4Var, "_id")) != -1) {
            q4Var.t(w2);
        }
        p4 p4Var5 = this.f2342a;
        R(p4Var5);
        if (p4Var5.L(str)) {
            q4Var.A0();
        }
        p4 p4Var6 = this.f2342a;
        R(p4Var6);
        if (p4Var6.I(str)) {
            q4Var.x0();
            ba baVar = (ba) this.B.get(str);
            if (baVar == null || baVar.f2331b + T().r(str, y2.S) < a().b()) {
                baVar = new ba(this);
                this.B.put(str, baVar);
            }
            q4Var.J(baVar.f2330a);
        }
        p4 p4Var7 = this.f2342a;
        R(p4Var7);
        if (p4Var7.K(str)) {
            q4Var.I0();
        }
    }

    /* access modifiers changed from: package-private */
    public final String h0(j jVar) {
        if (!jVar.i(i.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        g0().u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final void i(h6 h6Var) {
        a aVar;
        a aVar2;
        c().h();
        if (!TextUtils.isEmpty(h6Var.i0()) || !TextUtils.isEmpty(h6Var.b0())) {
            r9 r9Var = this.j;
            Uri.Builder builder = new Uri.Builder();
            String i0 = h6Var.i0();
            if (TextUtils.isEmpty(i0)) {
                i0 = h6Var.b0();
            }
            a aVar3 = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) y2.f2641e.a((Object) null)).encodedAuthority((String) y2.f2642f.a((Object) null)).path("config/app/".concat(String.valueOf(i0))).appendQueryParameter("platform", "android");
            r9Var.f2527a.z().q();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String d0 = h6Var.d0();
                n.i(d0);
                String str = d0;
                URL url = new URL(uri);
                f().v().b("Fetching remote configuration", str);
                p4 p4Var = this.f2342a;
                R(p4Var);
                s3 t2 = p4Var.t(str);
                p4 p4Var2 = this.f2342a;
                R(p4Var2);
                String v2 = p4Var2.v(str);
                if (t2 != null) {
                    if (!TextUtils.isEmpty(v2)) {
                        aVar2 = new a();
                        aVar2.put("If-Modified-Since", v2);
                    } else {
                        aVar2 = null;
                    }
                    ld.c();
                    if (T().B((String) null, y2.l0)) {
                        p4 p4Var3 = this.f2342a;
                        R(p4Var3);
                        String u2 = p4Var3.u(str);
                        if (!TextUtils.isEmpty(u2)) {
                            if (aVar2 == null) {
                                aVar2 = new a();
                            }
                            aVar3 = aVar2;
                            aVar3.put("If-None-Match", u2);
                        }
                    }
                    aVar = aVar2;
                    this.s = true;
                    s3 s3Var = this.f2343b;
                    R(s3Var);
                    u9 u9Var = new u9(this);
                    s3Var.h();
                    s3Var.i();
                    n.i(url);
                    n.i(u9Var);
                    s3Var.f2527a.c().y(new r3(s3Var, str, url, (byte[]) null, aVar, u9Var));
                }
                aVar = aVar3;
                this.s = true;
                s3 s3Var2 = this.f2343b;
                R(s3Var2);
                u9 u9Var2 = new u9(this);
                s3Var2.h();
                s3Var2.i();
                n.i(url);
                n.i(u9Var2);
                s3Var2.f2527a.c().y(new r3(s3Var2, str, url, (byte[]) null, aVar, u9Var2));
            } catch (MalformedURLException unused) {
                f().r().c("Failed to parse config URL. Not fetching. appId", m3.z(h6Var.d0()), uri);
            }
        } else {
            String d02 = h6Var.d0();
            n.i(d02);
            n(d02, 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final String i0(qa qaVar) {
        try {
            return (String) c().s(new v9(this, qaVar)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            f().r().c("Failed to get app instance id. appId", m3.z(qaVar.j), e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(x xVar, qa qaVar) {
        x xVar2;
        List<d> list;
        List<d> list2;
        List<d> list3;
        k3 r2;
        String str;
        Object z2;
        String f2;
        Object obj;
        String str2;
        qa qaVar2 = qaVar;
        n.i(qaVar);
        n.e(qaVar2.j);
        c().h();
        g();
        String str3 = qaVar2.j;
        long j2 = xVar.m;
        n3 b2 = n3.b(xVar);
        c().h();
        m7 m7Var = null;
        if (!(this.C == null || (str2 = this.D) == null || !str2.equals(str3))) {
            m7Var = this.C;
        }
        la.y(m7Var, b2.f2483d, false);
        x a2 = b2.a();
        R(this.g);
        if (ea.m(a2, qaVar2)) {
            if (!qaVar2.q) {
                S(qaVar2);
                return;
            }
            List list4 = qaVar2.C;
            if (list4 == null) {
                xVar2 = a2;
            } else if (list4.contains(a2.j)) {
                Bundle j3 = a2.k.j();
                j3.putLong("ga_safelisted", 1);
                xVar2 = new x(a2.j, new v(j3), a2.l, a2.m);
            } else {
                f().q().d("Dropping non-safelisted event. appId, event name, origin", str3, a2.j, a2.l);
                return;
            }
            n nVar = this.f2344c;
            R(nVar);
            nVar.e0();
            try {
                n nVar2 = this.f2344c;
                R(nVar2);
                n.e(str3);
                nVar2.h();
                nVar2.i();
                if (j2 < 0) {
                    nVar2.f2527a.f().w().c("Invalid time querying timed out conditional properties", m3.z(str3), Long.valueOf(j2));
                    list = Collections.emptyList();
                } else {
                    list = nVar2.b0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str3, String.valueOf(j2)});
                }
                for (d dVar : list) {
                    if (dVar != null) {
                        f().v().d("User property timed out", dVar.j, this.l.D().f(dVar.l.k), dVar.l.g());
                        x xVar3 = dVar.p;
                        if (xVar3 != null) {
                            D(new x(xVar3, j2), qaVar2);
                        }
                        n nVar3 = this.f2344c;
                        R(nVar3);
                        nVar3.J(str3, dVar.l.k);
                    }
                }
                n nVar4 = this.f2344c;
                R(nVar4);
                n.e(str3);
                nVar4.h();
                nVar4.i();
                if (j2 < 0) {
                    nVar4.f2527a.f().w().c("Invalid time querying expired conditional properties", m3.z(str3), Long.valueOf(j2));
                    list2 = Collections.emptyList();
                } else {
                    list2 = nVar4.b0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str3, String.valueOf(j2)});
                }
                ArrayList<x> arrayList = new ArrayList<>(list2.size());
                for (d dVar2 : list2) {
                    if (dVar2 != null) {
                        f().v().d("User property expired", dVar2.j, this.l.D().f(dVar2.l.k), dVar2.l.g());
                        n nVar5 = this.f2344c;
                        R(nVar5);
                        nVar5.m(str3, dVar2.l.k);
                        x xVar4 = dVar2.t;
                        if (xVar4 != null) {
                            arrayList.add(xVar4);
                        }
                        n nVar6 = this.f2344c;
                        R(nVar6);
                        nVar6.J(str3, dVar2.l.k);
                    }
                }
                for (x xVar5 : arrayList) {
                    D(new x(xVar5, j2), qaVar2);
                }
                n nVar7 = this.f2344c;
                R(nVar7);
                String str4 = xVar2.j;
                n.e(str3);
                n.e(str4);
                nVar7.h();
                nVar7.i();
                if (j2 < 0) {
                    nVar7.f2527a.f().w().d("Invalid time querying triggered conditional properties", m3.z(str3), nVar7.f2527a.D().d(str4), Long.valueOf(j2));
                    list3 = Collections.emptyList();
                } else {
                    list3 = nVar7.b0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str3, str4, String.valueOf(j2)});
                }
                ArrayList<x> arrayList2 = new ArrayList<>(list3.size());
                for (d dVar3 : list3) {
                    if (dVar3 != null) {
                        fa faVar = dVar3.l;
                        String str5 = dVar3.j;
                        n.i(str5);
                        String str6 = dVar3.k;
                        String str7 = faVar.k;
                        Object g2 = faVar.g();
                        n.i(g2);
                        ha haVar = new ha(str5, str6, str7, j2, g2);
                        n nVar8 = this.f2344c;
                        R(nVar8);
                        if (nVar8.x(haVar)) {
                            r2 = f().v();
                            str = "User property triggered";
                            z2 = dVar3.j;
                            f2 = this.l.D().f(haVar.f2406c);
                            obj = haVar.f2408e;
                        } else {
                            r2 = f().r();
                            str = "Too many active user properties, ignoring";
                            z2 = m3.z(dVar3.j);
                            f2 = this.l.D().f(haVar.f2406c);
                            obj = haVar.f2408e;
                        }
                        r2.d(str, z2, f2, obj);
                        x xVar6 = dVar3.r;
                        if (xVar6 != null) {
                            arrayList2.add(xVar6);
                        }
                        dVar3.l = new fa(haVar);
                        dVar3.n = true;
                        n nVar9 = this.f2344c;
                        R(nVar9);
                        nVar9.w(dVar3);
                    }
                }
                D(xVar2, qaVar2);
                for (x xVar7 : arrayList2) {
                    D(new x(xVar7, j2), qaVar2);
                }
                n nVar10 = this.f2344c;
                R(nVar10);
                nVar10.o();
            } finally {
                n nVar11 = this.f2344c;
                R(nVar11);
                nVar11.f0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(x xVar, String str) {
        x xVar2 = xVar;
        String str2 = str;
        n nVar = this.f2344c;
        R(nVar);
        h6 R = nVar.R(str2);
        if (R == null || TextUtils.isEmpty(R.g0())) {
            f().q().b("No app data available; dropping event", str2);
            return;
        }
        Boolean J = J(R);
        if (J == null) {
            if (!"_ui".equals(xVar2.j)) {
                f().w().b("Could not find package. appId", m3.z(str));
            }
        } else if (!J.booleanValue()) {
            f().r().b("App version does not match; dropping event. appId", m3.z(str));
            return;
        }
        String i0 = R.i0();
        String g0 = R.g0();
        long L = R.L();
        String f0 = R.f0();
        long W = R.W();
        long T = R.T();
        boolean J2 = R.J();
        String h0 = R.h0();
        R.A();
        qa qaVar = r2;
        h6 h6Var = R;
        qa qaVar2 = new qa(str, i0, g0, L, f0, W, T, (String) null, J2, false, h0, 0, 0, 0, h6Var.I(), false, h6Var.b0(), h6Var.a0(), h6Var.U(), h6Var.c(), (String) null, U(str2).h(), "", (String) null);
        l(xVar2, qaVar);
    }

    /* access modifiers changed from: package-private */
    public final void k0(Runnable runnable) {
        c().h();
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void l(x xVar, qa qaVar) {
        n.e(qaVar.j);
        n3 b2 = n3.b(xVar);
        la g0 = g0();
        Bundle bundle = b2.f2483d;
        n nVar = this.f2344c;
        R(nVar);
        g0.z(bundle, nVar.Q(qaVar.j));
        g0().A(b2, T().n(qaVar.j));
        x a2 = b2.a();
        if ("_cmp".equals(a2.j) && "referrer API v2".equals(a2.k.r("_cis"))) {
            String r2 = a2.k.r("gclid");
            if (!TextUtils.isEmpty(r2)) {
                B(new fa("_lgclid", a2.m, r2, "auto"), qaVar);
            }
        }
        j(a2, qaVar);
    }

    /* access modifiers changed from: package-private */
    public final void m() {
        this.r++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105 A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011c A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0139 A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0147 A[Catch:{ all -> 0x0182, all -> 0x018c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.u4 r0 = r8.c()
            r0.h()
            r8.g()
            com.google.android.gms.common.internal.n.e(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x018c }
        L_0x0012:
            com.google.android.gms.measurement.internal.m3 r1 = r8.f()     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()     // Catch:{ all -> 0x018c }
            int r2 = r12.length     // Catch:{ all -> 0x018c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x018c }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.b(r3, r2)     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.n r1 = r8.f2344c     // Catch:{ all -> 0x018c }
            R(r1)     // Catch:{ all -> 0x018c }
            r1.e0()     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.n r1 = r8.f2344c     // Catch:{ all -> 0x0182 }
            R(r1)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.h6 r1 = r1.R(r9)     // Catch:{ all -> 0x0182 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0043
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0043
            if (r10 != r4) goto L_0x0047
            r10 = 304(0x130, float:4.26E-43)
        L_0x0043:
            if (r11 != 0) goto L_0x0047
            r3 = 1
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.m3 r10 = r8.f()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.k3 r10 = r10.w()     // Catch:{ all -> 0x0182 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.m3.z(r9)     // Catch:{ all -> 0x0182 }
            r10.b(r11, r9)     // Catch:{ all -> 0x0182 }
            goto L_0x016c
        L_0x005d:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00bb
            if (r10 != r5) goto L_0x0064
            goto L_0x00bb
        L_0x0064:
            com.google.android.gms.common.util.d r12 = r8.a()     // Catch:{ all -> 0x0182 }
            long r12 = r12.a()     // Catch:{ all -> 0x0182 }
            r1.u(r12)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.n r12 = r8.f2344c     // Catch:{ all -> 0x0182 }
            R(r12)     // Catch:{ all -> 0x0182 }
            r12.p(r1)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.m3 r12 = r8.f()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.k3 r12 = r12.v()     // Catch:{ all -> 0x0182 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0182 }
            r12.c(r13, r1, r11)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.p4 r11 = r8.f2342a     // Catch:{ all -> 0x0182 }
            R(r11)     // Catch:{ all -> 0x0182 }
            r11.z(r9)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.w8 r9 = r8.i     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.x3 r9 = r9.h     // Catch:{ all -> 0x0182 }
            com.google.android.gms.common.util.d r11 = r8.a()     // Catch:{ all -> 0x0182 }
            long r11 = r11.a()     // Catch:{ all -> 0x0182 }
            r9.b(r11)     // Catch:{ all -> 0x0182 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a7
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b6
        L_0x00a7:
            com.google.android.gms.measurement.internal.w8 r9 = r8.i     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.x3 r9 = r9.f2608f     // Catch:{ all -> 0x0182 }
            com.google.android.gms.common.util.d r10 = r8.a()     // Catch:{ all -> 0x0182 }
            long r10 = r10.a()     // Catch:{ all -> 0x0182 }
            r9.b(r10)     // Catch:{ all -> 0x0182 }
        L_0x00b6:
            r8.M()     // Catch:{ all -> 0x0182 }
            goto L_0x016c
        L_0x00bb:
            r11 = 0
            if (r13 == 0) goto L_0x00c7
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r3 = r13.get(r3)     // Catch:{ all -> 0x0182 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0182 }
            goto L_0x00c8
        L_0x00c7:
            r3 = r11
        L_0x00c8:
            if (r3 == 0) goto L_0x00d7
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0182 }
            if (r6 != 0) goto L_0x00d7
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0182 }
            goto L_0x00d8
        L_0x00d7:
            r3 = r11
        L_0x00d8:
            c.d.a.b.e.e.ld.c()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.h r6 = r8.T()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.x2 r7 = com.google.android.gms.measurement.internal.y2.l0     // Catch:{ all -> 0x0182 }
            boolean r6 = r6.B(r11, r7)     // Catch:{ all -> 0x0182 }
            if (r6 == 0) goto L_0x0102
            if (r13 == 0) goto L_0x00f2
            java.lang.String r6 = "ETag"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x0182 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0182 }
            goto L_0x00f3
        L_0x00f2:
            r13 = r11
        L_0x00f3:
            if (r13 == 0) goto L_0x0102
            boolean r6 = r13.isEmpty()     // Catch:{ all -> 0x0182 }
            if (r6 != 0) goto L_0x0102
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0182 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0182 }
            goto L_0x0103
        L_0x0102:
            r13 = r11
        L_0x0103:
            if (r10 == r5) goto L_0x0111
            if (r10 != r4) goto L_0x0108
            goto L_0x0111
        L_0x0108:
            com.google.android.gms.measurement.internal.p4 r11 = r8.f2342a     // Catch:{ all -> 0x0182 }
            R(r11)     // Catch:{ all -> 0x0182 }
            r11.H(r9, r12, r3, r13)     // Catch:{ all -> 0x0182 }
            goto L_0x0124
        L_0x0111:
            com.google.android.gms.measurement.internal.p4 r12 = r8.f2342a     // Catch:{ all -> 0x0182 }
            R(r12)     // Catch:{ all -> 0x0182 }
            c.d.a.b.e.e.s3 r12 = r12.t(r9)     // Catch:{ all -> 0x0182 }
            if (r12 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.p4 r12 = r8.f2342a     // Catch:{ all -> 0x0182 }
            R(r12)     // Catch:{ all -> 0x0182 }
            r12.H(r9, r11, r11, r11)     // Catch:{ all -> 0x0182 }
        L_0x0124:
            com.google.android.gms.common.util.d r11 = r8.a()     // Catch:{ all -> 0x0182 }
            long r11 = r11.a()     // Catch:{ all -> 0x0182 }
            r1.l(r11)     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.n r11 = r8.f2344c     // Catch:{ all -> 0x0182 }
            R(r11)     // Catch:{ all -> 0x0182 }
            r11.p(r1)     // Catch:{ all -> 0x0182 }
            if (r10 != r5) goto L_0x0147
            com.google.android.gms.measurement.internal.m3 r10 = r8.f()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.k3 r10 = r10.x()     // Catch:{ all -> 0x0182 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.b(r11, r9)     // Catch:{ all -> 0x0182 }
            goto L_0x0158
        L_0x0147:
            com.google.android.gms.measurement.internal.m3 r9 = r8.f()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.k3 r9 = r9.v()     // Catch:{ all -> 0x0182 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0182 }
            r9.c(r11, r10, r2)     // Catch:{ all -> 0x0182 }
        L_0x0158:
            com.google.android.gms.measurement.internal.s3 r9 = r8.f2343b     // Catch:{ all -> 0x0182 }
            R(r9)     // Catch:{ all -> 0x0182 }
            boolean r9 = r9.m()     // Catch:{ all -> 0x0182 }
            if (r9 == 0) goto L_0x00b6
            boolean r9 = r8.O()     // Catch:{ all -> 0x0182 }
            if (r9 == 0) goto L_0x00b6
            r8.C()     // Catch:{ all -> 0x0182 }
        L_0x016c:
            com.google.android.gms.measurement.internal.n r9 = r8.f2344c     // Catch:{ all -> 0x0182 }
            R(r9)     // Catch:{ all -> 0x0182 }
            r9.o()     // Catch:{ all -> 0x0182 }
            com.google.android.gms.measurement.internal.n r9 = r8.f2344c     // Catch:{ all -> 0x018c }
            R(r9)     // Catch:{ all -> 0x018c }
            r9.f0()     // Catch:{ all -> 0x018c }
            r8.s = r0
            r8.K()
            return
        L_0x0182:
            r9 = move-exception
            com.google.android.gms.measurement.internal.n r10 = r8.f2344c     // Catch:{ all -> 0x018c }
            R(r10)     // Catch:{ all -> 0x018c }
            r10.f0()     // Catch:{ all -> 0x018c }
            throw r9     // Catch:{ all -> 0x018c }
        L_0x018c:
            r9 = move-exception
            r8.s = r0
            r8.K()
            goto L_0x0194
        L_0x0193:
            throw r9
        L_0x0194:
            goto L_0x0193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.n(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void o(boolean z2) {
        M();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void p(int i2, Throwable th, byte[] bArr, String str) {
        n nVar;
        c().h();
        g();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.t = false;
                K();
                throw th2;
            }
        }
        List list = this.x;
        n.i(list);
        List<Long> list2 = list;
        this.x = null;
        if (i2 != 200) {
            if (i2 == 204) {
                i2 = 204;
            }
            f().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
            this.i.h.b(a().a());
            if (i2 == 503 || i2 == 429) {
                this.i.f2608f.b(a().a());
            }
            n nVar2 = this.f2344c;
            R(nVar2);
            nVar2.g0(list2);
            M();
            this.t = false;
            K();
        }
        if (th == null) {
            try {
                this.i.g.b(a().a());
                this.i.h.b(0);
                M();
                f().v().c("Successful upload. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                n nVar3 = this.f2344c;
                R(nVar3);
                nVar3.e0();
                try {
                    for (Long l2 : list2) {
                        try {
                            nVar = this.f2344c;
                            R(nVar);
                            long longValue = l2.longValue();
                            nVar.h();
                            nVar.i();
                            if (nVar.P().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            nVar.f2527a.f().r().b("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        } catch (SQLiteException e3) {
                            List list3 = this.y;
                            if (list3 == null || !list3.contains(l2)) {
                                throw e3;
                            }
                        }
                    }
                    n nVar4 = this.f2344c;
                    R(nVar4);
                    nVar4.o();
                    n nVar5 = this.f2344c;
                    R(nVar5);
                    nVar5.f0();
                    this.y = null;
                    s3 s3Var = this.f2343b;
                    R(s3Var);
                    if (!s3Var.m() || !O()) {
                        this.z = -1;
                        M();
                    } else {
                        C();
                    }
                    this.o = 0;
                } catch (Throwable th3) {
                    n nVar6 = this.f2344c;
                    R(nVar6);
                    nVar6.f0();
                    throw th3;
                }
            } catch (SQLiteException e4) {
                f().r().b("Database error while trying to delete uploaded bundles", e4);
                this.o = a().b();
                f().v().b("Disable upload, time", Long.valueOf(this.o));
            }
            this.t = false;
            K();
        }
        f().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
        this.i.h.b(a().a());
        this.i.f2608f.b(a().a());
        n nVar22 = this.f2344c;
        R(nVar22);
        nVar22.g0(list2);
        M();
        this.t = false;
        K();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03df A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x040a A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x041f A[SYNTHETIC, Splitter:B:134:0x041f] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04c5 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04e1 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0541 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0141 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0201 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0205 A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x025f A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x026e A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027e A[Catch:{ RuntimeException -> 0x036c, all -> 0x056d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(com.google.android.gms.measurement.internal.qa r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.u4 r8 = r24.c()
            r8.h()
            r24.g()
            com.google.android.gms.common.internal.n.i(r25)
            java.lang.String r8 = r2.j
            com.google.android.gms.common.internal.n.e(r8)
            boolean r8 = Q(r25)
            if (r8 == 0) goto L_0x0577
            com.google.android.gms.measurement.internal.n r8 = r1.f2344c
            R(r8)
            java.lang.String r9 = r2.j
            com.google.android.gms.measurement.internal.h6 r8 = r8.R(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.i0()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.k
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.l(r9)
            com.google.android.gms.measurement.internal.n r11 = r1.f2344c
            R(r11)
            r11.p(r8)
            com.google.android.gms.measurement.internal.p4 r8 = r1.f2342a
            R(r8)
            java.lang.String r11 = r2.j
            r8.A(r11)
        L_0x005e:
            boolean r8 = r2.q
            if (r8 != 0) goto L_0x0066
            r24.S(r25)
            return
        L_0x0066:
            long r11 = r2.v
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.d r8 = r24.a()
            long r11 = r8.a()
        L_0x0074:
            com.google.android.gms.measurement.internal.x4 r8 = r1.l
            com.google.android.gms.measurement.internal.r r8 = r8.A()
            r8.r()
            int r8 = r2.w
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.m3 r13 = r24.f()
            com.google.android.gms.measurement.internal.k3 r13 = r13.w()
            java.lang.String r14 = r2.j
            java.lang.Object r14 = com.google.android.gms.measurement.internal.m3.z(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.c(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.n r9 = r1.f2344c
            R(r9)
            r9.e0()
            com.google.android.gms.measurement.internal.n r9 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r9)     // Catch:{ all -> 0x056d }
            java.lang.String r10 = r2.j     // Catch:{ all -> 0x056d }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.ha r9 = r9.X(r10, r13)     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x00c5
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.f2405b     // Catch:{ all -> 0x056d }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x056d }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r21 = r3
            r22 = r4
            r3 = 0
            r4 = 1
            goto L_0x0119
        L_0x00c5:
            java.lang.Boolean r10 = r2.A     // Catch:{ all -> 0x056d }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.fa r10 = new com.google.android.gms.measurement.internal.fa     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.A     // Catch:{ all -> 0x056d }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x056d }
            if (r15 == r13) goto L_0x00d8
            r19 = 0
            goto L_0x00da
        L_0x00d8:
            r19 = 1
        L_0x00da:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x056d }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r3 = 0
            r4 = 1
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.f2408e     // Catch:{ all -> 0x056d }
            java.lang.Long r13 = r10.m     // Catch:{ all -> 0x056d }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x056d }
            if (r9 != 0) goto L_0x0119
        L_0x00fd:
            r1.B(r10, r2)     // Catch:{ all -> 0x056d }
            goto L_0x0119
        L_0x0101:
            r21 = r3
            r22 = r4
            r3 = 0
            r4 = 1
            if (r9 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.fa r9 = new com.google.android.gms.measurement.internal.fa     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056d }
            r1.u(r9, r2)     // Catch:{ all -> 0x056d }
        L_0x0119:
            com.google.android.gms.measurement.internal.n r9 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r9)     // Catch:{ all -> 0x056d }
            java.lang.String r10 = r2.j     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.internal.n.i(r10)     // Catch:{ all -> 0x056d }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.h6 r9 = r9.R(r10)     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.la r13 = r24.g0()     // Catch:{ all -> 0x056d }
            java.lang.String r14 = r2.k     // Catch:{ all -> 0x056d }
            java.lang.String r15 = r9.i0()     // Catch:{ all -> 0x056d }
            java.lang.String r10 = r2.z     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r9.b0()     // Catch:{ all -> 0x056d }
            boolean r3 = r13.b0(r14, r15, r10, r3)     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.m3 r3 = r24.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()     // Catch:{ all -> 0x056d }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.d0()     // Catch:{ all -> 0x056d }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.m3.z(r13)     // Catch:{ all -> 0x056d }
            r3.b(r10, r13)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.n r3 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r9 = r9.d0()     // Catch:{ all -> 0x056d }
            r3.i()     // Catch:{ all -> 0x056d }
            r3.h()     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.internal.n.e(r9)     // Catch:{ all -> 0x056d }
            android.database.sqlite.SQLiteDatabase r10 = r3.P()     // Catch:{ SQLiteException -> 0x01e9 }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01e9 }
            r14 = 0
            r13[r14] = r9     // Catch:{ SQLiteException -> 0x01e9 }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01e9 }
            int r14 = r14 + r15
            c.d.a.b.e.e.wc.c()     // Catch:{ SQLiteException -> 0x01e9 }
            com.google.android.gms.measurement.internal.x4 r15 = r3.f2527a     // Catch:{ SQLiteException -> 0x01e9 }
            com.google.android.gms.measurement.internal.h r15 = r15.z()     // Catch:{ SQLiteException -> 0x01e9 }
            com.google.android.gms.measurement.internal.x2 r4 = com.google.android.gms.measurement.internal.y2.q0     // Catch:{ SQLiteException -> 0x01e9 }
            r23 = r6
            r6 = 0
            boolean r4 = r15.B(r6, r4)     // Catch:{ SQLiteException -> 0x01e7 }
            if (r4 == 0) goto L_0x01d1
            java.lang.String r4 = "default_event_params"
            int r0 = r10.delete(r4, r0, r13)     // Catch:{ SQLiteException -> 0x01e7 }
            int r14 = r14 + r0
        L_0x01d1:
            if (r14 <= 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.x4 r0 = r3.f2527a     // Catch:{ SQLiteException -> 0x01e7 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ SQLiteException -> 0x01e7 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.v()     // Catch:{ SQLiteException -> 0x01e7 }
            java.lang.String r4 = "Deleted application data. app, records"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01e7 }
            r0.c(r4, r9, r6)     // Catch:{ SQLiteException -> 0x01e7 }
            goto L_0x01ff
        L_0x01e7:
            r0 = move-exception
            goto L_0x01ec
        L_0x01e9:
            r0 = move-exception
            r23 = r6
        L_0x01ec:
            com.google.android.gms.measurement.internal.x4 r3 = r3.f2527a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r3 = r3.r()     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "Error deleting application data. appId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.m3.z(r9)     // Catch:{ all -> 0x056d }
            r3.c(r4, r6, r0)     // Catch:{ all -> 0x056d }
        L_0x01ff:
            r9 = 0
            goto L_0x0203
        L_0x0201:
            r23 = r6
        L_0x0203:
            if (r9 == 0) goto L_0x025a
            long r3 = r9.L()     // Catch:{ all -> 0x056d }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021c
            long r3 = r9.L()     // Catch:{ all -> 0x056d }
            long r13 = r2.s     // Catch:{ all -> 0x056d }
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x021c
            r0 = 1
            goto L_0x021d
        L_0x021c:
            r0 = 0
        L_0x021d:
            java.lang.String r3 = r9.g0()     // Catch:{ all -> 0x056d }
            long r9 = r9.L()     // Catch:{ all -> 0x056d }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0238
            if (r3 == 0) goto L_0x0238
            java.lang.String r4 = r2.l     // Catch:{ all -> 0x056d }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x056d }
            if (r4 != 0) goto L_0x0238
            r15 = 1
            goto L_0x0239
        L_0x0238:
            r15 = 0
        L_0x0239:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x025a
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056d }
            r0.<init>()     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x r3 = new com.google.android.gms.measurement.internal.x     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.v r15 = new com.google.android.gms.measurement.internal.v     // Catch:{ all -> 0x056d }
            r15.<init>(r0)     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056d }
            r1.j(r3, r2)     // Catch:{ all -> 0x056d }
        L_0x025a:
            r24.S(r25)     // Catch:{ all -> 0x056d }
            if (r8 != 0) goto L_0x026e
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r0)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r2.j     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.t r0 = r0.V(r3, r4)     // Catch:{ all -> 0x056d }
            r15 = 0
            goto L_0x027c
        L_0x026e:
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r0)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r2.j     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.t r0 = r0.V(r3, r4)     // Catch:{ all -> 0x056d }
            r15 = 1
        L_0x027c:
            if (r0 != 0) goto L_0x0541
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x04f9
            com.google.android.gms.measurement.internal.fa r0 = new com.google.android.gms.measurement.internal.fa     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056d }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056d }
            r1.B(r0, r2)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.u4 r0 = r24.c()     // Catch:{ all -> 0x056d }
            r0.h()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.e4 r0 = r1.k     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.internal.n.i(r0)     // Catch:{ all -> 0x056d }
            r8 = r0
            com.google.android.gms.measurement.internal.e4 r8 = (com.google.android.gms.measurement.internal.e4) r8     // Catch:{ all -> 0x056d }
            java.lang.String r0 = r2.j     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x039d
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x02bf
            goto L_0x039d
        L_0x02bf:
            com.google.android.gms.measurement.internal.x4 r9 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.u4 r9 = r9.c()     // Catch:{ all -> 0x056d }
            r9.h()     // Catch:{ all -> 0x056d }
            boolean r9 = r8.a()     // Catch:{ all -> 0x056d }
            if (r9 != 0) goto L_0x02df
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.u()     // Catch:{ all -> 0x056d }
            java.lang.String r5 = "Install Referrer Reporter is not available"
        L_0x02da:
            r0.a(r5)     // Catch:{ all -> 0x056d }
            goto L_0x03ab
        L_0x02df:
            com.google.android.gms.measurement.internal.d4 r9 = new com.google.android.gms.measurement.internal.d4     // Catch:{ all -> 0x056d }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.u4 r0 = r0.c()     // Catch:{ all -> 0x056d }
            r0.h()     // Catch:{ all -> 0x056d }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x056d }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x056d }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r13.<init>(r5, r14)     // Catch:{ all -> 0x056d }
            r0.setComponent(r13)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x4 r13 = r8.f2364a     // Catch:{ all -> 0x056d }
            android.content.Context r13 = r13.d()     // Catch:{ all -> 0x056d }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x056d }
            if (r13 != 0) goto L_0x0317
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.y()     // Catch:{ all -> 0x056d }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            goto L_0x02da
        L_0x0317:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r14)     // Catch:{ all -> 0x056d }
            if (r13 == 0) goto L_0x038f
            boolean r15 = r13.isEmpty()     // Catch:{ all -> 0x056d }
            if (r15 != 0) goto L_0x038f
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x056d }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x056d }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x056d }
            if (r13 == 0) goto L_0x03ab
            java.lang.String r14 = r13.packageName     // Catch:{ all -> 0x056d }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x056d }
            if (r13 == 0) goto L_0x0381
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x056d }
            if (r5 == 0) goto L_0x0381
            boolean r5 = r8.a()     // Catch:{ all -> 0x056d }
            if (r5 == 0) goto L_0x0381
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x056d }
            r5.<init>(r0)     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.m.a r0 = com.google.android.gms.common.m.a.b()     // Catch:{ RuntimeException -> 0x036c }
            com.google.android.gms.measurement.internal.x4 r13 = r8.f2364a     // Catch:{ RuntimeException -> 0x036c }
            android.content.Context r13 = r13.d()     // Catch:{ RuntimeException -> 0x036c }
            r14 = 1
            boolean r0 = r0.a(r13, r5, r9, r14)     // Catch:{ RuntimeException -> 0x036c }
            com.google.android.gms.measurement.internal.x4 r5 = r8.f2364a     // Catch:{ RuntimeException -> 0x036c }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ RuntimeException -> 0x036c }
            com.google.android.gms.measurement.internal.k3 r5 = r5.v()     // Catch:{ RuntimeException -> 0x036c }
            java.lang.String r9 = "Install Referrer Service is"
            java.lang.String r13 = "available"
            java.lang.String r14 = "not available"
            r15 = 1
            if (r15 == r0) goto L_0x0368
            r13 = r14
        L_0x0368:
            r5.b(r9, r13)     // Catch:{ RuntimeException -> 0x036c }
            goto L_0x03ab
        L_0x036c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r5 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r5 = r5.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r5 = r5.r()     // Catch:{ all -> 0x056d }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x056d }
            r5.b(r8, r0)     // Catch:{ all -> 0x056d }
            goto L_0x03ab
        L_0x0381:
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.w()     // Catch:{ all -> 0x056d }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            goto L_0x02da
        L_0x038f:
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.u()     // Catch:{ all -> 0x056d }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            goto L_0x02da
        L_0x039d:
            com.google.android.gms.measurement.internal.x4 r0 = r8.f2364a     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.y()     // Catch:{ all -> 0x056d }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            goto L_0x02da
        L_0x03ab:
            com.google.android.gms.measurement.internal.u4 r0 = r24.c()     // Catch:{ all -> 0x056d }
            r0.h()     // Catch:{ all -> 0x056d }
            r24.g()     // Catch:{ all -> 0x056d }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x056d }
            r5.<init>()     // Catch:{ all -> 0x056d }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x056d }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056d }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x056d }
            r6 = r23
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056d }
            r10 = r22
            r5.putLong(r10, r8)     // Catch:{ all -> 0x056d }
            r15 = r21
            r5.putLong(r15, r8)     // Catch:{ all -> 0x056d }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x056d }
            boolean r0 = r2.y     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x03e2
            r5.putLong(r3, r8)     // Catch:{ all -> 0x056d }
        L_0x03e2:
            java.lang.String r0 = r2.j     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.internal.n.i(r0)     // Catch:{ all -> 0x056d }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r0)     // Catch:{ all -> 0x056d }
            com.google.android.gms.common.internal.n.e(r3)     // Catch:{ all -> 0x056d }
            r0.h()     // Catch:{ all -> 0x056d }
            r0.i()     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.L(r3, r4)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x4 r0 = r1.l     // Catch:{ all -> 0x056d }
            android.content.Context r0 = r0.d()     // Catch:{ all -> 0x056d }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x056d }
            if (r0 != 0) goto L_0x041f
            com.google.android.gms.measurement.internal.m3 r0 = r24.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r0 = r0.r()     // Catch:{ all -> 0x056d }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x056d }
            r0.b(r4, r3)     // Catch:{ all -> 0x056d }
        L_0x041b:
            r3 = 0
            goto L_0x04dd
        L_0x041f:
            com.google.android.gms.measurement.internal.x4 r0 = r1.l     // Catch:{ NameNotFoundException -> 0x042f }
            android.content.Context r0 = r0.d()     // Catch:{ NameNotFoundException -> 0x042f }
            com.google.android.gms.common.n.b r0 = com.google.android.gms.common.n.c.a(r0)     // Catch:{ NameNotFoundException -> 0x042f }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.e(r3, r4)     // Catch:{ NameNotFoundException -> 0x042f }
            goto L_0x0442
        L_0x042f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.m3 r4 = r24.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r4 = r4.r()     // Catch:{ all -> 0x056d }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x056d }
            r4.c(r13, r14, r0)     // Catch:{ all -> 0x056d }
            r0 = 0
        L_0x0442:
            if (r0 == 0) goto L_0x0496
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x056d }
            r16 = 0
            int r4 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0496
            r21 = r3
            long r3 = r0.lastUpdateTime     // Catch:{ all -> 0x056d }
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0478
            com.google.android.gms.measurement.internal.h r0 = r24.T()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x2 r3 = com.google.android.gms.measurement.internal.y2.c0     // Catch:{ all -> 0x056d }
            r4 = 0
            boolean r0 = r0.B(r4, r3)     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x0472
            r13 = 0
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0470
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x056d }
            r0 = 0
            r8 = 0
            goto L_0x047a
        L_0x0470:
            r0 = 0
            goto L_0x047a
        L_0x0472:
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x056d }
            goto L_0x0470
        L_0x0478:
            r4 = 0
            r0 = 1
        L_0x047a:
            com.google.android.gms.measurement.internal.fa r3 = new com.google.android.gms.measurement.internal.fa     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_fi"
            r7 = 1
            if (r7 == r0) goto L_0x0484
            r16 = 0
            goto L_0x0486
        L_0x0484:
            r16 = 1
        L_0x0486:
            java.lang.Long r17 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x056d }
            java.lang.String r18 = "auto"
            r13 = r3
            r7 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056d }
            r1.B(r3, r2)     // Catch:{ all -> 0x056d }
            goto L_0x049a
        L_0x0496:
            r21 = r3
            r7 = r15
            r4 = 0
        L_0x049a:
            com.google.android.gms.measurement.internal.x4 r0 = r1.l     // Catch:{ NameNotFoundException -> 0x04ae }
            android.content.Context r0 = r0.d()     // Catch:{ NameNotFoundException -> 0x04ae }
            com.google.android.gms.common.n.b r0 = com.google.android.gms.common.n.c.a(r0)     // Catch:{ NameNotFoundException -> 0x04ae }
            r3 = r21
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.c(r3, r13)     // Catch:{ NameNotFoundException -> 0x04ac }
            goto L_0x04c3
        L_0x04ac:
            r0 = move-exception
            goto L_0x04b1
        L_0x04ae:
            r0 = move-exception
            r3 = r21
        L_0x04b1:
            com.google.android.gms.measurement.internal.m3 r13 = r24.f()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.k3 r13 = r13.r()     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.m3.z(r3)     // Catch:{ all -> 0x056d }
            r13.c(r14, r3, r0)     // Catch:{ all -> 0x056d }
            r0 = r4
        L_0x04c3:
            if (r0 == 0) goto L_0x041b
            int r3 = r0.flags     // Catch:{ all -> 0x056d }
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x04d0
            r3 = 1
            r5.putLong(r10, r3)     // Catch:{ all -> 0x056d }
        L_0x04d0:
            int r0 = r0.flags     // Catch:{ all -> 0x056d }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x041b
            r3 = 1
            r5.putLong(r7, r3)     // Catch:{ all -> 0x056d }
            goto L_0x041b
        L_0x04dd:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04e4
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056d }
        L_0x04e4:
            com.google.android.gms.measurement.internal.x r0 = new com.google.android.gms.measurement.internal.x     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.v r15 = new com.google.android.gms.measurement.internal.v     // Catch:{ all -> 0x056d }
            r15.<init>(r5)     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056d }
            r1.l(r0, r2)     // Catch:{ all -> 0x056d }
            goto L_0x055c
        L_0x04f9:
            com.google.android.gms.measurement.internal.fa r0 = new com.google.android.gms.measurement.internal.fa     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056d }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056d }
            r1.B(r0, r2)     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.u4 r0 = r24.c()     // Catch:{ all -> 0x056d }
            r0.h()     // Catch:{ all -> 0x056d }
            r24.g()     // Catch:{ all -> 0x056d }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056d }
            r0.<init>()     // Catch:{ all -> 0x056d }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x056d }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x056d }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x056d }
            boolean r4 = r2.y     // Catch:{ all -> 0x056d }
            if (r4 == 0) goto L_0x052c
            r0.putLong(r3, r7)     // Catch:{ all -> 0x056d }
        L_0x052c:
            com.google.android.gms.measurement.internal.x r3 = new com.google.android.gms.measurement.internal.x     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.v r15 = new com.google.android.gms.measurement.internal.v     // Catch:{ all -> 0x056d }
            r15.<init>(r0)     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056d }
        L_0x053d:
            r1.l(r3, r2)     // Catch:{ all -> 0x056d }
            goto L_0x055c
        L_0x0541:
            boolean r0 = r2.r     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x055c
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056d }
            r0.<init>()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.x r3 = new com.google.android.gms.measurement.internal.x     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.v r15 = new com.google.android.gms.measurement.internal.v     // Catch:{ all -> 0x056d }
            r15.<init>(r0)     // Catch:{ all -> 0x056d }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056d }
            goto L_0x053d
        L_0x055c:
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c     // Catch:{ all -> 0x056d }
            R(r0)     // Catch:{ all -> 0x056d }
            r0.o()     // Catch:{ all -> 0x056d }
            com.google.android.gms.measurement.internal.n r0 = r1.f2344c
            R(r0)
            r0.f0()
            return
        L_0x056d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n r2 = r1.f2344c
            R(r2)
            r2.f0()
            throw r0
        L_0x0577:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.q(com.google.android.gms.measurement.internal.qa):void");
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.q++;
    }

    /* access modifiers changed from: package-private */
    public final void s(d dVar) {
        String str = dVar.j;
        n.i(str);
        qa I = I(str);
        if (I != null) {
            t(dVar, I);
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(d dVar, qa qaVar) {
        n.i(dVar);
        n.e(dVar.j);
        n.i(dVar.l);
        n.e(dVar.l.k);
        c().h();
        g();
        if (Q(qaVar)) {
            if (qaVar.q) {
                n nVar = this.f2344c;
                R(nVar);
                nVar.e0();
                try {
                    S(qaVar);
                    String str = dVar.j;
                    n.i(str);
                    String str2 = str;
                    n nVar2 = this.f2344c;
                    R(nVar2);
                    d S = nVar2.S(str2, dVar.l.k);
                    if (S != null) {
                        f().q().c("Removing conditional user property", dVar.j, this.l.D().f(dVar.l.k));
                        n nVar3 = this.f2344c;
                        R(nVar3);
                        nVar3.J(str2, dVar.l.k);
                        if (S.n) {
                            n nVar4 = this.f2344c;
                            R(nVar4);
                            nVar4.m(str2, dVar.l.k);
                        }
                        x xVar = dVar.t;
                        if (xVar != null) {
                            v vVar = xVar.k;
                            Bundle j2 = vVar != null ? vVar.j() : null;
                            la g0 = g0();
                            x xVar2 = dVar.t;
                            n.i(xVar2);
                            x w0 = g0.w0(str2, xVar2.j, j2, S.k, dVar.t.m, true, true);
                            n.i(w0);
                            D(w0, qaVar);
                        }
                    } else {
                        f().w().c("Conditional user property doesn't exist", m3.z(dVar.j), this.l.D().f(dVar.l.k));
                    }
                    n nVar5 = this.f2344c;
                    R(nVar5);
                    nVar5.o();
                } finally {
                    n nVar6 = this.f2344c;
                    R(nVar6);
                    nVar6.f0();
                }
            } else {
                S(qaVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(fa faVar, qa qaVar) {
        c().h();
        g();
        if (Q(qaVar)) {
            if (!qaVar.q) {
                S(qaVar);
            } else if (!"_npa".equals(faVar.k) || qaVar.A == null) {
                f().q().b("Removing user property", this.l.D().f(faVar.k));
                n nVar = this.f2344c;
                R(nVar);
                nVar.e0();
                try {
                    S(qaVar);
                    if ("_id".equals(faVar.k)) {
                        n nVar2 = this.f2344c;
                        R(nVar2);
                        String str = qaVar.j;
                        n.i(str);
                        nVar2.m(str, "_lair");
                    }
                    n nVar3 = this.f2344c;
                    R(nVar3);
                    String str2 = qaVar.j;
                    n.i(str2);
                    nVar3.m(str2, faVar.k);
                    n nVar4 = this.f2344c;
                    R(nVar4);
                    nVar4.o();
                    f().q().b("User property removed", this.l.D().f(faVar.k));
                } finally {
                    n nVar5 = this.f2344c;
                    R(nVar5);
                    nVar5.f0();
                }
            } else {
                f().q().a("Falling back to manifest metadata value for ad personalization");
                B(new fa("_npa", a().a(), Long.valueOf(true != qaVar.A.booleanValue() ? 0 : 1), "auto"), qaVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(qa qaVar) {
        if (this.x != null) {
            ArrayList arrayList = new ArrayList();
            this.y = arrayList;
            arrayList.addAll(this.x);
        }
        n nVar = this.f2344c;
        R(nVar);
        String str = qaVar.j;
        n.i(str);
        String str2 = str;
        n.e(str2);
        nVar.h();
        nVar.i();
        try {
            SQLiteDatabase P = nVar.P();
            String[] strArr = {str2};
            int delete = P.delete("apps", "app_id=?", strArr) + P.delete("events", "app_id=?", strArr) + P.delete("user_attributes", "app_id=?", strArr) + P.delete("conditional_properties", "app_id=?", strArr) + P.delete("raw_events", "app_id=?", strArr) + P.delete("raw_events_metadata", "app_id=?", strArr) + P.delete("queue", "app_id=?", strArr) + P.delete("audience_filter_values", "app_id=?", strArr) + P.delete("main_event_params", "app_id=?", strArr) + P.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                nVar.f2527a.f().v().c("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            nVar.f2527a.f().r().c("Error resetting analytics data. appId, error", m3.z(str2), e2);
        }
        if (qaVar.q) {
            q(qaVar);
        }
    }

    public final void w(String str, m7 m7Var) {
        c().h();
        String str2 = this.D;
        if (str2 == null || str2.equals(str) || m7Var != null) {
            this.D = str;
            this.C = m7Var;
        }
    }

    /* access modifiers changed from: protected */
    public final void x() {
        c().h();
        n nVar = this.f2344c;
        R(nVar);
        nVar.h0();
        if (this.i.g.a() == 0) {
            this.i.g.b(a().a());
        }
        M();
    }

    /* access modifiers changed from: package-private */
    public final void y(d dVar) {
        String str = dVar.j;
        n.i(str);
        qa I = I(str);
        if (I != null) {
            z(dVar, I);
        }
    }

    /* access modifiers changed from: package-private */
    public final void z(d dVar, qa qaVar) {
        k3 r2;
        String str;
        Object z2;
        String f2;
        Object g2;
        k3 r3;
        String str2;
        Object z3;
        String f3;
        Object obj;
        n.i(dVar);
        n.e(dVar.j);
        n.i(dVar.k);
        n.i(dVar.l);
        n.e(dVar.l.k);
        c().h();
        g();
        if (Q(qaVar)) {
            if (!qaVar.q) {
                S(qaVar);
                return;
            }
            d dVar2 = new d(dVar);
            boolean z4 = false;
            dVar2.n = false;
            n nVar = this.f2344c;
            R(nVar);
            nVar.e0();
            try {
                n nVar2 = this.f2344c;
                R(nVar2);
                String str3 = dVar2.j;
                n.i(str3);
                d S = nVar2.S(str3, dVar2.l.k);
                if (S != null && !S.k.equals(dVar2.k)) {
                    f().w().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.l.D().f(dVar2.l.k), dVar2.k, S.k);
                }
                if (S != null && S.n) {
                    dVar2.k = S.k;
                    dVar2.m = S.m;
                    dVar2.q = S.q;
                    dVar2.o = S.o;
                    dVar2.r = S.r;
                    dVar2.n = true;
                    fa faVar = dVar2.l;
                    dVar2.l = new fa(faVar.k, S.l.l, faVar.g(), S.l.o);
                } else if (TextUtils.isEmpty(dVar2.o)) {
                    fa faVar2 = dVar2.l;
                    dVar2.l = new fa(faVar2.k, dVar2.m, faVar2.g(), dVar2.l.o);
                    dVar2.n = true;
                    z4 = true;
                }
                if (dVar2.n) {
                    fa faVar3 = dVar2.l;
                    String str4 = dVar2.j;
                    n.i(str4);
                    String str5 = dVar2.k;
                    String str6 = faVar3.k;
                    long j2 = faVar3.l;
                    Object g3 = faVar3.g();
                    n.i(g3);
                    ha haVar = new ha(str4, str5, str6, j2, g3);
                    n nVar3 = this.f2344c;
                    R(nVar3);
                    if (nVar3.x(haVar)) {
                        r3 = f().q();
                        str2 = "User property updated immediately";
                        z3 = dVar2.j;
                        f3 = this.l.D().f(haVar.f2406c);
                        obj = haVar.f2408e;
                    } else {
                        r3 = f().r();
                        str2 = "(2)Too many active user properties, ignoring";
                        z3 = m3.z(dVar2.j);
                        f3 = this.l.D().f(haVar.f2406c);
                        obj = haVar.f2408e;
                    }
                    r3.d(str2, z3, f3, obj);
                    if (z4 && dVar2.r != null) {
                        D(new x(dVar2.r, dVar2.m), qaVar);
                    }
                }
                n nVar4 = this.f2344c;
                R(nVar4);
                if (nVar4.w(dVar2)) {
                    r2 = f().q();
                    str = "Conditional property added";
                    z2 = dVar2.j;
                    f2 = this.l.D().f(dVar2.l.k);
                    g2 = dVar2.l.g();
                } else {
                    r2 = f().r();
                    str = "Too many conditional properties, ignoring";
                    z2 = m3.z(dVar2.j);
                    f2 = this.l.D().f(dVar2.l.k);
                    g2 = dVar2.l.g();
                }
                r2.d(str, z2, f2, g2);
                n nVar5 = this.f2344c;
                R(nVar5);
                nVar5.o();
            } finally {
                n nVar6 = this.f2344c;
                R(nVar6);
                nVar6.f0();
            }
        }
    }
}
