package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class y0 extends Resources {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f285b = false;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f286a;

    public y0(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f286a = new WeakReference<>(context);
    }

    public static boolean a() {
        return f285b;
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    public final Drawable c(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f286a.get();
        return context != null ? j.n().z(context, this, i) : super.getDrawable(i);
    }
}
