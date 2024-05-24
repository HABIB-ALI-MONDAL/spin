package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;

public final class l7 {
    public static String a(String str, String[] strArr, String[] strArr2) {
        n.i(strArr);
        n.i(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            String str2 = strArr[i];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static String b(Context context, String str, String str2) {
        n.i(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = q4.a(context);
        }
        return q4.b("google_app_id", resources, str2);
    }
}
