package c.b.a.n.o;

import android.util.Log;
import c.b.a.n.h;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class p extends Exception {
    private static final StackTraceElement[] o = new StackTraceElement[0];
    private final List<Throwable> j;
    private h k;
    private c.b.a.n.a l;
    private Class<?> m;
    private String n;

    private static final class a implements Appendable {
        private final Appendable j;
        private boolean k = true;

        a(Appendable appendable) {
            this.j = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c2) {
            boolean z = false;
            if (this.k) {
                this.k = false;
                this.j.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.k = z;
            this.j.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) {
            CharSequence a2 = a(charSequence);
            append(a2, 0, a2.length());
            return this;
        }

        public Appendable append(CharSequence charSequence, int i, int i2) {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.k) {
                this.k = false;
                this.j.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.k = z;
            this.j.append(a2, i, i2);
            return this;
        }
    }

    public p(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public p(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public p(String str, List<Throwable> list) {
        this.n = str;
        setStackTrace(o);
        this.j = list;
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof p) {
            for (Throwable a2 : ((p) th).e()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof p) {
                ((p) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i = i2;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List<Throwable> e() {
        return this.j;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> f2 = f();
        int size = f2.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), f2.get(i));
            i = i2;
        }
    }

    public String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.n);
        String str4 = "";
        if (this.m != null) {
            str = ", " + this.m;
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.l != null) {
            str2 = ", " + this.l;
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.k != null) {
            str4 = ", " + this.k;
        }
        sb.append(str4);
        List<Throwable> f2 = f();
        if (f2.isEmpty()) {
            return sb.toString();
        }
        if (f2.size() == 1) {
            str3 = "\nThere was 1 cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(f2.size());
            str3 = " causes:";
        }
        sb.append(str3);
        for (Throwable next : f2) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void i(h hVar, c.b.a.n.a aVar) {
        j(hVar, aVar, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void j(h hVar, c.b.a.n.a aVar, Class<?> cls) {
        this.k = hVar;
        this.l = aVar;
        this.m = cls;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }
}
