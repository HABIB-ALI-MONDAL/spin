package a.a.a.a;

import a.a.a.a.a;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final Handler j = null;
    a k;

    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    /* renamed from: a.a.a.a.b$b  reason: collision with other inner class name */
    class C0002b extends a.C0000a {
        C0002b() {
        }

        public void X(int i, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.j;
            if (handler != null) {
                handler.post(new c(i, bundle));
            } else {
                bVar.a(i, bundle);
            }
        }
    }

    class c implements Runnable {
        final int j;
        final Bundle k;

        c(int i, Bundle bundle) {
            this.j = i;
            this.k = bundle;
        }

        public void run() {
            b.this.a(this.j, this.k);
        }
    }

    b(Parcel parcel) {
        this.k = a.C0000a.h(parcel.readStrongBinder());
    }

    /* access modifiers changed from: protected */
    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new C0002b();
            }
            parcel.writeStrongBinder(this.k.asBinder());
        }
    }
}
