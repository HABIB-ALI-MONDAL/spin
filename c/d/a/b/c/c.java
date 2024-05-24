package c.d.a.b.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

interface c extends IInterface {

    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final IBinder f1520a;

        a(IBinder iBinder) {
            this.f1520a = iBinder;
        }

        public void G(Message message) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.f1520a.transact(1, obtain, (Parcel) null, 1);
            } finally {
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f1520a;
        }
    }

    void G(Message message);
}
