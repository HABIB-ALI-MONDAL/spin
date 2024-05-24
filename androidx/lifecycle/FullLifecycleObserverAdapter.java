package androidx.lifecycle;

import androidx.lifecycle.d;

class FullLifecycleObserverAdapter implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f384a;

    /* renamed from: b  reason: collision with root package name */
    private final e f385b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f386a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.d$b[] r0 = androidx.lifecycle.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f386a = r0
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f386a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.lifecycle.d$b r1 = androidx.lifecycle.d.b.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FullLifecycleObserverAdapter.a.<clinit>():void");
        }
    }

    FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.f384a = bVar;
        this.f385b = eVar;
    }

    public void d(g gVar, d.b bVar) {
        switch (a.f386a[bVar.ordinal()]) {
            case 1:
                this.f384a.c(gVar);
                break;
            case 2:
                this.f384a.g(gVar);
                break;
            case 3:
                this.f384a.a(gVar);
                break;
            case 4:
                this.f384a.e(gVar);
                break;
            case 5:
                this.f384a.f(gVar);
                break;
            case 6:
                this.f384a.b(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f385b;
        if (eVar != null) {
            eVar.d(gVar, bVar);
        }
    }
}
