package c.d.a.b.d;

import android.os.IBinder;
import c.d.a.b.d.a;
import com.google.android.gms.common.internal.n;
import java.lang.reflect.Field;

public final class b<T> extends a.C0064a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1553a;

    private b(Object obj) {
        this.f1553a = obj;
    }

    public static <T> a b0(T t) {
        return new b(t);
    }

    public static <T> T k(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f1553a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i == 1) {
            n.i(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e2) {
                    throw new IllegalArgumentException("Binder object is null.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
    }
}
