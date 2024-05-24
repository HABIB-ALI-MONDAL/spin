package c.d.a.b.e.e;

import android.util.Log;
import javax.annotation.Nullable;

final class k6 extends q6 {
    k6(m6 m6Var, String str, Double d2, boolean z) {
        super(m6Var, "measurement.test.double_flag", d2, true, (p6) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String c2 = super.c();
            Log.e("PhenotypeFlag", "Invalid double value for " + c2 + ": " + ((String) obj));
            return null;
        }
    }
}
