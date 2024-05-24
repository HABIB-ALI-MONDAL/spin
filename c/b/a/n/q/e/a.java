package c.b.a.n.q.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.c.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f1177a = true;

    public static Drawable a(Context context, int i) {
        return b(context, i, (Resources.Theme) null);
    }

    public static Drawable b(Context context, int i, Resources.Theme theme) {
        try {
            if (f1177a) {
                return d(context, i);
            }
        } catch (NoClassDefFoundError unused) {
            f1177a = false;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context.getTheme();
        }
        return c(context, i, theme);
    }

    private static Drawable c(Context context, int i, Resources.Theme theme) {
        return f.a(context.getResources(), i, theme);
    }

    private static Drawable d(Context context, int i) {
        return b.a.k.a.a.d(context, i);
    }
}
