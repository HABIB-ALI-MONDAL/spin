package c.d.a.b.e.e;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.b;
import javax.annotation.Nullable;

final class b6 implements y5 {

    /* renamed from: c  reason: collision with root package name */
    private static b6 f1583c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Context f1584a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ContentObserver f1585b;

    private b6() {
        this.f1584a = null;
        this.f1585b = null;
    }

    private b6(Context context) {
        this.f1584a = context;
        a6 a6Var = new a6(this, (Handler) null);
        this.f1585b = a6Var;
        context.getContentResolver().registerContentObserver(o5.f1704a, true, a6Var);
    }

    static b6 b(Context context) {
        b6 b6Var;
        synchronized (b6.class) {
            if (f1583c == null) {
                f1583c = b.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new b6(context) : new b6();
            }
            b6Var = f1583c;
        }
        return b6Var;
    }

    static synchronized void e() {
        Context context;
        synchronized (b6.class) {
            b6 b6Var = f1583c;
            if (!(b6Var == null || (context = b6Var.f1584a) == null || b6Var.f1585b == null)) {
                context.getContentResolver().unregisterContentObserver(f1583c.f1585b);
            }
            f1583c = null;
        }
    }

    @Nullable
    /* renamed from: c */
    public final String a(String str) {
        Context context = this.f1584a;
        if (context != null && !p5.a(context)) {
            try {
                return (String) w5.a(new z5(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e2) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e2);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String d(String str) {
        return o5.a(this.f1584a.getContentResolver(), str, (String) null);
    }
}
