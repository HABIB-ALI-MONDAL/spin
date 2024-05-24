package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final b.c.a<String, Method> f451a;

    /* renamed from: b  reason: collision with root package name */
    protected final b.c.a<String, Method> f452b;

    /* renamed from: c  reason: collision with root package name */
    protected final b.c.a<String, Class> f453c;

    public a(b.c.a<String, Method> aVar, b.c.a<String, Method> aVar2, b.c.a<String, Class> aVar3) {
        this.f451a = aVar;
        this.f452b = aVar2;
        this.f453c = aVar3;
    }

    private void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Class c(Class<? extends c> cls) {
        Class cls2 = this.f453c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f453c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Class<a> cls = a.class;
        Method method = this.f451a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f451a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) {
        Method method = this.f452b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f452b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i) {
        w(i);
        A(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i) {
        w(i);
        C(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void E(int i);

    public void F(int i, int i2) {
        w(i2);
        E(i);
    }

    /* access modifiers changed from: protected */
    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i) {
        w(i);
        G(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void I(String str);

    public void J(String str, int i) {
        w(i);
        I(str);
    }

    /* access modifiers changed from: protected */
    public <T extends c> void K(T t, a aVar) {
        try {
            e(t.getClass()).invoke((Object) null, new Object[]{t, aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public void L(c cVar) {
        if (cVar == null) {
            I((String) null);
            return;
        }
        N(cVar);
        a b2 = b();
        K(cVar, b2);
        b2.a();
    }

    public void M(c cVar, int i) {
        w(i);
        L(cVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract a b();

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    public boolean h(boolean z, int i) {
        return !m(i) ? z : g();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i) {
        return !m(i) ? bArr : i();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i) {
        return !m(i) ? charSequence : k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean m(int i);

    /* access modifiers changed from: protected */
    public <T extends c> T n(String str, a aVar) {
        try {
            return (c) d(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int o();

    public int p(int i, int i2) {
        return !m(i2) ? i : o();
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t, int i) {
        return !m(i) ? t : q();
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    public String t(String str, int i) {
        return !m(i) ? str : s();
    }

    /* access modifiers changed from: protected */
    public <T extends c> T u() {
        String s = s();
        if (s == null) {
            return null;
        }
        return n(s, b());
    }

    public <T extends c> T v(T t, int i) {
        return !m(i) ? t : u();
    }

    /* access modifiers changed from: protected */
    public abstract void w(int i);

    public void x(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void y(boolean z);

    public void z(boolean z, int i) {
        w(i);
        y(z);
    }
}
