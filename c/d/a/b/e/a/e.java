package c.d.a.b.e.a;

import android.os.IBinder;
import android.os.IInterface;

public abstract class e extends b implements f {
    public static f h(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new d(iBinder);
    }
}
