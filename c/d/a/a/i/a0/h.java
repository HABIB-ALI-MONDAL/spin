package c.d.a.a.i.a0;

import android.content.Context;
import android.os.Build;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.c0.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.p;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;

public abstract class h {
    static y a(Context context, j0 j0Var, t tVar, a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new s(context, j0Var, tVar) : new p(context, j0Var, aVar, tVar);
    }
}
