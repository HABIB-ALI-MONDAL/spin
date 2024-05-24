package c.d.a.b.c;

import android.os.Looper;
import android.os.Message;

final class f extends c.d.a.b.e.c.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1529a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f(d dVar, Looper looper) {
        super(looper);
        this.f1529a = dVar;
    }

    public final void handleMessage(Message message) {
        d.d(this.f1529a, message);
    }
}
