package f.a.a.b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import f.a.a.d.j;
import f.a.a.d.k;
import f.a.a.e.b;

public interface a {

    /* renamed from: f.a.a.b.a$a  reason: collision with other inner class name */
    public interface C0080a {
        void takeCancel();

        void takeFail(j jVar, String str);

        void takeSuccess(j jVar);
    }

    void a(Uri uri, f.a.a.d.a aVar);

    void b(Uri uri);

    void c(k kVar);

    void d(Uri uri, f.a.a.d.a aVar);

    void e(f.a.a.c.a aVar, boolean z);

    void f(b.c cVar);

    void g();

    void h(Bundle bundle);

    void onActivityResult(int i, int i2, Intent intent);

    void onSaveInstanceState(Bundle bundle);
}
