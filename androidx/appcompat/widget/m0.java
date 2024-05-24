package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.g0;

public class m0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    Runnable j;
    private c k;
    g0 l;
    private Spinner m;
    private boolean n;
    int o;
    int p;
    private int q;
    private int r;

    class a implements Runnable {
        final /* synthetic */ View j;

        a(View view) {
            this.j = view;
        }

        public void run() {
            m0.this.smoothScrollTo(this.j.getLeft() - ((m0.this.getWidth() - this.j.getWidth()) / 2), 0);
            m0.this.j = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        public int getCount() {
            return m0.this.l.getChildCount();
        }

        public Object getItem(int i) {
            return ((d) m0.this.l.getChildAt(i)).b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return m0.this.c((a.c) getItem(i), true);
            }
            ((d) view).a((a.c) getItem(i));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = m0.this.l.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = m0.this.l.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {
        private final int[] j;
        private a.c k;
        private TextView l;
        private ImageView m;
        private View n;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.m0.this = r5
                int r5 = b.a.a.actionBarTabStyle
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.j = r1
                r4.k = r7
                androidx.appcompat.widget.t0 r5 = androidx.appcompat.widget.t0.t(r6, r0, r1, r5, r3)
                boolean r6 = r5.q(r3)
                if (r6 == 0) goto L_0x0026
                android.graphics.drawable.Drawable r6 = r5.f(r3)
                r4.setBackgroundDrawable(r6)
            L_0x0026:
                r5.u()
                if (r8 == 0) goto L_0x0031
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L_0x0031:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.m0.d.<init>(androidx.appcompat.widget.m0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.k = cVar;
            c();
        }

        public a.c b() {
            return this.k;
        }

        public void c() {
            a.c cVar = this.k;
            View b2 = cVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.n = b2;
                TextView textView = this.l;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.m;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.m.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.n;
            if (view != null) {
                removeView(view);
                this.n = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.m == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.m = oVar;
                }
                this.m.setImageDrawable(c2);
                this.m.setVisibility(0);
            } else {
                ImageView imageView2 = this.m;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.m.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.l == null) {
                    y yVar = new y(getContext(), (AttributeSet) null, b.a.a.actionBarTabTextStyle);
                    yVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    yVar.setLayoutParams(layoutParams2);
                    addView(yVar);
                    this.l = yVar;
                }
                this.l.setText(d2);
                this.l.setVisibility(0);
            } else {
                TextView textView2 = this.l;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.l.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.m;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z) {
                charSequence = cVar.a();
            }
            v0.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (m0.this.o > 0 && getMeasuredWidth() > (i3 = m0.this.o)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner b() {
        w wVar = new w(getContext(), (AttributeSet) null, b.a.a.actionDropDownStyle);
        wVar.setLayoutParams(new g0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.m;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (!d()) {
            if (this.m == null) {
                this.m = b();
            }
            removeView(this.l);
            addView(this.m, new ViewGroup.LayoutParams(-2, -1));
            if (this.m.getAdapter() == null) {
                this.m.setAdapter(new b());
            }
            Runnable runnable = this.j;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.j = null;
            }
            this.m.setSelection(this.r);
        }
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.m);
        addView(this.l, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.m.getSelectedItemPosition());
        return false;
    }

    public void a(int i) {
        View childAt = this.l.getChildAt(i);
        Runnable runnable = this.j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.j = aVar;
        post(aVar);
    }

    /* access modifiers changed from: package-private */
    public d c(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable((Drawable) null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.q));
        } else {
            dVar.setFocusable(true);
            if (this.k == null) {
                this.k = new c();
            }
            dVar.setOnClickListener(this.k);
        }
        return dVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.j;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b.a.m.a b2 = b.a.m.a.b(getContext());
        setContentHeight(b2.f());
        this.p = b2.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((d) view).b().e();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.l.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.o = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.o = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.o, this.p);
        }
        this.o = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.q, 1073741824);
        if (z2 || !this.n) {
            z = false;
        }
        if (z) {
            this.l.measure(0, makeMeasureSpec);
            if (this.l.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z2 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.r);
                    return;
                }
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.n = z;
    }

    public void setContentHeight(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.r = i;
        int childCount = this.l.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.l.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.m;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }
}
