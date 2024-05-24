package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import c.d.a.b.e.e.t2;
import c.d.a.b.h.l;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.measurement.internal.f7;
import com.google.firebase.installations.h;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class FirebaseAnalytics {

    /* renamed from: b  reason: collision with root package name */
    private static volatile FirebaseAnalytics f2662b;

    /* renamed from: a  reason: collision with root package name */
    private final t2 f2663a;

    public FirebaseAnalytics(t2 t2Var) {
        n.i(t2Var);
        this.f2663a = t2Var;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f2662b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f2662b == null) {
                    f2662b = new FirebaseAnalytics(t2.r(context, (String) null, (String) null, (String) null, (Bundle) null));
                }
            }
        }
        return f2662b;
    }

    @Keep
    public static f7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        t2 r = t2.r(context, (String) null, (String) null, (String) null, bundle);
        if (r == null) {
            return null;
        }
        return new b(r);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) l.b(h.m().a(), 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Deprecated
    @Keep
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.f2663a.c(activity, str, str2);
    }
}
