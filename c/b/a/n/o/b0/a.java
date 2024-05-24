package c.b.a.n.o.b0;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final long f933b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f934c;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f935a;

    /* renamed from: c.b.a.n.o.b0.a$a  reason: collision with other inner class name */
    private static final class C0042a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f936a;

        /* renamed from: b  reason: collision with root package name */
        final b f937b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f938c;

        /* renamed from: d  reason: collision with root package name */
        private int f939d;

        /* renamed from: c.b.a.n.o.b0.a$a$a  reason: collision with other inner class name */
        class C0043a extends Thread {
            C0043a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (C0042a.this.f938c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    C0042a.this.f937b.a(th);
                }
            }
        }

        C0042a(String str, b bVar, boolean z) {
            this.f936a = str;
            this.f937b = bVar;
            this.f938c = z;
        }

        public synchronized Thread newThread(Runnable runnable) {
            C0043a aVar;
            aVar = new C0043a(runnable, "glide-" + this.f936a + "-thread-" + this.f939d);
            this.f939d = this.f939d + 1;
            return aVar;
        }
    }

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f940a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f941b;

        /* renamed from: c.b.a.n.o.b0.a$b$a  reason: collision with other inner class name */
        class C0044a implements b {
            C0044a() {
            }

            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0044a aVar = new C0044a();
            f940a = aVar;
            f941b = aVar;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f935a = executorService;
    }

    public static int a() {
        if (f934c == 0) {
            f934c = Math.min(4, b.a());
        }
        return f934c;
    }

    public static a b() {
        return c(a() >= 4 ? 2 : 1, b.f941b);
    }

    public static a c(int i, b bVar) {
        return new a(new ThreadPoolExecutor(0, i, f933b, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0042a("animation", bVar, true)));
    }

    public static a d() {
        return e(1, "disk-cache", b.f941b);
    }

    public static a e(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0042a(str, bVar, true)));
    }

    public static a f() {
        return g(a(), "source", b.f941b);
    }

    public static a g(int i, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0042a(str, bVar, false)));
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f933b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C0042a("source-unlimited", b.f941b, false)));
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f935a.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.f935a.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f935a.invokeAll(collection);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f935a.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return this.f935a.invokeAny(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f935a.invokeAny(collection, j, timeUnit);
    }

    public boolean isShutdown() {
        return this.f935a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f935a.isTerminated();
    }

    public void shutdown() {
        this.f935a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f935a.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f935a.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f935a.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f935a.submit(callable);
    }

    public String toString() {
        return this.f935a.toString();
    }
}
