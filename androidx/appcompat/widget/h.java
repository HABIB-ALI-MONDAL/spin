package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.i;
import b.a.k.a.a;

public class h extends CheckedTextView {
    private static final int[] k = {16843016};
    private final x j;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(q0.b(context), attributeSet, i);
        x xVar = new x(this);
        this.j = xVar;
        xVar.k(attributeSet, i);
        xVar.b();
        t0 t = t0.t(getContext(), attributeSet, k, i, 0);
        setCheckMarkDrawable(t.f(0));
        t.u();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        x xVar = this.j;
        if (xVar != null) {
            xVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.d(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.k(this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        x xVar = this.j;
        if (xVar != null) {
            xVar.n(context, i);
        }
    }
}
