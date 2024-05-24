package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f426a = new HashMap();

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Map<String, Object> map = this.f426a;
        if (map != null) {
            synchronized (map) {
                for (Object b2 : this.f426a.values()) {
                    b(b2);
                }
            }
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public <T> T c(String str) {
        T t;
        Map<String, Object> map = this.f426a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = this.f426a.get(str);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public void d() {
    }
}
