package org.cocos2dx.okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f3236a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3237b;

    /* renamed from: c  reason: collision with root package name */
    private final Class[] f3238c;

    d(Class<?> cls, String str, Class... clsArr) {
        this.f3236a = cls;
        this.f3237b = str;
        this.f3238c = clsArr;
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f3237b;
        if (str == null) {
            return null;
        }
        Method b2 = b(cls, str, this.f3238c);
        if (b2 == null || (cls2 = this.f3236a) == null || cls2.isAssignableFrom(b2.getReturnType())) {
            return b2;
        }
        return null;
    }

    private static Method b(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object c(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 != null) {
            try {
                return a2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a2);
                assertionError.initCause(e2);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f3237b + " not supported for object " + t);
        }
    }

    public Object d(T t, Object... objArr) {
        Method a2 = a(t.getClass());
        if (a2 == null) {
            return null;
        }
        try {
            return a2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(T t, Object... objArr) {
        try {
            return d(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(T t, Object... objArr) {
        try {
            return c(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean g(T t) {
        return a(t.getClass()) != null;
    }
}
