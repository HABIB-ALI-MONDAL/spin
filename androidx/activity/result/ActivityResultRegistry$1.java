package androidx.activity.result;

import androidx.activity.result.c;
import androidx.activity.result.d.a;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

class ActivityResultRegistry$1 implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f41b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f42c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ c f43d;

    public void d(g gVar, d.b bVar) {
        if (d.b.ON_START.equals(bVar)) {
            this.f43d.f49f.put(this.f40a, new c.a(this.f41b, this.f42c));
            if (this.f43d.g.containsKey(this.f40a)) {
                Object obj = this.f43d.g.get(this.f40a);
                this.f43d.g.remove(this.f40a);
                this.f41b.a(obj);
            }
            a aVar = (a) this.f43d.h.getParcelable(this.f40a);
            if (aVar != null) {
                this.f43d.h.remove(this.f40a);
                this.f41b.a(this.f42c.a(aVar.b(), aVar.a()));
            }
        } else if (d.b.ON_STOP.equals(bVar)) {
            this.f43d.f49f.remove(this.f40a);
        } else if (d.b.ON_DESTROY.equals(bVar)) {
            this.f43d.f(this.f40a);
        }
    }
}
