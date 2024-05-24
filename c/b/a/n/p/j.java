package c.b.a.n.p;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<i>> f1066b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Map<String, String> f1067c;

    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        private static final String f1068b;

        /* renamed from: c  reason: collision with root package name */
        private static final Map<String, List<i>> f1069c;

        /* renamed from: a  reason: collision with root package name */
        private Map<String, List<i>> f1070a = f1069c;

        static {
            String b2 = b();
            f1068b = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b2)));
            }
            f1069c = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt <= 31 && charAt != 9) || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public j a() {
            return new j(this.f1070a);
        }
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f1071a;

        b(String str) {
            this.f1071a = str;
        }

        public String a() {
            return this.f1071a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f1071a.equals(((b) obj).f1071a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1071a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f1071a + '\'' + '}';
        }
    }

    j(Map<String, List<i>> map) {
        this.f1066b = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f1066b.entrySet()) {
            String b2 = b((List) next.getValue());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(next.getKey(), b2);
            }
        }
        return hashMap;
    }

    public Map<String, String> a() {
        if (this.f1067c == null) {
            synchronized (this) {
                if (this.f1067c == null) {
                    this.f1067c = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f1067c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f1066b.equals(((j) obj).f1066b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1066b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f1066b + '}';
    }
}
