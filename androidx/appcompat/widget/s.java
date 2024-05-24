package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.j;
import b.a.a;

public class s extends RadioButton implements j {
    private final i j;
    private final x k;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(q0.b(context), attributeSet, i);
        i iVar = new i(this);
        this.j = iVar;
        iVar.e(attributeSet, i);
        x xVar = new x(this);
        this.k = xVar;
        xVar.k(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.j;
        return iVar != null ? iVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.j;
        if (iVar != null) {
            return iVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.j;
        if (iVar != null) {
            return iVar.d();
        }
        return null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(b.a.k.a.a.d(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.j;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.j;
        if (iVar != null) {
            iVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.j;
        if (iVar != null) {
            iVar.h(mode);
        }
    }
}
