package b.g.a;

import android.util.Log;
import b.d.j.b;
import b.g.a.d;
import b.g.a.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class a extends n implements j.l {

    /* renamed from: a  reason: collision with root package name */
    final j f674a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<C0032a> f675b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    int f676c;

    /* renamed from: d  reason: collision with root package name */
    int f677d;

    /* renamed from: e  reason: collision with root package name */
    int f678e;

    /* renamed from: f  reason: collision with root package name */
    int f679f;
    int g;
    int h;
    boolean i;
    String j;
    boolean k;
    int l = -1;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    boolean s = false;
    ArrayList<Runnable> t;

    /* renamed from: b.g.a.a$a  reason: collision with other inner class name */
    static final class C0032a {

        /* renamed from: a  reason: collision with root package name */
        int f680a;

        /* renamed from: b  reason: collision with root package name */
        d f681b;

        /* renamed from: c  reason: collision with root package name */
        int f682c;

        /* renamed from: d  reason: collision with root package name */
        int f683d;

        /* renamed from: e  reason: collision with root package name */
        int f684e;

        /* renamed from: f  reason: collision with root package name */
        int f685f;

        C0032a() {
        }

        C0032a(int i, d dVar) {
            this.f680a = i;
            this.f681b = dVar;
        }
    }

    public a(j jVar) {
        this.f674a = jVar;
    }

    private void i(int i2, d dVar, String str, int i3) {
        Class<?> cls = dVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        dVar.A = this.f674a;
        if (str != null) {
            String str2 = dVar.I;
            if (str2 == null || str.equals(str2)) {
                dVar.I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + dVar + ": was " + dVar.I + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = dVar.G;
                if (i4 == 0 || i4 == i2) {
                    dVar.G = i2;
                    dVar.H = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + dVar + ": was " + dVar.G + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + dVar + " with tag " + str + " to container view with no id");
            }
        }
        f(new C0032a(i3, dVar));
    }

    private static boolean r(C0032a aVar) {
        d dVar = aVar.f681b;
        return dVar != null && dVar.t && dVar.R != null && !dVar.K && !dVar.J && dVar.N();
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.N) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.i) {
            return true;
        }
        this.f674a.i(this);
        return true;
    }

    public n b(d dVar, String str) {
        i(0, dVar, str, 1);
        return this;
    }

    public int c() {
        return h(false);
    }

    public int d() {
        return h(true);
    }

    public n e(d dVar) {
        f(new C0032a(3, dVar));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void f(C0032a aVar) {
        this.f675b.add(aVar);
        aVar.f682c = this.f676c;
        aVar.f683d = this.f677d;
        aVar.f684e = this.f678e;
        aVar.f685f = this.f679f;
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        if (this.i) {
            if (j.N) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f675b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0032a aVar = this.f675b.get(i3);
                d dVar = aVar.f681b;
                if (dVar != null) {
                    dVar.z += i2;
                    if (j.N) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f681b + " to " + aVar.f681b.z);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int h(boolean z) {
        if (!this.k) {
            if (j.N) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                j("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.k = true;
            this.l = this.i ? this.f674a.k(this) : -1;
            this.f674a.c0(this, z);
            return this.l;
        }
        throw new IllegalStateException("commit already called");
    }

    public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        k(str, printWriter, true);
    }

    public void k(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.j);
            printWriter.print(" mIndex=");
            printWriter.print(this.l);
            printWriter.print(" mCommitted=");
            printWriter.println(this.k);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.f676c == 0 && this.f677d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f676c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f677d));
            }
            if (!(this.f678e == 0 && this.f679f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f678e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f679f));
            }
            if (!(this.m == 0 && this.n == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (!(this.o == 0 && this.p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (!this.f675b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.f675b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0032a aVar = this.f675b.get(i2);
                switch (aVar.f680a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f680a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f681b);
                if (z) {
                    if (!(aVar.f682c == 0 && aVar.f683d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f682c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f683d));
                    }
                    if (aVar.f684e != 0 || aVar.f685f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f684e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f685f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        int size = this.f675b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0032a aVar = this.f675b.get(i2);
            d dVar = aVar.f681b;
            if (dVar != null) {
                dVar.e1(this.g, this.h);
            }
            switch (aVar.f680a) {
                case 1:
                    dVar.d1(aVar.f682c);
                    this.f674a.j(dVar, false);
                    break;
                case 3:
                    dVar.d1(aVar.f683d);
                    this.f674a.N0(dVar);
                    break;
                case 4:
                    dVar.d1(aVar.f683d);
                    this.f674a.t0(dVar);
                    break;
                case 5:
                    dVar.d1(aVar.f682c);
                    this.f674a.d1(dVar);
                    break;
                case 6:
                    dVar.d1(aVar.f683d);
                    this.f674a.t(dVar);
                    break;
                case 7:
                    dVar.d1(aVar.f682c);
                    this.f674a.n(dVar);
                    break;
                case 8:
                    this.f674a.a1(dVar);
                    break;
                case 9:
                    this.f674a.a1((d) null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f680a);
            }
            if (!(this.s || aVar.f680a == 1 || dVar == null)) {
                this.f674a.D0(dVar);
            }
        }
        if (!this.s) {
            j jVar = this.f674a;
            jVar.E0(jVar.u, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        for (int size = this.f675b.size() - 1; size >= 0; size--) {
            C0032a aVar = this.f675b.get(size);
            d dVar = aVar.f681b;
            if (dVar != null) {
                dVar.e1(j.S0(this.g), this.h);
            }
            switch (aVar.f680a) {
                case 1:
                    dVar.d1(aVar.f685f);
                    this.f674a.N0(dVar);
                    break;
                case 3:
                    dVar.d1(aVar.f684e);
                    this.f674a.j(dVar, false);
                    break;
                case 4:
                    dVar.d1(aVar.f684e);
                    this.f674a.d1(dVar);
                    break;
                case 5:
                    dVar.d1(aVar.f685f);
                    this.f674a.t0(dVar);
                    break;
                case 6:
                    dVar.d1(aVar.f684e);
                    this.f674a.n(dVar);
                    break;
                case 7:
                    dVar.d1(aVar.f685f);
                    this.f674a.t(dVar);
                    break;
                case 8:
                    this.f674a.a1((d) null);
                    break;
                case 9:
                    this.f674a.a1(dVar);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f680a);
            }
            if (!(this.s || aVar.f680a == 3 || dVar == null)) {
                this.f674a.D0(dVar);
            }
        }
        if (!this.s && z) {
            j jVar = this.f674a;
            jVar.E0(jVar.u, true);
        }
    }

    /* access modifiers changed from: package-private */
    public d n(ArrayList<d> arrayList, d dVar) {
        ArrayList<d> arrayList2 = arrayList;
        d dVar2 = dVar;
        int i2 = 0;
        while (i2 < this.f675b.size()) {
            C0032a aVar = this.f675b.get(i2);
            int i3 = aVar.f680a;
            if (i3 != 1) {
                if (i3 == 2) {
                    d dVar3 = aVar.f681b;
                    int i4 = dVar3.H;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        d dVar4 = arrayList2.get(size);
                        if (dVar4.H == i4) {
                            if (dVar4 == dVar3) {
                                z = true;
                            } else {
                                if (dVar4 == dVar2) {
                                    this.f675b.add(i2, new C0032a(9, dVar4));
                                    i2++;
                                    dVar2 = null;
                                }
                                C0032a aVar2 = new C0032a(3, dVar4);
                                aVar2.f682c = aVar.f682c;
                                aVar2.f684e = aVar.f684e;
                                aVar2.f683d = aVar.f683d;
                                aVar2.f685f = aVar.f685f;
                                this.f675b.add(i2, aVar2);
                                arrayList2.remove(dVar4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.f675b.remove(i2);
                        i2--;
                    } else {
                        aVar.f680a = 1;
                        arrayList2.add(dVar3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(aVar.f681b);
                    d dVar5 = aVar.f681b;
                    if (dVar5 == dVar2) {
                        this.f675b.add(i2, new C0032a(9, dVar5));
                        i2++;
                        dVar2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f675b.add(i2, new C0032a(9, dVar2));
                        i2++;
                        dVar2 = aVar.f681b;
                    }
                }
                i2++;
            }
            arrayList2.add(aVar.f681b);
            i2++;
        }
        return dVar2;
    }

    public String o() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public boolean p(int i2) {
        int size = this.f675b.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = this.f675b.get(i3).f681b;
            int i4 = dVar != null ? dVar.H : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean q(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f675b.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = this.f675b.get(i5).f681b;
            int i6 = dVar != null ? dVar.H : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = arrayList.get(i7);
                    int size2 = aVar.f675b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        d dVar2 = aVar.f675b.get(i8).f681b;
                        if ((dVar2 != null ? dVar2.H : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        for (int i2 = 0; i2 < this.f675b.size(); i2++) {
            if (r(this.f675b.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void t() {
        ArrayList<Runnable> arrayList = this.t;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).run();
            }
            this.t = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.l >= 0) {
            sb.append(" #");
            sb.append(this.l);
        }
        if (this.j != null) {
            sb.append(" ");
            sb.append(this.j);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(d.f fVar) {
        for (int i2 = 0; i2 < this.f675b.size(); i2++) {
            C0032a aVar = this.f675b.get(i2);
            if (r(aVar)) {
                aVar.f681b.f1(fVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public d v(ArrayList<d> arrayList, d dVar) {
        for (int i2 = 0; i2 < this.f675b.size(); i2++) {
            C0032a aVar = this.f675b.get(i2);
            int i3 = aVar.f680a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            dVar = null;
                            break;
                        case 9:
                            dVar = aVar.f681b;
                            break;
                    }
                }
                arrayList.add(aVar.f681b);
            }
            arrayList.remove(aVar.f681b);
        }
        return dVar;
    }
}
