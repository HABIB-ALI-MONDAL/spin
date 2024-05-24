package c.d.a.b.e.e;

final class pb extends IllegalArgumentException {
    pb(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
