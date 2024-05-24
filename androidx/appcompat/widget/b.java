package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f196a;

    public b(ActionBarContainer actionBarContainer) {
        this.f196a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f196a;
        if (actionBarContainer.q) {
            Drawable drawable = actionBarContainer.p;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.n;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f196a;
        Drawable drawable3 = actionBarContainer2.o;
        if (drawable3 != null && actionBarContainer2.r) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f196a;
        if (actionBarContainer.q) {
            drawable = actionBarContainer.p;
            if (drawable == null) {
                return;
            }
        } else {
            drawable = actionBarContainer.n;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
