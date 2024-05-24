package b.l.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.c.g;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class b extends g implements Animatable {
    private C0036b k;
    private Context l;
    private ArgbEvaluator m;
    final Drawable.Callback n;

    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            b.this.scheduleSelf(runnable, j2);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: b.l.a.a.b$b  reason: collision with other inner class name */
    private static class C0036b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f770a;

        /* renamed from: b  reason: collision with root package name */
        h f771b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f772c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f773d;

        /* renamed from: e  reason: collision with root package name */
        b.c.a<Animator, String> f774e;

        public C0036b(Context context, C0036b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f770a = bVar.f770a;
                h hVar = bVar.f771b;
                if (hVar != null) {
                    Drawable.ConstantState constantState = hVar.getConstantState();
                    this.f771b = (h) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    h hVar2 = this.f771b;
                    hVar2.mutate();
                    h hVar3 = hVar2;
                    this.f771b = hVar3;
                    hVar3.setCallback(callback);
                    this.f771b.setBounds(bVar.f771b.getBounds());
                    this.f771b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f773d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f773d = new ArrayList<>(size);
                    this.f774e = new b.c.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = bVar.f773d.get(i);
                        Animator clone = animator.clone();
                        String str = bVar.f774e.get(animator);
                        clone.setTarget(this.f771b.d(str));
                        this.f773d.add(clone);
                        this.f774e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f772c == null) {
                this.f772c = new AnimatorSet();
            }
            this.f772c.playTogether(this.f773d);
        }

        public int getChangingConfigurations() {
            return this.f770a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f775a;

        public c(Drawable.ConstantState constantState) {
            this.f775a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f775a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f775a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            b bVar = new b();
            Drawable newDrawable = this.f775a.newDrawable();
            bVar.j = newDrawable;
            newDrawable.setCallback(bVar.n);
            return bVar;
        }

        public Drawable newDrawable(Resources resources) {
            b bVar = new b();
            Drawable newDrawable = this.f775a.newDrawable(resources);
            bVar.j = newDrawable;
            newDrawable.setCallback(bVar.n);
            return bVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b();
            Drawable newDrawable = this.f775a.newDrawable(resources, theme);
            bVar.j = newDrawable;
            newDrawable.setCallback(bVar.n);
            return bVar;
        }
    }

    b() {
        this((Context) null, (C0036b) null, (Resources) null);
    }

    private b(Context context) {
        this(context, (C0036b) null, (Resources) null);
    }

    private b(Context context, C0036b bVar, Resources resources) {
        this.m = null;
        a aVar = new a();
        this.n = aVar;
        this.l = context;
        if (bVar != null) {
            this.k = bVar;
        } else {
            this.k = new C0036b(context, bVar, aVar, resources);
        }
    }

    public static b a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        b bVar = new b(context);
        bVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return bVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.k.f771b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        C0036b bVar = this.k;
        if (bVar.f773d == null) {
            bVar.f773d = new ArrayList<>();
            this.k.f774e = new b.c.a<>();
        }
        this.k.f773d.add(animator);
        this.k.f774e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                c(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.m == null) {
                    this.m = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.m);
            }
        }
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.j;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.k.f771b.draw(canvas);
        if (this.k.f772c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.j;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.k.f771b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.k.f770a;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.j == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.j.getConstantState());
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getIntrinsicHeight() : this.k.f771b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getIntrinsicWidth() : this.k.f771b.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.getOpacity() : this.k.f771b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.f(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = g.i(resources, theme, attributeSet, a.f768e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        h b2 = h.b(resources, resourceId, theme);
                        b2.h(false);
                        b2.setCallback(this.n);
                        h hVar = this.k.f771b;
                        if (hVar != null) {
                            hVar.setCallback((Drawable.Callback) null);
                        }
                        this.k.f771b = b2;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, a.f769f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.l;
                        if (context != null) {
                            b(string, d.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.k.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.j;
        return drawable != null ? androidx.core.graphics.drawable.a.g(drawable) : this.k.f771b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.j;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.k.f772c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.j;
        return drawable != null ? drawable.isStateful() : this.k.f771b.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.k.f771b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.j;
        return drawable != null ? drawable.setLevel(i) : this.k.f771b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.j;
        return drawable != null ? drawable.setState(iArr) : this.k.f771b.setState(iArr);
    }

    public void setAlpha(int i) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.k.f771b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.i(drawable, z);
        } else {
            this.k.f771b.setAutoMirrored(z);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.k.f771b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.m(drawable, i);
        } else {
            this.k.f771b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, colorStateList);
        } else {
            this.k.f771b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, mode);
        } else {
            this.k.f771b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.j;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.k.f771b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        Drawable drawable = this.j;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.k.f772c.isStarted()) {
            this.k.f772c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.j;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.k.f772c.end();
        }
    }
}
