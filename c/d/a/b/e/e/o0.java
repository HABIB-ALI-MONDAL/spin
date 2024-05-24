package c.d.a.b.e.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class o0 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1702a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1703b;

    protected o0(IBinder iBinder, String str) {
        this.f1702a = iBinder;
        this.f1703b = str;
    }

    public final IBinder asBinder() {
        return this.f1702a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1703b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1702a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1702a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
