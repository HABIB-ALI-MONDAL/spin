package org.cocos2dx.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    static AsyncTimeout head;
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    class a implements Sink {
        final /* synthetic */ Sink j;

        a(Sink sink) {
            this.j = sink;
        }

        public void close() {
            AsyncTimeout.this.enter();
            try {
                this.j.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e2) {
                throw AsyncTimeout.this.exit(e2);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public void flush() {
            AsyncTimeout.this.enter();
            try {
                this.j.flush();
                AsyncTimeout.this.exit(true);
            } catch (IOException e2) {
                throw AsyncTimeout.this.exit(e2);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.j + ")";
        }

        public void write(Buffer buffer, long j2) {
            g.b(buffer.size, 0, j2);
            while (true) {
                long j3 = 0;
                if (j2 > 0) {
                    d dVar = buffer.head;
                    while (true) {
                        if (j3 >= 65536) {
                            break;
                        }
                        j3 += (long) (dVar.f3263c - dVar.f3262b);
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        dVar = dVar.f3266f;
                    }
                    AsyncTimeout.this.enter();
                    try {
                        this.j.write(buffer, j3);
                        j2 -= j3;
                        AsyncTimeout.this.exit(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit(e2);
                    } catch (Throwable th) {
                        AsyncTimeout.this.exit(false);
                        throw th;
                    }
                } else {
                    return;
                }
            }
        }
    }

    class b implements Source {
        final /* synthetic */ Source j;

        b(Source source) {
            this.j = source;
        }

        public void close() {
            try {
                this.j.close();
                AsyncTimeout.this.exit(true);
            } catch (IOException e2) {
                throw AsyncTimeout.this.exit(e2);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public long read(Buffer buffer, long j2) {
            AsyncTimeout.this.enter();
            try {
                long read = this.j.read(buffer, j2);
                AsyncTimeout.this.exit(true);
                return read;
            } catch (IOException e2) {
                throw AsyncTimeout.this.exit(e2);
            } catch (Throwable th) {
                AsyncTimeout.this.exit(false);
                throw th;
            }
        }

        public Timeout timeout() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.j + ")";
        }
    }

    private static final class c extends Thread {
        c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1.timedOut();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<org.cocos2dx.okio.AsyncTimeout> r0 = org.cocos2dx.okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                org.cocos2dx.okio.AsyncTimeout r1 = org.cocos2dx.okio.AsyncTimeout.awaitTimeout()     // Catch:{ all -> 0x0019 }
                if (r1 != 0) goto L_0x000b
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x0000
            L_0x000b:
                org.cocos2dx.okio.AsyncTimeout r2 = org.cocos2dx.okio.AsyncTimeout.head     // Catch:{ all -> 0x0019 }
                if (r1 != r2) goto L_0x0014
                r1 = 0
                org.cocos2dx.okio.AsyncTimeout.head = r1     // Catch:{ all -> 0x0019 }
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                return
            L_0x0014:
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                r1.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0019:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0019 }
                goto L_0x001d
            L_0x001c:
                throw r1
            L_0x001d:
                goto L_0x001c
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.AsyncTimeout.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    static AsyncTimeout awaitTimeout() {
        Class<AsyncTimeout> cls = AsyncTimeout.class;
        AsyncTimeout asyncTimeout = head.next;
        long nanoTime = System.nanoTime();
        if (asyncTimeout == null) {
            cls.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            cls.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = asyncTimeout.next;
        asyncTimeout.next = null;
        return asyncTimeout;
    }

    private static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        boolean z;
        synchronized (AsyncTimeout.class) {
            AsyncTimeout asyncTimeout2 = head;
            while (true) {
                if (asyncTimeout2 == null) {
                    z = true;
                    break;
                }
                AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                if (asyncTimeout3 == asyncTimeout) {
                    asyncTimeout2.next = asyncTimeout.next;
                    asyncTimeout.next = null;
                    z = false;
                    break;
                }
                asyncTimeout2 = asyncTimeout3;
            }
        }
        return z;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0052 A[EDGE_INSN: B:34:0x0052->B:23:0x0052 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void scheduleTimeout(org.cocos2dx.okio.AsyncTimeout r6, long r7, boolean r9) {
        /*
            java.lang.Class<org.cocos2dx.okio.AsyncTimeout> r0 = org.cocos2dx.okio.AsyncTimeout.class
            monitor-enter(r0)
            org.cocos2dx.okio.AsyncTimeout r1 = head     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0016
            org.cocos2dx.okio.AsyncTimeout r1 = new org.cocos2dx.okio.AsyncTimeout     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            head = r1     // Catch:{ all -> 0x0067 }
            org.cocos2dx.okio.AsyncTimeout$c r1 = new org.cocos2dx.okio.AsyncTimeout$c     // Catch:{ all -> 0x0067 }
            r1.<init>()     // Catch:{ all -> 0x0067 }
            r1.start()     // Catch:{ all -> 0x0067 }
        L_0x0016:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0067 }
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            if (r9 == 0) goto L_0x002f
            long r3 = r6.deadlineNanoTime()     // Catch:{ all -> 0x0067 }
            long r3 = r3 - r1
            long r7 = java.lang.Math.min(r7, r3)     // Catch:{ all -> 0x0067 }
        L_0x002b:
            long r7 = r7 + r1
            r6.timeoutAt = r7     // Catch:{ all -> 0x0067 }
            goto L_0x003c
        L_0x002f:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            if (r9 == 0) goto L_0x0061
            long r7 = r6.deadlineNanoTime()     // Catch:{ all -> 0x0067 }
            r6.timeoutAt = r7     // Catch:{ all -> 0x0067 }
        L_0x003c:
            long r7 = r6.remainingNanos(r1)     // Catch:{ all -> 0x0067 }
            org.cocos2dx.okio.AsyncTimeout r9 = head     // Catch:{ all -> 0x0067 }
        L_0x0042:
            org.cocos2dx.okio.AsyncTimeout r3 = r9.next     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0052
            long r3 = r3.remainingNanos(r1)     // Catch:{ all -> 0x0067 }
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            org.cocos2dx.okio.AsyncTimeout r9 = r9.next     // Catch:{ all -> 0x0067 }
            goto L_0x0042
        L_0x0052:
            org.cocos2dx.okio.AsyncTimeout r7 = r9.next     // Catch:{ all -> 0x0067 }
            r6.next = r7     // Catch:{ all -> 0x0067 }
            r9.next = r6     // Catch:{ all -> 0x0067 }
            org.cocos2dx.okio.AsyncTimeout r6 = head     // Catch:{ all -> 0x0067 }
            if (r9 != r6) goto L_0x005f
            r0.notify()     // Catch:{ all -> 0x0067 }
        L_0x005f:
            monitor-exit(r0)
            return
        L_0x0061:
            java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch:{ all -> 0x0067 }
            r6.<init>()     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r6 = move-exception
            monitor-exit(r0)
            goto L_0x006b
        L_0x006a:
            throw r6
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.AsyncTimeout.scheduleTimeout(org.cocos2dx.okio.AsyncTimeout, long, boolean):void");
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* access modifiers changed from: package-private */
    public final IOException exit(IOException iOException) {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    /* access modifiers changed from: package-private */
    public final void exit(boolean z) {
        if (exit() && z) {
            throw newTimeoutException((IOException) null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        return new a(sink);
    }

    public final Source source(Source source) {
        return new b(source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }
}
