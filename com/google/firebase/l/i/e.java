package com.google.firebase.l.i;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.l.b;
import com.google.firebase.l.c;
import com.google.firebase.l.d;
import com.google.firebase.l.f;
import com.google.firebase.l.g;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class e implements com.google.firebase.l.e, g {

    /* renamed from: a  reason: collision with root package name */
    private e f2849a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2850b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f2851c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, d<?>> f2852d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, f<?>> f2853e;

    /* renamed from: f  reason: collision with root package name */
    private final d<Object> f2854f;
    private final boolean g;

    e(Writer writer, Map<Class<?>, d<?>> map, Map<Class<?>, f<?>> map2, d<Object> dVar, boolean z) {
        this.f2851c = new JsonWriter(writer);
        this.f2852d = map;
        this.f2853e = map2;
        this.f2854f = dVar;
        this.g = z;
    }

    private boolean o(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e r(String str, Object obj) {
        t();
        this.f2851c.name(str);
        if (obj != null) {
            return h(obj, false);
        }
        this.f2851c.nullValue();
        return this;
    }

    private e s(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        t();
        this.f2851c.name(str);
        return h(obj, false);
    }

    private void t() {
        if (this.f2850b) {
            e eVar = this.f2849a;
            if (eVar != null) {
                eVar.t();
                this.f2849a.f2850b = false;
                this.f2849a = null;
                this.f2851c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public /* bridge */ /* synthetic */ g a(String str) {
        i(str);
        return this;
    }

    public /* bridge */ /* synthetic */ g b(boolean z) {
        m(z);
        return this;
    }

    public com.google.firebase.l.e c(c cVar, long j) {
        k(cVar.b(), j);
        return this;
    }

    public com.google.firebase.l.e d(c cVar, int i) {
        j(cVar.b(), i);
        return this;
    }

    public com.google.firebase.l.e e(c cVar, Object obj) {
        return l(cVar.b(), obj);
    }

    public e f(int i) {
        t();
        this.f2851c.value((long) i);
        return this;
    }

    public e g(long j) {
        t();
        this.f2851c.value(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    public e h(Object obj, boolean z) {
        int i = 0;
        if (z && o(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new b(String.format("%s cannot be encoded inline", objArr));
        } else if (obj == null) {
            this.f2851c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f2851c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                n((byte[]) obj);
                return this;
            }
            this.f2851c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i < length) {
                    this.f2851c.value((long) iArr[i]);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i < length2) {
                    g(jArr[i]);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i < length3) {
                    this.f2851c.value(dArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i < length4) {
                    this.f2851c.value(zArr[i]);
                    i++;
                }
            } else if (obj instanceof Number[]) {
                for (Number h : (Number[]) obj) {
                    h(h, false);
                }
            } else {
                for (Object h2 : (Object[]) obj) {
                    h(h2, false);
                }
            }
            this.f2851c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f2851c.beginArray();
            for (Object h3 : (Collection) obj) {
                h(h3, false);
            }
            this.f2851c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f2851c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    l((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e2);
                }
            }
            this.f2851c.endObject();
            return this;
        } else {
            d dVar = this.f2852d.get(obj.getClass());
            if (dVar != null) {
                q(dVar, obj, z);
                return this;
            }
            f fVar = this.f2853e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                i(((Enum) obj).name());
                return this;
            } else {
                q(this.f2854f, obj, z);
                return this;
            }
        }
    }

    public e i(String str) {
        t();
        this.f2851c.value(str);
        return this;
    }

    public e j(String str, int i) {
        t();
        this.f2851c.name(str);
        f(i);
        return this;
    }

    public e k(String str, long j) {
        t();
        this.f2851c.name(str);
        g(j);
        return this;
    }

    public e l(String str, Object obj) {
        return this.g ? s(str, obj) : r(str, obj);
    }

    public e m(boolean z) {
        t();
        this.f2851c.value(z);
        return this;
    }

    public e n(byte[] bArr) {
        t();
        if (bArr == null) {
            this.f2851c.nullValue();
        } else {
            this.f2851c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        t();
        this.f2851c.flush();
    }

    /* access modifiers changed from: package-private */
    public e q(d<Object> dVar, Object obj, boolean z) {
        if (!z) {
            this.f2851c.beginObject();
        }
        dVar.a(obj, this);
        if (!z) {
            this.f2851c.endObject();
        }
        return this;
    }
}
