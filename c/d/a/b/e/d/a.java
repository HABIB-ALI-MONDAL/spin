package c.d.a.b.e.d;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1565a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1566b;

    protected a(IBinder iBinder, String str) {
        this.f1565a = iBinder;
        this.f1566b = str;
    }

    public final IBinder asBinder() {
        return this.f1565a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1565a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel i() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1566b);
        return obtain;
    }
}
