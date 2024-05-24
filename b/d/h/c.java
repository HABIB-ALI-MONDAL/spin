package b.d.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f599a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f600b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f601c;

    /* renamed from: d  reason: collision with root package name */
    private int f602d;

    /* renamed from: e  reason: collision with root package name */
    private Handler.Callback f603e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final int f604f;
    private final int g;
    private final String h;

    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c.this.a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                c.this.b((Runnable) message.obj);
                return true;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ Callable j;
        final /* synthetic */ Handler k;
        final /* synthetic */ d l;

        class a implements Runnable {
            final /* synthetic */ Object j;

            a(Object obj) {
                this.j = obj;
            }

            public void run() {
                b.this.l.a(this.j);
            }
        }

        b(c cVar, Callable callable, Handler handler, d dVar) {
            this.j = callable;
            this.k = handler;
            this.l = dVar;
        }

        public void run() {
            Object obj;
            try {
                obj = this.j.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.k.post(new a(obj));
        }
    }

    /* renamed from: b.d.h.c$c  reason: collision with other inner class name */
    class C0024c implements Runnable {
        final /* synthetic */ AtomicReference j;
        final /* synthetic */ Callable k;
        final /* synthetic */ ReentrantLock l;
        final /* synthetic */ AtomicBoolean m;
        final /* synthetic */ Condition n;

        C0024c(c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.j = atomicReference;
            this.k = callable;
            this.l = reentrantLock;
            this.m = atomicBoolean;
            this.n = condition;
        }

        public void run() {
            try {
                this.j.set(this.k.call());
            } catch (Exception unused) {
            }
            this.l.lock();
            try {
                this.m.set(false);
                this.n.signal();
            } finally {
                this.l.unlock();
            }
        }
    }

    public interface d<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f604f = i2;
        this.f602d = 0;
    }

    private void c(Runnable runnable) {
        synchronized (this.f599a) {
            if (this.f600b == null) {
                HandlerThread handlerThread = new HandlerThread(this.h, this.g);
                this.f600b = handlerThread;
                handlerThread.start();
                this.f601c = new Handler(this.f600b.getLooper(), this.f603e);
                this.f602d++;
            }
            this.f601c.removeMessages(0);
            Handler handler = this.f601c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f599a) {
            if (!this.f601c.hasMessages(1)) {
                this.f600b.quit();
                this.f600b = null;
                this.f601c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        runnable.run();
        synchronized (this.f599a) {
            this.f601c.removeMessages(0);
            Handler handler = this.f601c;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.f604f);
        }
    }

    public <T> void d(Callable<T> callable, d<T> dVar) {
        c(new b(this, callable, new Handler(), dVar));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T e(java.util.concurrent.Callable<T> r13, int r14) {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            b.d.h.c$c r11 = new b.d.h.c$c
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r12.c(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            goto L_0x0062
        L_0x0061:
            throw r13
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.h.c.e(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
