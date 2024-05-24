package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f350a = aVar.p(iconCompat.f350a, 1);
        iconCompat.f352c = aVar.j(iconCompat.f352c, 2);
        iconCompat.f353d = aVar.r(iconCompat.f353d, 3);
        iconCompat.f354e = aVar.p(iconCompat.f354e, 4);
        iconCompat.f355f = aVar.p(iconCompat.f355f, 5);
        iconCompat.g = (ColorStateList) aVar.r(iconCompat.g, 6);
        iconCompat.i = aVar.t(iconCompat.i, 7);
        iconCompat.i();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.j(aVar.f());
        int i = iconCompat.f350a;
        if (-1 != i) {
            aVar.F(i, 1);
        }
        byte[] bArr = iconCompat.f352c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f353d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i2 = iconCompat.f354e;
        if (i2 != 0) {
            aVar.F(i2, 4);
        }
        int i3 = iconCompat.f355f;
        if (i3 != 0) {
            aVar.F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            aVar.J(str, 7);
        }
    }
}
