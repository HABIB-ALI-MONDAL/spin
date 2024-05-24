package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.j;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new p();
    public static final b n = new b(0);
    final int j;
    private final int k;
    private final PendingIntent l;
    private final String m;

    public b(int i) {
        this(i, (PendingIntent) null, (String) null);
    }

    b(int i, int i2, PendingIntent pendingIntent, String str) {
        this.j = i;
        this.k = i2;
        this.l = pendingIntent;
        this.m = str;
    }

    public b(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public b(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String p(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case j.h3:
                        return "API_DISABLED";
                    case j.i3:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + ")";
                }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.k == bVar.k && m.a(this.l, bVar.l) && m.a(this.m, bVar.m);
    }

    public int g() {
        return this.k;
    }

    public int hashCode() {
        return m.b(Integer.valueOf(this.k), this.l, this.m);
    }

    public String i() {
        return this.m;
    }

    public PendingIntent j() {
        return this.l;
    }

    public boolean k() {
        return (this.k == 0 || this.l == null) ? false : true;
    }

    public boolean l() {
        return this.k == 0;
    }

    public String toString() {
        m.a c2 = m.c(this);
        c2.a("statusCode", p(this.k));
        c2.a("resolution", this.l);
        c2.a("message", this.m);
        return c2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.i(parcel, 2, g());
        c.m(parcel, 3, j(), i, false);
        c.n(parcel, 4, i(), false);
        c.b(parcel, a2);
    }
}
