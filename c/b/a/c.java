package c.b.a;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.b.a.m.a;
import c.b.a.n.n.k;
import c.b.a.n.o.a0.h;
import c.b.a.n.o.j;
import c.b.a.n.o.z.b;
import c.b.a.n.o.z.e;
import c.b.a.n.p.a;
import c.b.a.n.p.b;
import c.b.a.n.p.d;
import c.b.a.n.p.e;
import c.b.a.n.p.f;
import c.b.a.n.p.g;
import c.b.a.n.p.k;
import c.b.a.n.p.s;
import c.b.a.n.p.t;
import c.b.a.n.p.u;
import c.b.a.n.p.v;
import c.b.a.n.p.w;
import c.b.a.n.p.x;
import c.b.a.n.p.y.a;
import c.b.a.n.p.y.b;
import c.b.a.n.p.y.c;
import c.b.a.n.p.y.d;
import c.b.a.n.p.y.e;
import c.b.a.n.q.c.f;
import c.b.a.n.q.c.i;
import c.b.a.n.q.c.k;
import c.b.a.n.q.c.r;
import c.b.a.n.q.c.s;
import c.b.a.n.q.c.u;
import c.b.a.n.q.c.v;
import c.b.a.n.q.d.a;
import c.b.a.o.d;
import c.b.a.o.l;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements ComponentCallbacks2 {
    private static volatile c r;
    private static volatile boolean s;
    private final e j;
    private final h k;
    private final e l;
    private final h m;
    private final b n;
    private final l o;
    private final d p;
    private final List<j> q = new ArrayList();

    c(Context context, j jVar, h hVar, e eVar, b bVar, l lVar, d dVar, int i, c.b.a.r.e eVar2, Map<Class<?>, k<?, ?>> map) {
        Context context2 = context;
        h hVar2 = hVar;
        e eVar3 = eVar;
        b bVar2 = bVar;
        Class<a> cls = a.class;
        f fVar = f.NORMAL;
        this.j = eVar3;
        this.n = bVar2;
        this.k = hVar2;
        this.o = lVar;
        this.p = dVar;
        new c.b.a.n.o.c0.a(hVar2, eVar3, (c.b.a.n.b) eVar2.s().c(k.f1144f));
        Resources resources = context.getResources();
        h hVar3 = new h();
        this.m = hVar3;
        hVar3.o(new i());
        k kVar = new k(hVar3.g(), resources.getDisplayMetrics(), eVar3, bVar2);
        c.b.a.n.q.g.a aVar = new c.b.a.n.q.g.a(context2, hVar3.g(), eVar3, bVar2);
        c.b.a.n.k<ParcelFileDescriptor, Bitmap> e2 = v.e(eVar);
        f fVar2 = new f(kVar);
        s sVar = new s(kVar, bVar2);
        c.b.a.n.q.e.d dVar2 = new c.b.a.n.q.e.d(context2);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar3 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        c.b.a.n.q.c.c cVar2 = new c.b.a.n.q.c.c(bVar2);
        c.b.a.n.q.h.a aVar3 = new c.b.a.n.q.h.a();
        c.b.a.n.q.h.d dVar4 = new c.b.a.n.q.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        s.d dVar5 = dVar3;
        hVar3.a(ByteBuffer.class, new c.b.a.n.p.c());
        hVar3.a(InputStream.class, new t(bVar2));
        hVar3.e("Bitmap", ByteBuffer.class, Bitmap.class, fVar2);
        hVar3.e("Bitmap", InputStream.class, Bitmap.class, sVar);
        hVar3.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, e2);
        hVar3.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, v.c(eVar));
        hVar3.d(Bitmap.class, Bitmap.class, v.a.a());
        hVar3.e("Bitmap", Bitmap.class, Bitmap.class, new u());
        hVar3.b(Bitmap.class, cVar2);
        hVar3.e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new c.b.a.n.q.c.a(resources, fVar2));
        hVar3.e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new c.b.a.n.q.c.a(resources, sVar));
        hVar3.e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new c.b.a.n.q.c.a(resources, e2));
        hVar3.b(BitmapDrawable.class, new c.b.a.n.q.c.b(eVar3, cVar2));
        hVar3.e("Gif", InputStream.class, c.b.a.n.q.g.c.class, new c.b.a.n.q.g.j(hVar3.g(), aVar, bVar2));
        hVar3.e("Gif", ByteBuffer.class, c.b.a.n.q.g.c.class, aVar);
        hVar3.b(c.b.a.n.q.g.c.class, new c.b.a.n.q.g.d());
        hVar3.d(cls, cls, v.a.a());
        hVar3.e("Bitmap", cls, Bitmap.class, new c.b.a.n.q.g.h(eVar3));
        hVar3.c(Uri.class, Drawable.class, dVar2);
        hVar3.c(Uri.class, Bitmap.class, new r(dVar2, eVar3));
        hVar3.p(new a.C0052a());
        hVar3.d(File.class, ByteBuffer.class, new d.b());
        hVar3.d(File.class, InputStream.class, new f.e());
        hVar3.c(File.class, File.class, new c.b.a.n.q.f.a());
        hVar3.d(File.class, ParcelFileDescriptor.class, new f.b());
        hVar3.d(File.class, File.class, v.a.a());
        hVar3.p(new k.a(bVar2));
        Class cls2 = Integer.TYPE;
        hVar3.d(cls2, InputStream.class, cVar);
        s.b bVar4 = bVar3;
        hVar3.d(cls2, ParcelFileDescriptor.class, bVar4);
        Class<Integer> cls3 = Integer.class;
        hVar3.d(cls3, InputStream.class, cVar);
        hVar3.d(cls3, ParcelFileDescriptor.class, bVar4);
        s.d dVar6 = dVar5;
        hVar3.d(cls3, Uri.class, dVar6);
        s.a aVar4 = aVar2;
        hVar3.d(cls2, AssetFileDescriptor.class, aVar4);
        hVar3.d(cls3, AssetFileDescriptor.class, aVar4);
        hVar3.d(cls2, Uri.class, dVar6);
        Class<String> cls4 = String.class;
        hVar3.d(cls4, InputStream.class, new e.c());
        hVar3.d(cls4, InputStream.class, new u.c());
        hVar3.d(cls4, ParcelFileDescriptor.class, new u.b());
        hVar3.d(cls4, AssetFileDescriptor.class, new u.a());
        hVar3.d(Uri.class, InputStream.class, new b.a());
        hVar3.d(Uri.class, InputStream.class, new a.c(context.getAssets()));
        hVar3.d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets()));
        Context context3 = context;
        hVar3.d(Uri.class, InputStream.class, new c.a(context3));
        hVar3.d(Uri.class, InputStream.class, new d.a(context3));
        ContentResolver contentResolver2 = contentResolver;
        hVar3.d(Uri.class, InputStream.class, new w.d(contentResolver2));
        hVar3.d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver2));
        hVar3.d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver2));
        hVar3.d(Uri.class, InputStream.class, new x.a());
        hVar3.d(URL.class, InputStream.class, new e.a());
        hVar3.d(Uri.class, File.class, new k.a(context3));
        hVar3.d(g.class, InputStream.class, new a.C0051a());
        Class<byte[]> cls5 = byte[].class;
        hVar3.d(cls5, ByteBuffer.class, new b.a());
        hVar3.d(cls5, InputStream.class, new b.d());
        hVar3.d(Uri.class, Uri.class, v.a.a());
        hVar3.d(Drawable.class, Drawable.class, v.a.a());
        hVar3.c(Drawable.class, Drawable.class, new c.b.a.n.q.e.e());
        hVar3.q(Bitmap.class, BitmapDrawable.class, new c.b.a.n.q.h.b(resources));
        c.b.a.n.q.h.a aVar5 = aVar3;
        hVar3.q(Bitmap.class, cls5, aVar5);
        c.b.a.n.q.h.d dVar7 = dVar4;
        hVar3.q(Drawable.class, cls5, new c.b.a.n.q.h.c(eVar3, aVar5, dVar7));
        hVar3.q(c.b.a.n.q.g.c.class, cls5, dVar7);
        this.l = new e(context, bVar, hVar3, new c.b.a.r.i.e(), eVar2, map, jVar, i);
    }

    private static void a(Context context) {
        if (!s) {
            s = true;
            m(context);
            s = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static c c(Context context) {
        if (r == null) {
            synchronized (c.class) {
                if (r == null) {
                    a(context);
                }
            }
        }
        return r;
    }

    private static a d() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (InstantiationException e2) {
            q(e2);
            throw null;
        } catch (IllegalAccessException e3) {
            q(e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            q(e4);
            throw null;
        } catch (InvocationTargetException e5) {
            q(e5);
            throw null;
        }
    }

    private static l l(Context context) {
        c.b.a.t.h.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context) {
        n(context, new d());
    }

    private static void n(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a d2 = d();
        List<c.b.a.p.b> emptyList = Collections.emptyList();
        if (d2 == null || d2.c()) {
            emptyList = new c.b.a.p.d(applicationContext).a();
        }
        if (d2 != null && !d2.d().isEmpty()) {
            Set<Class<?>> d3 = d2.d();
            Iterator<c.b.a.p.b> it = emptyList.iterator();
            while (it.hasNext()) {
                c.b.a.p.b next = it.next();
                if (d3.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (c.b.a.p.b bVar : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + bVar.getClass());
            }
        }
        dVar.b(d2 != null ? d2.e() : null);
        for (c.b.a.p.b b2 : emptyList) {
            b2.b(applicationContext, dVar);
        }
        if (d2 != null) {
            d2.b(applicationContext, dVar);
        }
        c a2 = dVar.a(applicationContext);
        for (c.b.a.p.b a3 : emptyList) {
            a3.a(applicationContext, a2, a2.m);
        }
        if (d2 != null) {
            d2.a(applicationContext, a2, a2.m);
        }
        applicationContext.registerComponentCallbacks(a2);
        r = a2;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static j t(Context context) {
        return l(context).d(context);
    }

    public void b() {
        c.b.a.t.i.a();
        this.k.b();
        this.j.b();
        this.n.b();
    }

    public c.b.a.n.o.z.b e() {
        return this.n;
    }

    public c.b.a.n.o.z.e f() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public c.b.a.o.d g() {
        return this.p;
    }

    public Context h() {
        return this.l.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    public e i() {
        return this.l;
    }

    public h j() {
        return this.m;
    }

    public l k() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void o(j jVar) {
        synchronized (this.q) {
            if (!this.q.contains(jVar)) {
                this.q.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i) {
        r(i);
    }

    /* access modifiers changed from: package-private */
    public boolean p(c.b.a.r.i.h<?> hVar) {
        synchronized (this.q) {
            for (j t : this.q) {
                if (t.t(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i) {
        c.b.a.t.i.a();
        this.k.a(i);
        this.j.a(i);
        this.n.a(i);
    }

    /* access modifiers changed from: package-private */
    public void s(j jVar) {
        synchronized (this.q) {
            if (this.q.contains(jVar)) {
                this.q.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
