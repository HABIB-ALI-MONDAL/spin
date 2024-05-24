package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.k;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f2225a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2226b;

    public q(Context context) {
        n.i(context);
        Resources resources = context.getResources();
        this.f2225a = resources;
        this.f2226b = resources.getResourcePackageName(k.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.f2225a.getIdentifier(str, "string", this.f2226b);
        if (identifier == 0) {
            return null;
        }
        return this.f2225a.getString(identifier);
    }
}
