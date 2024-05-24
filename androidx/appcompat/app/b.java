package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;

public class b extends g implements DialogInterface {
    final AlertController l = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f77a;

        /* renamed from: b  reason: collision with root package name */
        private final int f78b;

        public a(Context context) {
            this(context, b.e(context, 0));
        }

        public a(Context context, int i) {
            this.f77a = new AlertController.f(new ContextThemeWrapper(context, b.e(context, i)));
            this.f78b = i;
        }

        public b a() {
            b bVar = new b(this.f77a.f64a, this.f78b);
            this.f77a.a(bVar.l);
            bVar.setCancelable(this.f77a.r);
            if (this.f77a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f77a.s);
            bVar.setOnDismissListener(this.f77a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f77a.u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f77a.f64a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f77a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f77a.g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f77a.f67d = drawable;
            return this;
        }

        public a f(DialogInterface.OnKeyListener onKeyListener) {
            this.f77a.u = onKeyListener;
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f77a.f69f = charSequence;
            return this;
        }
    }

    protected b(Context context, int i) {
        super(context, e(context, i));
    }

    static int e(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l.d();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.l.f(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.l.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.l.p(charSequence);
    }
}
