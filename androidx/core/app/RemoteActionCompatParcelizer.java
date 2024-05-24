package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f294a = (IconCompat) aVar.v(remoteActionCompat.f294a, 1);
        remoteActionCompat.f295b = aVar.l(remoteActionCompat.f295b, 2);
        remoteActionCompat.f296c = aVar.l(remoteActionCompat.f296c, 3);
        remoteActionCompat.f297d = (PendingIntent) aVar.r(remoteActionCompat.f297d, 4);
        remoteActionCompat.f298e = aVar.h(remoteActionCompat.f298e, 5);
        remoteActionCompat.f299f = aVar.h(remoteActionCompat.f299f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f294a, 1);
        aVar.D(remoteActionCompat.f295b, 2);
        aVar.D(remoteActionCompat.f296c, 3);
        aVar.H(remoteActionCompat.f297d, 4);
        aVar.z(remoteActionCompat.f298e, 5);
        aVar.z(remoteActionCompat.f299f, 6);
    }
}
