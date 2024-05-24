package c.b.a.n;

import c.b.a.n.o.z.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface f {

    public enum a {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean j;

        private a(boolean z) {
            this.j = z;
        }

        public boolean d() {
            return this.j;
        }
    }

    a a(ByteBuffer byteBuffer);

    int b(InputStream inputStream, b bVar);

    a c(InputStream inputStream);
}
