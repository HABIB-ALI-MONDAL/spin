package f.a.a.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import f.a.a.b.a;
import f.a.a.c.b;
import f.a.a.d.d;
import f.a.a.d.e;
import f.a.a.d.f;
import f.a.a.d.h;
import f.a.a.d.i;
import f.a.a.d.j;
import f.a.a.d.k;
import f.a.a.e.b;
import f.a.a.f.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class c implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public e f3078a;

    /* renamed from: b  reason: collision with root package name */
    private a.C0080a f3079b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f3080c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f3081d;

    /* renamed from: e  reason: collision with root package name */
    private f.a.a.d.a f3082e;

    /* renamed from: f  reason: collision with root package name */
    private k f3083f;
    /* access modifiers changed from: private */
    public f.a.a.c.a g;
    private d h;
    private b.c i;
    private h.a j;
    private boolean k;
    /* access modifiers changed from: private */
    public ProgressDialog l;

    class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f3084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f3085b;

        a(j jVar, String[] strArr) {
            this.f3084a = jVar;
            this.f3085b = strArr;
        }

        public void a(ArrayList<h> arrayList) {
            if (!c.this.g.g()) {
                c.this.q(arrayList);
            }
            c.this.r(this.f3084a, new String[0]);
            if (c.this.l != null && !c.this.f3078a.a().isFinishing()) {
                c.this.l.dismiss();
            }
        }

        public void b(ArrayList<h> arrayList, String str) {
            if (!c.this.g.g()) {
                c.this.q(arrayList);
            }
            c cVar = c.this;
            j c2 = j.c(arrayList);
            String[] strArr = new String[1];
            String string = c.this.f3078a.a().getResources().getString(f.a.a.a.tip_compress_failed);
            Object[] objArr = new Object[3];
            String[] strArr2 = this.f3085b;
            objArr[0] = strArr2.length > 0 ? strArr2[0] : "";
            objArr[1] = str;
            objArr[2] = this.f3084a.a().a();
            strArr[0] = String.format(string, objArr);
            cVar.r(c2, strArr);
            if (c.this.l != null && !c.this.f3078a.a().isFinishing()) {
                c.this.l.dismiss();
            }
        }
    }

    public c(Activity activity, a.C0080a aVar) {
        this.f3078a = e.c(activity);
        this.f3079b = aVar;
    }

    private void n() {
        this.g = null;
        this.f3083f = null;
        this.f3082e = null;
        this.h = null;
    }

    private void o(boolean z) {
        Map e2 = this.h.e(this.f3080c, z);
        int intValue = ((Integer) e2.get("index")).intValue();
        if (!((Boolean) e2.get("isLast")).booleanValue()) {
            int i2 = intValue + 1;
            p(this.h.b().get(i2), this.h.a().get(i2), this.f3082e);
        } else if (z) {
            w(j.c(this.h.c()), new String[0]);
        } else {
            j c2 = j.c(this.h.c());
            w(c2, this.f3080c.getPath() + this.f3078a.a().getResources().getString(f.a.a.a.msg_crop_canceled));
        }
    }

    private void p(Uri uri, Uri uri2, f.a.a.d.a aVar) {
        this.f3080c = uri2;
        if (aVar.e()) {
            g.d(this.f3078a, uri, uri2, aVar);
        } else {
            g.c(this.f3078a, uri, uri2, aVar);
        }
    }

    /* access modifiers changed from: private */
    public void q(ArrayList<h> arrayList) {
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (h.a.CAMERA == this.j) {
                f.a.a.f.d.a(next.b());
                next.i("");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[EDGE_INSN: B:26:0x004b->B:19:0x004b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r(f.a.a.d.j r3, java.lang.String... r4) {
        /*
            r2 = this;
            int r0 = r4.length
            r1 = 0
            if (r0 <= 0) goto L_0x000c
            f.a.a.b.a$a r0 = r2.f3079b
            r4 = r4[r1]
            r0.takeFail(r3, r4)
            goto L_0x0061
        L_0x000c:
            f.a.a.d.d r4 = r2.h
            if (r4 == 0) goto L_0x002a
            boolean r4 = r4.f3108d
            if (r4 == 0) goto L_0x002a
            f.a.a.b.a$a r4 = r2.f3079b
            f.a.a.d.e r0 = r2.f3078a
            android.app.Activity r0 = r0.a()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = f.a.a.a.msg_crop_failed
            java.lang.String r0 = r0.getString(r1)
        L_0x0026:
            r4.takeFail(r3, r0)
            goto L_0x0061
        L_0x002a:
            f.a.a.c.a r4 = r2.g
            if (r4 == 0) goto L_0x005c
            java.util.ArrayList r4 = r3.b()
            java.util.Iterator r4 = r4.iterator()
        L_0x0036:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x004b
            java.lang.Object r0 = r4.next()
            f.a.a.d.h r0 = (f.a.a.d.h) r0
            if (r0 == 0) goto L_0x004a
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0036
        L_0x004a:
            r1 = 1
        L_0x004b:
            if (r1 == 0) goto L_0x005c
            f.a.a.b.a$a r4 = r2.f3079b
            f.a.a.d.e r0 = r2.f3078a
            android.app.Activity r0 = r0.a()
            int r1 = f.a.a.a.msg_compress_failed
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0026
        L_0x005c:
            f.a.a.b.a$a r4 = r2.f3079b
            r4.takeSuccess(r3)
        L_0x0061:
            r2.n()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.b.c.r(f.a.a.d.j, java.lang.String[]):void");
    }

    private void v(int i2, boolean z) {
        this.j = h.a.OTHER;
        k kVar = this.f3083f;
        if (kVar != null && kVar.b()) {
            u(1);
        } else if (!b.c.WAIT.equals(this.i)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i(f.a.a.f.b.c(), z ? 1005 : 1004));
            arrayList.add(new i(f.a.a.f.b.d(), z ? 1007 : 1006));
            try {
                g.h(this.f3078a, arrayList, i2, z);
            } catch (f e2) {
                w(j.d(h.e("", this.j)), e2.a());
                e2.printStackTrace();
            }
        }
    }

    private void w(j jVar, String... strArr) {
        if (this.g == null) {
            r(jVar, strArr);
            return;
        }
        if (this.k) {
            this.l = g.i(this.f3078a.a(), this.f3078a.a().getResources().getString(f.a.a.a.tip_compress));
        }
        f.a.a.c.c.f(this.f3078a.a(), this.g, jVar.b(), new a(jVar, strArr)).a();
    }

    public void a(Uri uri, f.a.a.d.a aVar) {
        this.j = h.a.CAMERA;
        if (!b.c.WAIT.equals(this.i)) {
            this.f3082e = aVar;
            this.f3080c = uri;
            if (Build.VERSION.SDK_INT >= 23) {
                uri = f.a.a.f.f.e(this.f3078a.a());
            }
            this.f3081d = uri;
            try {
                g.a(this.f3078a, new i(f.a.a.f.b.a(this.f3081d), 1002));
            } catch (f e2) {
                w(j.d(h.e("", this.j)), e2.a());
                e2.printStackTrace();
            }
        }
    }

    public void b(Uri uri) {
        this.j = h.a.CAMERA;
        if (!b.c.WAIT.equals(this.i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                uri = f.a.a.f.f.a(this.f3078a.a(), uri);
            }
            this.f3080c = uri;
            try {
                g.a(this.f3078a, new i(f.a.a.f.b.a(this.f3080c), 1003));
            } catch (f e2) {
                w(j.d(h.e("", this.j)), e2.a());
                e2.printStackTrace();
            }
        }
    }

    public void c(k kVar) {
        this.f3083f = kVar;
    }

    public void d(Uri uri, f.a.a.d.a aVar) {
        this.f3082e = aVar;
        this.f3080c = uri;
        v(1, true);
    }

    public void e(f.a.a.c.a aVar, boolean z) {
        this.g = aVar;
        this.k = z;
    }

    public void f(b.c cVar) {
        this.i = cVar;
    }

    public void g() {
        v(1, false);
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.f3082e = (f.a.a.d.a) bundle.getSerializable("cropOptions");
            this.f3083f = (k) bundle.getSerializable("takePhotoOptions");
            this.k = bundle.getBoolean("showCompressDialog");
            this.f3080c = (Uri) bundle.getParcelable("outPutUri");
            this.f3081d = (Uri) bundle.getParcelable("tempUri");
            this.g = (f.a.a.c.a) bundle.getSerializable("compressConfig");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0248, code lost:
        if (r5 != null) goto L_0x024a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 6709(0x1a35, float:9.401E-42)
            r1 = -1
            r2 = 1
            r3 = 0
            if (r5 == r0) goto L_0x01c6
            switch(r5) {
                case 1001: goto L_0x01c6;
                case 1002: goto L_0x016c;
                case 1003: goto L_0x011b;
                case 1004: goto L_0x00dd;
                case 1005: goto L_0x00b5;
                case 1006: goto L_0x0079;
                case 1007: goto L_0x004e;
                case 1008: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x024d
        L_0x000c:
            if (r6 != r1) goto L_0x01bf
            if (r7 == 0) goto L_0x01bf
            java.lang.String r5 = "images"
            java.util.ArrayList r5 = r7.getParcelableArrayListExtra(r5)
            f.a.a.d.a r6 = r4.f3082e
            if (r6 == 0) goto L_0x003d
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x0037 }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x0037 }
            java.util.ArrayList r5 = f.a.a.f.g.b(r6, r5)     // Catch:{ f -> 0x0037 }
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x0037 }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x0037 }
            f.a.a.d.h$a r7 = r4.j     // Catch:{ f -> 0x0037 }
            f.a.a.d.d r5 = f.a.a.d.d.d(r5, r6, r7)     // Catch:{ f -> 0x0037 }
            f.a.a.d.a r6 = r4.f3082e     // Catch:{ f -> 0x0037 }
            r4.t(r5, r6)     // Catch:{ f -> 0x0037 }
            goto L_0x024d
        L_0x0037:
            r5 = move-exception
            r4.o(r3)
            goto L_0x0116
        L_0x003d:
            f.a.a.d.h$a r6 = r4.j
            java.util.ArrayList r5 = f.a.a.f.g.e(r5, r6)
            f.a.a.d.j r5 = f.a.a.d.j.c(r5)
            java.lang.String[] r6 = new java.lang.String[r3]
            r4.w(r5, r6)
            goto L_0x024d
        L_0x004e:
            if (r6 != r1) goto L_0x01bf
            if (r7 == 0) goto L_0x01bf
            android.net.Uri r5 = r7.getData()     // Catch:{ f -> 0x005f }
            android.net.Uri r6 = r4.f3080c     // Catch:{ f -> 0x005f }
            f.a.a.d.a r7 = r4.f3082e     // Catch:{ f -> 0x005f }
            r4.s(r5, r6, r7)     // Catch:{ f -> 0x005f }
            goto L_0x024d
        L_0x005f:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x0079:
            if (r6 != r1) goto L_0x01bf
            android.net.Uri r5 = r7.getData()     // Catch:{ f -> 0x009a }
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x009a }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x009a }
            java.lang.String r5 = f.a.a.f.f.c(r5, r6)     // Catch:{ f -> 0x009a }
            f.a.a.d.h$a r6 = r4.j     // Catch:{ f -> 0x009a }
            f.a.a.d.h r5 = f.a.a.d.h.e(r5, r6)     // Catch:{ f -> 0x009a }
            f.a.a.d.j r5 = f.a.a.d.j.d(r5)     // Catch:{ f -> 0x009a }
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ f -> 0x009a }
            r4.w(r5, r6)     // Catch:{ f -> 0x009a }
            goto L_0x024d
        L_0x009a:
            r5 = move-exception
            android.net.Uri r6 = r7.getData()
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x00b5:
            if (r6 != r1) goto L_0x01bf
            android.net.Uri r5 = r7.getData()     // Catch:{ f -> 0x00c4 }
            android.net.Uri r6 = r4.f3080c     // Catch:{ f -> 0x00c4 }
            f.a.a.d.a r7 = r4.f3082e     // Catch:{ f -> 0x00c4 }
            r4.s(r5, r6, r7)     // Catch:{ f -> 0x00c4 }
            goto L_0x024d
        L_0x00c4:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x00dd:
            if (r6 != r1) goto L_0x01bf
            android.net.Uri r5 = r7.getData()     // Catch:{ f -> 0x00fe }
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x00fe }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x00fe }
            java.lang.String r5 = f.a.a.f.f.b(r5, r6)     // Catch:{ f -> 0x00fe }
            f.a.a.d.h$a r6 = r4.j     // Catch:{ f -> 0x00fe }
            f.a.a.d.h r5 = f.a.a.d.h.e(r5, r6)     // Catch:{ f -> 0x00fe }
            f.a.a.d.j r5 = f.a.a.d.j.d(r5)     // Catch:{ f -> 0x00fe }
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ f -> 0x00fe }
            r4.w(r5, r6)     // Catch:{ f -> 0x00fe }
            goto L_0x024d
        L_0x00fe:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
        L_0x0116:
            r5.printStackTrace()
            goto L_0x024d
        L_0x011b:
            if (r6 != r1) goto L_0x01bf
            f.a.a.d.k r5 = r4.f3083f
            if (r5 == 0) goto L_0x0136
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x0136
            f.a.a.f.a r5 = f.a.a.f.a.c()
            f.a.a.d.e r6 = r4.f3078a
            android.app.Activity r6 = r6.a()
            android.net.Uri r7 = r4.f3080c
            r5.a(r6, r7)
        L_0x0136:
            android.net.Uri r5 = r4.f3080c     // Catch:{ f -> 0x0153 }
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x0153 }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x0153 }
            java.lang.String r5 = f.a.a.f.f.c(r5, r6)     // Catch:{ f -> 0x0153 }
            f.a.a.d.h$a r6 = r4.j     // Catch:{ f -> 0x0153 }
            f.a.a.d.h r5 = f.a.a.d.h.e(r5, r6)     // Catch:{ f -> 0x0153 }
            f.a.a.d.j r5 = f.a.a.d.j.d(r5)     // Catch:{ f -> 0x0153 }
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ f -> 0x0153 }
            r4.w(r5, r6)     // Catch:{ f -> 0x0153 }
            goto L_0x024d
        L_0x0153:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x016c:
            if (r6 != r1) goto L_0x01bf
            f.a.a.d.k r5 = r4.f3083f
            if (r5 == 0) goto L_0x0187
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x0187
            f.a.a.f.a r5 = f.a.a.f.a.c()
            f.a.a.d.e r6 = r4.f3078a
            android.app.Activity r6 = r6.a()
            android.net.Uri r7 = r4.f3081d
            r5.a(r6, r7)
        L_0x0187:
            android.net.Uri r5 = r4.f3081d     // Catch:{ f -> 0x01a5 }
            java.io.File r6 = new java.io.File     // Catch:{ f -> 0x01a5 }
            f.a.a.d.e r7 = r4.f3078a     // Catch:{ f -> 0x01a5 }
            android.app.Activity r7 = r7.a()     // Catch:{ f -> 0x01a5 }
            android.net.Uri r0 = r4.f3080c     // Catch:{ f -> 0x01a5 }
            java.lang.String r7 = f.a.a.f.f.g(r7, r0)     // Catch:{ f -> 0x01a5 }
            r6.<init>(r7)     // Catch:{ f -> 0x01a5 }
            android.net.Uri r6 = android.net.Uri.fromFile(r6)     // Catch:{ f -> 0x01a5 }
            f.a.a.d.a r7 = r4.f3082e     // Catch:{ f -> 0x01a5 }
            r4.s(r5, r6, r7)     // Catch:{ f -> 0x01a5 }
            goto L_0x024d
        L_0x01a5:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.d(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x01bf:
            f.a.a.b.a$a r5 = r4.f3079b
            r5.takeCancel()
            goto L_0x024d
        L_0x01c6:
            f.a.a.d.d r5 = r4.h
            if (r6 != r1) goto L_0x020e
            if (r5 == 0) goto L_0x01d1
        L_0x01cc:
            r4.o(r2)
            goto L_0x024d
        L_0x01d1:
            android.net.Uri r5 = r4.f3080c     // Catch:{ f -> 0x01f0 }
            f.a.a.d.e r6 = r4.f3078a     // Catch:{ f -> 0x01f0 }
            android.app.Activity r6 = r6.a()     // Catch:{ f -> 0x01f0 }
            java.lang.String r5 = f.a.a.f.f.c(r5, r6)     // Catch:{ f -> 0x01f0 }
            f.a.a.d.h$a r6 = r4.j     // Catch:{ f -> 0x01f0 }
            f.a.a.d.h r5 = f.a.a.d.h.e(r5, r6)     // Catch:{ f -> 0x01f0 }
            r5.h(r2)     // Catch:{ f -> 0x01f0 }
            f.a.a.d.j r5 = f.a.a.d.j.d(r5)     // Catch:{ f -> 0x01f0 }
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ f -> 0x01f0 }
            r4.w(r5, r6)     // Catch:{ f -> 0x01f0 }
            goto L_0x024d
        L_0x01f0:
            r5 = move-exception
            android.net.Uri r6 = r4.f3080c
            java.lang.String r6 = r6.getPath()
            f.a.a.d.h$a r7 = r4.j
            f.a.a.d.h r6 = f.a.a.d.h.e(r6, r7)
            f.a.a.d.j r6 = f.a.a.d.j.d(r6)
            java.lang.String[] r7 = new java.lang.String[r2]
            java.lang.String r0 = r5.a()
            r7[r3] = r0
            r4.w(r6, r7)
            goto L_0x0116
        L_0x020e:
            if (r6 != 0) goto L_0x0248
            java.lang.String r6 = "data"
            if (r5 == 0) goto L_0x0222
            if (r7 == 0) goto L_0x024a
            android.os.Parcelable r5 = r7.getParcelableExtra(r6)
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            android.net.Uri r6 = r4.f3080c
            f.a.a.f.e.f(r5, r6)
            goto L_0x01cc
        L_0x0222:
            if (r7 == 0) goto L_0x01bf
            android.os.Parcelable r5 = r7.getParcelableExtra(r6)
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            android.net.Uri r6 = r4.f3080c
            f.a.a.f.e.f(r5, r6)
            android.net.Uri r5 = r4.f3080c
            java.lang.String r5 = r5.getPath()
            f.a.a.d.h$a r6 = r4.j
            f.a.a.d.h r5 = f.a.a.d.h.e(r5, r6)
            r5.h(r2)
            f.a.a.d.j r5 = f.a.a.d.j.d(r5)
            java.lang.String[] r6 = new java.lang.String[r3]
            r4.w(r5, r6)
            goto L_0x024d
        L_0x0248:
            if (r5 == 0) goto L_0x01bf
        L_0x024a:
            r4.o(r3)
        L_0x024d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.b.c.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("cropOptions", this.f3082e);
        bundle.putSerializable("takePhotoOptions", this.f3083f);
        bundle.putBoolean("showCompressDialog", this.k);
        bundle.putParcelable("outPutUri", this.f3080c);
        bundle.putParcelable("tempUri", this.f3081d);
        bundle.putSerializable("compressConfig", this.g);
    }

    public void s(Uri uri, Uri uri2, f.a.a.d.a aVar) {
        if (!b.c.WAIT.equals(this.i)) {
            this.f3080c = uri2;
            if (f.a.a.f.e.a(this.f3078a.a(), f.a.a.f.e.b(this.f3078a.a(), uri))) {
                p(uri, uri2, aVar);
            } else {
                Toast.makeText(this.f3078a.a(), this.f3078a.a().getResources().getText(f.a.a.a.tip_type_not_image), 0).show();
                throw new f(f.a.a.d.g.TYPE_NOT_IMAGE);
            }
        }
    }

    public void t(d dVar, f.a.a.d.a aVar) {
        this.h = dVar;
        s(dVar.b().get(0), dVar.a().get(0), aVar);
    }

    public void u(int i2) {
        if (!b.c.WAIT.equals(this.i)) {
            e eVar = this.f3078a;
            g.j(eVar, new i(f.a.a.f.b.e(eVar, i2), 1008));
        }
    }
}
