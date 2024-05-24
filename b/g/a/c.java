package b.g.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class c extends d implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    int h0 = 0;
    int i0 = 0;
    boolean j0 = true;
    boolean k0 = true;
    int l0 = -1;
    Dialog m0;
    boolean n0;
    boolean o0;
    boolean p0;

    public void S(Bundle bundle) {
        Bundle bundle2;
        super.S(bundle);
        if (this.k0) {
            View H = H();
            if (H != null) {
                if (H.getParent() == null) {
                    this.m0.setContentView(H);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            e k = k();
            if (k != null) {
                this.m0.setOwnerActivity(k);
            }
            this.m0.setCancelable(this.j0);
            this.m0.setOnCancelListener(this);
            this.m0.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.m0.onRestoreInstanceState(bundle2);
            }
        }
    }

    public void V(Context context) {
        super.V(context);
        if (!this.p0) {
            this.o0 = false;
        }
    }

    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.k0 = this.H == 0;
        if (bundle != null) {
            this.h0 = bundle.getInt("android:style", 0);
            this.i0 = bundle.getInt("android:theme", 0);
            this.j0 = bundle.getBoolean("android:cancelable", true);
            this.k0 = bundle.getBoolean("android:showsDialog", this.k0);
            this.l0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void f0() {
        super.f0();
        Dialog dialog = this.m0;
        if (dialog != null) {
            this.n0 = true;
            dialog.dismiss();
            this.m0 = null;
        }
    }

    public void g0() {
        super.g0();
        if (!this.p0 && !this.o0) {
            this.o0 = true;
        }
    }

    public LayoutInflater h0(Bundle bundle) {
        Context e2;
        if (!this.k0) {
            return super.h0(bundle);
        }
        Dialog k1 = k1(bundle);
        this.m0 = k1;
        if (k1 != null) {
            m1(k1, this.h0);
            e2 = this.m0.getContext();
        } else {
            e2 = this.B.e();
        }
        return (LayoutInflater) e2.getSystemService("layout_inflater");
    }

    /* access modifiers changed from: package-private */
    public void j1(boolean z) {
        if (!this.o0) {
            this.o0 = true;
            this.p0 = false;
            Dialog dialog = this.m0;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.n0 = true;
            if (this.l0 >= 0) {
                v().f(this.l0, 1);
                this.l0 = -1;
                return;
            }
            n a2 = v().a();
            a2.e(this);
            if (z) {
                a2.d();
            } else {
                a2.c();
            }
        }
    }

    public Dialog k1(Bundle bundle) {
        throw null;
    }

    public void l1(boolean z) {
        this.k0 = z;
    }

    public void m1(Dialog dialog, int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                dialog.getWindow().addFlags(24);
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void n1(i iVar, String str) {
        this.o0 = false;
        this.p0 = true;
        n a2 = iVar.a();
        a2.b(this, str);
        a2.c();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.n0) {
            j1(true);
        }
    }

    public void t0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.t0(bundle);
        Dialog dialog = this.m0;
        if (!(dialog == null || (onSaveInstanceState = dialog.onSaveInstanceState()) == null)) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.h0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.i0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.j0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.k0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.l0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    public void u0() {
        super.u0();
        Dialog dialog = this.m0;
        if (dialog != null) {
            this.n0 = false;
            dialog.show();
        }
    }

    public void v0() {
        super.v0();
        Dialog dialog = this.m0;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
