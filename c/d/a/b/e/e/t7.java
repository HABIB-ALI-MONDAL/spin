package c.d.a.b.e.e;

final class t7 extends v7 {

    /* renamed from: b  reason: collision with root package name */
    private int f1759b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1760c;

    /* renamed from: d  reason: collision with root package name */
    private int f1761d = Integer.MAX_VALUE;

    /* synthetic */ t7(byte[] bArr, int i, int i2, boolean z, s7 s7Var) {
        super((u7) null);
    }

    public final int c(int i) {
        int i2 = this.f1761d;
        this.f1761d = 0;
        int i3 = this.f1759b + this.f1760c;
        this.f1759b = i3;
        if (i3 > 0) {
            this.f1760c = i3;
            this.f1759b = i3 - i3;
        } else {
            this.f1760c = 0;
        }
        return i2;
    }
}
