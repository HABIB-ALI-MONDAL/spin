package c.d.a.b.e.e;

import c.d.a.b.e.e.c7;
import c.d.a.b.e.e.d7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class d7<MessageType extends d7<MessageType, BuilderType>, BuilderType extends c7<MessageType, BuilderType>> implements x9 {
    protected int zzb = 0;

    protected static void j(Iterable iterable, List list) {
        y8.e(iterable);
        if (iterable instanceof e9) {
            List f2 = ((e9) iterable).f();
            e9 e9Var = (e9) list;
            int size = list.size();
            for (Object next : f2) {
                if (next == null) {
                    int size2 = e9Var.size();
                    String str = "Element at index " + (size2 - size) + " is null.";
                    int size3 = e9Var.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            e9Var.remove(size3);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof r7) {
                    e9Var.n((r7) next);
                } else {
                    e9Var.add((String) next);
                }
            }
        } else if (!(iterable instanceof ea)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size();
                    String str2 = "Element at index " + (size5 - size4) + " is null.";
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 >= size4) {
                            list.remove(size6);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    public final r7 b() {
        try {
            int e2 = e();
            r7 r7Var = r7.k;
            byte[] bArr = new byte[e2];
            z7 c2 = z7.c(bArr);
            a(c2);
            c2.d();
            return new q7(bArr);
        } catch (IOException e3) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e3);
        }
    }

    /* access modifiers changed from: package-private */
    public int i(ia iaVar) {
        throw null;
    }

    public final byte[] k() {
        try {
            byte[] bArr = new byte[e()];
            z7 c2 = z7.c(bArr);
            a(c2);
            c2.d();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e2);
        }
    }
}
