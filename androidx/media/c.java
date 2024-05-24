package androidx.media;

import java.util.Arrays;

class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f436a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f437b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f438c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f439d = -1;

    c() {
    }

    public int a() {
        return this.f437b;
    }

    public int b() {
        int i = this.f438c;
        int c2 = c();
        if (c2 == 6) {
            i |= 4;
        } else if (c2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.f439d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f438c, this.f436a);
    }

    public int d() {
        return this.f436a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f437b == cVar.a() && this.f438c == cVar.b() && this.f436a == cVar.d() && this.f439d == cVar.f439d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f437b), Integer.valueOf(this.f438c), Integer.valueOf(this.f436a), Integer.valueOf(this.f439d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f439d != -1) {
            sb.append(" stream=");
            sb.append(this.f439d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f436a));
        sb.append(" content=");
        sb.append(this.f437b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f438c).toUpperCase());
        return sb.toString();
    }
}
