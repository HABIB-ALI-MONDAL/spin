package c.d.a.b.f.b;

import android.os.Parcel;
import c.d.a.b.e.b.b;
import c.d.a.b.e.b.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class e extends b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean b0(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                com.google.android.gms.common.b bVar = (com.google.android.gms.common.b) c.a(parcel, com.google.android.gms.common.b.CREATOR);
                b bVar2 = (b) c.a(parcel, b.CREATOR);
                break;
            case 4:
            case 6:
                Status status = (Status) c.a(parcel, Status.CREATOR);
                break;
            case 7:
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                c.b(parcel);
                R((l) c.a(parcel, l.CREATOR));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                break;
            default:
                return false;
        }
        c.b(parcel);
        parcel2.writeNoException();
        return true;
    }
}
