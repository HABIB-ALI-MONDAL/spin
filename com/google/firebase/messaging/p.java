package com.google.firebase.messaging;

import c.d.a.b.h.j;

public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ FirebaseMessaging j;
    public final /* synthetic */ j k;

    public /* synthetic */ p(FirebaseMessaging firebaseMessaging, j jVar) {
        this.j = firebaseMessaging;
        this.k = jVar;
    }

    public final void run() {
        this.j.t(this.k);
    }
}
