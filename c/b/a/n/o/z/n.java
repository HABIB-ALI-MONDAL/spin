package c.b.a.n.o.z;

import android.graphics.Bitmap;
import android.os.Build;
import c.b.a.t.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class n implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f1040d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f1041e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f1042f = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] g = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] h = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    private final c f1043a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final h<b, Bitmap> f1044b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f1045c = new HashMap();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1046a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1046a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1046a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1046a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1046a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.o.z.n.a.<clinit>():void");
        }
    }

    static final class b implements m {

        /* renamed from: a  reason: collision with root package name */
        private final c f1047a;

        /* renamed from: b  reason: collision with root package name */
        int f1048b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f1049c;

        public b(c cVar) {
            this.f1047a = cVar;
        }

        public void a() {
            this.f1047a.c(this);
        }

        public void b(int i, Bitmap.Config config) {
            this.f1048b = i;
            this.f1049c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1048b == bVar.f1048b && i.c(this.f1049c, bVar.f1049c);
        }

        public int hashCode() {
            int i = this.f1048b * 31;
            Bitmap.Config config = this.f1049c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.i(this.f1048b, this.f1049c);
        }
    }

    static class c extends d<b> {
        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i, Bitmap.Config config) {
            b bVar = (b) b();
            bVar.b(i, config);
            return bVar;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f1040d = configArr;
        f1041e = configArr;
    }

    private void g(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> k = k(bitmap.getConfig());
        Integer num2 = (Integer) k.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + f(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            k.remove(num);
        } else {
            k.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b h(int i, Bitmap.Config config) {
        b e2 = this.f1043a.e(i, config);
        Bitmap.Config[] j = j(config);
        int length = j.length;
        int i2 = 0;
        while (i2 < length) {
            Bitmap.Config config2 = j[i2];
            Integer ceilingKey = k(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey == null || ceilingKey.intValue() > i * 8) {
                i2++;
            } else {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return e2;
                        }
                    } else if (config2.equals(config)) {
                        return e2;
                    }
                }
                this.f1043a.c(e2);
                return this.f1043a.e(ceilingKey.intValue(), config2);
            }
        }
        return e2;
    }

    static String i(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f1041e;
        }
        int i = a.f1046a[config.ordinal()];
        if (i == 1) {
            return f1040d;
        }
        if (i == 2) {
            return f1042f;
        }
        if (i == 3) {
            return g;
        }
        if (i == 4) {
            return h;
        }
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f1045c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f1045c.put(config, treeMap);
        return treeMap;
    }

    public int a(Bitmap bitmap) {
        return i.g(bitmap);
    }

    public Bitmap b() {
        Bitmap f2 = this.f1044b.f();
        if (f2 != null) {
            g(Integer.valueOf(i.g(f2)), f2);
        }
        return f2;
    }

    public Bitmap c(int i, int i2, Bitmap.Config config) {
        b h2 = h(i.f(i, i2, config), config);
        Bitmap a2 = this.f1044b.a(h2);
        if (a2 != null) {
            g(Integer.valueOf(h2.f1048b), a2);
            a2.reconfigure(i, i2, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    public void d(Bitmap bitmap) {
        b e2 = this.f1043a.e(i.g(bitmap), bitmap.getConfig());
        this.f1044b.d(e2, bitmap);
        NavigableMap<Integer, Integer> k = k(bitmap.getConfig());
        Integer num = (Integer) k.get(Integer.valueOf(e2.f1048b));
        Integer valueOf = Integer.valueOf(e2.f1048b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        k.put(valueOf, Integer.valueOf(i));
    }

    public String e(int i, int i2, Bitmap.Config config) {
        return i(i.f(i, i2, config), config);
    }

    public String f(Bitmap bitmap) {
        return i(i.g(bitmap), bitmap.getConfig());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f1044b);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f1045c.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f1045c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
