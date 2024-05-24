package c.d.a.b.c;

import android.os.Bundle;
import android.util.Log;
import c.d.a.b.h.a;
import c.d.a.b.h.i;
import java.io.IOException;

public final /* synthetic */ class a0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a0 f1515a = new a0();

    private /* synthetic */ a0() {
    }

    public final Object a(i iVar) {
        if (iVar.m()) {
            return (Bundle) iVar.i();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(iVar.h());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Error making request: ");
            sb.append(valueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", iVar.h());
    }
}
