package c.d.a.b.e.e;

import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;

final class q5 extends n6 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1728a;

    /* renamed from: b  reason: collision with root package name */
    private final x6 f1729b;

    q5(Context context, @Nullable x6 x6Var) {
        Objects.requireNonNull(context, "Null context");
        this.f1728a = context;
        this.f1729b = x6Var;
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f1728a;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final x6 b() {
        return this.f1729b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n6) {
            n6 n6Var = (n6) obj;
            if (this.f1728a.equals(n6Var.a())) {
                x6 x6Var = this.f1729b;
                x6 b2 = n6Var.b();
                if (x6Var != null ? x6Var.equals(b2) : b2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f1728a.hashCode() ^ 1000003) * 1000003;
        x6 x6Var = this.f1729b;
        return hashCode ^ (x6Var == null ? 0 : x6Var.hashCode());
    }

    public final String toString() {
        String obj = this.f1728a.toString();
        String valueOf = String.valueOf(this.f1729b);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }
}
