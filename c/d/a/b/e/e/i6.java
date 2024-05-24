package c.d.a.b.e.e;

import android.util.Log;
import javax.annotation.Nullable;

final class i6 extends q6 {
    i6(m6 m6Var, String str, Long l, boolean z) {
        super(m6Var, str, l, true, (p6) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String c2 = super.c();
            Log.e("PhenotypeFlag", "Invalid long value for " + c2 + ": " + ((String) obj));
            return null;
        }
    }
}
