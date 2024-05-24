package com.google.firebase.messaging;

import com.google.firebase.l.c;
import com.google.firebase.l.d;
import com.google.firebase.l.e;

public final class d0 implements com.google.firebase.l.h.a {

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.firebase.l.h.a f2909a = new d0();

    private static final class a implements d<com.google.firebase.messaging.j1.a> {

        /* renamed from: a  reason: collision with root package name */
        static final a f2910a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final com.google.firebase.l.c f2911b;

        /* renamed from: c  reason: collision with root package name */
        private static final com.google.firebase.l.c f2912c;

        /* renamed from: d  reason: collision with root package name */
        private static final com.google.firebase.l.c f2913d;

        /* renamed from: e  reason: collision with root package name */
        private static final com.google.firebase.l.c f2914e;

        /* renamed from: f  reason: collision with root package name */
        private static final com.google.firebase.l.c f2915f;
        private static final com.google.firebase.l.c g;
        private static final com.google.firebase.l.c h;
        private static final com.google.firebase.l.c i;
        private static final com.google.firebase.l.c j;
        private static final com.google.firebase.l.c k;
        private static final com.google.firebase.l.c l;
        private static final com.google.firebase.l.c m;
        private static final com.google.firebase.l.c n;
        private static final com.google.firebase.l.c o;
        private static final com.google.firebase.l.c p;

        static {
            c.b a2 = com.google.firebase.l.c.a("projectNumber");
            com.google.firebase.l.j.c b2 = com.google.firebase.l.j.c.b();
            b2.c(1);
            a2.b(b2.a());
            f2911b = a2.a();
            c.b a3 = com.google.firebase.l.c.a("messageId");
            com.google.firebase.l.j.c b3 = com.google.firebase.l.j.c.b();
            b3.c(2);
            a3.b(b3.a());
            f2912c = a3.a();
            c.b a4 = com.google.firebase.l.c.a("instanceId");
            com.google.firebase.l.j.c b4 = com.google.firebase.l.j.c.b();
            b4.c(3);
            a4.b(b4.a());
            f2913d = a4.a();
            c.b a5 = com.google.firebase.l.c.a("messageType");
            com.google.firebase.l.j.c b5 = com.google.firebase.l.j.c.b();
            b5.c(4);
            a5.b(b5.a());
            f2914e = a5.a();
            c.b a6 = com.google.firebase.l.c.a("sdkPlatform");
            com.google.firebase.l.j.c b6 = com.google.firebase.l.j.c.b();
            b6.c(5);
            a6.b(b6.a());
            f2915f = a6.a();
            c.b a7 = com.google.firebase.l.c.a("packageName");
            com.google.firebase.l.j.c b7 = com.google.firebase.l.j.c.b();
            b7.c(6);
            a7.b(b7.a());
            g = a7.a();
            c.b a8 = com.google.firebase.l.c.a("collapseKey");
            com.google.firebase.l.j.c b8 = com.google.firebase.l.j.c.b();
            b8.c(7);
            a8.b(b8.a());
            h = a8.a();
            c.b a9 = com.google.firebase.l.c.a("priority");
            com.google.firebase.l.j.c b9 = com.google.firebase.l.j.c.b();
            b9.c(8);
            a9.b(b9.a());
            i = a9.a();
            c.b a10 = com.google.firebase.l.c.a("ttl");
            com.google.firebase.l.j.c b10 = com.google.firebase.l.j.c.b();
            b10.c(9);
            a10.b(b10.a());
            j = a10.a();
            c.b a11 = com.google.firebase.l.c.a("topic");
            com.google.firebase.l.j.c b11 = com.google.firebase.l.j.c.b();
            b11.c(10);
            a11.b(b11.a());
            k = a11.a();
            c.b a12 = com.google.firebase.l.c.a("bulkId");
            com.google.firebase.l.j.c b12 = com.google.firebase.l.j.c.b();
            b12.c(11);
            a12.b(b12.a());
            l = a12.a();
            c.b a13 = com.google.firebase.l.c.a("event");
            com.google.firebase.l.j.c b13 = com.google.firebase.l.j.c.b();
            b13.c(12);
            a13.b(b13.a());
            m = a13.a();
            c.b a14 = com.google.firebase.l.c.a("analyticsLabel");
            com.google.firebase.l.j.c b14 = com.google.firebase.l.j.c.b();
            b14.c(13);
            a14.b(b14.a());
            n = a14.a();
            c.b a15 = com.google.firebase.l.c.a("campaignId");
            com.google.firebase.l.j.c b15 = com.google.firebase.l.j.c.b();
            b15.c(14);
            a15.b(b15.a());
            o = a15.a();
            c.b a16 = com.google.firebase.l.c.a("composerLabel");
            com.google.firebase.l.j.c b16 = com.google.firebase.l.j.c.b();
            b16.c(15);
            a16.b(b16.a());
            p = a16.a();
        }

        private a() {
        }

        /* renamed from: b */
        public void a(com.google.firebase.messaging.j1.a aVar, e eVar) {
            eVar.c(f2911b, aVar.l());
            eVar.e(f2912c, aVar.h());
            eVar.e(f2913d, aVar.g());
            eVar.e(f2914e, aVar.i());
            eVar.e(f2915f, aVar.m());
            eVar.e(g, aVar.j());
            eVar.e(h, aVar.d());
            eVar.d(i, aVar.k());
            eVar.d(j, aVar.o());
            eVar.e(k, aVar.n());
            eVar.c(l, aVar.b());
            eVar.e(m, aVar.f());
            eVar.e(n, aVar.a());
            eVar.c(o, aVar.c());
            eVar.e(p, aVar.e());
        }
    }

    private static final class b implements d<com.google.firebase.messaging.j1.b> {

        /* renamed from: a  reason: collision with root package name */
        static final b f2916a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final com.google.firebase.l.c f2917b;

        static {
            c.b a2 = com.google.firebase.l.c.a("messagingClientEvent");
            com.google.firebase.l.j.c b2 = com.google.firebase.l.j.c.b();
            b2.c(1);
            a2.b(b2.a());
            f2917b = a2.a();
        }

        private b() {
        }

        /* renamed from: b */
        public void a(com.google.firebase.messaging.j1.b bVar, e eVar) {
            eVar.e(f2917b, bVar.a());
        }
    }

    private static final class c implements d<r0> {

        /* renamed from: a  reason: collision with root package name */
        static final c f2918a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final com.google.firebase.l.c f2919b = com.google.firebase.l.c.d("messagingClientEventExtension");

        private c() {
        }

        /* renamed from: b */
        public void a(r0 r0Var, e eVar) {
            eVar.e(f2919b, r0Var.b());
        }
    }

    private d0() {
    }

    public void a(com.google.firebase.l.h.b<?> bVar) {
        bVar.a(r0.class, c.f2918a);
        bVar.a(com.google.firebase.messaging.j1.b.class, b.f2916a);
        bVar.a(com.google.firebase.messaging.j1.a.class, a.f2910a);
    }
}
