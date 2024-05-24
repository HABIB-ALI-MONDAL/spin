package c.d.a.b.e.e;

import android.net.Uri;
import javax.annotation.Nullable;

public final class m6 {

    /* renamed from: a  reason: collision with root package name */
    final String f1685a;

    /* renamed from: b  reason: collision with root package name */
    final Uri f1686b;

    /* renamed from: c  reason: collision with root package name */
    final String f1687c;

    /* renamed from: d  reason: collision with root package name */
    final String f1688d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f1689e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f1690f;
    final boolean g;
    final boolean h;
    @Nullable
    final u6 i;

    public m6(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (u6) null);
    }

    private m6(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable u6 u6Var) {
        this.f1685a = null;
        this.f1686b = uri;
        this.f1687c = "";
        this.f1688d = "";
        this.f1689e = z;
        this.f1690f = false;
        this.g = z3;
        this.h = false;
        this.i = null;
    }

    public final m6 a() {
        return new m6((String) null, this.f1686b, this.f1687c, this.f1688d, this.f1689e, false, true, false, (u6) null);
    }

    public final m6 b() {
        if (this.f1687c.isEmpty()) {
            return new m6((String) null, this.f1686b, this.f1687c, this.f1688d, true, false, this.g, false, (u6) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final q6 c(String str, double d2) {
        return new k6(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final q6 d(String str, long j) {
        return new i6(this, str, Long.valueOf(j), true);
    }

    public final q6 e(String str, String str2) {
        return new l6(this, str, str2, true);
    }

    public final q6 f(String str, boolean z) {
        return new j6(this, str, Boolean.valueOf(z), true);
    }
}
