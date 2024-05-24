package b.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.core.app.d;
import androidx.lifecycle.d;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import b.c.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class e extends d implements t, a.b, a.d {
    final Handler k = new a();
    final g l = g.b(new b());
    private s m;
    boolean n;
    boolean o;
    boolean p = true;
    boolean q;
    boolean r;
    boolean s;
    int t;
    h<String> u;

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            e.this.r();
            e.this.l.s();
        }
    }

    class b extends h<e> {
        public b() {
            super(e.this);
        }

        public View b(int i) {
            return e.this.findViewById(i);
        }

        public boolean c() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public void h(d dVar) {
            e.this.p(dVar);
        }

        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public LayoutInflater j() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        public int k() {
            Window window = e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean l() {
            return e.this.getWindow() != null;
        }

        public void m(d dVar, String[] strArr, int i) {
            e.this.t(dVar, strArr, i);
        }

        public boolean n(d dVar) {
            return !e.this.isFinishing();
        }

        public void o(d dVar, Intent intent, int i, Bundle bundle) {
            e.this.u(dVar, intent, i, bundle);
        }

        public void p() {
            e.this.v();
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        Object f695a;

        /* renamed from: b  reason: collision with root package name */
        s f696b;

        /* renamed from: c  reason: collision with root package name */
        k f697c;

        c() {
        }
    }

    private int j(d dVar) {
        if (this.u.o() < 65534) {
            while (this.u.k(this.t) >= 0) {
                this.t = (this.t + 1) % 65534;
            }
            int i = this.t;
            this.u.m(i, dVar.o);
            this.t = (this.t + 1) % 65534;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void k(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void n() {
        do {
        } while (o(m(), d.c.CREATED));
    }

    private static boolean o(i iVar, d.c cVar) {
        boolean z = false;
        for (d next : iVar.d()) {
            if (next != null) {
                if (next.a().b().d(d.c.STARTED)) {
                    next.b0.j(cVar);
                    z = true;
                }
                i y0 = next.y0();
                if (y0 != null) {
                    z |= o(y0, cVar);
                }
            }
        }
        return z;
    }

    public androidx.lifecycle.d a() {
        return super.a();
    }

    public final void b(int i) {
        if (!this.q && i != -1) {
            k(i);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.n);
        printWriter.print(" mResumed=");
        printWriter.print(this.o);
        printWriter.print(" mStopped=");
        printWriter.print(this.p);
        if (getApplication() != null) {
            b.j.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.l.u().b(str, fileDescriptor, printWriter, strArr);
    }

    public s g() {
        if (getApplication() != null) {
            if (this.m == null) {
                c cVar = (c) getLastNonConfigurationInstance();
                if (cVar != null) {
                    this.m = cVar.f696b;
                }
                if (this.m == null) {
                    this.m = new s();
                }
            }
            return this.m;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    /* access modifiers changed from: package-private */
    public final View l(View view, String str, Context context, AttributeSet attributeSet) {
        return this.l.w(view, str, context, attributeSet);
    }

    public i m() {
        return this.l.u();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.l.v();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String i5 = this.u.i(i4);
            this.u.n(i4);
            if (i5 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            d t2 = this.l.t(i5);
            if (t2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + i5);
                return;
            }
            t2.T(i & 65535, i2, intent);
            return;
        }
        a.c l2 = androidx.core.app.a.l();
        if (l2 == null || !l2.b(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        i u2 = this.l.u();
        boolean e2 = u2.e();
        if (e2 && Build.VERSION.SDK_INT <= 25) {
            return;
        }
        if (e2 || !u2.g()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.l.v();
        this.l.d(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        s sVar;
        k kVar = null;
        this.l.a((d) null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (!(cVar == null || (sVar = cVar.f696b) == null || this.m != null)) {
            this.m = sVar;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            g gVar = this.l;
            if (cVar != null) {
                kVar = cVar.f697c;
            }
            gVar.x(parcelable, kVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.t = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.u = new h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.u.m(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.u == null) {
            this.u = new h<>();
            this.t = 0;
        }
        this.l.f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.l.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View l2 = l(view, str, context, attributeSet);
        return l2 == null ? super.onCreateView(view, str, context, attributeSet) : l2;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View l2 = l((View) null, str, context, attributeSet);
        return l2 == null ? super.onCreateView(str, context, attributeSet) : l2;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.m != null && !isChangingConfigurations()) {
            this.m.a();
        }
        this.l.h();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.l.i();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.l.k(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.l.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.l.j(z);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.l.v();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.l.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.o = false;
        if (this.k.hasMessages(2)) {
            this.k.removeMessages(2);
            r();
        }
        this.l.m();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.l.n(z);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.k.removeMessages(2);
        r();
        this.l.s();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : q(view, menu) | this.l.o(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.l.v();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String i4 = this.u.i(i3);
            this.u.n(i3);
            if (i4 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            d t2 = this.l.t(i4);
            if (t2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + i4);
                return;
            }
            t2.r0(i & 65535, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.k.sendEmptyMessage(2);
        this.o = true;
        this.l.s();
    }

    public final Object onRetainNonConfigurationInstance() {
        Object s2 = s();
        k y = this.l.y();
        if (y == null && this.m == null && s2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.f695a = s2;
        cVar.f696b = this.m;
        cVar.f697c = y;
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        n();
        Parcelable z = this.l.z();
        if (z != null) {
            bundle.putParcelable("android:support:fragments", z);
        }
        if (this.u.o() > 0) {
            bundle.putInt("android:support:next_request_index", this.t);
            int[] iArr = new int[this.u.o()];
            String[] strArr = new String[this.u.o()];
            for (int i = 0; i < this.u.o(); i++) {
                iArr[i] = this.u.l(i);
                strArr[i] = this.u.p(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.p = false;
        if (!this.n) {
            this.n = true;
            this.l.c();
        }
        this.l.v();
        this.l.s();
        this.l.q();
    }

    public void onStateNotSaved() {
        this.l.v();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.p = true;
        n();
        this.l.r();
    }

    public void p(d dVar) {
    }

    /* access modifiers changed from: protected */
    public boolean q(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* access modifiers changed from: protected */
    public void r() {
        this.l.p();
    }

    public Object s() {
        return null;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!this.s && i != -1) {
            k(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.s && i != -1) {
            k(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.r && i != -1) {
            k(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.r && i != -1) {
            k(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void t(d dVar, String[] strArr, int i) {
        if (i == -1) {
            androidx.core.app.a.m(this, strArr, i);
            return;
        }
        k(i);
        try {
            this.q = true;
            androidx.core.app.a.m(this, strArr, ((j(dVar) + 1) << 16) + (i & 65535));
            this.q = false;
        } catch (Throwable th) {
            this.q = false;
            throw th;
        }
    }

    public void u(d dVar, Intent intent, int i, Bundle bundle) {
        this.s = true;
        if (i == -1) {
            try {
                androidx.core.app.a.n(this, intent, -1, bundle);
            } finally {
                this.s = false;
            }
        } else {
            k(i);
            androidx.core.app.a.n(this, intent, ((j(dVar) + 1) << 16) + (i & 65535), bundle);
            this.s = false;
        }
    }

    @Deprecated
    public void v() {
        invalidateOptionsMenu();
    }
}
