package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class m {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f2211a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final Object f2212b;

        /* synthetic */ a(Object obj, u0 u0Var) {
            n.i(obj);
            this.f2212b = obj;
        }

        public a a(String str, Object obj) {
            List list = this.f2211a;
            n.i(str);
            String valueOf = String.valueOf(obj);
            list.add(str + "=" + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f2212b.getClass().getSimpleName());
            sb.append('{');
            int size = this.f2211a.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) this.f2211a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, (u0) null);
    }
}
