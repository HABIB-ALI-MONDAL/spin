package c.d.a.b.e.e;

import android.os.Binder;

public final /* synthetic */ class w5 {
    public static Object a(x5 x5Var) {
        long clearCallingIdentity;
        try {
            return x5Var.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object a2 = x5Var.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
