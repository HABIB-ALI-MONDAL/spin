package b.j.a;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import b.c.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class b extends a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f757c = false;

    /* renamed from: a  reason: collision with root package name */
    private final g f758a;

    /* renamed from: b  reason: collision with root package name */
    private final c f759b;

    public static class a<D> extends l<D> {
        private final int k;
        private final Bundle l;
        private final b.j.b.a<D> m;
        private g n;
        private C0035b<D> o;
        private b.j.b.a<D> p;

        /* access modifiers changed from: protected */
        public void f() {
            if (b.f757c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.d();
            throw null;
        }

        /* access modifiers changed from: protected */
        public void g() {
            if (b.f757c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.e();
            throw null;
        }

        public void h(m<? super D> mVar) {
            super.h(mVar);
            this.n = null;
        }

        public void i(D d2) {
            super.i(d2);
            b.j.b.a<D> aVar = this.p;
            if (aVar != null) {
                aVar.c();
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public b.j.b.a<D> j(boolean z) {
            if (b.f757c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.a();
            throw null;
        }

        public void k(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            b.j.b.a<D> aVar = this.m;
            aVar.b(str + "  ", fileDescriptor, printWriter, strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            g gVar = this.n;
            C0035b<D> bVar = this.o;
            if (gVar != null && bVar != null) {
                super.h(bVar);
                e(gVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            b.d.j.a.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: b.j.a.b$b  reason: collision with other inner class name */
    static class C0035b<D> implements m<D> {
    }

    static class c extends q {

        /* renamed from: c  reason: collision with root package name */
        private static final r.a f760c = new a();

        /* renamed from: b  reason: collision with root package name */
        private h<a> f761b = new h<>();

        static class a implements r.a {
            a() {
            }

            public <T extends q> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c f(s sVar) {
            return (c) new r(sVar, f760c).a(c.class);
        }

        /* access modifiers changed from: protected */
        public void d() {
            super.d();
            if (this.f761b.o() <= 0) {
                this.f761b.b();
            } else {
                this.f761b.p(0).j(true);
                throw null;
            }
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f761b.o() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.f761b.o() > 0) {
                    a p = this.f761b.p(0);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f761b.l(0));
                    printWriter.print(": ");
                    printWriter.println(p.toString());
                    p.k(str2, fileDescriptor, printWriter, strArr);
                    throw null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int o = this.f761b.o();
            for (int i = 0; i < o; i++) {
                this.f761b.p(i).l();
            }
        }
    }

    b(g gVar, s sVar) {
        this.f758a = gVar;
        this.f759b = c.f(sVar);
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f759b.e(str, fileDescriptor, printWriter, strArr);
    }

    public void c() {
        this.f759b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        b.d.j.a.a(this.f758a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
