package c.d.a.b.c;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.b.c.c;

public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new g();
    Messenger j;
    c k;

    public i(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.j = new Messenger(iBinder);
        } else {
            this.k = new c.a(iBinder);
        }
    }

    public final IBinder a() {
        Messenger messenger = this.j;
        return messenger != null ? messenger.getBinder() : this.k.asBinder();
    }

    public final void b(Message message) {
        Messenger messenger = this.j;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.k.G(message);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((i) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.j;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.k.asBinder());
    }
}
