package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Protocol;
import org.cocos2dx.okhttp3.internal.NamedRunnable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.b;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    /* access modifiers changed from: private */
    public boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final h readerRunnable;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final c writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2) {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new a();

        class a extends Listener {
            a() {
            }

            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        }

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    class a extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ ErrorCode k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.j = i;
            this.k = errorCode;
        }

        public void execute() {
            try {
                Http2Connection.this.writeSynReset(this.j, this.k);
            } catch (IOException unused) {
                Http2Connection.this.failConnection();
            }
        }
    }

    class b extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ long k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i, long j2) {
            super(str, objArr);
            this.j = i;
            this.k = j2;
        }

        public void execute() {
            try {
                Http2Connection.this.writer.x(this.j, this.k);
            } catch (IOException unused) {
                Http2Connection.this.failConnection();
            }
        }
    }

    class c extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ List k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.j = i;
            this.k = list;
        }

        public void execute() {
            if (Http2Connection.this.pushObserver.onRequest(this.j, this.k)) {
                try {
                    Http2Connection.this.writer.t(this.j, ErrorCode.CANCEL);
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.j));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class d extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ List k;
        final /* synthetic */ boolean l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.j = i;
            this.k = list;
            this.l = z;
        }

        public void execute() {
            boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(this.j, this.k, this.l);
            if (onHeaders) {
                try {
                    Http2Connection.this.writer.t(this.j, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.l) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.j));
                }
            }
        }
    }

    class e extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ Buffer k;
        final /* synthetic */ int l;
        final /* synthetic */ boolean m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i, Buffer buffer, int i2, boolean z) {
            super(str, objArr);
            this.j = i;
            this.k = buffer;
            this.l = i2;
            this.m = z;
        }

        public void execute() {
            try {
                boolean onData = Http2Connection.this.pushObserver.onData(this.j, this.k, this.l, this.m);
                if (onData) {
                    Http2Connection.this.writer.t(this.j, ErrorCode.CANCEL);
                }
                if (onData || this.m) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.j));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    class f extends NamedRunnable {
        final /* synthetic */ int j;
        final /* synthetic */ ErrorCode k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i, ErrorCode errorCode) {
            super(str, objArr);
            this.j = i;
            this.k = errorCode;
        }

        public void execute() {
            Http2Connection.this.pushObserver.onReset(this.j, this.k);
            synchronized (Http2Connection.this) {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.j));
            }
        }
    }

    final class g extends NamedRunnable {
        final boolean j;
        final int k;
        final int l;

        g(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            this.j = z;
            this.k = i;
            this.l = i2;
        }

        public void execute() {
            Http2Connection.this.writePing(this.j, this.k, this.l);
        }
    }

    class h extends NamedRunnable implements b.C0089b {
        final b j;

        class a extends NamedRunnable {
            final /* synthetic */ Http2Stream j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, Http2Stream http2Stream) {
                super(str, objArr);
                this.j = http2Stream;
            }

            public void execute() {
                try {
                    Http2Connection.this.listener.onStream(this.j);
                } catch (IOException e2) {
                    Platform platform = Platform.get();
                    platform.log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, e2);
                    try {
                        this.j.close(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends NamedRunnable {
            final /* synthetic */ boolean j;
            final /* synthetic */ Settings k;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z, Settings settings) {
                super(str, objArr);
                this.j = z;
                this.k = settings;
            }

            public void execute() {
                h.this.k(this.j, this.k);
            }
        }

        class c extends NamedRunnable {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            public void execute() {
                Http2Connection http2Connection = Http2Connection.this;
                http2Connection.listener.onSettings(http2Connection);
            }
        }

        h(b bVar) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.j = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
            r0.receiveHeaders(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r10, int r11, int r12, java.util.List<org.cocos2dx.okhttp3.internal.http2.Header> r13) {
            /*
                r9 = this;
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r12 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                boolean r12 = r12.pushedStream(r11)
                if (r12 == 0) goto L_0x000e
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r12 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                r12.pushHeadersLater(r11, r13, r10)
                return
            L_0x000e:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r12 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                monitor-enter(r12)
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r0 = r0.getStream(r11)     // Catch:{ all -> 0x0077 }
                if (r0 != 0) goto L_0x006d
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                boolean r1 = r0.shutdown     // Catch:{ all -> 0x0077 }
                if (r1 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0021:
                int r1 = r0.lastGoodStreamId     // Catch:{ all -> 0x0077 }
                if (r11 > r1) goto L_0x0027
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0027:
                int r1 = r11 % 2
                int r0 = r0.nextStreamId     // Catch:{ all -> 0x0077 }
                r2 = 2
                int r0 = r0 % r2
                if (r1 != r0) goto L_0x0031
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x0031:
                org.cocos2dx.okhttp3.Headers r8 = org.cocos2dx.okhttp3.internal.Util.toHeaders(r13)     // Catch:{ all -> 0x0077 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream r13 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0077 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r5 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0077 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r10 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                r10.lastGoodStreamId = r11     // Catch:{ all -> 0x0077 }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r10 = r10.streams     // Catch:{ all -> 0x0077 }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r10.put(r0, r13)     // Catch:{ all -> 0x0077 }
                java.util.concurrent.ExecutorService r10 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x0077 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection$h$a r0 = new org.cocos2dx.okhttp3.internal.http2.Http2Connection$h$a     // Catch:{ all -> 0x0077 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0077 }
                r3 = 0
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r4 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0077 }
                java.lang.String r4 = r4.hostname     // Catch:{ all -> 0x0077 }
                r2[r3] = r4     // Catch:{ all -> 0x0077 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0077 }
                r2[r3] = r11     // Catch:{ all -> 0x0077 }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x0077 }
                r10.execute(r0)     // Catch:{ all -> 0x0077 }
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                return
            L_0x006d:
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                r0.receiveHeaders(r13)
                if (r10 == 0) goto L_0x0076
                r0.receiveFin()
            L_0x0076:
                return
            L_0x0077:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x0077 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.h.a(boolean, int, int, java.util.List):void");
        }

        public void b() {
        }

        public void c(int i, long j2) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i == 0) {
                synchronized (http2Connection) {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.bytesLeftInWriteWindow += j2;
                    http2Connection2.notifyAll();
                }
                return;
            }
            Http2Stream stream = http2Connection.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j2);
                }
            }
        }

        public void d(boolean z, Settings settings) {
            try {
                Http2Connection.this.writerExecutor.execute(new b("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}, z, settings));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void e(int i, int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r4.k.close(r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR
                org.cocos2dx.okhttp3.internal.http2.b r1 = r4.j     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r1.h(r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
            L_0x0007:
                org.cocos2dx.okhttp3.internal.http2.b r1 = r4.j     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                r2 = 0
                boolean r1 = r1.f(r2, r4)     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r1 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001e, all -> 0x001b }
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001f }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0026 }
                r2.close(r1, r0)     // Catch:{ IOException -> 0x0026 }
                goto L_0x0026
            L_0x001b:
                r2 = move-exception
                r1 = r0
                goto L_0x002d
            L_0x001e:
                r1 = r0
            L_0x001f:
                org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x002c }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0026 }
                r1.close(r0, r0)     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                org.cocos2dx.okhttp3.internal.http2.b r0 = r4.j
                org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x002c:
                r2 = move-exception
            L_0x002d:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0032 }
                r3.close(r1, r0)     // Catch:{ IOException -> 0x0032 }
            L_0x0032:
                org.cocos2dx.okhttp3.internal.http2.b r0 = r4.j
                org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
                goto L_0x0039
            L_0x0038:
                throw r2
            L_0x0039:
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.h.execute():void");
        }

        public void f(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void g(int i, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void h(boolean z, int i, int i2) {
            if (z) {
                synchronized (Http2Connection.this) {
                    boolean unused = Http2Connection.this.awaitingPong = false;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new g(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public void i(int i, int i2, int i3, boolean z) {
        }

        public void j(boolean z, int i, BufferedSource bufferedSource, int i2) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                long j2 = (long) i2;
                Http2Connection.this.updateConnectionFlowControl(j2);
                bufferedSource.skip(j2);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|7|17|18|19|20|21) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k(boolean r6, org.cocos2dx.okhttp3.internal.http2.Settings r7) {
            /*
                r5 = this;
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r0 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                org.cocos2dx.okhttp3.internal.http2.c r0 = r0.writer
                monitor-enter(r0)
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0096 }
                monitor-enter(r1)     // Catch:{ all -> 0x0096 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Settings r2 = r2.peerSettings     // Catch:{ all -> 0x0093 }
                int r2 = r2.getInitialWindowSize()     // Catch:{ all -> 0x0093 }
                if (r6 == 0) goto L_0x0019
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r6 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0093 }
                r6.clear()     // Catch:{ all -> 0x0093 }
            L_0x0019:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r6 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0093 }
                r6.merge(r7)     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r6 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Settings r6 = r6.peerSettings     // Catch:{ all -> 0x0093 }
                int r6 = r6.getInitialWindowSize()     // Catch:{ all -> 0x0093 }
                r7 = -1
                r3 = 0
                if (r6 == r7) goto L_0x0054
                if (r6 == r2) goto L_0x0054
                int r6 = r6 - r2
                long r6 = (long) r6     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r2 = r2.streams     // Catch:{ all -> 0x0093 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0093 }
                if (r2 != 0) goto L_0x0056
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r2 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r2 = r2.streams     // Catch:{ all -> 0x0093 }
                java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0093 }
                java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r3 = r3.streams     // Catch:{ all -> 0x0093 }
                int r3 = r3.size()     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream[] r3 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream[r3]     // Catch:{ all -> 0x0093 }
                java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Stream[] r2 = (org.cocos2dx.okhttp3.internal.http2.Http2Stream[]) r2     // Catch:{ all -> 0x0093 }
                r3 = r2
                goto L_0x0056
            L_0x0054:
                r6 = 0
            L_0x0056:
                monitor-exit(r1)     // Catch:{ all -> 0x0093 }
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0061 }
                org.cocos2dx.okhttp3.internal.http2.c r2 = r1.writer     // Catch:{ IOException -> 0x0061 }
                org.cocos2dx.okhttp3.internal.http2.Settings r1 = r1.peerSettings     // Catch:{ IOException -> 0x0061 }
                r2.c(r1)     // Catch:{ IOException -> 0x0061 }
                goto L_0x0066
            L_0x0061:
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r1 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0096 }
                r1.failConnection()     // Catch:{ all -> 0x0096 }
            L_0x0066:
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                r0 = 0
                if (r3 == 0) goto L_0x007b
                int r1 = r3.length
                r2 = 0
            L_0x006c:
                if (r2 >= r1) goto L_0x007b
                r4 = r3[r2]
                monitor-enter(r4)
                r4.addBytesToWriteWindow(r6)     // Catch:{ all -> 0x0078 }
                monitor-exit(r4)     // Catch:{ all -> 0x0078 }
                int r2 = r2 + 1
                goto L_0x006c
            L_0x0078:
                r6 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0078 }
                throw r6
            L_0x007b:
                java.util.concurrent.ExecutorService r6 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.listenerExecutor
                org.cocos2dx.okhttp3.internal.http2.Http2Connection$h$c r7 = new org.cocos2dx.okhttp3.internal.http2.Http2Connection$h$c
                java.lang.String r1 = "OkHttp %s settings"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                org.cocos2dx.okhttp3.internal.http2.Http2Connection r3 = org.cocos2dx.okhttp3.internal.http2.Http2Connection.this
                java.lang.String r3 = r3.hostname
                r2[r0] = r3
                r7.<init>(r1, r2)
                r6.execute(r7)
                return
            L_0x0093:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0093 }
                throw r6     // Catch:{ all -> 0x0096 }
            L_0x0096:
                r6 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0096 }
                goto L_0x009a
            L_0x0099:
                throw r6
            L_0x009a:
                goto L_0x0099
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.h.k(boolean, org.cocos2dx.okhttp3.internal.http2.Settings):void");
        }
    }

    static {
        Class<Http2Connection> cls = Http2Connection.class;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder2.pushObserver;
        boolean z = builder2.client;
        this.client = z;
        this.listener = builder2.listener;
        int i = z ? 1 : 2;
        this.nextStreamId = i;
        if (z) {
            this.nextStreamId = i + 2;
        }
        if (z) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        String str = builder2.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder2.pingIntervalMillis != 0) {
            g gVar = new g(false, 0, 0);
            int i2 = builder2.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(gVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) settings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new c(builder2.sink, z);
        this.readerRunnable = new h(new b(builder2.source, z));
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.cocos2dx.okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<org.cocos2dx.okhttp3.internal.http2.Header> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            org.cocos2dx.okhttp3.internal.http2.c r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            org.cocos2dx.okhttp3.internal.http2.ErrorCode r0 = org.cocos2dx.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.shutdown     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0073 }
            org.cocos2dx.okhttp3.internal.http2.Http2Stream r9 = new org.cocos2dx.okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.bytesLeftInWriteWindow     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.bytesLeftInWriteWindow     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r0 = r10.streams     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            org.cocos2dx.okhttp3.internal.http2.c r0 = r10.writer     // Catch:{ all -> 0x0076 }
            r0.w(r6, r8, r11, r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.client     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            org.cocos2dx.okhttp3.internal.http2.c r0 = r10.writer     // Catch:{ all -> 0x0076 }
            r0.s(r11, r8, r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            org.cocos2dx.okhttp3.internal.http2.c r11 = r10.writer
            r11.flush()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            org.cocos2dx.okhttp3.internal.http2.ConnectionShutdownException r11 = new org.cocos2dx.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):org.cocos2dx.okhttp3.internal.http2.Http2Stream");
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!isShutdown()) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void awaitPong() {
        while (this.awaitingPong) {
            wait();
        }
    }

    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void flush() {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z) {
        return newStream(0, list, z);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) {
        Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            pushExecutorExecute(new e("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    public void pushHeadersLater(int i, List<Header> list, boolean z) {
        try {
            pushExecutorExecute(new d("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void pushRequestLater(int i, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            try {
                pushExecutorExecute(new c("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pushResetLater(int i, ErrorCode errorCode) {
        pushExecutorExecute(new f("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode));
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) {
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: package-private */
    public boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream removeStream(int i) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void setSettings(Settings settings) {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.u(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i = this.lastGoodStreamId;
                    this.writer.o(i, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public void start(boolean z) {
        if (z) {
            this.writer.f();
            this.writer.u(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.x(0, (long) (initialWindowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateConnectionFlowControl(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.writer.q());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, org.cocos2dx.okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            org.cocos2dx.okhttp3.internal.http2.c r12 = r8.writer
            r12.h(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, org.cocos2dx.okhttp3.internal.http2.Http2Stream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            org.cocos2dx.okhttp3.internal.http2.c r3 = r8.writer     // Catch:{ all -> 0x0056 }
            int r3 = r3.q()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            org.cocos2dx.okhttp3.internal.http2.c r4 = r8.writer
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.h(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.Http2Connection.writeData(int, boolean, org.cocos2dx.okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void writePing(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection();
                return;
            }
        }
        try {
            this.writer.r(z, i, i2);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: package-private */
    public void writePingAndAwaitPong() {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int i, boolean z, List<Header> list) {
        this.writer.v(z, i, list);
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int i, ErrorCode errorCode) {
        this.writer.t(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int i, ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new a("OkHttp %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int i, long j) {
        try {
            this.writerExecutor.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.hostname, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }
}
