package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class q0 extends ContextWrapper {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f244c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<WeakReference<q0>> f245d;

    /* renamed from: a  reason: collision with root package name */
    private final Resources f246a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources.Theme f247b;

    private q0(Context context) {
        super(context);
        if (y0.b()) {
            y0 y0Var = new y0(this, context.getResources());
            this.f246a = y0Var;
            Resources.Theme newTheme = y0Var.newTheme();
            this.f247b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f246a = new s0(this, context.getResources());
        this.f247b = null;
    }

    private static boolean a(Context context) {
        if ((context instanceof q0) || (context.getResources() instanceof s0) || (context.getResources() instanceof y0)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || y0.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f244c) {
            ArrayList<WeakReference<q0>> arrayList = f245d;
            if (arrayList == null) {
                f245d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f245d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f245d.remove(size);
                    }
                }
                for (int size2 = f245d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f245d.get(size2);
                    q0 q0Var = weakReference2 != null ? (q0) weakReference2.get() : null;
                    if (q0Var != null && q0Var.getBaseContext() == context) {
                        return q0Var;
                    }
                }
            }
            q0 q0Var2 = new q0(context);
            f245d.add(new WeakReference(q0Var2));
            return q0Var2;
        }
    }

    public AssetManager getAssets() {
        return this.f246a.getAssets();
    }

    public Resources getResources() {
        return this.f246a;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f247b;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.f247b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
