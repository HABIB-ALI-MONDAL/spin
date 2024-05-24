package c.b.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import c.b.a.n.o.j;
import c.b.a.n.o.z.b;
import c.b.a.r.i.i;
import java.util.Map;

public class e extends ContextWrapper {
    static final k<?, ?> h = new b();

    /* renamed from: a  reason: collision with root package name */
    private final b f817a;

    /* renamed from: b  reason: collision with root package name */
    private final h f818b;

    /* renamed from: c  reason: collision with root package name */
    private final c.b.a.r.i.e f819c;

    /* renamed from: d  reason: collision with root package name */
    private final c.b.a.r.e f820d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f821e;

    /* renamed from: f  reason: collision with root package name */
    private final j f822f;
    private final int g;

    public e(Context context, b bVar, h hVar, c.b.a.r.i.e eVar, c.b.a.r.e eVar2, Map<Class<?>, k<?, ?>> map, j jVar, int i) {
        super(context.getApplicationContext());
        this.f817a = bVar;
        this.f818b = hVar;
        this.f819c = eVar;
        this.f820d = eVar2;
        this.f821e = map;
        this.f822f = jVar;
        this.g = i;
        new Handler(Looper.getMainLooper());
    }

    public <X> i<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f819c.a(imageView, cls);
    }

    public b b() {
        return this.f817a;
    }

    public c.b.a.r.e c() {
        return this.f820d;
    }

    public <T> k<?, T> d(Class<T> cls) {
        k<?, T> kVar = this.f821e.get(cls);
        if (kVar == null) {
            for (Map.Entry next : this.f821e.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    kVar = (k) next.getValue();
                }
            }
        }
        return kVar == null ? h : kVar;
    }

    public j e() {
        return this.f822f;
    }

    public int f() {
        return this.g;
    }

    public h g() {
        return this.f818b;
    }
}
