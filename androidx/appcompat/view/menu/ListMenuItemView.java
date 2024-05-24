package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.t0;
import b.a.a;
import b.a.f;
import b.a.g;
import b.a.j;

public class ListMenuItemView extends LinearLayout implements p.a, AbsListView.SelectionBoundsAdjuster {
    private j j;
    private ImageView k;
    private RadioButton l;
    private TextView m;
    private CheckBox n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private LinearLayout r;
    private Drawable s;
    private int t;
    private Context u;
    private boolean v;
    private Drawable w;
    private boolean x;
    private LayoutInflater y;
    private boolean z;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        t0 t2 = t0.t(getContext(), attributeSet, j.R1, i, 0);
        this.s = t2.f(j.T1);
        this.t = t2.m(j.S1, -1);
        this.v = t2.a(j.U1, false);
        this.u = context;
        this.w = t2.f(j.V1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.dropDownListViewStyle, 0);
        this.x = obtainStyledAttributes.hasValue(0);
        t2.u();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i) {
        LinearLayout linearLayout = this.r;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        this.n = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        this.k = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        this.l = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.y == null) {
            this.y = LayoutInflater.from(getContext());
        }
        return this.y;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.q;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
            rect.top += this.q.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public boolean c() {
        return false;
    }

    public void d(j jVar, int i) {
        this.j = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.i(this));
        setCheckable(jVar.isCheckable());
        h(jVar.A(), jVar.g());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    public j getItemData() {
        return this.j;
    }

    public void h(boolean z2, char c2) {
        int i = (!z2 || !this.j.A()) ? 8 : 0;
        if (i == 0) {
            this.o.setText(this.j.h());
        }
        if (this.o.getVisibility() != i) {
            this.o.setVisibility(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        b.d.k.p.D(this, this.s);
        TextView textView = (TextView) findViewById(f.M);
        this.m = textView;
        int i = this.t;
        if (i != -1) {
            textView.setTextAppearance(this.u, i);
        }
        this.o = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.p = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.w);
        }
        this.q = (ImageView) findViewById(f.group_divider);
        this.r = (LinearLayout) findViewById(f.content);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.k != null && this.v) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z2 || this.l != null || this.n != null) {
            if (this.j.m()) {
                if (this.l == null) {
                    g();
                }
                compoundButton2 = this.l;
                compoundButton = this.n;
            } else {
                if (this.n == null) {
                    e();
                }
                compoundButton2 = this.n;
                compoundButton = this.l;
            }
            if (z2) {
                compoundButton2.setChecked(this.j.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.n;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.l;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.j.m()) {
            if (this.l == null) {
                g();
            }
            compoundButton = this.l;
        } else {
            if (this.n == null) {
                e();
            }
            compoundButton = this.n;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.z = z2;
        this.v = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setVisibility((this.x || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2 = this.j.z() || this.z;
        if (z2 || this.v) {
            ImageView imageView = this.k;
            if (imageView != null || drawable != null || this.v) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.v) {
                    ImageView imageView2 = this.k;
                    if (!z2) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.k.getVisibility() != 0) {
                        this.k.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.k.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i;
        if (charSequence != null) {
            this.m.setText(charSequence);
            if (this.m.getVisibility() != 0) {
                textView = this.m;
                i = 0;
            } else {
                return;
            }
        } else {
            i = 8;
            if (this.m.getVisibility() != 8) {
                textView = this.m;
            } else {
                return;
            }
        }
        textView.setVisibility(i);
    }
}
