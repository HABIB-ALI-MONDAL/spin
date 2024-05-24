package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.v0;
import androidx.appcompat.widget.y;
import b.a.j;

public class ActionMenuItemView extends y implements p.a, View.OnClickListener, ActionMenuView.a {
    j m;
    private CharSequence n;
    private Drawable o;
    h.b p;
    private f0 q;
    b r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;

    private class a extends f0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        public s b() {
            b bVar = ActionMenuItemView.this.r;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.h$b r1 = r0.p
                r2 = 0
                if (r1 == 0) goto L_0x001c
                androidx.appcompat.view.menu.j r0 = r0.m
                boolean r0 = r1.a(r0)
                if (r0 == 0) goto L_0x001c
                androidx.appcompat.view.menu.s r0 = r3.b()
                if (r0 == 0) goto L_0x001c
                boolean r0 = r0.f()
                if (r0 == 0) goto L_0x001c
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.a.c():boolean");
        }
    }

    public static abstract class b {
        public abstract s a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.s = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.v, i, 0);
        this.u = obtainStyledAttributes.getDimensionPixelSize(j.w, 0);
        obtainStyledAttributes.recycle();
        this.w = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.v = -1;
        setSaveEnabled(false);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.n);
        if (this.o != null && (!this.m.B() || (!this.s && !this.t))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.n : null);
        CharSequence contentDescription = this.m.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.m.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.m.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence = this.m.getTitle();
            }
            v0.a(this, charSequence);
            return;
        }
        v0.a(this, tooltipText);
    }

    public boolean a() {
        return f();
    }

    public boolean b() {
        return f() && this.m.getIcon() == null;
    }

    public boolean c() {
        return true;
    }

    public void d(j jVar, int i) {
        this.m = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.i(this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.q == null) {
            this.q = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public j getItemData() {
        return this.m;
    }

    public void onClick(View view) {
        h.b bVar = this.p;
        if (bVar != null) {
            bVar.a(this.m);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.s = g();
        h();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        boolean f2 = f();
        if (f2 && (i3 = this.v) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.u) : this.u;
        if (mode != 1073741824 && this.u > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!f2 && this.o != null) {
            super.setPadding((getMeasuredWidth() - this.o.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        f0 f0Var;
        if (!this.m.hasSubMenu() || (f0Var = this.q) == null || !f0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.t != z) {
            this.t = z;
            j jVar = this.m;
            if (jVar != null) {
                jVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.w;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i) / ((float) intrinsicHeight)));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        h();
    }

    public void setItemInvoker(h.b bVar) {
        this.p = bVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.v = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.r = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.n = charSequence;
        h();
    }
}
