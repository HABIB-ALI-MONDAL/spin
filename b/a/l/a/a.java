package b.a.l.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import b.a.j;
import b.a.l.a.b;
import b.a.l.a.d;
import b.c.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends d {
    private int A;
    private boolean B;
    private c x;
    private g y;
    private int z;

    private static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f468a;

        b(Animatable animatable) {
            super();
            this.f468a = animatable;
        }

        public void c() {
            this.f468a.start();
        }

        public void d() {
            this.f468a.stop();
        }
    }

    static class c extends d.a {
        b.c.d<Long> K;
        h<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            h<Integer> hVar;
            if (cVar != null) {
                this.K = cVar.K;
                hVar = cVar.L;
            } else {
                this.K = new b.c.d<>();
                hVar = new h<>();
            }
            this.L = hVar;
        }

        private static long D(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        /* access modifiers changed from: package-private */
        public int B(int[] iArr, Drawable drawable, int i) {
            int z = super.z(iArr, drawable);
            this.L.m(z, Integer.valueOf(i));
            return z;
        }

        /* access modifiers changed from: package-private */
        public int C(int i, int i2, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long D = D(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a2;
            this.K.a(D, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(D(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int E(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.j(i, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        public int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public int G(int i, int i2) {
            return (int) this.K.j(D(i, i2), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        public boolean H(int i, int i2) {
            return (this.K.j(D(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean I(int i, int i2) {
            return (this.K.j(D(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        /* access modifiers changed from: package-private */
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }
    }

    private static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final b.l.a.a.b f469a;

        d(b.l.a.a.b bVar) {
            super();
            this.f469a = bVar;
        }

        public void c() {
            this.f469a.start();
        }

        public void d() {
            this.f469a.stop();
        }
    }

    private static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f470a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f471b;

        e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) fVar.a());
            ofInt.setInterpolator(fVar);
            this.f471b = z2;
            this.f470a = ofInt;
        }

        public boolean a() {
            return this.f471b;
        }

        public void b() {
            this.f470a.reverse();
        }

        public void c() {
            this.f470a.start();
        }

        public void d() {
            this.f470a.cancel();
        }
    }

    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f472a;

        /* renamed from: b  reason: collision with root package name */
        private int f473b;

        /* renamed from: c  reason: collision with root package name */
        private int f474c;

        f(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f474c;
        }

        /* access modifiers changed from: package-private */
        public int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f473b = numberOfFrames;
            int[] iArr = this.f472a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f472a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f472a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f474c = i;
            return i;
        }

        public float getInterpolation(float f2) {
            int i = (int) ((f2 * ((float) this.f474c)) + 0.5f);
            int i2 = this.f473b;
            int[] iArr = this.f472a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f474c) : 0.0f);
        }
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    static {
        Class<a> cls = a.class;
    }

    public a() {
        this((c) null, (Resources) null);
    }

    a(c cVar, Resources resources) {
        super((d.a) null);
        this.z = -1;
        this.A = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray i = androidx.core.content.c.g.i(resources, theme, attributeSet, j.T);
        int resourceId = i.getResourceId(j.U, 0);
        int resourceId2 = i.getResourceId(j.V, -1);
        Drawable d2 = resourceId2 > 0 ? b.a.k.a.a.d(context, resourceId2) : null;
        i.recycle();
        int[] k = k(attributeSet);
        if (d2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                d2 = xmlPullParser.getName().equals("vector") ? b.l.a.a.h.c(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (d2 != null) {
            return this.x.B(k, d2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray i = androidx.core.content.c.g.i(resources, theme, attributeSet, j.W);
        int resourceId = i.getResourceId(j.Z, -1);
        int resourceId2 = i.getResourceId(j.Y, -1);
        int resourceId3 = i.getResourceId(j.X, -1);
        Drawable d2 = resourceId3 > 0 ? b.a.k.a.a.d(context, resourceId3) : null;
        boolean z2 = i.getBoolean(j.a0, false);
        i.recycle();
        if (d2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                d2 = xmlPullParser.getName().equals("animated-vector") ? b.l.a.a.b.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (d2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.x.C(resourceId, resourceId2, d2, z2);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i) {
        int i2;
        int G;
        g gVar;
        g gVar2 = this.y;
        if (gVar2 == null) {
            i2 = c();
        } else if (i == this.z) {
            return true;
        } else {
            if (i != this.A || !gVar2.a()) {
                i2 = this.z;
                gVar2.d();
            } else {
                gVar2.b();
                this.z = this.A;
                this.A = i;
                return true;
            }
        }
        this.y = null;
        this.A = -1;
        this.z = -1;
        c cVar = this.x;
        int E = cVar.E(i2);
        int E2 = cVar.E(i);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof b.l.a.a.b) {
            gVar = new d((b.l.a.a.b) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.y = gVar;
        this.A = i2;
        this.z = i;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.x;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f478d |= typedArray.getChangingConfigurations();
        }
        cVar.x(typedArray.getBoolean(j.P, cVar.i));
        cVar.t(typedArray.getBoolean(j.Q, cVar.l));
        cVar.u(typedArray.getInt(j.R, cVar.A));
        cVar.v(typedArray.getInt(j.S, cVar.B));
        setDither(typedArray.getBoolean(j.N, cVar.x));
    }

    /* access modifiers changed from: protected */
    public void h(b.c cVar) {
        super.h(cVar);
        if (cVar instanceof c) {
            this.x = (c) cVar;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.y;
        if (gVar != null) {
            gVar.d();
            this.y = null;
            g(this.z);
            this.z = -1;
            this.A = -1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public c j() {
        return new c(this.x, this, (Resources) null);
    }

    public Drawable mutate() {
        if (!this.B) {
            super.mutate();
            if (this == this) {
                this.x.r();
                this.B = true;
            }
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray i = androidx.core.content.c.g.i(resources, theme, attributeSet, j.M);
        setVisible(i.getBoolean(j.O, true), true);
        t(i);
        i(resources);
        i.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int F = this.x.F(iArr);
        boolean z2 = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z2 | current.setState(iArr) : z2;
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        g gVar = this.y;
        if (gVar != null && (visible || z3)) {
            if (z2) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
