package f.a.a.e;

import f.a.a.b.a;
import f.a.a.e.b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class c implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private a f3118a;

    /* renamed from: b  reason: collision with root package name */
    private a f3119b;

    private c(a aVar) {
        this.f3119b = aVar;
    }

    public static c b(a aVar) {
        return new c(aVar);
    }

    public Object a(a aVar) {
        this.f3118a = aVar;
        return Proxy.newProxyInstance(aVar.getClass().getClassLoader(), aVar.getClass().getInterfaces(), this);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        b.c invoke = this.f3119b.invoke(new f.a.a.d.b(obj, method, objArr));
        if ((obj instanceof a) && !b.c.NOT_NEED.equals(invoke)) {
            ((a) obj).f(invoke);
        }
        return method.invoke(this.f3118a, objArr);
    }
}
