package c.d.a.b.e.e;

import android.net.Uri;
import b.c.g;
import javax.annotation.Nullable;

public final class v5 {

    /* renamed from: a  reason: collision with root package name */
    private final g f1771a;

    v5(g gVar) {
        this.f1771a = gVar;
    }

    @Nullable
    public final String a(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri == null) {
            return null;
        }
        g gVar = (g) this.f1771a.get(uri.toString());
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(String.valueOf(str3)));
    }
}
