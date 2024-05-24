package c.b.a.n.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.b.a.t.i;

class x {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1010a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1011b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((u) message.obj).b();
            return true;
        }
    }

    x() {
    }

    /* access modifiers changed from: package-private */
    public void a(u<?> uVar) {
        i.a();
        if (this.f1010a) {
            this.f1011b.obtainMessage(1, uVar).sendToTarget();
            return;
        }
        this.f1010a = true;
        uVar.b();
        this.f1010a = false;
    }
}
