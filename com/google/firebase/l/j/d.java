package com.google.firebase.l.j;

import java.io.OutputStream;

final class d extends OutputStream {
    private long j = 0;

    d() {
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.j;
    }

    public void write(int i) {
        this.j++;
    }

    public void write(byte[] bArr) {
        this.j += (long) bArr.length;
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.j += (long) i2;
    }
}
