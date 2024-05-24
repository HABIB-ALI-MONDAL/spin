package androidx.appcompat.widget;

class l0 {

    /* renamed from: a  reason: collision with root package name */
    private int f221a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f222b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f223c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f224d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f225e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f226f = 0;
    private boolean g = false;
    private boolean h = false;

    l0() {
    }

    public int a() {
        return this.g ? this.f221a : this.f222b;
    }

    public int b() {
        return this.f221a;
    }

    public int c() {
        return this.f222b;
    }

    public int d() {
        return this.g ? this.f222b : this.f221a;
    }

    public void e(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f225e = i;
            this.f221a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f226f = i2;
            this.f222b = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != Integer.MIN_VALUE) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.g
            if (r2 != r0) goto L_0x0005
            return
        L_0x0005:
            r1.g = r2
            boolean r0 = r1.h
            if (r0 == 0) goto L_0x002b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L_0x001d
            int r2 = r1.f224d
            if (r2 == r0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            int r2 = r1.f225e
        L_0x0016:
            r1.f221a = r2
            int r2 = r1.f223c
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x001d:
            int r2 = r1.f223c
            if (r2 == r0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            int r2 = r1.f225e
        L_0x0024:
            r1.f221a = r2
            int r2 = r1.f224d
            if (r2 == r0) goto L_0x002f
            goto L_0x0031
        L_0x002b:
            int r2 = r1.f225e
            r1.f221a = r2
        L_0x002f:
            int r2 = r1.f226f
        L_0x0031:
            r1.f222b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.f(boolean):void");
    }

    public void g(int i, int i2) {
        this.f223c = i;
        this.f224d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f221a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f222b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f221a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f222b = i2;
        }
    }
}
