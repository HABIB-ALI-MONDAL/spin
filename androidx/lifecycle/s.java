package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, q> f429a = new HashMap<>();

    public final void a() {
        for (q a2 : this.f429a.values()) {
            a2.a();
        }
        this.f429a.clear();
    }

    /* access modifiers changed from: package-private */
    public final q b(String str) {
        return this.f429a.get(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f429a.keySet());
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, q qVar) {
        q put = this.f429a.put(str, qVar);
        if (put != null) {
            put.d();
        }
    }
}
