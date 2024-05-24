package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.view.menu.s;
import b.d.k.o;
import b.d.k.p;

public class w extends Spinner implements o {
    private static final int[] r = {16843505};
    private final e j;
    private final Context k;
    private f0 l;
    private SpinnerAdapter m;
    private final boolean n;
    c o;
    int p;
    final Rect q;

    class a extends f0 {
        final /* synthetic */ c s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(View view, c cVar) {
            super(view);
            this.s = cVar;
        }

        public s b() {
            return this.s;
        }

        public boolean c() {
            if (w.this.o.f()) {
                return true;
            }
            w.this.o.b();
            return true;
        }
    }

    private static class b implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter j;
        private ListAdapter k;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.j = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.k = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof p0) {
                p0 p0Var = (p0) spinnerAdapter;
                if (p0Var.getDropDownViewTheme() == null) {
                    p0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.k;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.j;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.k;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.j;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class c extends h0 {
        private CharSequence R;
        ListAdapter S;
        private final Rect T = new Rect();

        class a implements AdapterView.OnItemClickListener {
            a(w wVar) {
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
                w.this.setSelection(i);
                if (w.this.getOnItemClickListener() != null) {
                    c cVar = c.this;
                    w.this.performItemClick(view, i, cVar.S.getItemId(i));
                }
                c.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            public void onGlobalLayout() {
                c cVar = c.this;
                if (!cVar.M(w.this)) {
                    c.this.dismiss();
                    return;
                }
                c.this.K();
                c.super.b();
            }
        }

        /* renamed from: androidx.appcompat.widget.w$c$c  reason: collision with other inner class name */
        class C0011c implements PopupWindow.OnDismissListener {
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener j;

            C0011c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.j = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.j);
                }
            }
        }

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            s(w.this);
            A(true);
            F(0);
            C(new a(w.this));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0095  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void K() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.j()
                r1 = 0
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.widget.w r1 = androidx.appcompat.widget.w.this
                android.graphics.Rect r1 = r1.q
                r0.getPadding(r1)
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                boolean r0 = androidx.appcompat.widget.z0.b(r0)
                if (r0 == 0) goto L_0x001d
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.q
                int r0 = r0.right
                goto L_0x0024
            L_0x001d:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.q
                int r0 = r0.left
                int r0 = -r0
            L_0x0024:
                r1 = r0
                goto L_0x002e
            L_0x0026:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.q
                r0.right = r1
                r0.left = r1
            L_0x002e:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.w r2 = androidx.appcompat.widget.w.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.w r3 = androidx.appcompat.widget.w.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.w r4 = androidx.appcompat.widget.w.this
                int r5 = r4.p
                r6 = -2
                if (r5 != r6) goto L_0x0078
                android.widget.ListAdapter r5 = r8.S
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.j()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.w r5 = androidx.appcompat.widget.w.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.w r6 = androidx.appcompat.widget.w.this
                android.graphics.Rect r6 = r6.q
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L_0x007e
            L_0x0078:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r0
                int r4 = r4 - r2
            L_0x007e:
                r8.v(r4)
                goto L_0x0085
            L_0x0082:
                r8.v(r5)
            L_0x0085:
                androidx.appcompat.widget.w r4 = androidx.appcompat.widget.w.this
                boolean r4 = androidx.appcompat.widget.z0.b(r4)
                if (r4 == 0) goto L_0x0095
                int r3 = r3 - r2
                int r0 = r8.n()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto L_0x0096
            L_0x0095:
                int r1 = r1 + r0
            L_0x0096:
                r8.y(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.c.K():void");
        }

        public CharSequence L() {
            return this.R;
        }

        /* access modifiers changed from: package-private */
        public boolean M(View view) {
            return p.r(view) && view.getGlobalVisibleRect(this.T);
        }

        public void N(CharSequence charSequence) {
            this.R = charSequence;
        }

        public void b() {
            ViewTreeObserver viewTreeObserver;
            boolean f2 = f();
            K();
            z(2);
            super.b();
            g().setChoiceMode(1);
            G(w.this.getSelectedItemPosition());
            if (!f2 && (viewTreeObserver = w.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                B(new C0011c(bVar));
            }
        }

        public void r(ListAdapter listAdapter) {
            super.r(listAdapter);
            this.S = listAdapter;
        }
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.spinnerStyle);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public w(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r12 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0067, code lost:
        if (r12 != null) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.q = r0
            int[] r0 = b.a.j.u2
            r1 = 0
            androidx.appcompat.widget.t0 r0 = androidx.appcompat.widget.t0.t(r8, r9, r0, r10, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r7)
            r7.j = r2
            r2 = 0
            if (r12 == 0) goto L_0x0023
            b.a.m.d r3 = new b.a.m.d
            r3.<init>((android.content.Context) r8, (android.content.res.Resources.Theme) r12)
        L_0x0020:
            r7.k = r3
            goto L_0x003c
        L_0x0023:
            int r12 = b.a.j.z2
            int r12 = r0.m(r12, r1)
            if (r12 == 0) goto L_0x0031
            b.a.m.d r3 = new b.a.m.d
            r3.<init>((android.content.Context) r8, (int) r12)
            goto L_0x0020
        L_0x0031:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L_0x0039
            r12 = r8
            goto L_0x003a
        L_0x0039:
            r12 = r2
        L_0x003a:
            r7.k = r12
        L_0x003c:
            android.content.Context r12 = r7.k
            r3 = 1
            if (r12 == 0) goto L_0x00aa
            r12 = -1
            if (r11 != r12) goto L_0x0072
            int[] r12 = r     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            boolean r4 = r12.hasValue(r1)     // Catch:{ Exception -> 0x005a }
            if (r4 == 0) goto L_0x0054
            int r11 = r12.getInt(r1, r1)     // Catch:{ Exception -> 0x005a }
        L_0x0054:
            if (r12 == 0) goto L_0x0072
        L_0x0056:
            r12.recycle()
            goto L_0x0072
        L_0x005a:
            r4 = move-exception
            goto L_0x0060
        L_0x005c:
            r8 = move-exception
            goto L_0x006c
        L_0x005e:
            r4 = move-exception
            r12 = r2
        L_0x0060:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch:{ all -> 0x006a }
            if (r12 == 0) goto L_0x0072
            goto L_0x0056
        L_0x006a:
            r8 = move-exception
            r2 = r12
        L_0x006c:
            if (r2 == 0) goto L_0x0071
            r2.recycle()
        L_0x0071:
            throw r8
        L_0x0072:
            if (r11 != r3) goto L_0x00aa
            androidx.appcompat.widget.w$c r11 = new androidx.appcompat.widget.w$c
            android.content.Context r12 = r7.k
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.k
            int[] r4 = b.a.j.u2
            androidx.appcompat.widget.t0 r12 = androidx.appcompat.widget.t0.t(r12, r9, r4, r10, r1)
            int r1 = b.a.j.y2
            r4 = -2
            int r1 = r12.l(r1, r4)
            r7.p = r1
            int r1 = b.a.j.w2
            android.graphics.drawable.Drawable r1 = r12.f(r1)
            r11.u(r1)
            int r1 = b.a.j.x2
            java.lang.String r1 = r0.n(r1)
            r11.N(r1)
            r12.u()
            r7.o = r11
            androidx.appcompat.widget.w$a r12 = new androidx.appcompat.widget.w$a
            r12.<init>(r7, r11)
            r7.l = r12
        L_0x00aa:
            int r11 = b.a.j.v2
            java.lang.CharSequence[] r11 = r0.p(r11)
            if (r11 == 0) goto L_0x00c2
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = b.a.g.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter((android.widget.SpinnerAdapter) r12)
        L_0x00c2:
            r0.u()
            r7.n = r3
            android.widget.SpinnerAdapter r8 = r7.m
            if (r8 == 0) goto L_0x00d0
            r7.setAdapter((android.widget.SpinnerAdapter) r8)
            r7.m = r2
        L_0x00d0:
            androidx.appcompat.widget.e r8 = r7.j
            r8.e(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.q);
        Rect rect = this.q;
        return i2 + rect.left + rect.right;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.j;
        if (eVar != null) {
            eVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        c cVar = this.o;
        if (cVar != null) {
            return cVar.k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        c cVar = this.o;
        if (cVar != null) {
            return cVar.m();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.o != null) {
            return this.p;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        c cVar = this.o;
        if (cVar != null) {
            return cVar.j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        if (this.o != null) {
            return this.k;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public CharSequence getPrompt() {
        c cVar = this.o;
        return cVar != null ? cVar.L() : super.getPrompt();
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

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.o;
        if (cVar != null && cVar.f()) {
            this.o.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.o != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        f0 f0Var = this.l;
        if (f0Var == null || !f0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        c cVar = this.o;
        if (cVar == null) {
            return super.performClick();
        }
        if (cVar.f()) {
            return true;
        }
        this.o.b();
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.n) {
            this.m = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.o != null) {
            Context context = this.k;
            if (context == null) {
                context = getContext();
            }
            this.o.r(new b(spinnerAdapter, context.getTheme()));
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

    public void setDropDownHorizontalOffset(int i) {
        c cVar = this.o;
        if (cVar != null) {
            cVar.y(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        c cVar = this.o;
        if (cVar != null) {
            cVar.H(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.o != null) {
            this.p = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        c cVar = this.o;
        if (cVar != null) {
            cVar.u(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(b.a.k.a.a.d(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        c cVar = this.o;
        if (cVar != null) {
            cVar.N(charSequence);
        } else {
            super.setPrompt(charSequence);
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
}
