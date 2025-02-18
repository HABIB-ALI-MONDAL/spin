package org.cocos2dx.okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.ByteString;

public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType FORM = MediaType.get("multipart/form-data");
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    private final ByteString boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;

    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            Objects.requireNonNull(part, "part == null");
            this.parts.add(part);
            return this;
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder setType(MediaType mediaType) {
            Objects.requireNonNull(mediaType, "type == null");
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + mediaType);
        }
    }

    public static final class Part {
        final RequestBody body;
        @Nullable
        final Headers headers;

        private Part(@Nullable Headers headers2, RequestBody requestBody) {
            this.headers = headers2;
            this.body = requestBody;
        }

        public static Part create(@Nullable Headers headers2, RequestBody requestBody) {
            Objects.requireNonNull(requestBody, "body == null");
            if (headers2 != null && headers2.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (headers2 == null || headers2.get("Content-Length") == null) {
                return new Part(headers2, requestBody);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        public static Part create(RequestBody requestBody) {
            return create((Headers) null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, (String) null, RequestBody.create((MediaType) null, str2));
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                MultipartBody.appendQuotedString(sb, str2);
            }
            return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), requestBody);
        }

        public RequestBody body() {
            return this.body;
        }

        @Nullable
        public Headers headers() {
            return this.headers;
        }
    }

    MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.parts = Util.immutableList(list);
    }

    static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                str2 = "%0A";
            } else if (charAt == 13) {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: org.cocos2dx.okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: org.cocos2dx.okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.cocos2dx.okio.Buffer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: org.cocos2dx.okio.BufferedSink} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: org.cocos2dx.okio.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long writeOrCountBytes(@javax.annotation.Nullable org.cocos2dx.okio.BufferedSink r13, boolean r14) {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            org.cocos2dx.okio.Buffer r13 = new org.cocos2dx.okio.Buffer
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<org.cocos2dx.okhttp3.MultipartBody$Part> r1 = r12.parts
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r1) goto L_0x00a4
            java.util.List<org.cocos2dx.okhttp3.MultipartBody$Part> r6 = r12.parts
            java.lang.Object r6 = r6.get(r5)
            org.cocos2dx.okhttp3.MultipartBody$Part r6 = (org.cocos2dx.okhttp3.MultipartBody.Part) r6
            org.cocos2dx.okhttp3.Headers r7 = r6.headers
            org.cocos2dx.okhttp3.RequestBody r6 = r6.body
            byte[] r8 = DASHDASH
            r13.write((byte[]) r8)
            org.cocos2dx.okio.ByteString r8 = r12.boundary
            r13.write((org.cocos2dx.okio.ByteString) r8)
            byte[] r8 = CRLF
            r13.write((byte[]) r8)
            if (r7 == 0) goto L_0x0058
            int r8 = r7.size()
            r9 = 0
        L_0x0038:
            if (r9 >= r8) goto L_0x0058
            java.lang.String r10 = r7.name(r9)
            org.cocos2dx.okio.BufferedSink r10 = r13.writeUtf8(r10)
            byte[] r11 = COLONSPACE
            org.cocos2dx.okio.BufferedSink r10 = r10.write((byte[]) r11)
            java.lang.String r11 = r7.value(r9)
            org.cocos2dx.okio.BufferedSink r10 = r10.writeUtf8(r11)
            byte[] r11 = CRLF
            r10.write((byte[]) r11)
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0058:
            org.cocos2dx.okhttp3.MediaType r7 = r6.contentType()
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "Content-Type: "
            org.cocos2dx.okio.BufferedSink r8 = r13.writeUtf8(r8)
            java.lang.String r7 = r7.toString()
            org.cocos2dx.okio.BufferedSink r7 = r8.writeUtf8(r7)
            byte[] r8 = CRLF
            r7.write((byte[]) r8)
        L_0x0071:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008b
            java.lang.String r9 = "Content-Length: "
            org.cocos2dx.okio.BufferedSink r9 = r13.writeUtf8(r9)
            org.cocos2dx.okio.BufferedSink r9 = r9.writeDecimalLong(r7)
            byte[] r10 = CRLF
            r9.write((byte[]) r10)
            goto L_0x0091
        L_0x008b:
            if (r14 == 0) goto L_0x0091
            r0.clear()
            return r9
        L_0x0091:
            byte[] r9 = CRLF
            r13.write((byte[]) r9)
            if (r14 == 0) goto L_0x009a
            long r3 = r3 + r7
            goto L_0x009d
        L_0x009a:
            r6.writeTo(r13)
        L_0x009d:
            r13.write((byte[]) r9)
            int r5 = r5 + 1
            goto L_0x0014
        L_0x00a4:
            byte[] r1 = DASHDASH
            r13.write((byte[]) r1)
            org.cocos2dx.okio.ByteString r2 = r12.boundary
            r13.write((org.cocos2dx.okio.ByteString) r2)
            r13.write((byte[]) r1)
            byte[] r1 = CRLF
            r13.write((byte[]) r1)
            if (r14 == 0) goto L_0x00c0
            long r13 = r0.size()
            long r3 = r3 + r13
            r0.clear()
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.MultipartBody.writeOrCountBytes(org.cocos2dx.okio.BufferedSink, boolean):long");
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    public long contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes((BufferedSink) null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public Part part(int i) {
        return this.parts.get(i);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    public void writeTo(BufferedSink bufferedSink) {
        writeOrCountBytes(bufferedSink, false);
    }
}
