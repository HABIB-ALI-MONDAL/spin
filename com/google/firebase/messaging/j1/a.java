package com.google.firebase.messaging.j1;

import com.google.firebase.l.j.e;
import com.google.firebase.l.j.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final long f2966a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2967b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2968c;

    /* renamed from: d  reason: collision with root package name */
    private final c f2969d;

    /* renamed from: e  reason: collision with root package name */
    private final d f2970e;

    /* renamed from: f  reason: collision with root package name */
    private final String f2971f;
    private final String g;
    private final int h;
    private final int i;
    private final String j;
    private final long k;
    private final b l;
    private final String m;
    private final long n;
    private final String o;

    /* renamed from: com.google.firebase.messaging.j1.a$a  reason: collision with other inner class name */
    public static final class C0077a {

        /* renamed from: a  reason: collision with root package name */
        private long f2972a = 0;

        /* renamed from: b  reason: collision with root package name */
        private String f2973b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f2974c = "";

        /* renamed from: d  reason: collision with root package name */
        private c f2975d = c.UNKNOWN;

        /* renamed from: e  reason: collision with root package name */
        private d f2976e = d.UNKNOWN_OS;

        /* renamed from: f  reason: collision with root package name */
        private String f2977f = "";
        private String g = "";
        private int h = 0;
        private int i = 0;
        private String j = "";
        private long k = 0;
        private b l = b.UNKNOWN_EVENT;
        private String m = "";
        private long n = 0;
        private String o = "";

        C0077a() {
        }

        public a a() {
            return new a(this.f2972a, this.f2973b, this.f2974c, this.f2975d, this.f2976e, this.f2977f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
        }

        public C0077a b(String str) {
            this.m = str;
            return this;
        }

        public C0077a c(String str) {
            this.g = str;
            return this;
        }

        public C0077a d(String str) {
            this.o = str;
            return this;
        }

        public C0077a e(b bVar) {
            this.l = bVar;
            return this;
        }

        public C0077a f(String str) {
            this.f2974c = str;
            return this;
        }

        public C0077a g(String str) {
            this.f2973b = str;
            return this;
        }

        public C0077a h(c cVar) {
            this.f2975d = cVar;
            return this;
        }

        public C0077a i(String str) {
            this.f2977f = str;
            return this;
        }

        public C0077a j(long j2) {
            this.f2972a = j2;
            return this;
        }

        public C0077a k(d dVar) {
            this.f2976e = dVar;
            return this;
        }

        public C0077a l(String str) {
            this.j = str;
            return this;
        }

        public C0077a m(int i2) {
            this.i = i2;
            return this;
        }
    }

    public enum b implements e {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        
        private final int j;

        private b(int i) {
            this.j = i;
        }

        public int d() {
            return this.j;
        }
    }

    public enum c implements e {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        
        private final int j;

        private c(int i) {
            this.j = i;
        }

        public int d() {
            return this.j;
        }
    }

    public enum d implements e {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        
        private final int j;

        private d(int i) {
            this.j = i;
        }

        public int d() {
            return this.j;
        }
    }

    static {
        new C0077a().a();
    }

    a(long j2, String str, String str2, c cVar, d dVar, String str3, String str4, int i2, int i3, String str5, long j3, b bVar, String str6, long j4, String str7) {
        this.f2966a = j2;
        this.f2967b = str;
        this.f2968c = str2;
        this.f2969d = cVar;
        this.f2970e = dVar;
        this.f2971f = str3;
        this.g = str4;
        this.h = i2;
        this.i = i3;
        this.j = str5;
        this.k = j3;
        this.l = bVar;
        this.m = str6;
        this.n = j4;
        this.o = str7;
    }

    public static C0077a p() {
        return new C0077a();
    }

    @f(tag = 13)
    public String a() {
        return this.m;
    }

    @f(tag = 11)
    public long b() {
        return this.k;
    }

    @f(tag = 14)
    public long c() {
        return this.n;
    }

    @f(tag = 7)
    public String d() {
        return this.g;
    }

    @f(tag = 15)
    public String e() {
        return this.o;
    }

    @f(tag = 12)
    public b f() {
        return this.l;
    }

    @f(tag = 3)
    public String g() {
        return this.f2968c;
    }

    @f(tag = 2)
    public String h() {
        return this.f2967b;
    }

    @f(tag = 4)
    public c i() {
        return this.f2969d;
    }

    @f(tag = 6)
    public String j() {
        return this.f2971f;
    }

    @f(tag = 8)
    public int k() {
        return this.h;
    }

    @f(tag = 1)
    public long l() {
        return this.f2966a;
    }

    @f(tag = 5)
    public d m() {
        return this.f2970e;
    }

    @f(tag = 10)
    public String n() {
        return this.j;
    }

    @f(tag = 9)
    public int o() {
        return this.i;
    }
}
