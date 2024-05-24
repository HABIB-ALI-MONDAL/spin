package b.a.l.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {
    private Drawable j;

    public c(Drawable drawable) {
        b(drawable);
    }

    public Drawable a() {
        return this.j;
    }

    public void b(Drawable drawable) {
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.j.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.j.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.j.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.j.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.j.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.j.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.j.getMinimumWidth();
    }

    public int getOpacity() {
        return this.j.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.j.getPadding(rect);
    }

    public int[] getState() {
        return this.j.getState();
    }

    public Region getTransparentRegion() {
        return this.j.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.g(this.j);
    }

    public boolean isStateful() {
        return this.j.isStateful();
    }

    public void jumpToCurrentState() {
        a.h(this.j);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.j.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.j.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i) {
        this.j.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        a.i(this.j, z);
    }

    public void setChangingConfigurations(int i) {
        this.j.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.j.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.j.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.j.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        a.j(this.j, f2, f3);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        a.k(this.j, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.j.setState(iArr);
    }

    public void setTint(int i) {
        a.m(this.j, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.n(this.j, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.o(this.j, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.j.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
