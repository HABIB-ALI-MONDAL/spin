package b.d.g;

import android.os.LocaleList;
import java.util.Locale;

final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f571a;

    e(LocaleList localeList) {
        this.f571a = localeList;
    }

    public Object a() {
        return this.f571a;
    }

    public boolean equals(Object obj) {
        return this.f571a.equals(((d) obj).a());
    }

    public Locale get(int i) {
        return this.f571a.get(i);
    }

    public int hashCode() {
        return this.f571a.hashCode();
    }

    public String toString() {
        return this.f571a.toString();
    }
}
