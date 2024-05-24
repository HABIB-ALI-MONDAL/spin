package c.d.a.b.h;

public final class b extends IllegalStateException {
    private b(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(i<?> iVar) {
        if (!iVar.l()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception h = iVar.h();
        return new b("Complete with: ".concat(h != null ? "failure" : iVar.m() ? "result ".concat(String.valueOf(String.valueOf(iVar.i()))) : iVar.k() ? "cancellation" : "unknown issue"), h);
    }
}
