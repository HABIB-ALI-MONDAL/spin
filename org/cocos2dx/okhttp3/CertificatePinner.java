package org.cocos2dx.okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.tls.CertificateChainCleaner;
import org.cocos2dx.okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<a> pins;

    public static final class Builder {
        private final List<a> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            Objects.requireNonNull(str, "pattern == null");
            for (String aVar : strArr) {
                this.pins.add(new a(str, aVar));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), (CertificateChainCleaner) null);
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f3169a;

        /* renamed from: b  reason: collision with root package name */
        final String f3170b;

        /* renamed from: c  reason: collision with root package name */
        final String f3171c;

        /* renamed from: d  reason: collision with root package name */
        final ByteString f3172d;

        a(String str, String str2) {
            StringBuilder sb;
            int i;
            this.f3169a = str;
            if (str.startsWith("*.")) {
                sb = new StringBuilder();
                sb.append("http://");
                str = str.substring(2);
            } else {
                sb = new StringBuilder();
                sb.append("http://");
            }
            sb.append(str);
            this.f3170b = HttpUrl.get(sb.toString()).host();
            if (str2.startsWith("sha1/")) {
                this.f3171c = "sha1/";
                i = 5;
            } else if (str2.startsWith("sha256/")) {
                this.f3171c = "sha256/";
                i = 7;
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            this.f3172d = ByteString.decodeBase64(str2.substring(i));
            if (this.f3172d == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            if (!this.f3169a.startsWith("*.")) {
                return str.equals(this.f3170b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f3170b.length()) {
                String str2 = this.f3170b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f3169a.equals(aVar.f3169a) && this.f3171c.equals(aVar.f3171c) && this.f3172d.equals(aVar.f3172d);
            }
        }

        public int hashCode() {
            return ((((527 + this.f3169a.hashCode()) * 31) + this.f3171c.hashCode()) * 31) + this.f3172d.hashCode();
        }

        public String toString() {
            return this.f3171c + this.f3172d.base64();
        }
    }

    CertificatePinner(Set<a> set, @Nullable CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + sha256((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString sha1(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString sha256(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void check(String str, List<Certificate> list) {
        List<a> findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = findMatchingPins.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    a aVar = findMatchingPins.get(i2);
                    if (aVar.f3171c.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = sha256(x509Certificate);
                        }
                        if (aVar.f3172d.equals(byteString)) {
                            return;
                        }
                    } else if (aVar.f3171c.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = sha1(x509Certificate);
                        }
                        if (aVar.f3172d.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + aVar.f3171c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = findMatchingPins.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(findMatchingPins.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            return Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins);
        }
    }

    /* access modifiers changed from: package-private */
    public List<a> findMatchingPins(String str) {
        List<a> emptyList = Collections.emptyList();
        for (a next : this.pins) {
            if (next.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        return ((certificateChainCleaner2 != null ? certificateChainCleaner2.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    /* access modifiers changed from: package-private */
    public CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner certificateChainCleaner2) {
        return Util.equal(this.certificateChainCleaner, certificateChainCleaner2) ? this : new CertificatePinner(this.pins, certificateChainCleaner2);
    }
}
