package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class j1 extends o0 implements k1 {
    j1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int d() {
        Parcel i = i(2, h());
        int readInt = i.readInt();
        i.recycle();
        return readInt;
    }

    public final void p(String str, String str2, Bundle bundle, long j) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.e(h, bundle);
        h.writeLong(j);
        k(1, h);
    }
}
