package com.google.firebase.l.i;

import com.google.firebase.l.e;
import com.google.firebase.l.f;
import com.google.firebase.l.g;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class d implements com.google.firebase.l.h.b<d> {

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.firebase.l.d<Object> f2841e = a.f2838a;

    /* renamed from: f  reason: collision with root package name */
    private static final f<String> f2842f = b.f2839a;
    private static final f<Boolean> g = c.f2840a;
    private static final b h = new b((a) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, com.google.firebase.l.d<?>> f2843a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, f<?>> f2844b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.google.firebase.l.d<Object> f2845c = f2841e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f2846d = false;

    class a implements com.google.firebase.l.a {
        a() {
        }

        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f2843a, d.this.f2844b, d.this.f2845c, d.this.f2846d);
            eVar.h(obj, false);
            eVar.p();
        }
    }

    private static final class b implements f<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f2848a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f2848a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: b */
        public void a(Date date, g gVar) {
            gVar.a(f2848a.format(date));
        }
    }

    public d() {
        m(String.class, f2842f);
        m(Boolean.class, g);
        m(Date.class, h);
    }

    static /* synthetic */ void i(Object obj, e eVar) {
        throw new com.google.firebase.l.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public /* bridge */ /* synthetic */ com.google.firebase.l.h.b a(Class cls, com.google.firebase.l.d dVar) {
        l(cls, dVar);
        return this;
    }

    public com.google.firebase.l.a f() {
        return new a();
    }

    public d g(com.google.firebase.l.h.a aVar) {
        aVar.a(this);
        return this;
    }

    public d h(boolean z) {
        this.f2846d = z;
        return this;
    }

    public <T> d l(Class<T> cls, com.google.firebase.l.d<? super T> dVar) {
        this.f2843a.put(cls, dVar);
        this.f2844b.remove(cls);
        return this;
    }

    public <T> d m(Class<T> cls, f<? super T> fVar) {
        this.f2844b.put(cls, fVar);
        this.f2843a.remove(cls);
        return this;
    }
}
