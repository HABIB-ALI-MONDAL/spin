package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import c.d.a.b.h.i;
import com.google.firebase.messaging.i1;

class h1 extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final a f2949a;

    interface a {
        i<Void> a(Intent intent);
    }

    h1(a aVar) {
        this.f2949a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void b(i1.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.f2949a.a(aVar.f2960a).c(u.f3002a, new a0(aVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
