package c.d.a.b.e.e;

final class ob extends nb {
    ob() {
    }

    /* access modifiers changed from: package-private */
    public final int a(int i, byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        if (r9 >= i3) {
            return 0;
        }
        while (r9 < i3) {
            int i4 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 < 0) {
                if (b2 >= -32) {
                    if (b2 < -16) {
                        if (i4 < i3 - 1) {
                            int i5 = i4 + 1;
                            byte b3 = bArr[i4];
                            if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                                r9 = i5 + 1;
                                if (bArr[i5] > -65) {
                                }
                            }
                        }
                    } else if (i4 < i3 - 2) {
                        int i6 = i4 + 1;
                        byte b4 = bArr[i4];
                        if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                            int i7 = i6 + 1;
                            if (bArr[i6] <= -65) {
                                i4 = i7 + 1;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                    }
                    return qb.a(bArr, i4, i3);
                } else if (i4 >= i3) {
                    return b2;
                } else {
                    if (b2 >= -62) {
                        r9 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                }
                return -1;
            }
            r9 = i4;
        }
        return 0;
    }
}
