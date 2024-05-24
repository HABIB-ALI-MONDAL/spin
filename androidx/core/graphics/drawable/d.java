package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class d extends Drawable implements Drawable.Callback, c, b {
    static final PorterDuff.Mode p = PorterDuff.Mode.SRC_IN;
    private int j;
    private PorterDuff.Mode k;
    private boolean l;
    f m;
    private boolean n;
    Drawable o;

    d(Drawable drawable) {
        this.m = d();
        b(drawable);
    }

    d(f fVar, Resources resources) {
        this.m = fVar;
        e(resources);
    }

    private f d() {
        return new f(this.m);
    }

    private void e(Resources resources) {
        Drawable.ConstantState constantState;
        f fVar = this.m;
        if (fVar != null && (constantState = fVar.f361b) != null) {
            b(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        f fVar = this.m;
        ColorStateList colorStateList = fVar.f362c;
        PorterDuff.Mode mode = fVar.f363d;
        if (colorStateList == null || mode == null) {
            this.l = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.l && colorForState == this.j && mode == this.k)) {
                setColorFilter(colorForState, mode);
                this.j = colorForState;
                this.k = mode;
                this.l = true;
                return true;
            }
        }
        return false;
    }

    public final Drawable a() {
        return this.o;
    }

    public final void b(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.o = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.m;
            if (fVar != null) {
                fVar.f361b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.o.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.m;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.o.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        f fVar = this.m;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.m.f360a = getChangingConfigurations();
        return this.m;
    }

    public Drawable getCurrent() {
        return this.o.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.o.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.o.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.o.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.o.getMinimumWidth();
    }

    public int getOpacity() {
        return this.o.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.o.getPadding(rect);
    }

    public int[] getState() {
        return this.o.getState();
    }

    public Region getTransparentRegion() {
        return this.o.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.o.isAutoMirrored();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.f r0 = r1.m
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f362c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.o
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.d.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.o.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.n && super.mutate() == this) {
            this.m = d();
            Drawable drawable = this.o;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.m;
            if (fVar != null) {
                Drawable drawable2 = this.o;
                fVar.f361b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.n = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.o.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i) {
        this.o.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.o.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.o.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.o.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.o.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.o.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return f(iArr) || this.o.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.m.f362c = colorStateList;
        f(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.m.f363d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.o.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
