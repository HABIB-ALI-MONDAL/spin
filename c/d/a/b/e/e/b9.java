package c.d.a.b.e.e;

public enum b9 {
    VOID(Void.class, Void.class, (Class) null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(r7.class, r7.class, r7.k),
    ENUM(r1, Integer.class, (Class) null),
    MESSAGE(Object.class, Object.class, (Class) null);
    
    private final Class j;
    private final Object k;

    private b9(Class cls, Class cls2, Object obj) {
        this.j = cls2;
        this.k = obj;
    }

    public final Class d() {
        return this.j;
    }
}
