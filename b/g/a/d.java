package b.g.a;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.k;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

public class d implements ComponentCallbacks, View.OnCreateContextMenuListener, g, t {
    private static final b.c.g<String, Class<?>> f0 = new b.c.g<>();
    static final Object g0 = new Object();
    j A;
    h B;
    j C;
    k D;
    s E;
    d F;
    int G;
    int H;
    String I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O = true;
    boolean P;
    ViewGroup Q;
    View R;
    View S;
    boolean T;
    boolean U = true;
    C0033d V;
    boolean W;
    boolean X;
    float Y;
    LayoutInflater Z;
    boolean a0;
    h b0 = new h(this);
    h c0;
    g d0;
    l<g> e0 = new l<>();
    int j = 0;
    Bundle k;
    SparseArray<Parcelable> l;
    Boolean m;
    int n = -1;
    String o;
    Bundle p;
    d q;
    int r = -1;
    int s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    int z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            d.this.f();
        }
    }

    class b extends f {
        b() {
        }

        public d a(Context context, String str, Bundle bundle) {
            return d.this.B.a(context, str, bundle);
        }

        public View b(int i) {
            View view = d.this.R;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean c() {
            return d.this.R != null;
        }
    }

    class c implements g {
        c() {
        }

        public androidx.lifecycle.d a() {
            d dVar = d.this;
            if (dVar.c0 == null) {
                dVar.c0 = new h(dVar.d0);
            }
            return d.this.c0;
        }
    }

    /* renamed from: b.g.a.d$d  reason: collision with other inner class name */
    static class C0033d {

        /* renamed from: a  reason: collision with root package name */
        View f687a;

        /* renamed from: b  reason: collision with root package name */
        Animator f688b;

        /* renamed from: c  reason: collision with root package name */
        int f689c;

        /* renamed from: d  reason: collision with root package name */
        int f690d;

        /* renamed from: e  reason: collision with root package name */
        int f691e;

        /* renamed from: f  reason: collision with root package name */
        int f692f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        k o;
        k p;
        boolean q;
        f r;
        boolean s;

        C0033d() {
            Object obj = d.g0;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
        }
    }

    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface f {
        void a();

        void b();
    }

    public static d J(Context context, String str, Bundle bundle) {
        try {
            b.c.g<String, Class<?>> gVar = f0;
            Class<?> cls = gVar.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                gVar.put(str, cls);
            }
            d dVar = (d) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(dVar.getClass().getClassLoader());
                dVar.a1(bundle);
            }
            return dVar;
        } catch (ClassNotFoundException e2) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e3);
        } catch (IllegalAccessException e4) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    static boolean Q(Context context, String str) {
        try {
            b.c.g<String, Class<?>> gVar = f0;
            Class<?> cls = gVar.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                gVar.put(str, cls);
            }
            return d.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private C0033d i() {
        if (this.V == null) {
            this.V = new C0033d();
        }
        return this.V;
    }

    public final d A() {
        return this.F;
    }

    /* access modifiers changed from: package-private */
    public void A0(Configuration configuration) {
        onConfigurationChanged(configuration);
        j jVar = this.C;
        if (jVar != null) {
            jVar.v(configuration);
        }
    }

    public Object B() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.j;
        return obj == g0 ? t() : obj;
    }

    /* access modifiers changed from: package-private */
    public boolean B0(MenuItem menuItem) {
        if (this.J) {
            return false;
        }
        if (X(menuItem)) {
            return true;
        }
        j jVar = this.C;
        return jVar != null && jVar.w(menuItem);
    }

    public final Resources C() {
        return V0().getResources();
    }

    /* access modifiers changed from: package-private */
    public void C0(Bundle bundle) {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
        }
        this.j = 1;
        this.P = false;
        Y(bundle);
        this.a0 = true;
        if (this.P) {
            this.b0.h(d.b.ON_CREATE);
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onCreate()");
    }

    public Object D() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.h;
        return obj == g0 ? r() : obj;
    }

    /* access modifiers changed from: package-private */
    public boolean D0(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            b0(menu, menuInflater);
            z2 = true;
        }
        j jVar = this.C;
        return jVar != null ? z2 | jVar.y(menu, menuInflater) : z2;
    }

    public Object E() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.k;
    }

    /* access modifiers changed from: package-private */
    public void E0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
        }
        this.y = true;
        this.d0 = new c();
        this.c0 = null;
        View c02 = c0(layoutInflater, viewGroup, bundle);
        this.R = c02;
        if (c02 != null) {
            this.d0.a();
            this.e0.i(this.d0);
        } else if (this.c0 == null) {
            this.d0 = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    public Object F() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.l;
        return obj == g0 ? E() : obj;
    }

    /* access modifiers changed from: package-private */
    public void F0() {
        this.b0.h(d.b.ON_DESTROY);
        j jVar = this.C;
        if (jVar != null) {
            jVar.z();
        }
        this.j = 0;
        this.P = false;
        this.a0 = false;
        d0();
        if (this.P) {
            this.C = null;
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* access modifiers changed from: package-private */
    public int G() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return 0;
        }
        return dVar.f689c;
    }

    /* access modifiers changed from: package-private */
    public void G0() {
        if (this.R != null) {
            this.c0.h(d.b.ON_DESTROY);
        }
        j jVar = this.C;
        if (jVar != null) {
            jVar.A();
        }
        this.j = 1;
        this.P = false;
        f0();
        if (this.P) {
            b.j.a.a.b(this).c();
            this.y = false;
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    public View H() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public void H0() {
        this.P = false;
        g0();
        this.Z = null;
        if (this.P) {
            j jVar = this.C;
            if (jVar == null) {
                return;
            }
            if (this.M) {
                jVar.z();
                this.C = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
        throw new s("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* access modifiers changed from: package-private */
    public void I() {
        this.n = -1;
        this.o = null;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.z = 0;
        this.A = null;
        this.C = null;
        this.B = null;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = false;
        this.K = false;
        this.M = false;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater I0(Bundle bundle) {
        LayoutInflater h0 = h0(bundle);
        this.Z = h0;
        return h0;
    }

    /* access modifiers changed from: package-private */
    public void J0() {
        onLowMemory();
        j jVar = this.C;
        if (jVar != null) {
            jVar.B();
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        if (this.B != null) {
            j jVar = new j();
            this.C = jVar;
            jVar.m(this.B, new b(), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    /* access modifiers changed from: package-private */
    public void K0(boolean z2) {
        l0(z2);
        j jVar = this.C;
        if (jVar != null) {
            jVar.C(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return false;
        }
        return dVar.s;
    }

    /* access modifiers changed from: package-private */
    public boolean L0(MenuItem menuItem) {
        if (this.J) {
            return false;
        }
        if (this.N && this.O && m0(menuItem)) {
            return true;
        }
        j jVar = this.C;
        return jVar != null && jVar.R(menuItem);
    }

    /* access modifiers changed from: package-private */
    public final boolean M() {
        return this.z > 0;
    }

    /* access modifiers changed from: package-private */
    public void M0(Menu menu) {
        if (!this.J) {
            if (this.N && this.O) {
                n0(menu);
            }
            j jVar = this.C;
            if (jVar != null) {
                jVar.S(menu);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return false;
        }
        return dVar.q;
    }

    /* access modifiers changed from: package-private */
    public void N0() {
        if (this.R != null) {
            this.c0.h(d.b.ON_PAUSE);
        }
        this.b0.h(d.b.ON_PAUSE);
        j jVar = this.C;
        if (jVar != null) {
            jVar.T();
        }
        this.j = 3;
        this.P = false;
        o0();
        if (!this.P) {
            throw new s("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public final boolean O() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public void O0(boolean z2) {
        p0(z2);
        j jVar = this.C;
        if (jVar != null) {
            jVar.U(z2);
        }
    }

    public final boolean P() {
        j jVar = this.A;
        if (jVar == null) {
            return false;
        }
        return jVar.e();
    }

    /* access modifiers changed from: package-private */
    public boolean P0(Menu menu) {
        boolean z2 = false;
        if (this.J) {
            return false;
        }
        if (this.N && this.O) {
            q0(menu);
            z2 = true;
        }
        j jVar = this.C;
        return jVar != null ? z2 | jVar.V(menu) : z2;
    }

    /* access modifiers changed from: package-private */
    public void Q0() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
            this.C.f0();
        }
        this.j = 4;
        this.P = false;
        s0();
        if (this.P) {
            j jVar2 = this.C;
            if (jVar2 != null) {
                jVar2.W();
                this.C.f0();
            }
            h hVar = this.b0;
            d.b bVar = d.b.ON_RESUME;
            hVar.h(bVar);
            if (this.R != null) {
                this.c0.h(bVar);
                return;
            }
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void R() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
        }
    }

    /* access modifiers changed from: package-private */
    public void R0(Bundle bundle) {
        Parcelable T0;
        t0(bundle);
        j jVar = this.C;
        if (jVar != null && (T0 = jVar.T0()) != null) {
            bundle.putParcelable("android:support:fragments", T0);
        }
    }

    public void S(Bundle bundle) {
        this.P = true;
    }

    /* access modifiers changed from: package-private */
    public void S0() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
            this.C.f0();
        }
        this.j = 3;
        this.P = false;
        u0();
        if (this.P) {
            j jVar2 = this.C;
            if (jVar2 != null) {
                jVar2.X();
            }
            h hVar = this.b0;
            d.b bVar = d.b.ON_START;
            hVar.h(bVar);
            if (this.R != null) {
                this.c0.h(bVar);
                return;
            }
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStart()");
    }

    public void T(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public void T0() {
        if (this.R != null) {
            this.c0.h(d.b.ON_STOP);
        }
        this.b0.h(d.b.ON_STOP);
        j jVar = this.C;
        if (jVar != null) {
            jVar.Z();
        }
        this.j = 2;
        this.P = false;
        v0();
        if (!this.P) {
            throw new s("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    @Deprecated
    public void U(Activity activity) {
        this.P = true;
    }

    public final void U0(String[] strArr, int i) {
        h hVar = this.B;
        if (hVar != null) {
            hVar.m(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void V(Context context) {
        this.P = true;
        h hVar = this.B;
        Activity d2 = hVar == null ? null : hVar.d();
        if (d2 != null) {
            this.P = false;
            U(d2);
        }
    }

    public final Context V0() {
        Context q2 = q();
        if (q2 != null) {
            return q2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void W(d dVar) {
    }

    /* access modifiers changed from: package-private */
    public void W0(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.C == null) {
                K();
            }
            this.C.Q0(parcelable, this.D);
            this.D = null;
            this.C.x();
        }
    }

    public boolean X(MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void X0(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.l;
        if (sparseArray != null) {
            this.S.restoreHierarchyState(sparseArray);
            this.l = null;
        }
        this.P = false;
        x0(bundle);
        if (!this.P) {
            throw new s("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.R != null) {
            this.c0.h(d.b.ON_CREATE);
        }
    }

    public void Y(Bundle bundle) {
        this.P = true;
        W0(bundle);
        j jVar = this.C;
        if (jVar != null && !jVar.u0(1)) {
            this.C.x();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y0(View view) {
        i().f687a = view;
    }

    public Animation Z(int i, boolean z2, int i2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void Z0(Animator animator) {
        i().f688b = animator;
    }

    public androidx.lifecycle.d a() {
        return this.b0;
    }

    public Animator a0(int i, boolean z2, int i2) {
        return null;
    }

    public void a1(Bundle bundle) {
        if (this.n < 0 || !P()) {
            this.p = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    public void b0(Menu menu, MenuInflater menuInflater) {
    }

    /* access modifiers changed from: package-private */
    public void b1(boolean z2) {
        i().s = z2;
    }

    public View c0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void c1(int i, d dVar) {
        StringBuilder sb;
        String str;
        this.n = i;
        if (dVar != null) {
            sb.append(dVar.o);
            str = ":";
        } else {
            sb = new StringBuilder();
            str = "android:fragment:";
        }
        sb.append(str);
        sb.append(this.n);
        this.o = sb.toString();
    }

    public void d0() {
        boolean z2 = true;
        this.P = true;
        e k2 = k();
        if (k2 == null || !k2.isChangingConfigurations()) {
            z2 = false;
        }
        s sVar = this.E;
        if (sVar != null && !z2) {
            sVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void d1(int i) {
        if (this.V != null || i != 0) {
            i().f690d = i;
        }
    }

    public void e0() {
    }

    /* access modifiers changed from: package-private */
    public void e1(int i, int i2) {
        if (this.V != null || i != 0 || i2 != 0) {
            i();
            C0033d dVar = this.V;
            dVar.f691e = i;
            dVar.f692f = i2;
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        C0033d dVar = this.V;
        f fVar = null;
        if (dVar != null) {
            dVar.q = false;
            f fVar2 = dVar.r;
            dVar.r = null;
            fVar = fVar2;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    public void f0() {
        this.P = true;
    }

    /* access modifiers changed from: package-private */
    public void f1(f fVar) {
        i();
        C0033d dVar = this.V;
        f fVar2 = dVar.r;
        if (fVar != fVar2) {
            if (fVar == null || fVar2 == null) {
                if (dVar.q) {
                    dVar.r = fVar;
                }
                if (fVar != null) {
                    fVar.b();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public s g() {
        if (q() != null) {
            if (this.E == null) {
                this.E = new s();
            }
            return this.E;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void g0() {
        this.P = true;
    }

    /* access modifiers changed from: package-private */
    public void g1(int i) {
        i().f689c = i;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.G));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mTag=");
        printWriter.println(this.I);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.j);
        printWriter.print(" mIndex=");
        printWriter.print(this.n);
        printWriter.print(" mWho=");
        printWriter.print(this.o);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.z);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.t);
        printWriter.print(" mRemoving=");
        printWriter.print(this.u);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.v);
        printWriter.print(" mInLayout=");
        printWriter.println(this.w);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.J);
        printWriter.print(" mDetached=");
        printWriter.print(this.K);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.O);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.N);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.L);
        printWriter.print(" mRetaining=");
        printWriter.print(this.M);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.U);
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.A);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.B);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.F);
        }
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.p);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.k);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.l);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.q);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.s);
        }
        if (x() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(x());
        }
        if (this.Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.Q);
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.R);
        }
        if (n() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(n());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(G());
        }
        if (q() != null) {
            b.j.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.C + ":");
            j jVar = this.C;
            jVar.b(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public LayoutInflater h0(Bundle bundle) {
        return w(bundle);
    }

    public void h1(Intent intent, int i, Bundle bundle) {
        h hVar = this.B;
        if (hVar != null) {
            hVar.o(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i0(boolean z2) {
    }

    public void i1() {
        j jVar = this.A;
        if (jVar == null || jVar.v == null) {
            i().q = false;
        } else if (Looper.myLooper() != this.A.v.g().getLooper()) {
            this.A.v.g().postAtFrontOfQueue(new a());
        } else {
            f();
        }
    }

    /* access modifiers changed from: package-private */
    public d j(String str) {
        if (str.equals(this.o)) {
            return this;
        }
        j jVar = this.C;
        if (jVar != null) {
            return jVar.k0(str);
        }
        return null;
    }

    @Deprecated
    public void j0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
    }

    public final e k() {
        h hVar = this.B;
        if (hVar == null) {
            return null;
        }
        return (e) hVar.d();
    }

    public void k0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.P = true;
        h hVar = this.B;
        Activity d2 = hVar == null ? null : hVar.d();
        if (d2 != null) {
            this.P = false;
            j0(d2, attributeSet, bundle);
        }
    }

    public boolean l() {
        Boolean bool;
        C0033d dVar = this.V;
        if (dVar == null || (bool = dVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void l0(boolean z2) {
    }

    public boolean m() {
        Boolean bool;
        C0033d dVar = this.V;
        if (dVar == null || (bool = dVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean m0(MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public View n() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.f687a;
    }

    public void n0(Menu menu) {
    }

    /* access modifiers changed from: package-private */
    public Animator o() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.f688b;
    }

    public void o0() {
        this.P = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.P = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        k().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.P = true;
    }

    public final i p() {
        if (this.C == null) {
            K();
            int i = this.j;
            if (i >= 4) {
                this.C.W();
            } else if (i >= 3) {
                this.C.X();
            } else if (i >= 2) {
                this.C.u();
            } else if (i >= 1) {
                this.C.x();
            }
        }
        return this.C;
    }

    public void p0(boolean z2) {
    }

    public Context q() {
        h hVar = this.B;
        if (hVar == null) {
            return null;
        }
        return hVar.e();
    }

    public void q0(Menu menu) {
    }

    public Object r() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.g;
    }

    public void r0(int i, String[] strArr, int[] iArr) {
    }

    /* access modifiers changed from: package-private */
    public k s() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.o;
    }

    public void s0() {
        this.P = true;
    }

    public void startActivityForResult(Intent intent, int i) {
        h1(intent, i, (Bundle) null);
    }

    public Object t() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.i;
    }

    public void t0(Bundle bundle) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        b.d.j.a.a(this, sb);
        if (this.n >= 0) {
            sb.append(" #");
            sb.append(this.n);
        }
        if (this.G != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.G));
        }
        if (this.I != null) {
            sb.append(" ");
            sb.append(this.I);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public k u() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return null;
        }
        return dVar.p;
    }

    public void u0() {
        this.P = true;
    }

    public final i v() {
        return this.A;
    }

    public void v0() {
        this.P = true;
    }

    @Deprecated
    public LayoutInflater w(Bundle bundle) {
        h hVar = this.B;
        if (hVar != null) {
            LayoutInflater j2 = hVar.j();
            p();
            j jVar = this.C;
            jVar.r0();
            b.d.k.e.b(j2, jVar);
            return j2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void w0(View view, Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public int x() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return 0;
        }
        return dVar.f690d;
    }

    public void x0(Bundle bundle) {
        this.P = true;
    }

    /* access modifiers changed from: package-private */
    public int y() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return 0;
        }
        return dVar.f691e;
    }

    /* access modifiers changed from: package-private */
    public i y0() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        C0033d dVar = this.V;
        if (dVar == null) {
            return 0;
        }
        return dVar.f692f;
    }

    /* access modifiers changed from: package-private */
    public void z0(Bundle bundle) {
        j jVar = this.C;
        if (jVar != null) {
            jVar.H0();
        }
        this.j = 2;
        this.P = false;
        S(bundle);
        if (this.P) {
            j jVar2 = this.C;
            if (jVar2 != null) {
                jVar2.u();
                return;
            }
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
}
