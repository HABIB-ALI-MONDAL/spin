package b.d.h;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.c.f;
import b.d.e.j;
import b.d.h.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final b.c.e<String, Typeface> f578a = new b.c.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final c f579b = new c("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f580c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final b.c.g<String, ArrayList<c.d<g>>> f581d = new b.c.g<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f582e = new d();

    static class a implements Callable<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f583a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f584b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f585c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f586d;

        a(Context context, a aVar, int i, String str) {
            this.f583a = context;
            this.f584b = aVar;
            this.f585c = i;
            this.f586d = str;
        }

        /* renamed from: a */
        public g call() {
            g f2 = b.f(this.f583a, this.f584b, this.f585c);
            Typeface typeface = f2.f597a;
            if (typeface != null) {
                b.f578a.d(this.f586d, typeface);
            }
            return f2;
        }
    }

    /* renamed from: b.d.h.b$b  reason: collision with other inner class name */
    static class C0023b implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f588b;

        C0023b(f.a aVar, Handler handler) {
            this.f587a = aVar;
            this.f588b = handler;
        }

        /* renamed from: b */
        public void a(g gVar) {
            int i;
            f.a aVar;
            if (gVar == null) {
                aVar = this.f587a;
                i = 1;
            } else {
                i = gVar.f598b;
                if (i == 0) {
                    this.f587a.b(gVar.f597a, this.f588b);
                    return;
                }
                aVar = this.f587a;
            }
            aVar.a(i, this.f588b);
        }
    }

    static class c implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f589a;

        c(String str) {
            this.f589a = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (r0 >= r2.size()) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
            ((b.d.h.c.d) r2.get(r0)).a(r5);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0 = 0;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(b.d.h.b.g r5) {
            /*
                r4 = this;
                java.lang.Object r0 = b.d.h.b.f580c
                monitor-enter(r0)
                b.c.g<java.lang.String, java.util.ArrayList<b.d.h.c$d<b.d.h.b$g>>> r1 = b.d.h.b.f581d     // Catch:{ all -> 0x002b }
                java.lang.String r2 = r4.f589a     // Catch:{ all -> 0x002b }
                java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
                if (r2 != 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0011:
                java.lang.String r3 = r4.f589a     // Catch:{ all -> 0x002b }
                r1.remove(r3)     // Catch:{ all -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                r0 = 0
            L_0x0018:
                int r1 = r2.size()
                if (r0 >= r1) goto L_0x002a
                java.lang.Object r1 = r2.get(r0)
                b.d.h.c$d r1 = (b.d.h.c.d) r1
                r1.a(r5)
                int r0 = r0 + 1
                goto L_0x0018
            L_0x002a:
                return
            L_0x002b:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                goto L_0x002f
            L_0x002e:
                throw r5
            L_0x002f:
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.h.b.c.a(b.d.h.b$g):void");
        }
    }

    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(byte[] r5, byte[] r6) {
            /*
                r4 = this;
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x0008
                int r5 = r5.length
                int r6 = r6.length
            L_0x0006:
                int r5 = r5 - r6
                return r5
            L_0x0008:
                r0 = 0
                r1 = 0
            L_0x000a:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001b
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x0018
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x0006
            L_0x0018:
                int r1 = r1 + 1
                goto L_0x000a
            L_0x001b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.d.h.b.d.compare(byte[], byte[]):int");
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f590a;

        /* renamed from: b  reason: collision with root package name */
        private final f[] f591b;

        public e(int i, f[] fVarArr) {
            this.f590a = i;
            this.f591b = fVarArr;
        }

        public f[] a() {
            return this.f591b;
        }

        public int b() {
            return this.f590a;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f592a;

        /* renamed from: b  reason: collision with root package name */
        private final int f593b;

        /* renamed from: c  reason: collision with root package name */
        private final int f594c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f595d;

        /* renamed from: e  reason: collision with root package name */
        private final int f596e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            b.d.j.g.b(uri);
            this.f592a = uri;
            this.f593b = i;
            this.f594c = i2;
            this.f595d = z;
            this.f596e = i3;
        }

        public int a() {
            return this.f596e;
        }

        public int b() {
            return this.f593b;
        }

        public Uri c() {
            return this.f592a;
        }

        public int d() {
            return this.f594c;
        }

        public boolean e() {
            return this.f595d;
        }
    }

    private static final class g {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f597a;

        /* renamed from: b  reason: collision with root package name */
        final int f598b;

        g(Typeface typeface, int i) {
            this.f597a = typeface;
            this.f598b = i;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, a aVar) {
        ProviderInfo h = h(context.getPackageManager(), aVar, context.getResources());
        return h == null ? new e(1, (f[]) null) : new e(0, e(context, aVar, h.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(a aVar, Resources resources) {
        return aVar.a() != null ? aVar.a() : androidx.core.content.c.c.c(resources, aVar.b());
    }

    static f[] e(Context context, a aVar, String str, CancellationSignal cancellationSignal) {
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, (String) null, cancellationSignal) : context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, (String) null);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, a aVar, int i) {
        try {
            e c2 = c(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (c2.b() == 0) {
                Typeface a2 = b.d.e.c.a(context, (CancellationSignal) null, c2.a(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new g(a2, i2);
            }
            if (c2.b() == 1) {
                i2 = -2;
            }
            return new g((Typeface) null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g((Typeface) null, -1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        f579b.d(r1, new b.d.h.b.c(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface g(android.content.Context r2, b.d.h.a r3, androidx.core.content.c.f.a r4, android.os.Handler r5, boolean r6, int r7, int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.c()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            b.c.e<java.lang.String, android.graphics.Typeface> r1 = f578a
            java.lang.Object r1 = r1.c(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0027
            r4.d(r1)
        L_0x0027:
            return r1
        L_0x0028:
            if (r6 == 0) goto L_0x0043
            r1 = -1
            if (r7 != r1) goto L_0x0043
            b.d.h.b$g r2 = f(r2, r3, r8)
            if (r4 == 0) goto L_0x0040
            int r3 = r2.f598b
            if (r3 != 0) goto L_0x003d
            android.graphics.Typeface r3 = r2.f597a
            r4.b(r3, r5)
            goto L_0x0040
        L_0x003d:
            r4.a(r3, r5)
        L_0x0040:
            android.graphics.Typeface r2 = r2.f597a
            return r2
        L_0x0043:
            b.d.h.b$a r1 = new b.d.h.b$a
            r1.<init>(r2, r3, r8, r0)
            r2 = 0
            if (r6 == 0) goto L_0x0056
            b.d.h.c r3 = f579b     // Catch:{ InterruptedException -> 0x0055 }
            java.lang.Object r3 = r3.e(r1, r7)     // Catch:{ InterruptedException -> 0x0055 }
            b.d.h.b$g r3 = (b.d.h.b.g) r3     // Catch:{ InterruptedException -> 0x0055 }
            android.graphics.Typeface r2 = r3.f597a     // Catch:{ InterruptedException -> 0x0055 }
        L_0x0055:
            return r2
        L_0x0056:
            if (r4 != 0) goto L_0x005a
            r3 = r2
            goto L_0x005f
        L_0x005a:
            b.d.h.b$b r3 = new b.d.h.b$b
            r3.<init>(r4, r5)
        L_0x005f:
            java.lang.Object r4 = f580c
            monitor-enter(r4)
            b.c.g<java.lang.String, java.util.ArrayList<b.d.h.c$d<b.d.h.b$g>>> r5 = f581d     // Catch:{ all -> 0x008c }
            java.lang.Object r6 = r5.get(r0)     // Catch:{ all -> 0x008c }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x008c }
            if (r6 == 0) goto L_0x0073
            if (r3 == 0) goto L_0x0071
            r6.add(r3)     // Catch:{ all -> 0x008c }
        L_0x0071:
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            return r2
        L_0x0073:
            if (r3 == 0) goto L_0x0080
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x008c }
            r6.<init>()     // Catch:{ all -> 0x008c }
            r6.add(r3)     // Catch:{ all -> 0x008c }
            r5.put(r0, r6)     // Catch:{ all -> 0x008c }
        L_0x0080:
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            b.d.h.c r3 = f579b
            b.d.h.b$c r4 = new b.d.h.b$c
            r4.<init>(r0)
            r3.d(r1, r4)
            return r2
        L_0x008c:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.h.b.g(android.content.Context, b.d.h.a, androidx.core.content.c.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    public static ProviderInfo h(PackageManager packageManager, a aVar, Resources resources) {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
        } else if (resolveContentProvider.packageName.equals(aVar.e())) {
            List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f582e);
            List<List<byte[]>> d3 = d(aVar, resources);
            for (int i = 0; i < d3.size(); i++) {
                ArrayList arrayList = new ArrayList(d3.get(i));
                Collections.sort(arrayList, f582e);
                if (b(a2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, j.f(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
