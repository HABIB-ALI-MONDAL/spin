package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class a {

    /* renamed from: c  reason: collision with root package name */
    static a f407c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, C0016a> f408a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f409b = new HashMap();

    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    static class C0016a {

        /* renamed from: a  reason: collision with root package name */
        final Map<d.b, List<b>> f410a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, d.b> f411b;

        C0016a(Map<b, d.b> map) {
            this.f411b = map;
            for (Map.Entry next : map.entrySet()) {
                d.b bVar = (d.b) next.getValue();
                List list = this.f410a.get(bVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f410a.put(bVar, list);
                }
                list.add(next.getKey());
            }
        }

        private static void b(List<b> list, g gVar, d.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(gVar, bVar, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(g gVar, d.b bVar, Object obj) {
            b(this.f410a.get(bVar), gVar, bVar, obj);
            b(this.f410a.get(d.b.ON_ANY), gVar, bVar, obj);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f412a;

        /* renamed from: b  reason: collision with root package name */
        final Method f413b;

        b(int i, Method method) {
            this.f412a = i;
            this.f413b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(g gVar, d.b bVar, Object obj) {
            try {
                int i = this.f412a;
                if (i == 0) {
                    this.f413b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f413b.invoke(obj, new Object[]{gVar});
                } else if (i == 2) {
                    this.f413b.invoke(obj, new Object[]{gVar, bVar});
                }
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f412a == bVar.f412a && this.f413b.getName().equals(bVar.f413b.getName());
        }

        public int hashCode() {
            return (this.f412a * 31) + this.f413b.getName().hashCode();
        }
    }

    a() {
    }

    private C0016a a(Class<?> cls, Method[] methodArr) {
        int i;
        C0016a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c2 = c(superclass)) == null)) {
            hashMap.putAll(c2.f411b);
        }
        for (Class c3 : cls.getInterfaces()) {
            for (Map.Entry next : c(c3).f411b.entrySet()) {
                e(hashMap, (b) next.getKey(), (d.b) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(g.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                d.b value = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == d.b.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0016a aVar = new C0016a(hashMap);
        this.f408a.put(cls, aVar);
        this.f409b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<b, d.b> map, b bVar, d.b bVar2, Class<?> cls) {
        d.b bVar3 = map.get(bVar);
        if (bVar3 != null && bVar2 != bVar3) {
            Method method = bVar.f413b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
        } else if (bVar3 == null) {
            map.put(bVar, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    public C0016a c(Class<?> cls) {
        C0016a aVar = this.f408a.get(cls);
        return aVar != null ? aVar : a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f409b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method annotation : b2) {
            if (((n) annotation.getAnnotation(n.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f409b.put(cls, Boolean.FALSE);
        return false;
    }
}
