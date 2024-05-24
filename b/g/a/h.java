package b.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import b.d.j.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class h<E> extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f699a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f700b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f701c;

    /* renamed from: d  reason: collision with root package name */
    final j f702d;

    h(Activity activity, Context context, Handler handler, int i) {
        this.f702d = new j();
        this.f699a = activity;
        g.c(context, "context == null");
        this.f700b = context;
        g.c(handler, "handler == null");
        this.f701c = handler;
    }

    h(e eVar) {
        this(eVar, eVar, eVar.k, 0);
    }

    /* access modifiers changed from: package-private */
    public Activity d() {
        return this.f699a;
    }

    /* access modifiers changed from: package-private */
    public Context e() {
        return this.f700b;
    }

    /* access modifiers changed from: package-private */
    public j f() {
        return this.f702d;
    }

    /* access modifiers changed from: package-private */
    public Handler g() {
        return this.f701c;
    }

    /* access modifiers changed from: package-private */
    public abstract void h(d dVar);

    public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract LayoutInflater j();

    public abstract int k();

    public abstract boolean l();

    public abstract void m(d dVar, String[] strArr, int i);

    public abstract boolean n(d dVar);

    public abstract void o(d dVar, Intent intent, int i, Bundle bundle);

    public abstract void p();
}
