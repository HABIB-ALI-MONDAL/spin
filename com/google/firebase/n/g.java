package com.google.firebase.n;

import android.content.Context;
import android.util.Base64OutputStream;
import c.d.a.b.h.l;
import com.google.firebase.components.n;
import com.google.firebase.components.o;
import com.google.firebase.components.u;
import com.google.firebase.h;
import com.google.firebase.n.k;
import com.google.firebase.o.b;
import com.google.firebase.q.i;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class g implements j, k {

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f3034f = d.f3030a;

    /* renamed from: a  reason: collision with root package name */
    private final b<l> f3035a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3036b;

    /* renamed from: c  reason: collision with root package name */
    private final b<i> f3037c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<h> f3038d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f3039e;

    private g(Context context, String str, Set<h> set, b<i> bVar) {
        this(new a(context, str), set, new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), f3034f), bVar, context);
    }

    g(b<l> bVar, Set<h> set, Executor executor, b<i> bVar2, Context context) {
        this.f3035a = bVar;
        this.f3038d = set;
        this.f3039e = executor;
        this.f3037c = bVar2;
        this.f3036b = context;
    }

    public static n<g> c() {
        n.b<g> b2 = n.b(g.class, j.class, k.class);
        b2.b(u.i(Context.class));
        b2.b(u.i(h.class));
        b2.b(u.k(h.class));
        b2.b(u.j(i.class));
        b2.f(b.f3028a);
        return b2.d();
    }

    static /* synthetic */ g d(o oVar) {
        return new g((Context) oVar.a(Context.class), ((h) oVar.a(h.class)).l(), oVar.c(h.class), oVar.b(i.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ String f() {
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            l lVar = this.f3035a.get();
            List<m> c2 = lVar.c();
            lVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < c2.size(); i++) {
                m mVar = c2.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", mVar.c());
                jSONObject.put("dates", new JSONArray(mVar.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            try {
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                try {
                    base64OutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
    }

    static /* synthetic */ l g(Context context, String str) {
        return new l(context, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ Void i() {
        synchronized (this) {
            this.f3035a.get().k(System.currentTimeMillis(), this.f3037c.get().a());
        }
        return null;
    }

    static /* synthetic */ Thread j(Runnable runnable) {
        return new Thread(runnable, "heartbeat-information-executor");
    }

    public c.d.a.b.h.i<String> a() {
        return b.d.g.g.a(this.f3036b) ^ true ? l.e("") : l.c(this.f3039e, new c(this));
    }

    public synchronized k.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        l lVar = this.f3035a.get();
        if (lVar.i(currentTimeMillis)) {
            lVar.g();
            return k.a.GLOBAL;
        }
        return k.a.NONE;
    }

    public c.d.a.b.h.i<Void> k() {
        return this.f3038d.size() <= 0 ? l.e(null) : b.d.g.g.a(this.f3036b) ^ true ? l.e(null) : l.c(this.f3039e, new e(this));
    }
}
