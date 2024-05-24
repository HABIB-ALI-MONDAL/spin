package b.d.j;

public class e<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f614a;

    /* renamed from: b  reason: collision with root package name */
    private int f615b;

    public e(int i) {
        if (i > 0) {
            this.f614a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t) {
        for (int i = 0; i < this.f615b; i++) {
            if (this.f614a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public boolean a(T t) {
        if (!c(t)) {
            int i = this.f615b;
            Object[] objArr = this.f614a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f615b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    public T b() {
        int i = this.f615b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.f614a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f615b = i - 1;
        return t;
    }
}
