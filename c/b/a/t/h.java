package c.b.a.t;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class h {
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T c(T t) {
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static <T> T d(T t) {
        e(t, "Argument must not be null");
        return t;
    }

    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
