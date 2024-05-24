package c.d.a.b.e.e;

final class ha implements u9 {

    /* renamed from: a  reason: collision with root package name */
    private final x9 f1647a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1648b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f1649c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1650d;

    ha(x9 x9Var, String str, Object[] objArr) {
        this.f1647a = x9Var;
        this.f1648b = str;
        this.f1649c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f1650d = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f1650d = c2 | (charAt2 << i);
                return;
            }
        }
    }

    public final x9 a() {
        return this.f1647a;
    }

    public final boolean b() {
        return (this.f1650d & 2) == 2;
    }

    public final int c() {
        return (this.f1650d & 1) == 1 ? 1 : 2;
    }

    /* access modifiers changed from: package-private */
    public final String d() {
        return this.f1648b;
    }

    /* access modifiers changed from: package-private */
    public final Object[] e() {
        return this.f1649c;
    }
}
