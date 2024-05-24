package com.google.firebase.q;

import kotlin.KotlinVersion;

public final class f {
    public static String a() {
        try {
            return KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
