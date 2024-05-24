package b.d.e;

import android.graphics.Path;
import android.util.Log;
import b.a.j;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;

public class b {

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f552a;

        /* renamed from: b  reason: collision with root package name */
        boolean f553b;

        a() {
        }
    }

    /* renamed from: b.d.e.b$b  reason: collision with other inner class name */
    public static class C0022b {

        /* renamed from: a  reason: collision with root package name */
        public char f554a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f555b;

        C0022b(char c2, float[] fArr) {
            this.f554a = c2;
            this.f555b = fArr;
        }

        C0022b(C0022b bVar) {
            this.f554a = bVar.f554a;
            float[] fArr = bVar.f555b;
            this.f555b = b.c(fArr, 0, fArr.length);
        }

        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case ModuleDescriptor.MODULE_VERSION /*86*/:
                case 'h':
                case j.N0:
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case j.I0:
                case j.K0:
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    break;
            }
            i = 2;
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i3 = 0;
            char c5 = c2;
            while (i3 < fArr3.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        path.cubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i4], fArr3[i5], fArr3[i6], fArr3[i7]);
                        f18 = fArr3[i6];
                        float f22 = fArr3[i7];
                        float f23 = fArr3[i4];
                        float f24 = fArr3[i5];
                        f19 = f22;
                        f15 = f24;
                        f14 = f23;
                    } else if (c4 == 'H') {
                        i2 = i3;
                        int i8 = i2 + 0;
                        path2.lineTo(fArr3[i8], f19);
                        f18 = fArr3[i8];
                    } else if (c4 == 'Q') {
                        i2 = i3;
                        int i9 = i2 + 0;
                        int i10 = i2 + 1;
                        int i11 = i2 + 2;
                        int i12 = i2 + 3;
                        path2.quadTo(fArr3[i9], fArr3[i10], fArr3[i11], fArr3[i12]);
                        float f25 = fArr3[i9];
                        float f26 = fArr3[i10];
                        f18 = fArr3[i11];
                        f19 = fArr3[i12];
                        f14 = f25;
                        f15 = f26;
                    } else if (c4 == 'V') {
                        i2 = i3;
                        int i13 = i2 + 0;
                        path2.lineTo(f18, fArr3[i13]);
                        f19 = fArr3[i13];
                    } else if (c4 != 'a') {
                        if (c4 == 'c') {
                            int i14 = i3 + 2;
                            int i15 = i3 + 3;
                            int i16 = i3 + 4;
                            int i17 = i3 + 5;
                            path.rCubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i14], fArr3[i15], fArr3[i16], fArr3[i17]);
                            f5 = fArr3[i14] + f18;
                            f4 = fArr3[i15] + f19;
                            f18 += fArr3[i16];
                            f6 = fArr3[i17];
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else if (c4 != 'h') {
                            if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i18 = i3 + 0;
                                    path2.rLineTo(0.0f, fArr3[i18]);
                                    f7 = fArr3[i18];
                                } else if (c4 != 'L') {
                                    if (c4 == 'M') {
                                        int i19 = i3 + 0;
                                        f18 = fArr3[i19];
                                        int i20 = i3 + 1;
                                        f19 = fArr3[i20];
                                        if (i3 > 0) {
                                            path2.lineTo(fArr3[i19], fArr3[i20]);
                                        } else {
                                            path2.moveTo(fArr3[i19], fArr3[i20]);
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        float f27 = f19;
                                        int i21 = i3 + 0;
                                        int i22 = i3 + 1;
                                        int i23 = i3 + 2;
                                        int i24 = i3 + 3;
                                        path.cubicTo(f18, f27, fArr3[i21], fArr3[i22], fArr3[i23], fArr3[i24]);
                                        f5 = fArr3[i21];
                                        f4 = fArr3[i22];
                                        f18 = fArr3[i23];
                                        f19 = fArr3[i24];
                                        f14 = f5;
                                        f15 = f4;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        int i25 = i3 + 0;
                                        int i26 = i3 + 1;
                                        path2.quadTo(f18, f19, fArr3[i25], fArr3[i26]);
                                        float f28 = fArr3[i25];
                                        float f29 = fArr3[i26];
                                        i2 = i3;
                                        f15 = f19;
                                        f14 = f18;
                                        f18 = f28;
                                        f19 = f29;
                                    } else if (c4 == 'l') {
                                        int i27 = i3 + 0;
                                        int i28 = i3 + 1;
                                        path2.rLineTo(fArr3[i27], fArr3[i28]);
                                        f18 += fArr3[i27];
                                        f7 = fArr3[i28];
                                    } else if (c4 == 'm') {
                                        int i29 = i3 + 0;
                                        f18 += fArr3[i29];
                                        int i30 = i3 + 1;
                                        f19 += fArr3[i30];
                                        if (i3 > 0) {
                                            path2.rLineTo(fArr3[i29], fArr3[i30]);
                                        } else {
                                            path2.rMoveTo(fArr3[i29], fArr3[i30]);
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f30 = f18 - f14;
                                            f8 = f19 - f15;
                                            f9 = f30;
                                        } else {
                                            f9 = 0.0f;
                                            f8 = 0.0f;
                                        }
                                        int i31 = i3 + 0;
                                        int i32 = i3 + 1;
                                        int i33 = i3 + 2;
                                        int i34 = i3 + 3;
                                        path.rCubicTo(f9, f8, fArr3[i31], fArr3[i32], fArr3[i33], fArr3[i34]);
                                        f5 = fArr3[i31] + f18;
                                        f4 = fArr3[i32] + f19;
                                        f18 += fArr3[i33];
                                        f6 = fArr3[i34];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f10 = f18 - f14;
                                            f11 = f19 - f15;
                                        } else {
                                            f11 = 0.0f;
                                            f10 = 0;
                                        }
                                        int i35 = i3 + 0;
                                        int i36 = i3 + 1;
                                        path2.rQuadTo(f10, f11, fArr3[i35], fArr3[i36]);
                                        float f31 = f10 + f18;
                                        float f32 = f11 + f19;
                                        f18 += fArr3[i35];
                                        f19 += fArr3[i36];
                                        f15 = f32;
                                        f14 = f31;
                                    }
                                    i2 = i3;
                                    f21 = f19;
                                    f20 = f18;
                                } else {
                                    int i37 = i3 + 0;
                                    int i38 = i3 + 1;
                                    path2.lineTo(fArr3[i37], fArr3[i38]);
                                    f18 = fArr3[i37];
                                    f19 = fArr3[i38];
                                }
                                f19 += f7;
                            } else {
                                int i39 = i3 + 0;
                                int i40 = i3 + 1;
                                int i41 = i3 + 2;
                                int i42 = i3 + 3;
                                path2.rQuadTo(fArr3[i39], fArr3[i40], fArr3[i41], fArr3[i42]);
                                f5 = fArr3[i39] + f18;
                                f4 = fArr3[i40] + f19;
                                f18 += fArr3[i41];
                                f6 = fArr3[i42];
                            }
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else {
                            int i43 = i3 + 0;
                            path2.rLineTo(fArr3[i43], 0.0f);
                            f18 += fArr3[i43];
                        }
                        i2 = i3;
                    } else {
                        int i44 = i3 + 5;
                        int i45 = i3 + 6;
                        i2 = i3;
                        c(path, f18, f19, fArr3[i44] + f18, fArr3[i45] + f19, fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                        f2 = f18 + fArr3[i44];
                        f3 = f19 + fArr3[i45];
                    }
                    i3 = i2 + i;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i2 = i3;
                    int i46 = i2 + 5;
                    int i47 = i2 + 6;
                    c(path, f18, f19, fArr3[i46], fArr3[i47], fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                    f2 = fArr3[i46];
                    f3 = fArr3[i47];
                }
                f15 = f19;
                f14 = f18;
                i3 = i2 + i;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = (double) ceil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i = 0;
            double d24 = d6;
            double d25 = d7;
            while (i < ceil) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d28 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d29 = (d13 * sin3) - (d14 * cos3);
                double d30 = (sin3 * d16) + (cos3 * d17);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sin4 = (Math.sin(d31) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d32 = d24 + (d23 * sin4);
                double d33 = cos;
                double d34 = sin;
                path.rLineTo(0.0f, 0.0f);
                float f2 = (float) (d27 - (sin4 * d29));
                float f3 = (float) (d28 - (sin4 * d30));
                path.cubicTo((float) d32, (float) (d25 + (d22 * sin4)), f2, f3, (float) d27, (float) d28);
                i++;
                d20 = d20;
                sin = d34;
                d24 = d27;
                d16 = d16;
                cos = d33;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                ceil = ceil;
                d25 = d28;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            float f11 = f6;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f9;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f3;
            Double.isNaN(d7);
            double d8 = (double) f11;
            Double.isNaN(d8);
            double d9 = (d5 + (d7 * sin)) / d8;
            double d10 = (double) (-f9);
            Double.isNaN(d10);
            Double.isNaN(d7);
            double d11 = (d10 * sin) + (d7 * cos);
            double d12 = d7;
            double d13 = (double) f7;
            Double.isNaN(d13);
            double d14 = (double) f10;
            Double.isNaN(d14);
            double d15 = d11 / d13;
            double d16 = (double) f5;
            Double.isNaN(d16);
            Double.isNaN(d8);
            double d17 = ((d14 * cos) + (d16 * sin)) / d8;
            double d18 = d8;
            double d19 = (double) (-f10);
            Double.isNaN(d19);
            Double.isNaN(d16);
            Double.isNaN(d13);
            double d20 = ((d19 * sin) + (d16 * cos)) / d13;
            double d21 = d9 - d17;
            double d22 = d15 - d20;
            double d23 = (d9 + d17) / 2.0d;
            double d24 = (d15 + d20) / 2.0d;
            double d25 = sin;
            double d26 = (d21 * d21) + (d22 * d22);
            if (d26 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d27 = (1.0d / d26) - 0.25d;
            if (d27 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d26);
                float sqrt = (float) (Math.sqrt(d26) / 1.99999d);
                c(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d27);
            double d28 = d21 * sqrt2;
            double d29 = sqrt2 * d22;
            boolean z4 = z2;
            if (z == z4) {
                d3 = d23 - d29;
                d2 = d24 + d28;
            } else {
                d3 = d23 + d29;
                d2 = d24 - d28;
            }
            double atan2 = Math.atan2(d15 - d2, d9 - d3);
            double atan22 = Math.atan2(d20 - d2, d17 - d3) - atan2;
            if (z4 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d18);
            double d30 = d3 * d18;
            Double.isNaN(d13);
            double d31 = d2 * d13;
            b(path, (d30 * cos) - (d31 * d25), (d30 * d25) + (d31 * cos), d18, d13, d6, d12, radians, atan2, atan22);
        }

        public static void e(C0022b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                a(path, fArr, c2, bVarArr[i].f554a, bVarArr[i].f555b);
                c2 = bVarArr[i].f554a;
            }
        }

        public void d(C0022b bVar, C0022b bVar2, float f2) {
            this.f554a = bVar.f554a;
            int i = 0;
            while (true) {
                float[] fArr = bVar.f555b;
                if (i < fArr.length) {
                    this.f555b[i] = (fArr[i] * (1.0f - f2)) + (bVar2.f555b[i] * f2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(ArrayList<C0022b> arrayList, char c2, float[] fArr) {
        arrayList.add(new C0022b(c2, fArr));
    }

    public static boolean b(C0022b[] bVarArr, C0022b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].f554a != bVarArr2[i].f554a || bVarArr[i].f555b.length != bVarArr2[i].f555b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static C0022b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i(str, i);
            String trim = str.substring(i2, i3).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i2 = i3;
            i = i3 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0022b[]) arrayList.toArray(new C0022b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        C0022b[] d2 = d(str);
        if (d2 == null) {
            return null;
        }
        try {
            C0022b.e(d2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static C0022b[] f(C0022b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        C0022b[] bVarArr2 = new C0022b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new C0022b(bVarArr[i]);
        }
        return bVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r10.f553b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[LOOP:0: B:1:0x0007->B:19:0x0038, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(java.lang.String r8, int r9, b.d.e.b.a r10) {
        /*
            r0 = 0
            r10.f553b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0033
            r6 = 69
            if (r5 == r6) goto L_0x0031
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0031
            switch(r5) {
                case 44: goto L_0x0033;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x002f
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0035
        L_0x0027:
            r10.f553b = r7
            goto L_0x0033
        L_0x002a:
            if (r1 == r9) goto L_0x002f
            if (r2 != 0) goto L_0x002f
            goto L_0x0027
        L_0x002f:
            r2 = 0
            goto L_0x0035
        L_0x0031:
            r2 = 1
            goto L_0x0035
        L_0x0033:
            r2 = 0
            r4 = 1
        L_0x0035:
            if (r4 == 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003b:
            r10.f552a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.e.b.g(java.lang.String, int, b.d.e.b$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                g(str, i, aVar);
                int i3 = aVar.f552a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.f553b ? i3 : i3 + 1;
            }
            return c(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    private static int i(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void j(C0022b[] bVarArr, C0022b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].f554a = bVarArr2[i].f554a;
            for (int i2 = 0; i2 < bVarArr2[i].f555b.length; i2++) {
                bVarArr[i].f555b[i2] = bVarArr2[i].f555b[i2];
            }
        }
    }
}
