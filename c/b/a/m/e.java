package c.b.a.m;

import android.graphics.Bitmap;
import c.b.a.m.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class e implements a {
    private static final String u = "e";

    /* renamed from: a  reason: collision with root package name */
    private int[] f867a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f868b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0039a f869c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f870d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f871e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f872f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    public e(a.C0039a aVar) {
        this.f868b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.f869c = aVar;
        this.l = new c();
    }

    public e(a.C0039a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        r(cVar, byteBuffer, i2);
    }

    private int j(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.p + i2; i10++) {
            byte[] bArr = this.i;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f867a[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.p + i12; i13++) {
            byte[] bArr2 = this.i;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f867a[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void k(b bVar) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        b bVar2 = bVar;
        Boolean bool2 = Boolean.TRUE;
        int[] iArr = this.j;
        int i6 = bVar2.f854d;
        int i7 = this.p;
        int i8 = i6 / i7;
        int i9 = bVar2.f852b / i7;
        int i10 = bVar2.f853c / i7;
        int i11 = bVar2.f851a / i7;
        boolean z = this.k == 0;
        int i12 = this.r;
        int i13 = this.q;
        byte[] bArr = this.i;
        int[] iArr2 = this.f867a;
        Boolean bool3 = this.s;
        int i14 = 8;
        Boolean bool4 = bool2;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (true) {
            bool = bool3;
            if (i16 >= i8) {
                break;
            }
            if (bVar2.f855e) {
                if (i15 >= i8) {
                    int i18 = i15;
                    int i19 = i17 + 1;
                    if (i19 == 2) {
                        i17 = i19;
                        i15 = 4;
                    } else if (i19 != 3) {
                        i17 = i19;
                        if (i19 != 4) {
                            i15 = i18;
                        } else {
                            i15 = 1;
                            i14 = 2;
                        }
                    } else {
                        i17 = i19;
                        i15 = 2;
                        i14 = 4;
                    }
                } else {
                    int i20 = i15;
                }
                i2 = i15 + i14;
            } else {
                i2 = i15;
                i15 = i16;
            }
            int i21 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i21 < i13) {
                int i22 = i21 * i12;
                int i23 = i22 + i11;
                int i24 = i23 + i10;
                int i25 = i22 + i12;
                if (i25 < i24) {
                    i24 = i25;
                }
                i3 = i8;
                int i26 = i16 * i7 * bVar2.f853c;
                if (z2) {
                    int i27 = i23;
                    while (true) {
                        i5 = i9;
                        if (i27 >= i24) {
                            break;
                        }
                        int i28 = iArr2[bArr[i26] & 255];
                        if (i28 != 0) {
                            iArr[i27] = i28;
                        } else if (z && bool == null) {
                            bool = bool4;
                        }
                        i26 += i7;
                        i27++;
                        i9 = i5;
                    }
                } else {
                    i5 = i9;
                    int i29 = ((i24 - i23) * i7) + i26;
                    int i30 = i23;
                    while (true) {
                        i4 = i10;
                        if (i30 >= i24) {
                            break;
                        }
                        int j2 = j(i26, i29, bVar2.f853c);
                        if (j2 != 0) {
                            iArr[i30] = j2;
                        } else if (z && bool == null) {
                            bool = bool4;
                        }
                        i26 += i7;
                        i30++;
                        i10 = i4;
                    }
                    bool3 = bool;
                    i16++;
                    i9 = i5;
                    i10 = i4;
                    i15 = i2;
                    i8 = i3;
                }
            } else {
                i3 = i8;
                i5 = i9;
            }
            i4 = i10;
            bool3 = bool;
            i16++;
            i9 = i5;
            i10 = i4;
            i15 = i2;
            i8 = i3;
        }
        if (this.s == null) {
            this.s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void l(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.j;
        int i2 = bVar2.f854d;
        int i3 = bVar2.f852b;
        int i4 = bVar2.f853c;
        int i5 = bVar2.f851a;
        boolean z = this.k == 0;
        int i6 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.f867a;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f853c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                byte b4 = b3 & 255;
                if (b4 != b2) {
                    int i15 = iArr2[b4];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                b bVar3 = bVar;
                i2 = i14;
            }
            int i16 = i2;
            i7++;
            bVar2 = bVar;
        }
        this.s = Boolean.valueOf(this.s == null && z && b2 != -1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m(c.b.a.m.b r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f870d
            int r3 = r1.j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            c.b.a.m.c r1 = r0.l
            int r2 = r1.f862f
            int r1 = r1.g
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f853c
            int r1 = r1.f854d
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.i
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            c.b.a.m.a$a r1 = r0.f869c
            byte[] r1 = r1.e(r2)
            r0.i = r1
        L_0x002b:
            byte[] r1 = r0.i
            short[] r3 = r0.f872f
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.f872f = r3
        L_0x0037:
            short[] r3 = r0.f872f
            byte[] r5 = r0.g
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.g = r5
        L_0x0041:
            byte[] r5 = r0.g
            byte[] r6 = r0.h
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.h = r6
        L_0x004d:
            byte[] r6 = r0.h
            int r7 = r28.q()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.f871e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r24 = -1
            r25 = 0
            r26 = 0
        L_0x0083:
            if (r13 >= r2) goto L_0x014a
            if (r16 != 0) goto L_0x0094
            int r16 = r28.p()
            if (r16 > 0) goto L_0x0092
            r3 = 3
            r0.o = r3
            goto L_0x014a
        L_0x0092:
            r17 = 0
        L_0x0094:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ae:
            if (r4 < r15) goto L_0x0134
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c2
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ae
        L_0x00c2:
            if (r11 != r10) goto L_0x00d9
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00d9:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00eb
            byte r0 = r5[r11]
            r6[r26] = r0
            int r26 = r26 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ae
        L_0x00eb:
            if (r11 < r8) goto L_0x00f4
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f5
        L_0x00f4:
            r7 = r11
        L_0x00f5:
            if (r7 < r9) goto L_0x0100
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f5
        L_0x0100:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0107:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0114
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0107
        L_0x0114:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012b
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012b
            if (r8 >= r6) goto L_0x012b
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012b:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ae
        L_0x0134:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014a:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.e.m(c.b.a.m.b):void");
    }

    private Bitmap o() {
        Boolean bool = this.s;
        Bitmap b2 = this.f869c.b(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        b2.setHasAlpha(true);
        return b2;
    }

    private int p() {
        int q2 = q();
        if (q2 <= 0) {
            return q2;
        }
        ByteBuffer byteBuffer = this.f870d;
        byteBuffer.get(this.f871e, 0, Math.min(q2, byteBuffer.remaining()));
        return q2;
    }

    private int q() {
        return this.f870d.get() & 255;
    }

    private Bitmap s(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.f869c.d(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.g) > 0) {
            if (i3 == 2) {
                if (!bVar.f856f) {
                    c cVar = this.l;
                    int i5 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.h) {
                        i4 = i5;
                    }
                } else if (this.k == 0) {
                    this.s = Boolean.TRUE;
                }
                int i6 = bVar2.f854d;
                int i7 = this.p;
                int i8 = i6 / i7;
                int i9 = bVar2.f852b / i7;
                int i10 = bVar2.f853c / i7;
                int i11 = bVar2.f851a / i7;
                int i12 = this.r;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.r;
                }
            } else if (i3 == 3 && (bitmap = this.m) != null) {
                int i17 = this.r;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.q);
            }
        }
        m(bVar);
        if (bVar.f855e || this.p != 1) {
            k(bVar);
        } else {
            l(bVar);
        }
        if (this.n && ((i2 = bVar.g) == 0 || i2 == 1)) {
            if (this.m == null) {
                this.m = o();
            }
            Bitmap bitmap3 = this.m;
            int i18 = this.r;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        }
        Bitmap o2 = o();
        int i19 = this.r;
        o2.setPixels(iArr, 0, i19, 0, 0, i19, this.q);
        return o2;
    }

    public int a() {
        return this.k;
    }

    public int b() {
        return this.f870d.limit() + this.i.length + (this.j.length * 4);
    }

    public void c(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.f869c.c(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.f869c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f869c.d(bitmap);
        }
        this.m = null;
        this.f870d = null;
        this.s = null;
        byte[] bArr2 = this.f871e;
        if (bArr2 != null) {
            this.f869c.c(bArr2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d7, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap d() {
        /*
            r7 = this;
            monitor-enter(r7)
            c.b.a.m.c r0 = r7.l     // Catch:{ all -> 0x00d8 }
            int r0 = r0.f859c     // Catch:{ all -> 0x00d8 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.k     // Catch:{ all -> 0x00d8 }
            if (r0 >= 0) goto L_0x0039
        L_0x000d:
            java.lang.String r0 = u     // Catch:{ all -> 0x00d8 }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r3 == 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r3.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00d8 }
            c.b.a.m.c r4 = r7.l     // Catch:{ all -> 0x00d8 }
            int r4 = r4.f859c     // Catch:{ all -> 0x00d8 }
            r3.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00d8 }
            int r4 = r7.k     // Catch:{ all -> 0x00d8 }
            r3.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00d8 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00d8 }
        L_0x0037:
            r7.o = r2     // Catch:{ all -> 0x00d8 }
        L_0x0039:
            int r0 = r7.o     // Catch:{ all -> 0x00d8 }
            r3 = 0
            if (r0 == r2) goto L_0x00b8
            r4 = 2
            if (r0 != r4) goto L_0x0043
            goto L_0x00b8
        L_0x0043:
            r0 = 0
            r7.o = r0     // Catch:{ all -> 0x00d8 }
            byte[] r4 = r7.f871e     // Catch:{ all -> 0x00d8 }
            if (r4 != 0) goto L_0x0054
            c.b.a.m.a$a r4 = r7.f869c     // Catch:{ all -> 0x00d8 }
            r5 = 255(0xff, float:3.57E-43)
            byte[] r4 = r4.e(r5)     // Catch:{ all -> 0x00d8 }
            r7.f871e = r4     // Catch:{ all -> 0x00d8 }
        L_0x0054:
            c.b.a.m.c r4 = r7.l     // Catch:{ all -> 0x00d8 }
            java.util.List<c.b.a.m.b> r4 = r4.f861e     // Catch:{ all -> 0x00d8 }
            int r5 = r7.k     // Catch:{ all -> 0x00d8 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00d8 }
            c.b.a.m.b r4 = (c.b.a.m.b) r4     // Catch:{ all -> 0x00d8 }
            int r5 = r7.k     // Catch:{ all -> 0x00d8 }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x0070
            c.b.a.m.c r6 = r7.l     // Catch:{ all -> 0x00d8 }
            java.util.List<c.b.a.m.b> r6 = r6.f861e     // Catch:{ all -> 0x00d8 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00d8 }
            c.b.a.m.b r5 = (c.b.a.m.b) r5     // Catch:{ all -> 0x00d8 }
            goto L_0x0071
        L_0x0070:
            r5 = r3
        L_0x0071:
            int[] r6 = r4.k     // Catch:{ all -> 0x00d8 }
            if (r6 == 0) goto L_0x0076
            goto L_0x007a
        L_0x0076:
            c.b.a.m.c r6 = r7.l     // Catch:{ all -> 0x00d8 }
            int[] r6 = r6.f857a     // Catch:{ all -> 0x00d8 }
        L_0x007a:
            r7.f867a = r6     // Catch:{ all -> 0x00d8 }
            if (r6 != 0) goto L_0x00a0
            java.lang.String r0 = u     // Catch:{ all -> 0x00d8 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x009c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00d8 }
            int r4 = r7.k     // Catch:{ all -> 0x00d8 }
            r1.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d8 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00d8 }
        L_0x009c:
            r7.o = r2     // Catch:{ all -> 0x00d8 }
            monitor-exit(r7)
            return r3
        L_0x00a0:
            boolean r1 = r4.f856f     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x00b2
            int[] r1 = r7.f868b     // Catch:{ all -> 0x00d8 }
            int r2 = r6.length     // Catch:{ all -> 0x00d8 }
            java.lang.System.arraycopy(r6, r0, r1, r0, r2)     // Catch:{ all -> 0x00d8 }
            int[] r1 = r7.f868b     // Catch:{ all -> 0x00d8 }
            r7.f867a = r1     // Catch:{ all -> 0x00d8 }
            int r2 = r4.h     // Catch:{ all -> 0x00d8 }
            r1[r2] = r0     // Catch:{ all -> 0x00d8 }
        L_0x00b2:
            android.graphics.Bitmap r0 = r7.s(r4, r5)     // Catch:{ all -> 0x00d8 }
            monitor-exit(r7)
            return r0
        L_0x00b8:
            java.lang.String r0 = u     // Catch:{ all -> 0x00d8 }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x00d6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            int r2 = r7.o     // Catch:{ all -> 0x00d8 }
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d8 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00d8 }
        L_0x00d6:
            monitor-exit(r7)
            return r3
        L_0x00d8:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.m.e.d():android.graphics.Bitmap");
    }

    public void e() {
        this.k = (this.k + 1) % this.l.f859c;
    }

    public int f() {
        return this.l.f859c;
    }

    public int g() {
        int i2;
        if (this.l.f859c <= 0 || (i2 = this.k) < 0) {
            return 0;
        }
        return n(i2);
    }

    public ByteBuffer h() {
        return this.f870d;
    }

    public void i() {
        this.k = -1;
    }

    public int n(int i2) {
        if (i2 >= 0) {
            c cVar = this.l;
            if (i2 < cVar.f859c) {
                return cVar.f861e.get(i2).i;
            }
        }
        return -1;
    }

    public synchronized void r(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.o = 0;
            this.l = cVar;
            this.k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f870d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f870d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator<b> it = cVar.f861e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g == 3) {
                        this.n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.p = highestOneBit;
            int i3 = cVar.f862f;
            this.r = i3 / highestOneBit;
            int i4 = cVar.g;
            this.q = i4 / highestOneBit;
            this.i = this.f869c.e(i3 * i4);
            this.j = this.f869c.a(this.r * this.q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }
}
