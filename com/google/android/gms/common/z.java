package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class z extends x {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference f2278c = new WeakReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f2279b = f2278c;

    z(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] b0() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f2279b.get();
            if (bArr == null) {
                bArr = c0();
                this.f2279b = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] c0();
}
