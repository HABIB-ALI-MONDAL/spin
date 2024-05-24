package c.b.a.n.q.c;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f1140a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final j f1141b;

    /* renamed from: c  reason: collision with root package name */
    public static final j f1142c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final j f1143d;

    private static class a extends j {
        a() {
        }

        public d a(int i, int i2, int i3, int i4) {
            return d.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, j.f1140a.b(i, i2, i3, i4));
        }
    }

    private static class b extends j {
        b() {
        }

        public d a(int i, int i2, int i3, int i4) {
            return d.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    private static class c extends j {
        c() {
        }

        public d a(int i, int i2, int i3, int i4) {
            return d.QUALITY;
        }

        public float b(int i, int i2, int i3, int i4) {
            return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    public enum d {
        MEMORY,
        QUALITY
    }

    static {
        b bVar = new b();
        f1141b = bVar;
        f1143d = bVar;
    }

    public abstract d a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
