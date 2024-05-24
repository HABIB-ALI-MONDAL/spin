package c.d.a.b.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.b.e.b.a;
import c.d.a.b.e.b.c;

public final class g extends a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void b0(j jVar, f fVar) {
        Parcel h = h();
        c.c(h, jVar);
        c.d(h, fVar);
        i(12, h);
    }
}
