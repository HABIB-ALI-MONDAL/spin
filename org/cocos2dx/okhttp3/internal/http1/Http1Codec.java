package org.cocos2dx.okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.ResponseBody;
import org.cocos2dx.okhttp3.internal.Internal;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.connection.RealConnection;
import org.cocos2dx.okhttp3.internal.connection.StreamAllocation;
import org.cocos2dx.okhttp3.internal.http.HttpCodec;
import org.cocos2dx.okhttp3.internal.http.HttpHeaders;
import org.cocos2dx.okhttp3.internal.http.RealResponseBody;
import org.cocos2dx.okhttp3.internal.http.RequestLine;
import org.cocos2dx.okhttp3.internal.http.StatusLine;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ForwardingTimeout;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;
import org.cocos2dx.okio.Timeout;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final BufferedSink sink;
    final BufferedSource source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class b implements Source {
        protected final ForwardingTimeout j;
        protected boolean k;
        protected long l;

        private b() {
            this.j = new ForwardingTimeout(Http1Codec.this.source.timeout());
            this.l = 0;
        }

        /* access modifiers changed from: protected */
        public final void c(boolean z, IOException iOException) {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.state;
            if (i != 6) {
                if (i == 5) {
                    http1Codec.detachTimeout(this.j);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.state = 6;
                    StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!z, http1Codec2, this.l, iOException);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + Http1Codec.this.state);
            }
        }

        public long read(Buffer buffer, long j2) {
            try {
                long read = Http1Codec.this.source.read(buffer, j2);
                if (read > 0) {
                    this.l += read;
                }
                return read;
            } catch (IOException e2) {
                c(false, e2);
                throw e2;
            }
        }

        public Timeout timeout() {
            return this.j;
        }
    }

    private final class c implements Sink {
        private final ForwardingTimeout j;
        private boolean k;

        c() {
            this.j = new ForwardingTimeout(Http1Codec.this.sink.timeout());
        }

        public synchronized void close() {
            if (!this.k) {
                this.k = true;
                Http1Codec.this.sink.writeUtf8("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.j);
                Http1Codec.this.state = 3;
            }
        }

        public synchronized void flush() {
            if (!this.k) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.j;
        }

        public void write(Buffer buffer, long j2) {
            if (this.k) {
                throw new IllegalStateException("closed");
            } else if (j2 != 0) {
                Http1Codec.this.sink.writeHexadecimalUnsignedLong(j2);
                Http1Codec.this.sink.writeUtf8("\r\n");
                Http1Codec.this.sink.write(buffer, j2);
                Http1Codec.this.sink.writeUtf8("\r\n");
            }
        }
    }

    private class d extends b {
        private final HttpUrl n;
        private long o = -1;
        private boolean p = true;

        d(HttpUrl httpUrl) {
            super();
            this.n = httpUrl;
        }

        private void f() {
            if (this.o != -1) {
                Http1Codec.this.source.readUtf8LineStrict();
            }
            try {
                this.o = Http1Codec.this.source.readHexadecimalUnsignedLong();
                String trim = Http1Codec.this.source.readUtf8LineStrict().trim();
                if (this.o < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.o + trim + "\"");
                } else if (this.o == 0) {
                    this.p = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.n, Http1Codec.this.readHeaders());
                    c(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() {
            if (!this.k) {
                if (this.p && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    c(false, (IOException) null);
                }
                this.k = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.k) {
                throw new IllegalStateException("closed");
            } else if (!this.p) {
                return -1;
            } else {
                long j2 = this.o;
                if (j2 == 0 || j2 == -1) {
                    f();
                    if (!this.p) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j, this.o));
                if (read != -1) {
                    this.o -= read;
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                c(false, protocolException);
                throw protocolException;
            }
        }
    }

    private final class e implements Sink {
        private final ForwardingTimeout j;
        private boolean k;
        private long l;

        e(long j2) {
            this.j = new ForwardingTimeout(Http1Codec.this.sink.timeout());
            this.l = j2;
        }

        public void close() {
            if (!this.k) {
                this.k = true;
                if (this.l <= 0) {
                    Http1Codec.this.detachTimeout(this.j);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void flush() {
            if (!this.k) {
                Http1Codec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.j;
        }

        public void write(Buffer buffer, long j2) {
            if (!this.k) {
                Util.checkOffsetAndCount(buffer.size(), 0, j2);
                if (j2 <= this.l) {
                    Http1Codec.this.sink.write(buffer, j2);
                    this.l -= j2;
                    return;
                }
                throw new ProtocolException("expected " + this.l + " bytes but received " + j2);
            }
            throw new IllegalStateException("closed");
        }
    }

    private class f extends b {
        private long n;

        f(Http1Codec http1Codec, long j) {
            super();
            this.n = j;
            if (j == 0) {
                c(true, (IOException) null);
            }
        }

        public void close() {
            if (!this.k) {
                if (this.n != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    c(false, (IOException) null);
                }
                this.k = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (!this.k) {
                long j2 = this.n;
                if (j2 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j2, j));
                if (read != -1) {
                    long j3 = this.n - read;
                    this.n = j3;
                    if (j3 == 0) {
                        c(true, (IOException) null);
                    }
                    return read;
                }
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                c(false, protocolException);
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    private class g extends b {
        private boolean n;

        g(Http1Codec http1Codec) {
            super();
        }

        public void close() {
            if (!this.k) {
                if (!this.n) {
                    c(false, (IOException) null);
                }
                this.k = true;
            }
        }

        public long read(Buffer buffer, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.k) {
                throw new IllegalStateException("closed");
            } else if (this.n) {
                return -1;
            } else {
                long read = super.read(buffer, j);
                if (read != -1) {
                    return read;
                }
                this.n = true;
                c(true, (IOException) null);
                return -1;
            }
        }
    }

    public Http1Codec(OkHttpClient okHttpClient, StreamAllocation streamAllocation2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.streamAllocation = streamAllocation2;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    private String readHeaderLine() {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* access modifiers changed from: package-private */
    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public void finishRequest() {
        this.sink.flush();
    }

    public void flushRequest() {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new d(httpUrl);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new f(this, j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new g(this);
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public ResponseBody openResponseBody(Response response) {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        String header = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(header, 0, Okio.buffer(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(header, -1, Okio.buffer(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        return contentLength != -1 ? new RealResponseBody(header, contentLength, Okio.buffer(newFixedLengthSource(contentLength))) : new RealResponseBody(header, -1, Okio.buffer(newUnknownLengthSource()));
    }

    public Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            if (readHeaderLine.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, readHeaderLine);
        }
    }

    public Response.Builder readResponseHeaders(boolean z) {
        int i = this.state;
        if (i == 1 || i == 3) {
            try {
                StatusLine parse = StatusLine.parse(readHeaderLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                if (z && parse.code == 100) {
                    return null;
                }
                if (parse.code == 100) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }

    public void writeRequest(Headers headers, String str) {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8("\r\n");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
            }
            this.sink.writeUtf8("\r\n");
            this.state = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void writeRequestHeaders(Request request) {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }
}
