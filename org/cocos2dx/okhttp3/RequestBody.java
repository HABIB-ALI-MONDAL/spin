package org.cocos2dx.okhttp3;

import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Source;

public abstract class RequestBody {

    class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f3174a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteString f3175b;

        a(MediaType mediaType, ByteString byteString) {
            this.f3174a = mediaType;
            this.f3175b = byteString;
        }

        public long contentLength() {
            return (long) this.f3175b.size();
        }

        @Nullable
        public MediaType contentType() {
            return this.f3174a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f3175b);
        }
    }

    class b extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f3176a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3177b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f3178c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3179d;

        b(MediaType mediaType, int i, byte[] bArr, int i2) {
            this.f3176a = mediaType;
            this.f3177b = i;
            this.f3178c = bArr;
            this.f3179d = i2;
        }

        public long contentLength() {
            return (long) this.f3177b;
        }

        @Nullable
        public MediaType contentType() {
            return this.f3176a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            bufferedSink.write(this.f3178c, this.f3179d, this.f3177b);
        }
    }

    class c extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f3180a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f3181b;

        c(MediaType mediaType, File file) {
            this.f3180a = mediaType;
            this.f3181b = file;
        }

        public long contentLength() {
            return this.f3181b.length();
        }

        @Nullable
        public MediaType contentType() {
            return this.f3180a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            Source source = null;
            try {
                source = Okio.source(this.f3181b);
                bufferedSink.writeAll(source);
            } finally {
                Util.closeQuietly((Closeable) source);
            }
        }
    }

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        Objects.requireNonNull(file, "file == null");
        return new c(mediaType, file);
    }

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable MediaType mediaType, ByteString byteString) {
        return new a(mediaType, byteString);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new b(mediaType, i2, bArr, i);
    }

    public long contentLength() {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink);
}
