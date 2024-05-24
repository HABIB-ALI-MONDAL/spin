package org.cocos2dx.okio;

import javax.annotation.Nullable;

final class d {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f3261a;

    /* renamed from: b  reason: collision with root package name */
    int f3262b;

    /* renamed from: c  reason: collision with root package name */
    int f3263c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3264d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3265e;

    /* renamed from: f  reason: collision with root package name */
    d f3266f;
    d g;

    d() {
        this.f3261a = new byte[8192];
        this.f3265e = true;
        this.f3264d = false;
    }

    d(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3261a = bArr;
        this.f3262b = i;
        this.f3263c = i2;
        this.f3264d = z;
        this.f3265e = z2;
    }

    public final void a() {
        d dVar = this.g;
        if (dVar == this) {
            throw new IllegalStateException();
        } else if (dVar.f3265e) {
            int i = this.f3263c - this.f3262b;
            if (i <= (8192 - dVar.f3263c) + (dVar.f3264d ? 0 : dVar.f3262b)) {
                g(dVar, i);
                b();
                e.a(this);
            }
        }
    }

    @Nullable
    public final d b() {
        d dVar = this.f3266f;
        d dVar2 = dVar != this ? dVar : null;
        d dVar3 = this.g;
        dVar3.f3266f = dVar;
        this.f3266f.g = dVar3;
        this.f3266f = null;
        this.g = null;
        return dVar2;
    }

    public final d c(d dVar) {
        dVar.g = this;
        dVar.f3266f = this.f3266f;
        this.f3266f.g = dVar;
        this.f3266f = dVar;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final d d() {
        this.f3264d = true;
        return new d(this.f3261a, this.f3262b, this.f3263c, true, false);
    }

    public final d e(int i) {
        d dVar;
        if (i <= 0 || i > this.f3263c - this.f3262b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            dVar = d();
        } else {
            dVar = e.b();
            System.arraycopy(this.f3261a, this.f3262b, dVar.f3261a, 0, i);
        }
        dVar.f3263c = dVar.f3262b + i;
        this.f3262b += i;
        this.g.c(dVar);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final d f() {
        return new d((byte[]) this.f3261a.clone(), this.f3262b, this.f3263c, false, true);
    }

    public final void g(d dVar, int i) {
        if (dVar.f3265e) {
            int i2 = dVar.f3263c;
            if (i2 + i > 8192) {
                if (!dVar.f3264d) {
                    int i3 = dVar.f3262b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = dVar.f3261a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        dVar.f3263c -= dVar.f3262b;
                        dVar.f3262b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f3261a, this.f3262b, dVar.f3261a, dVar.f3263c, i);
            dVar.f3263c += i;
            this.f3262b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
