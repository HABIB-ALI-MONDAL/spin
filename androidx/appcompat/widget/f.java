package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.b;
import androidx.core.widget.i;
import b.a.a;
import b.d.k.o;

public class f extends Button implements o, b {
    private final e j;
    private final x k;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(q0.b(context), attributeSet, i);
        e eVar = new e(this);
        this.j = eVar;
        eVar.e(attributeSet, i);
        x xVar = new x(this);
        this.k = xVar;
        xVar.k(attributeSet, i);
        xVar.b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.j;
        if (eVar != null) {
            eVar.b();
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f370a) {
            return super.getAutoSizeMaxTextSize();
        }
        x xVar = this.k;
        if (xVar != null) {
            return xVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f370a) {
            return super.getAutoSizeMinTextSize();
        }
        x xVar = this.k;
        if (xVar != null) {
            return xVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f370a) {
            return super.getAutoSizeStepGranularity();
        }
        x xVar = this.k;
        if (xVar != null) {
            return xVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f370a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        x xVar = this.k;
        return xVar != null ? xVar.h() : new int[0];
    }

    public int getAutoSizeTextType() {
        if (b.f370a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        x xVar = this.k;
        if (xVar != null) {
            return xVar.i();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.j;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.j;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        x xVar = this.k;
        if (xVar != null) {
            xVar.m(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        x xVar = this.k;
        if (xVar != null && !b.f370a && xVar.j()) {
            this.k.c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.f370a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.p(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.f370a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.q(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f370a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.r(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.j;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.j;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.k(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        x xVar = this.k;
        if (xVar != null) {
            xVar.o(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.j;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.j;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        x xVar = this.k;
        if (xVar != null) {
            xVar.n(context, i);
        }
    }

    public void setTextSize(int i, float f2) {
        if (b.f370a) {
            super.setTextSize(i, f2);
            return;
        }
        x xVar = this.k;
        if (xVar != null) {
            xVar.s(i, f2);
        }
    }
}
