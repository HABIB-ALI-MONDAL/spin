package f.a.a.e;

import android.app.Activity;
import android.text.TextUtils;
import f.a.a.d.e;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3116a = {"onPickFromCapture", "onPickFromCaptureWithCrop", "onPickMultiple", "onPickMultipleWithCrop", "onPickFromDocuments", "onPickFromDocumentsWithCrop", "onPickFromGallery", "onPickFromGalleryWithCrop", "onCrop"};

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3117a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                f.a.a.e.b$c[] r0 = f.a.a.e.b.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3117a = r0
                f.a.a.e.b$c r1 = f.a.a.e.b.c.DENIED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3117a     // Catch:{ NoSuchFieldError -> 0x001d }
                f.a.a.e.b$c r1 = f.a.a.e.b.c.ONLY_CAMERA_DENIED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3117a     // Catch:{ NoSuchFieldError -> 0x0028 }
                f.a.a.e.b$c r1 = f.a.a.e.b.c.ONLY_STORAGE_DENIED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3117a     // Catch:{ NoSuchFieldError -> 0x0033 }
                f.a.a.e.b$c r1 = f.a.a.e.b.c.GRANTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a.a.e.b.a.<clinit>():void");
        }
    }

    /* renamed from: f.a.a.e.b$b  reason: collision with other inner class name */
    public enum C0083b {
        STORAGE("android.permission.WRITE_EXTERNAL_STORAGE"),
        CAMERA("android.permission.CAMERA");
        
        String j;

        private C0083b(String str) {
            this.j = str;
        }

        public String d() {
            return this.j;
        }
    }

    public enum c {
        GRANTED("已授权"),
        DENIED("未授权"),
        WAIT("等待授权"),
        NOT_NEED("无需授权"),
        ONLY_CAMERA_DENIED("没有拍照权限"),
        ONLY_STORAGE_DENIED("没有读写SD卡权限");

        private c(String str) {
        }
    }

    public static c a(e eVar, Method method) {
        boolean z;
        String name = method.getName();
        int length = f3116a.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (TextUtils.equals(name, f3116a[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return c.NOT_NEED;
        }
        Activity a2 = eVar.a();
        C0083b bVar = C0083b.STORAGE;
        boolean z3 = androidx.core.content.a.a(a2, bVar.d()) == 0;
        boolean z4 = (!TextUtils.equals(name, "onPickFromCapture") && !TextUtils.equals(name, "onPickFromCaptureWithCrop")) || androidx.core.content.a.a(eVar.a(), C0083b.CAMERA.d()) == 0;
        if (z3 && z4) {
            z2 = true;
        }
        if (!z2) {
            ArrayList arrayList = new ArrayList();
            if (!z3) {
                arrayList.add(bVar.d());
            }
            if (!z4) {
                arrayList.add(C0083b.CAMERA.d());
            }
            d(eVar, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return z2 ? c.GRANTED : c.WAIT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.app.Activity r3, f.a.a.e.b.c r4, f.a.a.d.b r5, f.a.a.b.a.C0080a r6) {
        /*
            int[] r0 = f.a.a.e.b.a.f3117a
            int r4 = r4.ordinal()
            r4 = r0[r4]
            r0 = 1
            r1 = 0
            if (r4 == r0) goto L_0x0039
            r2 = 2
            if (r4 == r2) goto L_0x0032
            r2 = 3
            if (r4 == r2) goto L_0x002b
            r2 = 4
            if (r4 == r2) goto L_0x0016
            goto L_0x0047
        L_0x0016:
            java.lang.reflect.Method r4 = r5.b()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object r2 = r5.c()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object[] r5 = r5.a()     // Catch:{ Exception -> 0x0026 }
            r4.invoke(r2, r5)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0047
        L_0x0026:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0039
        L_0x002b:
            android.content.res.Resources r4 = r3.getResources()
            int r5 = f.a.a.a.tip_permission_storage
            goto L_0x003f
        L_0x0032:
            android.content.res.Resources r4 = r3.getResources()
            int r5 = f.a.a.a.tip_permission_camera
            goto L_0x003f
        L_0x0039:
            android.content.res.Resources r4 = r3.getResources()
            int r5 = f.a.a.a.tip_permission_camera_storage
        L_0x003f:
            java.lang.String r4 = r4.getString(r5)
            r6.takeFail(r1, r4)
            r1 = r4
        L_0x0047:
            if (r1 == 0) goto L_0x0050
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r1, r0)
            r3.show()
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.e.b.b(android.app.Activity, f.a.a.e.b$c, f.a.a.d.b, f.a.a.b.a$a):void");
    }

    public static c c(int i, String[] strArr, int[] iArr) {
        if (i == 2000) {
            int length = strArr.length;
            boolean z = true;
            boolean z2 = true;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    if (TextUtils.equals(C0083b.STORAGE.d(), strArr[i2])) {
                        z2 = false;
                    } else if (TextUtils.equals(C0083b.CAMERA.d(), strArr[i2])) {
                        z = false;
                    }
                }
            }
            if (z && z2) {
                return c.GRANTED;
            }
            if (!z && z2) {
                return c.ONLY_CAMERA_DENIED;
            }
            if (!z2 && z) {
                return c.ONLY_STORAGE_DENIED;
            }
            if (!z2 && !z) {
                return c.DENIED;
            }
        }
        return c.WAIT;
    }

    public static void d(e eVar, String[] strArr) {
        if (eVar.b() != null) {
            eVar.b().U0(strArr, 2000);
        } else {
            androidx.core.app.a.m(eVar.a(), strArr, 2000);
        }
    }
}
