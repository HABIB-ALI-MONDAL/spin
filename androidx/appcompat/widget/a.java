package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b.a.j;
import b.d.k.p;
import b.d.k.t;
import b.d.k.u;

abstract class a extends ViewGroup {
    protected final C0009a j;
    protected final Context k;
    protected ActionMenuView l;
    protected c m;
    protected int n;
    protected t o;
    private boolean p;
    private boolean q;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0009a implements u {

        /* renamed from: a  reason: collision with root package name */
        private boolean f193a = false;

        /* renamed from: b  reason: collision with root package name */
        int f194b;

        protected C0009a() {
        }

        public void a(View view) {
            if (!this.f193a) {
                a aVar = a.this;
                aVar.o = null;
                a.super.setVisibility(this.f194b);
            }
        }

        public void b(View view) {
            a.super.setVisibility(0);
            this.f193a = false;
        }

        public void c(View view) {
            this.f193a = true;
        }

        public C0009a d(t tVar, int i) {
            a.this.o = tVar;
            this.f194b = i;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new C0009a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(b.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.k = context;
        } else {
            this.k = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public t f(int i, long j2) {
        t tVar = this.o;
        if (tVar != null) {
            tVar.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            t b2 = p.b(this);
            b2.a(1.0f);
            b2.d(j2);
            C0009a aVar = this.j;
            aVar.d(b2, i);
            b2.f(aVar);
            return b2;
        }
        t b3 = p.b(this);
        b3.a(0.0f);
        b3.d(j2);
        C0009a aVar2 = this.j;
        aVar2.d(b3, i);
        b3.f(aVar2);
        return b3;
    }

    public int getAnimatedVisibility() {
        return this.o != null ? this.j.f194b : getVisibility();
    }

    public int getContentHeight() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, j.f457a, b.a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.m;
        if (cVar != null) {
            cVar.E(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.q = false;
        }
        if (!this.q) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.q = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.q = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.p = false;
        }
        if (!this.p) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.p = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.p = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            t tVar = this.o;
            if (tVar != null) {
                tVar.b();
            }
            super.setVisibility(i);
        }
    }
}
