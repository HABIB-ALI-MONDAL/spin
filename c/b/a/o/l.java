package c.b.a.o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import b.g.a.d;
import b.g.a.e;
import b.g.a.i;
import b.g.a.n;
import c.b.a.c;
import c.b.a.j;
import java.util.HashMap;
import java.util.Map;

public class l implements Handler.Callback {

    /* renamed from: f  reason: collision with root package name */
    private static final b f1227f = new a();

    /* renamed from: a  reason: collision with root package name */
    private volatile j f1228a;

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, k> f1229b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<i, o> f1230c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f1231d;

    /* renamed from: e  reason: collision with root package name */
    private final b f1232e;

    class a implements b {
        a() {
        }

        public j a(c cVar, h hVar, m mVar, Context context) {
            return new j(cVar, hVar, mVar, context);
        }
    }

    public interface b {
        j a(c cVar, h hVar, m mVar, Context context);
    }

    public l(b bVar) {
        new b.c.a();
        new b.c.a();
        new Bundle();
        this.f1232e = bVar == null ? f1227f : bVar;
        this.f1231d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private j b(Context context, FragmentManager fragmentManager, Fragment fragment) {
        k g = g(fragmentManager, fragment);
        j d2 = g.d();
        if (d2 != null) {
            return d2;
        }
        j a2 = this.f1232e.a(c.c(context), g.b(), g.e(), context);
        g.i(a2);
        return a2;
    }

    private j f(Context context) {
        if (this.f1228a == null) {
            synchronized (this) {
                if (this.f1228a == null) {
                    this.f1228a = this.f1232e.a(c.c(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f1228a;
    }

    private j i(Context context, i iVar, d dVar) {
        o h = h(iVar, dVar);
        j m1 = h.m1();
        if (m1 != null) {
            return m1;
        }
        j a2 = this.f1232e.a(c.c(context), h.k1(), h.n1(), context);
        h.r1(a2);
        return a2;
    }

    public j c(Activity activity) {
        if (c.b.a.t.i.o()) {
            return d(activity.getApplicationContext());
        }
        a(activity);
        return b(activity, activity.getFragmentManager(), (Fragment) null);
    }

    public j d(Context context) {
        if (context != null) {
            if (c.b.a.t.i.p() && !(context instanceof Application)) {
                if (context instanceof e) {
                    return e((e) context);
                }
                if (context instanceof Activity) {
                    return c((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return d(((ContextWrapper) context).getBaseContext());
                }
            }
            return f(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public j e(e eVar) {
        if (c.b.a.t.i.o()) {
            return d(eVar.getApplicationContext());
        }
        a(eVar);
        return i(eVar, eVar.m(), (d) null);
    }

    /* access modifiers changed from: package-private */
    public k g(FragmentManager fragmentManager, Fragment fragment) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = this.f1229b.get(fragmentManager);
        if (kVar2 != null) {
            return kVar2;
        }
        k kVar3 = new k();
        kVar3.h(fragment);
        this.f1229b.put(fragmentManager, kVar3);
        fragmentManager.beginTransaction().add(kVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f1231d.obtainMessage(1, fragmentManager).sendToTarget();
        return kVar3;
    }

    /* access modifiers changed from: package-private */
    public o h(i iVar, d dVar) {
        o oVar = (o) iVar.c("com.bumptech.glide.manager");
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = this.f1230c.get(iVar);
        if (oVar2 != null) {
            return oVar2;
        }
        o oVar3 = new o();
        oVar3.q1(dVar);
        this.f1230c.put(iVar, oVar3);
        n a2 = iVar.a();
        a2.b(oVar3, "com.bumptech.glide.manager");
        a2.d();
        this.f1231d.obtainMessage(2, iVar).sendToTarget();
        return oVar3;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Map map;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj2 = (FragmentManager) message.obj;
            map = this.f1229b;
        } else if (i != 2) {
            z = false;
            obj = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
            }
            return z;
        } else {
            obj2 = (i) message.obj;
            map = this.f1230c;
        }
        Object obj4 = obj2;
        obj3 = map.remove(obj2);
        obj = obj4;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        return z;
    }
}
