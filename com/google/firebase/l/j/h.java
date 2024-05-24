package com.google.firebase.l.j;

import com.google.firebase.l.d;
import com.google.firebase.l.e;
import com.google.firebase.l.f;
import com.google.firebase.l.h.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, d<?>> f2868a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, f<?>> f2869b;

    /* renamed from: c  reason: collision with root package name */
    private final d<Object> f2870c;

    public static final class a implements b<a> {

        /* renamed from: d  reason: collision with root package name */
        private static final d<Object> f2871d = b.f2856a;

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, d<?>> f2872a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<Class<?>, f<?>> f2873b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private d<Object> f2874c = f2871d;

        static /* synthetic */ void d(Object obj, e eVar) {
            throw new com.google.firebase.l.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public /* bridge */ /* synthetic */ b a(Class cls, d dVar) {
            e(cls, dVar);
            return this;
        }

        public h b() {
            return new h(new HashMap(this.f2872a), new HashMap(this.f2873b), this.f2874c);
        }

        public a c(com.google.firebase.l.h.a aVar) {
            aVar.a(this);
            return this;
        }

        public <U> a e(Class<U> cls, d<? super U> dVar) {
            this.f2872a.put(cls, dVar);
            this.f2873b.remove(cls);
            return this;
        }
    }

    h(Map<Class<?>, d<?>> map, Map<Class<?>, f<?>> map2, d<Object> dVar) {
        this.f2868a = map;
        this.f2869b = map2;
        this.f2870c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new g(outputStream, this.f2868a, this.f2869b, this.f2870c).p(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
