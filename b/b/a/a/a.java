package b.b.a.a;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f517c;

    /* renamed from: a  reason: collision with root package name */
    private c f518a;

    /* renamed from: b  reason: collision with root package name */
    private c f519b;

    private a() {
        b bVar = new b();
        this.f519b = bVar;
        this.f518a = bVar;
    }

    public static a b() {
        if (f517c != null) {
            return f517c;
        }
        synchronized (a.class) {
            if (f517c == null) {
                f517c = new a();
            }
        }
        return f517c;
    }

    public boolean a() {
        return this.f518a.a();
    }
}
