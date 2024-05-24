package b.d.k;

import android.os.Build;
import android.view.ViewGroup;
import b.d.c;

public final class r {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(c.g);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && p.m(viewGroup) == null) ? false : true;
    }
}
