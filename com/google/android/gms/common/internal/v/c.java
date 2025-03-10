package com.google.android.gms.common.internal.v;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class c {
    public static int a(Parcel parcel) {
        return r(parcel, 20293);
    }

    public static void b(Parcel parcel, int i) {
        s(parcel, i);
    }

    public static void c(Parcel parcel, int i, boolean z) {
        t(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            t(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int r = r(parcel, i);
            parcel.writeBundle(bundle);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void f(Parcel parcel, int i, Double d2, boolean z) {
        if (d2 != null) {
            t(parcel, i, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void g(Parcel parcel, int i, Float f2, boolean z) {
        if (f2 != null) {
            t(parcel, i, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void h(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int r = r(parcel, i);
            parcel.writeStrongBinder(iBinder);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void i(Parcel parcel, int i, int i2) {
        t(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void j(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int r = r(parcel, i);
            parcel.writeIntArray(iArr);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void k(Parcel parcel, int i, long j) {
        t(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void l(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            t(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void m(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int r = r(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void n(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int r = r(parcel, i);
            parcel.writeString(str);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static void o(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int r = r(parcel, i);
            parcel.writeStringList(list);
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void p(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int r = r(parcel, i);
            parcel.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    u(parcel, t, i2);
                }
            }
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void q(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int r = r(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    u(parcel, parcelable, 0);
                }
            }
            s(parcel, r);
        } else if (z) {
            t(parcel, i, 0);
        }
    }

    private static int r(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void s(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void t(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static void u(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
