package com.google.firebase.messaging;

import android.os.Bundle;
import java.util.concurrent.TimeUnit;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final long f2939a = TimeUnit.MINUTES.toMillis(3);

    public static final class a {
        public static b.c.a<String, String> a(Bundle bundle) {
            b.c.a<String, String> aVar = new b.c.a<>();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            return aVar;
        }
    }
}
