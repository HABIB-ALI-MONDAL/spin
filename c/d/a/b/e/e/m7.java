package c.d.a.b.e.e;

final class m7 extends q7 {
    private final int m;

    m7(byte[] bArr, int i, int i2) {
        super(bArr);
        r7.s(0, i2, bArr.length);
        this.m = i2;
    }

    public final byte d(int i) {
        int i2 = this.m;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.l[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    /* access modifiers changed from: package-private */
    public final byte g(int i) {
        return this.l[i];
    }

    public final int i() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public final int x() {
        return 0;
    }
}
