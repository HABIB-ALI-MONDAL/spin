package c.d.a.b.e.a;

import android.os.IBinder;
import android.os.Parcel;

public final class d extends a implements f {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final boolean L(boolean z) {
        Parcel h = h();
        c.a(h, true);
        Parcel i = i(2, h);
        boolean b2 = c.b(i);
        i.recycle();
        return b2;
    }

    public final String c() {
        Parcel i = i(1, h());
        String readString = i.readString();
        i.recycle();
        return readString;
    }
}
