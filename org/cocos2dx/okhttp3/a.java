package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.internal.NamedRunnable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.cache.CacheInterceptor;
import org.cocos2dx.okhttp3.internal.connection.ConnectInterceptor;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.http.BridgeInterceptor;
import org.cocos2dx.okhttp3.internal.http.CallServerInterceptor;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;
import org.cocos2dx.okhttp3.internal.http.RealInterceptorChain;
import org.cocos2dx.okhttp3.internal.http.RetryAndFollowUpInterceptor;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.AsyncTimeout;
import org.cocos2dx.okio.Timeout;

final class a implements Call {
    final OkHttpClient j;
    final RetryAndFollowUpInterceptor k;
    final AsyncTimeout l;
    /* access modifiers changed from: private */
    @Nullable
    public EventListener m;
    final Request n;
    final boolean o;
    private boolean p;

    /* renamed from: org.cocos2dx.okhttp3.a$a  reason: collision with other inner class name */
    class C0087a extends AsyncTimeout {
        C0087a() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            a.this.cancel();
        }
    }

    final class b extends NamedRunnable {
        private final Callback j;

        static {
            Class<a> cls = a.class;
        }

        b(Callback callback) {
            super("OkHttp %s", a.this.i());
            this.j = callback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0079 A[Catch:{ IOException -> 0x004e, all -> 0x0026, all -> 0x008d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r5 = this;
                org.cocos2dx.okhttp3.a r0 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okio.AsyncTimeout r0 = r0.l
                r0.enter()
                r0 = 0
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this     // Catch:{ IOException -> 0x004e, all -> 0x0026 }
                org.cocos2dx.okhttp3.Response r0 = r1.e()     // Catch:{ IOException -> 0x004e, all -> 0x0026 }
                r1 = 1
                org.cocos2dx.okhttp3.Callback r2 = r5.j     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                org.cocos2dx.okhttp3.a r3 = org.cocos2dx.okhttp3.a.this     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            L_0x0016:
                org.cocos2dx.okhttp3.a r0 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okhttp3.OkHttpClient r0 = r0.j
                org.cocos2dx.okhttp3.Dispatcher r0 = r0.dispatcher()
                r0.finished((org.cocos2dx.okhttp3.a.b) r5)
                goto L_0x008c
            L_0x0022:
                r0 = move-exception
                goto L_0x0029
            L_0x0024:
                r0 = move-exception
                goto L_0x0051
            L_0x0026:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0029:
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                r2.cancel()     // Catch:{ all -> 0x008d }
                if (r1 != 0) goto L_0x004d
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x008d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
                r2.<init>()     // Catch:{ all -> 0x008d }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x008d }
                r2.append(r0)     // Catch:{ all -> 0x008d }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008d }
                r1.<init>(r2)     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.Callback r2 = r5.j     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.a r3 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x008d }
            L_0x004d:
                throw r0     // Catch:{ all -> 0x008d }
            L_0x004e:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0051:
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                java.io.IOException r0 = r2.k(r0)     // Catch:{ all -> 0x008d }
                if (r1 == 0) goto L_0x0079
                org.cocos2dx.okhttp3.internal.platform.Platform r1 = org.cocos2dx.okhttp3.internal.platform.Platform.get()     // Catch:{ all -> 0x008d }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
                r3.<init>()     // Catch:{ all -> 0x008d }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.a r4 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                java.lang.String r4 = r4.l()     // Catch:{ all -> 0x008d }
                r3.append(r4)     // Catch:{ all -> 0x008d }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008d }
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x008d }
                goto L_0x0016
            L_0x0079:
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.EventListener r1 = r1.m     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                r1.callFailed(r2, r0)     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.Callback r1 = r5.j     // Catch:{ all -> 0x008d }
                org.cocos2dx.okhttp3.a r2 = org.cocos2dx.okhttp3.a.this     // Catch:{ all -> 0x008d }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x008d }
                goto L_0x0016
            L_0x008c:
                return
            L_0x008d:
                r0 = move-exception
                org.cocos2dx.okhttp3.a r1 = org.cocos2dx.okhttp3.a.this
                org.cocos2dx.okhttp3.OkHttpClient r1 = r1.j
                org.cocos2dx.okhttp3.Dispatcher r1 = r1.dispatcher()
                r1.finished((org.cocos2dx.okhttp3.a.b) r5)
                goto L_0x009b
            L_0x009a:
                throw r0
            L_0x009b:
                goto L_0x009a
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.a.b.execute():void");
        }

        /* access modifiers changed from: package-private */
        public void k(ExecutorService executorService) {
            try {
                executorService.execute(this);
            } catch (RejectedExecutionException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e2);
                a.this.m.callFailed(a.this, interruptedIOException);
                this.j.onFailure(a.this, interruptedIOException);
                a.this.j.dispatcher().finished(this);
            } catch (Throwable th) {
                a.this.j.dispatcher().finished(this);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public a l() {
            return a.this;
        }

        /* access modifiers changed from: package-private */
        public String m() {
            return a.this.n.url().host();
        }
    }

    private a(OkHttpClient okHttpClient, Request request, boolean z) {
        this.j = okHttpClient;
        this.n = request;
        this.o = z;
        this.k = new RetryAndFollowUpInterceptor(okHttpClient, z);
        C0087a aVar = new C0087a();
        this.l = aVar;
        aVar.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private void b() {
        this.k.setCallStackTrace(Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    static a g(OkHttpClient okHttpClient, Request request, boolean z) {
        a aVar = new a(okHttpClient, request, z);
        aVar.m = okHttpClient.eventListenerFactory().create(aVar);
        return aVar;
    }

    public void cancel() {
        this.k.cancel();
    }

    /* renamed from: d */
    public a clone() {
        return g(this.j, this.n, this.o);
    }

    /* access modifiers changed from: package-private */
    public Response e() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.j.interceptors());
        arrayList.add(this.k);
        arrayList.add(new BridgeInterceptor(this.j.cookieJar()));
        arrayList.add(new CacheInterceptor(this.j.internalCache()));
        arrayList.add(new ConnectInterceptor(this.j));
        if (!this.o) {
            arrayList.addAll(this.j.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.o));
        Response proceed = new RealInterceptorChain(arrayList, (StreamAllocation) null, (HttpCodec) null, (RealConnection) null, 0, this.n, this, this.m, this.j.connectTimeoutMillis(), this.j.readTimeoutMillis(), this.j.writeTimeoutMillis()).proceed(this.n);
        if (!this.k.isCanceled()) {
            return proceed;
        }
        Util.closeQuietly((Closeable) proceed);
        throw new IOException("Canceled");
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (!this.p) {
                this.p = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.m.callStart(this);
        this.j.dispatcher().enqueue(new b(callback));
    }

    public Response execute() {
        synchronized (this) {
            if (!this.p) {
                this.p = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        b();
        this.l.enter();
        this.m.callStart(this);
        try {
            this.j.dispatcher().executed(this);
            Response e2 = e();
            if (e2 != null) {
                this.j.dispatcher().finished(this);
                return e2;
            }
            throw new IOException("Canceled");
        } catch (IOException e3) {
            IOException k2 = k(e3);
            this.m.callFailed(this, k2);
            throw k2;
        } catch (Throwable th) {
            this.j.dispatcher().finished(this);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return this.n.url().redact();
    }

    public boolean isCanceled() {
        return this.k.isCanceled();
    }

    public synchronized boolean isExecuted() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public StreamAllocation j() {
        return this.k.streamAllocation();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException k(@Nullable IOException iOException) {
        if (!this.l.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: package-private */
    public String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.o ? "web socket" : "call");
        sb.append(" to ");
        sb.append(i());
        return sb.toString();
    }

    public Request request() {
        return this.n;
    }

    public Timeout timeout() {
        return this.l;
    }
}
