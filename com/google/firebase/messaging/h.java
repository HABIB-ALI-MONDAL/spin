package com.google.firebase.messaging;

import c.d.a.b.h.i;
import com.google.firebase.messaging.a1;
import com.google.firebase.messaging.w0;

public final /* synthetic */ class h implements w0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f2943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2944b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a1.a f2945c;

    public /* synthetic */ h(FirebaseMessaging firebaseMessaging, String str, a1.a aVar) {
        this.f2943a = firebaseMessaging;
        this.f2944b = str;
        this.f2945c = aVar;
    }

    public final i start() {
        return this.f2943a.p(this.f2944b, this.f2945c);
    }
}
