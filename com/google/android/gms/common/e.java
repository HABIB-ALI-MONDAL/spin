package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.g;
import c.d.a.b.b.a;
import c.d.a.b.b.b;
import c.d.a.b.e.b.d;
import c.d.a.b.e.b.h;
import c.d.a.b.h.i;
import c.d.a.b.h.l;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.f0;
import com.google.android.gms.common.api.internal.h0;
import com.google.android.gms.common.internal.b0;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.k;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", allowlistAnnotations = {d.class, c.d.a.b.e.b.e.class}, explanation = "Sub classing of GMS Core's APIs are restricted to GMS Core client libs and testing fakes.", link = "go/gmscore-restrictedinheritance")
public class e extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final int f2156d = f.f2160a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2157e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final e f2158f = new e();

    /* renamed from: c  reason: collision with root package name */
    private String f2159c;

    public static e n() {
        return f2158f;
    }

    public Intent b(Context context, int i, String str) {
        return super.b(context, i, str);
    }

    public PendingIntent c(Context context, int i, int i2) {
        return super.c(context, i, i2);
    }

    public final String e(int i) {
        return super.e(i);
    }

    public int g(Context context) {
        return super.g(context);
    }

    public int h(Context context, int i) {
        return super.h(context, i);
    }

    public final boolean j(int i) {
        return super.j(i);
    }

    public Dialog k(Activity activity, int i, int i2) {
        return l(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public Dialog l(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return r(activity, i, e0.b(activity, b(activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent m(Context context, b bVar) {
        return bVar.k() ? bVar.j() : c(context, bVar.g(), 0);
    }

    public i<Void> o(Activity activity) {
        int i = f2156d;
        n.d("makeGooglePlayServicesAvailable must be called from the main thread");
        int h = h(activity, i);
        if (h == 0) {
            return l.e(null);
        }
        h0 t = h0.t(activity);
        t.s(new b(h, (PendingIntent) null), 0);
        return t.u();
    }

    public boolean p(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog l = l(activity, i, i2, onCancelListener);
        if (l == null) {
            return false;
        }
        u(activity, l, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void q(Context context, int i) {
        v(context, i, (String) null, d(context, i, 0, "n"));
    }

    /* access modifiers changed from: package-private */
    public final Dialog r(Context context, int i, e0 e0Var, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(b0.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = b0.c(context, i);
        if (c2 != null) {
            builder.setPositiveButton(c2, e0Var);
        }
        String g = b0.g(context, i);
        if (g != null) {
            builder.setTitle(g);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i)}), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog s(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(b0.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        u(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    public final f0 t(Context context, com.google.android.gms.common.api.internal.e0 e0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        f0 f0Var = new f0(e0Var);
        h.k(context, f0Var, intentFilter);
        f0Var.a(context);
        if (i(context, "com.google.android.gms")) {
            return f0Var;
        }
        e0Var.a();
        f0Var.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void u(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof b.g.a.e) {
                l.o1(dialog, onCancelListener).n1(((b.g.a.e) activity).m(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(20)
    public final void v(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i), null}), new IllegalArgumentException());
        if (i == 18) {
            w(context);
        } else if (pendingIntent != null) {
            String f2 = b0.f(context, i);
            String e2 = b0.e(context, i);
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            n.i(systemService);
            NotificationManager notificationManager = (NotificationManager) systemService;
            g.e eVar = new g.e(context);
            eVar.q(true);
            eVar.f(true);
            eVar.k(f2);
            g.c cVar = new g.c();
            cVar.g(e2);
            eVar.w(cVar);
            if (com.google.android.gms.common.util.h.c(context)) {
                n.l(k.e());
                eVar.u(context.getApplicationInfo().icon);
                eVar.s(2);
                if (com.google.android.gms.common.util.h.d(context)) {
                    eVar.a(a.common_full_open_on_phone, resources.getString(b.common_open_on_phone), pendingIntent);
                } else {
                    eVar.i(pendingIntent);
                }
            } else {
                eVar.u(17301642);
                eVar.x(resources.getString(b.common_google_play_services_notification_ticker));
                eVar.A(System.currentTimeMillis());
                eVar.i(pendingIntent);
                eVar.j(e2);
            }
            if (k.h()) {
                n.l(k.h());
                synchronized (f2157e) {
                    str2 = this.f2159c;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str2);
                    String b2 = b0.b(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel(str2, b2, 4);
                    } else if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                eVar.g(str2);
            }
            Notification b3 = eVar.b();
            if (i == 1 || i == 2 || i == 3) {
                i.f2163b.set(false);
                i2 = 10436;
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, b3);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void w(Context context) {
        new o(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean x(Activity activity, com.google.android.gms.common.api.internal.g gVar, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog r = r(activity, i, e0.c(gVar, b(activity, i, "d"), 2), onCancelListener);
        if (r == null) {
            return false;
        }
        u(activity, r, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean y(Context context, b bVar, int i) {
        PendingIntent m;
        if (com.google.android.gms.common.n.a.a(context) || (m = m(context, bVar)) == null) {
            return false;
        }
        v(context, bVar.g(), (String) null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, m, i, true), c.d.a.b.e.b.i.f1561a | 134217728));
        return true;
    }
}
