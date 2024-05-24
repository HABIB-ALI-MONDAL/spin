package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import b.c.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class j {
    private static final PorterDuff.Mode g = PorterDuff.Mode.SRC_IN;
    private static j h;
    private static final c i = new c(6);
    private static final int[] j = {b.a.e.abc_textfield_search_default_mtrl_alpha, b.a.e.abc_textfield_default_mtrl_alpha, b.a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] k = {b.a.e.abc_ic_commit_search_api_mtrl_alpha, b.a.e.abc_seekbar_tick_mark_material, b.a.e.abc_ic_menu_share_mtrl_alpha, b.a.e.abc_ic_menu_copy_mtrl_am_alpha, b.a.e.abc_ic_menu_cut_mtrl_alpha, b.a.e.abc_ic_menu_selectall_mtrl_alpha, b.a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] l = {b.a.e.abc_textfield_activated_mtrl_alpha, b.a.e.abc_textfield_search_activated_mtrl_alpha, b.a.e.abc_cab_background_top_mtrl_alpha, b.a.e.abc_text_cursor_material, b.a.e.abc_text_select_handle_left_mtrl_dark, b.a.e.abc_text_select_handle_middle_mtrl_dark, b.a.e.abc_text_select_handle_right_mtrl_dark, b.a.e.abc_text_select_handle_left_mtrl_light, b.a.e.abc_text_select_handle_middle_mtrl_light, b.a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] m = {b.a.e.abc_popup_background_mtrl_mult, b.a.e.abc_cab_background_internal_bg, b.a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] n = {b.a.e.abc_tab_indicator_material, b.a.e.abc_textfield_search_material};
    private static final int[] o = {b.a.e.abc_btn_check_material, b.a.e.abc_btn_radio_material};

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f214a;

    /* renamed from: b  reason: collision with root package name */
    private b.c.a<String, d> f215b;

    /* renamed from: c  reason: collision with root package name */
    private h<String> f216c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, b.c.d<WeakReference<Drawable.ConstantState>>> f217d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f218e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f219f;

    static class a implements d {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.a.l.a.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    private static class b implements d {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.l.a.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class c extends b.c.e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int j(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter k(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(j(i, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter l(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(j(i, mode)), porterDuffColorFilter);
        }
    }

    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    private static class e implements d {
        e() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.l.a.a.h.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private static void A(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (c0.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = g;
        }
        drawable.setColorFilter(r(i2, mode));
    }

    private Drawable B(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList s = s(context, i2);
        if (s != null) {
            if (c0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable p = androidx.core.graphics.drawable.a.p(drawable);
            androidx.core.graphics.drawable.a.n(p, s);
            PorterDuff.Mode u = u(i2);
            if (u == null) {
                return p;
            }
            androidx.core.graphics.drawable.a.o(p, u);
            return p;
        } else if (i2 == b.a.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
            int i3 = b.a.a.colorControlNormal;
            int b2 = o0.b(context, i3);
            PorterDuff.Mode mode = g;
            A(findDrawableByLayerId, b2, mode);
            A(layerDrawable.findDrawableByLayerId(16908303), o0.b(context, i3), mode);
            A(layerDrawable.findDrawableByLayerId(16908301), o0.b(context, b.a.a.colorControlActivated), mode);
            return drawable;
        } else if (i2 == b.a.e.abc_ratingbar_material || i2 == b.a.e.abc_ratingbar_indicator_material || i2 == b.a.e.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
            int a2 = o0.a(context, b.a.a.colorControlNormal);
            PorterDuff.Mode mode2 = g;
            A(findDrawableByLayerId2, a2, mode2);
            Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
            int i4 = b.a.a.colorControlActivated;
            A(findDrawableByLayerId3, o0.b(context, i4), mode2);
            A(layerDrawable2.findDrawableByLayerId(16908301), o0.b(context, i4), mode2);
            return drawable;
        } else if (D(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    static void C(Drawable drawable, r0 r0Var, int[] iArr) {
        if (!c0.a(drawable) || drawable.mutate() == drawable) {
            boolean z = r0Var.f254d;
            if (z || r0Var.f253c) {
                drawable.setColorFilter(m(z ? r0Var.f251a : null, r0Var.f253c ? r0Var.f252b : g, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean D(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = g
            int[] r1 = j
            boolean r1 = d(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0015
            int r2 = b.a.a.colorControlNormal
        L_0x0012:
            r7 = -1
        L_0x0013:
            r1 = 1
            goto L_0x0042
        L_0x0015:
            int[] r1 = l
            boolean r1 = d(r1, r7)
            if (r1 == 0) goto L_0x0020
            int r2 = b.a.a.colorControlActivated
            goto L_0x0012
        L_0x0020:
            int[] r1 = m
            boolean r1 = d(r1, r7)
            if (r1 == 0) goto L_0x002b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0012
        L_0x002b:
            int r1 = b.a.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L_0x003a
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            goto L_0x0013
        L_0x003a:
            int r1 = b.a.e.abc_dialog_material_background
            if (r7 != r1) goto L_0x003f
            goto L_0x0012
        L_0x003f:
            r7 = -1
            r1 = 0
            r2 = 0
        L_0x0042:
            if (r1 == 0) goto L_0x005f
            boolean r1 = androidx.appcompat.widget.c0.a(r8)
            if (r1 == 0) goto L_0x004e
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L_0x004e:
            int r6 = androidx.appcompat.widget.o0.b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = r(r6, r0)
            r8.setColorFilter(r6)
            if (r7 == r3) goto L_0x005e
            r8.setAlpha(r7)
        L_0x005e:
            return r5
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.D(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private void a(String str, d dVar) {
        if (this.f215b == null) {
            this.f215b = new b.c.a<>();
        }
        this.f215b.put(str, dVar);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            b.c.d dVar = this.f217d.get(context);
            if (dVar == null) {
                dVar = new b.c.d();
                this.f217d.put(context, dVar);
            }
            dVar.l(j2, new WeakReference(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f214a == null) {
            this.f214a = new WeakHashMap<>();
        }
        h hVar = this.f214a.get(context);
        if (hVar == null) {
            hVar = new h();
            this.f214a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    private static boolean d(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void e(Context context) {
        if (!this.f219f) {
            this.f219f = true;
            Drawable p = p(context, b.a.e.abc_vector_test);
            if (p == null || !w(p)) {
                this.f219f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private ColorStateList f(Context context) {
        return g(context, 0);
    }

    private ColorStateList g(Context context, int i2) {
        int b2 = o0.b(context, b.a.a.colorControlHighlight);
        int a2 = o0.a(context, b.a.a.colorButtonNormal);
        return new ColorStateList(new int[][]{o0.f237b, o0.f239d, o0.f238c, o0.f241f}, new int[]{a2, b.d.e.a.b(b2, i2), b.d.e.a.b(b2, i2), i2});
    }

    private static long h(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private ColorStateList i(Context context) {
        return g(context, o0.b(context, b.a.a.colorAccent));
    }

    private ColorStateList j(Context context) {
        return g(context, o0.b(context, b.a.a.colorButtonNormal));
    }

    private Drawable k(Context context, int i2) {
        if (this.f218e == null) {
            this.f218e = new TypedValue();
        }
        TypedValue typedValue = this.f218e;
        context.getResources().getValue(i2, typedValue, true);
        long h2 = h(typedValue);
        Drawable o2 = o(context, h2);
        if (o2 != null) {
            return o2;
        }
        if (i2 == b.a.e.abc_cab_background_top_material) {
            o2 = new LayerDrawable(new Drawable[]{p(context, b.a.e.abc_cab_background_internal_bg), p(context, b.a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (o2 != null) {
            o2.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, h2, o2);
        }
        return o2;
    }

    private ColorStateList l(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        int i2 = b.a.a.colorSwitchThumbNormal;
        ColorStateList d2 = o0.d(context, i2);
        if (d2 == null || !d2.isStateful()) {
            iArr[0] = o0.f237b;
            iArr2[0] = o0.a(context, i2);
            iArr[1] = o0.f240e;
            iArr2[1] = o0.b(context, b.a.a.colorControlActivated);
            iArr[2] = o0.f241f;
            iArr2[2] = o0.b(context, i2);
        } else {
            iArr[0] = o0.f237b;
            iArr2[0] = d2.getColorForState(iArr[0], 0);
            iArr[1] = o0.f240e;
            iArr2[1] = o0.b(context, b.a.a.colorControlActivated);
            iArr[2] = o0.f241f;
            iArr2[2] = d2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private static PorterDuffColorFilter m(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return r(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized j n() {
        j jVar;
        synchronized (j.class) {
            if (h == null) {
                j jVar2 = new j();
                h = jVar2;
                v(jVar2);
            }
            jVar = h;
        }
        return jVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable o(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, b.c.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f217d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            b.c.d r0 = (b.c.d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.i(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.e(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.o(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter r(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter k2;
        synchronized (j.class) {
            c cVar = i;
            k2 = cVar.k(i2, mode);
            if (k2 == null) {
                k2 = new PorterDuffColorFilter(i2, mode);
                cVar.l(i2, mode, k2);
            }
        }
        return k2;
    }

    private ColorStateList t(Context context, int i2) {
        h hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f214a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.i(i2);
    }

    static PorterDuff.Mode u(int i2) {
        if (i2 == b.a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    private static void v(j jVar) {
        if (Build.VERSION.SDK_INT < 24) {
            jVar.a("vector", new e());
            jVar.a("animated-vector", new b());
            jVar.a("animated-selector", new a());
        }
    }

    private static boolean w(Drawable drawable) {
        return (drawable instanceof b.l.a.a.h) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable x(android.content.Context r11, int r12) {
        /*
            r10 = this;
            b.c.a<java.lang.String, androidx.appcompat.widget.j$d> r0 = r10.f215b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            b.c.h<java.lang.String> r0 = r10.f216c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.i(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            b.c.a<java.lang.String, androidx.appcompat.widget.j$d> r3 = r10.f215b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            b.c.h r0 = new b.c.h
            r0.<init>()
            r10.f216c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f218e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f218e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f218e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = h(r0)
            android.graphics.drawable.Drawable r6 = r10.o(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            b.c.h<java.lang.String> r8 = r10.f216c     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            b.c.a<java.lang.String, androidx.appcompat.widget.j$d> r8 = r10.f215b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.j$d r3 = (androidx.appcompat.widget.j.d) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "AppCompatDrawableManag"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            b.c.h<java.lang.String> r11 = r10.f216c
            r11.a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.x(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    public synchronized Drawable p(Context context, int i2) {
        return q(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable q(Context context, int i2, boolean z) {
        Drawable x;
        e(context);
        x = x(context, i2);
        if (x == null) {
            x = k(context, i2);
        }
        if (x == null) {
            x = androidx.core.content.a.f(context, i2);
        }
        if (x != null) {
            x = B(context, i2, z, x);
        }
        if (x != null) {
            c0.b(x);
        }
        return x;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.content.res.ColorStateList s(android.content.Context r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.res.ColorStateList r0 = r2.t(r3, r4)     // Catch:{ all -> 0x007d }
            if (r0 != 0) goto L_0x007b
            int r1 = b.a.e.abc_edit_text_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x0013
            int r0 = b.a.c.abc_tint_edittext     // Catch:{ all -> 0x007d }
        L_0x000d:
            android.content.res.ColorStateList r0 = b.a.k.a.a.c(r3, r0)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x0013:
            int r1 = b.a.e.abc_switch_track_mtrl_alpha     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x001a
            int r0 = b.a.c.abc_tint_switch_track     // Catch:{ all -> 0x007d }
            goto L_0x000d
        L_0x001a:
            int r1 = b.a.e.abc_switch_thumb_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x0023
            android.content.res.ColorStateList r0 = r2.l(r3)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x0023:
            int r1 = b.a.e.abc_btn_default_mtrl_shape     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x002c
            android.content.res.ColorStateList r0 = r2.j(r3)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x002c:
            int r1 = b.a.e.abc_btn_borderless_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x0035
            android.content.res.ColorStateList r0 = r2.f(r3)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x0035:
            int r1 = b.a.e.abc_btn_colored_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x003e
            android.content.res.ColorStateList r0 = r2.i(r3)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x003e:
            int r1 = b.a.e.abc_spinner_mtrl_am_alpha     // Catch:{ all -> 0x007d }
            if (r4 == r1) goto L_0x0073
            int r1 = b.a.e.abc_spinner_textfield_background_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x0047
            goto L_0x0073
        L_0x0047:
            int[] r1 = k     // Catch:{ all -> 0x007d }
            boolean r1 = d(r1, r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0056
            int r0 = b.a.a.colorControlNormal     // Catch:{ all -> 0x007d }
            android.content.res.ColorStateList r0 = androidx.appcompat.widget.o0.d(r3, r0)     // Catch:{ all -> 0x007d }
            goto L_0x0076
        L_0x0056:
            int[] r1 = n     // Catch:{ all -> 0x007d }
            boolean r1 = d(r1, r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0061
            int r0 = b.a.c.abc_tint_default     // Catch:{ all -> 0x007d }
            goto L_0x000d
        L_0x0061:
            int[] r1 = o     // Catch:{ all -> 0x007d }
            boolean r1 = d(r1, r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x006c
            int r0 = b.a.c.abc_tint_btn_checkable     // Catch:{ all -> 0x007d }
            goto L_0x000d
        L_0x006c:
            int r1 = b.a.e.abc_seekbar_thumb_material     // Catch:{ all -> 0x007d }
            if (r4 != r1) goto L_0x0076
            int r0 = b.a.c.abc_tint_seek_thumb     // Catch:{ all -> 0x007d }
            goto L_0x000d
        L_0x0073:
            int r0 = b.a.c.abc_tint_spinner     // Catch:{ all -> 0x007d }
            goto L_0x000d
        L_0x0076:
            if (r0 == 0) goto L_0x007b
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x007d }
        L_0x007b:
            monitor-exit(r2)
            return r0
        L_0x007d:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0081
        L_0x0080:
            throw r3
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.s(android.content.Context, int):android.content.res.ColorStateList");
    }

    public synchronized void y(Context context) {
        b.c.d dVar = this.f217d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable z(Context context, y0 y0Var, int i2) {
        Drawable x = x(context, i2);
        if (x == null) {
            x = y0Var.c(i2);
        }
        if (x == null) {
            return null;
        }
        return B(context, i2, false, x);
    }
}
