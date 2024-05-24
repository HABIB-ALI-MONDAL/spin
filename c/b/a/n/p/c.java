package c.b.a.n.p;

import android.util.Log;
import c.b.a.n.d;
import c.b.a.n.j;
import c.b.a.t.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c implements d<ByteBuffer> {
    /* renamed from: c */
    public boolean a(ByteBuffer byteBuffer, File file, j jVar) {
        try {
            a.d(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
