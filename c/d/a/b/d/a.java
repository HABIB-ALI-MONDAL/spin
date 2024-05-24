package c.d.a.b.d;

import android.os.IBinder;
import android.os.IInterface;
import c.d.a.b.e.d.b;

public interface a extends IInterface {

    /* renamed from: c.d.a.b.d.a$a  reason: collision with other inner class name */
    public static abstract class C0064a extends b implements a {
        public C0064a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new c(iBinder);
        }
    }
}
