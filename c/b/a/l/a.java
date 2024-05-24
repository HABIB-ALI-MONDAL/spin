package c.b.a.l;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements Closeable {
    /* access modifiers changed from: private */
    public final File j;
    private final File k;
    private final File l;
    private final File m;
    private final int n;
    private long o;
    /* access modifiers changed from: private */
    public final int p;
    private long q = 0;
    /* access modifiers changed from: private */
    public Writer r;
    private final LinkedHashMap<String, d> s = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int t;
    private long u = 0;
    final ThreadPoolExecutor v = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b((C0038a) null));
    private final Callable<Void> w = new C0038a();

    /* renamed from: c.b.a.l.a$a  reason: collision with other inner class name */
    class C0038a implements Callable<Void> {
        C0038a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r4 = this;
                c.b.a.l.a r0 = c.b.a.l.a.this
                monitor-enter(r0)
                c.b.a.l.a r1 = c.b.a.l.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.r     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                c.b.a.l.a r1 = c.b.a.l.a.this     // Catch:{ all -> 0x0028 }
                r1.G()     // Catch:{ all -> 0x0028 }
                c.b.a.l.a r1 = c.b.a.l.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.y()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                c.b.a.l.a r1 = c.b.a.l.a.this     // Catch:{ all -> 0x0028 }
                r1.D()     // Catch:{ all -> 0x0028 }
                c.b.a.l.a r1 = c.b.a.l.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.t = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.a.C0038a.call():java.lang.Void");
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(C0038a aVar) {
            this();
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final d f839a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f840b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f841c;

        private c(d dVar) {
            this.f839a = dVar;
            this.f840b = dVar.f847e ? null : new boolean[a.this.p];
        }

        /* synthetic */ c(a aVar, d dVar, C0038a aVar2) {
            this(dVar);
        }

        public void a() {
            a.this.s(this, false);
        }

        public void b() {
            if (!this.f841c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() {
            a.this.s(this, true);
            this.f841c = true;
        }

        public File f(int i) {
            File k;
            synchronized (a.this) {
                if (this.f839a.f848f == this) {
                    if (!this.f839a.f847e) {
                        this.f840b[i] = true;
                    }
                    k = this.f839a.k(i);
                    if (!a.this.j.exists()) {
                        a.this.j.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k;
        }
    }

    private final class d {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f843a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f844b;

        /* renamed from: c  reason: collision with root package name */
        File[] f845c;

        /* renamed from: d  reason: collision with root package name */
        File[] f846d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f847e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public c f848f;
        /* access modifiers changed from: private */
        public long g;

        private d(String str) {
            this.f843a = str;
            this.f844b = new long[a.this.p];
            this.f845c = new File[a.this.p];
            this.f846d = new File[a.this.p];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.p; i++) {
                sb.append(i);
                this.f845c[i] = new File(a.this.j, sb.toString());
                sb.append(".tmp");
                this.f846d[i] = new File(a.this.j, sb.toString());
                sb.setLength(length);
            }
        }

        /* synthetic */ d(a aVar, String str, C0038a aVar2) {
            this(str);
        }

        private IOException m(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void n(String[] strArr) {
            if (strArr.length == a.this.p) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f844b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        m(strArr);
                        throw null;
                    }
                }
                return;
            }
            m(strArr);
            throw null;
        }

        public File j(int i) {
            return this.f845c[i];
        }

        public File k(int i) {
            return this.f846d[i];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f844b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }
    }

    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private final File[] f849a;

        private e(a aVar, String str, long j, File[] fileArr, long[] jArr) {
            this.f849a = fileArr;
        }

        /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, C0038a aVar2) {
            this(aVar, str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.f849a[i];
        }
    }

    private a(File file, int i, int i2, long j2) {
        File file2 = file;
        this.j = file2;
        this.n = i;
        this.k = new File(file2, "journal");
        this.l = new File(file2, "journal.tmp");
        this.m = new File(file2, "journal.bkp");
        this.p = i2;
        this.o = j2;
    }

    private void A() {
        u(this.l);
        Iterator<d> it = this.s.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f848f == null) {
                while (i < this.p) {
                    this.q += next.f844b[i];
                    i++;
                }
            } else {
                c unused = next.f848f = null;
                while (i < this.p) {
                    u(next.j(i));
                    u(next.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.t = r0 - r9.s.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.h() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        D();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.r = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.k, true), c.b.a.l.c.f850a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            c.b.a.l.b r1 = new c.b.a.l.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.k
            r2.<init>(r3)
            java.nio.charset.Charset r3 = c.b.a.l.c.f850a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.i()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.i()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.i()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.i()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.i()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.n     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.p     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.i()     // Catch:{ EOFException -> 0x005f }
            r9.C(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r2 = r9.s     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.t = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.h()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.D()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.k     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = c.b.a.l.c.f850a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.r = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            c.b.a.l.c.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            c.b.a.l.c.a(r1)
            goto L_0x00c0
        L_0x00bf:
            throw r0
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.a.B():void");
    }

    private void C(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.s.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            d dVar = this.s.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, (C0038a) null);
                this.s.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.f847e = true;
                c unused2 = dVar.f848f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c unused3 = dVar.f848f = new c(this, dVar, (C0038a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void D() {
        String str;
        Writer writer = this.r;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.l), c.f850a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.n));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.p));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.s.values()) {
                if (next.f848f != null) {
                    str = "DIRTY " + next.f843a + 10;
                } else {
                    str = "CLEAN " + next.f843a + next.l() + 10;
                }
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
            if (this.k.exists()) {
                F(this.k, this.m, true);
            }
            F(this.l, this.k, false);
            this.m.delete();
            this.r = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.k, true), c.f850a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void F(File file, File file2, boolean z) {
        if (z) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        while (this.q > this.o) {
            E((String) this.s.entrySet().iterator().next().getKey());
        }
    }

    private void r() {
        if (this.r == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void s(c.b.a.l.a.c r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            c.b.a.l.a$d r0 = r10.f839a     // Catch:{ all -> 0x010e }
            c.b.a.l.a$c r1 = r0.f848f     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f847e     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.p     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f840b     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.p     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f844b     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f844b     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.q     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.q = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            u(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.t     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.t = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            c.b.a.l.a.c unused = r0.f848f = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f847e     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f847e = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f843a     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.u     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.u = r1     // Catch:{ all -> 0x010e }
            long unused = r0.g = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r10 = r9.s     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f843a     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f843a     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.r     // Catch:{ all -> 0x010e }
            r10.flush()     // Catch:{ all -> 0x010e }
            long r10 = r9.q     // Catch:{ all -> 0x010e }
            long r0 = r9.o     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.y()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.v     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.w     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0112
        L_0x0111:
            throw r10
        L_0x0112:
            goto L_0x0111
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.a.s(c.b.a.l.a$c, boolean):void");
    }

    private static void u(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized c.b.a.l.a.c w(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.r()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r0 = r5.s     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            c.b.a.l.a$d r0 = (c.b.a.l.a.d) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.g     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            c.b.a.l.a$d r0 = new c.b.a.l.a$d     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r7 = r5.s     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            c.b.a.l.a$c r7 = r0.f848f     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            c.b.a.l.a$c r7 = new c.b.a.l.a$c     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r3)     // Catch:{ all -> 0x005d }
            c.b.a.l.a.c unused = r0.f848f = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.r     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.r     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.r     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.r     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.r     // Catch:{ all -> 0x005d }
            r6.flush()     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.a.w(java.lang.String, long):c.b.a.l.a$c");
    }

    /* access modifiers changed from: private */
    public boolean y() {
        int i = this.t;
        return i >= 2000 && i >= this.s.size();
    }

    public static a z(File file, int i, int i2, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    F(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j2);
            if (aVar.k.exists()) {
                try {
                    aVar.B();
                    aVar.A();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.t();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j2);
            aVar2.D();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean E(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.r()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r0 = r7.s     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            c.b.a.l.a$d r0 = (c.b.a.l.a.d) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            c.b.a.l.a$c r2 = r0.f848f     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.p     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.q     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f844b     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.q = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f844b     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.t     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.t = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.r     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.r     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.r     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.r     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, c.b.a.l.a$d> r0 = r7.s     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.y()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.v     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.w     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0093
        L_0x0092:
            throw r8
        L_0x0093:
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.l.a.E(java.lang.String):boolean");
    }

    public synchronized void close() {
        if (this.r != null) {
            Iterator it = new ArrayList(this.s.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f848f != null) {
                    dVar.f848f.a();
                }
            }
            G();
            this.r.close();
            this.r = null;
        }
    }

    public void t() {
        close();
        c.b(this.j);
    }

    public c v(String str) {
        return w(str, -1);
    }

    public synchronized e x(String str) {
        r();
        d dVar = this.s.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f847e) {
            return null;
        }
        for (File exists : dVar.f845c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.t++;
        this.r.append("READ");
        this.r.append(' ');
        this.r.append(str);
        this.r.append(10);
        if (y()) {
            this.v.submit(this.w);
        }
        return new e(this, str, dVar.g, dVar.f845c, dVar.f844b, (C0038a) null);
    }
}
