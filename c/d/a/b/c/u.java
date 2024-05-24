package c.d.a.b.c;

import android.os.Bundle;
import android.util.Log;
import c.d.a.b.h.j;

abstract class u<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f1539a;

    /* renamed from: b  reason: collision with root package name */
    final j<T> f1540b = new j<>();

    /* renamed from: c  reason: collision with root package name */
    final int f1541c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f1542d;

    u(int i, int i2, Bundle bundle) {
        this.f1539a = i;
        this.f1541c = i2;
        this.f1542d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public final void c(v vVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(vVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f1540b.b(vVar);
    }

    /* access modifiers changed from: package-private */
    public final void d(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f1540b.c(t);
    }

    public final String toString() {
        int i = this.f1541c;
        int i2 = this.f1539a;
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(b());
        sb.append("}");
        return sb.toString();
    }
}
