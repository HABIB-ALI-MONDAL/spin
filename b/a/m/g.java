package b.a.m;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.c0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f493e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f494f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f495a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f496b;

    /* renamed from: c  reason: collision with root package name */
    Context f497c;

    /* renamed from: d  reason: collision with root package name */
    private Object f498d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f499c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f500a;

        /* renamed from: b  reason: collision with root package name */
        private Method f501b;

        public a(Object obj, String str) {
            this.f500a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f501b = cls.getMethod(str, f499c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f501b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f501b.invoke(this.f500a, new Object[]{menuItem})).booleanValue();
                }
                this.f501b.invoke(this.f500a, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {
        b.d.k.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f502a;

        /* renamed from: b  reason: collision with root package name */
        private int f503b;

        /* renamed from: c  reason: collision with root package name */
        private int f504c;

        /* renamed from: d  reason: collision with root package name */
        private int f505d;

        /* renamed from: e  reason: collision with root package name */
        private int f506e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f507f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f502a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.f497c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!g.this.f497c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z3 = menuItem instanceof j;
            if (z3) {
                j jVar = (j) menuItem;
            }
            if (this.r >= 2) {
                if (z3) {
                    ((j) menuItem).t(true);
                } else if (menuItem instanceof k) {
                    ((k) menuItem).i(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f493e, g.this.f495a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            b.d.k.b bVar = this.A;
            if (bVar != null) {
                b.d.k.g.a(menuItem, bVar);
            }
            b.d.k.g.c(menuItem, this.B);
            b.d.k.g.g(menuItem, this.C);
            b.d.k.g.b(menuItem, this.n, this.o);
            b.d.k.g.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                b.d.k.g.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                b.d.k.g.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            i(this.f502a.add(this.f503b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f502a.addSubMenu(this.f503b, this.i, this.j, this.k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f497c.obtainStyledAttributes(attributeSet, b.a.j.m1);
            this.f503b = obtainStyledAttributes.getResourceId(b.a.j.o1, 0);
            this.f504c = obtainStyledAttributes.getInt(b.a.j.q1, 0);
            this.f505d = obtainStyledAttributes.getInt(b.a.j.r1, 0);
            this.f506e = obtainStyledAttributes.getInt(b.a.j.s1, 0);
            this.f507f = obtainStyledAttributes.getBoolean(b.a.j.p1, true);
            this.g = obtainStyledAttributes.getBoolean(b.a.j.n1, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f497c.obtainStyledAttributes(attributeSet, b.a.j.t1);
            this.i = obtainStyledAttributes.getResourceId(b.a.j.w1, 0);
            this.j = (obtainStyledAttributes.getInt(b.a.j.z1, this.f504c) & -65536) | (obtainStyledAttributes.getInt(b.a.j.A1, this.f505d) & 65535);
            this.k = obtainStyledAttributes.getText(b.a.j.B1);
            this.l = obtainStyledAttributes.getText(b.a.j.C1);
            this.m = obtainStyledAttributes.getResourceId(b.a.j.u1, 0);
            this.n = c(obtainStyledAttributes.getString(b.a.j.D1));
            this.o = obtainStyledAttributes.getInt(b.a.j.K1, 4096);
            this.p = c(obtainStyledAttributes.getString(b.a.j.E1));
            this.q = obtainStyledAttributes.getInt(b.a.j.O1, 4096);
            int i2 = b.a.j.F1;
            this.r = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getBoolean(i2, false) : this.f506e;
            this.s = obtainStyledAttributes.getBoolean(b.a.j.x1, false);
            this.t = obtainStyledAttributes.getBoolean(b.a.j.y1, this.f507f);
            this.u = obtainStyledAttributes.getBoolean(b.a.j.v1, this.g);
            this.v = obtainStyledAttributes.getInt(b.a.j.P1, -1);
            this.z = obtainStyledAttributes.getString(b.a.j.G1);
            this.w = obtainStyledAttributes.getResourceId(b.a.j.H1, 0);
            this.x = obtainStyledAttributes.getString(b.a.j.J1);
            String string = obtainStyledAttributes.getString(b.a.j.I1);
            this.y = string;
            boolean z2 = string != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (b.d.k.b) e(string, g.f494f, g.this.f496b);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(b.a.j.L1);
            this.C = obtainStyledAttributes.getText(b.a.j.Q1);
            int i3 = b.a.j.N1;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.E = c0.d(obtainStyledAttributes.getInt(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = b.a.j.M1;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.D = obtainStyledAttributes.getColorStateList(i4);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public void h() {
            this.f503b = 0;
            this.f504c = 0;
            this.f505d = 0;
            this.f506e = 0;
            this.f507f = true;
            this.g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f493e = r0
            f494f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.m.g.<clinit>():void");
    }

    public g(Context context) {
        super(context);
        this.f497c = context;
        Object[] objArr = {context};
        this.f495a = objArr;
        this.f496b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                b.d.k.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f498d == null) {
            this.f498d = a(this.f497c);
        }
        return this.f498d;
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof b.d.f.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f497c.getResources().getLayout(i);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
