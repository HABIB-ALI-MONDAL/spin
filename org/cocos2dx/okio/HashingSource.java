package org.cocos2dx.okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            Mac instance = Mac.getInstance(str);
            this.mac = instance;
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public final ByteString hash() {
        MessageDigest messageDigest2 = this.messageDigest;
        return ByteString.of(messageDigest2 != null ? messageDigest2.digest() : this.mac.doFinal());
    }

    public long read(Buffer buffer, long j) {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.size;
            long j3 = j2 - read;
            d dVar = buffer.head;
            while (j2 > j3) {
                dVar = dVar.g;
                j2 -= (long) (dVar.f3263c - dVar.f3262b);
            }
            while (j2 < buffer.size) {
                int i = (int) ((((long) dVar.f3262b) + j3) - j2);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(dVar.f3261a, i, dVar.f3263c - i);
                } else {
                    this.mac.update(dVar.f3261a, i, dVar.f3263c - i);
                }
                j3 = ((long) (dVar.f3263c - dVar.f3262b)) + j2;
                dVar = dVar.f3266f;
                j2 = j3;
            }
        }
        return read;
    }
}
