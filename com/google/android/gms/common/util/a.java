package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.n.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a {
    @Deprecated
    public static byte[] a(Context context, String str) {
        MessageDigest b2;
        PackageInfo e2 = c.a(context).e(str, 64);
        Signature[] signatureArr = e2.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b2 = b("SHA1")) == null) {
            return null;
        }
        return b2.digest(e2.signatures[0].toByteArray());
    }

    public static MessageDigest b(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
