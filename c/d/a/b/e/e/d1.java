package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import c.d.a.b.d.a;

public final class d1 extends o0 implements f1 {
    d1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j) {
        Parcel h = h();
        h.writeString(str);
        h.writeLong(j);
        k(23, h);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.e(h, bundle);
        k(9, h);
    }

    public final void endAdUnitExposure(String str, long j) {
        Parcel h = h();
        h.writeString(str);
        h.writeLong(j);
        k(24, h);
    }

    public final void generateEventId(i1 i1Var) {
        Parcel h = h();
        q0.f(h, i1Var);
        k(22, h);
    }

    public final void getCachedAppInstanceId(i1 i1Var) {
        Parcel h = h();
        q0.f(h, i1Var);
        k(19, h);
    }

    public final void getConditionalUserProperties(String str, String str2, i1 i1Var) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.f(h, i1Var);
        k(10, h);
    }

    public final void getCurrentScreenClass(i1 i1Var) {
        Parcel h = h();
        q0.f(h, i1Var);
        k(17, h);
    }

    public final void getCurrentScreenName(i1 i1Var) {
        Parcel h = h();
        q0.f(h, i1Var);
        k(16, h);
    }

    public final void getGmpAppId(i1 i1Var) {
        Parcel h = h();
        q0.f(h, i1Var);
        k(21, h);
    }

    public final void getMaxUserProperties(String str, i1 i1Var) {
        Parcel h = h();
        h.writeString(str);
        q0.f(h, i1Var);
        k(6, h);
    }

    public final void getUserProperties(String str, String str2, boolean z, i1 i1Var) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.d(h, z);
        q0.f(h, i1Var);
        k(5, h);
    }

    public final void initialize(a aVar, n1 n1Var, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        q0.e(h, n1Var);
        h.writeLong(j);
        k(1, h);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.e(h, bundle);
        q0.d(h, z);
        q0.d(h, z2);
        h.writeLong(j);
        k(2, h);
    }

    public final void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) {
        Parcel h = h();
        h.writeInt(5);
        h.writeString(str);
        q0.f(h, aVar);
        q0.f(h, aVar2);
        q0.f(h, aVar3);
        k(33, h);
    }

    public final void onActivityCreated(a aVar, Bundle bundle, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        q0.e(h, bundle);
        h.writeLong(j);
        k(27, h);
    }

    public final void onActivityDestroyed(a aVar, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeLong(j);
        k(28, h);
    }

    public final void onActivityPaused(a aVar, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeLong(j);
        k(29, h);
    }

    public final void onActivityResumed(a aVar, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeLong(j);
        k(30, h);
    }

    public final void onActivitySaveInstanceState(a aVar, i1 i1Var, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        q0.f(h, i1Var);
        h.writeLong(j);
        k(31, h);
    }

    public final void onActivityStarted(a aVar, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeLong(j);
        k(25, h);
    }

    public final void onActivityStopped(a aVar, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeLong(j);
        k(26, h);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel h = h();
        q0.e(h, bundle);
        h.writeLong(j);
        k(8, h);
    }

    public final void setCurrentScreen(a aVar, String str, String str2, long j) {
        Parcel h = h();
        q0.f(h, aVar);
        h.writeString(str);
        h.writeString(str2);
        h.writeLong(j);
        k(15, h);
    }

    public final void setDataCollectionEnabled(boolean z) {
        Parcel h = h();
        q0.d(h, z);
        k(39, h);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z, long j) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.f(h, aVar);
        q0.d(h, z);
        h.writeLong(j);
        k(4, h);
    }
}
