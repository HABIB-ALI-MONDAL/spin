package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.d.f.a.a;
import b.d.f.a.b;
import b.d.f.a.c;

public final class q {
    public static Menu a(Context context, a aVar) {
        return new r(context, aVar);
    }

    public static MenuItem b(Context context, b bVar) {
        return Build.VERSION.SDK_INT >= 16 ? new l(context, bVar) : new k(context, bVar);
    }

    public static SubMenu c(Context context, c cVar) {
        return new v(context, cVar);
    }
}
