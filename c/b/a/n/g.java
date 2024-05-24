package c.b.a.n;

import c.b.a.n.f;
import c.b.a.n.o.z.b;
import c.b.a.n.q.c.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class g {
    public static int a(List<f> list, InputStream inputStream, b bVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new q(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                int b2 = list.get(i).b(inputStream, bVar);
                if (b2 != -1) {
                    return b2;
                }
                i++;
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static f.a b(List<f> list, InputStream inputStream, b bVar) {
        if (inputStream == null) {
            return f.a.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new q(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int i = 0;
        int size = list.size();
        while (i < size) {
            try {
                f.a c2 = list.get(i).c(inputStream);
                if (c2 != f.a.UNKNOWN) {
                    return c2;
                }
                i++;
            } finally {
                inputStream.reset();
            }
        }
        return f.a.UNKNOWN;
    }

    public static f.a c(List<f> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return f.a.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            f.a a2 = list.get(i).a(byteBuffer);
            if (a2 != f.a.UNKNOWN) {
                return a2;
            }
        }
        return f.a.UNKNOWN;
    }
}
