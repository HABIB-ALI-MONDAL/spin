package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.d;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.savedstate.SavedStateRegistry;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends d implements g, t, androidx.savedstate.c {
    final androidx.activity.c.a k = new androidx.activity.c.a();
    private final h l = new h(this);
    final androidx.savedstate.b m = androidx.savedstate.b.a(this);
    private s n;
    private final OnBackPressedDispatcher o = new OnBackPressedDispatcher(new a());
    private int p;
    private final androidx.activity.result.c q;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e2;
                }
            }
        }
    }

    class b extends androidx.activity.result.c {
        b(ComponentActivity componentActivity) {
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        Object f22a;

        /* renamed from: b  reason: collision with root package name */
        s f23b;

        c() {
        }
    }

    public ComponentActivity() {
        new AtomicInteger();
        this.q = new b(this);
        if (a() != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                a().a(new e() {
                    public void d(g gVar, d.b bVar) {
                        if (bVar == d.b.ON_STOP) {
                            Window window = ComponentActivity.this.getWindow();
                            View peekDecorView = window != null ? window.peekDecorView() : null;
                            if (peekDecorView != null) {
                                peekDecorView.cancelPendingInputEvents();
                            }
                        }
                    }
                });
            }
            a().a(new e() {
                public void d(g gVar, d.b bVar) {
                    if (bVar == d.b.ON_DESTROY) {
                        ComponentActivity.this.k.a();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.g().a();
                        }
                    }
                }
            });
            a().a(new e() {
                public void d(g gVar, d.b bVar) {
                    ComponentActivity.this.k();
                    ComponentActivity.this.a().c(this);
                }
            });
            if (19 <= i && i <= 23) {
                a().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void l() {
        u.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
    }

    public androidx.lifecycle.d a() {
        return this.l;
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        l();
        super.addContentView(view, layoutParams);
    }

    public final SavedStateRegistry c() {
        return this.m.b();
    }

    public s g() {
        if (getApplication() != null) {
            k();
            return this.n;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.n == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.n = cVar.f23b;
            }
            if (this.n == null) {
                this.n = new s();
            }
        }
    }

    @Deprecated
    public Object m() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.q.b(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        this.o.b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.m.c(bundle);
        this.k.b(this);
        super.onCreate(bundle);
        this.q.d(bundle);
        o.f(this);
        int i = this.p;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.q.b(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object m2 = m();
        s sVar = this.n;
        if (sVar == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            sVar = cVar.f23b;
        }
        if (sVar == null && m2 == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.f22a = m2;
        cVar2.f23b = sVar;
        return cVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.d a2 = a();
        if (a2 instanceof h) {
            ((h) a2).o(d.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.m.d(bundle);
        this.q.e(bundle);
    }

    public void reportFullyDrawn() {
        try {
            if (b.k.a.d()) {
                b.k.a.a("reportFullyDrawn() for " + getComponentName());
            }
            int i = Build.VERSION.SDK_INT;
            if (i > 19 || (i == 19 && androidx.core.content.a.a(this, "android.permission.UPDATE_DEVICE_STATS") == 0)) {
                super.reportFullyDrawn();
            }
        } finally {
            b.k.a.b();
        }
    }

    public void setContentView(int i) {
        l();
        super.setContentView(i);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        l();
        super.setContentView(view);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        l();
        super.setContentView(view, layoutParams);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
