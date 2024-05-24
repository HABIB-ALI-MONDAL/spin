package c.d.a.b.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1554a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1555b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    protected a(IBinder iBinder, String str) {
        this.f1554a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f1554a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1555b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1554a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
