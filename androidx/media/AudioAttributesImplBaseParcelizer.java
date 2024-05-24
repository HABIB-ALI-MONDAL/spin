package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f436a = aVar.p(cVar.f436a, 1);
        cVar.f437b = aVar.p(cVar.f437b, 2);
        cVar.f438c = aVar.p(cVar.f438c, 3);
        cVar.f439d = aVar.p(cVar.f439d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        aVar.x(false, false);
        aVar.F(cVar.f436a, 1);
        aVar.F(cVar.f437b, 2);
        aVar.F(cVar.f438c, 3);
        aVar.F(cVar.f439d, 4);
    }
}
