package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import b.c.g;
import b.d.g.a;
import c.d.a.b.b.b;
import com.google.android.gms.common.k;
import com.google.android.gms.common.n.c;
import com.google.android.gms.common.util.h;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

public final class b0 {
    @GuardedBy("sCache")

    /* renamed from: a  reason: collision with root package name */
    private static final g f2168a = new g();
    @GuardedBy("sCache")

    /* renamed from: b  reason: collision with root package name */
    private static Locale f2169b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return c.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(b.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i) {
        return context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : b.common_google_play_services_enable_button : b.common_google_play_services_update_button : b.common_google_play_services_install_button);
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        String a2 = a(context);
        if (i == 1) {
            return resources.getString(b.common_google_play_services_install_text, new Object[]{a2});
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(b.common_google_play_services_enable_text, new Object[]{a2});
            } else if (i == 5) {
                return h(context, "common_google_play_services_invalid_account_text", a2);
            } else {
                if (i == 7) {
                    return h(context, "common_google_play_services_network_error_text", a2);
                }
                if (i == 9) {
                    return resources.getString(b.common_google_play_services_unsupported_text, new Object[]{a2});
                } else if (i == 20) {
                    return h(context, "common_google_play_services_restricted_profile_text", a2);
                } else {
                    switch (i) {
                        case 16:
                            return h(context, "common_google_play_services_api_unavailable_text", a2);
                        case 17:
                            return h(context, "common_google_play_services_sign_in_failed_text", a2);
                        case 18:
                            return resources.getString(b.common_google_play_services_updating_text, new Object[]{a2});
                        default:
                            return resources.getString(k.common_google_play_services_unknown_issue, new Object[]{a2});
                    }
                }
            }
        } else if (h.d(context)) {
            return resources.getString(b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(b.common_google_play_services_update_text, new Object[]{a2});
        }
    }

    public static String e(Context context, int i) {
        return (i == 6 || i == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i);
    }

    public static String f(Context context, int i) {
        String i2 = i == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i);
        return i2 == null ? context.getResources().getString(b.common_google_play_services_notification_ticker) : i2;
    }

    public static String g(Context context, int i) {
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(b.common_google_play_services_install_title);
            case 2:
                return resources.getString(b.common_google_play_services_update_title);
            case 3:
                return resources.getString(b.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
            default:
                str = "Unexpected error code " + i;
                break;
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i = i(context, str);
        if (i == null) {
            i = resources.getString(k.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, i, new Object[]{str2});
    }

    private static String i(Context context, String str) {
        g gVar = f2168a;
        synchronized (gVar) {
            Locale c2 = a.a(context.getResources().getConfiguration()).c(0);
            if (!c2.equals(f2169b)) {
                gVar.clear();
                f2169b = c2;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources c3 = com.google.android.gms.common.h.c(context);
            if (c3 == null) {
                return null;
            }
            int identifier = c3.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", "Missing resource: " + str);
                return null;
            }
            String string = c3.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", "Got empty resource: " + str);
                return null;
            }
            gVar.put(str, string);
            return string;
        }
    }
}
