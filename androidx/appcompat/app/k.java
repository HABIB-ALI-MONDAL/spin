package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.b;
import java.util.Calendar;

class k {

    /* renamed from: d  reason: collision with root package name */
    private static k f117d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f118a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f119b;

    /* renamed from: c  reason: collision with root package name */
    private final a f120c = new a();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f121a;

        /* renamed from: b  reason: collision with root package name */
        long f122b;

        /* renamed from: c  reason: collision with root package name */
        long f123c;

        /* renamed from: d  reason: collision with root package name */
        long f124d;

        /* renamed from: e  reason: collision with root package name */
        long f125e;

        /* renamed from: f  reason: collision with root package name */
        long f126f;

        a() {
        }
    }

    k(Context context, LocationManager locationManager) {
        this.f118a = context;
        this.f119b = locationManager;
    }

    static k a(Context context) {
        if (f117d == null) {
            Context applicationContext = context.getApplicationContext();
            f117d = new k(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f117d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location c2 = b.b(this.f118a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (b.b(this.f118a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c2 == null) ? location != null ? location : c2 : location.getTime() > c2.getTime() ? location : c2;
    }

    private Location c(String str) {
        try {
            if (this.f119b.isProviderEnabled(str)) {
                return this.f119b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f120c.f126f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        a aVar = this.f120c;
        long currentTimeMillis = System.currentTimeMillis();
        j b2 = j.b();
        j jVar = b2;
        jVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = b2.f114a;
        jVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f116c == 1;
        long j3 = b2.f115b;
        long j4 = j2;
        long j5 = b2.f114a;
        long j6 = j3;
        boolean z2 = z;
        b2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = b2.f115b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f121a = z2;
        aVar.f122b = j4;
        aVar.f123c = j6;
        aVar.f124d = j5;
        aVar.f125e = j7;
        aVar.f126f = j;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f120c;
        if (e()) {
            return aVar.f121a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return aVar.f121a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
