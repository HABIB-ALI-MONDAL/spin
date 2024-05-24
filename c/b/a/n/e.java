package c.b.a.n;

import java.io.IOException;

public final class e extends IOException {
    public e(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, (Throwable) null);
    }

    public e(String str, int i, Throwable th) {
        super(str, th);
    }
}
