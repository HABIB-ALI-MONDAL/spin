package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import java.lang.reflect.Method;

public class j0 extends h0 implements i0 {
    private static Method S;
    private i0 R;

    public static class a extends d0 {
        private MenuItem A;
        final int x;
        final int y;
        private i0 z;

        public a(Context context, boolean z2) {
            super(context, z2);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.x = 22;
                this.y = 21;
                return;
            }
            this.x = 21;
            this.y = 22;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            int pointToPosition;
            int i2;
            if (this.z != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                }
                g gVar = (g) adapter;
                j jVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < gVar.getCount()) {
                    jVar = gVar.getItem(i2);
                }
                MenuItem menuItem = this.A;
                if (menuItem != jVar) {
                    h b2 = gVar.b();
                    if (menuItem != null) {
                        this.z.c(b2, menuItem);
                    }
                    this.A = jVar;
                    if (jVar != null) {
                        this.z.a(b2, jVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.x) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.y) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((g) getAdapter()).b().e(false);
                return true;
            }
        }

        public void setHoverListener(i0 i0Var) {
            this.z = i0Var;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        try {
            S = cls.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public j0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void J(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.N.setEnterTransition((Transition) obj);
        }
    }

    public void K(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.N.setExitTransition((Transition) obj);
        }
    }

    public void L(i0 i0Var) {
        this.R = i0Var;
    }

    public void M(boolean z) {
        Method method = S;
        if (method != null) {
            try {
                method.invoke(this.N, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    public void a(h hVar, MenuItem menuItem) {
        i0 i0Var = this.R;
        if (i0Var != null) {
            i0Var.a(hVar, menuItem);
        }
    }

    public void c(h hVar, MenuItem menuItem) {
        i0 i0Var = this.R;
        if (i0Var != null) {
            i0Var.c(hVar, menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    public d0 h(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
