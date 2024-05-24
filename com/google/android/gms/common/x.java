package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import c.d.a.b.d.a;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.q1;
import com.google.android.gms.common.internal.r1;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class x extends q1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f2276a;

    protected x(byte[] bArr) {
        n.a(bArr.length == 25);
        this.f2276a = Arrays.hashCode(bArr);
    }

    protected static byte[] k(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] b0();

    public final int c() {
        return this.f2276a;
    }

    public final a d() {
        return b.b0(b0());
    }

    public final boolean equals(Object obj) {
        a d2;
        if (obj != null && (obj instanceof r1)) {
            try {
                r1 r1Var = (r1) obj;
                if (r1Var.c() != this.f2276a || (d2 = r1Var.d()) == null) {
                    return false;
                }
                return Arrays.equals(b0(), (byte[]) b.k(d2));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2276a;
    }
}
