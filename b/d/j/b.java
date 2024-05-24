package b.d.j;

import android.util.Log;
import java.io.Writer;

public class b extends Writer {
    private final String j;
    private StringBuilder k = new StringBuilder(128);

    public b(String str) {
        this.j = str;
    }

    private void c() {
        if (this.k.length() > 0) {
            Log.d(this.j, this.k.toString());
            StringBuilder sb = this.k;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        c();
    }

    public void flush() {
        c();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == 10) {
                c();
            } else {
                this.k.append(c2);
            }
        }
    }
}
