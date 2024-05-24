package b.a.m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import b.a.i;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f482a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f483b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f484c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f485d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f486e;

    public d() {
        super((Context) null);
    }

    public d(Context context, int i) {
        super(context);
        this.f482a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f483b = theme;
    }

    private Resources a() {
        Resources resources;
        if (this.f486e == null) {
            Configuration configuration = this.f485d;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            }
            this.f486e = resources;
        }
        return this.f486e;
    }

    private void c() {
        boolean z = this.f483b == null;
        if (z) {
            this.f483b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f483b.setTo(theme);
            }
        }
        d(this.f483b, this.f482a, z);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f482a;
    }

    /* access modifiers changed from: protected */
    public void d(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return a();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f484c == null) {
            this.f484c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f484c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f483b;
        if (theme != null) {
            return theme;
        }
        if (this.f482a == 0) {
            this.f482a = i.Theme_AppCompat_Light;
        }
        c();
        return this.f483b;
    }

    public void setTheme(int i) {
        if (this.f482a != i) {
            this.f482a = i;
            c();
        }
    }
}
