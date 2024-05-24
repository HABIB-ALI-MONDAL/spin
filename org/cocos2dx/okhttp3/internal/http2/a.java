package org.cocos2dx.okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Source;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final Header[] f3192a;

    /* renamed from: b  reason: collision with root package name */
    static final Map<ByteString, Integer> f3193b = b();

    /* renamed from: org.cocos2dx.okhttp3.internal.http2.a$a  reason: collision with other inner class name */
    static final class C0088a {

        /* renamed from: a  reason: collision with root package name */
        private final List<Header> f3194a;

        /* renamed from: b  reason: collision with root package name */
        private final BufferedSource f3195b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3196c;

        /* renamed from: d  reason: collision with root package name */
        private int f3197d;

        /* renamed from: e  reason: collision with root package name */
        Header[] f3198e;

        /* renamed from: f  reason: collision with root package name */
        int f3199f;
        int g;
        int h;

        C0088a(int i, int i2, Source source) {
            this.f3194a = new ArrayList();
            Header[] headerArr = new Header[8];
            this.f3198e = headerArr;
            this.f3199f = headerArr.length - 1;
            this.g = 0;
            this.h = 0;
            this.f3196c = i;
            this.f3197d = i2;
            this.f3195b = Okio.buffer(source);
        }

        C0088a(int i, Source source) {
            this(i, i, source);
        }

        private void a() {
            int i = this.f3197d;
            int i2 = this.h;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                b();
            } else {
                d(i2 - i);
            }
        }

        private void b() {
            Arrays.fill(this.f3198e, (Object) null);
            this.f3199f = this.f3198e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private int c(int i) {
            return this.f3199f + 1 + i;
        }

        private int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f3198e.length;
                while (true) {
                    length--;
                    i2 = this.f3199f;
                    if (length < i2 || i <= 0) {
                        Header[] headerArr = this.f3198e;
                        System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.g);
                        this.f3199f += i3;
                    } else {
                        Header[] headerArr2 = this.f3198e;
                        i -= headerArr2[length].hpackSize;
                        this.h -= headerArr2[length].hpackSize;
                        this.g--;
                        i3++;
                    }
                }
                Header[] headerArr3 = this.f3198e;
                System.arraycopy(headerArr3, i2 + 1, headerArr3, i2 + 1 + i3, this.g);
                this.f3199f += i3;
            }
            return i3;
        }

        private ByteString f(int i) {
            Header header;
            if (h(i)) {
                header = a.f3192a[i];
            } else {
                int c2 = c(i - a.f3192a.length);
                if (c2 >= 0) {
                    Header[] headerArr = this.f3198e;
                    if (c2 < headerArr.length) {
                        header = headerArr[c2];
                    }
                }
                throw new IOException("Header index too large " + (i + 1));
            }
            return header.name;
        }

        private void g(int i, Header header) {
            this.f3194a.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.f3198e[c(i)].hpackSize;
            }
            int i3 = this.f3197d;
            if (i2 > i3) {
                b();
                return;
            }
            int d2 = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                Header[] headerArr = this.f3198e;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f3199f = this.f3198e.length - 1;
                    this.f3198e = headerArr2;
                }
                int i5 = this.f3199f;
                this.f3199f = i5 - 1;
                this.f3198e[i5] = header;
                this.g++;
            } else {
                this.f3198e[i + c(i) + d2] = header;
            }
            this.h += i2;
        }

        private boolean h(int i) {
            return i >= 0 && i <= a.f3192a.length - 1;
        }

        private int i() {
            return this.f3195b.readByte() & 255;
        }

        private void l(int i) {
            if (h(i)) {
                this.f3194a.add(a.f3192a[i]);
                return;
            }
            int c2 = c(i - a.f3192a.length);
            if (c2 >= 0) {
                Header[] headerArr = this.f3198e;
                if (c2 < headerArr.length) {
                    this.f3194a.add(headerArr[c2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void n(int i) {
            g(-1, new Header(f(i), j()));
        }

        private void o() {
            ByteString j = j();
            a.a(j);
            g(-1, new Header(j, j()));
        }

        private void p(int i) {
            this.f3194a.add(new Header(f(i), j()));
        }

        private void q() {
            ByteString j = j();
            a.a(j);
            this.f3194a.add(new Header(j, j()));
        }

        public List<Header> e() {
            ArrayList arrayList = new ArrayList(this.f3194a);
            this.f3194a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public ByteString j() {
            int i = i();
            boolean z = (i & 128) == 128;
            int m = m(i, 127);
            return z ? ByteString.of(d.f().c(this.f3195b.readByteArray((long) m))) : this.f3195b.readByteString((long) m);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f3195b.exhausted()) {
                byte readByte = this.f3195b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m = m(readByte, 31);
                    this.f3197d = m;
                    if (m < 0 || m > this.f3196c) {
                        throw new IOException("Invalid dynamic table size update " + this.f3197d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    q();
                } else {
                    p(m(readByte, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Buffer f3200a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3201b;

        /* renamed from: c  reason: collision with root package name */
        private int f3202c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3203d;

        /* renamed from: e  reason: collision with root package name */
        int f3204e;

        /* renamed from: f  reason: collision with root package name */
        Header[] f3205f;
        int g;
        int h;
        int i;

        b(int i2, boolean z, Buffer buffer) {
            this.f3202c = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.f3205f = headerArr;
            this.g = headerArr.length - 1;
            this.h = 0;
            this.i = 0;
            this.f3204e = i2;
            this.f3201b = z;
            this.f3200a = buffer;
        }

        b(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            int i2 = this.f3204e;
            int i3 = this.i;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                c(i3 - i2);
            }
        }

        private void b() {
            Arrays.fill(this.f3205f, (Object) null);
            this.g = this.f3205f.length - 1;
            this.h = 0;
            this.i = 0;
        }

        private int c(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f3205f.length;
                while (true) {
                    length--;
                    i3 = this.g;
                    if (length < i3 || i2 <= 0) {
                        Header[] headerArr = this.f3205f;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i4, this.h);
                        Header[] headerArr2 = this.f3205f;
                        int i5 = this.g;
                        Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i4, (Object) null);
                        this.g += i4;
                    } else {
                        Header[] headerArr3 = this.f3205f;
                        i2 -= headerArr3[length].hpackSize;
                        this.i -= headerArr3[length].hpackSize;
                        this.h--;
                        i4++;
                    }
                }
                Header[] headerArr4 = this.f3205f;
                System.arraycopy(headerArr4, i3 + 1, headerArr4, i3 + 1 + i4, this.h);
                Header[] headerArr22 = this.f3205f;
                int i52 = this.g;
                Arrays.fill(headerArr22, i52 + 1, i52 + 1 + i4, (Object) null);
                this.g += i4;
            }
            return i4;
        }

        private void d(Header header) {
            int i2 = header.hpackSize;
            int i3 = this.f3204e;
            if (i2 > i3) {
                b();
                return;
            }
            c((this.i + i2) - i3);
            int i4 = this.h + 1;
            Header[] headerArr = this.f3205f;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.g = this.f3205f.length - 1;
                this.f3205f = headerArr2;
            }
            int i5 = this.g;
            this.g = i5 - 1;
            this.f3205f[i5] = header;
            this.h++;
            this.i += i2;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f3204e;
            if (i3 != min) {
                if (min < i3) {
                    this.f3202c = Math.min(this.f3202c, min);
                }
                this.f3203d = true;
                this.f3204e = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(ByteString byteString) {
            int i2;
            int i3;
            if (!this.f3201b || d.f().e(byteString) >= byteString.size()) {
                i3 = byteString.size();
                i2 = 0;
            } else {
                Buffer buffer = new Buffer();
                d.f().d(byteString, buffer);
                byteString = buffer.readByteString();
                i3 = byteString.size();
                i2 = 128;
            }
            h(i3, 127, i2);
            this.f3200a.write(byteString);
        }

        /* access modifiers changed from: package-private */
        public void g(List<Header> list) {
            int i2;
            int i3;
            if (this.f3203d) {
                int i4 = this.f3202c;
                if (i4 < this.f3204e) {
                    h(i4, 31, 32);
                }
                this.f3203d = false;
                this.f3202c = Integer.MAX_VALUE;
                h(this.f3204e, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Header header = list.get(i5);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = a.f3193b.get(asciiLowercase);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        Header[] headerArr = a.f3192a;
                        if (Util.equal(headerArr[i3 - 1].value, byteString)) {
                            i2 = i3;
                        } else if (Util.equal(headerArr[i3].value, byteString)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.g + 1;
                    int length = this.f3205f.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Util.equal(this.f3205f[i6].name, asciiLowercase)) {
                            if (Util.equal(this.f3205f[i6].value, byteString)) {
                                i3 = a.f3192a.length + (i6 - this.g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.g) + a.f3192a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    h(i3, 127, 128);
                } else {
                    if (i2 == -1) {
                        this.f3200a.writeByte(64);
                        f(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                        h(i2, 63, 64);
                    } else {
                        h(i2, 15, 0);
                        f(byteString);
                    }
                    f(byteString);
                    d(header);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2, int i3, int i4) {
            int i5;
            Buffer buffer;
            if (i2 < i3) {
                buffer = this.f3200a;
                i5 = i2 | i4;
            } else {
                this.f3200a.writeByte(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f3200a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                buffer = this.f3200a;
            }
            buffer.writeByte(i5);
        }
    }

    static {
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        f3192a = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    static ByteString a(ByteString byteString) {
        int size = byteString.size();
        int i = 0;
        while (i < size) {
            byte b2 = byteString.getByte(i);
            if (b2 < 65 || b2 > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f3192a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = f3192a;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }
}
