package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private b f1597a;

    /* renamed from: b  reason: collision with root package name */
    private b f1598b;

    /* renamed from: c  reason: collision with root package name */
    private final List f1599c;

    public c() {
        this.f1597a = new b("", 0, (Map) null);
        this.f1598b = new b("", 0, (Map) null);
        this.f1599c = new ArrayList();
    }

    public c(b bVar) {
        this.f1597a = bVar;
        this.f1598b = bVar.clone();
        this.f1599c = new ArrayList();
    }

    public final b a() {
        return this.f1597a;
    }

    public final b b() {
        return this.f1598b;
    }

    public final List c() {
        return this.f1599c;
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        c cVar = new c(this.f1597a.clone());
        for (b b2 : this.f1599c) {
            cVar.f1599c.add(b2.clone());
        }
        return cVar;
    }

    public final void d(b bVar) {
        this.f1597a = bVar;
        this.f1598b = bVar.clone();
        this.f1599c.clear();
    }

    public final void e(String str, long j, Map map) {
        this.f1599c.add(new b(str, j, map));
    }

    public final void f(b bVar) {
        this.f1598b = bVar;
    }
}
