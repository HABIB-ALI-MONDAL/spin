package c.d.a.b.e.e;

final class h7 {
    static int a(byte[] bArr, int i, g7 g7Var) {
        int j = j(bArr, i, g7Var);
        int i2 = g7Var.f1638a;
        if (i2 < 0) {
            throw a9.d();
        } else if (i2 > bArr.length - j) {
            throw a9.f();
        } else if (i2 == 0) {
            g7Var.f1640c = r7.k;
            return j;
        } else {
            g7Var.f1640c = r7.u(bArr, j, i2);
            return j + i2;
        }
    }

    static int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int c(ia iaVar, byte[] bArr, int i, int i2, int i3, g7 g7Var) {
        Object e2 = iaVar.e();
        int n = n(e2, iaVar, bArr, i, i2, i3, g7Var);
        iaVar.a(e2);
        g7Var.f1640c = e2;
        return n;
    }

    static int d(ia iaVar, byte[] bArr, int i, int i2, g7 g7Var) {
        Object e2 = iaVar.e();
        int o = o(e2, iaVar, bArr, i, i2, g7Var);
        iaVar.a(e2);
        g7Var.f1640c = e2;
        return o;
    }

    static int e(ia iaVar, int i, byte[] bArr, int i2, int i3, x8 x8Var, g7 g7Var) {
        int d2 = d(iaVar, bArr, i2, i3, g7Var);
        while (true) {
            x8Var.add(g7Var.f1640c);
            if (d2 >= i3) {
                break;
            }
            int j = j(bArr, d2, g7Var);
            if (i != g7Var.f1638a) {
                break;
            }
            d2 = d(iaVar, bArr, j, i3, g7Var);
        }
        return d2;
    }

    static int f(byte[] bArr, int i, x8 x8Var, g7 g7Var) {
        t8 t8Var = (t8) x8Var;
        int j = j(bArr, i, g7Var);
        int i2 = g7Var.f1638a + j;
        while (j < i2) {
            j = j(bArr, j, g7Var);
            t8Var.j(g7Var.f1638a);
        }
        if (j == i2) {
            return j;
        }
        throw a9.f();
    }

    static int g(byte[] bArr, int i, g7 g7Var) {
        int j = j(bArr, i, g7Var);
        int i2 = g7Var.f1638a;
        if (i2 < 0) {
            throw a9.d();
        } else if (i2 == 0) {
            g7Var.f1640c = "";
            return j;
        } else {
            g7Var.f1640c = new String(bArr, j, i2, y8.f1783a);
            return j + i2;
        }
    }

    static int h(byte[] bArr, int i, g7 g7Var) {
        int j = j(bArr, i, g7Var);
        int i2 = g7Var.f1638a;
        if (i2 < 0) {
            throw a9.d();
        } else if (i2 == 0) {
            g7Var.f1640c = "";
            return j;
        } else {
            g7Var.f1640c = qb.d(bArr, j, i2);
            return j + i2;
        }
    }

    static int i(int i, byte[] bArr, int i2, int i3, bb bbVar, g7 g7Var) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int m = m(bArr, i2, g7Var);
                bbVar.j(i, Long.valueOf(g7Var.f1639b));
                return m;
            } else if (i4 == 1) {
                bbVar.j(i, Long.valueOf(p(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int j = j(bArr, i2, g7Var);
                int i5 = g7Var.f1638a;
                if (i5 < 0) {
                    throw a9.d();
                } else if (i5 <= bArr.length - j) {
                    bbVar.j(i, i5 == 0 ? r7.k : r7.u(bArr, j, i5));
                    return j + i5;
                } else {
                    throw a9.f();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                bb f2 = bb.f();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int j2 = j(bArr, i2, g7Var);
                    int i8 = g7Var.f1638a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = j2;
                        break;
                    }
                    int i9 = i(i7, bArr, j2, i3, f2, g7Var);
                    i7 = i8;
                    i2 = i9;
                }
                if (i2 > i3 || i7 != i6) {
                    throw a9.e();
                }
                bbVar.j(i, f2);
                return i2;
            } else if (i4 == 5) {
                bbVar.j(i, Integer.valueOf(b(bArr, i2)));
                return i2 + 4;
            } else {
                throw a9.b();
            }
        } else {
            throw a9.b();
        }
    }

    static int j(byte[] bArr, int i, g7 g7Var) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return k(b2, bArr, i2, g7Var);
        }
        g7Var.f1638a = b2;
        return i2;
    }

    static int k(int i, byte[] bArr, int i2, g7 g7Var) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i4 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i3 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i4 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i3 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] < 0) {
                                i8 = i10;
                            } else {
                                g7Var.f1638a = i9;
                                return i10;
                            }
                        }
                    }
                }
            }
            g7Var.f1638a = i7 | i3;
            return i8;
        }
        g7Var.f1638a = i5 | i4;
        return i6;
    }

    static int l(int i, byte[] bArr, int i2, int i3, x8 x8Var, g7 g7Var) {
        t8 t8Var = (t8) x8Var;
        int j = j(bArr, i2, g7Var);
        while (true) {
            t8Var.j(g7Var.f1638a);
            if (j >= i3) {
                break;
            }
            int j2 = j(bArr, j, g7Var);
            if (i != g7Var.f1638a) {
                break;
            }
            j = j(bArr, j2, g7Var);
        }
        return j;
    }

    static int m(byte[] bArr, int i, g7 g7Var) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            g7Var.f1639b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b2 = b3;
            i3 = i6;
        }
        g7Var.f1639b = j2;
        return i3;
    }

    static int n(Object obj, ia iaVar, byte[] bArr, int i, int i2, int i3, g7 g7Var) {
        int J = ((aa) iaVar).J(obj, bArr, i, i2, i3, g7Var);
        g7Var.f1640c = obj;
        return J;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int o(java.lang.Object r6, c.d.a.b.e.e.ia r7, byte[] r8, int r9, int r10, c.d.a.b.e.e.g7 r11) {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = k(r9, r8, r0, r11)
            int r9 = r11.f1638a
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.h(r1, r2, r3, r4, r5)
            r11.f1640c = r6
            return r9
        L_0x001e:
            c.d.a.b.e.e.a9 r6 = c.d.a.b.e.e.a9.f()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.h7.o(java.lang.Object, c.d.a.b.e.e.ia, byte[], int, int, c.d.a.b.e.e.g7):int");
    }

    static long p(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
