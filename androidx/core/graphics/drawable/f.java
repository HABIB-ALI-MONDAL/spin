package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f360a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f361b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f362c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f363d = d.p;

    f(f fVar) {
        if (fVar != null) {
            this.f360a = fVar.f360a;
            this.f361b = fVar.f361b;
            this.f362c = fVar.f362c;
            this.f363d = fVar.f363d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f361b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f360a;
        Drawable.ConstantState constantState = this.f361b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
