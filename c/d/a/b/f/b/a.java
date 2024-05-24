package c.d.a.b.f.b;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.b;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.l0;
import com.google.android.gms.common.internal.n;

public class a extends g<g> implements c.d.a.b.f.g {
    public static final /* synthetic */ int E = 0;
    private final boolean A = true;
    private final d B;
    private final Bundle C;
    private final Integer D;

    public a(Context context, Looper looper, boolean z, d dVar, Bundle bundle, f fVar, com.google.android.gms.common.api.g gVar) {
        super(context, looper, 44, dVar, fVar, gVar);
        this.B = dVar;
        this.C = bundle;
        this.D = dVar.g();
    }

    public static Bundle l0(d dVar) {
        dVar.f();
        Integer g = dVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (g != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        if (!y().getPackageName().equals(this.B.d())) {
            this.C.putString("com.google.android.gms.signin.internal.realClientPackageName", this.B.d());
        }
        return this.C;
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean l() {
        return this.A;
    }

    public final void m() {
        i(new c.d());
    }

    public final void o(f fVar) {
        n.j(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.B.b();
            GoogleSignInAccount b3 = "<<default account>>".equals(b2.name) ? com.google.android.gms.auth.api.signin.a.a.a(y()).b() : null;
            Integer num = this.D;
            n.i(num);
            ((g) D()).b0(new j(1, new j0(b2, num.intValue(), b3)), fVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.R(new l(1, new b(8, (PendingIntent) null), (l0) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public final int p() {
        return i.f2162a;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new g(iBinder);
    }
}
