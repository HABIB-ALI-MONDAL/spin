package b.j.a;

import androidx.lifecycle.g;
import androidx.lifecycle.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends g & t> a b(T t) {
        return new b(t, ((t) t).g());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
