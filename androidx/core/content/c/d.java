package androidx.core.content.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class d {

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f348a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f349b;

        a(int i, int i2) {
            this.f348a = new int[]{i, i2};
            this.f349b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.f348a = new int[]{i, i2, i3};
            this.f349b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f348a = new int[size];
            this.f349b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f348a[i] = list.get(i).intValue();
                this.f349b[i] = list2.get(i).floatValue();
            }
        }
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        a aVar2;
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return aVar2;
        }
        aVar2 = new a(i, i2);
        return aVar2;
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray i = g.i(resources, theme2, attributeSet, b.d.d.w);
            float d2 = g.d(i, xmlPullParser2, "startX", b.d.d.F, 0.0f);
            float d3 = g.d(i, xmlPullParser2, "startY", b.d.d.G, 0.0f);
            float d4 = g.d(i, xmlPullParser2, "endX", b.d.d.H, 0.0f);
            float d5 = g.d(i, xmlPullParser2, "endY", b.d.d.I, 0.0f);
            float d6 = g.d(i, xmlPullParser2, "centerX", b.d.d.A, 0.0f);
            float d7 = g.d(i, xmlPullParser2, "centerY", b.d.d.B, 0.0f);
            int e2 = g.e(i, xmlPullParser2, "type", b.d.d.z, 0);
            int b2 = g.b(i, xmlPullParser2, "startColor", b.d.d.x, 0);
            boolean h = g.h(xmlPullParser2, "centerColor");
            int b3 = g.b(i, xmlPullParser2, "centerColor", b.d.d.E, 0);
            int b4 = g.b(i, xmlPullParser2, "endColor", b.d.d.y, 0);
            int e3 = g.e(i, xmlPullParser2, "tileMode", b.d.d.D, 0);
            float f2 = d6;
            float d8 = g.d(i, xmlPullParser2, "gradientRadius", b.d.d.C, 0.0f);
            i.recycle();
            a a2 = a(c(resources, xmlPullParser, attributeSet, theme), b2, b4, h, b3);
            if (e2 == 1) {
                float f3 = f2;
                if (d8 > 0.0f) {
                    int[] iArr = a2.f348a;
                    return new RadialGradient(f3, d7, d8, iArr, a2.f349b, d(e3));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (e2 != 2) {
                return new LinearGradient(d2, d3, d4, d5, a2.f348a, a2.f349b, d(e3));
            } else {
                return new SweepGradient(f2, d7, a2.f348a, a2.f349b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.c.d.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = b.d.d.J
            android.content.res.TypedArray r3 = androidx.core.content.c.g.i(r9, r12, r11, r3)
            int r5 = b.d.d.K
            boolean r6 = r3.hasValue(r5)
            int r7 = b.d.d.L
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            androidx.core.content.c.d$a r9 = new androidx.core.content.c.d$a
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.c.d.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.c.d$a");
    }

    private static Shader.TileMode d(int i) {
        return i != 1 ? i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
