package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

@TargetApi(14)
final class d7 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ e7 j;

    /* synthetic */ d7(e7 e7Var, c7 c7Var) {
        this.j = e7Var;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.j.f2527a.f().v().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.j.f2527a.N();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        boolean z = true;
                        String str = true != ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "auto" : "gs";
                        String queryParameter = data.getQueryParameter("referrer");
                        if (bundle != null) {
                            z = false;
                        }
                        this.j.f2527a.c().z(new b7(this, z, data, str, queryParameter));
                    }
                }
            }
        } catch (RuntimeException e2) {
            this.j.f2527a.f().r().b("Throwable caught in onActivityCreated", e2);
        } catch (Throwable th) {
            this.j.f2527a.K().y(activity, bundle);
            throw th;
        }
        this.j.f2527a.K().y(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.j.f2527a.K().z(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.j.f2527a.K().A(activity);
        l9 M = this.j.f2527a.M();
        M.f2527a.c().z(new d9(M, M.f2527a.a().b()));
    }

    public final void onActivityResumed(Activity activity) {
        l9 M = this.j.f2527a.M();
        M.f2527a.c().z(new c9(M, M.f2527a.a().b()));
        this.j.f2527a.K().B(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.j.f2527a.K().C(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
