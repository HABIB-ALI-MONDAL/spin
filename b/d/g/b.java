package b.d.g;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private d f568a;

    static {
        a(new Locale[0]);
    }

    private b(d dVar) {
        this.f568a = dVar;
    }

    public static b a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? d(new LocaleList(localeArr)) : new b(new c(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static b d(LocaleList localeList) {
        return new b(new e(localeList));
    }

    public Locale c(int i) {
        return this.f568a.get(i);
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.f568a.equals(((b) obj).f568a);
    }

    public int hashCode() {
        return this.f568a.hashCode();
    }

    public String toString() {
        return this.f568a.toString();
    }
}
