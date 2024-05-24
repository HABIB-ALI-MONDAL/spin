package c.b.a.n.q.g;

import android.graphics.Bitmap;
import c.b.a.m.a;
import c.b.a.n.o.z.e;

public final class b implements a.C0039a {

    /* renamed from: a  reason: collision with root package name */
    private final e f1186a;

    /* renamed from: b  reason: collision with root package name */
    private final c.b.a.n.o.z.b f1187b;

    public b(e eVar, c.b.a.n.o.z.b bVar) {
        this.f1186a = eVar;
        this.f1187b = bVar;
    }

    public int[] a(int i) {
        c.b.a.n.o.z.b bVar = this.f1187b;
        return bVar == null ? new int[i] : (int[]) bVar.e(i, int[].class);
    }

    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return this.f1186a.e(i, i2, config);
    }

    public void c(byte[] bArr) {
        c.b.a.n.o.z.b bVar = this.f1187b;
        if (bVar != null) {
            bVar.d(bArr);
        }
    }

    public void d(Bitmap bitmap) {
        this.f1186a.d(bitmap);
    }

    public byte[] e(int i) {
        c.b.a.n.o.z.b bVar = this.f1187b;
        return bVar == null ? new byte[i] : (byte[]) bVar.e(i, byte[].class);
    }

    public void f(int[] iArr) {
        c.b.a.n.o.z.b bVar = this.f1187b;
        if (bVar != null) {
            bVar.d(iArr);
        }
    }
}
