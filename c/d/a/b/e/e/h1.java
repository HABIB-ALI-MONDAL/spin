package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.Parcel;

public abstract class h1 extends p0 implements i1 {
    public h1() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        q0.c(parcel);
        x((Bundle) q0.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
