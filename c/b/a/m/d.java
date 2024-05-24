package c.b.a.m;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f863a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f864b;

    /* renamed from: c  reason: collision with root package name */
    private c f865c;

    /* renamed from: d  reason: collision with root package name */
    private int f866d = 0;

    private boolean b() {
        return this.f865c.f858b != 0;
    }

    private int d() {
        try {
            return this.f864b.get() & 255;
        } catch (Exception unused) {
            this.f865c.f858b = 1;
            return 0;
        }
    }

    private void e() {
        this.f865c.f860d.f851a = n();
        this.f865c.f860d.f852b = n();
        this.f865c.f860d.f853c = n();
        this.f865c.f860d.f854d = n();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        b bVar = this.f865c.f860d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        bVar.f855e = z;
        if (z2) {
            bVar.k = g(pow);
        } else {
            bVar.k = null;
        }
        this.f865c.f860d.j = this.f864b.position();
        r();
        if (!b()) {
            c cVar = this.f865c;
            cVar.f859c++;
            cVar.f861e.add(cVar.f860d);
        }
    }

    private void f() {
        int d2 = d();
        this.f866d = d2;
        if (d2 > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    int i3 = this.f866d;
                    if (i < i3) {
                        i2 = i3 - i;
                        this.f864b.get(this.f863a, i, i2);
                        i += i2;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f866d, e2);
                    }
                    this.f865c.f858b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f864b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f865c.f858b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i) {
        boolean z = false;
        while (!z && !b() && this.f865c.f859c <= i) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 != 1) {
                    if (d3 == 249) {
                        this.f865c.f860d = new b();
                        j();
                    } else if (d3 != 254 && d3 == 255) {
                        f();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.f863a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            m();
                        }
                    }
                }
                q();
            } else if (d2 == 44) {
                c cVar = this.f865c;
                if (cVar.f860d == null) {
                    cVar.f860d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f865c.f858b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int d2 = d();
        b bVar = this.f865c.f860d;
        int i = (d2 & 28) >> 2;
        bVar.g = i;
        boolean z = true;
        if (i == 0) {
            bVar.g = 1;
        }
        if ((d2 & 1) == 0) {
            z = false;
        }
        bVar.f856f = z;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f865c.f860d;
        bVar2.i = n * 10;
        bVar2.h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f865c.f858b = 1;
            return;
        }
        l();
        if (this.f865c.h && !b()) {
            c cVar = this.f865c;
            cVar.f857a = g(cVar.i);
            c cVar2 = this.f865c;
            cVar2.l = cVar2.f857a[cVar2.j];
        }
    }

    private void l() {
        this.f865c.f862f = n();
        this.f865c.g = n();
        int d2 = d();
        c cVar = this.f865c;
        cVar.h = (d2 & 128) != 0;
        cVar.i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.f865c.j = d();
        this.f865c.k = d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f863a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            c.b.a.m.c r2 = r3.f865c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.m = r0
        L_0x001b:
            int r0 = r3.f866d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.d.m():void");
    }

    private int n() {
        return this.f864b.getShort();
    }

    private void o() {
        this.f864b = null;
        Arrays.fill(this.f863a, (byte) 0);
        this.f865c = new c();
        this.f866d = 0;
    }

    private void q() {
        int d2;
        do {
            d2 = d();
            this.f864b.position(Math.min(this.f864b.position() + d2, this.f864b.limit()));
        } while (d2 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f864b = null;
        this.f865c = null;
    }

    public c c() {
        if (this.f864b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f865c;
        } else {
            k();
            if (!b()) {
                h();
                c cVar = this.f865c;
                if (cVar.f859c < 0) {
                    cVar.f858b = 1;
                }
            }
            return this.f865c;
        }
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f864b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f864b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
