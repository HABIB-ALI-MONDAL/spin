package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.y;
import b.a.j;
import b.a.m.d;
import b.d.k.p;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f71b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f72c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f73d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Constructor<? extends View>> f74e = new b.c.a();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f75a = new Object[2];

    private static class a implements View.OnClickListener {
        private final View j;
        private final String k;
        private Method l;
        private Context m;

        public a(View view, String str) {
            this.j = view;
            this.k = str;
        }

        private void a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.k, new Class[]{View.class})) != null) {
                        this.l = method;
                        this.m = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.j.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.j.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.k + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.j.getClass() + str2);
        }

        public void onClick(View view) {
            if (this.l == null) {
                a(this.j.getContext(), this.k);
            }
            try {
                this.l.invoke(this.m, new Object[]{view});
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || p.o(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f72c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View q(Context context, String str, String str2) {
        String str3;
        Map<String, Constructor<? extends View>> map = f74e;
        Constructor<? extends U> constructor = map.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(f71b);
                map.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f75a);
    }

    private View r(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            Object[] objArr = this.f75a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i = 0;
                while (true) {
                    String[] strArr = f73d;
                    if (i < strArr.length) {
                        View q = q(context, str, strArr[i]);
                        if (q != null) {
                            return q;
                        }
                        i++;
                    } else {
                        Object[] objArr2 = this.f75a;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View q2 = q(context, str, (String) null);
                Object[] objArr3 = this.f75a;
                objArr3[0] = null;
                objArr3[1] = null;
                return q2;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.f75a;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    private static Context s(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.n3, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(j.o3, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.p3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? (!(context instanceof d) || ((d) context).b() != resourceId) ? new d(context, resourceId) : context : context;
    }

    private void t(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(AppCompatViewInflater.class.getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public f c(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public g d(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public h e(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public k f(Context context, AttributeSet attributeSet) {
        return new k(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public m g(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public androidx.appcompat.widget.p i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.p(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public s j(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public t k(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public u l(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public y n(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public View o(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View p(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = s(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = q0.b(context2);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view2 = k(context2, attributeSet);
                break;
            case 1:
                view2 = e(context2, attributeSet);
                break;
            case 2:
                view2 = i(context2, attributeSet);
                break;
            case 3:
                view2 = n(context2, attributeSet);
                break;
            case 4:
                view2 = g(context2, attributeSet);
                break;
            case 5:
                view2 = l(context2, attributeSet);
                break;
            case 6:
                view2 = m(context2, attributeSet);
                break;
            case 7:
                view2 = j(context2, attributeSet);
                break;
            case 8:
                view2 = h(context2, attributeSet);
                break;
            case 9:
                view2 = b(context2, attributeSet);
                break;
            case 10:
                view2 = d(context2, attributeSet);
                break;
            case 11:
                view2 = f(context2, attributeSet);
                break;
            case 12:
                view2 = c(context2, attributeSet);
                break;
            default:
                view2 = o(context2, str, attributeSet);
                break;
        }
        t(view2, str);
        if (view2 == null && context != context2) {
            view2 = r(context2, str, attributeSet);
        }
        if (view2 != null) {
            a(view2, attributeSet);
        }
        return view2;
    }
}
