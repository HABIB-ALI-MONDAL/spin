package c.d.a.a.i.z;

public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) {
        TResult a2;
        if (i < 1) {
            return aVar.a(tinput);
        }
        do {
            a2 = aVar.a(tinput);
            tinput = cVar.a(tinput, a2);
            if (tinput == null || i - 1 < 1) {
                return a2;
            }
            a2 = aVar.a(tinput);
            tinput = cVar.a(tinput, a2);
            break;
        } while (i - 1 < 1);
        return a2;
    }
}
