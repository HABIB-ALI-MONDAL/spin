package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.cache.CacheRequest;
import org.cocos2dx.okhttp3.internal.cache.CacheStrategy;
import org.cocos2dx.okhttp3.internal.cache.DiskLruCache;
import org.cocos2dx.okhttp3.internal.cache.InternalCache;
import org.cocos2dx.okhttp3.internal.http.HttpHeaders;
import org.cocos2dx.okhttp3.internal.http.HttpMethod;
import org.cocos2dx.okhttp3.internal.http.StatusLine;
import org.cocos2dx.okhttp3.internal.io.FileSystem;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.ForwardingSink;
import org.cocos2dx.okio.ForwardingSource;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    class a implements InternalCache {
        a() {
        }

        public Response get(Request request) {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) {
            return Cache.this.put(response);
        }

        public void remove(Request request) {
            Cache.this.remove(request);
        }

        public void trackConditionalCacheHit() {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.trackResponse(cacheStrategy);
        }

        public void update(Response response, Response response2) {
            Cache.this.update(response, response2);
        }
    }

    class b implements Iterator<String> {
        final Iterator<DiskLruCache.Snapshot> j;
        @Nullable
        String k;
        boolean l;

        b() {
            this.j = Cache.this.cache.snapshots();
        }

        /* renamed from: b */
        public String next() {
            if (hasNext()) {
                String str = this.k;
                this.k = null;
                this.l = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.k != null) {
                return true;
            }
            this.l = false;
            while (this.j.hasNext()) {
                DiskLruCache.Snapshot next = this.j.next();
                try {
                    this.k = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                    return true;
                } catch (IOException unused) {
                } finally {
                    next.close();
                }
            }
            return false;
        }

        public void remove() {
            if (this.l) {
                this.j.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private final class c implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        private final DiskLruCache.Editor f3158a;

        /* renamed from: b  reason: collision with root package name */
        private Sink f3159b;

        /* renamed from: c  reason: collision with root package name */
        private Sink f3160c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3161d;

        class a extends ForwardingSink {
            final /* synthetic */ DiskLruCache.Editor j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Sink sink, Cache cache, DiskLruCache.Editor editor) {
                super(sink);
                this.j = editor;
            }

            public void close() {
                synchronized (Cache.this) {
                    c cVar = c.this;
                    if (!cVar.f3161d) {
                        cVar.f3161d = true;
                        Cache.this.writeSuccessCount++;
                        super.close();
                        this.j.commit();
                    }
                }
            }
        }

        c(DiskLruCache.Editor editor) {
            this.f3158a = editor;
            Sink newSink = editor.newSink(1);
            this.f3159b = newSink;
            this.f3160c = new a(newSink, Cache.this, editor);
        }

        public void abort() {
            synchronized (Cache.this) {
                if (!this.f3161d) {
                    this.f3161d = true;
                    Cache.this.writeAbortCount++;
                    Util.closeQuietly((Closeable) this.f3159b);
                    try {
                        this.f3158a.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.f3160c;
        }
    }

    private static class d extends ResponseBody {
        final DiskLruCache.Snapshot j;
        private final BufferedSource k;
        @Nullable
        private final String l;
        @Nullable
        private final String m;

        class a extends ForwardingSource {
            final /* synthetic */ DiskLruCache.Snapshot j;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, Source source, DiskLruCache.Snapshot snapshot) {
                super(source);
                this.j = snapshot;
            }

            public void close() {
                this.j.close();
                super.close();
            }
        }

        d(DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.j = snapshot;
            this.l = str;
            this.m = str2;
            this.k = Okio.buffer((Source) new a(this, snapshot.getSource(1), snapshot));
        }

        public long contentLength() {
            try {
                String str = this.m;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.l;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.k;
        }
    }

    private static final class e {
        private static final String k = (Platform.get().getPrefix() + "-Sent-Millis");
        private static final String l = (Platform.get().getPrefix() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f3163a;

        /* renamed from: b  reason: collision with root package name */
        private final Headers f3164b;

        /* renamed from: c  reason: collision with root package name */
        private final String f3165c;

        /* renamed from: d  reason: collision with root package name */
        private final Protocol f3166d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3167e;

        /* renamed from: f  reason: collision with root package name */
        private final String f3168f;
        private final Headers g;
        @Nullable
        private final Handshake h;
        private final long i;
        private final long j;

        e(Response response) {
            this.f3163a = response.request().url().toString();
            this.f3164b = HttpHeaders.varyHeaders(response);
            this.f3165c = response.request().method();
            this.f3166d = response.protocol();
            this.f3167e = response.code();
            this.f3168f = response.message();
            this.g = response.headers();
            this.h = response.handshake();
            this.i = response.sentRequestAtMillis();
            this.j = response.receivedResponseAtMillis();
        }

        e(Source source) {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f3163a = buffer.readUtf8LineStrict();
                this.f3165c = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(buffer);
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.addLenient(buffer.readUtf8LineStrict());
                }
                this.f3164b = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f3166d = parse.protocol;
                this.f3167e = parse.code;
                this.f3168f = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(buffer);
                for (int i3 = 0; i3 < readInt2; i3++) {
                    builder2.addLenient(buffer.readUtf8LineStrict());
                }
                String str = k;
                String str2 = builder2.get(str);
                String str3 = l;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j2 = 0;
                this.i = str2 != null ? Long.parseLong(str2) : 0;
                this.j = str4 != null ? Long.parseLong(str4) : j2;
                this.g = builder2.build();
                if (a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        this.h = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), c(buffer), c(buffer));
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.h = null;
                }
            } finally {
                source.close();
            }
        }

        private boolean a() {
            return this.f3163a.startsWith("https://");
        }

        private List<Certificate> c(BufferedSource bufferedSource) {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 < readInt; i2++) {
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private void e(BufferedSink bufferedSink, List<Certificate> list) {
            try {
                bufferedSink.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i2).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public boolean b(Request request, Response response) {
            return this.f3163a.equals(request.url().toString()) && this.f3165c.equals(request.method()) && HttpHeaders.varyMatches(response, this.f3164b, request);
        }

        public Response d(DiskLruCache.Snapshot snapshot) {
            String str = this.g.get("Content-Type");
            String str2 = this.g.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f3163a).method(this.f3165c, (RequestBody) null).headers(this.f3164b).build()).protocol(this.f3166d).code(this.f3167e).message(this.f3168f).headers(this.g).body(new d(snapshot, str, str2)).handshake(this.h).sentRequestAtMillis(this.i).receivedResponseAtMillis(this.j).build();
        }

        public void f(DiskLruCache.Editor editor) {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f3163a).writeByte(10);
            buffer.writeUtf8(this.f3165c).writeByte(10);
            buffer.writeDecimalLong((long) this.f3164b.size()).writeByte(10);
            int size = this.f3164b.size();
            for (int i2 = 0; i2 < size; i2++) {
                buffer.writeUtf8(this.f3164b.name(i2)).writeUtf8(": ").writeUtf8(this.f3164b.value(i2)).writeByte(10);
            }
            buffer.writeUtf8(new StatusLine(this.f3166d, this.f3167e, this.f3168f).toString()).writeByte(10);
            buffer.writeDecimalLong((long) (this.g.size() + 2)).writeByte(10);
            int size2 = this.g.size();
            for (int i3 = 0; i3 < size2; i3++) {
                buffer.writeUtf8(this.g.name(i3)).writeUtf8(": ").writeUtf8(this.g.value(i3)).writeByte(10);
            }
            buffer.writeUtf8(k).writeUtf8(": ").writeDecimalLong(this.i).writeByte(10);
            buffer.writeUtf8(l).writeUtf8(": ").writeDecimalLong(this.j).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.h.cipherSuite().javaName()).writeByte(10);
                e(buffer, this.h.peerCertificates());
                e(buffer, this.h.localCertificates());
                buffer.writeUtf8(this.h.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new a();
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    private void abortQuietly(@Nullable DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    static int readInt(BufferedSource bufferedSource) {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public void close() {
        this.cache.close();
    }

    public void delete() {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() {
        this.cache.evictAll();
    }

    public void flush() {
        this.cache.flush();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                e eVar = new e(snapshot.getSource(0));
                Response d2 = eVar.d(snapshot);
                if (eVar.b(request, d2)) {
                    return d2;
                }
                Util.closeQuietly((Closeable) d2.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            e eVar = new e(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    eVar.f(editor);
                    return new c(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void remove(Request request) {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() {
        return this.cache.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    /* access modifiers changed from: package-private */
    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        e eVar = new e(response2);
        try {
            editor = ((d) response.body()).j.edit();
            if (editor != null) {
                try {
                    eVar.f(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public Iterator<String> urls() {
        return new b();
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }
}
