package b.g.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.s;

final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();
    final String j;
    final int k;
    final boolean l;
    final int m;
    final int n;
    final String o;
    final boolean p;
    final boolean q;
    final Bundle r;
    final boolean s;
    Bundle t;
    d u;

    static class a implements Parcelable.Creator<m> {
        a() {
        }

        /* renamed from: a */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: b */
        public m[] newArray(int i) {
            return new m[i];
        }
    }

    m(Parcel parcel) {
        this.j = parcel.readString();
        this.k = parcel.readInt();
        boolean z = true;
        this.l = parcel.readInt() != 0;
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readString();
        this.p = parcel.readInt() != 0;
        this.q = parcel.readInt() != 0;
        this.r = parcel.readBundle();
        this.s = parcel.readInt() == 0 ? false : z;
        this.t = parcel.readBundle();
    }

    m(d dVar) {
        this.j = dVar.getClass().getName();
        this.k = dVar.n;
        this.l = dVar.v;
        this.m = dVar.G;
        this.n = dVar.H;
        this.o = dVar.I;
        this.p = dVar.L;
        this.q = dVar.K;
        this.r = dVar.p;
        this.s = dVar.J;
    }

    public d a(h hVar, f fVar, d dVar, k kVar, s sVar) {
        if (this.u == null) {
            Context e2 = hVar.e();
            Bundle bundle = this.r;
            if (bundle != null) {
                bundle.setClassLoader(e2.getClassLoader());
            }
            this.u = fVar != null ? fVar.a(e2, this.j, this.r) : d.J(e2, this.j, this.r);
            Bundle bundle2 = this.t;
            if (bundle2 != null) {
                bundle2.setClassLoader(e2.getClassLoader());
                this.u.k = this.t;
            }
            this.u.c1(this.k, dVar);
            d dVar2 = this.u;
            dVar2.v = this.l;
            dVar2.x = true;
            dVar2.G = this.m;
            dVar2.H = this.n;
            dVar2.I = this.o;
            dVar2.L = this.p;
            dVar2.K = this.q;
            dVar2.J = this.s;
            dVar2.A = hVar.f702d;
            if (j.N) {
                Log.v("FragmentManager", "Instantiated fragment " + this.u);
            }
        }
        d dVar3 = this.u;
        dVar3.D = kVar;
        dVar3.E = sVar;
        return dVar3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeString(this.o);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeBundle(this.r);
        parcel.writeInt(this.s ? 1 : 0);
        parcel.writeBundle(this.t);
    }
}
