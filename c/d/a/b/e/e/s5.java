package c.d.a.b.e.e;

import android.database.ContentObserver;
import android.os.Handler;

final class s5 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t5 f1744a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s5(t5 t5Var, Handler handler) {
        super((Handler) null);
        this.f1744a = t5Var;
    }

    public final void onChange(boolean z) {
        this.f1744a.f();
    }
}
