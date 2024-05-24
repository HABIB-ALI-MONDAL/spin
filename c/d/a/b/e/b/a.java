package c.d.a.b.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1557a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1558b;

    protected a(IBinder iBinder, String str) {
        this.f1557a = iBinder;
        this.f1558b = str;
    }

    public final IBinder asBinder() {
        return this.f1557a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1558b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void i(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1557a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i, Parcel parcel) {
        try {
            this.f1557a.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
