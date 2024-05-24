package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class s0 extends k0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f255b;

    public s0(Context context, Resources resources) {
        super(resources);
        this.f255b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f255b.get();
        if (!(drawable == null || context == null)) {
            j.n();
            j.D(context, i, drawable);
        }
        return drawable;
    }
}
