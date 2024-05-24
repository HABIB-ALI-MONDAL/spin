package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends g0 implements b.a.m.c {
    static final k z0 = new k();
    private final View A;
    private final View B;
    final ImageView C;
    final ImageView D;
    final ImageView E;
    final ImageView F;
    private final View G;
    private p H;
    private Rect I;
    private Rect J;
    private int[] K;
    private int[] L;
    private final ImageView M;
    private final Drawable N;
    private final int O;
    private final int P;
    private final Intent Q;
    private final Intent R;
    private final CharSequence S;
    private m T;
    private l U;
    View.OnFocusChangeListener V;
    private n W;
    private View.OnClickListener a0;
    private boolean b0;
    private boolean c0;
    b.e.a.a d0;
    private boolean e0;
    private CharSequence f0;
    private boolean g0;
    private boolean h0;
    private int i0;
    private boolean j0;
    private CharSequence k0;
    private CharSequence l0;
    private boolean m0;
    private int n0;
    SearchableInfo o0;
    private Bundle p0;
    private final Runnable q0;
    private Runnable r0;
    private final WeakHashMap<String, Drawable.ConstantState> s0;
    private final View.OnClickListener t0;
    View.OnKeyListener u0;
    private final TextView.OnEditorActionListener v0;
    private final AdapterView.OnItemClickListener w0;
    private final AdapterView.OnItemSelectedListener x0;
    final SearchAutoComplete y;
    private TextWatcher y0;
    private final View z;

    public static class SearchAutoComplete extends d {
        private int m;
        private SearchView n;
        private boolean o;
        final Runnable p;

        class a implements Runnable {
            a() {
            }

            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, b.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.p = new a();
            this.m = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.o) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.o = false;
            }
        }

        public boolean enoughToFilter() {
            return this.m <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.o) {
                removeCallbacks(this.p);
                post(this.p);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.n.X();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.n.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.n.hasFocus() && getVisibility() == 0) {
                this.o = true;
                if (SearchView.K(getContext())) {
                    SearchView.z0.c(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.o = false;
                removeCallbacks(this.p);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.o = false;
                removeCallbacks(this.p);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.o = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.n = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.m = i;
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.W(charSequence);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            SearchView.this.d0();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            b.e.a.a aVar = SearchView.this.d0;
            if (aVar != null && (aVar instanceof n0)) {
                aVar.b((Cursor) null);
            }
        }
    }

    class d implements View.OnFocusChangeListener {
        d() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.V;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    class e implements View.OnLayoutChangeListener {
        e() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.z();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.C) {
                searchView.T();
            } else if (view == searchView.E) {
                searchView.P();
            } else if (view == searchView.D) {
                searchView.U();
            } else if (view == searchView.F) {
                searchView.Y();
            } else if (view == searchView.y) {
                searchView.F();
            }
        }
    }

    class g implements View.OnKeyListener {
        g() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.o0 == null) {
                return false;
            }
            if (searchView.y.isPopupShowing() && SearchView.this.y.getListSelection() != -1) {
                return SearchView.this.V(view, i, keyEvent);
            }
            if (SearchView.this.y.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.N(0, (String) null, searchView2.y.getText().toString());
            return true;
        }
    }

    class h implements TextView.OnEditorActionListener {
        h() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.U();
            return true;
        }
    }

    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            SearchView.this.Q(i, 0, (String) null);
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
            SearchView.this.R(i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private Method f182a;

        /* renamed from: b  reason: collision with root package name */
        private Method f183b;

        /* renamed from: c  reason: collision with root package name */
        private Method f184c;

        k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f182a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f183b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f184c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f183b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f182a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f184c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface l {
        boolean a();
    }

    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    public interface n {
        boolean a(int i);

        boolean b(int i);
    }

    static class o extends b.f.a.a {
        public static final Parcelable.Creator<o> CREATOR = new a();
        boolean l;

        static class a implements Parcelable.ClassLoaderCreator<o> {
            a() {
            }

            /* renamed from: a */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            /* renamed from: c */
            public o[] newArray(int i) {
                return new o[i];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.l = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.l + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.l));
        }
    }

    private static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f185a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f186b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f187c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f188d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f189e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f190f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f189e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f185a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f186b.set(rect);
            this.f188d.set(rect);
            Rect rect3 = this.f188d;
            int i = this.f189e;
            rect3.inset(-i, -i);
            this.f187c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0032
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f190f
                r7.f190f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f190f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f188d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r4 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f186b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f190f = r4
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r4 = 0
            L_0x003f:
                if (r4 == 0) goto L_0x006e
                if (r2 == 0) goto L_0x005b
                android.graphics.Rect r2 = r7.f187c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005b
                android.view.View r0 = r7.f185a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f185a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                goto L_0x0064
            L_0x005b:
                android.graphics.Rect r2 = r7.f187c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
            L_0x0064:
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                android.view.View r0 = r7.f185a
                boolean r5 = r0.dispatchTouchEvent(r8)
            L_0x006e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.p.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.I = new Rect();
        this.J = new Rect();
        this.K = new int[2];
        this.L = new int[2];
        this.q0 = new b();
        this.r0 = new c();
        this.s0 = new WeakHashMap<>();
        f fVar = new f();
        this.t0 = fVar;
        this.u0 = new g();
        h hVar = new h();
        this.v0 = hVar;
        i iVar = new i();
        this.w0 = iVar;
        j jVar = new j();
        this.x0 = jVar;
        this.y0 = new a();
        t0 t = t0.t(context, attributeSet, b.a.j.c2, i2, 0);
        LayoutInflater.from(context).inflate(t.m(b.a.j.m2, b.a.g.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(b.a.f.search_src_text);
        this.y = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.z = findViewById(b.a.f.search_edit_frame);
        View findViewById = findViewById(b.a.f.search_plate);
        this.A = findViewById;
        View findViewById2 = findViewById(b.a.f.submit_area);
        this.B = findViewById2;
        ImageView imageView = (ImageView) findViewById(b.a.f.search_button);
        this.C = imageView;
        ImageView imageView2 = (ImageView) findViewById(b.a.f.search_go_btn);
        this.D = imageView2;
        ImageView imageView3 = (ImageView) findViewById(b.a.f.search_close_btn);
        this.E = imageView3;
        ImageView imageView4 = (ImageView) findViewById(b.a.f.search_voice_btn);
        this.F = imageView4;
        ImageView imageView5 = (ImageView) findViewById(b.a.f.search_mag_icon);
        this.M = imageView5;
        b.d.k.p.D(findViewById, t.f(b.a.j.n2));
        b.d.k.p.D(findViewById2, t.f(b.a.j.r2));
        int i3 = b.a.j.q2;
        imageView.setImageDrawable(t.f(i3));
        imageView2.setImageDrawable(t.f(b.a.j.k2));
        imageView3.setImageDrawable(t.f(b.a.j.h2));
        imageView4.setImageDrawable(t.f(b.a.j.t2));
        imageView5.setImageDrawable(t.f(i3));
        this.N = t.f(b.a.j.p2);
        v0.a(imageView, getResources().getString(b.a.h.abc_searchview_description_search));
        this.O = t.m(b.a.j.s2, b.a.g.abc_search_dropdown_item_icons_2line);
        this.P = t.m(b.a.j.i2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.y0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.u0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(t.a(b.a.j.l2, true));
        int e2 = t.e(b.a.j.e2, -1);
        if (e2 != -1) {
            setMaxWidth(e2);
        }
        this.S = t.o(b.a.j.j2);
        this.f0 = t.o(b.a.j.o2);
        int j2 = t.j(b.a.j.g2, -1);
        if (j2 != -1) {
            setImeOptions(j2);
        }
        int j3 = t.j(b.a.j.f2, -1);
        if (j3 != -1) {
            setInputType(j3);
        }
        setFocusable(t.a(b.a.j.d2, true));
        t.u();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.Q = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.R = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.G = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        i0(this.b0);
        e0();
    }

    private Intent A(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.l0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.p0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.o0.getSearchActivity());
        return intent;
    }

    private Intent B(Cursor cursor, int i2, String str) {
        int i3;
        String o2;
        try {
            String o3 = n0.o(cursor, "suggest_intent_action");
            if (o3 == null) {
                o3 = this.o0.getSuggestIntentAction();
            }
            if (o3 == null) {
                o3 = "android.intent.action.SEARCH";
            }
            String str2 = o3;
            String o4 = n0.o(cursor, "suggest_intent_data");
            if (o4 == null) {
                o4 = this.o0.getSuggestIntentData();
            }
            if (!(o4 == null || (o2 = n0.o(cursor, "suggest_intent_data_id")) == null)) {
                o4 = o4 + "/" + Uri.encode(o2);
            }
            return A(str2, o4 == null ? null : Uri.parse(o4), n0.o(cursor, "suggest_intent_extra_data"), n0.o(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent C(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.p0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent D(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void E() {
        this.y.dismissDropDown();
    }

    private void G(View view, Rect rect) {
        view.getLocationInWindow(this.K);
        getLocationInWindow(this.L);
        int[] iArr = this.K;
        int i2 = iArr[1];
        int[] iArr2 = this.L;
        int i3 = i2 - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i3, view.getWidth() + i4, view.getHeight() + i3);
    }

    private CharSequence H(CharSequence charSequence) {
        if (!this.b0 || this.N == null) {
            return charSequence;
        }
        double textSize = (double) this.y.getTextSize();
        Double.isNaN(textSize);
        int i2 = (int) (textSize * 1.25d);
        this.N.setBounds(0, 0, i2, i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.N), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean I() {
        SearchableInfo searchableInfo = this.o0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.o0.getVoiceSearchLaunchWebSearch()) {
            intent = this.Q;
        } else if (this.o0.getVoiceSearchLaunchRecognizer()) {
            intent = this.R;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean K(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean L() {
        return (this.e0 || this.j0) && !J();
    }

    private void M(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.e("SearchView", "Failed launch activity: " + intent, e2);
            }
        }
    }

    private boolean O(int i2, int i3, String str) {
        Cursor c2 = this.d0.c();
        if (c2 == null || !c2.moveToPosition(i2)) {
            return false;
        }
        M(B(c2, i3, str));
        return true;
    }

    private void Z() {
        post(this.q0);
    }

    private void a0(int i2) {
        CharSequence a2;
        Editable text = this.y.getText();
        Cursor c2 = this.d0.c();
        if (c2 != null) {
            if (!c2.moveToPosition(i2) || (a2 = this.d0.a(c2)) == null) {
                setQuery(text);
            } else {
                setQuery(a2);
            }
        }
    }

    private void c0() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.y.getText());
        int i2 = 0;
        if (!z3 && (!this.b0 || this.m0)) {
            z2 = false;
        }
        ImageView imageView = this.E;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.E.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void e0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.y;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(H(queryHint));
    }

    private void f0() {
        this.y.setThreshold(this.o0.getSuggestThreshold());
        this.y.setImeOptions(this.o0.getImeOptions());
        int inputType = this.o0.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.o0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.y.setInputType(inputType);
        b.e.a.a aVar = this.d0;
        if (aVar != null) {
            aVar.b((Cursor) null);
        }
        if (this.o0.getSuggestAuthority() != null) {
            n0 n0Var = new n0(getContext(), this, this.o0, this.s0);
            this.d0 = n0Var;
            this.y.setAdapter(n0Var);
            n0 n0Var2 = (n0) this.d0;
            if (this.g0) {
                i2 = 2;
            }
            n0Var2.x(i2);
        }
    }

    private void g0() {
        this.B.setVisibility((!L() || !(this.D.getVisibility() == 0 || this.F.getVisibility() == 0)) ? 8 : 0);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(b.a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(b.a.d.abc_search_view_preferred_width);
    }

    private void h0(boolean z2) {
        this.D.setVisibility((!this.e0 || !L() || !hasFocus() || (!z2 && this.j0)) ? 8 : 0);
    }

    private void i0(boolean z2) {
        this.c0 = z2;
        int i2 = 0;
        int i3 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.y.getText());
        this.C.setVisibility(i3);
        h0(z3);
        this.z.setVisibility(z2 ? 8 : 0);
        if (this.M.getDrawable() == null || this.b0) {
            i2 = 8;
        }
        this.M.setVisibility(i2);
        c0();
        j0(!z3);
        g0();
    }

    private void j0(boolean z2) {
        int i2 = 8;
        if (this.j0 && !J() && z2) {
            this.D.setVisibility(8);
            i2 = 0;
        }
        this.F.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        this.y.setText(charSequence);
        this.y.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public void F() {
        k kVar = z0;
        kVar.b(this.y);
        kVar.a(this.y);
    }

    public boolean J() {
        return this.c0;
    }

    /* access modifiers changed from: package-private */
    public void N(int i2, String str, String str2) {
        getContext().startActivity(A("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (!TextUtils.isEmpty(this.y.getText())) {
            this.y.setText("");
            this.y.requestFocus();
            this.y.setImeVisibility(true);
        } else if (this.b0) {
            l lVar = this.U;
            if (lVar == null || !lVar.a()) {
                clearFocus();
                i0(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Q(int i2, int i3, String str) {
        n nVar = this.W;
        if (nVar != null && nVar.b(i2)) {
            return false;
        }
        O(i2, 0, (String) null);
        this.y.setImeVisibility(false);
        E();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean R(int i2) {
        n nVar = this.W;
        if (nVar != null && nVar.a(i2)) {
            return false;
        }
        a0(i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void S(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        i0(false);
        this.y.requestFocus();
        this.y.setImeVisibility(true);
        View.OnClickListener onClickListener = this.a0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        Editable text = this.y.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            m mVar = this.T;
            if (mVar == null || !mVar.b(text.toString())) {
                if (this.o0 != null) {
                    N(0, (String) null, text.toString());
                }
                this.y.setImeVisibility(false);
                E();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean V(View view, int i2, KeyEvent keyEvent) {
        if (this.o0 != null && this.d0 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return Q(this.y.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.y.setSelection(i2 == 21 ? 0 : this.y.length());
                this.y.setListSelection(0);
                this.y.clearListSelection();
                z0.c(this.y, true);
                return true;
            } else if (i2 != 19 || this.y.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void W(CharSequence charSequence) {
        Editable text = this.y.getText();
        this.l0 = text;
        boolean z2 = !TextUtils.isEmpty(text);
        h0(z2);
        j0(!z2);
        c0();
        g0();
        if (this.T != null && !TextUtils.equals(charSequence, this.k0)) {
            this.T.a(charSequence.toString());
        }
        this.k0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void X() {
        i0(J());
        Z();
        if (this.y.hasFocus()) {
            F();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        Intent C2;
        SearchableInfo searchableInfo = this.o0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    C2 = D(this.Q, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    C2 = C(this.R, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(C2);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    public void b0(CharSequence charSequence, boolean z2) {
        this.y.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.y;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.l0 = charSequence;
        }
        if (z2 && !TextUtils.isEmpty(charSequence)) {
            U();
        }
    }

    public void c() {
        if (!this.m0) {
            this.m0 = true;
            int imeOptions = this.y.getImeOptions();
            this.n0 = imeOptions;
            this.y.setImeOptions(imeOptions | 33554432);
            this.y.setText("");
            setIconified(false);
        }
    }

    public void clearFocus() {
        this.h0 = true;
        super.clearFocus();
        this.y.clearFocus();
        this.y.setImeVisibility(false);
        this.h0 = false;
    }

    public void d() {
        b0("", false);
        clearFocus();
        i0(true);
        this.y.setImeOptions(this.n0);
        this.m0 = false;
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        int[] iArr = this.y.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.A.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.B.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.y.getImeOptions();
    }

    public int getInputType() {
        return this.y.getInputType();
    }

    public int getMaxWidth() {
        return this.i0;
    }

    public CharSequence getQuery() {
        return this.y.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f0;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.o0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.S : getContext().getText(this.o0.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.P;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.O;
    }

    public b.e.a.a getSuggestionsAdapter() {
        return this.d0;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.q0);
        post(this.r0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            G(this.y, this.I);
            Rect rect = this.J;
            Rect rect2 = this.I;
            rect.set(rect2.left, 0, rect2.right, i5 - i3);
            p pVar = this.H;
            if (pVar == null) {
                p pVar2 = new p(this.J, this.I, this.y);
                this.H = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.J, this.I);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.J()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x002c
            if (r0 == 0) goto L_0x0022
            if (r0 == r2) goto L_0x001d
            goto L_0x0039
        L_0x001d:
            int r0 = r3.i0
            if (r0 <= 0) goto L_0x0039
            goto L_0x0030
        L_0x0022:
            int r4 = r3.i0
            if (r4 <= 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            int r4 = r3.getPreferredWidth()
            goto L_0x0039
        L_0x002c:
            int r0 = r3.i0
            if (r0 <= 0) goto L_0x0031
        L_0x0030:
            goto L_0x0035
        L_0x0031:
            int r0 = r3.getPreferredWidth()
        L_0x0035:
            int r4 = java.lang.Math.min(r0, r4)
        L_0x0039:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004b
            if (r0 == 0) goto L_0x0046
            goto L_0x0053
        L_0x0046:
            int r5 = r3.getPreferredHeight()
            goto L_0x0053
        L_0x004b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0053:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        i0(oVar.l);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.l = J();
        return oVar;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        Z();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.h0 || !isFocusable()) {
            return false;
        }
        if (J()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.y.requestFocus(i2, rect);
        if (requestFocus) {
            i0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.p0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            P();
        } else {
            T();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.b0 != z2) {
            this.b0 = z2;
            i0(z2);
            e0();
        }
    }

    public void setImeOptions(int i2) {
        this.y.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.y.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.i0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.U = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.V = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.T = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.a0 = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.W = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f0 = charSequence;
        e0();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.g0 = z2;
        b.e.a.a aVar = this.d0;
        if (aVar instanceof n0) {
            ((n0) aVar).x(z2 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.o0 = searchableInfo;
        if (searchableInfo != null) {
            f0();
            e0();
        }
        boolean I2 = I();
        this.j0 = I2;
        if (I2) {
            this.y.setPrivateImeOptions("nm");
        }
        i0(J());
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.e0 = z2;
        i0(J());
    }

    public void setSuggestionsAdapter(b.e.a.a aVar) {
        this.d0 = aVar;
        this.y.setAdapter(aVar);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.G.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.A.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = z0.b(this);
            int dimensionPixelSize = this.b0 ? resources.getDimensionPixelSize(b.a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(b.a.d.abc_dropdownitem_text_padding_left) : 0;
            this.y.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.y.setDropDownHorizontalOffset(b2 ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.y.setDropDownWidth((((this.G.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }
}
