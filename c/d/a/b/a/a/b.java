package c.d.a.b.a.a;

import android.net.Uri;
import java.util.Map;

final class b extends Thread {
    final /* synthetic */ Map j;

    b(a aVar, Map map) {
        this.j = map;
    }

    public final void run() {
        Map map = this.j;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        d.a(buildUpon.build().toString());
    }
}
