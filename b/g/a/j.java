package b.g.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.lifecycle.s;
import b.d.k.p;
import b.g.a.d;
import b.g.a.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class j extends i implements LayoutInflater.Factory2 {
    static boolean N = false;
    static Field O;
    static final Interpolator P = new DecelerateInterpolator(2.5f);
    static final Interpolator Q = new DecelerateInterpolator(1.5f);
    boolean A;
    boolean B;
    boolean C;
    String D;
    boolean E;
    ArrayList<a> F;
    ArrayList<Boolean> G;
    ArrayList<d> H;
    Bundle I = null;
    SparseArray<Parcelable> J = null;
    ArrayList<n> K;
    k L;
    Runnable M = new a();
    ArrayList<l> j;
    boolean k;
    int l = 0;
    final ArrayList<d> m = new ArrayList<>();
    SparseArray<d> n;
    ArrayList<a> o;
    ArrayList<d> p;
    ArrayList<a> q;
    ArrayList<Integer> r;
    ArrayList<i.b> s;
    private final CopyOnWriteArrayList<C0034j> t = new CopyOnWriteArrayList<>();
    int u = 0;
    h v;
    f w;
    d x;
    d y;
    boolean z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            j.this.f0();
        }
    }

    class b extends f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f703b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f704c;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (b.this.f704c.n() != null) {
                    b.this.f704c.Y0((View) null);
                    b bVar = b.this;
                    j jVar = j.this;
                    d dVar = bVar.f704c;
                    jVar.G0(dVar, dVar.G(), 0, 0, false);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Animation.AnimationListener animationListener, ViewGroup viewGroup, d dVar) {
            super(animationListener);
            this.f703b = viewGroup;
            this.f704c = dVar;
        }

        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            this.f703b.post(new a());
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f707b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f708c;

        c(ViewGroup viewGroup, View view, d dVar) {
            this.f706a = viewGroup;
            this.f707b = view;
            this.f708c = dVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f706a.endViewTransition(this.f707b);
            Animator o = this.f708c.o();
            this.f708c.Z0((Animator) null);
            if (o != null && this.f706a.indexOfChild(this.f707b) < 0) {
                j jVar = j.this;
                d dVar = this.f708c;
                jVar.G0(dVar, dVar.G(), 0, 0, false);
            }
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f710a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f711b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f712c;

        d(j jVar, ViewGroup viewGroup, View view, d dVar) {
            this.f710a = viewGroup;
            this.f711b = view;
            this.f712c = dVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f710a.endViewTransition(this.f711b);
            animator.removeListener(this);
            View view = this.f712c.R;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    private static class e extends f {

        /* renamed from: b  reason: collision with root package name */
        View f713b;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e.this.f713b.setLayerType(0, (Paint) null);
            }
        }

        e(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f713b = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (p.r(this.f713b) || Build.VERSION.SDK_INT >= 24) {
                this.f713b.post(new a());
            } else {
                this.f713b.setLayerType(0, (Paint) null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final Animation.AnimationListener f714a;

        f(Animation.AnimationListener animationListener) {
            this.f714a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f714a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f714a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f714a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f715a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f716b;

        g(Animator animator) {
            this.f715a = null;
            this.f716b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.f715a = animation;
            this.f716b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        View f717a;

        h(View view) {
            this.f717a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f717a.setLayerType(0, (Paint) null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.f717a.setLayerType(2, (Paint) null);
        }
    }

    private static class i extends AnimationSet implements Runnable {
        private final ViewGroup j;
        private final View k;
        private boolean l;
        private boolean m;
        private boolean n = true;

        i(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.j = viewGroup;
            this.k = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.n = true;
            if (this.l) {
                return !this.m;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.l = true;
                r.a(this.j, this);
            }
            return true;
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.n = true;
            if (this.l) {
                return !this.m;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.l = true;
                r.a(this.j, this);
            }
            return true;
        }

        public void run() {
            if (this.l || !this.n) {
                this.j.endViewTransition(this.k);
                this.m = true;
                return;
            }
            this.n = false;
            this.j.post(this);
        }
    }

    /* renamed from: b.g.a.j$j  reason: collision with other inner class name */
    private static final class C0034j {

        /* renamed from: a  reason: collision with root package name */
        final i.a f718a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f719b;
    }

    static class k {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f720a = {16842755, 16842960, 16842961};
    }

    interface l {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class m implements l {

        /* renamed from: a  reason: collision with root package name */
        final String f721a;

        /* renamed from: b  reason: collision with root package name */
        final int f722b;

        /* renamed from: c  reason: collision with root package name */
        final int f723c;

        m(String str, int i, int i2) {
            this.f721a = str;
            this.f722b = i;
            this.f723c = i2;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            i y0;
            d dVar = j.this.y;
            if (dVar != null && this.f722b < 0 && this.f721a == null && (y0 = dVar.y0()) != null && y0.g()) {
                return false;
            }
            return j.this.K0(arrayList, arrayList2, this.f721a, this.f722b, this.f723c);
        }
    }

    static class n implements d.f {

        /* renamed from: a  reason: collision with root package name */
        final boolean f725a;

        /* renamed from: b  reason: collision with root package name */
        final a f726b;

        /* renamed from: c  reason: collision with root package name */
        private int f727c;

        n(a aVar, boolean z) {
            this.f725a = z;
            this.f726b = aVar;
        }

        public void a() {
            int i = this.f727c - 1;
            this.f727c = i;
            if (i == 0) {
                this.f726b.f674a.X0();
            }
        }

        public void b() {
            this.f727c++;
        }

        public void c() {
            a aVar = this.f726b;
            aVar.f674a.r(aVar, this.f725a, false, false);
        }

        public void d() {
            boolean z = this.f727c > 0;
            j jVar = this.f726b.f674a;
            int size = jVar.m.size();
            for (int i = 0; i < size; i++) {
                d dVar = jVar.m.get(i);
                dVar.f1((d.f) null);
                if (z && dVar.N()) {
                    dVar.i1();
                }
            }
            a aVar = this.f726b;
            aVar.f674a.r(aVar, this.f725a, !z, true);
        }

        public boolean e() {
            return this.f727c == 0;
        }
    }

    static {
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    j() {
    }

    private void A0(b.c.b<d> bVar) {
        int size = bVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            d r2 = bVar.r(i2);
            if (!r2.t) {
                View H2 = r2.H();
                r2.Y = H2.getAlpha();
                H2.setAlpha(0.0f);
            }
        }
    }

    static boolean B0(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (B0(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean C0(g gVar) {
        Animation animation = gVar.f715a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return B0(gVar.f716b);
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    private boolean J0(String str, int i2, int i3) {
        i y0;
        f0();
        d0(true);
        d dVar = this.y;
        if (dVar != null && i2 < 0 && str == null && (y0 = dVar.y0()) != null && y0.g()) {
            return true;
        }
        boolean K0 = K0(this.F, this.G, str, i2, i3);
        if (K0) {
            this.k = true;
            try {
                O0(this.F, this.G);
            } finally {
                q();
            }
        }
        a0();
        o();
        return K0;
    }

    private int L0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, b.c.b<d> bVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.s() && !aVar.q(arrayList, i5 + 1, i3)) {
                if (this.K == null) {
                    this.K = new ArrayList<>();
                }
                n nVar = new n(aVar, booleanValue);
                this.K.add(nVar);
                aVar.u(nVar);
                if (booleanValue) {
                    aVar.l();
                } else {
                    aVar.m(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                h(bVar);
            }
        }
        return i4;
    }

    private void O0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            i0(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).s) {
                    if (i3 != i2) {
                        h0(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).s) {
                            i3++;
                        }
                    }
                    h0(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                h0(arrayList, arrayList2, i3, size);
            }
        }
    }

    public static int S0(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: finally extract failed */
    private void Y(int i2) {
        try {
            this.k = true;
            E0(i2, false);
            this.k = false;
            f0();
        } catch (Throwable th) {
            this.k = false;
            throw th;
        }
    }

    private static void Z0(View view, g gVar) {
        if (view != null && gVar != null && c1(view, gVar)) {
            Animator animator = gVar.f716b;
            if (animator != null) {
                animator.addListener(new h(view));
                return;
            }
            Animation.AnimationListener p0 = p0(gVar.f715a);
            view.setLayerType(2, (Paint) null);
            gVar.f715a.setAnimationListener(new e(view, p0));
        }
    }

    private void b0() {
        SparseArray<d> sparseArray = this.n;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            d valueAt = this.n.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.n() != null) {
                    int G2 = valueAt.G();
                    View n2 = valueAt.n();
                    Animation animation = n2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        n2.clearAnimation();
                    }
                    valueAt.Y0((View) null);
                    G0(valueAt, G2, 0, 0, false);
                } else if (valueAt.o() != null) {
                    valueAt.o().end();
                }
            }
        }
    }

    private static void b1(k kVar) {
        if (kVar != null) {
            List<d> b2 = kVar.b();
            if (b2 != null) {
                for (d dVar : b2) {
                    dVar.M = true;
                }
            }
            List<k> a2 = kVar.a();
            if (a2 != null) {
                for (k b1 : a2) {
                    b1(b1);
                }
            }
        }
    }

    static boolean c1(View view, g gVar) {
        return view != null && gVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && p.p(view) && C0(gVar);
    }

    private void d0(boolean z2) {
        if (this.k) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.v == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.v.g().getLooper()) {
            if (!z2) {
                p();
            }
            if (this.F == null) {
                this.F = new ArrayList<>();
                this.G = new ArrayList<>();
            }
            this.k = true;
            try {
                i0((ArrayList<a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.k = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private void f1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new b.d.j.b("FragmentManager"));
        h hVar = this.v;
        if (hVar != null) {
            try {
                hVar.i("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            b("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    private static void g0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.g(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.m(z2);
            } else {
                aVar.g(1);
                aVar.l();
            }
            i2++;
        }
    }

    public static int g1(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    private void h(b.c.b<d> bVar) {
        int i2 = this.u;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.m.size();
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.m.get(i3);
                if (dVar.j < min) {
                    G0(dVar, min, dVar.x(), dVar.y(), false);
                    if (dVar.R != null && !dVar.J && dVar.W) {
                        bVar.add(dVar);
                    }
                }
            }
        }
    }

    private void h0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        ArrayList<a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = arrayList3.get(i6).s;
        ArrayList<d> arrayList5 = this.H;
        if (arrayList5 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.H.addAll(this.m);
        d s0 = s0();
        boolean z3 = false;
        for (int i8 = i6; i8 < i7; i8++) {
            a aVar = arrayList3.get(i8);
            s0 = !arrayList4.get(i8).booleanValue() ? aVar.n(this.H, s0) : aVar.v(this.H, s0);
            z3 = z3 || aVar.i;
        }
        this.H.clear();
        if (!z2) {
            o.C(this, arrayList, arrayList2, i2, i3, false);
        }
        g0(arrayList, arrayList2, i2, i3);
        if (z2) {
            b.c.b bVar = new b.c.b();
            h(bVar);
            int L0 = L0(arrayList, arrayList2, i2, i3, bVar);
            A0(bVar);
            i4 = L0;
        } else {
            i4 = i7;
        }
        if (i4 != i6 && z2) {
            o.C(this, arrayList, arrayList2, i2, i4, true);
            E0(this.u, true);
        }
        while (i6 < i7) {
            a aVar2 = arrayList3.get(i6);
            if (arrayList4.get(i6).booleanValue() && (i5 = aVar2.l) >= 0) {
                n0(i5);
                aVar2.l = -1;
            }
            aVar2.t();
            i6++;
        }
        if (z3) {
            P0();
        }
    }

    private void i0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.K;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.K.get(i2);
            if (arrayList == null || nVar.f725a || (indexOf2 = arrayList.indexOf(nVar.f726b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (nVar.e() || (arrayList != null && nVar.f726b.q(arrayList, 0, arrayList.size()))) {
                    this.K.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || nVar.f725a || (indexOf = arrayList.indexOf(nVar.f726b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        nVar.d();
                    }
                }
                i2++;
            }
            nVar.c();
            i2++;
        }
    }

    private void l(d dVar, g gVar, int i2) {
        View view = dVar.R;
        ViewGroup viewGroup = dVar.Q;
        viewGroup.startViewTransition(view);
        dVar.g1(i2);
        if (gVar.f715a != null) {
            i iVar = new i(gVar.f715a, viewGroup, view);
            dVar.Y0(dVar.R);
            iVar.setAnimationListener(new b(p0(iVar), viewGroup, dVar));
            Z0(view, gVar);
            dVar.R.startAnimation(iVar);
            return;
        }
        Animator animator = gVar.f716b;
        dVar.Z0(animator);
        animator.addListener(new c(viewGroup, view, dVar));
        animator.setTarget(dVar.R);
        Z0(dVar.R, gVar);
        animator.start();
    }

    private d l0(d dVar) {
        ViewGroup viewGroup = dVar.Q;
        View view = dVar.R;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.m.indexOf(dVar) - 1; indexOf >= 0; indexOf--) {
                d dVar2 = this.m.get(indexOf);
                if (dVar2.Q == viewGroup && dVar2.R != null) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private void m0() {
        if (this.K != null) {
            while (!this.K.isEmpty()) {
                this.K.remove(0).d();
            }
        }
    }

    private void o() {
        SparseArray<d> sparseArray = this.n;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.n.valueAt(size) == null) {
                    SparseArray<d> sparseArray2 = this.n;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o0(java.util.ArrayList<b.g.a.a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<b.g.a.j$l> r0 = r4.j     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 == 0) goto L_0x0038
            int r0 = r0.size()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x000d
            goto L_0x0038
        L_0x000d:
            java.util.ArrayList<b.g.a.j$l> r0 = r4.j     // Catch:{ all -> 0x003a }
            int r0 = r0.size()     // Catch:{ all -> 0x003a }
            r2 = 0
        L_0x0014:
            if (r1 >= r0) goto L_0x0026
            java.util.ArrayList<b.g.a.j$l> r3 = r4.j     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003a }
            b.g.a.j$l r3 = (b.g.a.j.l) r3     // Catch:{ all -> 0x003a }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003a }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0026:
            java.util.ArrayList<b.g.a.j$l> r5 = r4.j     // Catch:{ all -> 0x003a }
            r5.clear()     // Catch:{ all -> 0x003a }
            b.g.a.h r5 = r4.v     // Catch:{ all -> 0x003a }
            android.os.Handler r5 = r5.g()     // Catch:{ all -> 0x003a }
            java.lang.Runnable r6 = r4.M     // Catch:{ all -> 0x003a }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            return r2
        L_0x0038:
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            return r1
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003d:
            throw r5
        L_0x003e:
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.j.o0(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    private void p() {
        if (e()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.D != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.D);
        }
    }

    private static Animation.AnimationListener p0(Animation animation) {
        String str;
        try {
            if (O == null) {
                Field declaredField = Animation.class.getDeclaredField("mListener");
                O = declaredField;
                declaredField.setAccessible(true);
            }
            return (Animation.AnimationListener) O.get(animation);
        } catch (NoSuchFieldException e2) {
            e = e2;
            str = "No field with the name mListener is found in Animation class";
            Log.e("FragmentManager", str, e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            str = "Cannot access Animation's mListener field";
            Log.e("FragmentManager", str, e);
            return null;
        }
    }

    private void q() {
        this.k = false;
        this.G.clear();
        this.F.clear();
    }

    static g x0(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(Q);
        alphaAnimation.setDuration(220);
        return new g((Animation) alphaAnimation);
    }

    static g z0(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(P);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(Q);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new g((Animation) animationSet);
    }

    public void A() {
        Y(1);
    }

    public void B() {
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null) {
                dVar.J0();
            }
        }
    }

    public void C(boolean z2) {
        int size = this.m.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = this.m.get(size);
                if (dVar != null) {
                    dVar.K0(z2);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D(d dVar, Bundle bundle, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).D(dVar, bundle, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.a(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r0.R;
        r1 = r11.Q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D0(b.g.a.d r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r10.u
            boolean r1 = r11.u
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            boolean r1 = r11.M()
            if (r1 == 0) goto L_0x0016
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x001a
        L_0x0016:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x001a:
            r6 = r0
            int r7 = r11.y()
            int r8 = r11.z()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.G0(r5, r6, r7, r8, r9)
            android.view.View r0 = r11.R
            if (r0 == 0) goto L_0x008c
            b.g.a.d r0 = r10.l0(r11)
            if (r0 == 0) goto L_0x004b
            android.view.View r0 = r0.R
            android.view.ViewGroup r1 = r11.Q
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.R
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x004b
            r1.removeViewAt(r4)
            android.view.View r4 = r11.R
            r1.addView(r4, r0)
        L_0x004b:
            boolean r0 = r11.W
            if (r0 == 0) goto L_0x008c
            android.view.ViewGroup r0 = r11.Q
            if (r0 == 0) goto L_0x008c
            float r0 = r11.Y
            r1 = 0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            android.view.View r4 = r11.R
            r4.setAlpha(r0)
        L_0x005f:
            r11.Y = r1
            r11.W = r3
            int r0 = r11.y()
            int r1 = r11.z()
            b.g.a.j$g r0 = r10.v0(r11, r0, r2, r1)
            if (r0 == 0) goto L_0x008c
            android.view.View r1 = r11.R
            Z0(r1, r0)
            android.view.animation.Animation r1 = r0.f715a
            if (r1 == 0) goto L_0x0080
            android.view.View r0 = r11.R
            r0.startAnimation(r1)
            goto L_0x008c
        L_0x0080:
            android.animation.Animator r1 = r0.f716b
            android.view.View r2 = r11.R
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f716b
            r0.start()
        L_0x008c:
            boolean r0 = r11.X
            if (r0 == 0) goto L_0x0093
            r10.s(r11)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.j.D0(b.g.a.d):void");
    }

    /* access modifiers changed from: package-private */
    public void E(d dVar, Context context, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).E(dVar, context, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.b(this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E0(int i2, boolean z2) {
        h hVar;
        if (this.v == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.u) {
            this.u = i2;
            if (this.n != null) {
                int size = this.m.size();
                for (int i3 = 0; i3 < size; i3++) {
                    D0(this.m.get(i3));
                }
                int size2 = this.n.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d valueAt = this.n.valueAt(i4);
                    if (valueAt != null && ((valueAt.u || valueAt.K) && !valueAt.W)) {
                        D0(valueAt);
                    }
                }
                e1();
                if (this.z && (hVar = this.v) != null && this.u == 4) {
                    hVar.p();
                    this.z = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F(d dVar, Bundle bundle, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).F(dVar, bundle, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.c(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F0(d dVar) {
        G0(dVar, this.u, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public void G(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).G(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.d(this, dVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r0 != 3) goto L_0x0418;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G0(b.g.a.d r17, int r18, int r19, int r20, boolean r21) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            boolean r0 = r7.t
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.K
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r18
            goto L_0x0016
        L_0x0011:
            r0 = r18
            if (r0 <= r8) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r7.u
            if (r1 == 0) goto L_0x002a
            int r1 = r7.j
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r0 = r17.M()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.j
        L_0x002a:
            boolean r1 = r7.T
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0038
            int r1 = r7.j
            if (r1 >= r9) goto L_0x0038
            if (r0 <= r10) goto L_0x0038
            r11 = 2
            goto L_0x0039
        L_0x0038:
            r11 = r0
        L_0x0039:
            int r0 = r7.j
            java.lang.String r12 = "FragmentManager"
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x02d6
            boolean r0 = r7.v
            if (r0 == 0) goto L_0x004a
            boolean r0 = r7.w
            if (r0 != 0) goto L_0x004a
            return
        L_0x004a:
            android.view.View r0 = r17.n()
            if (r0 != 0) goto L_0x0056
            android.animation.Animator r0 = r17.o()
            if (r0 == 0) goto L_0x006a
        L_0x0056:
            r7.Y0(r14)
            r7.Z0(r14)
            int r2 = r17.G()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r1 = r17
            r0.G0(r1, r2, r3, r4, r5)
        L_0x006a:
            int r0 = r7.j
            if (r0 == 0) goto L_0x0076
            if (r0 == r8) goto L_0x019e
            if (r0 == r10) goto L_0x0290
            if (r0 == r9) goto L_0x02b0
            goto L_0x0418
        L_0x0076:
            if (r11 <= 0) goto L_0x019e
            boolean r0 = N
            if (r0 == 0) goto L_0x0090
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0090:
            android.os.Bundle r0 = r7.k
            if (r0 == 0) goto L_0x00e1
            b.g.a.h r1 = r6.v
            android.content.Context r1 = r1.e()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.k
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.l = r0
            android.os.Bundle r0 = r7.k
            java.lang.String r1 = "android:target_state"
            b.g.a.d r0 = r6.q0(r0, r1)
            r7.q = r0
            if (r0 == 0) goto L_0x00c1
            android.os.Bundle r0 = r7.k
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.s = r0
        L_0x00c1:
            java.lang.Boolean r0 = r7.m
            if (r0 == 0) goto L_0x00ce
            boolean r0 = r0.booleanValue()
            r7.U = r0
            r7.m = r14
            goto L_0x00d8
        L_0x00ce:
            android.os.Bundle r0 = r7.k
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.U = r0
        L_0x00d8:
            boolean r0 = r7.U
            if (r0 != 0) goto L_0x00e1
            r7.T = r8
            if (r11 <= r10) goto L_0x00e1
            r11 = 2
        L_0x00e1:
            b.g.a.h r0 = r6.v
            r7.B = r0
            b.g.a.d r1 = r6.x
            r7.F = r1
            if (r1 == 0) goto L_0x00ee
            b.g.a.j r0 = r1.C
            goto L_0x00f2
        L_0x00ee:
            b.g.a.j r0 = r0.f()
        L_0x00f2:
            r7.A = r0
            b.g.a.d r0 = r7.q
            java.lang.String r15 = "Fragment "
            if (r0 == 0) goto L_0x0138
            android.util.SparseArray<b.g.a.d> r1 = r6.n
            int r0 = r0.n
            java.lang.Object r0 = r1.get(r0)
            b.g.a.d r1 = r7.q
            if (r0 != r1) goto L_0x0114
            int r0 = r1.j
            if (r0 >= r8) goto L_0x0138
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r0.G0(r1, r2, r3, r4, r5)
            goto L_0x0138
        L_0x0114:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            b.g.a.d r2 = r7.q
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0138:
            b.g.a.h r0 = r6.v
            android.content.Context r0 = r0.e()
            r6.J(r7, r0, r13)
            r7.P = r13
            b.g.a.h r0 = r6.v
            android.content.Context r0 = r0.e()
            r7.V(r0)
            boolean r0 = r7.P
            if (r0 == 0) goto L_0x0184
            b.g.a.d r0 = r7.F
            if (r0 != 0) goto L_0x015a
            b.g.a.h r0 = r6.v
            r0.h(r7)
            goto L_0x015d
        L_0x015a:
            r0.W(r7)
        L_0x015d:
            b.g.a.h r0 = r6.v
            android.content.Context r0 = r0.e()
            r6.E(r7, r0, r13)
            boolean r0 = r7.a0
            if (r0 != 0) goto L_0x017a
            android.os.Bundle r0 = r7.k
            r6.K(r7, r0, r13)
            android.os.Bundle r0 = r7.k
            r7.C0(r0)
            android.os.Bundle r0 = r7.k
            r6.F(r7, r0, r13)
            goto L_0x0181
        L_0x017a:
            android.os.Bundle r0 = r7.k
            r7.W0(r0)
            r7.j = r8
        L_0x0181:
            r7.M = r13
            goto L_0x019e
        L_0x0184:
            b.g.a.s r0 = new b.g.a.s
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r2 = " did not call through to super.onAttach()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x019e:
            r16.e0(r17)
            if (r11 <= r8) goto L_0x0290
            boolean r0 = N
            if (r0 == 0) goto L_0x01bb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x01bb:
            boolean r0 = r7.v
            if (r0 != 0) goto L_0x027b
            int r0 = r7.H
            if (r0 == 0) goto L_0x0231
            r1 = -1
            if (r0 == r1) goto L_0x0212
            b.g.a.f r1 = r6.w
            android.view.View r0 = r1.b(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0232
            boolean r1 = r7.x
            if (r1 == 0) goto L_0x01d5
            goto L_0x0232
        L_0x01d5:
            android.content.res.Resources r0 = r17.C()     // Catch:{ NotFoundException -> 0x01e0 }
            int r1 = r7.H     // Catch:{ NotFoundException -> 0x01e0 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x01e0 }
            goto L_0x01e2
        L_0x01e0:
            java.lang.String r0 = "unknown"
        L_0x01e2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            int r3 = r7.H
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r6.f1(r1)
            throw r14
        L_0x0212:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r6.f1(r0)
            throw r14
        L_0x0231:
            r0 = r14
        L_0x0232:
            r7.Q = r0
            android.os.Bundle r1 = r7.k
            android.view.LayoutInflater r1 = r7.I0(r1)
            android.os.Bundle r2 = r7.k
            r7.E0(r1, r0, r2)
            android.view.View r1 = r7.R
            if (r1 == 0) goto L_0x0279
            r7.S = r1
            r1.setSaveFromParentEnabled(r13)
            if (r0 == 0) goto L_0x024f
            android.view.View r1 = r7.R
            r0.addView(r1)
        L_0x024f:
            boolean r0 = r7.J
            if (r0 == 0) goto L_0x025a
            android.view.View r0 = r7.R
            r1 = 8
            r0.setVisibility(r1)
        L_0x025a:
            android.view.View r0 = r7.R
            android.os.Bundle r1 = r7.k
            r7.w0(r0, r1)
            android.view.View r0 = r7.R
            android.os.Bundle r1 = r7.k
            r6.P(r7, r0, r1, r13)
            android.view.View r0 = r7.R
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0275
            android.view.ViewGroup r0 = r7.Q
            if (r0 == 0) goto L_0x0275
            goto L_0x0276
        L_0x0275:
            r8 = 0
        L_0x0276:
            r7.W = r8
            goto L_0x027b
        L_0x0279:
            r7.S = r14
        L_0x027b:
            android.os.Bundle r0 = r7.k
            r7.z0(r0)
            android.os.Bundle r0 = r7.k
            r6.D(r7, r0, r13)
            android.view.View r0 = r7.R
            if (r0 == 0) goto L_0x028e
            android.os.Bundle r0 = r7.k
            r7.X0(r0)
        L_0x028e:
            r7.k = r14
        L_0x0290:
            if (r11 <= r10) goto L_0x02b0
            boolean r0 = N
            if (r0 == 0) goto L_0x02aa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02aa:
            r17.S0()
            r6.N(r7, r13)
        L_0x02b0:
            if (r11 <= r9) goto L_0x0418
            boolean r0 = N
            if (r0 == 0) goto L_0x02ca
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02ca:
            r17.Q0()
            r6.L(r7, r13)
            r7.k = r14
            r7.l = r14
            goto L_0x0418
        L_0x02d6:
            if (r0 <= r11) goto L_0x0418
            if (r0 == r8) goto L_0x03a4
            if (r0 == r10) goto L_0x0323
            if (r0 == r9) goto L_0x0303
            r1 = 4
            if (r0 == r1) goto L_0x02e3
            goto L_0x0418
        L_0x02e3:
            if (r11 >= r1) goto L_0x0303
            boolean r0 = N
            if (r0 == 0) goto L_0x02fd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02fd:
            r17.N0()
            r6.I(r7, r13)
        L_0x0303:
            if (r11 >= r9) goto L_0x0323
            boolean r0 = N
            if (r0 == 0) goto L_0x031d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x031d:
            r17.T0()
            r6.O(r7, r13)
        L_0x0323:
            if (r11 >= r10) goto L_0x03a4
            boolean r0 = N
            if (r0 == 0) goto L_0x033d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x033d:
            android.view.View r0 = r7.R
            if (r0 == 0) goto L_0x0350
            b.g.a.h r0 = r6.v
            boolean r0 = r0.n(r7)
            if (r0 == 0) goto L_0x0350
            android.util.SparseArray<android.os.Parcelable> r0 = r7.l
            if (r0 != 0) goto L_0x0350
            r16.V0(r17)
        L_0x0350:
            r17.G0()
            r6.Q(r7, r13)
            android.view.View r0 = r7.R
            if (r0 == 0) goto L_0x0395
            android.view.ViewGroup r1 = r7.Q
            if (r1 == 0) goto L_0x0395
            r1.endViewTransition(r0)
            android.view.View r0 = r7.R
            r0.clearAnimation()
            int r0 = r6.u
            r1 = 0
            if (r0 <= 0) goto L_0x0386
            boolean r0 = r6.C
            if (r0 != 0) goto L_0x0386
            android.view.View r0 = r7.R
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0386
            float r0 = r7.Y
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0386
            r0 = r19
            r2 = r20
            b.g.a.j$g r0 = r6.v0(r7, r0, r13, r2)
            goto L_0x0387
        L_0x0386:
            r0 = r14
        L_0x0387:
            r7.Y = r1
            if (r0 == 0) goto L_0x038e
            r6.l(r7, r0, r11)
        L_0x038e:
            android.view.ViewGroup r0 = r7.Q
            android.view.View r1 = r7.R
            r0.removeView(r1)
        L_0x0395:
            r7.Q = r14
            r7.R = r14
            r7.d0 = r14
            androidx.lifecycle.l<androidx.lifecycle.g> r0 = r7.e0
            r0.i(r14)
            r7.S = r14
            r7.w = r13
        L_0x03a4:
            if (r11 >= r8) goto L_0x0418
            boolean r0 = r6.C
            if (r0 == 0) goto L_0x03cb
            android.view.View r0 = r17.n()
            if (r0 == 0) goto L_0x03bb
            android.view.View r0 = r17.n()
            r7.Y0(r14)
            r0.clearAnimation()
            goto L_0x03cb
        L_0x03bb:
            android.animation.Animator r0 = r17.o()
            if (r0 == 0) goto L_0x03cb
            android.animation.Animator r0 = r17.o()
            r7.Z0(r14)
            r0.cancel()
        L_0x03cb:
            android.view.View r0 = r17.n()
            if (r0 != 0) goto L_0x0414
            android.animation.Animator r0 = r17.o()
            if (r0 == 0) goto L_0x03d8
            goto L_0x0414
        L_0x03d8:
            boolean r0 = N
            if (r0 == 0) goto L_0x03f0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x03f0:
            boolean r0 = r7.M
            if (r0 != 0) goto L_0x03fb
            r17.F0()
            r6.G(r7, r13)
            goto L_0x03fd
        L_0x03fb:
            r7.j = r13
        L_0x03fd:
            r17.H0()
            r6.H(r7, r13)
            if (r21 != 0) goto L_0x0418
            boolean r0 = r7.M
            if (r0 != 0) goto L_0x040d
            r16.y0(r17)
            goto L_0x0418
        L_0x040d:
            r7.B = r14
            r7.F = r14
            r7.A = r14
            goto L_0x0418
        L_0x0414:
            r7.g1(r11)
            goto L_0x0419
        L_0x0418:
            r8 = r11
        L_0x0419:
            int r0 = r7.j
            if (r0 == r8) goto L_0x044a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; "
            r0.append(r1)
            java.lang.String r1 = "expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.j
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
            r7.j = r8
        L_0x044a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.j.G0(b.g.a.d, int, int, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void H(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).H(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.e(this, dVar);
            }
        }
    }

    public void H0() {
        this.L = null;
        this.A = false;
        this.B = false;
        int size = this.m.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null) {
                dVar.R();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).I(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.f(this, dVar);
            }
        }
    }

    public void I0(d dVar) {
        if (!dVar.T) {
            return;
        }
        if (this.k) {
            this.E = true;
            return;
        }
        dVar.T = false;
        G0(dVar, this.u, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    public void J(d dVar, Context context, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).J(dVar, context, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.g(this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void K(d dVar, Bundle bundle, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).K(dVar, bundle, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.h(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean K0(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        Boolean bool = Boolean.TRUE;
        ArrayList<a> arrayList3 = this.o;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.o.remove(size));
            arrayList2.add(bool);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    a aVar = this.o.get(size2);
                    if ((str != null && str.equals(aVar.o())) || (i2 >= 0 && i2 == aVar.l)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = this.o.get(size2);
                        if ((str == null || !str.equals(aVar2.o())) && (i2 < 0 || i2 != aVar2.l)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.o.size() - 1) {
                return false;
            }
            for (int size3 = this.o.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.o.remove(size3));
                arrayList2.add(bool);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void L(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).L(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.i(this, dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M(d dVar, Bundle bundle, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).M(dVar, bundle, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.j(this, dVar, bundle);
            }
        }
    }

    public void M0(Bundle bundle, String str, d dVar) {
        int i2 = dVar.n;
        if (i2 >= 0) {
            bundle.putInt(str, i2);
            return;
        }
        f1(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void N(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).N(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.k(this, dVar);
            }
        }
    }

    public void N0(d dVar) {
        if (N) {
            Log.v("FragmentManager", "remove: " + dVar + " nesting=" + dVar.z);
        }
        boolean z2 = !dVar.M();
        if (!dVar.K || z2) {
            synchronized (this.m) {
                this.m.remove(dVar);
            }
            if (dVar.N && dVar.O) {
                this.z = true;
            }
            dVar.t = false;
            dVar.u = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void O(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).O(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.l(this, dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P(d dVar, View view, Bundle bundle, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).P(dVar, view, bundle, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.m(this, dVar, view, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void P0() {
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                this.s.get(i2).a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(d dVar, boolean z2) {
        d dVar2 = this.x;
        if (dVar2 != null) {
            i v2 = dVar2.v();
            if (v2 instanceof j) {
                ((j) v2).Q(dVar, true);
            }
        }
        Iterator<C0034j> it = this.t.iterator();
        while (it.hasNext()) {
            C0034j next = it.next();
            if (!z2 || next.f719b) {
                next.f718a.n(this, dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Q0(Parcelable parcelable, k kVar) {
        List<s> list;
        List<k> list2;
        m[] mVarArr;
        if (parcelable != null) {
            l lVar = (l) parcelable;
            if (lVar.j != null) {
                if (kVar != null) {
                    List<d> b2 = kVar.b();
                    list2 = kVar.a();
                    list = kVar.c();
                    int size = b2 != null ? b2.size() : 0;
                    int i2 = 0;
                    while (i2 < size) {
                        d dVar = b2.get(i2);
                        if (N) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + dVar);
                        }
                        int i3 = 0;
                        while (true) {
                            mVarArr = lVar.j;
                            if (i3 < mVarArr.length && mVarArr[i3].k != dVar.n) {
                                i3++;
                            }
                        }
                        if (i3 != mVarArr.length) {
                            m mVar = mVarArr[i3];
                            mVar.u = dVar;
                            dVar.l = null;
                            dVar.z = 0;
                            dVar.w = false;
                            dVar.t = false;
                            dVar.q = null;
                            Bundle bundle = mVar.t;
                            if (bundle != null) {
                                bundle.setClassLoader(this.v.e().getClassLoader());
                                dVar.l = mVar.t.getSparseParcelableArray("android:view_state");
                                dVar.k = mVar.t;
                            }
                            i2++;
                        } else {
                            f1(new IllegalStateException("Could not find active fragment with index " + dVar.n));
                            throw null;
                        }
                    }
                } else {
                    list2 = null;
                    list = null;
                }
                this.n = new SparseArray<>(lVar.j.length);
                int i4 = 0;
                while (true) {
                    m[] mVarArr2 = lVar.j;
                    if (i4 >= mVarArr2.length) {
                        break;
                    }
                    m mVar2 = mVarArr2[i4];
                    if (mVar2 != null) {
                        d a2 = mVar2.a(this.v, this.w, this.x, (list2 == null || i4 >= list2.size()) ? null : list2.get(i4), (list == null || i4 >= list.size()) ? null : list.get(i4));
                        if (N) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a2);
                        }
                        this.n.put(a2.n, a2);
                        mVar2.u = null;
                    }
                    i4++;
                }
                if (kVar != null) {
                    List<d> b3 = kVar.b();
                    int size2 = b3 != null ? b3.size() : 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        d dVar2 = b3.get(i5);
                        int i6 = dVar2.r;
                        if (i6 >= 0) {
                            d dVar3 = this.n.get(i6);
                            dVar2.q = dVar3;
                            if (dVar3 == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + dVar2 + " target no longer exists: " + dVar2.r);
                            }
                        }
                    }
                }
                this.m.clear();
                if (lVar.k != null) {
                    int i7 = 0;
                    while (true) {
                        int[] iArr = lVar.k;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        d dVar4 = this.n.get(iArr[i7]);
                        if (dVar4 != null) {
                            dVar4.t = true;
                            if (N) {
                                Log.v("FragmentManager", "restoreAllState: added #" + i7 + ": " + dVar4);
                            }
                            if (!this.m.contains(dVar4)) {
                                synchronized (this.m) {
                                    this.m.add(dVar4);
                                }
                                i7++;
                            } else {
                                throw new IllegalStateException("Already added!");
                            }
                        } else {
                            f1(new IllegalStateException("No instantiated fragment for index #" + lVar.k[i7]));
                            throw null;
                        }
                    }
                }
                if (lVar.l != null) {
                    this.o = new ArrayList<>(lVar.l.length);
                    int i8 = 0;
                    while (true) {
                        b[] bVarArr = lVar.l;
                        if (i8 >= bVarArr.length) {
                            break;
                        }
                        a a3 = bVarArr[i8].a(this);
                        if (N) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + a3.l + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new b.d.j.b("FragmentManager"));
                            a3.k("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.o.add(a3);
                        int i9 = a3.l;
                        if (i9 >= 0) {
                            Y0(i9, a3);
                        }
                        i8++;
                    }
                } else {
                    this.o = null;
                }
                int i10 = lVar.m;
                if (i10 >= 0) {
                    this.y = this.n.get(i10);
                }
                this.l = lVar.n;
            }
        }
    }

    public boolean R(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null && dVar.L0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public k R0() {
        b1(this.L);
        return this.L;
    }

    public void S(Menu menu) {
        if (this.u >= 1) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                d dVar = this.m.get(i2);
                if (dVar != null) {
                    dVar.M0(menu);
                }
            }
        }
    }

    public void T() {
        Y(3);
    }

    /* access modifiers changed from: package-private */
    public Parcelable T0() {
        int[] iArr;
        int size;
        m0();
        b0();
        f0();
        this.A = true;
        b[] bVarArr = null;
        this.L = null;
        SparseArray<d> sparseArray = this.n;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.n.size();
        m[] mVarArr = new m[size2];
        boolean z2 = false;
        for (int i2 = 0; i2 < size2; i2++) {
            d valueAt = this.n.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.n >= 0) {
                    m mVar = new m(valueAt);
                    mVarArr[i2] = mVar;
                    if (valueAt.j <= 0 || mVar.t != null) {
                        mVar.t = valueAt.k;
                    } else {
                        Bundle U0 = U0(valueAt);
                        mVar.t = U0;
                        d dVar = valueAt.q;
                        if (dVar != null) {
                            if (dVar.n >= 0) {
                                if (U0 == null) {
                                    mVar.t = new Bundle();
                                }
                                M0(mVar.t, "android:target_state", valueAt.q);
                                int i3 = valueAt.s;
                                if (i3 != 0) {
                                    mVar.t.putInt("android:target_req_state", i3);
                                }
                            } else {
                                f1(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.q));
                                throw null;
                            }
                        }
                    }
                    if (N) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + mVar.t);
                    }
                    z2 = true;
                } else {
                    f1(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.n));
                    throw null;
                }
            }
        }
        if (!z2) {
            if (N) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.m.size();
        if (size3 > 0) {
            iArr = new int[size3];
            int i4 = 0;
            while (i4 < size3) {
                iArr[i4] = this.m.get(i4).n;
                if (iArr[i4] >= 0) {
                    if (N) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.m.get(i4));
                    }
                    i4++;
                } else {
                    f1(new IllegalStateException("Failure saving state: active " + this.m.get(i4) + " has cleared index: " + iArr[i4]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<a> arrayList = this.o;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            bVarArr = new b[size];
            for (int i5 = 0; i5 < size; i5++) {
                bVarArr[i5] = new b(this.o.get(i5));
                if (N) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.o.get(i5));
                }
            }
        }
        l lVar = new l();
        lVar.j = mVarArr;
        lVar.k = iArr;
        lVar.l = bVarArr;
        d dVar2 = this.y;
        if (dVar2 != null) {
            lVar.m = dVar2.n;
        }
        lVar.n = this.l;
        W0();
        return lVar;
    }

    public void U(boolean z2) {
        int size = this.m.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = this.m.get(size);
                if (dVar != null) {
                    dVar.O0(z2);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle U0(d dVar) {
        if (this.I == null) {
            this.I = new Bundle();
        }
        dVar.R0(this.I);
        M(dVar, this.I, false);
        Bundle bundle = null;
        if (!this.I.isEmpty()) {
            Bundle bundle2 = this.I;
            this.I = null;
            bundle = bundle2;
        }
        if (dVar.R != null) {
            V0(dVar);
        }
        if (dVar.l != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", dVar.l);
        }
        if (!dVar.U) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", dVar.U);
        }
        return bundle;
    }

    public boolean V(Menu menu) {
        if (this.u < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null && dVar.P0(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void V0(d dVar) {
        if (dVar.S != null) {
            SparseArray<Parcelable> sparseArray = this.J;
            if (sparseArray == null) {
                this.J = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            dVar.S.saveHierarchyState(this.J);
            if (this.J.size() > 0) {
                dVar.l = this.J;
                this.J = null;
            }
        }
    }

    public void W() {
        this.A = false;
        this.B = false;
        Y(4);
    }

    /* access modifiers changed from: package-private */
    public void W0() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        k kVar;
        if (this.n != null) {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                d valueAt = this.n.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.L) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(valueAt);
                        d dVar = valueAt.q;
                        valueAt.r = dVar != null ? dVar.n : -1;
                        if (N) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    j jVar = valueAt.C;
                    if (jVar != null) {
                        jVar.W0();
                        kVar = valueAt.C.L;
                    } else {
                        kVar = valueAt.D;
                    }
                    if (arrayList2 == null && kVar != null) {
                        arrayList2 = new ArrayList(this.n.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add((Object) null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(kVar);
                    }
                    if (arrayList == null && valueAt.E != null) {
                        arrayList = new ArrayList(this.n.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList.add((Object) null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(valueAt.E);
                    }
                }
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.L = null;
        } else {
            this.L = new k(arrayList3, arrayList2, arrayList);
        }
    }

    public void X() {
        this.A = false;
        this.B = false;
        Y(3);
    }

    /* access modifiers changed from: package-private */
    public void X0() {
        synchronized (this) {
            ArrayList<n> arrayList = this.K;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            ArrayList<l> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.v.g().removeCallbacks(this.M);
                this.v.g().post(this.M);
            }
        }
    }

    public void Y0(int i2, a aVar) {
        synchronized (this) {
            if (this.q == null) {
                this.q = new ArrayList<>();
            }
            int size = this.q.size();
            if (i2 < size) {
                if (N) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.q.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.q.add((Object) null);
                    if (this.r == null) {
                        this.r = new ArrayList<>();
                    }
                    if (N) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.r.add(Integer.valueOf(size));
                    size++;
                }
                if (N) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.q.add(aVar);
            }
        }
    }

    public void Z() {
        this.B = true;
        Y(2);
    }

    public n a() {
        return new a(this);
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        if (this.E) {
            this.E = false;
            e1();
        }
    }

    public void a1(d dVar) {
        if (dVar == null || (this.n.get(dVar.n) == dVar && (dVar.B == null || dVar.v() == this))) {
            this.y = dVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<d> sparseArray = this.n;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                d valueAt = this.n.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.h(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.m.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.m.get(i3).toString());
            }
        }
        ArrayList<d> arrayList = this.p;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.p.get(i4).toString());
            }
        }
        ArrayList<a> arrayList2 = this.o;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                a aVar = this.o.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.j(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            ArrayList<a> arrayList3 = this.q;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.q.get(i6));
                }
            }
            ArrayList<Integer> arrayList4 = this.r;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.r.toArray()));
            }
        }
        ArrayList<l> arrayList5 = this.j;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(this.j.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.w);
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.A);
        printWriter.print(" mStopped=");
        printWriter.print(this.B);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.C);
        if (this.z) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.z);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.D);
        }
    }

    public d c(String str) {
        if (str != null) {
            for (int size = this.m.size() - 1; size >= 0; size--) {
                d dVar = this.m.get(size);
                if (dVar != null && str.equals(dVar.I)) {
                    return dVar;
                }
            }
        }
        SparseArray<d> sparseArray = this.n;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            d valueAt = this.n.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.I)) {
                return valueAt;
            }
        }
        return null;
    }

    public void c0(l lVar, boolean z2) {
        if (!z2) {
            p();
        }
        synchronized (this) {
            if (!this.C) {
                if (this.v != null) {
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    this.j.add(lVar);
                    X0();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public List<d> d() {
        List<d> list;
        if (this.m.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.m) {
            list = (List) this.m.clone();
        }
        return list;
    }

    public void d1(d dVar) {
        if (N) {
            Log.v("FragmentManager", "show: " + dVar);
        }
        if (dVar.J) {
            dVar.J = false;
            dVar.X = !dVar.X;
        }
    }

    public boolean e() {
        return this.A || this.B;
    }

    /* access modifiers changed from: package-private */
    public void e0(d dVar) {
        if (dVar.v && !dVar.y) {
            dVar.E0(dVar.I0(dVar.k), (ViewGroup) null, dVar.k);
            View view = dVar.R;
            if (view != null) {
                dVar.S = view;
                view.setSaveFromParentEnabled(false);
                if (dVar.J) {
                    dVar.R.setVisibility(8);
                }
                dVar.w0(dVar.R, dVar.k);
                P(dVar, dVar.R, dVar.k, false);
                return;
            }
            dVar.S = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void e1() {
        if (this.n != null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                d valueAt = this.n.valueAt(i2);
                if (valueAt != null) {
                    I0(valueAt);
                }
            }
        }
    }

    public void f(int i2, int i3) {
        if (i2 >= 0) {
            c0(new m((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* JADX INFO: finally extract failed */
    public boolean f0() {
        d0(true);
        boolean z2 = false;
        while (o0(this.F, this.G)) {
            this.k = true;
            try {
                O0(this.F, this.G);
                q();
                z2 = true;
            } catch (Throwable th) {
                q();
                throw th;
            }
        }
        a0();
        o();
        return z2;
    }

    public boolean g() {
        p();
        return J0((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public void i(a aVar) {
        if (this.o == null) {
            this.o = new ArrayList<>();
        }
        this.o.add(aVar);
    }

    public void j(d dVar, boolean z2) {
        if (N) {
            Log.v("FragmentManager", "add: " + dVar);
        }
        w0(dVar);
        if (dVar.K) {
            return;
        }
        if (!this.m.contains(dVar)) {
            synchronized (this.m) {
                this.m.add(dVar);
            }
            dVar.t = true;
            dVar.u = false;
            if (dVar.R == null) {
                dVar.X = false;
            }
            if (dVar.N && dVar.O) {
                this.z = true;
            }
            if (z2) {
                F0(dVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + dVar);
    }

    public d j0(int i2) {
        for (int size = this.m.size() - 1; size >= 0; size--) {
            d dVar = this.m.get(size);
            if (dVar != null && dVar.G == i2) {
                return dVar;
            }
        }
        SparseArray<d> sparseArray = this.n;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            d valueAt = this.n.valueAt(size2);
            if (valueAt != null && valueAt.G == i2) {
                return valueAt;
            }
        }
        return null;
    }

    public int k(a aVar) {
        synchronized (this) {
            ArrayList<Integer> arrayList = this.r;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    ArrayList<Integer> arrayList2 = this.r;
                    int intValue = arrayList2.remove(arrayList2.size() - 1).intValue();
                    if (N) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                    }
                    this.q.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.q == null) {
                this.q = new ArrayList<>();
            }
            int size = this.q.size();
            if (N) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.q.add(aVar);
            return size;
        }
    }

    public d k0(String str) {
        d j2;
        SparseArray<d> sparseArray = this.n;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            d valueAt = this.n.valueAt(size);
            if (valueAt != null && (j2 = valueAt.j(str)) != null) {
                return j2;
            }
        }
        return null;
    }

    public void m(h hVar, f fVar, d dVar) {
        if (this.v == null) {
            this.v = hVar;
            this.w = fVar;
            this.x = dVar;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void n(d dVar) {
        if (N) {
            Log.v("FragmentManager", "attach: " + dVar);
        }
        if (dVar.K) {
            dVar.K = false;
            if (dVar.t) {
                return;
            }
            if (!this.m.contains(dVar)) {
                if (N) {
                    Log.v("FragmentManager", "add from attach: " + dVar);
                }
                synchronized (this.m) {
                    this.m.add(dVar);
                }
                dVar.t = true;
                if (dVar.N && dVar.O) {
                    this.z = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + dVar);
        }
    }

    public void n0(int i2) {
        synchronized (this) {
            this.q.set(i2, (Object) null);
            if (this.r == null) {
                this.r = new ArrayList<>();
            }
            if (N) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.r.add(Integer.valueOf(i2));
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, k.f720a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!d.Q(this.v.e(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        d j0 = resourceId != -1 ? j0(resourceId) : null;
        if (j0 == null && string != null) {
            j0 = c(string);
        }
        if (j0 == null && i2 != -1) {
            j0 = j0(i2);
        }
        if (N) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + j0);
        }
        if (j0 == null) {
            j0 = this.w.a(context, str3, (Bundle) null);
            j0.v = true;
            j0.G = resourceId != 0 ? resourceId : i2;
            j0.H = i2;
            j0.I = string;
            j0.w = true;
            j0.A = this;
            h hVar = this.v;
            j0.B = hVar;
            j0.k0(hVar.e(), attributeSet2, j0.k);
            j(j0, true);
        } else if (!j0.w) {
            j0.w = true;
            h hVar2 = this.v;
            j0.B = hVar2;
            if (!j0.M) {
                j0.k0(hVar2.e(), attributeSet2, j0.k);
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        d dVar = j0;
        if (this.u >= 1 || !dVar.v) {
            F0(dVar);
        } else {
            G0(dVar, 1, 0, 0, false);
        }
        View view2 = dVar.R;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (dVar.R.getTag() == null) {
                dVar.R.setTag(string);
            }
            return dVar.R;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public d q0(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        d dVar = this.n.get(i2);
        if (dVar != null) {
            return dVar;
        }
        f1(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void r(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.m(z4);
        } else {
            aVar.l();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            o.C(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z4) {
            E0(this.u, true);
        }
        SparseArray<d> sparseArray = this.n;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                d valueAt = this.n.valueAt(i2);
                if (valueAt != null && valueAt.R != null && valueAt.W && aVar.p(valueAt.H)) {
                    float f2 = valueAt.Y;
                    if (f2 > 0.0f) {
                        valueAt.R.setAlpha(f2);
                    }
                    if (z4) {
                        valueAt.Y = 0.0f;
                    } else {
                        valueAt.Y = -1.0f;
                        valueAt.W = false;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 r0() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public void s(d dVar) {
        Animator animator;
        if (dVar.R != null) {
            g v0 = v0(dVar, dVar.y(), !dVar.J, dVar.z());
            if (v0 == null || (animator = v0.f716b) == null) {
                if (v0 != null) {
                    Z0(dVar.R, v0);
                    dVar.R.startAnimation(v0.f715a);
                    v0.f715a.start();
                }
                dVar.R.setVisibility((!dVar.J || dVar.L()) ? 0 : 8);
                if (dVar.L()) {
                    dVar.b1(false);
                }
            } else {
                animator.setTarget(dVar.R);
                if (!dVar.J) {
                    dVar.R.setVisibility(0);
                } else if (dVar.L()) {
                    dVar.b1(false);
                } else {
                    ViewGroup viewGroup = dVar.Q;
                    View view = dVar.R;
                    viewGroup.startViewTransition(view);
                    v0.f716b.addListener(new d(this, viewGroup, view, dVar));
                }
                Z0(dVar.R, v0);
                v0.f716b.start();
            }
        }
        if (dVar.t && dVar.N && dVar.O) {
            this.z = true;
        }
        dVar.X = false;
        dVar.i0(dVar.J);
    }

    public d s0() {
        return this.y;
    }

    public void t(d dVar) {
        if (N) {
            Log.v("FragmentManager", "detach: " + dVar);
        }
        if (!dVar.K) {
            dVar.K = true;
            if (dVar.t) {
                if (N) {
                    Log.v("FragmentManager", "remove from detach: " + dVar);
                }
                synchronized (this.m) {
                    this.m.remove(dVar);
                }
                if (dVar.N && dVar.O) {
                    this.z = true;
                }
                dVar.t = false;
            }
        }
    }

    public void t0(d dVar) {
        if (N) {
            Log.v("FragmentManager", "hide: " + dVar);
        }
        if (!dVar.J) {
            dVar.J = true;
            dVar.X = true ^ dVar.X;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.x;
        if (obj == null) {
            obj = this.v;
        }
        b.d.j.a.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        this.A = false;
        this.B = false;
        Y(2);
    }

    /* access modifiers changed from: package-private */
    public boolean u0(int i2) {
        return this.u >= i2;
    }

    public void v(Configuration configuration) {
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null) {
                dVar.A0(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public g v0(d dVar, int i2, boolean z2, int i3) {
        int g1;
        int x2 = dVar.x();
        Animation Z = dVar.Z(i2, z2, x2);
        if (Z != null) {
            return new g(Z);
        }
        Animator a0 = dVar.a0(i2, z2, x2);
        if (a0 != null) {
            return new g(a0);
        }
        if (x2 != 0) {
            boolean equals = "anim".equals(this.v.e().getResources().getResourceTypeName(x2));
            boolean z3 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.v.e(), x2);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.v.e(), x2);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.v.e(), x2);
                        if (loadAnimation2 != null) {
                            return new g(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0 || (g1 = g1(i2, z2)) < 0) {
            return null;
        }
        switch (g1) {
            case 1:
                return z0(this.v.e(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return z0(this.v.e(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return z0(this.v.e(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return z0(this.v.e(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return x0(this.v.e(), 0.0f, 1.0f);
            case 6:
                return x0(this.v.e(), 1.0f, 0.0f);
            default:
                if (i3 != 0 || !this.v.l()) {
                    return null;
                }
                int k2 = this.v.k();
                return null;
        }
    }

    public boolean w(MenuItem menuItem) {
        if (this.u < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null && dVar.B0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void w0(d dVar) {
        if (dVar.n < 0) {
            int i2 = this.l;
            this.l = i2 + 1;
            dVar.c1(i2, this.x);
            if (this.n == null) {
                this.n = new SparseArray<>();
            }
            this.n.put(dVar.n, dVar);
            if (N) {
                Log.v("FragmentManager", "Allocated fragment index " + dVar);
            }
        }
    }

    public void x() {
        this.A = false;
        this.B = false;
        Y(1);
    }

    public boolean y(Menu menu, MenuInflater menuInflater) {
        if (this.u < 1) {
            return false;
        }
        ArrayList<d> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            d dVar = this.m.get(i2);
            if (dVar != null && dVar.D0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z2 = true;
            }
        }
        if (this.p != null) {
            for (int i3 = 0; i3 < this.p.size(); i3++) {
                d dVar2 = this.p.get(i3);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.e0();
                }
            }
        }
        this.p = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void y0(d dVar) {
        if (dVar.n >= 0) {
            if (N) {
                Log.v("FragmentManager", "Freeing fragment index " + dVar);
            }
            this.n.put(dVar.n, (Object) null);
            dVar.I();
        }
    }

    public void z() {
        this.C = true;
        f0();
        Y(0);
        this.v = null;
        this.w = null;
        this.x = null;
    }
}
