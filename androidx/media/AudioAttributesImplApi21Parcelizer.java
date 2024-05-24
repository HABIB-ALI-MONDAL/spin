package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.a;

public final class AudioAttributesImplApi21Parcelizer {
    public static b read(a aVar) {
        b bVar = new b();
        bVar.f434a = (AudioAttributes) aVar.r(bVar.f434a, 1);
        bVar.f435b = aVar.p(bVar.f435b, 2);
        return bVar;
    }

    public static void write(b bVar, a aVar) {
        aVar.x(false, false);
        aVar.H(bVar.f434a, 1);
        aVar.F(bVar.f435b, 2);
    }
}
