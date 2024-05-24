package androidx.activity.c;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f39a = new CopyOnWriteArraySet();

    public void a() {
    }

    public void b(Context context) {
        for (b a2 : this.f39a) {
            a2.a(context);
        }
    }
}
