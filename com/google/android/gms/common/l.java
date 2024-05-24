package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import b.g.a.c;
import b.g.a.i;
import com.google.android.gms.common.internal.n;

public class l extends c {
    private Dialog q0;
    private DialogInterface.OnCancelListener r0;
    private Dialog s0;

    public static l o1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        l lVar = new l();
        n.j(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        lVar.q0 = dialog2;
        if (onCancelListener != null) {
            lVar.r0 = onCancelListener;
        }
        return lVar;
    }

    public Dialog k1(Bundle bundle) {
        Dialog dialog = this.q0;
        if (dialog != null) {
            return dialog;
        }
        l1(false);
        if (this.s0 == null) {
            Context q = q();
            n.i(q);
            this.s0 = new AlertDialog.Builder(q).create();
        }
        return this.s0;
    }

    public void n1(i iVar, String str) {
        super.n1(iVar, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.r0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
