package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class r0 extends o0 implements t0 {
    r0(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle D(Bundle bundle) {
        Parcel h = h();
        q0.e(h, bundle);
        Parcel i = i(1, h);
        Bundle bundle2 = (Bundle) q0.a(i, Bundle.CREATOR);
        i.recycle();
        return bundle2;
    }
}
