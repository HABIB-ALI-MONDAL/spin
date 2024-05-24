package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import c.d.a.b.c.a;
import c.d.a.b.c.b;
import c.d.a.b.h.l;
import com.google.firebase.messaging.j0;
import com.google.firebase.messaging.o0;
import java.util.concurrent.ExecutionException;

public final class FirebaseInstanceIdReceiver extends b {
    private static Intent g(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public int b(Context context, a aVar) {
        try {
            return ((Integer) l.a(new j0(context).f(aVar.g()))).intValue();
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e2);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public void c(Context context, Bundle bundle) {
        Intent g = g(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (o0.A(g)) {
            o0.s(g);
        }
    }
}
