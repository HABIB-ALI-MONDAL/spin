package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import b.c.a;
import c.d.a.b.d.b;
import c.d.a.b.e.e.e1;
import c.d.a.b.e.e.i1;
import c.d.a.b.e.e.k1;
import c.d.a.b.e.e.m1;
import c.d.a.b.e.e.n1;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.DynamiteApi;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService extends e1 {

    /* renamed from: a  reason: collision with root package name */
    x4 f2300a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map f2301b = new a();

    @EnsuresNonNull({"scion"})
    private final void i() {
        if (this.f2300a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void k(i1 i1Var, String str) {
        i();
        this.f2300a.N().J(i1Var, str);
    }

    public void beginAdUnitExposure(String str, long j) {
        i();
        this.f2300a.y().l(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        i();
        this.f2300a.I().o(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) {
        i();
        this.f2300a.I().I((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) {
        i();
        this.f2300a.y().m(str, j);
    }

    public void generateEventId(i1 i1Var) {
        i();
        long r0 = this.f2300a.N().r0();
        i();
        this.f2300a.N().I(i1Var, r0);
    }

    public void getAppInstanceId(i1 i1Var) {
        i();
        this.f2300a.c().z(new h7(this, i1Var));
    }

    public void getCachedAppInstanceId(i1 i1Var) {
        i();
        k(i1Var, this.f2300a.I().V());
    }

    public void getConditionalUserProperties(String str, String str2, i1 i1Var) {
        i();
        this.f2300a.c().z(new ma(this, i1Var, str, str2));
    }

    public void getCurrentScreenClass(i1 i1Var) {
        i();
        k(i1Var, this.f2300a.I().W());
    }

    public void getCurrentScreenName(i1 i1Var) {
        i();
        k(i1Var, this.f2300a.I().X());
    }

    public void getGmpAppId(i1 i1Var) {
        String str;
        i();
        e7 I = this.f2300a.I();
        if (I.f2527a.O() != null) {
            str = I.f2527a.O();
        } else {
            try {
                str = l7.b(I.f2527a.d(), "google_app_id", I.f2527a.R());
            } catch (IllegalStateException e2) {
                I.f2527a.f().r().b("getGoogleAppId failed with exception", e2);
                str = null;
            }
        }
        k(i1Var, str);
    }

    public void getMaxUserProperties(String str, i1 i1Var) {
        i();
        this.f2300a.I().Q(str);
        i();
        this.f2300a.N().H(i1Var, 25);
    }

    public void getSessionId(i1 i1Var) {
        i();
        e7 I = this.f2300a.I();
        I.f2527a.c().z(new r6(I, i1Var));
    }

    public void getTestFlag(i1 i1Var, int i) {
        i();
        if (i == 0) {
            this.f2300a.N().J(i1Var, this.f2300a.I().Y());
        } else if (i == 1) {
            this.f2300a.N().I(i1Var, this.f2300a.I().U().longValue());
        } else if (i == 2) {
            la N = this.f2300a.N();
            double doubleValue = this.f2300a.I().S().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                i1Var.x(bundle);
            } catch (RemoteException e2) {
                N.f2527a.f().w().b("Error returning double value to wrapper", e2);
            }
        } else if (i == 3) {
            this.f2300a.N().H(i1Var, this.f2300a.I().T().intValue());
        } else if (i == 4) {
            this.f2300a.N().D(i1Var, this.f2300a.I().R().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, i1 i1Var) {
        i();
        this.f2300a.c().z(new i9(this, i1Var, str, str2, z));
    }

    public void initForTests(Map map) {
        i();
    }

    public void initialize(c.d.a.b.d.a aVar, n1 n1Var, long j) {
        x4 x4Var = this.f2300a;
        if (x4Var == null) {
            Context context = (Context) b.k(aVar);
            n.i(context);
            this.f2300a = x4.H(context, n1Var, Long.valueOf(j));
            return;
        }
        x4Var.f().w().a("Attempting to initialize multiple times");
    }

    public void isDataCollectionEnabled(i1 i1Var) {
        i();
        this.f2300a.c().z(new na(this, i1Var));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        i();
        this.f2300a.I().s(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, i1 i1Var, long j) {
        Bundle bundle2;
        i();
        n.e(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.f2300a.c().z(new h8(this, i1Var, new x(str2, new v(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, c.d.a.b.d.a aVar, c.d.a.b.d.a aVar2, c.d.a.b.d.a aVar3) {
        i();
        Object obj = null;
        Object k = aVar == null ? null : b.k(aVar);
        Object k2 = aVar2 == null ? null : b.k(aVar2);
        if (aVar3 != null) {
            obj = b.k(aVar3);
        }
        this.f2300a.f().F(i, true, false, str, k, k2, obj);
    }

    public void onActivityCreated(c.d.a.b.d.a aVar, Bundle bundle, long j) {
        i();
        d7 d7Var = this.f2300a.I().f2369c;
        if (d7Var != null) {
            this.f2300a.I().p();
            d7Var.onActivityCreated((Activity) b.k(aVar), bundle);
        }
    }

    public void onActivityDestroyed(c.d.a.b.d.a aVar, long j) {
        i();
        d7 d7Var = this.f2300a.I().f2369c;
        if (d7Var != null) {
            this.f2300a.I().p();
            d7Var.onActivityDestroyed((Activity) b.k(aVar));
        }
    }

    public void onActivityPaused(c.d.a.b.d.a aVar, long j) {
        i();
        d7 d7Var = this.f2300a.I().f2369c;
        if (d7Var != null) {
            this.f2300a.I().p();
            d7Var.onActivityPaused((Activity) b.k(aVar));
        }
    }

    public void onActivityResumed(c.d.a.b.d.a aVar, long j) {
        i();
        d7 d7Var = this.f2300a.I().f2369c;
        if (d7Var != null) {
            this.f2300a.I().p();
            d7Var.onActivityResumed((Activity) b.k(aVar));
        }
    }

    public void onActivitySaveInstanceState(c.d.a.b.d.a aVar, i1 i1Var, long j) {
        i();
        d7 d7Var = this.f2300a.I().f2369c;
        Bundle bundle = new Bundle();
        if (d7Var != null) {
            this.f2300a.I().p();
            d7Var.onActivitySaveInstanceState((Activity) b.k(aVar), bundle);
        }
        try {
            i1Var.x(bundle);
        } catch (RemoteException e2) {
            this.f2300a.f().w().b("Error returning bundle value to wrapper", e2);
        }
    }

    public void onActivityStarted(c.d.a.b.d.a aVar, long j) {
        i();
        if (this.f2300a.I().f2369c != null) {
            this.f2300a.I().p();
            Activity activity = (Activity) b.k(aVar);
        }
    }

    public void onActivityStopped(c.d.a.b.d.a aVar, long j) {
        i();
        if (this.f2300a.I().f2369c != null) {
            this.f2300a.I().p();
            Activity activity = (Activity) b.k(aVar);
        }
    }

    public void performAction(Bundle bundle, i1 i1Var, long j) {
        i();
        i1Var.x((Bundle) null);
    }

    public void registerOnMeasurementEventListener(k1 k1Var) {
        z5 z5Var;
        i();
        synchronized (this.f2301b) {
            z5Var = (z5) this.f2301b.get(Integer.valueOf(k1Var.d()));
            if (z5Var == null) {
                z5Var = new pa(this, k1Var);
                this.f2301b.put(Integer.valueOf(k1Var.d()), z5Var);
            }
        }
        this.f2300a.I().x(z5Var);
    }

    public void resetAnalyticsData(long j) {
        i();
        this.f2300a.I().y(j);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) {
        i();
        if (bundle == null) {
            this.f2300a.f().r().a("Conditional user property must not be null");
        } else {
            this.f2300a.I().E(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) {
        i();
        e7 I = this.f2300a.I();
        I.f2527a.c().A(new c6(I, bundle, j));
    }

    public void setConsentThirdParty(Bundle bundle, long j) {
        i();
        this.f2300a.I().F(bundle, -20, j);
    }

    public void setCurrentScreen(c.d.a.b.d.a aVar, String str, String str2, long j) {
        i();
        this.f2300a.K().D((Activity) b.k(aVar), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) {
        i();
        e7 I = this.f2300a.I();
        I.i();
        I.f2527a.c().z(new a7(I, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        i();
        e7 I = this.f2300a.I();
        I.f2527a.c().z(new d6(I, bundle == null ? null : new Bundle(bundle)));
    }

    public void setEventInterceptor(k1 k1Var) {
        i();
        oa oaVar = new oa(this, k1Var);
        if (this.f2300a.c().C()) {
            this.f2300a.I().H(oaVar);
        } else {
            this.f2300a.c().z(new ja(this, oaVar));
        }
    }

    public void setInstanceIdProvider(m1 m1Var) {
        i();
    }

    public void setMeasurementEnabled(boolean z, long j) {
        i();
        this.f2300a.I().I(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) {
        i();
    }

    public void setSessionTimeoutDuration(long j) {
        i();
        e7 I = this.f2300a.I();
        I.f2527a.c().z(new i6(I, j));
    }

    public void setUserId(String str, long j) {
        i();
        e7 I = this.f2300a.I();
        if (str == null || !TextUtils.isEmpty(str)) {
            I.f2527a.c().z(new e6(I, str));
            I.L((String) null, "_id", str, true, j);
            return;
        }
        I.f2527a.f().w().a("User ID must be non-empty or null");
    }

    public void setUserProperty(String str, String str2, c.d.a.b.d.a aVar, boolean z, long j) {
        i();
        this.f2300a.I().L(str, str2, b.k(aVar), z, j);
    }

    public void unregisterOnMeasurementEventListener(k1 k1Var) {
        z5 z5Var;
        i();
        synchronized (this.f2301b) {
            z5Var = (z5) this.f2301b.remove(Integer.valueOf(k1Var.d()));
        }
        if (z5Var == null) {
            z5Var = new pa(this, k1Var);
        }
        this.f2300a.I().N(z5Var);
    }
}
