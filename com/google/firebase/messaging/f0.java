package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.g;
import java.util.concurrent.atomic.AtomicInteger;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f2933a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final g.e f2934a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2935b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2936c;

        a(g.e eVar, String str, int i) {
            this.f2934a = eVar;
            this.f2935b = str;
            this.f2936c = i;
        }
    }

    private static PendingIntent a(Context context, q0 q0Var, String str, PackageManager packageManager) {
        Intent f2 = f(str, q0Var, packageManager);
        if (f2 == null) {
            return null;
        }
        f2.addFlags(67108864);
        f2.putExtras(q0Var.y());
        if (q(q0Var)) {
            f2.putExtra("gcm.n.analytics_data", q0Var.x());
        }
        return PendingIntent.getActivity(context, g(), f2, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, q0 q0Var) {
        if (!q(q0Var)) {
            return null;
        }
        return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(q0Var.x()));
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context2, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static a d(Context context, Context context2, q0 q0Var, String str, Bundle bundle) {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        g.e eVar = new g.e(context2, str);
        String n = q0Var.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(n)) {
            eVar.k(n);
        }
        String n2 = q0Var.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(n2)) {
            eVar.j(n2);
            g.c cVar = new g.c();
            cVar.g(n2);
            eVar.w(cVar);
        }
        eVar.u(m(packageManager, resources, packageName, q0Var.p("gcm.n.icon"), bundle));
        Uri n3 = n(packageName, q0Var, resources);
        if (n3 != null) {
            eVar.v(n3);
        }
        eVar.i(a(context, q0Var, packageName, packageManager));
        PendingIntent b2 = b(context, context2, q0Var);
        if (b2 != null) {
            eVar.m(b2);
        }
        Integer h = h(context2, q0Var.p("gcm.n.color"), bundle);
        if (h != null) {
            eVar.h(h.intValue());
        }
        eVar.f(!q0Var.a("gcm.n.sticky"));
        eVar.q(q0Var.a("gcm.n.local_only"));
        String p = q0Var.p("gcm.n.ticker");
        if (p != null) {
            eVar.x(p);
        }
        Integer m = q0Var.m();
        if (m != null) {
            eVar.s(m.intValue());
        }
        Integer r = q0Var.r();
        if (r != null) {
            eVar.z(r.intValue());
        }
        Integer l = q0Var.l();
        if (l != null) {
            eVar.r(l.intValue());
        }
        Long j = q0Var.j("gcm.n.event_time");
        if (j != null) {
            eVar.t(true);
            eVar.A(j.longValue());
        }
        long[] q = q0Var.q();
        if (q != null) {
            eVar.y(q);
        }
        int[] e2 = q0Var.e();
        if (e2 != null) {
            eVar.p(e2[0], e2[1], e2[2]);
        }
        eVar.l(i(q0Var));
        return new a(eVar, o(q0Var), 0);
    }

    static a e(Context context, q0 q0Var) {
        Bundle j = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, q0Var, k(context, q0Var.k(), j), j);
    }

    private static Intent f(String str, q0 q0Var, PackageManager packageManager) {
        String p = q0Var.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p)) {
            Intent intent = new Intent(p);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f2 = q0Var.f();
        if (f2 != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(f2);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return f2933a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(androidx.core.content.a.d(context, i));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    private static int i(q0 q0Var) {
        int i = q0Var.a("gcm.n.default_sound") ? 1 : 0;
        if (q0Var.a("gcm.n.default_vibrate_timings")) {
            i |= 2;
        }
        return q0Var.a("gcm.n.default_light_settings") ? i | 4 : i;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e2);
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    public static String k(Context context, String str, Bundle bundle) {
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w("FirebaseMessaging", str2);
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    str3 = "Misc";
                } else {
                    str3 = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", str3, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i) {
        return Build.VERSION.SDK_INT >= 23 ? i | 67108864 : i;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !p(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e2);
            }
        }
        if (i == 0 || !p(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static Uri n(String str, q0 q0Var, Resources resources) {
        String o = q0Var.o();
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        if ("default".equals(o) || resources.getIdentifier(o, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + o);
    }

    private static String o(q0 q0Var) {
        String p = q0Var.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    @TargetApi(26)
    private static boolean p(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(q0 q0Var) {
        return q0Var.a("google.c.a.e");
    }
}
