package b.l.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import b.d.e.b;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class h extends g {
    static final PorterDuff.Mode s = PorterDuff.Mode.SRC_IN;
    private C0037h k;
    private PorterDuffColorFilter l;
    private ColorFilter m;
    private boolean n;
    private boolean o;
    private final float[] p;
    private final Matrix q;
    private final Rect r;

    private static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f790b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f789a = b.d.e.b.d(string2);
            }
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.c.g.h(xmlPullParser, "pathData")) {
                TypedArray i = androidx.core.content.c.g.i(resources, theme, attributeSet, a.f767d);
                f(i);
                i.recycle();
            }
        }
    }

    private static class c extends f {

        /* renamed from: d  reason: collision with root package name */
        private int[] f780d;

        /* renamed from: e  reason: collision with root package name */
        androidx.core.content.c.b f781e;

        /* renamed from: f  reason: collision with root package name */
        float f782f = 0.0f;
        androidx.core.content.c.b g;
        float h = 1.0f;
        int i = 0;
        float j = 1.0f;
        float k = 0.0f;
        float l = 1.0f;
        float m = 0.0f;
        Paint.Cap n = Paint.Cap.BUTT;
        Paint.Join o = Paint.Join.MITER;
        float p = 4.0f;

        public c() {
        }

        public c(c cVar) {
            super(cVar);
            this.f780d = cVar.f780d;
            this.f781e = cVar.f781e;
            this.f782f = cVar.f782f;
            this.h = cVar.h;
            this.g = cVar.g;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        private Paint.Cap e(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f780d = null;
            if (androidx.core.content.c.g.h(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f790b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f789a = b.d.e.b.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.g = androidx.core.content.c.g.c(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.j = androidx.core.content.c.g.d(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = e(androidx.core.content.c.g.e(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = f(androidx.core.content.c.g.e(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = androidx.core.content.c.g.d(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f781e = androidx.core.content.c.g.c(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.h = androidx.core.content.c.g.d(typedArray, xmlPullParser, "strokeAlpha", 11, this.h);
                this.f782f = androidx.core.content.c.g.d(typedArray, xmlPullParser, "strokeWidth", 4, this.f782f);
                this.l = androidx.core.content.c.g.d(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = androidx.core.content.c.g.d(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = androidx.core.content.c.g.d(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.i = androidx.core.content.c.g.e(typedArray, xmlPullParser, "fillType", 13, this.i);
            }
        }

        public boolean a() {
            return this.g.i() || this.f781e.i();
        }

        public boolean b(int[] iArr) {
            return this.f781e.j(iArr) | this.g.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i2 = androidx.core.content.c.g.i(resources, theme, attributeSet, a.f766c);
            h(i2, xmlPullParser, theme);
            i2.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.g.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f781e.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f782f;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.g.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.h = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f781e.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f782f = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.k = f2;
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f783a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f784b;

        /* renamed from: c  reason: collision with root package name */
        float f785c;

        /* renamed from: d  reason: collision with root package name */
        private float f786d;

        /* renamed from: e  reason: collision with root package name */
        private float f787e;

        /* renamed from: f  reason: collision with root package name */
        private float f788f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;

        public d() {
            super();
            this.f783a = new Matrix();
            this.f784b = new ArrayList<>();
            this.f785c = 0.0f;
            this.f786d = 0.0f;
            this.f787e = 0.0f;
            this.f788f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, b.c.a<String, Object> aVar) {
            super();
            f fVar;
            this.f783a = new Matrix();
            this.f784b = new ArrayList<>();
            this.f785c = 0.0f;
            this.f786d = 0.0f;
            this.f787e = 0.0f;
            this.f788f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.f785c = dVar.f785c;
            this.f786d = dVar.f786d;
            this.f787e = dVar.f787e;
            this.f788f = dVar.f788f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.f784b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f784b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f784b.add(fVar);
                    String str2 = fVar.f790b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.f786d, -this.f787e);
            this.j.postScale(this.f788f, this.g);
            this.j.postRotate(this.f785c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.f786d, this.i + this.f787e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f785c = androidx.core.content.c.g.d(typedArray, xmlPullParser, "rotation", 5, this.f785c);
            this.f786d = typedArray.getFloat(1, this.f786d);
            this.f787e = typedArray.getFloat(2, this.f787e);
            this.f788f = androidx.core.content.c.g.d(typedArray, xmlPullParser, "scaleX", 3, this.f788f);
            this.g = androidx.core.content.c.g.d(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = androidx.core.content.c.g.d(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = androidx.core.content.c.g.d(typedArray, xmlPullParser, "translateY", 7, this.i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f784b.size(); i2++) {
                if (this.f784b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f784b.size(); i2++) {
                z |= this.f784b.get(i2).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i2 = androidx.core.content.c.g.i(resources, theme, attributeSet, a.f765b);
            e(i2, xmlPullParser);
            i2.recycle();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f786d;
        }

        public float getPivotY() {
            return this.f787e;
        }

        public float getRotation() {
            return this.f785c;
        }

        public float getScaleX() {
            return this.f788f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f786d) {
                this.f786d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f787e) {
                this.f787e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f785c) {
                this.f785c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f788f) {
                this.f788f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                d();
            }
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected b.C0022b[] f789a = null;

        /* renamed from: b  reason: collision with root package name */
        String f790b;

        /* renamed from: c  reason: collision with root package name */
        int f791c;

        public f() {
            super();
        }

        public f(f fVar) {
            super();
            this.f790b = fVar.f790b;
            this.f791c = fVar.f791c;
            this.f789a = b.d.e.b.f(fVar.f789a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            b.C0022b[] bVarArr = this.f789a;
            if (bVarArr != null) {
                b.C0022b.e(bVarArr, path);
            }
        }

        public b.C0022b[] getPathData() {
            return this.f789a;
        }

        public String getPathName() {
            return this.f790b;
        }

        public void setPathData(b.C0022b[] bVarArr) {
            if (!b.d.e.b.b(this.f789a, bVarArr)) {
                this.f789a = b.d.e.b.f(bVarArr);
            } else {
                b.d.e.b.j(this.f789a, bVarArr);
            }
        }
    }

    private static class g {
        private static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f792a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f793b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f794c;

        /* renamed from: d  reason: collision with root package name */
        Paint f795d;

        /* renamed from: e  reason: collision with root package name */
        Paint f796e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f797f;
        private int g;
        final d h;
        float i;
        float j;
        float k;
        float l;
        int m;
        String n;
        Boolean o;
        final b.c.a<String, Object> p;

        public g() {
            this.f794c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new b.c.a<>();
            this.h = new d();
            this.f792a = new Path();
            this.f793b = new Path();
        }

        public g(g gVar) {
            this.f794c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            b.c.a<String, Object> aVar = new b.c.a<>();
            this.p = aVar;
            this.h = new d(gVar.h, aVar);
            this.f792a = new Path(gVar.f792a);
            this.f793b = new Path(gVar.f793b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = gVar.o;
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f783a.set(matrix);
            dVar.f783a.preConcat(dVar.j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f784b.size(); i4++) {
                e eVar = dVar.f784b.get(i4);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f783a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.k;
            float f3 = ((float) i3) / this.l;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.f783a;
            this.f794c.set(matrix);
            this.f794c.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 != 0.0f) {
                fVar.d(this.f792a);
                Path path = this.f792a;
                this.f793b.reset();
                if (fVar.c()) {
                    this.f793b.addPath(path, this.f794c);
                    canvas.clipPath(this.f793b);
                    return;
                }
                c cVar = (c) fVar;
                float f4 = cVar.k;
                if (!(f4 == 0.0f && cVar.l == 1.0f)) {
                    float f5 = cVar.m;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (cVar.l + f5) % 1.0f;
                    if (this.f797f == null) {
                        this.f797f = new PathMeasure();
                    }
                    this.f797f.setPath(this.f792a, false);
                    float length = this.f797f.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.f797f.getSegment(f8, length, path, true);
                        this.f797f.getSegment(0.0f, f9, path, true);
                    } else {
                        this.f797f.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f793b.addPath(path, this.f794c);
                if (cVar.g.l()) {
                    androidx.core.content.c.b bVar = cVar.g;
                    if (this.f796e == null) {
                        Paint paint = new Paint(1);
                        this.f796e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f796e;
                    if (bVar.h()) {
                        Shader f10 = bVar.f();
                        f10.setLocalMatrix(this.f794c);
                        paint2.setShader(f10);
                        paint2.setAlpha(Math.round(cVar.j * 255.0f));
                    } else {
                        paint2.setColor(h.a(bVar.e(), cVar.j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f793b.setFillType(cVar.i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f793b, paint2);
                }
                if (cVar.f781e.l()) {
                    androidx.core.content.c.b bVar2 = cVar.f781e;
                    if (this.f795d == null) {
                        Paint paint3 = new Paint(1);
                        this.f795d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f795d;
                    Paint.Join join = cVar.o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.p);
                    if (bVar2.h()) {
                        Shader f11 = bVar2.f();
                        f11.setLocalMatrix(this.f794c);
                        paint4.setShader(f11);
                        paint4.setAlpha(Math.round(cVar.h * 255.0f));
                    } else {
                        paint4.setColor(h.a(bVar2.e(), cVar.h));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f782f * min * e2);
                    canvas.drawPath(this.f793b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.h, q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }
    }

    /* renamed from: b.l.a.a.h$h  reason: collision with other inner class name */
    private static class C0037h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f798a;

        /* renamed from: b  reason: collision with root package name */
        g f799b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f800c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f801d;

        /* renamed from: e  reason: collision with root package name */
        boolean f802e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f803f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public C0037h() {
            this.f800c = null;
            this.f801d = h.s;
            this.f799b = new g();
        }

        public C0037h(C0037h hVar) {
            this.f800c = null;
            this.f801d = h.s;
            if (hVar != null) {
                this.f798a = hVar.f798a;
                g gVar = new g(hVar.f799b);
                this.f799b = gVar;
                if (hVar.f799b.f796e != null) {
                    gVar.f796e = new Paint(hVar.f799b.f796e);
                }
                if (hVar.f799b.f795d != null) {
                    this.f799b.f795d = new Paint(hVar.f799b.f795d);
                }
                this.f800c = hVar.f800c;
                this.f801d = hVar.f801d;
                this.f802e = hVar.f802e;
            }
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f803f.getWidth() && i3 == this.f803f.getHeight();
        }

        public boolean b() {
            return !this.k && this.g == this.f800c && this.h == this.f801d && this.j == this.f802e && this.i == this.f799b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f803f == null || !a(i2, i3)) {
                this.f803f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f803f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f799b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean f() {
            return this.f799b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f799b.f();
        }

        public int getChangingConfigurations() {
            return this.f798a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f799b.g(iArr);
            this.k |= g2;
            return g2;
        }

        public void i() {
            this.g = this.f800c;
            this.h = this.f801d;
            this.i = this.f799b.getRootAlpha();
            this.j = this.f802e;
            this.k = false;
        }

        public void j(int i2, int i3) {
            this.f803f.eraseColor(0);
            this.f799b.b(new Canvas(this.f803f), i2, i3, (ColorFilter) null);
        }

        public Drawable newDrawable() {
            return new h(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f804a;

        public i(Drawable.ConstantState constantState) {
            this.f804a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f804a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f804a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            h hVar = new h();
            hVar.j = (VectorDrawable) this.f804a.newDrawable();
            return hVar;
        }

        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.j = (VectorDrawable) this.f804a.newDrawable(resources);
            return hVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.j = (VectorDrawable) this.f804a.newDrawable(resources, theme);
            return hVar;
        }
    }

    h() {
        this.o = true;
        this.p = new float[9];
        this.q = new Matrix();
        this.r = new Rect();
        this.k = new C0037h();
    }

    h(C0037h hVar) {
        this.o = true;
        this.p = new float[9];
        this.q = new Matrix();
        this.r = new Rect();
        this.k = hVar;
        this.l = j(this.l, hVar.f800c, hVar.f801d);
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ IOException | XmlPullParserException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ IOException | XmlPullParserException -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b.l.a.a.h b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            b.l.a.a.h r0 = new b.l.a.a.h
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.c.f.a(r6, r7, r8)
            r0.j = r6
            b.l.a.a.h$i r6 = new b.l.a.a.h$i
            android.graphics.drawable.Drawable r7 = r0.j
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            b.l.a.a.h r6 = c(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            goto L_0x0046
        L_0x0045:
            r6 = move-exception
        L_0x0046:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.a.h.b(android.content.res.Resources, int, android.content.res.Resources$Theme):b.l.a.a.h");
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: b.l.a.a.h$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: b.l.a.a.h$c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: b.l.a.a.h$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: b.l.a.a.h$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: b.l.a.a.h$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(android.content.res.Resources r11, org.xmlpull.v1.XmlPullParser r12, android.util.AttributeSet r13, android.content.res.Resources.Theme r14) {
        /*
            r10 = this;
            b.l.a.a.h$h r0 = r10.k
            b.l.a.a.h$g r1 = r0.f799b
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            b.l.a.a.h$d r3 = r1.h
            r2.push(r3)
            int r3 = r12.getEventType()
            int r4 = r12.getDepth()
            r5 = 1
            int r4 = r4 + r5
            r6 = 1
        L_0x0019:
            if (r3 == r5) goto L_0x00c4
            int r7 = r12.getDepth()
            r8 = 3
            if (r7 >= r4) goto L_0x0024
            if (r3 == r8) goto L_0x00c4
        L_0x0024:
            r7 = 2
            java.lang.String r9 = "group"
            if (r3 != r7) goto L_0x00af
            java.lang.String r3 = r12.getName()
            java.lang.Object r7 = r2.peek()
            b.l.a.a.h$d r7 = (b.l.a.a.h.d) r7
            java.lang.String r8 = "path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0059
            b.l.a.a.h$c r3 = new b.l.a.a.h$c
            r3.<init>()
            r3.g(r11, r13, r14, r12)
            java.util.ArrayList<b.l.a.a.h$e> r6 = r7.f784b
            r6.add(r3)
            java.lang.String r6 = r3.getPathName()
            if (r6 == 0) goto L_0x0057
            b.c.a<java.lang.String, java.lang.Object> r6 = r1.p
            java.lang.String r7 = r3.getPathName()
            r6.put(r7, r3)
        L_0x0057:
            r6 = 0
            goto L_0x007d
        L_0x0059:
            java.lang.String r8 = "clip-path"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0085
            b.l.a.a.h$b r3 = new b.l.a.a.h$b
            r3.<init>()
            r3.e(r11, r13, r14, r12)
            java.util.ArrayList<b.l.a.a.h$e> r7 = r7.f784b
            r7.add(r3)
            java.lang.String r7 = r3.getPathName()
            if (r7 == 0) goto L_0x007d
            b.c.a<java.lang.String, java.lang.Object> r7 = r1.p
            java.lang.String r8 = r3.getPathName()
            r7.put(r8, r3)
        L_0x007d:
            int r7 = r0.f798a
            int r3 = r3.f791c
        L_0x0081:
            r3 = r3 | r7
            r0.f798a = r3
            goto L_0x00be
        L_0x0085:
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            b.l.a.a.h$d r3 = new b.l.a.a.h$d
            r3.<init>()
            r3.c(r11, r13, r14, r12)
            java.util.ArrayList<b.l.a.a.h$e> r7 = r7.f784b
            r7.add(r3)
            r2.push(r3)
            java.lang.String r7 = r3.getGroupName()
            if (r7 == 0) goto L_0x00aa
            b.c.a<java.lang.String, java.lang.Object> r7 = r1.p
            java.lang.String r8 = r3.getGroupName()
            r7.put(r8, r3)
        L_0x00aa:
            int r7 = r0.f798a
            int r3 = r3.k
            goto L_0x0081
        L_0x00af:
            if (r3 != r8) goto L_0x00be
            java.lang.String r3 = r12.getName()
            boolean r3 = r9.equals(r3)
            if (r3 == 0) goto L_0x00be
            r2.pop()
        L_0x00be:
            int r3 = r12.next()
            goto L_0x0019
        L_0x00c4:
            if (r6 != 0) goto L_0x00c7
            return
        L_0x00c7:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = "no path defined"
            r11.<init>(r12)
            goto L_0x00d0
        L_0x00cf:
            throw r11
        L_0x00d0:
            goto L_0x00cf
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.a.h.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.e(this) == 1;
    }

    private static PorterDuff.Mode g(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0037h hVar = this.k;
        g gVar = hVar.f799b;
        hVar.f801d = g(androidx.core.content.c.g.e(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            hVar.f800c = colorStateList;
        }
        hVar.f802e = androidx.core.content.c.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f802e);
        gVar.k = androidx.core.content.c.g.d(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        float d2 = androidx.core.content.c.g.d(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        gVar.l = d2;
        if (gVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (d2 > 0.0f) {
            gVar.i = typedArray.getDimension(3, gVar.i);
            float dimension = typedArray.getDimension(2, gVar.j);
            gVar.j = dimension;
            if (gVar.i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(androidx.core.content.c.g.d(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.n = string;
                    gVar.p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.j;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    /* access modifiers changed from: package-private */
    public Object d(String str) {
        return this.k.f799b.p.get(str);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.r);
        if (this.r.width() > 0 && this.r.height() > 0) {
            ColorFilter colorFilter = this.m;
            if (colorFilter == null) {
                colorFilter = this.l;
            }
            canvas.getMatrix(this.q);
            this.q.getValues(this.p);
            float abs = Math.abs(this.p[0]);
            float abs2 = Math.abs(this.p[4]);
            float abs3 = Math.abs(this.p[1]);
            float abs4 = Math.abs(this.p[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.r.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.r.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.r;
                canvas.translate((float) rect.left, (float) rect.top);
                if (f()) {
                    canvas.translate((float) this.r.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.r.offsetTo(0, 0);
                this.k.c(min, min2);
                if (!this.o) {
                    this.k.j(min, min2);
                } else if (!this.k.b()) {
                    this.k.j(min, min2);
                    this.k.i();
                }
                this.k.d(canvas, colorFilter, this.r);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.j;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.k.f799b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.k.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.j != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.j.getConstantState());
        }
        this.k.f798a = getChangingConfigurations();
        return this.k;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.k.f799b.j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.k.f799b.i;
    }

    public int getOpacity() {
        Drawable drawable = this.j;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void h(boolean z) {
        this.o = z;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0037h hVar = this.k;
        hVar.f799b = new g();
        TypedArray i2 = androidx.core.content.c.g.i(resources, theme, attributeSet, a.f764a);
        i(i2, xmlPullParser);
        i2.recycle();
        hVar.f798a = getChangingConfigurations();
        hVar.k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.l = j(this.l, hVar.f800c, hVar.f801d);
    }

    public void invalidateSelf() {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.j;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.k.f802e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.k.f800c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.j
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            b.l.a.a.h$h r0 = r1.k
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            b.l.a.a.h$h r0 = r1.k
            android.content.res.ColorStateList r0 = r0.f800c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.l.a.a.h.isStateful():boolean");
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public Drawable mutate() {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.n && super.mutate() == this) {
            this.k = new C0037h(this.k);
            this.n = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.j;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0037h hVar = this.k;
        ColorStateList colorStateList = hVar.f800c;
        if (!(colorStateList == null || (mode = hVar.f801d) == null)) {
            this.l = j(this.l, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.k.f799b.getRootAlpha() != i2) {
            this.k.f799b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z);
        } else {
            this.k.f802e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.m = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
            return;
        }
        C0037h hVar = this.k;
        if (hVar.f800c != colorStateList) {
            hVar.f800c = colorStateList;
            this.l = j(this.l, colorStateList, hVar.f801d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
            return;
        }
        C0037h hVar = this.k;
        if (hVar.f801d != mode) {
            hVar.f801d = mode;
            this.l = j(this.l, hVar.f800c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.j;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
