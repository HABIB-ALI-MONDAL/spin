package org.cocos2dx.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class Okio {
    static final Logger logger = Logger.getLogger(Okio.class.getName());

    class a implements Sink {
        final /* synthetic */ Timeout j;
        final /* synthetic */ OutputStream k;

        a(Timeout timeout, OutputStream outputStream) {
            this.j = timeout;
            this.k = outputStream;
        }

        public void close() {
            this.k.close();
        }

        public void flush() {
            this.k.flush();
        }

        public Timeout timeout() {
            return this.j;
        }

        public String toString() {
            return "sink(" + this.k + ")";
        }

        public void write(Buffer buffer, long j2) {
            g.b(buffer.size, 0, j2);
            while (j2 > 0) {
                this.j.throwIfReached();
                d dVar = buffer.head;
                int min = (int) Math.min(j2, (long) (dVar.f3263c - dVar.f3262b));
                this.k.write(dVar.f3261a, dVar.f3262b, min);
                int i = dVar.f3262b + min;
                dVar.f3262b = i;
                long j3 = (long) min;
                j2 -= j3;
                buffer.size -= j3;
                if (i == dVar.f3263c) {
                    buffer.head = dVar.b();
                    e.a(dVar);
                }
            }
        }
    }

    class b implements Source {
        final /* synthetic */ Timeout j;
        final /* synthetic */ InputStream k;

        b(Timeout timeout, InputStream inputStream) {
            this.j = timeout;
            this.k = inputStream;
        }

        public void close() {
            this.k.close();
        }

        public long read(Buffer buffer, long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (j2 == 0) {
                return 0;
            } else {
                try {
                    this.j.throwIfReached();
                    d writableSegment = buffer.writableSegment(1);
                    int read = this.k.read(writableSegment.f3261a, writableSegment.f3263c, (int) Math.min(j2, (long) (8192 - writableSegment.f3263c)));
                    if (read == -1) {
                        return -1;
                    }
                    writableSegment.f3263c += read;
                    long j3 = (long) read;
                    buffer.size += j3;
                    return j3;
                } catch (AssertionError e2) {
                    if (Okio.isAndroidGetsocknameError(e2)) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public Timeout timeout() {
            return this.j;
        }

        public String toString() {
            return "source(" + this.k + ")";
        }
    }

    class c implements Sink {
        c() {
        }

        public void close() {
        }

        public void flush() {
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j) {
            buffer.skip(j);
        }
    }

    class d extends AsyncTimeout {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Socket f3258a;

        d(Socket socket) {
            this.f3258a = socket;
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void timedOut() {
            /*
                r5 = this;
                java.lang.String r0 = "Failed to close timed out socket "
                java.net.Socket r1 = r5.f3258a     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                r1.close()     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                goto L_0x0033
            L_0x0008:
                r1 = move-exception
                boolean r2 = org.cocos2dx.okio.Okio.isAndroidGetsocknameError(r1)
                if (r2 == 0) goto L_0x0019
                java.util.logging.Logger r2 = org.cocos2dx.okio.Okio.logger
                java.util.logging.Level r3 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                goto L_0x0024
            L_0x0019:
                throw r1
            L_0x001a:
                r1 = move-exception
                java.util.logging.Logger r2 = org.cocos2dx.okio.Okio.logger
                java.util.logging.Level r3 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
            L_0x0024:
                r4.append(r0)
                java.net.Socket r0 = r5.f3258a
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.log(r3, r0, r1)
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.Okio.d.timedOut():void");
        }
    }

    private Okio() {
    }

    public static Sink appendingSink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new c();
    }

    public static BufferedSink buffer(Sink sink) {
        return new b(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new c(source);
    }

    static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink sink(File file) {
        if (file != null) {
            return sink((OutputStream) new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return sink(outputStream, new Timeout());
    }

    private static Sink sink(OutputStream outputStream, Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new a(timeout, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Sink sink(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.sink(sink(socket.getOutputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    @IgnoreJRERequirement
    public static Sink sink(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return sink(Files.newOutputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    public static Source source(File file) {
        if (file != null) {
            return source((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return source(inputStream, new Timeout());
    }

    private static Source source(InputStream inputStream, Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new b(timeout, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static Source source(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            AsyncTimeout timeout = timeout(socket);
            return timeout.source(source(socket.getInputStream(), (Timeout) timeout));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    @IgnoreJRERequirement
    public static Source source(Path path, OpenOption... openOptionArr) {
        if (path != null) {
            return source(Files.newInputStream(path, openOptionArr));
        }
        throw new IllegalArgumentException("path == null");
    }

    private static AsyncTimeout timeout(Socket socket) {
        return new d(socket);
    }
}
