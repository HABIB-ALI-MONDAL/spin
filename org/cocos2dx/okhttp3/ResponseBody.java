package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;

public abstract class ResponseBody implements Closeable {
    @Nullable
    private Reader reader;

    class a extends ResponseBody {
        final /* synthetic */ MediaType j;
        final /* synthetic */ long k;
        final /* synthetic */ BufferedSource l;

        a(MediaType mediaType, long j2, BufferedSource bufferedSource) {
            this.j = mediaType;
            this.k = j2;
            this.l = bufferedSource;
        }

        public long contentLength() {
            return this.k;
        }

        @Nullable
        public MediaType contentType() {
            return this.j;
        }

        public BufferedSource source() {
            return this.l;
        }
    }

    static final class b extends Reader {
        private final BufferedSource j;
        private final Charset k;
        private boolean l;
        @Nullable
        private Reader m;

        b(BufferedSource bufferedSource, Charset charset) {
            this.j = bufferedSource;
            this.k = charset;
        }

        public void close() {
            this.l = true;
            Reader reader = this.m;
            if (reader != null) {
                reader.close();
            } else {
                this.j.close();
            }
        }

        public int read(char[] cArr, int i, int i2) {
            if (!this.l) {
                Reader reader = this.m;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.j.inputStream(), Util.bomAwareCharset(this.j, this.k));
                    this.m = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public static ResponseBody create(@Nullable MediaType mediaType, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new a(mediaType, j, bufferedSource);
    }

    public static ResponseBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static ResponseBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return create(mediaType, (long) byteString.size(), new Buffer().write(byteString));
    }

    public static ResponseBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, (long) bArr.length, new Buffer().write(bArr));
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            BufferedSource source = source();
            try {
                byte[] readByteArray = source.readByteArray();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) readByteArray.length)) {
                    return readByteArray;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + readByteArray.length + ") disagree");
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        b bVar = new b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() {
        BufferedSource source = source();
        try {
            return source.readString(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }
}
